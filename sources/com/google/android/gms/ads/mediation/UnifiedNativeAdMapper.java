package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.internal.ads.zzark;
import java.util.List;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public class UnifiedNativeAdMapper {

    /* renamed from: a */
    private String f10285a;

    /* renamed from: b */
    private List<NativeAd.Image> f10286b;

    /* renamed from: c */
    private String f10287c;

    /* renamed from: d */
    private NativeAd.Image f10288d;

    /* renamed from: e */
    private String f10289e;

    /* renamed from: f */
    private String f10290f;

    /* renamed from: g */
    private Double f10291g;

    /* renamed from: h */
    private String f10292h;
    private String i;
    private VideoController j;
    private boolean k;
    private View l;
    private View m;
    private Object n;
    private Bundle o = new Bundle();
    private boolean p;
    private boolean q;

    public void a(View view) {
    }

    public void a(View view, Map<String, View> map, Map<String, View> map2) {
    }

    public final void a(List<NativeAd.Image> list) {
        this.f10286b = list;
    }

    public void b(View view) {
    }

    public final void b(String str) {
        this.f10287c = str;
    }

    public final void c(String str) {
        this.f10289e = str;
    }

    public final void d(String str) {
        this.f10285a = str;
    }

    public final void e(String str) {
        this.i = str;
    }

    public final void f(String str) {
        this.f10292h = str;
    }

    public final NativeAd.Image g() {
        return this.f10288d;
    }

    public final List<NativeAd.Image> h() {
        return this.f10286b;
    }

    public final boolean i() {
        return this.q;
    }

    public final boolean j() {
        return this.p;
    }

    public final String k() {
        return this.i;
    }

    public final Double l() {
        return this.f10291g;
    }

    public final String m() {
        return this.f10292h;
    }

    public final VideoController n() {
        return this.j;
    }

    public boolean o() {
        return this.k;
    }

    public void p() {
    }

    public final View q() {
        return this.m;
    }

    public final Object r() {
        return this.n;
    }

    public final void a(NativeAd.Image image) {
        this.f10288d = image;
    }

    public final void b(boolean z) {
        this.p = z;
    }

    public final String c() {
        return this.f10287c;
    }

    public final String d() {
        return this.f10289e;
    }

    public final Bundle e() {
        return this.o;
    }

    public final String f() {
        return this.f10285a;
    }

    public final void a(String str) {
        this.f10290f = str;
    }

    public final String b() {
        return this.f10290f;
    }

    public final void a(Double d2) {
        this.f10291g = d2;
    }

    public final void a(VideoController videoController) {
        this.j = videoController;
    }

    public final void a(Object obj) {
        this.n = obj;
    }

    public final void a(boolean z) {
        this.q = z;
    }

    public View a() {
        return this.l;
    }
}
