package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public class NativeContentAdMapper extends NativeAdMapper {

    /* renamed from: h */
    private String f10284h;
    private List<NativeAd.Image> i;
    private String j;
    private NativeAd.Image k;
    private String l;
    private String m;

    public final void a(List<NativeAd.Image> list) {
        this.i = list;
    }

    public final void b(String str) {
        this.j = str;
    }

    public final void c(String str) {
        this.l = str;
    }

    public final void d(String str) {
        this.f10284h = str;
    }

    public final String i() {
        return this.m;
    }

    public final String j() {
        return this.j;
    }

    public final String k() {
        return this.l;
    }

    public final String l() {
        return this.f10284h;
    }

    public final List<NativeAd.Image> m() {
        return this.i;
    }

    public final NativeAd.Image n() {
        return this.k;
    }

    public final void a(NativeAd.Image image) {
        this.k = image;
    }

    public final void a(String str) {
        this.m = str;
    }
}
