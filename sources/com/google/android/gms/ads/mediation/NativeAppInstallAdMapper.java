package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeAppInstallAdMapper extends NativeAdMapper {

    /* renamed from: h */
    private String f10283h;
    private List<NativeAd.Image> i;
    private String j;
    private NativeAd.Image k;
    private String l;
    private double m;
    private String n;
    private String o;

    public final void a(List<NativeAd.Image> list) {
        this.i = list;
    }

    public final void b(String str) {
        this.l = str;
    }

    public final void c(String str) {
        this.f10283h = str;
    }

    public final void d(String str) {
        this.o = str;
    }

    public final void e(String str) {
        this.n = str;
    }

    public final String i() {
        return this.j;
    }

    public final String j() {
        return this.l;
    }

    public final String k() {
        return this.f10283h;
    }

    public final NativeAd.Image l() {
        return this.k;
    }

    public final List<NativeAd.Image> m() {
        return this.i;
    }

    public final String n() {
        return this.o;
    }

    public final double o() {
        return this.m;
    }

    public final String p() {
        return this.n;
    }

    public final void a(String str) {
        this.j = str;
    }

    public final void a(NativeAd.Image image) {
        this.k = image;
    }

    public final void a(double d2) {
        this.m = d2;
    }
}
