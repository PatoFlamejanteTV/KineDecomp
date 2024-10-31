package com.google.android.gms.plus;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqg;
import com.google.android.gms.internal.zzqh;
import com.google.android.gms.internal.zzqi;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Plus {

    /* renamed from: a */
    public static final Api.zzc<zze> f2151a = new Api.zzc<>();
    static final Api.zza<zze, PlusOptions> b = new a();
    public static final Api<PlusOptions> c = new Api<>("Plus.API", b, f2151a);
    public static final Scope d = new Scope("https://www.googleapis.com/auth/plus.login");
    public static final Scope e = new Scope("https://www.googleapis.com/auth/plus.me");
    public static final Moments f = new zzqh();
    public static final People g = new zzqi();
    public static final Account h = new zzqe();
    public static final zzb i = new zzqg();
    public static final com.google.android.gms.plus.zza j = new zzqf();

    /* loaded from: classes.dex */
    public static final class PlusOptions implements Api.ApiOptions.Optional {

        /* renamed from: a */
        final String f2152a;
        final Set<String> b;

        /* loaded from: classes.dex */
        public static final class Builder {

            /* renamed from: a */
            final Set<String> f2153a = new HashSet();
        }

        private PlusOptions() {
            this.f2152a = null;
            this.b = new HashSet();
        }

        public /* synthetic */ PlusOptions(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result> extends zzlb.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.f2151a, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze a(GoogleApiClient googleApiClient, boolean z) {
        zzx.b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzx.a(googleApiClient.isConnected(), "GoogleApiClient must be connected.");
        zzx.a(googleApiClient.zza(c), "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(c);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        }
        if (hasConnectedApi) {
            return (zze) googleApiClient.zza(f2151a);
        }
        return null;
    }
}
