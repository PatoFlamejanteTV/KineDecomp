package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzbh {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final String f13953a;

    /* renamed from: b, reason: collision with root package name */
    private final String f13954b;

    /* renamed from: c, reason: collision with root package name */
    private final String f13955c;

    /* renamed from: d, reason: collision with root package name */
    private final long f13956d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ C1428m f13957e;

    private zzbh(C1428m c1428m, String str, long j) {
        this.f13957e = c1428m;
        Preconditions.b(str);
        Preconditions.a(j > 0);
        this.f13953a = String.valueOf(str).concat(":start");
        this.f13954b = String.valueOf(str).concat(":count");
        this.f13955c = String.valueOf(str).concat(":value");
        this.f13956d = j;
    }

    private final void b() {
        SharedPreferences y;
        this.f13957e.c();
        long a2 = this.f13957e.a().a();
        y = this.f13957e.y();
        SharedPreferences.Editor edit = y.edit();
        edit.remove(this.f13954b);
        edit.remove(this.f13955c);
        edit.putLong(this.f13953a, a2);
        edit.apply();
    }

    private final long c() {
        SharedPreferences y;
        y = this.f13957e.y();
        return y.getLong(this.f13953a, 0L);
    }

    public final void a(String str, long j) {
        SharedPreferences y;
        SharedPreferences y2;
        SharedPreferences y3;
        this.f13957e.c();
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        y = this.f13957e.y();
        long j2 = y.getLong(this.f13954b, 0L);
        if (j2 <= 0) {
            y3 = this.f13957e.y();
            SharedPreferences.Editor edit = y3.edit();
            edit.putString(this.f13955c, str);
            edit.putLong(this.f13954b, 1L);
            edit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.f13957e.h().s().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        y2 = this.f13957e.y();
        SharedPreferences.Editor edit2 = y2.edit();
        if (z) {
            edit2.putString(this.f13955c, str);
        }
        edit2.putLong(this.f13954b, j3);
        edit2.apply();
    }

    public final Pair<String, Long> a() {
        long abs;
        SharedPreferences y;
        SharedPreferences y2;
        this.f13957e.c();
        this.f13957e.c();
        long c2 = c();
        if (c2 == 0) {
            b();
            abs = 0;
        } else {
            abs = Math.abs(c2 - this.f13957e.a().a());
        }
        long j = this.f13956d;
        if (abs < j) {
            return null;
        }
        if (abs > (j << 1)) {
            b();
            return null;
        }
        y = this.f13957e.y();
        String string = y.getString(this.f13955c, null);
        y2 = this.f13957e.y();
        long j2 = y2.getLong(this.f13954b, 0L);
        b();
        if (string != null && j2 > 0) {
            return new Pair<>(string, Long.valueOf(j2));
        }
        return C1428m.f13797c;
    }
}
