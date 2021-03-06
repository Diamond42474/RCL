import java.util.Enumeration;

import com.github.pires.obd.commands.engine.RPMCommand;
import com.github.pires.obd.commands.protocol.EchoOffCommand;
import com.github.pires.obd.commands.protocol.LineFeedOffCommand;
import com.github.pires.obd.commands.protocol.SelectProtocolCommand;
import com.github.pires.obd.commands.protocol.TimeoutCommand;
import com.github.pires.obd.enums.ObdProtocols;

import gnu.io.CommPortIdentifier;

public class Car {
	public static int RPM = 0;
	public static RPM_Manager rpm_manager = new RPM_Manager();
	static class RPM_Manager{
		private final RPMCommand RPMC = new RPMCommand();
		public void start(){
			try {
			Enumeration ports = CommPortIdentifier.getPortIdentifiers();
			new EchoOffCommand().run(Connection.socket.getInputStream(), Connection.socket.getOutputStream());
			new LineFeedOffCommand().run(Connection.socket.getInputStream(), Connection.socket.getOutputStream());
			new TimeoutCommand(125).run(Connection.socket.getInputStream(), Connection.socket.getOutputStream());
			new SelectProtocolCommand(ObdProtocols.AUTO).run(Connection.socket.getInputStream(), Connection.socket.getOutputStream());
			}catch(Exception e) {
				e.printStackTrace();
			}
			Thread thread = new Thread() {
				public void run() {
					while(true) {
						RPM = RPMC.getRPM();
					}
				}
			};
			thread.start();
			}
		}
}
