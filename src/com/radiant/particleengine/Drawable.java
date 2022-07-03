package com.radiant.particleengine;

import java.awt.*;

public interface Drawable {
    void DrawObject(Graphics g, double[] rel, double[] scale, double[] screen_res);
}
