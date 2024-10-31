package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public class Container {

    /* renamed from: a */
    private final String f14160a;

    /* renamed from: b */
    private t f14161b;

    /* loaded from: classes2.dex */
    public interface FunctionCallMacroCallback {
    }

    /* loaded from: classes2.dex */
    public interface FunctionCallTagCallback {
    }

    private final synchronized t c() {
        return this.f14161b;
    }

    public String a() {
        return this.f14160a;
    }

    public final void b() {
        this.f14161b = null;
    }

    @VisibleForTesting
    public final void a(String str) {
        c().a(str);
        throw null;
    }
}
