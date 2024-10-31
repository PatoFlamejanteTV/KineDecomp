package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Bb implements zzbip<Object, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzamy f11397a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzalm f11398b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bb(zzanm zzanmVar, zzamy zzamyVar, zzalm zzalmVar) {
        this.f11397a = zzamyVar;
        this.f11398b = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbip
    public final void zzbw(String str) {
        try {
            this.f11397a.zzcu(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }
}
