package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.zzx;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class zzs extends ac {

    /* renamed from: a */
    static final Pair<String, Long> f2066a = new Pair<>("", 0L);
    public final zzb b;
    public final zza c;
    public final zza d;
    public final zza e;
    public final zza f;
    private SharedPreferences h;
    private String i;
    private boolean j;
    private long k;

    /* loaded from: classes.dex */
    public final class zza {
        private final String b;
        private final long c;
        private boolean d;
        private long e;

        public zza(String str, long j) {
            zzx.a(str);
            this.b = str;
            this.c = j;
        }

        private void b() {
            if (this.d) {
                return;
            }
            this.d = true;
            this.e = zzs.this.h.getLong(this.b, this.c);
        }

        public long a() {
            b();
            return this.e;
        }

        public void a(long j) {
            SharedPreferences.Editor edit = zzs.this.h.edit();
            edit.putLong(this.b, j);
            edit.apply();
            this.e = j;
        }
    }

    /* loaded from: classes.dex */
    public final class zzb {

        /* renamed from: a */
        final String f2068a;
        private final String c;
        private final String d;
        private final long e;

        private zzb(String str, long j) {
            zzx.a(str);
            zzx.b(j > 0);
            this.f2068a = str + ":start";
            this.c = str + ":count";
            this.d = str + ":value";
            this.e = j;
        }

        /* synthetic */ zzb(zzs zzsVar, String str, long j, AnonymousClass1 anonymousClass1) {
            this(str, j);
        }

        private void b() {
            zzs.this.e();
            long currentTimeMillis = zzs.this.h().currentTimeMillis();
            SharedPreferences.Editor edit = zzs.this.h.edit();
            edit.remove(this.c);
            edit.remove(this.d);
            edit.putLong(this.f2068a, currentTimeMillis);
            edit.apply();
        }

        private long c() {
            zzs.this.e();
            long d = d();
            if (d != 0) {
                return Math.abs(d - zzs.this.h().currentTimeMillis());
            }
            b();
            return 0L;
        }

        private long d() {
            return zzs.this.r().getLong(this.f2068a, 0L);
        }

        public Pair<String, Long> a() {
            zzs.this.e();
            long c = c();
            if (c < this.e) {
                return null;
            }
            if (c > this.e * 2) {
                b();
                return null;
            }
            String string = zzs.this.r().getString(this.d, null);
            long j = zzs.this.r().getLong(this.c, 0L);
            b();
            return (string == null || j <= 0) ? zzs.f2066a : new Pair<>(string, Long.valueOf(j));
        }

        public void a(String str) {
            zzs.this.e();
            if (d() == 0) {
                b();
            }
            if (str == null) {
                str = "";
            }
            long j = zzs.this.h.getLong(this.c, 0L);
            if (j <= 0) {
                SharedPreferences.Editor edit = zzs.this.h.edit();
                edit.putString(this.d, str);
                edit.putLong(this.c, 1L);
                edit.apply();
                return;
            }
            boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
            SharedPreferences.Editor edit2 = zzs.this.h.edit();
            if (z) {
                edit2.putString(this.d, str);
            }
            edit2.putLong(this.c, j + 1);
            edit2.apply();
        }
    }

    public zzs(zzv zzvVar) {
        super(zzvVar);
        this.b = new zzb("health_monitor", n().E());
        this.c = new zza("last_upload", 0L);
        this.d = new zza("last_upload_attempt", 0L);
        this.e = new zza("backoff", 0L);
        this.f = new zza("last_delete_stale", 0L);
    }

    static MessageDigest a(String str) {
        MessageDigest messageDigest;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException e) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
            i = i2 + 1;
        }
    }

    public SharedPreferences r() {
        e();
        x();
        return this.h;
    }

    @Override // com.google.android.gms.measurement.internal.ac
    protected void a() {
        this.h = i().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
    }

    public void a(boolean z) {
        e();
        l().t().a("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = r().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    public Pair<String, Boolean> b() {
        e();
        long elapsedRealtime = h().elapsedRealtime();
        if (this.i != null && elapsedRealtime < this.k) {
            return new Pair<>(this.i, Boolean.valueOf(this.j));
        }
        this.k = elapsedRealtime + n().u();
        AdvertisingIdClient.b(true);
        try {
            AdvertisingIdClient.Info b = AdvertisingIdClient.b(i());
            this.i = b.a();
            this.j = b.b();
        } catch (Throwable th) {
            l().s().a("Unable to get advertising id", th);
            this.i = "";
        }
        AdvertisingIdClient.b(false);
        return new Pair<>(this.i, Boolean.valueOf(this.j));
    }

    public String o() {
        String str = (String) b().first;
        MessageDigest a2 = a("MD5");
        if (a2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, a2.digest(str.getBytes())));
    }

    public String p() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Boolean q() {
        e();
        if (r().contains("use_service")) {
            return Boolean.valueOf(r().getBoolean("use_service", false));
        }
        return null;
    }
}
