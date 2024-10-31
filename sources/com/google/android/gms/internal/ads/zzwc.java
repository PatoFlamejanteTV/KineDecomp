package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzwc {
    private Bundle mExtras;
    private boolean zzbli;
    private int zzcjs;
    private String zzcjt;
    private long zzcju;
    private int zzcjv;
    private List<String> zzcjw;
    private boolean zzcjx;
    private int zzcjy;
    private String zzcjz;
    private zzzs zzcka;
    private String zzckb;
    private Bundle zzckc;
    private Bundle zzckd;
    private List<String> zzcke;
    private String zzckf;
    private String zzckg;
    private boolean zzckh;
    private zzvv zzcki;
    private Location zzil;

    public zzwc() {
        this.zzcju = -1L;
        this.mExtras = new Bundle();
        this.zzcjv = -1;
        this.zzcjw = new ArrayList();
        this.zzcjx = false;
        this.zzcjy = -1;
        this.zzbli = false;
        this.zzcjz = null;
        this.zzcka = null;
        this.zzil = null;
        this.zzckb = null;
        this.zzckc = new Bundle();
        this.zzckd = new Bundle();
        this.zzcke = new ArrayList();
        this.zzckf = null;
        this.zzckg = null;
        this.zzckh = false;
        this.zzcjs = -1;
        this.zzcjt = null;
    }

    public final zzwc zza(Location location) {
        this.zzil = null;
        return this;
    }

    public final zzwb zzpn() {
        return new zzwb(8, this.zzcju, this.mExtras, this.zzcjv, this.zzcjw, this.zzcjx, this.zzcjy, this.zzbli, this.zzcjz, this.zzcka, this.zzil, this.zzckb, this.zzckc, this.zzckd, this.zzcke, this.zzckf, this.zzckg, this.zzckh, this.zzcki, this.zzcjs, this.zzcjt);
    }

    public zzwc(zzwb zzwbVar) {
        this.zzcju = zzwbVar.zzcjb;
        this.mExtras = zzwbVar.extras;
        this.zzcjv = zzwbVar.zzcjc;
        this.zzcjw = zzwbVar.zzcjd;
        this.zzcjx = zzwbVar.zzcje;
        this.zzcjy = zzwbVar.zzcjf;
        this.zzbli = zzwbVar.zzcjg;
        this.zzcjz = zzwbVar.zzcjh;
        this.zzcka = zzwbVar.zzcji;
        this.zzil = zzwbVar.zzcjj;
        this.zzckb = zzwbVar.zzcjk;
        this.zzckc = zzwbVar.zzcjl;
        this.zzckd = zzwbVar.zzcjm;
        this.zzcke = zzwbVar.zzcjn;
        this.zzckf = zzwbVar.zzcjo;
        this.zzckg = zzwbVar.zzcjp;
        this.zzckh = zzwbVar.zzcjq;
        this.zzcki = zzwbVar.zzcjr;
        this.zzcjs = zzwbVar.zzcjs;
        this.zzcjt = zzwbVar.zzcjt;
    }
}
