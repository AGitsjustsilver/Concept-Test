package com.ag.brain.desktop;

import com.ag.brain.Constants;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.ag.brain.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		new LwjglApplication(new Main(), Constants.TITLE,Constants.WIDTH, Constants.HEIGHT);
	}
}
