package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqx;
import com.google.android.gms.signin.internal.zzd;
import com.google.android.gms.signin.internal.zzf;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class zzi extends zzj<zzf> implements zzqw {

    /* renamed from: a */
    private final boolean f2200a;
    private final com.google.android.gms.common.internal.zzf b;
    private final zzqx c;
    private Integer d;
    private final ExecutorService e;

    /* loaded from: classes.dex */
    public static class a extends zzd.zza {

        /* renamed from: a */
        private final zzqx f2201a;
        private final ExecutorService b;

        public a(zzqx zzqxVar, ExecutorService executorService) {
            this.f2201a = zzqxVar;
            this.b = executorService;
        }

        public GoogleApiClient.ServerAuthCodeCallbacks a() throws RemoteException {
            return this.f2201a.zzCg();
        }

        @Override // com.google.android.gms.signin.internal.zzd
        public void a(String str, String str2, zzf zzfVar) throws RemoteException {
            this.b.submit(new b(this, str, str2, zzfVar));
        }

        @Override // com.google.android.gms.signin.internal.zzd
        public void a(String str, List<Scope> list, zzf zzfVar) throws RemoteException {
            this.b.submit(new com.google.android.gms.signin.internal.a(this, list, str, zzfVar));
        }
    }

    public zzi(Context context, Looper looper, boolean z, com.google.android.gms.common.internal.zzf zzfVar, zzqx zzqxVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        super(context, looper, 44, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f2200a = z;
        this.b = zzfVar;
        this.c = zzqxVar;
        this.d = zzfVar.l();
        this.e = executorService;
    }

    public static Bundle a(zzqx zzqxVar, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzqxVar.zzCf());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzqxVar.zzlY());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzqxVar.zzmb());
        if (zzqxVar.zzCg() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a(zzqxVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", zzqxVar.zzCh());
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzqxVar.zzma());
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a */
    public zzf zzW(IBinder iBinder) {
        return zzf.zza.a(iBinder);
    }

    @Override // com.google.android.gms.internal.zzqw
    public void connect() {
        zza(new zzj.zzf());
    }

    @Override // com.google.android.gms.internal.zzqw
    public void zzCe() {
        try {
            zzpc().a(this.d.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.internal.zzqw
    public void zza(zzp zzpVar, Set<Scope> set, zze zzeVar) {
        zzx.a(zzeVar, "Expecting a valid ISignInCallbacks");
        try {
            zzpc().a(new AuthAccountRequest(zzpVar, set), zzeVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                zzeVar.a(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqw
    public void zza(zzp zzpVar, boolean z) {
        try {
            zzpc().a(zzpVar, this.d.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.internal.zzqw
    public void zza(zzt zztVar) {
        zzx.a(zztVar, "Expecting a valid IResolveAccountCallbacks");
        try {
            zzpc().a(new ResolveAccountRequest(this.b.c(), this.d.intValue()), zztVar);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                zztVar.a(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return this.f2200a;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        Bundle a2 = a(this.c, this.b.l(), this.e);
        if (!getContext().getPackageName().equals(this.b.h())) {
            a2.putString("com.google.android.gms.signin.internal.realClientPackageName", this.b.h());
        }
        return a2;
    }
}
