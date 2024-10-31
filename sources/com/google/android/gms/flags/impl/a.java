package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class a implements Callable<Boolean> {

    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f11344a;

    /* renamed from: b */
    private final /* synthetic */ String f11345b;

    /* renamed from: c */
    private final /* synthetic */ Boolean f11346c;

    public a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        this.f11344a = sharedPreferences;
        this.f11345b = str;
        this.f11346c = bool;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Boolean call() throws Exception {
        return Boolean.valueOf(this.f11344a.getBoolean(this.f11345b, this.f11346c.booleanValue()));
    }
}
