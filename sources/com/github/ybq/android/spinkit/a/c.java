package com.github.ybq.android.spinkit.a;

import android.util.Property;

/* compiled from: IntProperty.java */
/* loaded from: classes.dex */
public abstract class c<T> extends Property<T, Integer> {
    public c(String str) {
        super(Integer.class, str);
    }

    public abstract void a(T t, int i);

    public final void a(T t, Integer num) {
        a((c<T>) t, num.intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(Object obj, Integer num) {
        a((c<T>) obj, num);
    }
}
