// Represents an empty tile without a mine but with a number of nearby mines
class EmptyTile extends Tile {
    private int nearbyMines;  // Number of mines nearby this tile

    // Constructor initializes the tile with the number of nearby mines
    public EmptyTile(int nearbyMines) {
        super(false);  // An empty tile has isMine set to false
        this.nearbyMines = nearbyMines;
    }

    // Implement the reveal method for EmptyTile
    @Override
    public void reveal() {
        isRevealed = true;  // Mark the tile as revealed
        System.out.println("Revealed: " + nearbyMines + " nearby mines");
    }

    // Getter for nearby mines
    public int getNearbyMines() {
        return nearbyMines;
    }
}
