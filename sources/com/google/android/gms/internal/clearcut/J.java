package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;

/* loaded from: classes2.dex */
final class J implements InterfaceC1194da {

    /* renamed from: a, reason: collision with root package name */
    private static final J f12783a = new J();

    private J() {
    }

    public static J a() {
        return f12783a;
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1194da
    public final InterfaceC1192ca a(Class<?> cls) {
        if (!zzcg.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (InterfaceC1192ca) zzcg.zzc(cls.asSubclass(zzcg.class)).zza(zzcg.zzg.zzkf, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.InterfaceC1194da
    public final boolean b(Class<?> cls) {
        return zzcg.class.isAssignableFrom(cls);
    }
}
