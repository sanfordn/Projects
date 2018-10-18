INFINITY = 1000

def search(startState):
    score,move = MiniMax(startState,None,True)
    pos,piece = move

def MiniMax(s, e, isMax):
    s1 = updateState(s, e)
    if isLeaf(s1):
        return (score(s1, isMax), "Complete")
    if isMax:
        highest = -INFINITY
        for e1 in getMoves(s1):
            tmpScore, tmpMove = MiniMax(s1, e1, not(isMax))
            if tmpScore > highest:
                highest = tmpScore
                move = e1
        return highest,move
    else:
        lowest = INFINITY
        for e1 in getMoves(s1):
            tmpScore, tmpMove = MiniMax(s1, e1, not(isMax))
            if tmpScore < lowest:
                lowest = tmpScore
                move = e1
        return lowest, move

def getMoves(state):
    moves = []
    #stateList = list(state)
    for i in range(len(stateList)):
        if stateList[i] == '-':
            moves.append(state[:i] + 'x' + state[i:])
            moves.append(state[:i] + 'o' + state[i:])
    return moves

def updateState(s, e):
    if e == None:
        return s
    pos,piece = e
    return s[:pos] + peice + s[pos:]
def isLeaf(state):
    if isWin(state):
        return True
    elif isTie(state):
        return True
    else:
        return False

def isWin(state):
    for i in range(0,9,3):
        if state[i] == 'x' and state[i] == state[i+1] and state[i] == state[i+2]:
            return True
        elif state[i] == 'o' and state[i] == state[i+1] and state[i] == state[i+2]:
            return True
        else:
            return False
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
    if '-' in state:
        return False
    elif '-' not in state
        return True
    else:
        return "error"

def score(state):
