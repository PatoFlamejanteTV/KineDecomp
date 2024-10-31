package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.gtm.qa */
/* loaded from: classes2.dex */
final class C1327qa extends AbstractC1325pa<Object> {
    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final boolean a(zzsk zzskVar) {
        return zzskVar instanceof zzrc.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final C1330sa<Object> b(Object obj) {
        zzrc.zzc zzcVar = (zzrc.zzc) obj;
        if (zzcVar.zzbaq.b()) {
            zzcVar.zzbaq = (C1330sa) zzcVar.zzbaq.clone();
        }
        return zzcVar.zzbaq;
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final void c(Object obj) {
        a(obj).e();
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final C1330sa<Object> a(Object obj) {
        return ((zzrc.zzc) obj).zzbaq;
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final <UT, UB> UB a(Za za, Object obj, zzqp zzqpVar, C1330sa<Object> c1330sa, UB ub, qb<UT, UB> qbVar) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final void a(Cb cb, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final Object a(zzqp zzqpVar, zzsk zzskVar, int i) {
        return zzqpVar.zza(zzskVar, i);
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final void a(Za za, Object obj, zzqp zzqpVar, C1330sa<Object> c1330sa) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.AbstractC1325pa
    public final void a(zzps zzpsVar, Object obj, zzqp zzqpVar, C1330sa<Object> c1330sa) throws IOException {
        throw new NoSuchMethodError();
    }
}
