public class NBody {
    public static int n;

    public static double readRadius(String path) {
        In in = new In(path);
        int dummy = in.readInt();
        double r = in.readDouble();
        return r;
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        n = in.readInt();

        Planet[] planet = new Planet[n];
        double dummy = in.readDouble();

        for (int i = 0; i < n; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planet[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }
        return planet;
    }

    public static void main (String args[]) {
        double t = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);

        StdDraw.enableDoubleBuffering();

        double T = 0;

        while(T <= t) {
            StdDraw.clear();

            double[] xForces = new double[n];
            double[] yForces = new double[n];
            for (int i = 0; i < n; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < n; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "./images/starfield.jpg");
            for (int i = 0; i < n; i++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            T += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}

