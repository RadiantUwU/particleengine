package com.radiant.particleengine;

import java.awt.*;

public class BaseParticle implements AbstractParticle {
    private ParticleType type;
    private double charge;
    private double mass;
    private double radius;
    private Color color;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double ax;
    private double ay;
    public void update() {}
    public void DrawObject(Graphics g, double[] rel, double[] scale, double[] screen_res) {
        g.setColor(color);
        final double nx = x - rel[0] / scale[0];
        final double ny = y - rel[1] / scale[1];
        // check if the particle is in the screen
        if ((nx > 0 && nx < 1) && (ny > 0 && ny < 1)) {
            final double orx = radius / scale[0] * screen_res[0];
            final double ory = radius / scale[1] * screen_res[1];
            g.fillOval((int) (nx * screen_res[0]), (int) (ny * screen_res[1]), (int) orx, (int) ory);
        }
    }
    public ParticleType getType() { return type; }
    public double getCharge() { return charge; }
    public double getMass() { return mass; }
    public double getRadius() { return radius; }
    public double[] getPos() { return new double[] {x, y}; }
    public double[] getVel() { return new double[] {vx, vy}; }
    public double[] getAcc() { return new double[] {ax, ay}; }
    public void setPos(double[] pos) { x = pos[0]; y = pos[1]; }
    public void addVel(double[] vel) { vx += vel[0]; vy += vel[1]; }
    public void addAcc(double[] acc) { ax += acc[0]; ay += acc[1]; }
}
