package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzft;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase_auth.x */
/* loaded from: classes2.dex */
final class C1283x extends AbstractC1281w<Object> {
    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final boolean a(zzhc zzhcVar) {
        return zzhcVar instanceof zzft.zzc;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final C1287z<Object> b(Object obj) {
        zzft.zzc zzcVar = (zzft.zzc) obj;
        if (zzcVar.zzxe.c()) {
            zzcVar.zzxe = (C1287z) zzcVar.zzxe.clone();
        }
        return zzcVar.zzxe;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final void c(Object obj) {
        a(obj).f();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final C1287z<Object> a(Object obj) {
        return ((zzft.zzc) obj).zzxe;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final <UT, UB> UB a(InterfaceC1255ia interfaceC1255ia, Object obj, zzfg zzfgVar, C1287z<Object> c1287z, UB ub, Fa<UT, UB> fa) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final void a(Ra ra, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final Object a(zzfg zzfgVar, zzhc zzhcVar, int i) {
        return zzfgVar.zza(zzhcVar, i);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final void a(InterfaceC1255ia interfaceC1255ia, Object obj, zzfg zzfgVar, C1287z<Object> c1287z) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1281w
    public final void a(zzeh zzehVar, Object obj, zzfg zzfgVar, C1287z<Object> c1287z) throws IOException {
        throw new NoSuchMethodError();
    }
}
