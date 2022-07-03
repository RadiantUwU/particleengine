package com.radiant.particleengine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final public class ParticleType {
    private final String name;

    public String getName() {
        return name;
    }

    public ParticleType(String name) throws InvocationTargetException, IllegalAccessException {
        this.name = name;
        //access private field of ParticleTypes and get instance
        Method m;
        try {
            //noinspection JavaReflectionMemberAccess
            m = ParticleTypes.class.getMethod("addType");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        m.setAccessible(true);
        //noinspection JavaReflectionInvocation
        m.invoke(ParticleTypes.getInstance(),this);
    }
}
