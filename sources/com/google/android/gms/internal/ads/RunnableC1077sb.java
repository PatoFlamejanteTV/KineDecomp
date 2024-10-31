package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.ads.sb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1077sb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdRequest.ErrorCode f12510a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamj f12511b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1077sb(zzamj zzamjVar, AdRequest.ErrorCode errorCode) {
        this.f12511b = zzamjVar;
        this.f12510a = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12511b.zzdnz;
            zzalmVar.onAdFailedToLoad(zzamv.zza(this.f12510a));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
