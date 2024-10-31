package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.credentials.internal.zzc;
import com.google.android.gms.auth.api.credentials.internal.zze;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInConfig;
import com.google.android.gms.auth.api.signin.internal.zzb;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.auth.api.signin.zzd;
import com.google.android.gms.auth.api.signin.zzf;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzjz;
import com.google.android.gms.internal.zzka;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzki;
import com.google.android.gms.internal.zzkm;

/* loaded from: classes.dex */
public final class Auth {

    /* renamed from: a, reason: collision with root package name */
    public static final Api.zzc<zzki> f782a = new Api.zzc<>();
    public static final Api.zzc<zze> b = new Api.zzc<>();
    public static final Api.zzc<zzkb> c = new Api.zzc<>();
    public static final Api.zzc<zzg> d = new Api.zzc<>();
    public static final Api.zzc<zzb> e = new Api.zzc<>();
    public static final Api.zzc<zzkf> f = new Api.zzc<>();
    private static final Api.zza<zzki, zza> s = new a();
    private static final Api.zza<zze, AuthCredentialsOptions> t = new b();
    private static final Api.zza<zzkb, Api.ApiOptions.NoOptions> u = new c();
    private static final Api.zza<zzkf, Api.ApiOptions.NoOptions> v = new d();
    private static final Api.zza<zzg, com.google.android.gms.auth.api.signin.zzg> w = new e();
    private static final Api.zza<zzb, GoogleSignInConfig> x = new f();
    public static final Api<zza> g = new Api<>("Auth.PROXY_API", s, f782a);
    public static final Api<AuthCredentialsOptions> h = new Api<>("Auth.CREDENTIALS_API", t, b);
    public static final Api<com.google.android.gms.auth.api.signin.zzg> i = new Api<>("Auth.SIGN_IN_API", w, d);
    public static final Api<GoogleSignInConfig> j = new Api<>("Auth.GOOGLE_SIGN_IN_API", x, e);
    public static final Api<Api.ApiOptions.NoOptions> k = new Api<>("Auth.ACCOUNT_STATUS_API", u, c);
    public static final Api<Api.ApiOptions.NoOptions> l = new Api<>("Auth.CONSENT_API", v, f);
    public static final ProxyApi m = new zzkm();
    public static final CredentialsApi n = new zzc();
    public static final zzjz o = new zzka();
    public static final zzf p = new com.google.android.gms.auth.api.signin.internal.zzf();
    public static final zzd q = new com.google.android.gms.auth.api.signin.internal.zza();
    public static final com.google.android.gms.auth.api.consent.zza r = new zzke();

    /* loaded from: classes.dex */
    public static final class AuthCredentialsOptions implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        private final String f783a;
        private final PasswordSpecification b;

        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private PasswordSpecification f784a = PasswordSpecification.f792a;
        }

        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.f783a);
            bundle.putParcelable("password_specification", this.b);
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public static final class zza implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f785a;

        public Bundle a() {
            return new Bundle(this.f785a);
        }
    }

    private Auth() {
    }
}
