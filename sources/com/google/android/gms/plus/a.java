package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzna;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;

/* loaded from: classes.dex */
final class a extends Api.zza<zze, Plus.PlusOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public zze zza(Context context, Looper looper, zzf zzfVar, Plus.PlusOptions plusOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (plusOptions == null) {
            plusOptions = new Plus.PlusOptions(null);
        }
        return new zze(context, looper, zzfVar, new PlusSession(zzfVar.c().name, zzna.zzc(zzfVar.f()), (String[]) plusOptions.b.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.Api.zza
    public int getPriority() {
        return 2;
    }
}
