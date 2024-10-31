package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.tl, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C1101tl implements zzpi {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f12557a;

    /* renamed from: b, reason: collision with root package name */
    private final zzov f12558b;

    /* renamed from: c, reason: collision with root package name */
    private final C1115ul f12559c;

    /* renamed from: d, reason: collision with root package name */
    private final zzpq f12560d;

    /* renamed from: e, reason: collision with root package name */
    private final zzif f12561e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f12562f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12563g;

    /* renamed from: h, reason: collision with root package name */
    private long f12564h;
    private long i;
    private final /* synthetic */ C1032ol j;

    public C1101tl(C1032ol c1032ol, Uri uri, zzov zzovVar, C1115ul c1115ul, zzpq zzpqVar) {
        this.j = c1032ol;
        zzpo.checkNotNull(uri);
        this.f12557a = uri;
        zzpo.checkNotNull(zzovVar);
        this.f12558b = zzovVar;
        zzpo.checkNotNull(c1115ul);
        this.f12559c = c1115ul;
        this.f12560d = zzpqVar;
        this.f12561e = new zzif();
        this.f12563g = true;
        this.i = -1L;
    }

    public final void a(long j, long j2) {
        this.f12561e.zzaha = j;
        this.f12564h = j2;
        this.f12563g = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void cancelLoad() {
        this.f12562f = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final boolean zzfe() {
        return this.f12562f;
    }

    @Override // com.google.android.gms.internal.ads.zzpi
    public final void zzff() throws IOException, InterruptedException {
        zzhx zzhxVar;
        long j;
        int i = 0;
        while (i == 0 && !this.f12562f) {
            try {
                j = this.f12561e.zzaha;
                this.i = this.f12558b.zza(new zzoz(this.f12557a, j, -1L, C1032ol.f(this.j)));
                if (this.i != -1) {
                    this.i += j;
                }
                zzhxVar = new zzhx(this.f12558b, j, this.i);
            } catch (Throwable th) {
                th = th;
                zzhxVar = null;
            }
            try {
                zzhz a2 = this.f12559c.a(zzhxVar, this.f12558b.getUri());
                if (this.f12563g) {
                    a2.zzc(j, this.f12564h);
                    this.f12563g = false;
                }
                while (i == 0 && !this.f12562f) {
                    this.f12560d.block();
                    i = a2.zza(zzhxVar, this.f12561e);
                    if (zzhxVar.getPosition() > C1032ol.g(this.j) + j) {
                        j = zzhxVar.getPosition();
                        this.f12560d.zzha();
                        C1032ol.i(this.j).post(C1032ol.h(this.j));
                    }
                }
                if (i == 1) {
                    i = 0;
                } else {
                    this.f12561e.zzaha = zzhxVar.getPosition();
                }
                zzqe.zza(this.f12558b);
            } catch (Throwable th2) {
                th = th2;
                if (i != 1 && zzhxVar != null) {
                    this.f12561e.zzaha = zzhxVar.getPosition();
                }
                zzqe.zza(this.f12558b);
                throw th;
            }
        }
    }
}
