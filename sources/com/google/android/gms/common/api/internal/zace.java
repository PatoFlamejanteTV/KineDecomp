package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.util.Set;

/* loaded from: classes.dex */
public final class zace extends com.google.android.gms.signin.internal.zac implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private static Api.AbstractClientBuilder<? extends zad, SignInOptions> f10908a = com.google.android.gms.signin.zaa.f14143c;

    /* renamed from: b, reason: collision with root package name */
    private final Context f10909b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f10910c;

    /* renamed from: d, reason: collision with root package name */
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> f10911d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Scope> f10912e;

    /* renamed from: f, reason: collision with root package name */
    private ClientSettings f10913f;

    /* renamed from: g, reason: collision with root package name */
    private zad f10914g;

    /* renamed from: h, reason: collision with root package name */
    private zach f10915h;

    public zace(Context context, Handler handler, ClientSettings clientSettings) {
        this(context, handler, clientSettings, f10908a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(com.google.android.gms.signin.internal.zaj zajVar) {
        ConnectionResult a2 = zajVar.a();
        if (a2.R()) {
            ResolveAccountResponse O = zajVar.O();
            ConnectionResult O2 = O.O();
            if (!O2.R()) {
                String valueOf = String.valueOf(O2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                sb.append("Sign-in succeeded with resolve account failure: ");
                sb.append(valueOf);
                Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                this.f10915h.b(O2);
                this.f10914g.disconnect();
                return;
            }
            this.f10915h.a(O.a(), this.f10912e);
        } else {
            this.f10915h.b(a2);
        }
        this.f10914g.disconnect();
    }

    public final void a(zach zachVar) {
        zad zadVar = this.f10914g;
        if (zadVar != null) {
            zadVar.disconnect();
        }
        this.f10913f.a(Integer.valueOf(System.identityHashCode(this)));
        Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder = this.f10911d;
        Context context = this.f10909b;
        Looper looper = this.f10910c.getLooper();
        ClientSettings clientSettings = this.f10913f;
        this.f10914g = abstractClientBuilder.a(context, looper, clientSettings, clientSettings.j(), this, this);
        this.f10915h = zachVar;
        Set<Scope> set = this.f10912e;
        if (set != null && !set.isEmpty()) {
            this.f10914g.connect();
        } else {
            this.f10910c.post(new F(this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f10914g.a(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f10915h.b(connectionResult);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        this.f10914g.disconnect();
    }

    public final zad v() {
        return this.f10914g;
    }

    public final void w() {
        zad zadVar = this.f10914g;
        if (zadVar != null) {
            zadVar.disconnect();
        }
    }

    public zace(Context context, Handler handler, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        this.f10909b = context;
        this.f10910c = handler;
        Preconditions.a(clientSettings, "ClientSettings must not be null");
        this.f10913f = clientSettings;
        this.f10912e = clientSettings.i();
        this.f10911d = abstractClientBuilder;
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zad
    public final void a(com.google.android.gms.signin.internal.zaj zajVar) {
        this.f10910c.post(new G(this, zajVar));
    }
}
