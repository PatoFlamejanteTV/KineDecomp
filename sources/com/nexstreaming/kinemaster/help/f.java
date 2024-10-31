package com.nexstreaming.kinemaster.help;

import android.graphics.drawable.Drawable;

/* compiled from: HelpSection.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f3401a;
    private String b;
    private g c;
    private boolean d;
    private Drawable e;
    private int f;

    public f(String str, String str2, boolean z, int i) {
        this.f3401a = str;
        this.b = str2;
        this.d = z;
        this.e = null;
        this.c = null;
        this.f = i;
    }

    public f(String str, g gVar, boolean z, int i) {
        this.f3401a = str;
        this.b = null;
        this.d = z;
        this.e = null;
        this.c = gVar;
        this.f = i;
    }

    public f(String str, String str2, boolean z, Drawable drawable) {
        this.f3401a = str;
        this.b = str2;
        this.d = z;
        this.e = drawable;
        this.c = null;
        this.f = -1;
    }

    public String a() {
        return this.f3401a;
    }

    public String b() {
        return this.b;
    }

    public Drawable c() {
        return this.e;
    }

    public g d() {
        return this.c;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return this.c != null;
    }

    public int g() {
        return this.f;
    }
}
