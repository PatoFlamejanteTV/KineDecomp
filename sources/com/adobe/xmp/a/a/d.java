package com.adobe.xmp.a.a;

/* compiled from: XMPPathSegment.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private String f7498a;

    /* renamed from: b */
    private int f7499b;

    /* renamed from: c */
    private boolean f7500c;

    /* renamed from: d */
    private int f7501d;

    public d(String str, int i) {
        this.f7498a = str;
        this.f7499b = i;
    }

    public void a(String str) {
        this.f7498a = str;
    }

    public int b() {
        return this.f7499b;
    }

    public String c() {
        return this.f7498a;
    }

    public boolean d() {
        return this.f7500c;
    }

    public String toString() {
        switch (this.f7499b) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f7498a;
            case 5:
            case 6:
                return this.f7498a;
            default:
                return this.f7498a;
        }
    }

    public void a(boolean z) {
        this.f7500c = z;
    }

    public void b(int i) {
        this.f7499b = i;
    }

    public int a() {
        return this.f7501d;
    }

    public void a(int i) {
        this.f7501d = i;
    }
}
