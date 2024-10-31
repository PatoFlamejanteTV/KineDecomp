package android.support.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: ObjectAnimatorUtilsApi21.java */
/* renamed from: android.support.transition.y */
/* loaded from: classes.dex */
class C0218y implements InterfaceC0219z {
    @Override // android.support.transition.InterfaceC0219z
    public <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
    }
}
