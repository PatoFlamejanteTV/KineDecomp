package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzh;
import com.google.android.gms.internal.auth.zzr;

/* loaded from: classes.dex */
public class WorkAccount {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzr> f10413a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzr, Api.ApiOptions.NoOptions> f10414b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f10415c = new Api<>("WorkAccount.API", f10414b, f10413a);

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public static final WorkAccountApi f10416d = new zzh();

    private WorkAccount() {
    }
}
