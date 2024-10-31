package com.birbit.android.jobqueue.messaging;

import java.util.Arrays;

/* compiled from: MessageFactory.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    b[] f8224a = new b[Type.values().length];

    /* renamed from: b */
    int[] f8225b = new int[this.f8224a.length];

    public c() {
        Arrays.fill(this.f8225b, 0);
    }

    public <T extends b> T a(Class<T> cls) {
        Type type = Type.mapping.get(cls);
        synchronized (type) {
            T t = (T) this.f8224a[type.ordinal()];
            if (t != null) {
                this.f8224a[type.ordinal()] = t.f8222b;
                this.f8225b[type.ordinal()] = r7[r3] - 1;
                t.f8222b = null;
                return t;
            }
            try {
                try {
                    return cls.newInstance();
                } catch (IllegalAccessException e2) {
                    com.birbit.android.jobqueue.f.c.a(e2, "Cannot create an instance of " + cls + ". Make sure it has a public empty constructor.", new Object[0]);
                    return null;
                }
            } catch (InstantiationException e3) {
                com.birbit.android.jobqueue.f.c.a(e3, "Cannot create an instance of " + cls + ". Make sure it has a empty constructor.", new Object[0]);
                return null;
            }
        }
    }

    public void a(b bVar) {
        Type type = bVar.f8221a;
        bVar.b();
        synchronized (type) {
            if (this.f8225b[type.ordinal()] < 20) {
                bVar.f8222b = this.f8224a[type.ordinal()];
                this.f8224a[type.ordinal()] = bVar;
                int[] iArr = this.f8225b;
                int ordinal = type.ordinal();
                iArr[ordinal] = iArr[ordinal] + 1;
            }
        }
    }
}
