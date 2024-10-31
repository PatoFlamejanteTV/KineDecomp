package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.google.android.gms.measurement.internal.m */
/* loaded from: classes2.dex */
public final class C1428m extends P {

    /* renamed from: c */
    @VisibleForTesting
    static final Pair<String, Long> f13797c = new Pair<>("", 0L);

    /* renamed from: d */
    private SharedPreferences f13798d;

    /* renamed from: e */
    public zzbh f13799e;

    /* renamed from: f */
    public final zzbg f13800f;

    /* renamed from: g */
    public final zzbg f13801g;

    /* renamed from: h */
    public final zzbg f13802h;
    public final zzbg i;
    public final zzbg j;
    public final zzbg k;
    public final zzbg l;
    public final zzbi m;
    private String n;
    private boolean o;
    private long p;
    public final zzbg q;
    public final zzbg r;
    public final zzbf s;
    public final zzbg t;
    public final zzbg u;
    public boolean v;

    public C1428m(zzbw zzbwVar) {
        super(zzbwVar);
        this.f13800f = new zzbg(this, "last_upload", 0L);
        this.f13801g = new zzbg(this, "last_upload_attempt", 0L);
        this.f13802h = new zzbg(this, "backoff", 0L);
        this.i = new zzbg(this, "last_delete_stale", 0L);
        this.q = new zzbg(this, "time_before_start", 10000L);
        this.r = new zzbg(this, "session_timeout", 1800000L);
        this.s = new zzbf(this, "start_new_session", true);
        this.t = new zzbg(this, "last_pause_time", 0L);
        this.u = new zzbg(this, "time_active", 0L);
        this.j = new zzbg(this, "midnight_offset", 0L);
        this.k = new zzbg(this, "first_open_time", 0L);
        this.l = new zzbg(this, "app_install_time", 0L);
        this.m = new zzbi(this, "app_instance_id", null);
    }

    public final SharedPreferences y() {
        c();
        l();
        return this.f13798d;
    }

    public final Pair<String, Boolean> a(String str) {
        c();
        long c2 = a().c();
        String str2 = this.n;
        if (str2 != null && c2 < this.p) {
            return new Pair<>(str2, Boolean.valueOf(this.o));
        }
        this.p = c2 + j().a(str, zzai.p);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            if (advertisingIdInfo != null) {
                this.n = advertisingIdInfo.getId();
                this.o = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.n == null) {
                this.n = "";
            }
        } catch (Exception e2) {
            b().x().a("Unable to get advertising id", e2);
            this.n = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.n, Boolean.valueOf(this.o));
    }

    public final String b(String str) {
        c();
        String str2 = (String) a(str).first;
        MessageDigest q = zzfy.q();
        if (q == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, q.digest(str2.getBytes())));
    }

    public final void c(String str) {
        c();
        SharedPreferences.Editor edit = y().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    public final void d(String str) {
        c();
        SharedPreferences.Editor edit = y().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    @Override // com.google.android.gms.measurement.internal.P
    protected final boolean n() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.P
    protected final void o() {
        this.f13798d = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.v = this.f13798d.getBoolean("has_been_opened", false);
        if (!this.v) {
            SharedPreferences.Editor edit = this.f13798d.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f13799e = new zzbh(this, "health_monitor", Math.max(0L, zzai.q.a().longValue()));
    }

    public final String q() {
        c();
        return y().getString("gmp_app_id", null);
    }

    public final String r() {
        c();
        return y().getString("admob_app_id", null);
    }

    public final Boolean s() {
        c();
        if (y().contains("use_service")) {
            return Boolean.valueOf(y().getBoolean("use_service", false));
        }
        return null;
    }

    public final void t() {
        c();
        b().y().a("Clearing collection preferences.");
        if (j().a(zzai.wa)) {
            Boolean u = u();
            SharedPreferences.Editor edit = y().edit();
            edit.clear();
            edit.apply();
            if (u != null) {
                a(u.booleanValue());
                return;
            }
            return;
        }
        boolean contains = y().contains("measurement_enabled");
        boolean c2 = contains ? c(true) : true;
        SharedPreferences.Editor edit2 = y().edit();
        edit2.clear();
        edit2.apply();
        if (contains) {
            a(c2);
        }
    }

    public final Boolean u() {
        c();
        if (y().contains("measurement_enabled")) {
            return Boolean.valueOf(y().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final String v() {
        c();
        String string = y().getString("previous_os_version", null);
        f().l();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = y().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    public final boolean w() {
        c();
        return y().getBoolean("deferred_analytics_collection", false);
    }

    public final boolean x() {
        return this.f13798d.contains("deferred_analytics_collection");
    }

    public final void b(boolean z) {
        c();
        b().y().a("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = y().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    public final boolean c(boolean z) {
        c();
        return y().getBoolean("measurement_enabled", z);
    }

    public final void d(boolean z) {
        c();
        b().y().a("Updating deferred analytics collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = y().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    public final void a(boolean z) {
        c();
        b().y().a("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = y().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    public final boolean a(long j) {
        return j - this.r.a() > this.t.a();
    }
}
