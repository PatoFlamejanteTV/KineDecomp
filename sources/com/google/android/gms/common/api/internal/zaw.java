package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

/* loaded from: classes.dex */
public final class zaw<O extends Api.ApiOptions> extends GoogleApi<O> {

    /* renamed from: a, reason: collision with root package name */
    private final Api.Client f10956a;

    /* renamed from: b, reason: collision with root package name */
    private final zaq f10957b;

    /* renamed from: c, reason: collision with root package name */
    private final ClientSettings f10958c;

    /* renamed from: d, reason: collision with root package name */
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> f10959d;

    public zaw(Context context, Api<O> api, Looper looper, Api.Client client, zaq zaqVar, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder) {
        super(context, api, looper);
        this.f10956a = client;
        this.f10957b = zaqVar;
        this.f10958c = clientSettings;
        this.f10959d = abstractClientBuilder;
        this.zabm.a(this);
    }

    public final Api.Client a() {
        return this.f10956a;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final Api.Client zaa(Looper looper, GoogleApiManager.zaa<O> zaaVar) {
        this.f10957b.a(zaaVar);
        return this.f10956a;
    }

    @Override // com.google.android.gms.common.api.GoogleApi
    public final zace zaa(Context context, Handler handler) {
        return new zace(context, handler, this.f10958c, this.f10959d);
    }
}
