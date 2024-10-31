package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class e implements Callable<SharedPreferences> {

    /* renamed from: a */
    private final /* synthetic */ Context f11356a;

    public e(Context context) {
        this.f11356a = context;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ SharedPreferences call() throws Exception {
        return this.f11356a.getSharedPreferences("google_sdk_flags", 0);
    }
}
