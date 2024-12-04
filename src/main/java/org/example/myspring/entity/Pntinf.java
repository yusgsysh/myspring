package org.example.myspring.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data

public class Pntinf {
    public String pntinfid;

    public String cstid;

    public Character hnnkzk;

    public String urseq;

    public Instant tritim;

    public Character rksts;

    public BigDecimal pntcou;

    public String ktkytiym;

    public String campid;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;
}