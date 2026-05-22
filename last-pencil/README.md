## Pencil Game

This project is an implementation of an educational project from Hyperskill.org.  This is the pencil game, where the user plays against the bot. In the game, players take turns to remove 1, 2, or 3 pencils from a pile. The player who takes the last pencil loses.


The bot is implemented with a winning strategy for specific numbers of pencils left on the table. If the bot is not in a winning position, it follows a random pattern.

### How to Play

1. Choose the number of pencils to use in the game.
2. Select who will play first: the user (John) or the bot (Jack).
3. If it's the bot's turn, the program will print the bot's move.
4. If it's the user's turn, input the number of pencils to take (1, 2, or 3).
5. The game continues until all pencils are taken, and the player who takes the last pencil loses.

See example games below:

#### Example 1

```plaintext
How many pencils would you like to use:
> 10
Who will be the first (John, Jack):
> Jack
||||||||||
Jack's turn:
1
|||||||||
John's turn!
> 2
|||||||
Jack's turn:
2
|||||
John's turn!
> 1
||||
Jack's turn:
3
|
John's turn!
> 1
Jack won!
```

#### Example 2

```plaintext
How many pencils would you like to use:
> 6
Who will be the first (John, Jack):
> John
||||||
John's turn!
> 1
|||||
Jack's turn:
2
|||
John's turn!
> 2
|
Jack's turn:
1
John won!
```
