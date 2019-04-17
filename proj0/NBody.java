public class NBody {
	public static double readRadius(String file) {
		In in =  new In(file);
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public  static Body[] readBodies(String file) {
		In in = new In(file);
		int number = in.readInt();
		double radius = in.readDouble();
		Body[] bodies = new Body[number];
		for (int i = 0; i < number; i++) {
			bodies[i] = new Body(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}
		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Body[] bodies = readBodies(filename);

		// draw background
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-100, 100);
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		StdDraw.show();
		StdDraw.pause(2000);

	}
}
