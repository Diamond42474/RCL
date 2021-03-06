import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class Connection {
	public static SerialPort socket;
	public static void connect() {
		socket = connectSerial("/dev/rfcomm0");
	}
	private static SerialPort connectSerial(String port) {
        SerialPort serialPort = null;
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
            serialPort = (SerialPort) portIdentifier.open("OBD2-connection", 0);
        } catch (NoSuchPortException | PortInUseException e) {
            System.out.println(e);
        }
        return serialPort;
    }
}
