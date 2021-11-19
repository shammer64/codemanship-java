package video4_5;

import java.util.*;

public class Rover {
    public static final int FORWARD_GEAR = 1;
    public static final int REVERSE_GEAR = -1;
    public static final int CLOCKWISE = 1;
    public static final int COUNTERCLOCKWISE = 3;
    private static final String[] COMPASS_DIRECTIONS = new String[]{"N", "E", "S", "W"};
    private Position position;
    private Map<Character, Runnable> commandMap = new HashMap<>();

    public Rover(String initialDirection, int xPos, int yPos) {
        super();
        this.position = new Position(initialDirection, xPos, yPos);
        initCommandMap();
    }

    private void initCommandMap() {
        commandMap.put('R', this::turnRight);
        commandMap.put('L', this::turnLeft);
        commandMap.put('F', this::moveForward);
        commandMap.put('B', this::moveBackward);
    }

    public Position send(String instructions) {
        instructions.chars().forEach(instruction -> commandMap.get((char)instruction).run());
        return position;
    }

    private void moveBackward() {
        move(REVERSE_GEAR);
    }

    private void moveForward() {
        move(FORWARD_GEAR);
    }

    private void move(int gear) {
        switch (position.getDirection()) {
            case "N":
                position = new Position(position.getDirection(), position.getXPos(), position.getYPos() + gear);
                break;
            case "E":
                position = new Position(position.getDirection(), position.getXPos() + gear, position.getYPos());
                break;
            case "S":
                position = new Position(position.getDirection(), position.getXPos(), position.getYPos() - gear);
                break;
            case "W":
                position = new Position(position.getDirection(), position.getXPos() - gear, position.getYPos());
                break;
        }
    }

    private void turnRight() {
        turn(CLOCKWISE);
    }

    private void turnLeft() {
        turn(COUNTERCLOCKWISE);
    }

    private void turn(int turnDirection) {
        int index = Arrays.asList(COMPASS_DIRECTIONS).indexOf(position.getDirection());
        String newDirection = COMPASS_DIRECTIONS[(index + turnDirection) % 4];
        position = new Position(newDirection, position.getXPos(), position.getYPos());
    }
}
