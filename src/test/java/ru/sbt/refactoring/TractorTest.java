package ru.sbt.refactoring;

import junit.framework.TestCase;

import static ru.sbt.refactoring.Command.MOVE_FORWARDS;
import static ru.sbt.refactoring.Command.TURN_CLOCKWISE;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

    public void testShouldMoveForward(){
        Tractor tractor = new Tractor();
        tractor.move(MOVE_FORWARDS);
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    public void testShouldTurn(){
        Tractor tractor = new Tractor();
        tractor.move(TURN_CLOCKWISE);
        assertEquals(Orientation.EAST, tractor.getOrientation());
        tractor.move(TURN_CLOCKWISE);
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        tractor.move(TURN_CLOCKWISE);
        assertEquals(Orientation.WEST, tractor.getOrientation());
        tractor.move(TURN_CLOCKWISE);
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection(){
        Tractor tractor = new Tractor();
        tractor.move(TURN_CLOCKWISE);
        tractor.move(MOVE_FORWARDS);
        assertEquals(1, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
        tractor.move(TURN_CLOCKWISE);
        tractor.move(MOVE_FORWARDS);
        assertEquals(1, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move(TURN_CLOCKWISE);
        tractor.move(MOVE_FORWARDS);
        assertEquals(0, tractor.getPositionX());
        assertEquals(-1, tractor.getPositionY());
        tractor.move(TURN_CLOCKWISE);
        tractor.move(MOVE_FORWARDS);
        assertEquals(0, tractor.getPositionX());
        assertEquals(0, tractor.getPositionY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau(){
        Tractor tractor = new Tractor();
        tractor.move(MOVE_FORWARDS);
        tractor.move(MOVE_FORWARDS);
        tractor.move(MOVE_FORWARDS);
        tractor.move(MOVE_FORWARDS);
        tractor.move(MOVE_FORWARDS);
        try{
            tractor.move(MOVE_FORWARDS);
            fail("Tractor was expected to fall off the plateau");
        }catch(TractorInDitchException expected){
        }
    }
}