package me.lebedamm.coursework3.services.Impl;

import lombok.AllArgsConstructor;
import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;
import me.lebedamm.coursework3.services.FirstService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FirstServiceImpl implements FirstService {

    @Override
    public void accept(Pack pack) {

    }

    @Override
    public int release(Pack pack) {
        return 0;
    }

    @Override
    public int delete(Pack pack) {
        return 0;
    }

    @Override
    public int getRemains(Color color, Size size, int percentCottonMin, int percentCottonMax) {
        return 0;
    }

    private void checkPack (Pack pack) {


    }
}
