package com.mac.bb4.display;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import com.mac.bb4.rrs.Process;

public class RRSchedulerApplet extends Applet {
	
	@Override
	public void init() {
		setLayout(new BorderLayout());
		
		StringCanvas cpuCanvas = new StringCanvas("CPU", Color.CYAN);
		
		Process p = new Process(10, 1000);
		
		//cpuCanvas.setString("Process ID: " + p.getID() + "\n Time Remaining: " + p.getTimeRemaining() );
		//add(cpuCanvas, BorderLayout.NORTH);
		
		CPUCanvas cpu = new CPUCanvas();
		cpu.setProcess(p);
		add(cpu);
	}
	
	

}
