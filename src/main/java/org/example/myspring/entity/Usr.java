package org.example.myspring.entity;



import lombok.Data;

import java.time.Instant;
@Data

public class Usr {
    public String cstid;

    public String loginn;

    public String disn;

    public String pass;

    public Character ser;

    public String token;

    public Character kbn;

    public String mail;

    public Instant insertdte;

    public String insertid;

    public Instant updatedte;

    public String updateid;

    public Character deleteflg;

    public Instant deletedte;
}