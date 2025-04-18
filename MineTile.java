// Represents a tile that contains a mine
class MineTile extends Tile {
    // Constructor initializes this tile as a mine
    public MineTile() {
        super(true);  // A mine tile is initialized with isMine = true
    }

    // Implement the reveal method for MineTile
    @Override
    public void reveal() {
        isRevealed = true;  // Mark the tile as revealed
        System.out.println("Mine revealed! BOOM!");
    }
}
