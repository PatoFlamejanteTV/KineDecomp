package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class Rd<T> implements zzbbl<Throwable, T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzazy f11801a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rd(zzazs zzazsVar, zzazy zzazyVar) {
        this.f11801a = zzazyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final /* synthetic */ zzbcb zzf(Throwable th) throws Exception {
        Throwable th2 = th;
        zzbbd.zzb("Error occurred while dispatching http response in getter.", th2);
        com.google.android.gms.ads.internal.zzbv.i().zza(th2, "HttpGetter.deliverResponse.1");
        return zzbbq.zzm(this.f11801a.zzwf());
    }
}
