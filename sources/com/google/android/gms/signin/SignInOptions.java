package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {

    /* renamed from: a */
    public static final SignInOptions f14122a;

    /* renamed from: b */
    private final boolean f14123b = false;

    /* renamed from: c */
    private final boolean f14124c = false;

    /* renamed from: d */
    private final String f14125d = null;

    /* renamed from: e */
    private final boolean f14126e = false;

    /* renamed from: g */
    private final boolean f14128g = false;

    /* renamed from: f */
    private final String f14127f = null;

    /* renamed from: h */
    private final Long f14129h = null;
    private final Long i = null;

    /* loaded from: classes2.dex */
    public static final class zaa {
    }

    static {
        new zaa();
        f14122a = new SignInOptions(false, false, null, false, null, false, null, null);
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
    }

    public final Long a() {
        return this.f14129h;
    }

    public final String b() {
        return this.f14127f;
    }

    public final Long c() {
        return this.i;
    }

    public final String d() {
        return this.f14125d;
    }

    public final boolean e() {
        return this.f14126e;
    }

    public final boolean f() {
        return this.f14124c;
    }

    public final boolean g() {
        return this.f14123b;
    }

    public final boolean h() {
        return this.f14128g;
    }
}
