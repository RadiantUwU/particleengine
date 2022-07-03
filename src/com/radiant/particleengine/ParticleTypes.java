package com.radiant.particleengine;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class ParticleTypes {
    private final Set<WeakReference<ParticleType>> types = new HashSet<>();
    static private ParticleTypes inst = null;
    @SuppressWarnings("unused")
    private void addType(ParticleType type) {
        types.add(new WeakReference<>(type));
    }
    @SuppressWarnings("unused")
    public ParticleType get(String name) {
        for (WeakReference<ParticleType> i : types) {
            //noinspection ConstantConditions
            if (i.get() != null && i.get().getName().equals(name)) {
                return i.get();
            }
        }
        return null;
    }
    @SuppressWarnings({"ConstantConditions", "unused"})
    public boolean contains(String name) {
        for (WeakReference<ParticleType> i : types) {
            if (i.get() != null && i.get().getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    static public ParticleTypes getInstance() {
        if (inst == null) {
            inst = new ParticleTypes();
        }
        return inst;
    }
}
