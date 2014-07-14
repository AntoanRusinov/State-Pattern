package com.egt.whatever.test;

import com.egt.whatever.lib.IPrinter;
import com.egt.whatever.lib.IState;
import com.egt.whatever.spiral.SpiralFactory;

public class TestMain {

    public static void main(String[] args) {

	final int xLength = 9;
	final int yLength = 9;

	IPrinter iPrinter = new IPrinter() {

	    @Override
	    public void print(int[][] matrix) {

		for (int row = 0; row < matrix[0].length; row++) {
		    for (int col = 0; col < matrix.length; col++) {
			System.out.print(matrix[row][col] + " ");
		    }
		    System.out.print("\n");
		}
	    }
	};

	final SpiralFactory spiralFactory = new SpiralFactory();

	IState stateContext = spiralFactory.create(xLength, yLength, iPrinter);

	for (int i = 0; i < 144; i++) {

	    try {
		stateContext.next();
	    } catch (Exception e) {
		e.printStackTrace();
		break;
	    }
	}

	stateContext.view();

    }

}
