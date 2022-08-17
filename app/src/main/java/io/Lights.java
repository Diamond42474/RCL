package io;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class Lights {
	// front row
	private static final int frontRowRed = 8;
	private static final int frontRowBlue = 4;
	private static final int frontRowGreen = 5;
	// middle row
	private static final int middleRowRed = 15;
	private static final int middleRowBlue = 16;
	private static final int middleRowGreen = 1;
	// back row
	private static final int backRowRed = 0;
	private static final int backRowBlue = 2;
	private static final int backRowGreen = 3;

	public Lights(){

	}
	public void setup() {
		Gpio.wiringPiSetup();

		SoftPwm.softPwmCreate(frontRowRed, 0, 255);
		SoftPwm.softPwmCreate(frontRowGreen, 0, 255);
		SoftPwm.softPwmCreate(frontRowBlue, 0, 255);

		SoftPwm.softPwmCreate(middleRowRed, 0, 255);
		SoftPwm.softPwmCreate(middleRowGreen, 0, 255);
		SoftPwm.softPwmCreate(middleRowBlue, 0, 255);

		SoftPwm.softPwmCreate(backRowRed, 0, 255);
		SoftPwm.softPwmCreate(backRowGreen, 0, 255);
		SoftPwm.softPwmCreate(backRowBlue, 0, 255);
	}
	public void setFrontLights(int r, int b, int g){
		SoftPwm.softPwmWrite(frontRowRed, r);
		SoftPwm.softPwmWrite(frontRowGreen, g);
		SoftPwm.softPwmWrite(frontRowBlue, b);
	}
	public void setMiddleLights(int r, int b, int g){
		SoftPwm.softPwmWrite(middleRowRed, r);
		SoftPwm.softPwmWrite(middleRowGreen, g);
		SoftPwm.softPwmWrite(middleRowBlue, b);
	}
	public void setBackLights(int r, int b, int g){
		SoftPwm.softPwmWrite(backRowRed, r);
		SoftPwm.softPwmWrite(backRowGreen, g);
		SoftPwm.softPwmWrite(backRowBlue, b);
	}
}
