package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaee;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzafz;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxh;
import com.google.android.gms.internal.ads.zzxz;

@zzark
/* loaded from: classes.dex */
public final class zzak extends zzxh {

    /* renamed from: a, reason: collision with root package name */
    private zzxa f10189a;

    /* renamed from: b, reason: collision with root package name */
    private zzaeb f10190b;

    /* renamed from: c, reason: collision with root package name */
    private zzaeq f10191c;

    /* renamed from: d, reason: collision with root package name */
    private zzaee f10192d;

    /* renamed from: g, reason: collision with root package name */
    private zzaen f10195g;

    /* renamed from: h, reason: collision with root package name */
    private zzwf f10196h;
    private PublisherAdViewOptions i;
    private zzacp j;
    private zzafz k;
    private zzagf l;
    private zzxz m;
    private final Context n;
    private final zzalg o;
    private final String p;
    private final zzbbi q;
    private final zzv r;

    /* renamed from: f, reason: collision with root package name */
    private SimpleArrayMap<String, zzaek> f10194f = new SimpleArrayMap<>();

    /* renamed from: e, reason: collision with root package name */
    private SimpleArrayMap<String, zzaeh> f10193e = new SimpleArrayMap<>();

    public zzak(Context context, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzv zzvVar) {
        this.n = context;
        this.p = str;
        this.o = zzalgVar;
        this.q = zzbbiVar;
        this.r = zzvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzacp zzacpVar) {
        this.j = zzacpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxa zzxaVar) {
        this.f10189a = zzxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final zzxd zzkd() {
        return new zzah(this.n, this.p, this.o, this.q, this.f10189a, this.f10190b, this.f10191c, this.l, this.f10192d, this.f10194f, this.f10193e, this.j, this.k, this.m, this.r, this.f10195g, this.f10196h, this.i);
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.i = publisherAdViewOptions;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zzb(zzxz zzxzVar) {
        this.m = zzxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzafz zzafzVar) {
        this.k = zzafzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaee zzaeeVar) {
        this.f10192d = zzaeeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeb zzaebVar) {
        this.f10190b = zzaebVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaeq zzaeqVar) {
        this.f10191c = zzaeqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzagf zzagfVar) {
        this.l = zzagfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(String str, zzaek zzaekVar, zzaeh zzaehVar) {
        if (!TextUtils.isEmpty(str)) {
            this.f10194f.put(str, zzaekVar);
            this.f10193e.put(str, zzaehVar);
            return;
        }
        throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }

    @Override // com.google.android.gms.internal.ads.zzxg
    public final void zza(zzaen zzaenVar, zzwf zzwfVar) {
        this.f10195g = zzaenVar;
        this.f10196h = zzwfVar;
    }
}
