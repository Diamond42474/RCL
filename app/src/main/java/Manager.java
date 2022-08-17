import connection.Obd;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import io.Lights;

import java.io.IOException;

public class Manager {
    private static Obd obd;
    private static Lights lights;
    public Manager(){

    }
    public void setup(){
        // Setup connection.Obd connection
        try {
            obd = new Obd();
            obd.setup();
        } catch (NoSuchPortException | PortInUseException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        // Setup io.Lights
        lights = new Lights();
        lights.setup();
    }
    public void start(){
        int rpm = obd.getRpm();
        lights.setFrontLights(255, 0 ,0);
        lights.setMiddleLights(0, 255, 0);
        lights.setBackLights(0, 0, 255);
    }
}
