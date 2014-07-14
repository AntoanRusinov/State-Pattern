package com.egt.whatever.spiral;

import java.util.Arrays;

import com.egt.whatever.lib.IPrinter;
import com.egt.whatever.lib.IState;

class StateContext implements IState {

    private final int matrix[][];

    private final IPrinter iPrinter;

    private final int xLength;
    private final int yLength;

    private State currentState;

    private int counter;
    private int currentX;
    private int currentY;

    public StateContext(final int xLength, final int yLength, final IPrinter iPrinter) {
	this.matrix = new int[yLength][xLength];
	this.xLength = xLength;
	this.yLength = yLength;

	this.iPrinter = iPrinter;
	this.currentState = MoveRightState.get();
    }

    public State getState() {
	return currentState;
    }

    public void setState(State state) {
	this.currentState = state;
    }

    public int getCurrentX() {
	return currentX;
    }

    public void setXY(final int x, final int y) {
	this.currentX = x;
	this.currentY = y;
    }

    public int incrementAndGet() {
	return ++this.counter;
    }

    public int getCurrentY() {
	return currentY;
    }

    public int[][] getMatrix() {
	return matrix;
    }

    public int getxLength() {
	return xLength;
    }

    public int getyLength() {
	return yLength;
    }

    public void next() {
	this.currentState.move(this);
    }

    public void view() {

	int[][] copyOfMatrix = new int[this.yLength][this.xLength];

	for (int y = 0; y < this.yLength; y++) {
	    int[] copyOfMatrixRow = Arrays.copyOf(this.matrix[y], this.yLength);
	    copyOfMatrix[y] = copyOfMatrixRow;
	}

	this.iPrinter.print(copyOfMatrix);
    }
}
