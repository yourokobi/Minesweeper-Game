// Base class for both MineTile and EmptyTile
abstract class Tile {
    protected boolean isMine;   // True if the tile contains a mine, false otherwise
    protected boolean isRevealed;  // True if the tile is revealed, false otherwise
    protected boolean isFlagged;   // True if the tile is flagged, false otherwise

    // Constructor for initializing a tile as a mine or not
    public Tile(boolean isMine) {
        this.isMine = isMine;
        this.isRevealed = false;
        this.isFlagged = false;
    }

    // Abstract method to reveal the tile (must be implemented in subclasses)
    public abstract void reveal();
}
