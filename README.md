# Lazy Chess
I was playing chess with friends, and started to wonder how well I could do if I just randomly chose a move. So I created this!


## How to Use

You can edit **board.txt** in the files folder to set up what your game looks like by using different letters for pieces and spaces for empty spots.

The file **starting_game.txt** has a brand new game already set up for you, the contents of which you can copy into **board.txt** to use.

If a letter is uppercase, it's your piece! If it's lowercase, it's your opponent's.

These are the letters that represent each piece

- B => Bishop
- K => King
- N => Knight
- P => Pawn
- Q => Queen
- R => Rook

Once you've set up your board in **board.txt**, run the program! It will print out the board to the console for you and give you a suggested move.

## How it Works

Choosing any old possible move at random probably isn't going to let you last very long. But I want games to still be playable, so I decided to let it choose randomly from a subset of all possible moves instead. What is that subset?

For each possible move, it looks at how many of your pieces would be left open to be captured by your opponent. It looks to see which moves would result in the fewest of your pieces being open to capture, and then chooses randomly from those moves.

It doesn't do anything fancy like look ahead at future moves or try to consider what your opponent might do. The only thing it cares about is how many of your pieces will be open to capture if you make a particular move.

So the strategy is basically: Don't Die!