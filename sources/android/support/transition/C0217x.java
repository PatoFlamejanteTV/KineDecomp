package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: ObjectAnimatorUtilsApi14.java */
/* renamed from: android.support.transition.x */
/* loaded from: classes.dex */
class C0217x implements InterfaceC0219z {
    @Override // android.support.transition.InterfaceC0219z
    public <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new B(property, path), 0.0f, 1.0f);
    }
}
