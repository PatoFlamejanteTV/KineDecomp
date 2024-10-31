package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;

/* loaded from: classes2.dex */
final class Rh implements InterfaceC0945ii {

    /* renamed from: a, reason: collision with root package name */
    private static final Rh f11812a = new Rh();

    private Rh() {
    }

    public static Rh a() {
        return f11812a;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0945ii
    public final InterfaceC0932hi b(Class<?> cls) {
        if (!zzbrd.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (InterfaceC0932hi) zzbrd.zzd(cls.asSubclass(zzbrd.class)).zza(zzbrd.zze.zzfqd, (Object) null, (Object) null);
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0945ii
    public final boolean a(Class<?> cls) {
        return zzbrd.class.isAssignableFrom(cls);
    }
}
