import HW2;
      
boards =  ["----x---x","---o-o---","x--------","-x-------","----x----","-o--x----"]
expected = ["7 win","7 win","0 tie","0 tie","-3 lose","3 win"]
move =  ["x in 0","o in 4","o in 1","o in 3","o in 1","o in 7"]

for x in range(len(boards)):
    print("******************************************")
    print("testing "+boards[x])
    print("expecting "+expected[x])
    print("with "+move[x])
        
    print()
    print("They Say")
    result = HW2.search(boards[x])
    print("******************************************")

input()
