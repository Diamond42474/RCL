package connection;

import com.github.pires.obd.commands.engine.RPMCommand;
import com.github.pires.obd.commands.protocol.EchoOffCommand;
import com.github.pires.obd.commands.protocol.LineFeedOffCommand;
import com.github.pires.obd.commands.protocol.SelectProtocolCommand;
import com.github.pires.obd.commands.protocol.TimeoutCommand;
import com.github.pires.obd.enums.ObdProtocols;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import java.io.IOException;


public class Obd {
    private static RPMCommand RPMC;
    public Obd(){
        RPMC = new RPMCommand();
    }

    public void setup() throws NoSuchPortException, PortInUseException, IOException, InterruptedException {
        SerialPort socket = connectSerial();
        new EchoOffCommand().run(socket.getInputStream(), socket.getOutputStream());
        new LineFeedOffCommand().run(socket.getInputStream(), socket.getOutputStream());
        new TimeoutCommand(125).run(socket.getInputStream(), socket.getOutputStream());
        new SelectProtocolCommand(ObdProtocols.AUTO).run(socket.getInputStream(), socket.getOutputStream());
    }

    public int getRpm(){
        return RPMC.getRPM();
    }

	private static SerialPort connectSerial() throws NoSuchPortException, PortInUseException {
        SerialPort serialPort;
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("/dev/rfcomm0");
        serialPort = (SerialPort) portIdentifier.open("OBD2-connection", 0);
        return serialPort;
    }
}
