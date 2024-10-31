package com.google.android.gms.internal.ads;

import java.util.Random;

@zzark
/* loaded from: classes2.dex */
public final class zzwu {
    private static zzwu zzclj = new zzwu();
    private final zzbat zzclk;
    private final zzwj zzcll;
    private final String zzclm;
    private final zzaai zzcln;
    private final zzaaj zzclo;
    private final zzaak zzclp;
    private final zzbbi zzclq;
    private final Random zzclr;

    protected zzwu() {
        this(new zzbat(), new zzwj(new zzvz(), new zzvy(), new zzzg(), new zzafa(), new zzavf(), new zzawf(), new zzaoo(), new zzafb()), new zzaai(), new zzaaj(), new zzaak(), zzbat.zzaas(), new zzbbi(0, 14300000, true), new Random());
    }

    public static zzbat zzpv() {
        return zzclj.zzclk;
    }

    public static zzwj zzpw() {
        return zzclj.zzcll;
    }

    public static zzaaj zzpx() {
        return zzclj.zzclo;
    }

    public static zzaai zzpy() {
        return zzclj.zzcln;
    }

    public static zzaak zzpz() {
        return zzclj.zzclp;
    }

    public static String zzqa() {
        return zzclj.zzclm;
    }

    public static zzbbi zzqb() {
        return zzclj.zzclq;
    }

    public static Random zzqc() {
        return zzclj.zzclr;
    }

    private zzwu(zzbat zzbatVar, zzwj zzwjVar, zzaai zzaaiVar, zzaaj zzaajVar, zzaak zzaakVar, String str, zzbbi zzbbiVar, Random random) {
        this.zzclk = zzbatVar;
        this.zzcll = zzwjVar;
        this.zzcln = zzaaiVar;
        this.zzclo = zzaajVar;
        this.zzclp = zzaakVar;
        this.zzclm = str;
        this.zzclq = zzbbiVar;
        this.zzclr = random;
    }
}
