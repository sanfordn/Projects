#!/usr/bin/env python

"""
An echo server that uses select to handle multiple clients at a time.
Entering any line of input at the terminal will exit the server.
ports 65280--65289
"""

import select
import socket
import sys

host = ''
port = int(sys.argv[1])
backlog = 5
size = 1024
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((host,port))
server.listen(5)
inputList = [server]
running = 1
username = ""
guess = ""
connecting = False

while running:
    inputready,outputready,exceptready = select.select(inputList,[],[],1)

    for s in inputready:

	#Someone tried to connect to the server for the first time.
	#Let's accept.
        if s == server:
            # handle the server socket
            client, address = server.accept()
            inputList.append(client)
	#This is a client sending messages!    
        elif s in inputList:
            # handle all other sockets

    # try to read
            data = s.recv(size)
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
                else:
                    print("error in data recieved\n")
                if connecting:
                    #first time user has connected
                    print(username," connected.")
                else:
                    #user is in guessing mode
                    print(username," is already connected and has a guess of: ", guess)
            else:
                s.close()
                print("Removing client: ", username)
                inputList.remove(s)
                break

server.close()
