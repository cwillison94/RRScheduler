package com.mac.bb4.display;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.mac.bb4.rrs.Process;

public class CPUCanvas extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Process process = null;
	private Font f1 = new Font("Helvetica", Font.BOLD, 20);
	// private Font f2 = new Font("Times",Font.ITALIC+Font.BOLD,24);

	private BufferedImage cpu;

	public CPUCanvas() {
		try {
			this.cpu = ImageIO.read(new File("images/cpu.jpg"));
		} catch (IOException e) {
			System.out.println("Image failed to load");
		}
	}

	public void setProcess(Process p) {
		this.process = p;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Dimension dim = getSize();

		if (cpu != null) {

			int w = cpu.getWidth();
			int h = cpu.getHeight();
			int x = (dim.width - w) / 2;
			int y = (dim.height - h) / 2;
			g.drawImage(cpu, x, y, this);
		}

		if (process != null) {
			String processTxt = "PID: " + process.getID();
			g.setFont(f1);
			FontMetrics fm = g.getFontMetrics();
			int w = fm.stringWidth(processTxt);
			int x = (dim.width - w) / 2;
			int y = dim.height / 2;
			int h = fm.getHeight();

			g.drawString(processTxt, x, y);
			
			String tR = "T.R: " + process.getTimeRemaining();
			fm = g.getFontMetrics();
			w = fm.stringWidth(tR);
			x = (dim.width - w) / 2;
			
			g.drawString(tR, x, y+h);
		}

	}

}
