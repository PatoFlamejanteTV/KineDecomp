package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class V implements InterfaceC1220qa {

    /* renamed from: a, reason: collision with root package name */
    private static final InterfaceC1194da f12814a = new W();

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1194da f12815b;

    public V() {
        this(new X(J.a(), a()));
    }

    private V(InterfaceC1194da interfaceC1194da) {
        zzci.zza(interfaceC1194da, "messageInfoFactory");
        this.f12815b = interfaceC1194da;
    }

    private static InterfaceC1194da a() {
        try {
            return (InterfaceC1194da) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f12814a;
        }
    }

    private static boolean a(InterfaceC1192ca interfaceC1192ca) {
        return interfaceC1192ca.a() == zzcg.zzg.zzkl;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1220qa
    public final <T> InterfaceC1218pa<T> a(Class<T> cls) {
        C1221ra.a((Class<?>) cls);
        InterfaceC1192ca a2 = this.f12815b.a(cls);
        return a2.zzcg() ? zzcg.class.isAssignableFrom(cls) ? C1200ga.a(C1221ra.c(), E.a(), a2.zzch()) : C1200ga.a(C1221ra.a(), E.b(), a2.zzch()) : zzcg.class.isAssignableFrom(cls) ? a(a2) ? C1198fa.a(cls, a2, C1206ja.b(), O.b(), C1221ra.c(), E.a(), C1190ba.b()) : C1198fa.a(cls, a2, C1206ja.b(), O.b(), C1221ra.c(), (B<?>) null, C1190ba.b()) : a(a2) ? C1198fa.a(cls, a2, C1206ja.a(), O.a(), C1221ra.a(), E.b(), C1190ba.a()) : C1198fa.a(cls, a2, C1206ja.a(), O.a(), C1221ra.b(), (B<?>) null, C1190ba.a());
    }
}
