package android.support.transition;

import android.util.Property;
import android.view.View;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
class ia extends Property<View, Float> {
    public ia(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(View view) {
        return Float.valueOf(ka.c(view));
    }

    @Override // android.util.Property
    /* renamed from: a */
    public void set(View view, Float f2) {
        ka.a(view, f2.floatValue());
    }
}
