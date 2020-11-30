public class Planet {
    //TODO
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11; //unit Nm2/kg2

    // constructor
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    // p: the supplied planet; calling instance: the object subjected to force
    public double calcDistance(Planet p) {
        double dx, dy;
        dx = p.xxPos - this.xxPos;
        dy = p.yyPos - this.xxPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p) {
        return G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] p) {
        double forceX = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != this)
                forceX += this.calcForceExertedByX(p[i]);
        }
        return forceX;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double forceY = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] != this)
                forceY += this.calcForceExertedByY(p[i]);
        }
        return forceY;
    }

    public void update(double t, double FxNet, double FyNet) {
        double ax = FxNet / mass, ay = FyNet / mass;
        xxVel = xxVel + ax * t;
        yyVel = yyVel + ay * t;
        xxPos = xxPos + xxVel * t;
        yyPos = yyPos + yyVel * t;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this. yyPos, "./images/" + imgFileName);
    }
}


