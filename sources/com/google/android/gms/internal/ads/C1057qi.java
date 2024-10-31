package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.qi, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1057qi {

    /* renamed from: a, reason: collision with root package name */
    private static final C1057qi f12464a = new C1057qi();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1126vi f12465b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, InterfaceC1112ui<?>> f12466c = new ConcurrentHashMap();

    private C1057qi() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        InterfaceC1126vi interfaceC1126vi = null;
        for (int i = 0; i <= 0; i++) {
            interfaceC1126vi = a(strArr[0]);
            if (interfaceC1126vi != null) {
                break;
            }
        }
        this.f12465b = interfaceC1126vi == null ? new C0831ai() : interfaceC1126vi;
    }

    public static C1057qi a() {
        return f12464a;
    }

    public final <T> InterfaceC1112ui<T> a(Class<T> cls) {
        zzbrf.zza(cls, "messageType");
        InterfaceC1112ui<T> interfaceC1112ui = (InterfaceC1112ui) this.f12466c.get(cls);
        if (interfaceC1112ui != null) {
            return interfaceC1112ui;
        }
        InterfaceC1112ui<T> a2 = this.f12465b.a(cls);
        zzbrf.zza(cls, "messageType");
        zzbrf.zza(a2, "schema");
        InterfaceC1112ui<T> interfaceC1112ui2 = (InterfaceC1112ui) this.f12466c.putIfAbsent(cls, a2);
        return interfaceC1112ui2 != null ? interfaceC1112ui2 : a2;
    }

    public final <T> InterfaceC1112ui<T> a(T t) {
        return a((Class) t.getClass());
    }

    private static InterfaceC1126vi a(String str) {
        try {
            return (InterfaceC1126vi) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
