package ru.sbt.refactoring.tractor;

import java.awt.*;

public class Tractor {
    private Point position;
    private final Point field;
    private Orientation orientation;

    public Tractor() {
        position = new Point(0, 0);
        field = new Point(5, 5);
        orientation = Orientation.NORTH;
    }

    public Tractor(Point position, Point field, Orientation orientation) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
    }

    public void move(Command command) {
        command.execute(this);
    }

    public void moveForwards() {
        position = orientation.moveForwards(position);
        if (isOutOfBounds()) {
            throw new TractorInDitchException();
        }
    }

    private boolean isOutOfBounds() {
        return position.x > field.x || position.y > field.y;
    }

    public void turnClockwise() {
        orientation = orientation.turnClockwise();
    }

    public int getPositionX() {
        return position.x;
    }

    public int getPositionY() {
        return position.y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}