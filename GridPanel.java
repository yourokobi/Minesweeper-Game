import javax.swing.*;
import java.awt.*;
import java.util.Random;

// This class represents the container that holds the grid of tiles
class GridPanel extends JPanel {
    private TileButton[][] buttons;  // 2D array to store the buttons representing the tiles

    // Constructor initializes the grid with a given size and number of mines
    public GridPanel(int rows, int cols, int mines) {
        setLayout(new GridLayout(rows, cols));  // Set the layout of the panel to a grid
        buttons = new TileButton[rows][cols];  // Initialize the 2D array for buttons
        generateGrid(rows, cols, mines);  // Generate the grid of tiles
    }

    // Method to generate the grid of tiles and place mines randomly
    private void generateGrid(int rows, int cols, int mines) {
        Tile[][] tiles = new Tile[rows][cols];  // Create a 2D array of Tile objects
        Random random = new Random();  // Random generator for placing mines

        // Place mines randomly in the grid
        int placedMines = 0;
        while (placedMines < mines) {
            int r = random.nextInt(rows);  // Random row
            int c = random.nextInt(cols);  // Random column
            if (tiles[r][c] == null) {  // If the tile hasn't been placed yet
                tiles[r][c] = new MineTile();  // Place a mine
                placedMines++;
            }
        }

        // Fill remaining tiles with empty tiles, calculating the number of nearby mines
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (tiles[r][c] == null) {  // If no mine has been placed here
                    int nearbyMines = countMines(tiles, r, c, rows, cols);  // Count nearby mines
                    tiles[r][c] = new EmptyTile(nearbyMines);  // Place an empty tile
                }
                TileButton button = new TileButton(tiles[r][c]);  // Create a button for the tile
                buttons[r][c] = button;  // Store the button in the array
                add(button);  // Add the button to the panel
            }
        }
    }

    // Method to count the number of mines surrounding a specific tile
    private int countMines(Tile[][] tiles, int row, int col, int rows, int cols) {
        int count = 0;  // Counter for nearby mines
        // Check surrounding tiles
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int r = row + i, c = col + j;  // Calculate neighboring coordinates
                if (r >= 0 && r < rows && c >= 0 && c < cols && tiles[r][c] instanceof MineTile) {
                    count++;  // Increment count if there's a mine nearby
                }
            }
        }
        return count;  // Return the count of nearby mines
    }
}
