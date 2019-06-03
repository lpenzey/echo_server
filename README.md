# echo-server

### Java Echo Server
A client/server program where the server returns (echos) client input. 

### Requirements
- Software: [Java 11.0.2](https://docs.oracle.com/en/java/javase/12/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)


### Getting Started
Clone this repo to your local machine: https://github.com/lpenzey/echo_server.git

### Usage
1. Start the server: In one terminal window, cd into the project directory:
```
$ cd echo_server
```
Then cd into the src folder:
```
$ cd src
```
Then run the following command to compile and run the echo server
```
javac main/java/server/EchoServer.java && java main/java/server/EchoServer
```
2. Connect to server: In a new terminal window, cd into the project directory:
```
$ cd echo_server
```
Then cd into the src folder:
```
$ cd src
```
Then run the following command to compile and run the echo client
```
$ javac main/java/client/EchoClient.java && java main/java/client/EchoClient localhost
```
3. Type your request in the client terminal window and receive the request back from the server.
