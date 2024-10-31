package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import java.util.UUID;

/* loaded from: classes.dex */
public class zzai extends zzd {

    /* renamed from: a */
    private SharedPreferences f732a;
    private long b;
    private long c;
    private final zza d;

    /* loaded from: classes.dex */
    public final class zza {
        private final String b;
        private final long c;

        private zza(String str, long j) {
            com.google.android.gms.common.internal.zzx.a(str);
            com.google.android.gms.common.internal.zzx.b(j > 0);
            this.b = str;
            this.c = j;
        }

        /* synthetic */ zza(zzai zzaiVar, String str, long j, AnonymousClass1 anonymousClass1) {
            this(str, j);
        }

        private void c() {
            long currentTimeMillis = zzai.this.n().currentTimeMillis();
            SharedPreferences.Editor edit = zzai.this.f732a.edit();
            edit.remove(g());
            edit.remove(b());
            edit.putLong(f(), currentTimeMillis);
            edit.commit();
        }

        private long d() {
            long e = e();
            if (e == 0) {
                return 0L;
            }
            return Math.abs(e - zzai.this.n().currentTimeMillis());
        }

        private long e() {
            return zzai.this.f732a.getLong(f(), 0L);
        }

        private String f() {
            return this.b + ":start";
        }

        private String g() {
            return this.b + ":count";
        }

        public Pair<String, Long> a() {
            long d = d();
            if (d < this.c) {
                return null;
            }
            if (d > this.c * 2) {
                c();
                return null;
            }
            String string = zzai.this.f732a.getString(b(), null);
            long j = zzai.this.f732a.getLong(g(), 0L);
            c();
            if (string == null || j <= 0) {
                return null;
            }
            return new Pair<>(string, Long.valueOf(j));
        }

        public void a(String str) {
            if (e() == 0) {
                c();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = zzai.this.f732a.getLong(g(), 0L);
                if (j <= 0) {
                    SharedPreferences.Editor edit = zzai.this.f732a.edit();
                    edit.putString(b(), str);
                    edit.putLong(g(), 1L);
                    edit.apply();
                    return;
                }
                boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
                SharedPreferences.Editor edit2 = zzai.this.f732a.edit();
                if (z) {
                    edit2.putString(b(), str);
                }
                edit2.putLong(g(), j + 1);
                edit2.apply();
            }
        }

        protected String b() {
            return this.b + ":value";
        }
    }

    public zzai(zzf zzfVar) {
        super(zzfVar);
        this.c = -1L;
        this.d = new zza("monitoring", q().G());
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        this.f732a = o().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public void a(String str) {
        m();
        D();
        SharedPreferences.Editor edit = this.f732a.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (edit.commit()) {
            return;
        }
        e("Failed to commit campaign data");
    }

    public long b() {
        m();
        D();
        if (this.b == 0) {
            long j = this.f732a.getLong("first_run", 0L);
            if (j != 0) {
                this.b = j;
            } else {
                long currentTimeMillis = n().currentTimeMillis();
                SharedPreferences.Editor edit = this.f732a.edit();
                edit.putLong("first_run", currentTimeMillis);
                if (!edit.commit()) {
                    e("Failed to commit first run time");
                }
                this.b = currentTimeMillis;
            }
        }
        return this.b;
    }

    public d c() {
        return new d(n(), b());
    }

    public long d() {
        m();
        D();
        if (this.c == -1) {
            this.c = this.f732a.getLong("last_dispatch", 0L);
        }
        return this.c;
    }

    public void e() {
        m();
        D();
        long currentTimeMillis = n().currentTimeMillis();
        SharedPreferences.Editor edit = this.f732a.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.c = currentTimeMillis;
    }

    public String f() {
        m();
        D();
        String string = this.f732a.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public zza g() {
        return this.d;
    }
}
