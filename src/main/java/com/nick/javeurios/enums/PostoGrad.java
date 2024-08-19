package com.nick.javeurios.enums;

public enum PostoGrad {
    CEL("Cel"),
    TC("TC"),
    MAJ("Maj"),
    CAP("Cap"),
    PRIM_TEN("1º Ten"),
    SEG_TEN("2º Ten"),
    ASP("Asp Of"),
    ST("ST"),
    PRIM_SGT("1º Sgt"),
    SEG_SGT("2º Sgt"),
    TER_SGT("3º Sgt"),
    CB("Cb"),
    SD("Sd EP"),
    REC("Sd Rec");

    private final String pg_extenso;

    PostoGrad(String pg_extenso) {
        this.pg_extenso = pg_extenso;
    }

    public String getPg_extenso(){
        return pg_extenso;
    }
}
