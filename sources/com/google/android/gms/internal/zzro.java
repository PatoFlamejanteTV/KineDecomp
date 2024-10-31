package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzrj;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class zzro extends com.google.android.gms.common.internal.zzj<zzrj> {
    private final Context mContext;
    private final int mTheme;
    private final String zzRs;
    private final int zzbdL;

    /* loaded from: classes.dex */
    private static class a extends zzrm.zza {
        private a() {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(int i, boolean z, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(Status status, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(Status status, GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zza(Status status, GetInstrumentsResponse getInstrumentsResponse, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zzb(int i, boolean z, Bundle bundle) {
        }

        @Override // com.google.android.gms.internal.zzrm
        public void zzj(int i, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    static final class b extends a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<Activity> f1831a;
        private final int b;

        public b(Context context, int i) {
            super();
            this.f1831a = new WeakReference<>((Activity) context);
            this.b = i;
        }

        @Override // com.google.android.gms.internal.zzro.a, com.google.android.gms.internal.zzrm
        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            Activity activity = this.f1831a.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.a()) {
                try {
                    connectionResult.a(activity, this.b);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Intent intent = new Intent();
            if (connectionResult.b()) {
                i2 = -1;
                intent.putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", fullWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.b, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        @Override // com.google.android.gms.internal.zzro.a, com.google.android.gms.internal.zzrm
        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            Activity activity = this.f1831a.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, bundle != null ? (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT") : null);
            if (connectionResult.a()) {
                try {
                    connectionResult.a(activity, this.b);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Intent intent = new Intent();
            if (connectionResult.b()) {
                i2 = -1;
                intent.putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", maskedWallet);
            } else {
                i2 = i == 408 ? 0 : 1;
                intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", i);
            }
            PendingIntent createPendingResult = activity.createPendingResult(this.b, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                return;
            }
            try {
                createPendingResult.send(i2);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }

        @Override // com.google.android.gms.internal.zzro.a, com.google.android.gms.internal.zzrm
        public void zza(int i, boolean z, Bundle bundle) {
            Activity activity = this.f1831a.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", z);
            PendingIntent createPendingResult = activity.createPendingResult(this.b, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        @Override // com.google.android.gms.internal.zzro.a, com.google.android.gms.internal.zzrm
        public void zzb(int i, boolean z, Bundle bundle) {
            Activity activity = this.f1831a.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("com.google.android.gms.wallet.EXTRA_IS_NEW_USER", z);
            PendingIntent createPendingResult = activity.createPendingResult(this.b, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (PendingIntent.CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        @Override // com.google.android.gms.internal.zzro.a, com.google.android.gms.internal.zzrm
        public void zzj(int i, Bundle bundle) {
            com.google.android.gms.common.internal.zzx.a(bundle, "Bundle should not be null");
            Activity activity = this.f1831a.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.a()) {
                try {
                    connectionResult.a(activity, this.b);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                    return;
                }
            }
            Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
            Intent intent = new Intent();
            intent.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
            PendingIntent createPendingResult = activity.createPendingResult(this.b, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                return;
            }
            try {
                createPendingResult.send(1);
            } catch (PendingIntent.CanceledException e2) {
                Log.w("WalletClientImpl", "Exception setting pending result", e2);
            }
        }
    }

    public zzro(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, int i, int i2) {
        super(context, looper, 4, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzbdL = i;
        this.zzRs = zzfVar.a();
        this.mTheme = i2;
    }

    private Bundle zzEG() {
        return zza(this.zzbdL, this.mContext.getPackageName(), this.zzRs, this.mTheme);
    }

    public static Bundle zza(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, "com.google"));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    public void zza(FullWalletRequest fullWalletRequest, int i) {
        b bVar = new b(this.mContext, i);
        try {
            zzpc().zza(fullWalletRequest, zzEG(), bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            bVar.zza(8, (FullWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle zzEG = zzEG();
        b bVar = new b(this.mContext, i);
        try {
            zzpc().zza(maskedWalletRequest, zzEG, bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            bVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            zzpc().zza(notifyTransactionStatusRequest, zzEG());
        } catch (RemoteException e) {
        }
    }

    public void zze(String str, String str2, int i) {
        Bundle zzEG = zzEG();
        b bVar = new b(this.mContext, i);
        try {
            zzpc().zza(str, str2, zzEG, bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            bVar.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: zzeb, reason: merged with bridge method [inline-methods] */
    public zzrj zzW(IBinder iBinder) {
        return zzrj.zza.zzdX(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void zzkA(int i) {
        Bundle zzEG = zzEG();
        b bVar = new b(this.mContext, i);
        try {
            zzpc().zzb(zzEG, bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            bVar.zzb(8, false, Bundle.EMPTY);
        }
    }

    public void zzkz(int i) {
        Bundle zzEG = zzEG();
        b bVar = new b(this.mContext, i);
        try {
            zzpc().zza(zzEG, bVar);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            bVar.zza(8, false, Bundle.EMPTY);
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public boolean zzpe() {
        return true;
    }
}
