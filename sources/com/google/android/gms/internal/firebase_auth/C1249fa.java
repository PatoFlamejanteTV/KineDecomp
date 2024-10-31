package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.firebase_auth.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1249fa {

    /* renamed from: a, reason: collision with root package name */
    private static final C1249fa f13026a = new C1249fa();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, InterfaceC1263ma<?>> f13028c = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1265na f13027b = new O();

    private C1249fa() {
    }

    public static C1249fa a() {
        return f13026a;
    }

    public final <T> InterfaceC1263ma<T> a(Class<T> cls) {
        zzfv.zza(cls, "messageType");
        InterfaceC1263ma<T> interfaceC1263ma = (InterfaceC1263ma) this.f13028c.get(cls);
        if (interfaceC1263ma != null) {
            return interfaceC1263ma;
        }
        InterfaceC1263ma<T> a2 = this.f13027b.a(cls);
        zzfv.zza(cls, "messageType");
        zzfv.zza(a2, "schema");
        InterfaceC1263ma<T> interfaceC1263ma2 = (InterfaceC1263ma) this.f13028c.putIfAbsent(cls, a2);
        return interfaceC1263ma2 != null ? interfaceC1263ma2 : a2;
    }

    public final <T> InterfaceC1263ma<T> a(T t) {
        return a((Class) t.getClass());
    }
}
