package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.panel.DrawPanelController;
import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.legacy.drawer.shape.LineFactory;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

/**
 * driver adapter to drawer with several bugs.
 */
public class DrawPanelControllerAdapter extends DrawPanelController implements Job2dDriver {
	protected int startX = 0, startY = 0;

	public DrawPanelControllerAdapter() {
		super();
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = LineFactory.getBasicLine();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);

		DrawerFeature.getDrawerController().drawLine(line);
		setPosition(x,y);
	}

	@Override
	public String toString() {
		return "X = " + startX + " Y = " + startY;
	}
}

//Pytanie: Kiedy warto (lub trzeba) korzystać z adaptera klasy (wariant
//z projektu stażysty)?

//Gdy chcemy dopasować większą funkcjonaloność do małej lub niepasującej.
//Możemy dopasować interface do wymogów klasy do której chcemy używać
//nasze klasy.