import javax.swing.*;

// Main application class that starts the Minesweeper game
public class MainApp {
    public static void main(String[] args) {
        // Create a new JFrame to hold the Minesweeper game
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the window when the user exits
        frame.setSize(600, 600);  // Set the size of the window

        // Create the grid panel with 10 rows, 10 columns, and 20 mines
        GridPanel grid = new GridPanel(10, 10, 20);  
        frame.add(grid);  // Add the grid panel to the frame

        frame.setVisible(true);  // Make the frame visible
    }
}
