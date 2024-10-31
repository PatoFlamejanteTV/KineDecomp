package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class c implements Callable<Long> {

    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f11350a;

    /* renamed from: b */
    private final /* synthetic */ String f11351b;

    /* renamed from: c */
    private final /* synthetic */ Long f11352c;

    public c(SharedPreferences sharedPreferences, String str, Long l) {
        this.f11350a = sharedPreferences;
        this.f11351b = str;
        this.f11352c = l;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Long call() throws Exception {
        return Long.valueOf(this.f11350a.getLong(this.f11351b, this.f11352c.longValue()));
    }
}
