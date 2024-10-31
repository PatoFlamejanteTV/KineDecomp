package com.google.android.gms.internal.firebase_auth;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class J {

    /* renamed from: a */
    private static final J f12972a;

    /* renamed from: b */
    private static final J f12973b;

    static {
        f12972a = new L();
        f12973b = new M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public J() {
    }

    public static J a() {
        return f12972a;
    }

    public static J b() {
        return f12973b;
    }

    public abstract <L> List<L> a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract void b(Object obj, long j);

    public /* synthetic */ J(K k) {
        this();
    }
}
