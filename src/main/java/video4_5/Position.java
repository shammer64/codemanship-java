package video4_5;

public class Position {
    private final String direction;
    private final int xPos;
    private final int yPos;

    public Position(String direction, int xPos, int yPos) {
        this.direction = direction;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public String getDirection() {
        return direction;
    }

    public int getXPos() {
        return xPos;
    }

    public int getYPos() {
        return yPos;
    }
}
