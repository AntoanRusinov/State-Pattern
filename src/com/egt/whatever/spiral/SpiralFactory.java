package com.egt.whatever.spiral;

import com.egt.whatever.lib.IPrinter;
import com.egt.whatever.lib.IState;

public class SpiralFactory {

    public IState create(int xLength, int yLength, final IPrinter iPrinter) {
	return new StateContext(xLength, yLength, iPrinter);
    }
}
