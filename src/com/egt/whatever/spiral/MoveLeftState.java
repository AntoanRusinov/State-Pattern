package com.egt.whatever.spiral;
public class MoveLeftState extends State {

    private static final MoveLeftState _INSTANCE = new MoveLeftState();

    public static State get() {
	return _INSTANCE;
    }

    public void move(StateContext stateContext) {

	final int matrix[][] = stateContext.getMatrix();

	matrix[stateContext.getCurrentY()][stateContext.getCurrentX()] = stateContext.incrementAndGet();

	final int newX = stateContext.getCurrentX() - 1;
	final int newY = stateContext.getCurrentY();

	if (newX >= 0) {
	    final int element = matrix[newY][newX];

	    if (element == 0) {
		stateContext.setXY(newX, newY);
		return;
	    }
	}

	stateContext.setXY(stateContext.getCurrentX(), stateContext.getCurrentY() - 1);
	stateContext.setState(MoveUpState.get());

    }

}
