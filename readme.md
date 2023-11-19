#### Let's run interactive java program with nodejs.


Java program will receive input througth `Scanner` and output back with `System.out.print`. Nodejs will run this program with `spawn`.

Nodejs will listens all buffer data and changed to normal string and send them throguth web socket connection so that user can play a game called `TicTacToe`.

### To run on your computer

```
npm i

```

Compiled the program with `javac`


```
javac TicTacToe.java
```

`javac` will produced bytecode file which can run with `java`.

Then

```
node wsserver.js
```

Then launch localhost:6969

#### About Java Program

This is some java code I wrote in 2019. It played TicTacToe with the current user. The user can play with his favorite character. If the user enter inappropriate string, the program will not give a chance to user and play itself util the game end.
The code is kinda messy and verbose.