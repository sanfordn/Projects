INFINITY = 1000
def search(startState):
    score,move = MiniMax(startState,None,True)
    pos, piece = move
    print("You will get a score of " + str(score) + " if you put a " + piece + "in the position " + pos)

def MiniMax(s, e, isMax):
    s1 = updateState(s, e)
    if isWin(s1):
        return (score(s1, isMax), "Done")
    if isTie(s1):
        return (0, "Done")
    if isMax:
        highest = -100
        for e1 in getMoves(s1):
            tmpScore, tmpMove = MiniMax(s1, e1, not(isMax))
            if tmpScore > highest:
                highest = tmpScore
                move = e1
                print("move is " + str(move))
        return (highest,move)
    else:
        lowest = 100
        for e1 in getMoves(s1):
            tmpScore, tmpMove = MiniMax(s1, e1, not(isMax))
            if tmpScore < lowest:
                lowest = tmpScore
                move = e1
                print("move is " + str(move))
        return (lowest,move)

def getMoves(state):
    moves = []
    for i in range(9):
        if state[i] == '-':
            moves.append((i,'x'))
            moves.append((i,'o'))
    return moves

def updateState(s, e):
    if e == None:
        return s
    pos,piece = e
    return s[:pos] + piece + s[pos:]

def isWin(state):
    #row
    for i in range(0,9,3):
        if state[i] == 'x' and state[i] == state[i+1] and state[i] == state[i+2]:
            return True
        elif state[i] == 'o' and state[i] == state[i+1] and state[i] == state[i+2]:
            return True
        else:
            return False
    #col
    for i in range(0,3):
        if state[i] == 'x' and state[i] == state[i+3] and state[i] == state[i+6]:
            return True
        elif state[i] == 'o' and state[i] == state[i+3] and state[i] == state[i+6]:
            return True

    #diagonal tL to lR
    if state[0] == 'x' and state[0] == state[4] and state[0] == state[8]:
        return True
    elif state[0] == 'o' and state[0] == state[4] and state[0] == state[8]:
        return True
    else:
        return False

    #diagonal tR to lL
    if state[2] == 'x' and state[2] == state[4] and state[2] == state[6]:
        return True
    elif state[2] == 'o' and state[2] == state[4] and state[2] == state[6]:
        return True
    else:
        return False

def isTie(state):
    for item in state:
        if item == '-':
            return False
    return True

def score(state, isMax):
    dashes = 0
    for i in range(9):
        if state[i] == '-':
            dashes += 1
    dashes += 1
    if isMax:
        return dashes
    else:
        return -1 * dashes
