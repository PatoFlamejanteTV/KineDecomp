package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzal;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.internal.ads.pa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1035pa {

    /* renamed from: a, reason: collision with root package name */
    zzal f12413a;

    /* renamed from: b, reason: collision with root package name */
    zzwb f12414b;

    /* renamed from: c, reason: collision with root package name */
    I f12415c;

    /* renamed from: d, reason: collision with root package name */
    long f12416d;

    /* renamed from: e, reason: collision with root package name */
    boolean f12417e;

    /* renamed from: f, reason: collision with root package name */
    boolean f12418f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ C1021oa f12419g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1035pa(C1021oa c1021oa, zzagi zzagiVar) {
        String str;
        this.f12419g = c1021oa;
        str = c1021oa.f12377c;
        this.f12413a = zzagiVar.zzby(str);
        this.f12415c = new I();
        I i = this.f12415c;
        zzal zzalVar = this.f12413a;
        zzalVar.zza(new J(i));
        zzalVar.zza(new S(i));
        zzalVar.zza(new U(i));
        zzalVar.zza(new W(i));
        zzalVar.zza(new Y(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        if (this.f12417e) {
            return false;
        }
        zzwb zzwbVar = this.f12414b;
        if (zzwbVar == null) {
            zzwbVar = this.f12419g.f12376b;
        }
        this.f12418f = this.f12413a.zzb(zzahm.zzi(zzwbVar));
        this.f12417e = true;
        this.f12416d = com.google.android.gms.ads.internal.zzbv.l().a();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1035pa(C1021oa c1021oa, zzagi zzagiVar, zzwb zzwbVar) {
        this(c1021oa, zzagiVar);
        this.f12414b = zzwbVar;
    }
}
