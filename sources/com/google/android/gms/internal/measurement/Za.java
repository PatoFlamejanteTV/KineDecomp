package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Za {

    /* renamed from: a, reason: collision with root package name */
    private static final Za f13408a = new Za();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, InterfaceC1353cb<?>> f13410c = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1356db f13409b = new Ja();

    private Za() {
    }

    public static Za a() {
        return f13408a;
    }

    public final <T> InterfaceC1353cb<T> a(Class<T> cls) {
        zzuq.zza(cls, "messageType");
        InterfaceC1353cb<T> interfaceC1353cb = (InterfaceC1353cb) this.f13410c.get(cls);
        if (interfaceC1353cb != null) {
            return interfaceC1353cb;
        }
        InterfaceC1353cb<T> a2 = this.f13409b.a(cls);
        zzuq.zza(cls, "messageType");
        zzuq.zza(a2, "schema");
        InterfaceC1353cb<T> interfaceC1353cb2 = (InterfaceC1353cb) this.f13410c.putIfAbsent(cls, a2);
        return interfaceC1353cb2 != null ? interfaceC1353cb2 : a2;
    }

    public final <T> InterfaceC1353cb<T> a(T t) {
        return a((Class) t.getClass());
    }
}
