package com.workintech.zoo.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Kangaroo {
    private int id;
    private String name;
    private double height;
    private double weight;
    private String gender;
    private Boolean isAggressive;
}
