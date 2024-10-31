package com.github.ybq.android.spinkit.a;

import android.util.Property;

/* compiled from: FloatProperty.java */
/* loaded from: classes.dex */
public abstract class b<T> extends Property<T, Float> {
    public b(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t, float f2);

    public final void a(T t, Float f2) {
        a((b<T>) t, f2.floatValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Float f2) {
        a((b<T>) obj, f2);
    }
}
