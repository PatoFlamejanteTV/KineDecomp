package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Ca {

    /* renamed from: a */
    private static final Ca f13134a;

    /* renamed from: b */
    private static final Ca f13135b;

    static {
        f13134a = new Ea();
        f13135b = new Fa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Ca() {
    }

    public static Ca a() {
        return f13134a;
    }

    public static Ca b() {
        return f13135b;
    }

    public abstract <L> List<L> a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract void b(Object obj, long j);

    public /* synthetic */ Ca(Da da) {
        this();
    }
}
