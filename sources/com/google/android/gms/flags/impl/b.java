package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class b implements Callable<Integer> {

    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f11347a;

    /* renamed from: b */
    private final /* synthetic */ String f11348b;

    /* renamed from: c */
    private final /* synthetic */ Integer f11349c;

    public b(SharedPreferences sharedPreferences, String str, Integer num) {
        this.f11347a = sharedPreferences;
        this.f11348b = str;
        this.f11349c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Integer call() throws Exception {
        return Integer.valueOf(this.f11347a.getInt(this.f11348b, this.f11349c.intValue()));
    }
}
