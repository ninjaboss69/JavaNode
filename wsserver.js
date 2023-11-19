import {WebSocketServer} from "ws";
import http from "http";
import fs from "fs";
import { spawn } from 'child_process';
import ReadLine from "readline";


let gloablOutput = "";

const server = http.createServer((req,res)=>{

    fs.readFile('index.html','utf-8',(err,data)=>{
        if(err){
            res.writeHead(500,{'Content-Type':'text/plain'});
            res.end('Internal Server Error');
            return;
        }
        res.writeHead(200,{'Content-Type':'text/html'});
        res.end(data);
    })

});


const wss = new WebSocketServer({server});


wss.on('connection',async (ws)=>{
    
    console.log("Client Connected");

    let javaProcess =  spawn('java',['TicTacToe']);
    
    ws.send("started java program successfully :: not guarantee");

    const rl =ReadLine.createInterface({input:javaProcess.stdout});
    
    rl.on('line',(line)=>{
       gloablOutput+=(line+" \n");
        ws.send(line); 
      });

    
    ws.on('message',(message)=>{
    
if(javaProcess) javaProcess.stdin.write(message+"\n");
        
    })

    ws.on('close', () => {
        console.log('Client disconnected');
        gloablOutput="";
        if (javaProcess) {
            console.log("killing program");
            javaProcess.kill('SIGTERM');
            javaProcess = null; 
        }
    });

   
})

server.listen(6969, () => {
    console.log('Server listening on http://localhost:6969');
  });