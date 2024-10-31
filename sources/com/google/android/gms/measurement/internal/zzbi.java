package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzbi {

    /* renamed from: a, reason: collision with root package name */
    private final String f13958a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13959b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f13960c;

    /* renamed from: d, reason: collision with root package name */
    private String f13961d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ C1428m f13962e;

    public zzbi(C1428m c1428m, String str, String str2) {
        this.f13962e = c1428m;
        Preconditions.b(str);
        this.f13958a = str;
        this.f13959b = null;
    }

    public final String a() {
        SharedPreferences y;
        if (!this.f13960c) {
            this.f13960c = true;
            y = this.f13962e.y();
            this.f13961d = y.getString(this.f13958a, null);
        }
        return this.f13961d;
    }

    public final void a(String str) {
        SharedPreferences y;
        if (zzfy.d(str, this.f13961d)) {
            return;
        }
        y = this.f13962e.y();
        SharedPreferences.Editor edit = y.edit();
        edit.putString(this.f13958a, str);
        edit.apply();
        this.f13961d = str;
    }
}
