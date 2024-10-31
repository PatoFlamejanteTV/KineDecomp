package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class Common {

    /* renamed from: a, reason: collision with root package name */
    @KeepForSdk
    public static final Api.ClientKey<zai> f11166a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> f11167b = new a();

    /* renamed from: c, reason: collision with root package name */
    @KeepForSdk
    public static final Api<Api.ApiOptions.NoOptions> f11168c = new Api<>("Common.API", f11167b, f11166a);

    /* renamed from: d, reason: collision with root package name */
    public static final zac f11169d = new zad();
}
