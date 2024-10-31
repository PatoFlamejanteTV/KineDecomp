package android.support.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.l */
/* loaded from: classes.dex */
class C0206l extends Property<View, PointF> {
    public C0206l(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public PointF get(View view) {
        return null;
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, PointF pointF) {
        int round = Math.round(pointF.x);
        int round2 = Math.round(pointF.y);
        ka.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
    }
}
