package com.larvalabs.svgandroid;

import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import java.util.Set;

/* compiled from: SVG.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    private final Set<Integer> f19312a;

    /* renamed from: b */
    private Picture f19313b;

    /* renamed from: c */
    private RectF f19314c;

    /* renamed from: d */
    private RectF f19315d = null;

    public b(Picture picture, RectF rectF, Set<Integer> set) {
        this.f19313b = picture;
        this.f19314c = rectF;
        this.f19312a = set;
    }

    public void a(RectF rectF) {
        this.f19315d = rectF;
    }

    public RectF b() {
        return this.f19314c;
    }

    public Set<Integer> c() {
        return this.f19312a;
    }

    public Picture d() {
        return this.f19313b;
    }

    public PictureDrawable a() {
        return new c.d.a.a.a.a(this.f19313b);
    }
}
