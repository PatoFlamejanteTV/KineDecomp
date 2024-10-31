package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

/* loaded from: classes.dex */
class x implements Logger {

    /* renamed from: a, reason: collision with root package name */
    private int f722a = 2;
    private boolean b;

    @Override // com.google.android.gms.analytics.Logger
    public int a() {
        return this.f722a;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void a(int i) {
        this.f722a = i;
        if (this.b) {
            return;
        }
        Log.i(zzy.c.a(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + zzy.c.a() + " DEBUG");
        this.b = true;
    }

    @Override // com.google.android.gms.analytics.Logger
    public void a(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void b(String str) {
    }

    @Override // com.google.android.gms.analytics.Logger
    public void c(String str) {
    }
}
