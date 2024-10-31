package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzjp;

/* loaded from: classes.dex */
public class zzjs extends com.google.android.gms.common.internal.zzj<zzjp> {
    public zzjs(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 19, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzai, reason: merged with bridge method [inline-methods] */
    public zzjp zzW(IBinder iBinder) {
        return zzjp.zza.zzag(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzjp zzlw() throws DeadObjectException {
        return zzpc();
    }
}
