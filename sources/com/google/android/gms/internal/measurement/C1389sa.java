package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzuo;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.measurement.sa */
/* loaded from: classes2.dex */
final class C1389sa extends AbstractC1387ra<Object> {
    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final boolean a(zzvv zzvvVar) {
        return zzvvVar instanceof zzuo.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final C1393ua<Object> b(Object obj) {
        zzuo.zzc zzcVar = (zzuo.zzc) obj;
        if (zzcVar.zzbyj.c()) {
            zzcVar.zzbyj = (C1393ua) zzcVar.zzbyj.clone();
        }
        return zzcVar.zzbyj;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final void c(Object obj) {
        a(obj).f();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final C1393ua<Object> a(Object obj) {
        return ((zzuo.zzc) obj).zzbyj;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final <UT, UB> UB a(InterfaceC1350bb interfaceC1350bb, Object obj, zzub zzubVar, C1393ua<Object> c1393ua, UB ub, tb<UT, UB> tbVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final void a(Fb fb, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final Object a(zzub zzubVar, zzvv zzvvVar, int i) {
        return zzubVar.zza(zzvvVar, i);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final void a(InterfaceC1350bb interfaceC1350bb, Object obj, zzub zzubVar, C1393ua<Object> c1393ua) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1387ra
    public final void a(zzte zzteVar, Object obj, zzub zzubVar, C1393ua<Object> c1393ua) throws IOException {
        throw new NoSuchMethodError();
    }
}
