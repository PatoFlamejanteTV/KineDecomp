package com.google.android.gms.internal.clearcut;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class O {

    /* renamed from: a */
    private static final O f12804a;

    /* renamed from: b */
    private static final O f12805b;

    static {
        f12804a = new S();
        f12805b = new T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public O() {
    }

    public /* synthetic */ O(P p) {
        this();
    }

    public static O a() {
        return f12804a;
    }

    public static O b() {
        return f12805b;
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);
}
