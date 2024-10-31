package com.google.android.gms.internal.clearcut;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.clearcut.ka, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1208ka {

    /* renamed from: a, reason: collision with root package name */
    private static final C1208ka f12849a = new C1208ka();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1220qa f12850b;

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, InterfaceC1218pa<?>> f12851c = new ConcurrentHashMap();

    private C1208ka() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        InterfaceC1220qa interfaceC1220qa = null;
        for (int i = 0; i <= 0; i++) {
            interfaceC1220qa = a(strArr[0]);
            if (interfaceC1220qa != null) {
                break;
            }
        }
        this.f12850b = interfaceC1220qa == null ? new V() : interfaceC1220qa;
    }

    public static C1208ka a() {
        return f12849a;
    }

    private static InterfaceC1220qa a(String str) {
        try {
            return (InterfaceC1220qa) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final <T> InterfaceC1218pa<T> a(Class<T> cls) {
        zzci.zza(cls, "messageType");
        InterfaceC1218pa<T> interfaceC1218pa = (InterfaceC1218pa) this.f12851c.get(cls);
        if (interfaceC1218pa != null) {
            return interfaceC1218pa;
        }
        InterfaceC1218pa<T> a2 = this.f12850b.a(cls);
        zzci.zza(cls, "messageType");
        zzci.zza(a2, "schema");
        InterfaceC1218pa<T> interfaceC1218pa2 = (InterfaceC1218pa) this.f12851c.putIfAbsent(cls, a2);
        return interfaceC1218pa2 != null ? interfaceC1218pa2 : a2;
    }

    public final <T> InterfaceC1218pa<T> a(T t) {
        return a((Class) t.getClass());
    }
}
