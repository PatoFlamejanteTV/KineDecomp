package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;

/* loaded from: classes2.dex */
final class E implements X {

    /* renamed from: a, reason: collision with root package name */
    private static final E f12960a = new E();

    private E() {
    }

    public static E a() {
        return f12960a;
    }

    @Override // com.google.android.gms.internal.firebase_auth.X
    public final W b(Class<?> cls) {
        if (!zzft.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (W) zzft.zzd(cls.asSubclass(zzft.class)).zza(zzft.zze.zzxh, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.X
    public final boolean a(Class<?> cls) {
        return zzft.class.isAssignableFrom(cls);
    }
}
