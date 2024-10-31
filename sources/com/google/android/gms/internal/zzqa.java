package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzpy;

/* loaded from: classes2.dex */
public class zzqa extends com.google.android.gms.common.internal.zzj<zzpy> {
    public zzqa(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 3, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdy, reason: merged with bridge method [inline-methods] */
    public zzpy zzW(IBinder iBinder) {
        return zzpy.zza.zzdx(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.panorama.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.panorama.internal.IPanoramaService";
    }
}
