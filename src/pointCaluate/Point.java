package pointCaluate;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int compareTo(Point p) {

        int distanceRow = this.getX() - p.getX();

        int distanceColumn = this.getY() - p.getY();

        return Math.abs(distanceColumn) + Math.abs(distanceRow);
    }
}
