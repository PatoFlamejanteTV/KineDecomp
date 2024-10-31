package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzpb;

/* loaded from: classes.dex */
public class zzk extends zzd {

    /* renamed from: a */
    private final zzpb f746a;

    public zzk(zzf zzfVar) {
        super(zzfVar);
        this.f746a = new zzpb();
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void a() {
        r().a().zza(this.f746a);
        b();
    }

    public void b() {
        zzan v = v();
        String c = v.c();
        if (c != null) {
            this.f746a.setAppName(c);
        }
        String b = v.b();
        if (b != null) {
            this.f746a.setAppVersion(b);
        }
    }

    public zzpb c() {
        D();
        return this.f746a;
    }
}
