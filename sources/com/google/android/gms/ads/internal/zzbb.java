package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzabs;
import com.google.android.gms.internal.ads.zzabu;
import com.google.android.gms.internal.ads.zzabw;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzace;
import com.google.android.gms.internal.ads.zzacf;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzaek;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzaly;
import com.google.android.gms.internal.ads.zzaow;
import com.google.android.gms.internal.ads.zzapl;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcl;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzri;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbb extends zzc implements zzace {

    /* renamed from: a, reason: collision with root package name */
    private final Object f10218a;

    /* renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private boolean f10219b;

    /* renamed from: c, reason: collision with root package name */
    private zzbcl<zzacf> f10220c;

    /* renamed from: d, reason: collision with root package name */
    private zzbgg f10221d;

    /* renamed from: e, reason: collision with root package name */
    private zzbgg f10222e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f10223f;

    /* renamed from: g, reason: collision with root package name */
    private int f10224g;

    /* renamed from: h, reason: collision with root package name */
    private zzaqp f10225h;
    private final String i;

    public zzbb(Context context, zzv zzvVar, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar) {
        this(context, zzvVar, zzwfVar, str, zzalgVar, zzbbiVar, false);
    }

    private final boolean I() {
        zzaxf zzaxfVar = this.zzbls.j;
        return zzaxfVar != null && zzaxfVar.zzdzc;
    }

    private final zzakr J() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || !zzaxfVar.zzdyd) {
            return null;
        }
        return zzaxfVar.zzehj;
    }

    private final void K() {
        zzaqp C = C();
        if (C != null) {
            C.zzug();
        }
    }

    private final void a(zzabs zzabsVar) {
        zzayh.zzelc.post(new RunnableC0794u(this, zzabsVar));
    }

    public final String A() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B() throws zzbgq {
        synchronized (this.f10218a) {
            zzaxz.v("Initializing webview native ads utills");
            this.f10225h = new zzaqt(this.zzbls.f10251c, this, this.i, this.zzbls.f10252d, this.zzbls.f10253e);
        }
    }

    public final zzaqp C() {
        zzaqp zzaqpVar;
        synchronized (this.f10218a) {
            zzaqpVar = this.f10225h;
        }
        return zzaqpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Future<zzacf> D() {
        return this.f10220c;
    }

    public final void E() {
        if (this.zzbls.j != null && this.f10221d != null) {
            zzrf zzym = zzbv.i().zzym();
            zzbw zzbwVar = this.zzbls;
            zzym.zza(zzbwVar.i, zzbwVar.j, this.f10221d.getView(), this.f10221d);
            this.f10223f = false;
            return;
        }
        this.f10223f = true;
        zzbbd.zzeo("Request to enable ActiveView before adState is available.");
    }

    public final void F() {
        this.f10223f = false;
        if (this.zzbls.j != null && this.f10221d != null) {
            zzbv.i().zzym().zzh(this.zzbls.j);
        } else {
            zzbbd.zzeo("Request to enable ActiveView before adState is available.");
        }
    }

    public final SimpleArrayMap<String, zzaek> G() {
        Preconditions.a("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzbls.w;
    }

    public final void H() {
        zzbgg zzbggVar;
        zzacp zzacpVar;
        zzbgg zzbggVar2 = this.f10221d;
        if (zzbggVar2 != null && zzbggVar2.zzabu() != null && (zzacpVar = this.zzbls.x) != null && zzacpVar.zzdcw != null) {
            this.f10221d.zzabu().zzb(this.zzbls.x.zzdcw);
        } else {
            if (this.zzbls.u == null || (zzbggVar = this.f10221d) == null || zzbggVar.zzabu() == null) {
                return;
            }
            this.f10221d.zzabu().zza(false, true, false);
        }
    }

    public final void b(zzbgg zzbggVar) {
        this.f10222e = zzbggVar;
    }

    public final void c(int i) {
        Preconditions.a("setMaxNumberOfAds must be called on the main UI thread.");
        this.f10224g = i;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final String getAdUnitId() {
        return this.zzbls.f10250b;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzwb zzwbVar, zzaba zzabaVar) {
        try {
            B();
            return super.zza(zzwbVar, zzabaVar, this.f10224g);
        } catch (Exception e2) {
            if (!zzbbd.isLoggable(4)) {
                return false;
            }
            Log.i("Ads", "Error initializing webview.", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final zzaeh zzar(String str) {
        Preconditions.a("getOnCustomClickListener must be called on the main UI thread.");
        SimpleArrayMap<String, zzaeh> simpleArrayMap = this.zzbls.v;
        if (simpleArrayMap == null) {
            return null;
        }
        return simpleArrayMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(IObjectWrapper iObjectWrapper) {
        Object a2 = iObjectWrapper != null ? ObjectWrapper.a(iObjectWrapper) : null;
        if (a2 instanceof zzacd) {
            ((zzacd) a2).zzsm();
        }
        super.zzb(this.zzbls.j, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzbr(int i) {
        zzg(i, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzg(int i, boolean z) {
        K();
        super.zzg(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzi(View view) {
        boolean z = this.f10222e != null;
        if (!I() || this.zzblx == null || !z || view == null) {
            return;
        }
        zzbv.v().zza(this.zzblx, view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzil() {
        zzm(false);
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzix() {
        zzys zzqh;
        zzalj zzaljVar = this.zzbls.j.zzdnc;
        if (zzaljVar == null) {
            super.zzix();
            return;
        }
        zzyp zzypVar = null;
        try {
            zzals zzuu = zzaljVar.zzuu();
            if (zzuu != null) {
                zzypVar = zzuu.getVideoController();
            } else {
                zzalv zzuv = zzaljVar.zzuv();
                if (zzuv != null) {
                    zzypVar = zzuv.getVideoController();
                } else {
                    zzadx zzuz = zzaljVar.zzuz();
                    if (zzuz != null) {
                        zzypVar = zzuz.getVideoController();
                    }
                }
            }
            if (zzypVar == null || (zzqh = zzypVar.zzqh()) == null) {
                return;
            }
            zzqh.onVideoEnd();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zziy() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(zzaxfVar.zzdnd)) {
            zzin();
        } else {
            super.zziy();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzaks
    public final void zzjd() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar != null && "com.google.ads.mediation.admob.AdMobAdapter".equals(zzaxfVar.zzdnd)) {
            zzim();
        } else {
            super.zzjd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjl() {
        if (I() && this.zzblx != null) {
            zzbgg zzbggVar = this.f10222e;
            if (zzbggVar == null && (zzbggVar = this.f10221d) == null) {
                zzbggVar = null;
            }
            if (zzbggVar != null) {
                zzbggVar.zza("onSdkImpression", new HashMap());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjm() {
        this.zzblx = null;
        zzbgg zzbggVar = this.f10222e;
        if (zzbggVar != null) {
            zzbggVar.destroy();
            this.f10222e = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zzjn() {
        zzbgg zzbggVar = this.f10221d;
        if (zzbggVar != null) {
            zzbggVar.destroy();
            this.f10221d = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjo() {
        if (J() != null) {
            return J().zzdmd;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjp() {
        if (J() != null) {
            return J().zzdme;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final boolean zzjq() {
        if (J() != null) {
            return J().zzdmf;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final void zzm(boolean z) {
        super.zzm(z);
        if (this.f10223f) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuk)).booleanValue()) {
                E();
            }
        }
    }

    public zzbb(Context context, zzv zzvVar, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar, boolean z) {
        super(context, zzwfVar, str, zzalgVar, zzbbiVar, zzvVar);
        this.f10218a = new Object();
        this.f10220c = new zzbcl<>();
        this.f10224g = 1;
        this.i = UUID.randomUUID().toString();
        this.f10219b = z;
    }

    private final void a(zzabz zzabzVar) {
        zzayh.zzelc.post(new RunnableC0795v(this, zzabzVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzabz b(zzacf zzacfVar) {
        zzabz zzabzVar;
        Object obj;
        Object obj2 = null;
        if (zzacfVar instanceof zzabu) {
            zzabu zzabuVar = (zzabu) zzacfVar;
            zzabzVar = new zzabz(zzabuVar.getHeadline(), zzabuVar.getImages(), zzabuVar.getBody(), zzabuVar.zzsf(), zzabuVar.getCallToAction(), zzabuVar.getAdvertiser(), -1.0d, null, null, zzabuVar.zzrw(), zzabuVar.getVideoController(), zzabuVar.zzrx(), zzabuVar.zzsd(), zzabuVar.getMediationAdapterClassName(), zzabuVar.getExtras());
            if (zzabuVar.zzsc() != null) {
                obj = ObjectWrapper.a(zzabuVar.zzsc());
                obj2 = obj;
            }
        } else if (zzacfVar instanceof zzabs) {
            zzabs zzabsVar = (zzabs) zzacfVar;
            zzabzVar = new zzabz(zzabsVar.getHeadline(), zzabsVar.getImages(), zzabsVar.getBody(), zzabsVar.zzsb(), zzabsVar.getCallToAction(), null, zzabsVar.getStarRating(), zzabsVar.getStore(), zzabsVar.getPrice(), zzabsVar.zzrw(), zzabsVar.getVideoController(), zzabsVar.zzrx(), zzabsVar.zzsd(), zzabsVar.getMediationAdapterClassName(), zzabsVar.getExtras());
            if (zzabsVar.zzsc() != null) {
                obj = ObjectWrapper.a(zzabsVar.zzsc());
                obj2 = obj;
            }
        } else {
            zzabzVar = null;
        }
        if (obj2 instanceof zzach) {
            zzabzVar.zzb((zzach) obj2);
        }
        return zzabzVar;
    }

    private final void a(zzabu zzabuVar) {
        zzayh.zzelc.post(new RunnableC0796w(this, zzabuVar));
    }

    private final void a(String str, boolean z) {
        String str2;
        if (z) {
            if (this.f10222e == null && this.f10221d == null) {
                return;
            }
            boolean z2 = this.f10222e != null;
            boolean z3 = this.f10221d != null;
            zzbgg zzbggVar = null;
            if (z2) {
                str2 = null;
                zzbggVar = this.f10222e;
            } else if (z3) {
                zzbggVar = this.f10221d;
                str2 = "javascript";
            } else {
                str2 = null;
            }
            if (zzbggVar.getWebView() != null && zzbv.v().zzk(this.zzbls.f10251c)) {
                zzbbi zzbbiVar = this.zzbls.f10253e;
                int i = zzbbiVar.zzeou;
                int i2 = zzbbiVar.zzeov;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                this.zzblx = zzbv.v().zza(sb.toString(), zzbggVar.getWebView(), "", "javascript", str2, str);
                IObjectWrapper iObjectWrapper = this.zzblx;
                if (iObjectWrapper == null) {
                    return;
                }
                zzbggVar.zzaa(iObjectWrapper);
                if (z3) {
                    IObjectWrapper iObjectWrapper2 = this.zzblx;
                    View view = this.f10221d.getView();
                    if (view != null) {
                        zzbv.v().zza(iObjectWrapper2, view);
                    }
                }
                zzbv.v().zzo(this.zzblx);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.zza
    public final void zza(final zzaxg zzaxgVar, zzaba zzabaVar) {
        zzwf zzwfVar = zzaxgVar.zzbst;
        if (zzwfVar != null) {
            this.zzbls.i = zzwfVar;
        }
        if (zzaxgVar.errorCode != -2) {
            zzayh.zzelc.post(new Runnable(this, zzaxgVar) { // from class: com.google.android.gms.ads.internal.q

                /* renamed from: a, reason: collision with root package name */
                private final zzbb f10146a;

                /* renamed from: b, reason: collision with root package name */
                private final zzaxg f10147b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f10146a = this;
                    this.f10147b = zzaxgVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f10146a.zzb(new zzaxf(this.f10147b, null, null, null, null, null, null, null));
                }
            });
            return;
        }
        int i = zzaxgVar.zzeag.zzdxq;
        if (i == 1) {
            zzbw zzbwVar = this.zzbls;
            zzbwVar.L = 0;
            zzbv.d();
            zzbw zzbwVar2 = this.zzbls;
            zzbwVar.f10256h = zzapl.zza(zzbwVar2.f10251c, this, zzaxgVar, zzbwVar2.f10252d, null, this.zzbma, this, zzabaVar);
            String valueOf = String.valueOf(this.zzbls.f10256h.getClass().getName());
            zzbbd.zzdn(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
            return;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONArray jSONArray2 = new JSONObject(zzaxgVar.zzehy.zzdyb).getJSONArray("slots");
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                JSONArray optJSONArray = jSONArray2.getJSONObject(i2).optJSONArray("ads");
                for (int i3 = 0; optJSONArray != null && i3 < optJSONArray.length(); i3++) {
                    jSONArray.put(optJSONArray.get(i3));
                }
            }
            K();
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i; i4++) {
                arrayList.add(zzayf.zza(new CallableC0792s(this, i4, jSONArray, i, zzaxgVar)));
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                try {
                    zzayh.zzelc.post(new RunnableC0793t(this, (zzacf) ((zzbcb) arrayList.get(i5)).get(((Long) zzwu.zzpz().zzd(zzaan.zzctf)).longValue(), TimeUnit.MILLISECONDS), i5, arrayList));
                } catch (InterruptedException e2) {
                    zzbbd.zzc("", e2);
                    Thread.currentThread().interrupt();
                } catch (CancellationException e3) {
                    e = e3;
                    zzbbd.zzc("", e);
                } catch (ExecutionException e4) {
                    e = e4;
                    zzbbd.zzc("", e);
                } catch (TimeoutException e5) {
                    e = e5;
                    zzbbd.zzc("", e);
                }
            }
        } catch (JSONException e6) {
            zzbbd.zzc("Malformed native ad response", e6);
            zzbr(0);
        }
    }

    public final void a(List<String> list) {
        Preconditions.a("setNativeTemplates must be called on the main UI thread.");
        this.zzbls.I = list;
    }

    public final void a(zzbgg zzbggVar) {
        this.f10221d = zzbggVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(zzbw zzbwVar, zzbw zzbwVar2) {
        if (zzbwVar2.r == null) {
            zzbwVar2.r = zzbwVar.r;
        }
        if (zzbwVar2.s == null) {
            zzbwVar2.s = zzbwVar.s;
        }
        if (zzbwVar2.v == null) {
            zzbwVar2.v = zzbwVar.v;
        }
        if (zzbwVar2.w == null) {
            zzbwVar2.w = zzbwVar.w;
        }
        if (zzbwVar2.y == null) {
            zzbwVar2.y = zzbwVar.y;
        }
        if (zzbwVar2.x == null) {
            zzbwVar2.x = zzbwVar.x;
        }
        if (zzbwVar2.I == null) {
            zzbwVar2.I = zzbwVar.I;
        }
        if (zzbwVar2.l == null) {
            zzbwVar2.l = zzbwVar.l;
        }
        if (zzbwVar2.J == null) {
            zzbwVar2.J = zzbwVar.J;
        }
        if (zzbwVar2.m == null) {
            zzbwVar2.m = zzbwVar.m;
        }
        if (zzbwVar2.n == null) {
            zzbwVar2.n = zzbwVar.n;
        }
        if (zzbwVar2.i == null) {
            zzbwVar2.i = zzbwVar.i;
        }
        if (zzbwVar2.j == null) {
            zzbwVar2.j = zzbwVar.j;
        }
        if (zzbwVar2.k == null) {
            zzbwVar2.k = zzbwVar.k;
        }
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected final boolean zza(zzwb zzwbVar, zzaxf zzaxfVar, boolean z) {
        return this.zzblr.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    public final boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        SimpleArrayMap<String, zzaek> simpleArrayMap;
        a((List<String>) null);
        if (this.zzbls.d()) {
            if (zzaxfVar2.zzdyd) {
                K();
                try {
                    zzaly zzva = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzva() : null;
                    zzals zzuu = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuu() : null;
                    zzalv zzuv = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuv() : null;
                    zzadx zzuz = zzaxfVar2.zzdnc != null ? zzaxfVar2.zzdnc.zzuz() : null;
                    String zzc = zzc.zzc(zzaxfVar2);
                    if (zzva != null && this.zzbls.t != null) {
                        zzabz zzabzVar = new zzabz(zzva.getHeadline(), zzva.getImages(), zzva.getBody(), zzva.zzsb() != null ? zzva.zzsb() : null, zzva.getCallToAction(), zzva.getAdvertiser(), zzva.getStarRating(), zzva.getStore(), zzva.getPrice(), null, zzva.getVideoController(), zzva.zzvc() != null ? (View) ObjectWrapper.a(zzva.zzvc()) : null, zzva.zzsd(), zzc, zzva.getExtras());
                        zzabzVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzva, zzabzVar));
                        a(zzabzVar);
                    } else if (zzuu != null && this.zzbls.t != null) {
                        zzabz zzabzVar2 = new zzabz(zzuu.getHeadline(), zzuu.getImages(), zzuu.getBody(), zzuu.zzsb() != null ? zzuu.zzsb() : null, zzuu.getCallToAction(), null, zzuu.getStarRating(), zzuu.getStore(), zzuu.getPrice(), null, zzuu.getVideoController(), zzuu.zzvc() != null ? (View) ObjectWrapper.a(zzuu.zzvc()) : null, zzuu.zzsd(), zzc, zzuu.getExtras());
                        zzabzVar2.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuu, zzabzVar2));
                        a(zzabzVar2);
                    } else if (zzuu != null && this.zzbls.r != null) {
                        zzabs zzabsVar = new zzabs(zzuu.getHeadline(), zzuu.getImages(), zzuu.getBody(), zzuu.zzsb() != null ? zzuu.zzsb() : null, zzuu.getCallToAction(), zzuu.getStarRating(), zzuu.getStore(), zzuu.getPrice(), null, zzuu.getExtras(), zzuu.getVideoController(), zzuu.zzvc() != null ? (View) ObjectWrapper.a(zzuu.zzvc()) : null, zzuu.zzsd(), zzc);
                        zzabsVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuu, zzabsVar));
                        a(zzabsVar);
                    } else if (zzuv != null && this.zzbls.t != null) {
                        zzabz zzabzVar3 = new zzabz(zzuv.getHeadline(), zzuv.getImages(), zzuv.getBody(), zzuv.zzsf() != null ? zzuv.zzsf() : null, zzuv.getCallToAction(), zzuv.getAdvertiser(), -1.0d, null, null, null, zzuv.getVideoController(), zzuv.zzvc() != null ? (View) ObjectWrapper.a(zzuv.zzvc()) : null, zzuv.zzsd(), zzc, zzuv.getExtras());
                        zzabzVar3.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuv, zzabzVar3));
                        a(zzabzVar3);
                    } else if (zzuv != null && this.zzbls.s != null) {
                        zzabu zzabuVar = new zzabu(zzuv.getHeadline(), zzuv.getImages(), zzuv.getBody(), zzuv.zzsf() != null ? zzuv.zzsf() : null, zzuv.getCallToAction(), zzuv.getAdvertiser(), null, zzuv.getExtras(), zzuv.getVideoController(), zzuv.zzvc() != null ? (View) ObjectWrapper.a(zzuv.zzvc()) : null, zzuv.zzsd(), zzc);
                        zzabuVar.zzb(new zzacc(this.zzbls.f10251c, this, this.zzbls.f10252d, zzuv, zzabuVar));
                        a(zzabuVar);
                    } else if (zzuz != null && this.zzbls.w != null && this.zzbls.w.get(zzuz.getCustomTemplateId()) != null) {
                        zzayh.zzelc.post(new y(this, zzuz));
                    } else {
                        zzbbd.zzeo("No matching mapper/listener for retrieved native ad template.");
                        zzbr(0);
                        return false;
                    }
                } catch (RemoteException e2) {
                    zzbbd.zzd("#007 Could not call remote method.", e2);
                }
            } else {
                zzacf zzacfVar = zzaxfVar2.zzehp;
                if (this.f10219b) {
                    a("Google", zzaxfVar2.zzdzc);
                    this.f10220c.set(zzacfVar);
                } else {
                    boolean z = zzacfVar instanceof zzabu;
                    if (z && this.zzbls.t != null) {
                        a("Google", zzaxfVar2.zzdzc);
                        a(b(zzaxfVar2.zzehp));
                    } else if (z && this.zzbls.s != null) {
                        a("Google", zzaxfVar2.zzdzc);
                        a((zzabu) zzaxfVar2.zzehp);
                    } else {
                        boolean z2 = zzacfVar instanceof zzabs;
                        if (z2 && this.zzbls.t != null) {
                            a("Google", zzaxfVar2.zzdzc);
                            a(b(zzaxfVar2.zzehp));
                        } else if (z2 && this.zzbls.r != null) {
                            a("Google", zzaxfVar2.zzdzc);
                            a((zzabs) zzaxfVar2.zzehp);
                        } else {
                            if ((zzacfVar instanceof zzabw) && (simpleArrayMap = this.zzbls.w) != null) {
                                zzabw zzabwVar = (zzabw) zzacfVar;
                                if (simpleArrayMap.get(zzabwVar.getCustomTemplateId()) != null) {
                                    zzayh.zzelc.post(new x(this, zzabwVar.getCustomTemplateId(), zzaxfVar2));
                                }
                            }
                            if ((zzacfVar instanceof zzabq) && this.zzbls.u != null) {
                                final zzabq zzabqVar = (zzabq) zzacfVar;
                                zzayh.zzelc.post(new Runnable(this, zzabqVar) { // from class: com.google.android.gms.ads.internal.r

                                    /* renamed from: a, reason: collision with root package name */
                                    private final zzbb f10148a;

                                    /* renamed from: b, reason: collision with root package name */
                                    private final zzabq f10149b;

                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        this.f10148a = this;
                                        this.f10149b = zzabqVar;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        zzbb zzbbVar = this.f10148a;
                                        zzabq zzabqVar2 = this.f10149b;
                                        try {
                                            if (zzbbVar.zzbls.u != null) {
                                                zzbbVar.zzbls.u.zza(zzabqVar2);
                                            }
                                        } catch (RemoteException e3) {
                                            zzbbd.zzd("#007 Could not call remote method.", e3);
                                        }
                                    }
                                });
                            } else {
                                zzbbd.zzeo("No matching listener for retrieved native ad template.");
                                zzbr(0);
                                return false;
                            }
                        }
                    }
                }
            }
            return super.zza(zzaxfVar, zzaxfVar2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacd zzacdVar) {
        zzbw zzbwVar = this.zzbls;
        if (zzbwVar.j.zzehh != null && zzbwVar.z == null) {
            zzrf zzym = zzbv.i().zzym();
            zzbw zzbwVar2 = this.zzbls;
            zzym.zza(zzbwVar2.i, zzbwVar2.j, new zzri(zzacdVar), (zzbgg) null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzace
    public final void zza(zzacb zzacbVar) {
        zzbgg zzbggVar = this.f10221d;
        if (zzbggVar != null) {
            zzbggVar.zzb(zzacbVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzaow zzaowVar) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void zza(zzabg zzabgVar) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }
}
