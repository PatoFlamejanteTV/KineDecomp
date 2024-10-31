package com.google.android.gms.internal.config;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
final class e extends h {
    private final /* synthetic */ zzi t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(zzo zzoVar, GoogleApiClient googleApiClient, zzi zziVar) {
        super(googleApiClient);
        this.t = zziVar;
    }

    @Override // com.google.android.gms.internal.config.g
    protected final void a(Context context, zzah zzahVar) throws RemoteException {
        String str;
        String str2;
        DataHolder.Builder a2 = DataBufferSafeParcelable.a();
        for (Map.Entry<String, String> entry : this.t.zzc().entrySet()) {
            DataBufferSafeParcelable.a(a2, new zzz(entry.getKey(), entry.getValue()));
        }
        DataHolder a3 = a2.a(0);
        try {
            str = FirebaseInstanceId.b().a();
            try {
                str2 = FirebaseInstanceId.b().d();
            } catch (IllegalStateException e2) {
                e = e2;
                if (Log.isLoggable("ConfigApiImpl", 3)) {
                    Log.d("ConfigApiImpl", "Cannot retrieve instanceId or instanceIdToken.", e);
                }
                str2 = null;
                zzahVar.zza(this.s, new zzab(context.getPackageName(), this.t.zzb(), a3, this.t.getGmpAppId(), str, str2, null, this.t.zzd(), zzn.zzb(context), this.t.zze(), this.t.zzf()));
            }
        } catch (IllegalStateException e3) {
            e = e3;
            str = null;
        }
        try {
            zzahVar.zza(this.s, new zzab(context.getPackageName(), this.t.zzb(), a3, this.t.getGmpAppId(), str, str2, null, this.t.zzd(), zzn.zzb(context), this.t.zze(), this.t.zzf()));
        } finally {
            a3.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ Result a(Status status) {
        return new zzu(status, new HashMap());
    }
}
