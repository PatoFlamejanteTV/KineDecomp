package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzbg {

    /* renamed from: a */
    private final String f13948a;

    /* renamed from: b */
    private final long f13949b;

    /* renamed from: c */
    private boolean f13950c;

    /* renamed from: d */
    private long f13951d;

    /* renamed from: e */
    private final /* synthetic */ C1428m f13952e;

    public zzbg(C1428m c1428m, String str, long j) {
        this.f13952e = c1428m;
        Preconditions.b(str);
        this.f13948a = str;
        this.f13949b = j;
    }

    public final long a() {
        SharedPreferences y;
        if (!this.f13950c) {
            this.f13950c = true;
            y = this.f13952e.y();
            this.f13951d = y.getLong(this.f13948a, this.f13949b);
        }
        return this.f13951d;
    }

    public final void a(long j) {
        SharedPreferences y;
        y = this.f13952e.y();
        SharedPreferences.Editor edit = y.edit();
        edit.putLong(this.f13948a, j);
        edit.apply();
        this.f13951d = j;
    }
}
