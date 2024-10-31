package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Xa {

    /* renamed from: a, reason: collision with root package name */
    private static final Xa f13190a = new Xa();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, _a<?>> f13192c = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1291ab f13191b = new Ha();

    private Xa() {
    }

    public static Xa a() {
        return f13190a;
    }

    public final <T> _a<T> a(Class<T> cls) {
        zzre.zza(cls, "messageType");
        _a<T> _aVar = (_a) this.f13192c.get(cls);
        if (_aVar != null) {
            return _aVar;
        }
        _a<T> a2 = this.f13191b.a(cls);
        zzre.zza(cls, "messageType");
        zzre.zza(a2, "schema");
        _a<T> _aVar2 = (_a) this.f13192c.putIfAbsent(cls, a2);
        return _aVar2 != null ? _aVar2 : a2;
    }

    public final <T> _a<T> a(T t) {
        return a((Class) t.getClass());
    }
}
