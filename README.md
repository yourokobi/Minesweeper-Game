MINESWEEPER GAME
A Java implementation of the classic Minesweeper game

DESCRIPTION
This is a simple implementation of the classic Minesweeper game using Java and Swing GUI components. The game features the traditional gameplay where players must uncover tiles while avoiding hidden mines. Each number revealed indicates how many mines are adjacent to that tile.

HOW TO PLAY
1. Left-click on a tile to reveal it
2. Right-click on a tile to place or remove a flag (marking a suspected mine)
3. Uncover all non-mine tiles to win the game
4. If you click on a mine, the game is over!

HOW TO RUN THE GAME
1. Make sure you have Java installed on your system
2. Compile all the Java files: `javac *.java`
3. Run the main application: `java MainApp`

PROJECT STRUCTURE
- MainApp.java: Entry point for the application
- GridPanel.java: Manages the grid of tiles
- TileButton.java: Button implementation for each tile
- Tile.java: Abstract base class for tiles
- MineTile.java: Implementation for tiles containing mines
- EmptyTile.java: Implementation for tiles without mines
- Clickable.java: Interface for click interactions

DEFAULT SETTINGS
- Grid Size: 10x10
- Number of Mines: 20

FUTURE IMPROVEMENTS
- Add a game status display
- Implement difficulty levels
- Add a timer and scoring system
- Create a game reset option
- Add sound effects

CREDITS
Developed by Zeti Wiyada, as a demonstration of object-oriented programming principles in Java.

LICENSE
This project is available for educational purposes. Feel free to modify and expand it as needed.
