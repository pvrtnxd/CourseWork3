package me.lebedamm.coursework3.repository;

import io.swagger.v3.oas.models.security.SecurityScheme;
import me.lebedamm.coursework3.model.Pack;
import me.lebedamm.coursework3.model.Socks;

import java.util.Map;

public interface SocksREP {
    void save (Pack pack);
    int delete (Pack pack);
    Map<Socks, Integer> getAll();
}
