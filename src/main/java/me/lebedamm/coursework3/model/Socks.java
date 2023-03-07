package me.lebedamm.coursework3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Socks {
    private Color color;
    private Size size;
    private int percentCotton;
}
