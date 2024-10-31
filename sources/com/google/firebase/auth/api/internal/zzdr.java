package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zze;

/* loaded from: classes2.dex */
public final class zzdr extends GmsClient<zzea> implements zzdq {

    /* renamed from: a, reason: collision with root package name */
    private static Logger f16472a = new Logger("FirebaseAuth", "FirebaseAuth:");

    /* renamed from: b, reason: collision with root package name */
    private final Context f16473b;

    /* renamed from: c, reason: collision with root package name */
    private final zzef f16474c;

    public zzdr(Context context, Looper looper, ClientSettings clientSettings, zzef zzefVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        Preconditions.a(context);
        this.f16473b = context;
        this.f16474c = zzefVar;
    }

    @Override // com.google.firebase.auth.api.internal.zzdq
    @KeepForSdk
    public final /* synthetic */ zzea a() throws DeadObjectException {
        return (zzea) super.getService();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        if (queryLocalInterface instanceof zzea) {
            return (zzea) queryLocalInterface;
        }
        return new zzec(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zze.zzg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        zzef zzefVar = this.f16474c;
        if (zzefVar != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", zzefVar.d());
        }
        return getServiceRequestExtraArgs;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServicePackage() {
        char c2;
        String a2 = zzfe.a("firebear.preference");
        if (TextUtils.isEmpty(a2)) {
            a2 = "default";
        }
        int hashCode = a2.hashCode();
        char c3 = 65535;
        if (hashCode != 103145323) {
            if (hashCode == 1544803905 && a2.equals("default")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (a2.equals("local")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0 && c2 != 1) {
            a2 = "default";
        }
        if (a2.hashCode() == 103145323 && a2.equals("local")) {
            c3 = 0;
        }
        if (c3 != 0) {
            f16472a.c("Loading module via FirebaseOptions.", new Object[0]);
            if (this.f16474c.f16468a) {
                f16472a.c("Preparing to create service connection to fallback implementation", new Object[0]);
                return this.f16473b.getPackageName();
            }
            f16472a.c("Preparing to create service connection to gms implementation", new Object[0]);
            return "com.google.android.gms";
        }
        f16472a.c("Loading fallback module override.", new Object[0]);
        return this.f16473b.getPackageName();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.a(this.f16473b, "com.google.firebase.auth") == 0;
    }
}
