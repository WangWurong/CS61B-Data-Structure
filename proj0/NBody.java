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
		double currentTime = 0.0;

		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

		while(currentTime <= T) {
			double[] xForces = new double[bodies.length];
			double[] yForces = new double[bodies.length];
			for (int i = 0; i < bodies.length; i++) {
				xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
				yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
			}
			for (int i = 0; i < bodies.length; i++) {
				bodies[i].update(dt, xForces[i], yForces[i]);
			}

			// draw background
			StdDraw.picture(0, 0, "images/starfield.jpg");

			// draw other planets
			for (Body b : bodies) {
				b.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			currentTime += dt;
		}

		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
					bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
					bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
		}
	}
}
