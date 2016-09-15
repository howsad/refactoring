package ru.sbt.refactoring;

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
    WEST {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x - 1, currentPosition.y);
        }

        @Override
        public Orientation turnClockwise() {
            return NORTH;
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
    EAST {
        @Override
        public Point moveForwards(Point currentPosition) {
            return new Point(currentPosition.x + 1, currentPosition.y);
        }

        @Override
        public Orientation turnClockwise() {
            return SOUTH;
        }
    };

    public abstract Point moveForwards(Point currentPosition);
    public abstract Orientation turnClockwise();
}