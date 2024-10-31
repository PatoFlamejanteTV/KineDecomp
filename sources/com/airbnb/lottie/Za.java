package com.airbnb.lottie;

import android.graphics.PointF;
import java.util.Collections;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
class Za extends AbstractC0651ha<PointF> {

    /* renamed from: f */
    private final PointF f7742f;

    /* renamed from: g */
    private final AbstractC0651ha<Float> f7743g;

    /* renamed from: h */
    private final AbstractC0651ha<Float> f7744h;

    public Za(AbstractC0651ha<Float> abstractC0651ha, AbstractC0651ha<Float> abstractC0651ha2) {
        super(Collections.emptyList());
        this.f7742f = new PointF();
        this.f7743g = abstractC0651ha;
        this.f7744h = abstractC0651ha2;
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    /* bridge */ /* synthetic */ Object a(C0649ga c0649ga, float f2) {
        return a((C0649ga<PointF>) c0649ga, f2);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    public void a(float f2) {
        this.f7743g.a(f2);
        this.f7744h.a(f2);
        this.f7742f.set(((Float) this.f7743g.b()).floatValue(), ((Float) this.f7744h.b()).floatValue());
        for (int i = 0; i < this.f7830a.size(); i++) {
            this.f7830a.get(i).a();
        }
    }

    @Override // com.airbnb.lottie.AbstractC0651ha, com.airbnb.lottie.AbstractC0677v
    public PointF b() {
        return a((C0649ga<PointF>) null, 0.0f);
    }

    @Override // com.airbnb.lottie.AbstractC0677v
    PointF a(C0649ga<PointF> c0649ga, float f2) {
        return this.f7742f;
    }
}
