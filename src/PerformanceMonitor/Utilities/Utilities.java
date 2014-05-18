package PerformanceMonitor.Utilities;

import java.awt.GridBagConstraints;

public class Utilities {
	public static GridBagConstraints formatConfig(int gridX, int gridY, int width, int height, int anchor, int fill){
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gridX;
		gbc.gridy = gridY;
		gbc.gridwidth = width;
		gbc.gridheight = width;
		gbc.anchor = anchor;
		gbc.fill = fill;
		
		return gbc;
	}

}
