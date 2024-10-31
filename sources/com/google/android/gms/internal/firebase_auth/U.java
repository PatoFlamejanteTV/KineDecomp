package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class U implements T {
    @Override // com.google.android.gms.internal.firebase_auth.T
    public final Object a(Object obj) {
        return zzgw.zzih().zzii();
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final Object b(Object obj) {
        ((zzgw) obj).zzev();
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final Map<?, ?> zzj(Object obj) {
        return (zzgw) obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final Map<?, ?> zzk(Object obj) {
        return (zzgw) obj;
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final boolean zzl(Object obj) {
        return !((zzgw) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final S<?, ?> zzo(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final Object a(Object obj, Object obj2) {
        zzgw zzgwVar = (zzgw) obj;
        zzgw zzgwVar2 = (zzgw) obj2;
        if (!zzgwVar2.isEmpty()) {
            if (!zzgwVar.isMutable()) {
                zzgwVar = zzgwVar.zzii();
            }
            zzgwVar.zza(zzgwVar2);
        }
        return zzgwVar;
    }

    @Override // com.google.android.gms.internal.firebase_auth.T
    public final int a(int i, Object obj, Object obj2) {
        zzgw zzgwVar = (zzgw) obj;
        if (zzgwVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgwVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
