package android.support.transition;

import android.graphics.PointF;
import android.util.Property;
import android.view.View;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.k */
/* loaded from: classes.dex */
class C0205k extends Property<View, PointF> {
    public C0205k(Class cls, String str) {
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
        ka.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
    }
}
