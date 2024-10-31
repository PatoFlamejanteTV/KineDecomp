package com.nexstreaming.kinemaster.help;

import android.graphics.drawable.Drawable;

/* compiled from: HelpSection.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private String f20410a;

    /* renamed from: b */
    private String f20411b;

    /* renamed from: c */
    private g f20412c;

    /* renamed from: d */
    private boolean f20413d;

    /* renamed from: e */
    private Drawable f20414e;

    /* renamed from: f */
    private int f20415f;

    public f(String str, String str2, boolean z, int i) {
        this.f20410a = str;
        this.f20411b = str2;
        this.f20413d = z;
        this.f20414e = null;
        this.f20412c = null;
        this.f20415f = i;
    }

    public Drawable a() {
        return this.f20414e;
    }

    public String b() {
        return this.f20411b;
    }

    public g c() {
        return this.f20412c;
    }

    public int d() {
        return this.f20415f;
    }

    public String e() {
        return this.f20410a;
    }

    public boolean f() {
        return this.f20412c != null;
    }

    public boolean g() {
        return this.f20413d;
    }

    public f(String str, g gVar, boolean z, int i) {
        this.f20410a = str;
        this.f20411b = null;
        this.f20413d = z;
        this.f20414e = null;
        this.f20412c = gVar;
        this.f20415f = i;
    }

    public f(String str, String str2, boolean z, Drawable drawable) {
        this.f20410a = str;
        this.f20411b = str2;
        this.f20413d = z;
        this.f20414e = drawable;
        this.f20412c = null;
        this.f20415f = -1;
    }
}
