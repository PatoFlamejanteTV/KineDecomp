package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzbf {

    /* renamed from: a */
    private final String f13943a;

    /* renamed from: b */
    private final boolean f13944b;

    /* renamed from: c */
    private boolean f13945c;

    /* renamed from: d */
    private boolean f13946d;

    /* renamed from: e */
    private final /* synthetic */ C1428m f13947e;

    public zzbf(C1428m c1428m, String str, boolean z) {
        this.f13947e = c1428m;
        Preconditions.b(str);
        this.f13943a = str;
        this.f13944b = true;
    }

    public final boolean a() {
        SharedPreferences y;
        if (!this.f13945c) {
            this.f13945c = true;
            y = this.f13947e.y();
            this.f13946d = y.getBoolean(this.f13943a, this.f13944b);
        }
        return this.f13946d;
    }

    public final void a(boolean z) {
        SharedPreferences y;
        y = this.f13947e.y();
        SharedPreferences.Editor edit = y.edit();
        edit.putBoolean(this.f13943a, z);
        edit.apply();
        this.f13946d = z;
    }
}
