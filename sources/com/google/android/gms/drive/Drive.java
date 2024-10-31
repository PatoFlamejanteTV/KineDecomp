package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.zzaa;
import com.google.android.gms.drive.internal.zzac;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.internal.zzx;
import com.google.api.services.drive.DriveScopes;

/* loaded from: classes.dex */
public final class Drive {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzu> f1052a = new Api.zzc<>();
    public static final Scope b = new Scope(DriveScopes.DRIVE_FILE);
    public static final Scope c = new Scope(DriveScopes.DRIVE_APPDATA);
    public static final Scope d = new Scope(DriveScopes.DRIVE);
    public static final Scope e = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<Api.ApiOptions.NoOptions> f = new Api<>("Drive.API", new a(), f1052a);
    public static final Api<zzb> g = new Api<>("Drive.INTERNAL_API", new b(), f1052a);
    public static final DriveApi h = new zzs();
    public static final zzd i = new zzx();
    public static final zzg j = new zzac();
    public static final DrivePreferencesApi k = new zzaa();

    /* loaded from: classes2.dex */
    public static abstract class zza<O extends Api.ApiOptions> extends Api.zza<zzu, O> {
        protected abstract Bundle a(O o);

        @Override // com.google.android.gms.common.api.Api.zza
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zzu zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzu(context, looper, zzfVar, connectionCallbacks, onConnectionFailedListener, a(o));
        }
    }

    /* loaded from: classes2.dex */
    public static class zzb implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f1053a;

        public Bundle a() {
            return this.f1053a;
        }
    }

    private Drive() {
    }
}
