package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Ea {

    /* renamed from: a */
    private static final Ea f13362a;

    /* renamed from: b */
    private static final Ea f13363b;

    static {
        f13362a = new Ga();
        f13363b = new Ha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Ea() {
    }

    public static Ea a() {
        return f13362a;
    }

    public static Ea b() {
        return f13363b;
    }

    public abstract <L> List<L> a(Object obj, long j);

    public abstract <L> void a(Object obj, Object obj2, long j);

    public abstract void b(Object obj, long j);

    public /* synthetic */ Ea(Fa fa) {
        this();
    }
}
