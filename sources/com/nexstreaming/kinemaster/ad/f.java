package com.nexstreaming.kinemaster.ad;

import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: Banner.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a */
    protected final BannerInfo f19951a;

    /* renamed from: b */
    protected final Rect f19952b = new Rect();

    /* renamed from: c */
    protected int f19953c;

    /* renamed from: d */
    protected int f19954d;

    /* renamed from: e */
    private boolean f19955e;

    /* compiled from: Banner.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(f fVar);
    }

    public f(BannerInfo bannerInfo) {
        this.f19951a = bannerInfo;
    }

    public Rect a() {
        return this.f19952b;
    }

    public abstract void a(long j);

    public abstract void a(Canvas canvas);

    public abstract void a(a aVar);

    public int b() {
        return this.f19951a.getDuration();
    }

    public int c() {
        return this.f19952b.height();
    }

    public int d() {
        return this.f19952b.left;
    }

    public int e() {
        return this.f19952b.top;
    }

    public int f() {
        return this.f19952b.width();
    }

    public boolean g() {
        return this.f19955e;
    }

    public abstract boolean h();

    public abstract boolean i();

    public void a(int i, int i2, int i3, int i4) {
        this.f19952b.set(i, i2, i3, i4);
    }

    public void a(int i, int i2) {
        this.f19953c = i;
        this.f19954d = i2;
    }

    public void a(boolean z) {
        this.f19955e = z;
    }
}
