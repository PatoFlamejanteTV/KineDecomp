package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.gmsg.zzf;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzaqf {
    private final Context mContext;
    private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private final zzaba zzbln;
    private final DisplayMetrics zzbwk;
    private final zzcu zzdcf;
    private final zzaxg zzdsk;
    private final com.google.android.gms.ads.internal.zzbb zzdug;
    private ViewTreeObserver.OnScrollChangedListener zzduh;
    private final Object mLock = new Object();
    private int zzbty = -1;
    private int zzbtz = -1;
    private zzbai zzbua = new zzbai(200);

    public zzaqf(Context context, zzcu zzcuVar, zzaxg zzaxgVar, zzaba zzabaVar, com.google.android.gms.ads.internal.zzbb zzbbVar) {
        this.mContext = context;
        this.zzdcf = zzcuVar;
        this.zzdsk = zzaxgVar;
        this.zzbln = zzabaVar;
        this.zzdug = zzbbVar;
        com.google.android.gms.ads.internal.zzbv.e();
        this.zzbwk = zzayh.zza((WindowManager) context.getSystemService("window"));
    }

    private final void zza(zzbgg zzbggVar, boolean z) {
        zzbggVar.zza("/video", zzf.l);
        zzbggVar.zza("/videoMeta", zzf.m);
        zzbggVar.zza("/precache", new zzbfq());
        zzbggVar.zza("/delayPageLoaded", zzf.p);
        zzbggVar.zza("/instrument", zzf.n);
        zzbggVar.zza("/log", zzf.f10078g);
        zzbggVar.zza("/videoClicked", zzf.f10079h);
        zzbggVar.zza("/trackActiveViewUnit", new C0926hc(this));
        zzbggVar.zza("/untrackActiveViewUnit", new C0940ic(this));
        if (z) {
            zzbggVar.zza("/open", new com.google.android.gms.ads.internal.gmsg.zzac(null, null));
        }
    }

    private final ViewTreeObserver.OnScrollChangedListener zzb(WeakReference<zzbgg> weakReference) {
        if (this.zzduh == null) {
            this.zzduh = new ViewTreeObserverOnScrollChangedListenerC0967kc(this, weakReference);
        }
        return this.zzduh;
    }

    @VisibleForTesting
    private final zzbgg zzwg() throws zzbgq {
        com.google.android.gms.ads.internal.zzbv.f();
        return zzbgm.zza(this.mContext, zzbht.zzaey(), "native-video", false, false, this.zzdcf, this.zzdsk.zzeag.zzbsp, this.zzbln, null, this.zzdug.zzid(), this.zzdsk.zzehw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbcl zzbclVar, zzbgg zzbggVar, boolean z) {
        this.zzdug.H();
        zzbclVar.set(zzbggVar);
    }

    private final ViewTreeObserver.OnGlobalLayoutListener zza(WeakReference<zzbgg> weakReference) {
        if (this.mGlobalLayoutListener == null) {
            this.mGlobalLayoutListener = new ViewTreeObserverOnGlobalLayoutListenerC0953jc(this, weakReference);
        }
        return this.mGlobalLayoutListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(WeakReference<zzbgg> weakReference, boolean z) {
        zzbgg zzbggVar;
        if (weakReference == null || (zzbggVar = weakReference.get()) == null || zzbggVar.getView() == null) {
            return;
        }
        if (!z || this.zzbua.tryAcquire()) {
            int[] iArr = new int[2];
            zzbggVar.getView().getLocationOnScreen(iArr);
            zzwu.zzpv();
            int zzb = zzbat.zzb(this.zzbwk, iArr[0]);
            zzwu.zzpv();
            int zzb2 = zzbat.zzb(this.zzbwk, iArr[1]);
            synchronized (this.mLock) {
                if (this.zzbty != zzb || this.zzbtz != zzb2) {
                    this.zzbty = zzb;
                    this.zzbtz = zzb2;
                    zzbggVar.zzadl().zza(this.zzbty, this.zzbtz, z ? false : true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(boolean z, final zzbcl zzbclVar, String str, String str2) {
        try {
            final zzbgg zzwg = zzwg();
            if (z) {
                zzwg.zza(zzbht.zzafa());
            } else {
                zzwg.zza(zzbht.zzaez());
            }
            this.zzdug.a(zzwg);
            WeakReference<zzbgg> weakReference = new WeakReference<>(zzwg);
            zzwg.zzadl().zza(zza(weakReference), zzb(weakReference));
            zza(zzwg, z);
            zzwg.zzadl().zza(new zzbho(this, zzbclVar, zzwg) { // from class: com.google.android.gms.internal.ads.ec

                /* renamed from: a, reason: collision with root package name */
                private final zzaqf f12137a;

                /* renamed from: b, reason: collision with root package name */
                private final zzbcl f12138b;

                /* renamed from: c, reason: collision with root package name */
                private final zzbgg f12139c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12137a = this;
                    this.f12138b = zzbclVar;
                    this.f12139c = zzwg;
                }

                @Override // com.google.android.gms.internal.ads.zzbho
                public final void zzp(boolean z2) {
                    this.f12137a.zza(this.f12138b, this.f12139c, z2);
                }
            });
            zzwg.zzc(str, str2, null);
        } catch (Exception e2) {
            zzbbd.zzc("Exception occurred while getting video view", e2);
            zzbclVar.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbcl zzbclVar, zzbgg zzbggVar, boolean z) {
        this.zzdug.H();
        zzbclVar.set(zzbggVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(boolean z, final JSONObject jSONObject, final zzbcl zzbclVar) {
        try {
            final zzbgg zzwg = zzwg();
            if (z) {
                zzwg.zza(zzbht.zzafa());
            } else {
                zzwg.zza(zzbht.zzaez());
            }
            this.zzdug.a(zzwg);
            WeakReference<zzbgg> weakReference = new WeakReference<>(zzwg);
            zzwg.zzadl().zza(zza(weakReference), zzb(weakReference));
            zza(zzwg, z);
            zzwg.zzadl().zza(new zzbhp(zzwg, jSONObject) { // from class: com.google.android.gms.internal.ads.fc

                /* renamed from: a, reason: collision with root package name */
                private final zzbgg f12157a;

                /* renamed from: b, reason: collision with root package name */
                private final JSONObject f12158b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12157a = zzwg;
                    this.f12158b = jSONObject;
                }

                @Override // com.google.android.gms.internal.ads.zzbhp
                public final void zzuc() {
                    this.f12157a.zzb("google.afma.nativeAds.renderVideo", this.f12158b);
                }
            });
            zzwg.zzadl().zza(new zzbho(this, zzbclVar, zzwg) { // from class: com.google.android.gms.internal.ads.gc

                /* renamed from: a, reason: collision with root package name */
                private final zzaqf f12172a;

                /* renamed from: b, reason: collision with root package name */
                private final zzbcl f12173b;

                /* renamed from: c, reason: collision with root package name */
                private final zzbgg f12174c;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12172a = this;
                    this.f12173b = zzbclVar;
                    this.f12174c = zzwg;
                }

                @Override // com.google.android.gms.internal.ads.zzbho
                public final void zzp(boolean z2) {
                    this.f12172a.zzb(this.f12173b, this.f12174c, z2);
                }
            });
            zzwg.loadUrl((String) zzwu.zzpz().zzd(zzaan.zzcug));
        } catch (Exception e2) {
            zzbbd.zzc("Exception occurred while getting video view", e2);
            zzbclVar.set(null);
        }
    }
}
