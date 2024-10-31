package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.zzj;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zze extends com.google.android.gms.common.internal.zzj<zzj> {

    /* renamed from: a, reason: collision with root package name */
    final int f638a;

    public zze(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i) {
        super(context, looper, 8, com.google.android.gms.common.internal.zzf.a(context), connectionCallbacks, onConnectionFailedListener);
        this.f638a = i;
    }

    public zzj a() throws DeadObjectException {
        return (zzj) super.zzpc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zzj zzW(IBinder iBinder) {
        return zzj.zza.zzX(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.ads.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }
}
