import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

public class Lights {
	private static class sets{
		public static class Front{
			public static final int r = 8;
			public static final int g = 4;
			public static final int b = 5;
		}
		public static class Middle{
			public static final int r = 15;
			public static final int g = 16;
			public static final int b = 1;
		}
		public static class Back{
			public static final int r = 0;
			public static final int g = 2;
			public static final int b = 3;
		}
	}
	public static void start() {
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					set_Lights(Car.RPM);
				}
			}
		};
		thread.start();
	}
	public static void set_Lights(int RPM) {
		
		int[] colors = Calc.calculate(RPM);
		int r = colors[0];
		int g = colors[1];
		int b = colors[2];
		setColor(Row.FRONT, r, g, b);
		setColor(Row.MIDDLE, r, g, b);
		setColor(Row.BACK, r, g, b);
		
	}
	public static void setup() {
		Gpio.wiringPiSetup();
		
		SoftPwm.softPwmCreate(sets.Front.r, 0, 255);
		SoftPwm.softPwmCreate(sets.Front.g, 0, 255);
		SoftPwm.softPwmCreate(sets.Front.b, 0, 255);
		
		SoftPwm.softPwmCreate(sets.Middle.r, 0, 255);
		SoftPwm.softPwmCreate(sets.Middle.g, 0, 255);
		SoftPwm.softPwmCreate(sets.Middle.b, 0, 255);
		
		SoftPwm.softPwmCreate(sets.Back.r, 0, 255);
		SoftPwm.softPwmCreate(sets.Back.g, 0, 255);
		SoftPwm.softPwmCreate(sets.Back.b, 0, 255);
	}
	public static void setColor(Row row, int r, int g, int b) {
		switch(row) {
			case FRONT:
				//System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(sets.Front.r, r);
				SoftPwm.softPwmWrite(sets.Front.g, g);
				SoftPwm.softPwmWrite(sets.Front.b, b);
				break;
			case MIDDLE:
				//System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(sets.Middle.r, r);
				SoftPwm.softPwmWrite(sets.Middle.g, g);
				SoftPwm.softPwmWrite(sets.Middle.b, b);
				break;
			case BACK:
				//System.out.println("Setting "+row+" to "+r+" "+g+" "+b);
				SoftPwm.softPwmWrite(sets.Back.r, r);
				SoftPwm.softPwmWrite(sets.Back.g, g);
				SoftPwm.softPwmWrite(sets.Back.b, b);
				break;
		}
	}
}
