
public class Tile {

    public boolean isRevealed;
    public boolean isBomb;
    public boolean isFlagged;
    public int bombAround;

    public Tile(){
    }

    public void Tiles(boolean isRevealed, boolean isBomb, boolean isFlagged, int bombAround) {
        this.bombAround = bombAround;
        this.isBomb = isBomb;
        this.isFlagged = isFlagged;
        this.isRevealed = false;
    }

    public void setBomb(){
        isBomb = true;
    }

    public int totalBombsAround(){
        return bombAround;
    }

    public void toggleFlag() {
        this.isFlagged = !isFlagged;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    @Override
    public String toString() {
        if (isFlagged) {
            return " P";
        }else if (!isRevealed) {
            return " #";
        } else if (isBomb) {
            return " X";
        }
        return " " + totalBombsAround();
    }
}
