package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInOptions;

@KeepForSdk
/* loaded from: classes2.dex */
public class SignInClientImpl extends GmsClient<zaf> implements com.google.android.gms.signin.zad {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f14130a;

    /* renamed from: b, reason: collision with root package name */
    private final Bundle f14131b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f14132c;
    private final ClientSettings zaet;

    private SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f14130a = true;
        this.zaet = clientSettings;
        this.f14131b = bundle;
        this.f14132c = clientSettings.e();
    }

    @Override // com.google.android.gms.signin.zad
    public final void a(IAccountAccessor iAccountAccessor, boolean z) {
        try {
            ((zaf) getService()).a(iAccountAccessor, this.f14132c.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void b() {
        try {
            ((zaf) getService()).a(this.f14132c.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void connect() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zag(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.zaet.h())) {
            this.f14131b.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zaet.h());
        }
        return this.f14131b;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return this.f14130a;
    }

    @Override // com.google.android.gms.signin.zad
    public final void a(zad zadVar) {
        Preconditions.a(zadVar, "Expecting a valid ISignInCallbacks");
        try {
            Account c2 = this.zaet.c();
            ((zaf) getService()).a(new zah(new ResolveAccountRequest(c2, this.f14132c.intValue(), BaseGmsClient.DEFAULT_ACCOUNT.equals(c2.name) ? Storage.a(getContext()).b() : null)), zadVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zadVar.a(new zaj(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, true, clientSettings, a(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }

    @KeepForSdk
    public static Bundle a(ClientSettings clientSettings) {
        SignInOptions j = clientSettings.j();
        Integer e2 = clientSettings.e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", clientSettings.a());
        if (e2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", e2.intValue());
        }
        if (j != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", j.g());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", j.f());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", j.d());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", j.e());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", j.b());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", j.h());
            if (j.a() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", j.a().longValue());
            }
            if (j.c() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", j.c().longValue());
            }
        }
        return bundle;
    }
}
