package com.radiant.particleengine;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Window extends JFrame {

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
        private final Set<Drawable> drawables;

        public Panel() {
            super();
            drawables = new HashSet<>();
        }

        public void paintComponent(Graphics g) {
            for (Drawable i : drawables)
                i.DrawObject(g);

        }
    }

    public Window() {
        super();
        setContentPane(new Panel());
    }
}
