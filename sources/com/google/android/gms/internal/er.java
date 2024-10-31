package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzju;

/* loaded from: classes.dex */
public class er extends zzju.c<Status> {

    /* renamed from: a */
    final /* synthetic */ String f1537a;
    final /* synthetic */ UsageInfo[] b;
    final /* synthetic */ zzju c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public er(zzju zzjuVar, GoogleApiClient googleApiClient, String str, UsageInfo[] usageInfoArr) {
        super(googleApiClient);
        this.c = zzjuVar;
        this.f1537a = str;
        this.b = usageInfoArr;
    }

    @Override // com.google.android.gms.internal.zzju.b
    protected void a(zzjp zzjpVar) throws RemoteException {
        zzjpVar.zza(new zzju.d(this), this.f1537a, this.b);
    }
}
