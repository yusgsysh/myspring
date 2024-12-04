package org.example.myspring.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data

public class Pntsykknr {
    public String cstid;

    public String sykdte;

    public Instant rkdte;

    public BigDecimal pntcou;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;

}