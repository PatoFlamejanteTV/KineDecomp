package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public final class zzed {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzdq> f16477a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzdq, zzef> f16478b = new O();

    /* renamed from: c, reason: collision with root package name */
    public static final Api<zzef> f16479c = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", f16478b, f16477a);

    public static zzao a(Context context, zzef zzefVar) {
        return new zzao(context, zzefVar);
    }
}
