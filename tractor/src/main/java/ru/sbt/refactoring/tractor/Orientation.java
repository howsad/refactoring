package ru.sbt.refactoring.tractor;

import java.awt.*;

public enum Orientation {
    NORTH {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y + 1);
        }

        @Override
        public Orientation turnClockwise() {
            return EAST;
        }
    },
    EAST {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x + 1, currentPosition.y);
        }

        @Override
        public Orientation turnClockwise() {
            return SOUTH;
        }
    },
    SOUTH {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x, currentPosition.y - 1);
        }

        @Override
        public Orientation turnClockwise() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x - 1, currentPosition.y);
        }

        @Override
        public Orientation turnClockwise() {
            return NORTH;
        }
    };

    public abstract Point moveForwards(Point currentPosition);
    public abstract Orientation turnClockwise();
}