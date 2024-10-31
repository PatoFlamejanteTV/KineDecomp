package com.google.android.gms.signin;

import android.support.v4.app.NotificationCompat;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

/* loaded from: classes2.dex */
public final class zaa {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<SignInClientImpl> f14141a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    @ShowFirstParty
    private static final Api.ClientKey<SignInClientImpl> f14142b = new Api.ClientKey<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> f14143c = new a();

    /* renamed from: d, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<SignInClientImpl, Object> f14144d = new b();

    /* renamed from: e, reason: collision with root package name */
    private static final Scope f14145e = new Scope("profile");

    /* renamed from: f, reason: collision with root package name */
    private static final Scope f14146f = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: g, reason: collision with root package name */
    public static final Api<SignInOptions> f14147g = new Api<>("SignIn.API", f14143c, f14141a);

    /* renamed from: h, reason: collision with root package name */
    private static final Api<Object> f14148h = new Api<>("SignIn.INTERNAL_API", f14144d, f14142b);
}
