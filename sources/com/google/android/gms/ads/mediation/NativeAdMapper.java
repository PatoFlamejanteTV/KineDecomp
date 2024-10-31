package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public abstract class NativeAdMapper {

    /* renamed from: a, reason: collision with root package name */
    protected boolean f670a;
    protected boolean b;
    protected Bundle c = new Bundle();

    public void a(View view) {
    }

    public final void a(boolean z) {
        this.f670a = z;
    }

    public final boolean a() {
        return this.f670a;
    }

    public void b(View view) {
    }

    public final void b(boolean z) {
        this.b = z;
    }

    public final boolean b() {
        return this.b;
    }

    public final Bundle c() {
        return this.c;
    }

    public void d() {
    }
}
