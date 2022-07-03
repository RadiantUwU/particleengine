package com.radiant.particleengine;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Window extends JFrame {
    private static Window inst = null;
    static public double[] rel = new double[2];
    static public double[] scale = new double[2];
    public static Window getInstance() {
        if (inst == null) {
            inst = new Window();
        }
        return inst;
    }
    public static void delete() {
        inst.removeAll();
        inst.dispose();
        inst = null;
    }

    public void addObject(Drawable drawable) {
        ((Panel) getContentPane()).drawables.add(drawable);
    }

    public void removeObject(Drawable drawable) {
        ((Panel) getContentPane()).drawables.remove(drawable);
    }

    public boolean hasObject(Drawable drawable) {
        return ((Panel) getContentPane()).drawables.contains(drawable);
    }

    public int getObjectsLen() {
        return ((Panel) getContentPane()).drawables.size();
    }

    static protected class Panel extends JPanel {
        private final Set<Drawable> drawables = new HashSet<>();

        public void paintComponent(Graphics g) {
            for (Drawable i : drawables){
                Dimension d = getSize();
                i.DrawObject(g,rel,scale,new double[]{d.width,d.height});
            }

        }
    }

    private Window() {
        super();
        setTitle("Particle Engine");
        setContentPane(new Panel());
    }
}
