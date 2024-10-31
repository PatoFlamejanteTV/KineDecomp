package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsi;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class zzb {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<zza> f2147a;
    private int b;

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        public final PlayLoggerContext f2148a;
        public final LogEvent b;
        public final zzsi.zzd c;

        private zza(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
            this.f2148a = (PlayLoggerContext) zzx.a(playLoggerContext);
            this.b = (LogEvent) zzx.a(logEvent);
            this.c = null;
        }
    }

    public zzb() {
        this(100);
    }

    public zzb(int i) {
        this.f2147a = new ArrayList<>();
        this.b = i;
    }

    private void f() {
        while (c() > d()) {
            this.f2147a.remove(0);
        }
    }

    public ArrayList<zza> a() {
        return this.f2147a;
    }

    public void a(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.f2147a.add(new zza(playLoggerContext, logEvent));
        f();
    }

    public void b() {
        this.f2147a.clear();
    }

    public int c() {
        return this.f2147a.size();
    }

    public int d() {
        return this.b;
    }

    public boolean e() {
        return this.f2147a.isEmpty();
    }
}
