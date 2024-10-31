package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class d implements Callable<String> {

    /* renamed from: a */
    private final /* synthetic */ SharedPreferences f11353a;

    /* renamed from: b */
    private final /* synthetic */ String f11354b;

    /* renamed from: c */
    private final /* synthetic */ String f11355c;

    public d(SharedPreferences sharedPreferences, String str, String str2) {
        this.f11353a = sharedPreferences;
        this.f11354b = str;
        this.f11355c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f11353a.getString(this.f11354b, this.f11355c);
    }
}
