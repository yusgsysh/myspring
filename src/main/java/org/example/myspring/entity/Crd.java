package org.example.myspring.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
@Data

public class Crd {
    public String crdcd;

    public String cstid;

    public Character hnnkzk;

    public Character ssflg;

    public String crdshucd;

    public String taxcd;

    public String crdykk;

    public BigDecimal spgtorkbn;

    public BigDecimal csgkbn;

    public BigDecimal tspgtorkbn;

    public BigDecimal tcsgkbn;

    public String tykk;

    public String crdsts;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;
}