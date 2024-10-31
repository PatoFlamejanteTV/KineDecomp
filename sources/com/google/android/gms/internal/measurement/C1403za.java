package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;

/* renamed from: com.google.android.gms.internal.measurement.za, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1403za implements Ra {

    /* renamed from: a, reason: collision with root package name */
    private static final C1403za f13569a = new C1403za();

    private C1403za() {
    }

    public static C1403za a() {
        return f13569a;
    }

    @Override // com.google.android.gms.internal.measurement.Ra
    public final Qa b(Class<?> cls) {
        if (!zzuo.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (Qa) zzuo.zzg(cls.asSubclass(zzuo.class)).zza(zzuo.zze.zzbym, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.Ra
    public final boolean a(Class<?> cls) {
        return zzuo.class.isAssignableFrom(cls);
    }
}
