import gnu.io.SerialPort;

public class Runner {
	private static SerialPort socket;
	public static void main(String[] args) {
				Lights.setup();
				Car.rpm_manager.start();
		}
	
}
