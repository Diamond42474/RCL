import java.util.Enumeration;

import com.github.pires.obd.commands.engine.RPMCommand;
import com.github.pires.obd.commands.protocol.EchoOffCommand;
import com.github.pires.obd.commands.protocol.LineFeedOffCommand;
import com.github.pires.obd.commands.protocol.SelectProtocolCommand;
import com.github.pires.obd.commands.protocol.TimeoutCommand;
import com.github.pires.obd.commands.temperature.AmbientAirTemperatureCommand;
import com.github.pires.obd.enums.ObdProtocols;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class Runner {
	private static SerialPort socket;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			try{
				Enumeration ports = CommPortIdentifier.getPortIdentifiers();
				socket = connectSerial("/dev/rfcomm0");
				
				new EchoOffCommand().run(socket.getInputStream(), socket.getOutputStream());
				new LineFeedOffCommand().run(socket.getInputStream(), socket.getOutputStream());
				new TimeoutCommand(125).run(socket.getInputStream(), socket.getOutputStream());
				new SelectProtocolCommand(ObdProtocols.AUTO).run(socket.getInputStream(), socket.getOutputStream());
				new AmbientAirTemperatureCommand().run(socket.getInputStream(), socket.getOutputStream());
				
				final RPMCommand RPMC = new RPMCommand();
				Lights.setup();
				while(true) {
					RPMC.run(socket.getInputStream(), socket.getOutputStream());
					Lights.set_Lights(RPMC.getRPM());
				}
			}catch(Exception e){
				
			}
		}

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
