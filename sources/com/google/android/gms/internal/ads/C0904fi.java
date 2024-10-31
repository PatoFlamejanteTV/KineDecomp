package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.fi */
/* loaded from: classes2.dex */
final class C0904fi implements InterfaceC0890ei {
    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final int a(int i, Object obj, Object obj2) {
        zzbsf zzbsfVar = (zzbsf) obj;
        if (zzbsfVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzbsfVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final boolean b(Object obj) {
        return !((zzbsf) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final Object d(Object obj) {
        return zzbsf.zzant().zzanu();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final C0876di<?, ?> e(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final Object f(Object obj) {
        ((zzbsf) obj).zzakj();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final Map<?, ?> g(Object obj) {
        return (zzbsf) obj;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final Map<?, ?> h(Object obj) {
        return (zzbsf) obj;
    }

    @Override // com.google.android.gms.internal.ads.InterfaceC0890ei
    public final Object b(Object obj, Object obj2) {
        zzbsf zzbsfVar = (zzbsf) obj;
        zzbsf zzbsfVar2 = (zzbsf) obj2;
        if (!zzbsfVar2.isEmpty()) {
            if (!zzbsfVar.isMutable()) {
                zzbsfVar = zzbsfVar.zzanu();
            }
            zzbsfVar.zza(zzbsfVar2);
        }
        return zzbsfVar;
    }
}
