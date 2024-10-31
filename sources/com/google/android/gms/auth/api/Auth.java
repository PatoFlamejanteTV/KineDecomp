package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p000authapi.zzi;
import com.google.android.gms.internal.p000authapi.zzr;

/* loaded from: classes.dex */
public final class Auth {

    /* renamed from: a */
    public static final Api.ClientKey<zzr> f10417a = new Api.ClientKey<>();

    /* renamed from: b */
    public static final Api.ClientKey<zzg> f10418b = new Api.ClientKey<>();

    /* renamed from: c */
    private static final Api.AbstractClientBuilder<zzr, AuthCredentialsOptions> f10419c = new b();

    /* renamed from: d */
    private static final Api.AbstractClientBuilder<zzg, GoogleSignInOptions> f10420d = new c();

    /* renamed from: e */
    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> f10421e = AuthProxy.f10431c;

    /* renamed from: f */
    public static final Api<AuthCredentialsOptions> f10422f = new Api<>("Auth.CREDENTIALS_API", f10419c, f10417a);

    /* renamed from: g */
    public static final Api<GoogleSignInOptions> f10423g = new Api<>("Auth.GOOGLE_SIGN_IN_API", f10420d, f10418b);

    /* renamed from: h */
    @KeepForSdk
    @Deprecated
    public static final ProxyApi f10424h = AuthProxy.f10432d;
    public static final CredentialsApi i = new zzi();
    public static final GoogleSignInApi j = new zzf();

    @Deprecated
    /* loaded from: classes.dex */
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {

        /* renamed from: a */
        private static final AuthCredentialsOptions f10425a = new Builder().a();

        /* renamed from: b */
        private final String f10426b = null;

        /* renamed from: c */
        private final boolean f10427c;

        @Deprecated
        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a */
            protected Boolean f10428a = false;

            public AuthCredentialsOptions a() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.f10427c = builder.f10428a.booleanValue();
        }

        public final Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.f10427c);
            return bundle;
        }
    }

    private Auth() {
    }
}
