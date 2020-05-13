
public class Calc {
	public static class colors{
		public final static int[] r = {255,	255,	0,	255};
		public final static int[] g = {255,	0,	0,	255};
		public final static int[] b = {0,	0,	255,	255};
	}
	public static int[] calculate(int RPM) {
		System.out.println(RPM);
		if(RPM<1500) {
			return new int[] {colors.r[0],colors.g[0],colors.b[0]};
		}else if(RPM<3000) {
			return new int[] {fade(RPM,3000,colors.r[0],colors.r[1]),fade(RPM,3000,colors.g[0],colors.g[1]),fade(RPM,3000,colors.b[0],colors.b[1])};
		}else if(RPM<4500) {
			return new int[] {fade(RPM,4500,colors.r[1],colors.r[2]),fade(RPM,4500,colors.g[1],colors.g[2]),fade(RPM,4500,colors.b[1],colors.b[2])};
		}else if(RPM<6000) {
			return new int[] {fade(RPM,6000,colors.r[2],colors.r[3]),fade(RPM,6000,colors.g[2],colors.g[3]),fade(RPM,6000,colors.b[2],colors.b[3])};
		}else if(RPM>6000) {
			return new int[] {colors.r[3],colors.g[3],colors.b[3]};
		}
		return null;
		
	}
	private static int fade(int RPM, int TopRPM, int min, int max) {
		double percent = (double) (RPM-(TopRPM-1500))/1500;
		double lowP = (double) 1-percent;
		
		return (int) ((((double)(max*percent))+((double)(min*lowP))));
		
	}
}
