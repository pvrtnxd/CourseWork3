package me.lebedamm.coursework3.services.Impl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AllArgsConstructor;
import me.lebedamm.coursework3.exception.ValException;
import me.lebedamm.coursework3.model.Color;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Size;
import me.lebedamm.coursework3.model.Socks;
import me.lebedamm.coursework3.repository.SocksREP;
import me.lebedamm.coursework3.services.FirstService;
import me.lebedamm.coursework3.services.ValService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class FirstServiceImpl implements FirstService {

    private SocksREP socksREP;
    private ValService valService;

    @Override
    public void accept(Pack pack) {
        checkPack(pack);
        socksREP.save(pack);
    }

    @Override
    public int release(Pack pack) {
        checkPack(pack);
        return socksREP.delete(pack);
    }

    @Override
    public int delete(Pack pack) {
        checkPack(pack);
        return socksREP.delete(pack);
    }

    @Override
    public int getRemains(Color color, Size size, int percentCottonMin, int percentCottonMax) {
        if (!valService.validation(color, size, percentCottonMin, percentCottonMax)) {
            throw new ValException();
        }
        int count = 0;
        Map<Socks, Integer> socksIntegerMap = socksREP.getAll();
        for (Map.Entry<Socks, Integer> socksIntegerEntry : socksIntegerMap.entrySet()) {
            Socks socks = socksIntegerEntry.getKey();
            if (socks.getColor().equals(color) && socks.getSize().equals(size)
                    && socks.getPercentCotton() >= percentCottonMin && socks.getPercentCotton() <= percentCottonMax) {
                count += socksIntegerEntry.getValue();
            }
        }
        return count;
    }

    private void checkPack (Pack pack) {
        if (!valService.validation(pack)) {
            throw new ValException();
        }
    }
}
