package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.pd, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1038pd extends zzaxv {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzaxk f12423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1038pd(zzaxk zzaxkVar) {
        this.f12423a = zzaxkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        Context context;
        zzbbi zzbbiVar;
        Object obj;
        zzaaq zzaaqVar;
        context = this.f12423a.mContext;
        zzbbiVar = this.f12423a.zzbob;
        zzaap zzaapVar = new zzaap(context, zzbbiVar.zzdp);
        obj = this.f12423a.mLock;
        synchronized (obj) {
            try {
                com.google.android.gms.ads.internal.zzbv.n();
                zzaaqVar = this.f12423a.zzeix;
                zzaas.zza(zzaaqVar, zzaapVar);
            } catch (IllegalArgumentException e2) {
                zzbbd.zzc("Cannot config CSI reporter.", e2);
            }
        }
    }
}
