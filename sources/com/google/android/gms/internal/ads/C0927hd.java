package com.google.android.gms.internal.ads;

import java.util.List;

/* renamed from: com.google.android.gms.internal.ads.hd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0927hd implements zzbbn<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbcb f12190a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0927hd(zzawg zzawgVar, zzbcb zzbcbVar) {
        this.f12190a = zzbcbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final void zzb(Throwable th) {
        List list;
        list = zzawg.zzefp;
        list.remove(this.f12190a);
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final /* synthetic */ void zzl(Void r2) {
        List list;
        list = zzawg.zzefp;
        list.remove(this.f12190a);
    }
}
