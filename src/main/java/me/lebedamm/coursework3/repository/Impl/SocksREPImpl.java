package me.lebedamm.coursework3.repository.Impl;

import io.swagger.v3.oas.models.security.SecurityScheme;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Socks;
import me.lebedamm.coursework3.repository.SocksREP;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SocksREPImpl implements SocksREP {


    private final Map<Socks, Integer> socksIntegerMap = new HashMap<>();

    @Override
    public void save(Pack pack) {
        Socks socks = pack.getSocks();
        if (socksIntegerMap.containsKey(socks)) {
            socksIntegerMap.put(socks,socksIntegerMap.get(socks) + pack.getQuantity());
        }
        socksIntegerMap.put(socks, pack.getQuantity());

    }

    @Override
    public int delete(Pack pack) {
        Socks socks = pack.getSocks();

        if (socksIntegerMap.containsKey(socks)) {
            int quantity = socksIntegerMap.get(socks);

            if (pack.getQuantity() < quantity) {
                socksIntegerMap.replace(socks, quantity - pack.getQuantity());
                return pack.getQuantity();
            } else {
                socksIntegerMap.remove(socks);
                return quantity;
            }
        }
        return 0;
    }

    @Override
    public Map<Socks, Integer> getAll() {
        return socksIntegerMap;
    }
}
