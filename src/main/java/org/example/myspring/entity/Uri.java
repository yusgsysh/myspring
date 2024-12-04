package org.example.myspring.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data

public class Uri {

    public String sel;

    public String kmtcd;

    public String kmtnam;

    public String poscd;

    public String dpycd;

    public Instant tritim;

    public String crdcd;

    public BigDecimal bktskz;

    public BigDecimal uag;

    public String cdtid;

    public Character hnnkzk;

    public String skyym;

    public Character tskflg;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;

}