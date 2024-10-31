package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzqm;
import java.util.List;

/* loaded from: classes.dex */
public class zzqo extends com.google.android.gms.common.internal.zzj<zzqm> {
    private final Context mContext;

    public zzqo(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
    }

    private String zzmi() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null) {
                return (String) bundle.get("com.google.android.safetynet.API_KEY");
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public void zza(zzql zzqlVar, List<Integer> list, int i, String str) throws RemoteException {
        int[] iArr = new int[list.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                zzpc().zza(zzqlVar, zzmi(), iArr, i, str);
                return;
            } else {
                iArr[i3] = list.get(i3).intValue();
                i2 = i3 + 1;
            }
        }
    }

    public void zza(zzql zzqlVar, byte[] bArr) throws RemoteException {
        zzpc().zza(zzqlVar, bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzdI, reason: merged with bridge method [inline-methods] */
    public zzqm zzW(IBinder iBinder) {
        return zzqm.zza.zzdH(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.safetynet.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }
}
