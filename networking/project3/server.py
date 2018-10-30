#/usr/bin/env python

"""
An echo server that uses select to handle multiple clients at a time.
Entering any line of input at the terminal will exit the server.
ports 65280--65289
"""

import select
import socket
import sys
import time

host = ''
port = int(sys.argv[1])
backlog = 5
size = 1024
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host,port))
server.listen(5)
inputList = [server]
users = {}
running = 1
username = ""
guess = ""
connecting = False
timeThreshold = 10.0
gameStartSent = False

initTime= time.time()
print(initTime)

def sendToAll(users, message):
    for client in users.keys():
        print(message)
        print(client)
        client.sendall(bytes(message,'ascii'))
#stage1 - "Waiting for clients to connect..."; if full send "full"; 
#stage2 - create boggle board & send to client


while running:
    inputready,outputready,exceptready = select.select(inputList,[],[],1)

    for s in inputready:

	#Someone tried to connect to the server for the first time.
	#Let's accept.
        currTime = time.time() - initTime
        if s == server and currTime < timeThreshold and len(inputList) <= 4:
            # handle the server socket
            print("stage1")
            client, address = server.accept()
            inputList.append(client)
            data = client.recv(size)
            if data:
                dataPrint = data.decode().strip()
                splitData = dataPrint.split('|')
                if len(splitData) == 3:
                    username = splitData[0]
                    connectingStr = splitData[1]
                    if connectingStr == 't' or connectingStr == 'T':
                        connecting = True
                    elif connectingStr == 'f' or connectingStr == 'F':
                        connecting = False
                    else:
                        print("error in getting connection boolean")
                    guess = splitData[2]
                    if connecting:
                        #first time user has connected
                        print(username," connected.")
                        reply = "Hello, " + username + ". You are connected.\n"
                        client.sendall(bytes(reply,'ascii'))
                        users[client] = username
                    else:
                        print(username," is already connected.")
        elif currTime >= (timeThreshold-3.0) and len(users) >=2 and (not gameStartSent):
            message = "the game is about to start...\n"
            print("sending a message to users")
            sendToAll(users, message)
            gameStartSent = True
	#This is a client sending messages!
        elif s in inputList and len(inputList)>1 and currTime >= timeThreshold:
            print("in stage 2")
            # handle all other sockets
            data = s.recv(size)
            username = users[s]
            if data:
                print(data.decode().strip())

                # try to read
            else:
                s.close()
                print(username, " disconnected.")
                inputList.remove(s)
                users.pop(s)
                break

       # elif notEnoughPlayers:
        #    sendToAll("There are not enough players to start the game. Ending game...", users)
         #   print("quitting game. Not enough players joined.")
          #  exit(1)
server.close()
