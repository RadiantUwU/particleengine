package com.radiant.particleengine;

public interface Particle extends Drawable {
    void update();
    ParticleType getType();
}
