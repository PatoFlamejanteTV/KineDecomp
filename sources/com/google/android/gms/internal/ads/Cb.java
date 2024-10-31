package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Cb implements zzbip<zzbiq, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzana f11435a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzalm f11436b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzanm f11437c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cb(zzanm zzanmVar, zzana zzanaVar, zzalm zzalmVar) {
        this.f11437c = zzanmVar;
        this.f11435a = zzanaVar;
        this.f11436b = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbip
    public final void zzbw(String str) {
        try {
            this.f11435a.zzcu(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }
}
