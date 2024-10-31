package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes2.dex */
final class Db implements zzbip<zzbir, Object> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzane f11455a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzalm f11456b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzanm f11457c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Db(zzanm zzanmVar, zzane zzaneVar, zzalm zzalmVar) {
        this.f11457c = zzanmVar;
        this.f11455a = zzaneVar;
        this.f11456b = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbip
    public final void zzbw(String str) {
        try {
            this.f11455a.zzcu(str);
        } catch (RemoteException e2) {
            zzbbd.zzb("", e2);
        }
    }
}
