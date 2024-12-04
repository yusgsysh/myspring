package org.example.myspring.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data

public class Campinf {
    public String campid;

    public String campn;

    public String ykkks;

    public String ykkke;

    public String ktkytiym;

    public BigDecimal pntcou;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;

}