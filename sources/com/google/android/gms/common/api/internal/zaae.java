package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class zaae extends zal {

    /* renamed from: f, reason: collision with root package name */
    private final ArraySet<zai<?>> f10867f;

    /* renamed from: g, reason: collision with root package name */
    private GoogleApiManager f10868g;

    private zaae(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f10867f = new ArraySet<>();
        this.f10774a.a("ConnectionlessLifecycleHelper", this);
    }

    public static void a(Activity activity, GoogleApiManager googleApiManager, zai<?> zaiVar) {
        LifecycleFragment a2 = LifecycleCallback.a(activity);
        zaae zaaeVar = (zaae) a2.a("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            zaaeVar = new zaae(a2);
        }
        zaaeVar.f10868g = googleApiManager;
        Preconditions.a(zaiVar, "ApiKey cannot be null");
        zaaeVar.f10867f.add(zaiVar);
        googleApiManager.a(zaaeVar);
    }

    private final void i() {
        if (this.f10867f.isEmpty()) {
            return;
        }
        this.f10868g.a(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void c() {
        super.c();
        i();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void d() {
        super.d();
        i();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void e() {
        super.e();
        this.f10868g.b(this);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void f() {
        this.f10868g.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ArraySet<zai<?>> h() {
        return this.f10867f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        this.f10868g.a(connectionResult, i);
    }
}
