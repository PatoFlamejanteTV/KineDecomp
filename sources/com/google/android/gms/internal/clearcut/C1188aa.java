package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.clearcut.aa */
/* loaded from: classes2.dex */
final class C1188aa implements Z {
    @Override // com.google.android.gms.internal.clearcut.Z
    public final int a(int i, Object obj, Object obj2) {
        zzdi zzdiVar = (zzdi) obj;
        if (zzdiVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzdiVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Object a(Object obj, Object obj2) {
        zzdi zzdiVar = (zzdi) obj;
        zzdi zzdiVar2 = (zzdi) obj2;
        if (!zzdiVar2.isEmpty()) {
            if (!zzdiVar.isMutable()) {
                zzdiVar = zzdiVar.zzca();
            }
            zzdiVar.zza(zzdiVar2);
        }
        return zzdiVar;
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final boolean a(Object obj) {
        return !((zzdi) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Map<?, ?> b(Object obj) {
        return (zzdi) obj;
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Map<?, ?> zzh(Object obj) {
        return (zzdi) obj;
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Object zzj(Object obj) {
        ((zzdi) obj).zzv();
        return obj;
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Object zzk(Object obj) {
        return zzdi.zzbz().zzca();
    }

    @Override // com.google.android.gms.internal.clearcut.Z
    public final Y<?, ?> zzl(Object obj) {
        throw new NoSuchMethodError();
    }
}
