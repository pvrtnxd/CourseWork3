package me.lebedamm.coursework3.services.Impl;

import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;
import me.lebedamm.coursework3.services.ValService;

public class ValServiceImpl implements ValService {
    @Override
    public boolean validation(Pack pack) {
        return pack.getSocks() != null
        && pack.getQuantity() > 0
        && pack.getSocks().getColor() != null
        && pack.getSocks().getSize() != null
        && consistCotton(pack.getSocks().getPercentCotton(), pack.getSocks().getPercentCotton());
    }

    @Override
    public boolean validation(Color color, Size size, int cottonMin, int cottonMax) {
        return color != null
                && size != null
                && consistCotton(cottonMin, cottonMax);
    }

    private boolean consistCotton (int cottonMin, int cottonMax) {
        return cottonMin >= 0 && cottonMax <= 100;
    }
}
