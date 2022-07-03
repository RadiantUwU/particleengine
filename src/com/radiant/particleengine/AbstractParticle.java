package com.radiant.particleengine;

public interface AbstractParticle extends Drawable {
    void update();
    ParticleType getType();
    double getCharge();
    double getMass();
    double getRadius();
    double[] getPos();
    double[] getVel();
    double[] getAcc();
    void setPos(double[] pos);
    void addVel(double[] vel);
    void addAcc(double[] acc);
}
