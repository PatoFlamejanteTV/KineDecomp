package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* renamed from: com.google.android.gms.internal.ads.xb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class RunnableC1147xb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AdRequest.ErrorCode f12651a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzamj f12652b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1147xb(zzamj zzamjVar, AdRequest.ErrorCode errorCode) {
        this.f12652b = zzamjVar;
        this.f12651a = errorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzalm zzalmVar;
        try {
            zzalmVar = this.f12652b.zzdnz;
            zzalmVar.onAdFailedToLoad(zzamv.zza(this.f12651a));
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }
}
