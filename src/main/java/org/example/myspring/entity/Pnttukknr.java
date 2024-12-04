package org.example.myspring.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data

public class Pnttukknr {

    public String cstid;

    public Instant id;

    public String skdte;

    public BigDecimal pntcou;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;

}