#### Let's run interactive java program with nodejs.


Java program will receive input througth `Scanner` and output back with `System.out.print`. Nodejs will run this program with `spawn`.

Nodejs will send all buffer data throguth web socket connection so that user can play a game called `TicTacToe`.

### To run on your computer

```
npm i
javac TicTacToe.java
```

`javac` will produced bytecode file which can run with `java`.

Then

```
node wsserver.js
```

Then launch localhost:6969