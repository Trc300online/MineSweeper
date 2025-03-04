
public class Tile {

    public boolean isRevealed;
    public boolean isBomb;
    public boolean isFlagged;
    public int bombAround;

    public Tile(){
        Tile tile = new Tile();
    }

    public void Tiles(boolean isRevealed, boolean isBomb, boolean isFlagged, int bombAround) {
        this.bombAround = bombAround;
        this.isBomb = isBomb;
        this.isFlagged = isFlagged;
        this.isRevealed = isRevealed;
    }

}
