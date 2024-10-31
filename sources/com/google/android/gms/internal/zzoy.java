package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.identity.intents.UserAddressRequest;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zzpa;

/* loaded from: classes.dex */
public class zzoy extends com.google.android.gms.common.internal.zzj<zzpa> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzRs;
    private zza zzaDj;

    /* loaded from: classes.dex */
    public static final class zza extends zzoz.zza {
        private Activity mActivity;
        private final int zzaaY;

        public zza(int i, Activity activity) {
            this.zzaaY = i;
            this.mActivity = activity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        @Override // com.google.android.gms.internal.zzoz
        public void zzh(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.mActivity.createPendingResult(this.zzaaY, intent, 1073741824);
                if (createPendingResult == null) {
                    return;
                }
                try {
                    createPendingResult.send(1);
                    return;
                } catch (PendingIntent.CanceledException e) {
                    Log.w("AddressClientImpl", "Exception settng pending result", e);
                    return;
                }
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.a()) {
                try {
                    connectionResult.a(this.mActivity, this.zzaaY);
                    return;
                } catch (IntentSender.SendIntentException e2) {
                    Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    return;
                }
            }
            try {
                PendingIntent createPendingResult2 = this.mActivity.createPendingResult(this.zzaaY, new Intent(), 1073741824);
                if (createPendingResult2 != null) {
                    createPendingResult2.send(1);
                }
            } catch (PendingIntent.CanceledException e3) {
                Log.w("AddressClientImpl", "Exception setting pending result", e3);
            }
        }
    }

    public zzoy(Activity activity, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.zzRs = zzfVar.a();
        this.mActivity = activity;
        this.mTheme = i;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        super.disconnect();
        if (this.zzaDj != null) {
            this.zzaDj.setActivity(null);
            this.zzaDj = null;
        }
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzwk();
        this.zzaDj = new zza(i, this.mActivity);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzRs)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzRs, "com.google"));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzwj().zza(this.zzaDj, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("com.google.android.gms.identity.intents.EXTRA_ERROR_CODE", 555);
            this.zzaDj.zzh(1, bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzbS, reason: merged with bridge method [inline-methods] */
    public zzpa zzW(IBinder iBinder) {
        return zzpa.zza.zzbU(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.identity.service.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzpe() {
        return true;
    }

    protected zzpa zzwj() throws DeadObjectException {
        return (zzpa) super.zzpc();
    }

    protected void zzwk() {
        super.zzpb();
    }
}
