package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* compiled from: PropertyValuesHolderUtilsApi14.java */
/* loaded from: classes.dex */
class D implements F {
    @Override // android.support.transition.F
    public PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new B(property, path), 0.0f, 1.0f);
    }
}
