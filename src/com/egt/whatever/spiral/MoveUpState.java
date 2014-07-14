package com.egt.whatever.spiral;
public class MoveUpState extends State {

    private static final MoveUpState _INSTANCE = new MoveUpState();

    public static State get() {
	return _INSTANCE;
    }

    public void move(StateContext stateContext) {

	final int matrix[][] = stateContext.getMatrix();

	matrix[stateContext.getCurrentY()][stateContext.getCurrentX()] = stateContext.incrementAndGet();

	final int newX = stateContext.getCurrentX();
	final int newY = stateContext.getCurrentY() - 1;

	if (newY >= 0) {
	    final int element = matrix[newY][newX];

	    if (element == 0) {
		stateContext.setXY(newX, newY);
		return;
	    }
	}

	stateContext.setXY(stateContext.getCurrentX() + 1, stateContext.getCurrentY());
	stateContext.setState(MoveRightState.get());

    }

}
