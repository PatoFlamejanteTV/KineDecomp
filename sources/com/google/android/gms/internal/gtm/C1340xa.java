package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;

/* renamed from: com.google.android.gms.internal.gtm.xa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1340xa implements Pa {

    /* renamed from: a, reason: collision with root package name */
    private static final C1340xa f13320a = new C1340xa();

    private C1340xa() {
    }

    public static C1340xa a() {
        return f13320a;
    }

    @Override // com.google.android.gms.internal.gtm.Pa
    public final Oa b(Class<?> cls) {
        if (!zzrc.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (Oa) zzrc.zzg(cls.asSubclass(zzrc.class)).zza(zzrc.zze.zzbat, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.Pa
    public final boolean a(Class<?> cls) {
        return zzrc.class.isAssignableFrom(cls);
    }
}
