package com.google.android.gms.common.api;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class Api<O extends ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    private final zza<?, O> f971a;
    private final zze<?, O> b;
    private final zzc<?> c;
    private final zzf<?> d;
    private final String e;

    /* loaded from: classes.dex */
    public interface ApiOptions {

        /* loaded from: classes.dex */
        public interface HasOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public static final class NoOptions implements NotRequiredOptions {
            private NoOptions() {
            }
        }

        /* loaded from: classes.dex */
        public interface NotRequiredOptions extends ApiOptions {
        }

        /* loaded from: classes.dex */
        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class zza<T extends zzb, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public abstract T zza(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);

        public List<Scope> zzm(O o) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes.dex */
    public interface zzb {
        void disconnect();

        void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean isConnected();

        void zza(GoogleApiClient.zza zzaVar);

        void zza(zzp zzpVar);

        void zza(zzp zzpVar, Set<Scope> set);

        boolean zzlN();

        IBinder zznz();
    }

    /* loaded from: classes.dex */
    public static final class zzc<C extends zzb> {
    }

    /* loaded from: classes.dex */
    public interface zzd<T extends IInterface> {
        T a(IBinder iBinder);

        String a();

        void a(int i, T t);

        String b();
    }

    /* loaded from: classes.dex */
    public interface zze<T extends zzd, O> {
        int a();

        T a(O o);
    }

    /* loaded from: classes.dex */
    public static final class zzf<C extends zzd> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends zzb> Api(String str, zza<C, O> zzaVar, zzc<C> zzcVar) {
        zzx.a(zzaVar, "Cannot construct an Api with a null ClientBuilder");
        zzx.a(zzcVar, "Cannot construct an Api with a null ClientKey");
        this.e = str;
        this.f971a = zzaVar;
        this.b = null;
        this.c = zzcVar;
        this.d = null;
    }

    public zza<?, O> a() {
        zzx.a(this.f971a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f971a;
    }

    public zze<?, O> b() {
        zzx.a(this.b != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
        return this.b;
    }

    public zzc<?> c() {
        zzx.a(this.c != null, "This API was constructed with a SimpleClientKey. Use getSimpleClientKey");
        return this.c;
    }

    public boolean d() {
        return this.d != null;
    }

    public String e() {
        return this.e;
    }
}
