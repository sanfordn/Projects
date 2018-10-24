male(james1).
male(charles1).
female(catherine).
male(charles2).
male(james2).
female(elizabeth).
female(sophia).
male(george1).
parentOf(james1,charles1).
parentOf(james1,elizabeth).
parentOf(charles1,catherine).
parentOf(charles1,charles2).
parentOf(charles1,james2).
parentOf(elizabeth,sophia).
parentOf(sophia,george1).

/* sisterOf
brotherOf
auntOf
uncleOf
grandparentOf
cousinOf*/

motherOf(M,X) :-
      parentOf(M,X),
      female(M).
fatherOf(F,X) :-
      parentOf(F,X),
      male(F).
siblingOf(X,Y) :-
      parentOf(Z,X),
      parentOf(Z,Y),
      X\==Y.
sisterOf(X,Y) :-
      siblingOf(X,Y),
      female(X).
brotherOf(X,Y) :-
      siblingOf(X,Y),
      male(X).
auntOf(X,Y) :-
      sisterOf(X,Z),
      parentOf(Z,Y).
uncleOf(X,Y) :-
      brotherOf(X,Z),
      parentOf(Z,Y).
grandparentOf(X,Y) :-
      parentOf(X,Z),
      parentOf(Z,Y).
cousinOf(X,Y) :-
      parentOf(Z,X),
      siblingOf(Z,W),
      parentOf(W,Y).
