package me.lebedamm.coursework3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pack {
    private Socks socks;
    private int quantity;

}
