public class Domino {
    private int top;
    private int bottom;

    public Domino() {
        top = 0;
        bottom = 0;
    }
    public Domino(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }
    public int getTop() {
        return top;
    }
    public int getBottom() {
        return bottom;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
    public String toString() {
        return "" + top + "/" + bottom;
    }
    public void flip() {
        int temp = top;
        top = bottom;
        bottom = temp;
    }
    public void settle() {
        while (top > bottom) {
            flip();
        }
    }
    public int compareTo(Domino domino) {
        settle();
        domino.settle();
        if (top < domino.getTop()) return -1;
        else if (top > domino.getTop()) return 1;
        else {
            if (bottom < domino.getBottom()) return -1;
            else if (bottom > domino.getBottom()) return 1;
            else return 0;
        }
    }
    public int compareToWeight(Domino other) {
        int combined = top + bottom;
        int otherCombined = other.getTop() + other.getBottom();
        if (combined < otherCombined) return -1;
        else if (combined > otherCombined) return 1;
        else return 0;
    }
    public boolean canConnect(Domino other) {
        if (top == other.getTop() || top == other.getBottom()
                || bottom == other.getTop() || bottom == other.getBottom())  return true;
        return false;
    }

}
