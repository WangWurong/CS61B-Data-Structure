public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;

	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b) {
		return Math.sqrt((b.xxPos - xxPos) * (b.xxPos - xxPos) + (b.yyPos - yyPos) * (b.yyPos - yyPos));
	}

	public double calcForceExertedBy(Body b) {
		double r = calcDistance(b);
		return (G * b.mass * mass) / (r * r);
	}

	public double calcForceExertedByX(Body b) {
		return (calcForceExertedBy(b) * (b.xxPos - xxPos)) / calcDistance(b);
	}

	public double calcForceExertedByY(Body b) {
		return (calcForceExertedBy(b) * (b.yyPos - yyPos)) / calcDistance(b);
	}

	public double calcNetForceExertedByX(Body[] allBodys) {
		double res = 0.0;
		for (Body b : allBodys) {
			if (!b.equals(this)) {
				res += calcForceExertedByX(b);
			}
		}
		return res;
	}

	public double calcNetForceExertedByY(Body[] allBodys) {
		double res = 0.0;
		for (Body b : allBodys) {
			if (!b.equals(this)) {
				res += calcForceExertedByY(b);
			}
		}
		return res;
	}

	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += dt * aX;
		yyVel += dt * aY;
		xxPos += dt * xxVel;
		yyPos += dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, imgFileName);
		StdDraw.show();
		StdDraw.pause(2000);
	}

}