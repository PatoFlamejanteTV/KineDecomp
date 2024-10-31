package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrd;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
final class Kh extends Jh<Object> {
    @Override // com.google.android.gms.internal.ads.Jh
    public final boolean a(zzbsl zzbslVar) {
        return zzbslVar instanceof zzbrd.zzc;
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final Mh<Object> b(Object obj) {
        Mh<Object> a2 = a(obj);
        if (!a2.c()) {
            return a2;
        }
        Mh<Object> mh = (Mh) a2.clone();
        a(obj, mh);
        return mh;
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final void c(Object obj) {
        a(obj).f();
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final Mh<Object> a(Object obj) {
        return ((zzbrd.zzc) obj).zzfqa;
    }

    final void a(Object obj, Mh<Object> mh) {
        ((zzbrd.zzc) obj).zzfqa = mh;
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final <UT, UB> UB a(InterfaceC1098ti interfaceC1098ti, Object obj, zzbqq zzbqqVar, Mh<Object> mh, UB ub, Li<UT, UB> li) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final void a(Xi xi, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final Object a(zzbqq zzbqqVar, zzbsl zzbslVar, int i) {
        return zzbqqVar.zza(zzbslVar, i);
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final void a(InterfaceC1098ti interfaceC1098ti, Object obj, zzbqq zzbqqVar, Mh<Object> mh) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.Jh
    public final void a(zzbpu zzbpuVar, Object obj, zzbqq zzbqqVar, Mh<Object> mh) throws IOException {
        throw new NoSuchMethodError();
    }
}
