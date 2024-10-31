package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqr;

/* loaded from: classes.dex */
public class zzqs extends com.google.android.gms.common.internal.zzj<zzqr> {
    public zzqs(Context context, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzf zzfVar) {
        super(context, context.getMainLooper(), 73, zzfVar, connectionCallbacks, onConnectionFailedListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdL, reason: merged with bridge method [inline-methods] */
    public zzqr zzW(IBinder iBinder) {
        return zzqr.zza.zzdK(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
