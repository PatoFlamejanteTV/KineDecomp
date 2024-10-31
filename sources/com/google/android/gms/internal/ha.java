package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.internal.zznt;

/* loaded from: classes.dex */
class ha extends zznt.zza {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ gz f1592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ha(gz gzVar) {
        this.f1592a = gzVar;
    }

    @Override // com.google.android.gms.internal.zznt
    public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
        this.f1592a.zzb((gz) dailyTotalResult);
    }
}
