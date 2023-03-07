package me.lebedamm.coursework3.services;

import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;

public interface FirstService {
    void accept(Pack pack);
    int release(Pack pack);
    int delete(Pack pack);
    int getRemains(Color color, Size size, int percentCottonMin, int percentCottonMax);
}
