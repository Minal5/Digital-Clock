package com.practice;

import javax.swing.*;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyWindow extends JFrame{
	
	private JLabel heading;
	
	private JLabel clockLabel;
	
	private Font font = new Font("",Font.BOLD,35);
	
	MyWindow(){
		super.setTitle("My Clock");
		super.setSize(400, 400);
		super.setLocation(300, 50);
		this.createGUI();
		this.startClock();
		super.setVisible(true);
		
		
	}
	
	public void createGUI() {
		//GUI
		
		heading = new JLabel("My Clock");
		
		clockLabel = new JLabel("clock");
		
		heading.setFont(font);
		clockLabel.setFont(font);
		
		
		this.setLayout(new GridLayout(2,1));
		
		this.add(heading);
		
		this.add(clockLabel);
		
	}
	
	public void startClock() {
		//METHOD 1
//		Timer timer = new Timer(1000,new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				String dateTime = new Date().toString();
//				
////				String dateTime = new Date().toLocaleString();
//				
//				// To format date
//				Date d = new Date();
//				SimpleDateFormat sfd = new SimpleDateFormat("HH : mm : ss");
//				String dateTime = sfd.format(d);
//				clockLabel.setText(dateTime);
//			}
//		});	
//		timer.start();
		
		//METHOD 2 : USING THREAD
		Thread t = new Thread() {
			public void run() {
				try {
					while(true) {
						Date d = new Date();
						SimpleDateFormat sfd = new SimpleDateFormat("HH : mm : ss");
						String dateTime = sfd.format(d);
						clockLabel.setText(dateTime);
//						Thread.sleep(1000);
						
						Thread.currentThread().sleep(1000);
					}
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t.start();
		
	}
}
