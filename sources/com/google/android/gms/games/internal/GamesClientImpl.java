package com.google.android.gms.games.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.IGamesService;
import com.google.android.gms.games.internal.events.EventIncrementManager;
import com.google.android.gms.signin.internal.zzi;
import java.util.Set;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class GamesClientImpl extends zzj<IGamesService> {

    /* renamed from: a, reason: collision with root package name */
    EventIncrementManager f1315a;
    private final String b;
    private PlayerEntity c;
    private GameEntity d;
    private final PopupManager e;
    private boolean f;
    private final Binder g;
    private final long h;
    private final Games.GamesOptions i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends AbstractGamesClient {

        /* renamed from: a, reason: collision with root package name */
        private final PopupManager f1316a;

        public a(PopupManager popupManager) {
            this.f1316a = popupManager;
        }

        @Override // com.google.android.gms.games.internal.AbstractGamesClient, com.google.android.gms.games.internal.IGamesClient
        public PopupLocationInfoParcelable a() {
            return new PopupLocationInfoParcelable(this.f1316a.c());
        }
    }

    public GamesClientImpl(Context context, Looper looper, zzf zzfVar, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, zzfVar, connectionCallbacks, onConnectionFailedListener);
        this.f1315a = new com.google.android.gms.games.internal.a(this);
        this.f = false;
        this.b = zzfVar.h();
        this.g = new Binder();
        this.e = PopupManager.a(this, zzfVar.d());
        a(zzfVar.j());
        this.h = hashCode();
        this.i = gamesOptions;
    }

    private void a(RemoteException remoteException) {
        GamesLog.a("GamesClientImpl", "service died", remoteException);
    }

    private void c() {
        this.c = null;
        this.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IGamesService zzW(IBinder iBinder) {
        return IGamesService.Stub.a(iBinder);
    }

    public void a() {
        try {
            zzpc().a(new a(this.e), this.h);
        } catch (RemoteException e) {
            a(e);
        }
    }

    public void a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                zzpc().a(iBinder, bundle);
            } catch (RemoteException e) {
                a(e);
            }
        }
    }

    public void a(View view) {
        this.e.a(view);
    }

    public void b() {
        if (isConnected()) {
            try {
                zzpc().c();
            } catch (RemoteException e) {
                a(e);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        this.f = false;
        if (isConnected()) {
            try {
                IGamesService zzpc = zzpc();
                zzpc.c();
                this.f1315a.a();
                zzpc.a(this.h);
            } catch (RemoteException e) {
                GamesLog.a("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.zzj
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null) {
            bundle.setClassLoader(GamesClientImpl.class.getClassLoader());
            this.f = bundle.getBoolean("show_welcome_popup");
            this.c = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.d = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public void zza(GoogleApiClient.zza zzaVar) {
        c();
        super.zza(zzaVar);
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Set<Scope> zzb(Set<Scope> set) {
        boolean z;
        boolean z2;
        Scope scope = new Scope("https://www.googleapis.com/auth/games");
        Scope scope2 = new Scope("https://www.googleapis.com/auth/games.firstparty");
        boolean z3 = false;
        boolean z4 = false;
        for (Scope scope3 : set) {
            if (scope3.equals(scope)) {
                z = z3;
                z2 = true;
            } else if (scope3.equals(scope2)) {
                z = true;
                z2 = z4;
            } else {
                z = z3;
                z2 = z4;
            }
            z4 = z2;
            z3 = z;
        }
        if (z3) {
            zzx.a(!z4, "Cannot have both %s and %s!", "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty");
        } else {
            zzx.a(z4, "Games APIs requires %s to function.", "https://www.googleapis.com/auth/games");
        }
        return set;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfK() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected String zzfL() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    protected Bundle zzly() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle a2 = this.i.a();
        a2.putString("com.google.android.gms.games.key.gamePackageName", this.b);
        a2.putString("com.google.android.gms.games.key.desiredLocale", locale);
        a2.putParcelable("com.google.android.gms.games.key.popupWindowToken", new BinderWrapper(this.e.b()));
        a2.putInt("com.google.android.gms.games.key.API_VERSION", 1);
        zzf zzpa = zzpa();
        if (zzpa.k() != null) {
            a2.putBundle("com.google.android.gms.games.key.signInOptions", zzi.a(zzpa.k(), zzpa.l(), Executors.newSingleThreadExecutor()));
        }
        return a2;
    }

    @Override // com.google.android.gms.common.internal.zzj, com.google.android.gms.common.internal.zzk.zza
    public Bundle zzmS() {
        try {
            Bundle b = zzpc().b();
            if (b == null) {
                return b;
            }
            b.setClassLoader(GamesClientImpl.class.getClassLoader());
            return b;
        } catch (RemoteException e) {
            a(e);
            return null;
        }
    }

    @Override // com.google.android.gms.common.internal.zzj
    public void zzoW() {
        super.zzoW();
        if (this.f) {
            this.e.a();
            this.f = false;
        }
        if (this.i.f1297a) {
            return;
        }
        a();
    }
}
