package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Wh {

    /* renamed from: a */
    private static final Wh f11931a;

    /* renamed from: b */
    private static final Wh f11932b;

    static {
        f11931a = new Yh();
        f11932b = new Zh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Wh() {
    }

    public static Wh a() {
        return f11931a;
    }

    public static Wh b() {
        return f11932b;
    }

    public abstract <L> List<L> a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract void b(Object obj, long j);

    public /* synthetic */ Wh(Xh xh) {
        this();
    }
}
