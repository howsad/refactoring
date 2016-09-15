package ru.sbt.refactoring;

/**
 * Created by Alexander Ushakov on 15.09.2016.
 */
public enum Command {
    MOVE_FORWARDS {
        @Override
        public void execute(Tractor tractor) {
            tractor.moveForwards();
        }
    },
    TURN_CLOCKWISE {
        @Override
        public void execute(Tractor tractor) {
            tractor.turnClockwise();
        }
    };

    public abstract void execute(Tractor tractor);
}
