package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.lang.ref.WeakReference;

@zzgr
/* loaded from: classes.dex */
public class zzo {

    /* renamed from: a, reason: collision with root package name */
    private final zza f665a;
    private final Runnable b;
    private AdRequestParcel c;
    private boolean d;
    private boolean e;
    private long f;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f666a;

        public zza(Handler handler) {
            this.f666a = handler;
        }

        public void a(Runnable runnable) {
            this.f666a.removeCallbacks(runnable);
        }

        public boolean a(Runnable runnable, long j) {
            return this.f666a.postDelayed(runnable, j);
        }
    }

    public zzo(com.google.android.gms.ads.internal.zza zzaVar) {
        this(zzaVar, new zza(zzid.zzIE));
    }

    zzo(com.google.android.gms.ads.internal.zza zzaVar, zza zzaVar2) {
        this.d = false;
        this.e = false;
        this.f = 0L;
        this.f665a = zzaVar2;
        this.b = new n(this, new WeakReference(zzaVar));
    }

    public void a() {
        this.d = false;
        this.f665a.a(this.b);
    }

    public void a(AdRequestParcel adRequestParcel) {
        a(adRequestParcel, 60000L);
    }

    public void a(AdRequestParcel adRequestParcel, long j) {
        if (this.d) {
            com.google.android.gms.ads.internal.util.client.zzb.e("An ad refresh is already scheduled.");
            return;
        }
        this.c = adRequestParcel;
        this.d = true;
        this.f = j;
        if (this.e) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.c("Scheduling ad refresh " + j + " milliseconds from now.");
        this.f665a.a(this.b, j);
    }

    public void b() {
        this.e = true;
        if (this.d) {
            this.f665a.a(this.b);
        }
    }

    public void c() {
        this.e = false;
        if (this.d) {
            this.d = false;
            a(this.c, this.f);
        }
    }

    public boolean d() {
        return this.d;
    }
}
