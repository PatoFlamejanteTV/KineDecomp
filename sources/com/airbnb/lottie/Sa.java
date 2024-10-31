package com.airbnb.lottie;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public class Sa extends AbstractC0677v<Oa, Path> {

    /* renamed from: f */
    private final Oa f7695f;

    /* renamed from: g */
    private final Path f7696g;

    public Sa(List<C0649ga<Oa>> list) {
        super(list);
        this.f7695f = new Oa();
        this.f7696g = new Path();
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public Path a(C0649ga<Oa> c0649ga, float f2) {
        this.f7695f.a(c0649ga.f7772c, c0649ga.f7773d, f2);
        C0676ua.a(this.f7695f, this.f7696g);
        return this.f7696g;
    }
}
