package com.google.android.gms.identity.intents;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzoy;

/* loaded from: classes.dex */
public final class Address {

    /* renamed from: a, reason: collision with root package name */
    static final Api.zzc<zzoy> f1417a = new Api.zzc<>();
    private static final Api.zza<zzoy, AddressOptions> c = new a();
    public static final Api<AddressOptions> b = new Api<>("Address.API", c, f1417a);

    /* loaded from: classes.dex */
    public static final class AddressOptions implements Api.ApiOptions.HasOptions {

        /* renamed from: a, reason: collision with root package name */
        public final int f1418a = 0;
    }
}
