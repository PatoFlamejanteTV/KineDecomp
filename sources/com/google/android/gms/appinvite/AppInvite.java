package com.google.android.gms.appinvite;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.firebase_dynamic_links.zze;
import com.google.android.gms.internal.firebase_dynamic_links.zzn;

@Deprecated
/* loaded from: classes.dex */
public final class AppInvite {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzn> f10383a = new Api.ClientKey<>();

    /* renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzn, Api.ApiOptions.NoOptions> f10384b = new a();

    /* renamed from: c, reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f10385c = new Api<>("AppInvite.API", f10384b, f10383a);

    /* renamed from: d, reason: collision with root package name */
    public static final AppInviteApi f10386d = new zze();

    private AppInvite() {
    }
}
