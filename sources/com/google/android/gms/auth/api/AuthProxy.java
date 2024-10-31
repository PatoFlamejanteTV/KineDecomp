package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

@KeepForSdk
/* loaded from: classes.dex */
public final class AuthProxy {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzak> f10429a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> f10430b = new a();

    /* renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final Api<AuthProxyOptions> f10431c = new Api<>("Auth.PROXY_API", f10430b, f10429a);

    /* renamed from: d, reason: collision with root package name */
    @KeepForSdk
    public static final ProxyApi f10432d = new zzar();
}
