## What does UDP Require?

UDP server:
- Creates a UDP socket and binds it to an address (port and host)
- Listen for connections/messages
- Accept a connection
- Send/receive data

Client:
- Create socket
- Connect to address of server  
- Sent/receive data 

Socket:
Required by both client and server
Must have 
- address domain
- socket type

Address domain:
- Unix domain - file system communication
  Format: string which represents entry in file system
- Internet domain
  Format: IP address

 
### Feature: UDP Server

**Scenario: Server is started**
When the server is started  
Then it will create a socket
And it will bind the socket to an address (host and port)
And it will stay alive until manually stopped  

**Scenario: Server is stopped**
Given the server is running 
When the server is killed   
Then the socket is closed   
And the port is freed      

**Scenario: Server is running, message received**
Given the server is running     
When a message is received  
Then it reads[1024](https://help.papertrailapp.com/kb/configuration/troubleshooting-remote-syslog-reachability#message-length)bytes from it 

**Scenario: Server is running, message received and processed**
Given the server is running 
When a message is received  
Then raw frames are requested from the ethernet driver  
And IPv4 packets are extracted  

**Scenario: Server is running, message received and returned**
Given the server is running     
When a message is received  
Then the messaged is uppercased and returned to the user   
 

Questions:
What is the maximum number of requests that the server can handle at once?
What does a client receive when the server is busy and cannot respond?
What is hole-punching? (principal known as UDP hole punching to get past NATs)


# Build: UDP chat app!
 
Useful resources:
https://www.slideshare.net/lineking/udp-33422210
https://medium.com/geckoboard-under-the-hood/how-to-build-a-network-stack-in-ruby-f73aeb1b661b
https://github.com/geckoboard/RUDP/blob/master/server.rb
 
https://github.com/joshuaar/UDPChat- UDP chat client
https://github.com/ratanak1010/Java-UDP-Chat ***
http://gtubeit6.blogspot.co.uk/2017/01/advance-java-practical-1.html
https://www.daniweb.com/programming/software-development/threads/392710/basic-udp-chat-system
https://www.cs.rutgers.edu/~pxk/417/notes/sockets/udp.html

TCP:
http://makemobiapps.blogspot.co.uk/p/multiple-client-server-chat-programming.html

Bitta knowledge:
https://help.papertrailapp.com/kb/configuration/troubleshooting-remote-syslog-reachability#message-length

## What is UDP


