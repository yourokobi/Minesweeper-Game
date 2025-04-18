import javax.swing.*;
import java.awt.event.*;

// TileButton represents the button for each tile in the Minesweeper game
class TileButton extends JButton implements Clickable {
    private Tile tile;  // The tile this button represents (can be a MineTile or EmptyTile)

    // Constructor initializes the button with a tile and adds mouse listener
    public TileButton(Tile tile) {
        this.tile = tile;  // Assign the tile to this button
        addMouseListener(new MouseAdapter() {  // Add a mouse listener for clicks
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle left-click (reveal the tile)
                if (SwingUtilities.isLeftMouseButton(e)) {
                    onLeftClick();
                }
                // Handle right-click (flag/unflag the tile)
                else if (SwingUtilities.isRightMouseButton(e)) {
                    onRightClick();
                }
            }
        });
    }

    // Left-click behavior: reveals the tile and updates the button text
    @Override
    public void onLeftClick() {
        if (!tile.isRevealed && !tile.isFlagged) {  // If the tile is not revealed or flagged
            tile.reveal();  // Reveal the tile

            // Update the button's text based on the tile type
            if (tile instanceof EmptyTile) {
                setText(String.valueOf(((EmptyTile) tile).getNearbyMines()));  // Show nearby mines count for empty tiles
            } else if (tile instanceof MineTile) {
                setText("💣");  // Show mine symbol for mine tiles
            }
            setEnabled(false);  // Disable the button after it is clicked (can't be clicked again)
        }
    }

    // Right-click behavior: flags/unflags the tile
    @Override
    public void onRightClick() {
        if (!tile.isRevealed) {  // If the tile is not revealed
            tile.isFlagged = !tile.isFlagged;  // Toggle the flag status
            // Show the flag symbol or remove it based on the flag status
            setText(tile.isFlagged ? "🚩" : "");
        }
    }
}
