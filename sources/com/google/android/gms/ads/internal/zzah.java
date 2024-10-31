package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaan;
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
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxe;
import com.google.android.gms.internal.ads.zzxz;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzah extends zzxe {

    /* renamed from: a, reason: collision with root package name */
    private final Context f10181a;

    /* renamed from: b, reason: collision with root package name */
    private final zzxa f10182b;

    /* renamed from: c, reason: collision with root package name */
    private final zzalg f10183c;

    /* renamed from: d, reason: collision with root package name */
    private final zzaeb f10184d;

    /* renamed from: e, reason: collision with root package name */
    private final zzaeq f10185e;

    /* renamed from: f, reason: collision with root package name */
    private final zzagf f10186f;

    /* renamed from: g, reason: collision with root package name */
    private final zzaee f10187g;

    /* renamed from: h, reason: collision with root package name */
    private final zzaen f10188h;
    private final zzwf i;
    private final PublisherAdViewOptions j;
    private final SimpleArrayMap<String, zzaek> k;
    private final SimpleArrayMap<String, zzaeh> l;
    private final zzacp m;
    private final zzafz n;
    private final zzxz o;
    private final String p;
    private final zzbbi q;
    private WeakReference<zzc> r;
    private final zzv s;
    private final Object t = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(Context context, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzxa zzxaVar, zzaeb zzaebVar, zzaeq zzaeqVar, zzagf zzagfVar, zzaee zzaeeVar, SimpleArrayMap<String, zzaek> simpleArrayMap, SimpleArrayMap<String, zzaeh> simpleArrayMap2, zzacp zzacpVar, zzafz zzafzVar, zzxz zzxzVar, zzv zzvVar, zzaen zzaenVar, zzwf zzwfVar, PublisherAdViewOptions publisherAdViewOptions) {
        this.f10181a = context;
        this.p = str;
        this.f10183c = zzalgVar;
        this.q = zzbbiVar;
        this.f10182b = zzxaVar;
        this.f10187g = zzaeeVar;
        this.f10184d = zzaebVar;
        this.f10185e = zzaeqVar;
        this.f10186f = zzagfVar;
        this.k = simpleArrayMap;
        this.l = simpleArrayMap2;
        this.m = zzacpVar;
        this.n = zzafzVar;
        this.o = zzxzVar;
        this.s = zzvVar;
        this.f10188h = zzaenVar;
        this.i = zzwfVar;
        this.j = publisherAdViewOptions;
        zzaan.initialize(this.f10181a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A() {
        return this.f10186f == null && this.f10188h != null;
    }

    private final boolean B() {
        if (this.f10184d != null || this.f10187g != null || this.f10185e != null) {
            return true;
        }
        SimpleArrayMap<String, zzaek> simpleArrayMap = this.k;
        return simpleArrayMap != null && simpleArrayMap.size() > 0;
    }

    private final List<String> C() {
        ArrayList arrayList = new ArrayList();
        if (this.f10187g != null) {
            arrayList.add("1");
        }
        if (this.f10184d != null) {
            arrayList.add("2");
        }
        if (this.f10185e != null) {
            arrayList.add("6");
        }
        if (this.k.size() > 0) {
            arrayList.add("3");
        }
        if (this.f10186f != null) {
            arrayList.add("2");
            arrayList.add("1");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzwb zzwbVar) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcup)).booleanValue() && this.f10185e != null) {
            zzbr(0);
            return;
        }
        zzp zzpVar = new zzp(this.f10181a, this.s, this.i, this.p, this.f10183c, this.q);
        this.r = new WeakReference<>(zzpVar);
        zzaen zzaenVar = this.f10188h;
        Preconditions.a("setOnPublisherAdViewLoadedListener must be called on the main UI thread.");
        zzpVar.zzbls.B = zzaenVar;
        PublisherAdViewOptions publisherAdViewOptions = this.j;
        if (publisherAdViewOptions != null) {
            if (publisherAdViewOptions.O() != null) {
                zzpVar.zza(this.j.O());
            }
            zzpVar.setManualImpressionsEnabled(this.j.a());
        }
        zzaeb zzaebVar = this.f10184d;
        Preconditions.a("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzpVar.zzbls.r = zzaebVar;
        zzaeq zzaeqVar = this.f10185e;
        Preconditions.a("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
        zzpVar.zzbls.t = zzaeqVar;
        zzaee zzaeeVar = this.f10187g;
        Preconditions.a("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzpVar.zzbls.s = zzaeeVar;
        SimpleArrayMap<String, zzaek> simpleArrayMap = this.k;
        Preconditions.a("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzpVar.zzbls.w = simpleArrayMap;
        SimpleArrayMap<String, zzaeh> simpleArrayMap2 = this.l;
        Preconditions.a("setOnCustomClickListener must be called on the main UI thread.");
        zzpVar.zzbls.v = simpleArrayMap2;
        zzacp zzacpVar = this.m;
        Preconditions.a("setNativeAdOptions must be called on the main UI thread.");
        zzpVar.zzbls.x = zzacpVar;
        zzpVar.a(C());
        zzpVar.zza(this.f10182b);
        zzpVar.zza(this.o);
        ArrayList arrayList = new ArrayList();
        if (B()) {
            arrayList.add(1);
        }
        if (this.f10188h != null) {
            arrayList.add(2);
        }
        zzpVar.b(arrayList);
        if (B()) {
            zzwbVar.extras.putBoolean("ina", true);
        }
        if (this.f10188h != null) {
            zzwbVar.extras.putBoolean("iba", true);
        }
        zzpVar.zzb(zzwbVar);
    }

    private final void zzbr(int i) {
        zzxa zzxaVar = this.f10182b;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdFailedToLoad(0);
            } catch (RemoteException e2) {
                zzbbd.zzc("Failed calling onAdFailedToLoad.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String getMediationAdapterClassName() {
        synchronized (this.t) {
            if (this.r == null) {
                return null;
            }
            zzc zzcVar = this.r.get();
            return zzcVar != null ? zzcVar.getMediationAdapterClassName() : null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final boolean isLoading() {
        synchronized (this.t) {
            if (this.r == null) {
                return false;
            }
            zzc zzcVar = this.r.get();
            return zzcVar != null ? zzcVar.isLoading() : false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zza(zzwb zzwbVar, int i) {
        if (i > 0) {
            a(new RunnableC0778d(this, zzwbVar, i));
            return;
        }
        throw new IllegalArgumentException("Number of ads has to be more than 0");
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final void zzd(zzwb zzwbVar) {
        a(new RunnableC0777c(this, zzwbVar));
    }

    @Override // com.google.android.gms.internal.ads.zzxd
    public final String zzje() {
        synchronized (this.t) {
            if (this.r == null) {
                return null;
            }
            zzc zzcVar = this.r.get();
            return zzcVar != null ? zzcVar.zzje() : null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzwb zzwbVar, int i) {
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcup)).booleanValue() && this.f10185e != null) {
            zzbr(0);
            return;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcuq)).booleanValue() && this.f10186f != null) {
            zzbr(0);
            return;
        }
        Context context = this.f10181a;
        zzbb zzbbVar = new zzbb(context, this.s, zzwf.zzg(context), this.p, this.f10183c, this.q);
        this.r = new WeakReference<>(zzbbVar);
        zzaeb zzaebVar = this.f10184d;
        Preconditions.a("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        zzbbVar.zzbls.r = zzaebVar;
        zzaeq zzaeqVar = this.f10185e;
        Preconditions.a("setOnUnifiedNativeAdLoadedListener must be called on the main UI thread.");
        zzbbVar.zzbls.t = zzaeqVar;
        zzagf zzagfVar = this.f10186f;
        Preconditions.a("#008 Must be called on the main UI thread.: setInstreamAdLoadCallback");
        zzbbVar.zzbls.u = zzagfVar;
        zzaee zzaeeVar = this.f10187g;
        Preconditions.a("setOnContentAdLoadedListener must be called on the main UI thread.");
        zzbbVar.zzbls.s = zzaeeVar;
        SimpleArrayMap<String, zzaek> simpleArrayMap = this.k;
        Preconditions.a("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        zzbbVar.zzbls.w = simpleArrayMap;
        zzbbVar.zza(this.f10182b);
        SimpleArrayMap<String, zzaeh> simpleArrayMap2 = this.l;
        Preconditions.a("setOnCustomClickListener must be called on the main UI thread.");
        zzbbVar.zzbls.v = simpleArrayMap2;
        zzbbVar.a(C());
        zzacp zzacpVar = this.m;
        Preconditions.a("setNativeAdOptions must be called on the main UI thread.");
        zzbbVar.zzbls.x = zzacpVar;
        zzafz zzafzVar = this.n;
        Preconditions.a("#008 Must be called on the main UI thread.: setInstreamAdConfiguration");
        zzbbVar.zzbls.z = zzafzVar;
        zzbbVar.zza(this.o);
        zzbbVar.c(i);
        zzbbVar.zzb(zzwbVar);
    }

    private static void a(Runnable runnable) {
        zzayh.zzelc.post(runnable);
    }
}
