package me.lebedamm.coursework3.services;

import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;

public interface ValService {
    boolean validation(Pack pack);
    boolean validation(Color color, Size size, int cottonMin, int cottonMax);
}
