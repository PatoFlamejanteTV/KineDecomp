package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* loaded from: classes.dex */
public abstract class NativeAppInstallAdMapper extends NativeAdMapper {
    private String d;
    private List<NativeAd.Image> e;
    private String f;
    private NativeAd.Image g;
    private String h;
    private double i;
    private String j;
    private String k;

    public final void a(double d) {
        this.i = d;
    }

    public final void a(NativeAd.Image image) {
        this.g = image;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(List<NativeAd.Image> list) {
        this.e = list;
    }

    public final void b(String str) {
        this.f = str;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final void d(String str) {
        this.j = str;
    }

    public final String e() {
        return this.d;
    }

    public final void e(String str) {
        this.k = str;
    }

    public final List<NativeAd.Image> f() {
        return this.e;
    }

    public final String g() {
        return this.f;
    }

    public final NativeAd.Image h() {
        return this.g;
    }

    public final String i() {
        return this.h;
    }

    public final double j() {
        return this.i;
    }

    public final String k() {
        return this.j;
    }

    public final String l() {
        return this.k;
    }
}
