package android.support.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: ChangeBounds.java */
/* renamed from: android.support.transition.g */
/* loaded from: classes.dex */
class C0201g extends Property<Drawable, PointF> {

    /* renamed from: a */
    private Rect f589a;

    public C0201g(Class cls, String str) {
        super(cls, str);
        this.f589a = new Rect();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f589a);
        this.f589a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f589a);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f589a);
        Rect rect = this.f589a;
        return new PointF(rect.left, rect.top);
    }
}
