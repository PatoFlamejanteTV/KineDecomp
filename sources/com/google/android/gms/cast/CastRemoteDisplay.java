package com.google.android.gms.cast;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkx;

/* loaded from: classes.dex */
public final class CastRemoteDisplay {
    private static final Api.zzc<zzkx> c = new Api.zzc<>();
    private static final Api.zza<zzkx, CastRemoteDisplayOptions> d = new c();

    /* renamed from: a, reason: collision with root package name */
    public static final Api<CastRemoteDisplayOptions> f821a = new Api<>("CastRemoteDisplay.API", d, c);
    public static final CastRemoteDisplayApi b = new zzkw(c);

    /* loaded from: classes.dex */
    public static final class CastRemoteDisplayOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: a, reason: collision with root package name */
        final CastDevice f822a;
        final CastRemoteDisplaySessionCallbacks b;

        /* loaded from: classes.dex */
        public static final class Builder {
        }
    }

    /* loaded from: classes.dex */
    public interface CastRemoteDisplaySessionCallbacks {
        void a(Status status);
    }

    /* loaded from: classes.dex */
    public interface CastRemoteDisplaySessionResult extends Result {
    }

    private CastRemoteDisplay() {
    }
}
