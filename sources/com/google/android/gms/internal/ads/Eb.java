package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* loaded from: classes2.dex */
final class Eb implements zzbip<UnifiedNativeAdMapper, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzanc f11482a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzalm f11483b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Eb(zzanm zzanmVar, zzanc zzancVar, zzalm zzalmVar) {
        this.f11482a = zzancVar;
        this.f11483b = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbip
    public final void zzbw(String str) {
        try {
            this.f11482a.zzcu(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }
}
