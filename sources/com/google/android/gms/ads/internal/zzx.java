package com.google.android.gms.ads.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzalv;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzawr;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzsc;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzyp;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzx extends zzh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: b, reason: collision with root package name */
    private boolean f10272b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10273c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<Object> f10274d;

    public zzx(Context context, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzv zzvVar) {
        super(context, zzwfVar, str, zzalgVar, zzbbiVar, zzvVar);
        this.f10274d = new WeakReference<>(null);
    }

    private final void c(zzbgg zzbggVar) {
        WebView webView;
        View view;
        if (A() && (webView = zzbggVar.getWebView()) != null && (view = zzbggVar.getView()) != null && zzbv.v().zzk(this.zzbls.f10251c)) {
            zzbbi zzbbiVar = this.zzbls.f10253e;
            int i = zzbbiVar.zzeou;
            int i2 = zzbbiVar.zzeov;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            this.zzblx = zzbv.v().zza(sb.toString(), webView, "", "javascript", zzit());
            if (this.zzblx != null) {
                zzbv.v().zza(this.zzblx, view);
                zzbggVar.zzaa(this.zzblx);
                zzbv.v().zzo(this.zzblx);
                this.f10273c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzh
    public final zzbgg a(zzaxg zzaxgVar, zzw zzwVar, zzawr zzawrVar) throws zzbgq {
        AdSize zzpp;
        zzbw zzbwVar = this.zzbls;
        zzwf zzwfVar = zzbwVar.i;
        if (zzwfVar.zzckm == null && zzwfVar.zzcko) {
            zzasm zzasmVar = zzaxgVar.zzehy;
            if (!zzasmVar.zzcko) {
                String str = zzasmVar.zzdyg;
                if (str != null) {
                    String[] split = str.split("[xX]");
                    split[0] = split[0].trim();
                    split[1] = split[1].trim();
                    zzpp = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } else {
                    zzpp = zzwfVar.zzpp();
                }
                zzwfVar = new zzwf(this.zzbls.f10251c, zzpp);
            }
            zzbwVar.i = zzwfVar;
        }
        return super.a(zzaxgVar, zzwVar, zzawrVar);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final zzyp getVideoController() {
        zzbgg zzbggVar;
        Preconditions.a("getVideoController must be called from the main thread.");
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || (zzbggVar = zzaxfVar.zzdrv) == null) {
            return null;
        }
        return zzbggVar.zzabu();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        a(this.zzbls.j);
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        a(this.zzbls.j);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final void setManualImpressionsEnabled(boolean z) {
        Preconditions.a("setManualImpressionsEnabled must be called from the main thread.");
        this.f10272b = z;
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.internal.ads.zzxl
    public final void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0078, code lost:            if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcuc)).booleanValue() != false) goto L28;     */
    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zza
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzaxf r5, final com.google.android.gms.internal.ads.zzaxf r6) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzx.zza(com.google.android.gms.internal.ads.zzaxf, com.google.android.gms.internal.ads.zzaxf):boolean");
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public final boolean zzb(zzwb zzwbVar) {
        zzwb zzwbVar2 = zzwbVar;
        this.f10273c = false;
        this.zzblx = null;
        boolean z = zzwbVar2.zzcjg;
        boolean z2 = this.f10272b;
        if (z != z2) {
            zzwbVar2 = new zzwb(zzwbVar2.versionCode, zzwbVar2.zzcjb, zzwbVar2.extras, zzwbVar2.zzcjc, zzwbVar2.zzcjd, zzwbVar2.zzcje, zzwbVar2.zzcjf, z || z2, zzwbVar2.zzcjh, zzwbVar2.zzcji, zzwbVar2.zzcjj, zzwbVar2.zzcjk, zzwbVar2.zzcjl, zzwbVar2.zzcjm, zzwbVar2.zzcjn, zzwbVar2.zzcjo, zzwbVar2.zzcjp, zzwbVar2.zzcjq, null, zzwbVar2.zzcjs, zzwbVar2.zzcjt);
        }
        return super.zzb(zzwbVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzh, com.google.android.gms.ads.internal.zza
    public final void zzil() {
        zzaxf zzaxfVar = this.zzbls.j;
        zzbgg zzbggVar = zzaxfVar != null ? zzaxfVar.zzdrv : null;
        if (!this.f10273c && zzbggVar != null) {
            c(zzbggVar);
        }
        super.zzil();
    }

    @Override // com.google.android.gms.ads.internal.zzc
    protected final boolean zziu() {
        boolean z;
        zzbx zzbxVar;
        zzbv.e();
        if (zzayh.zzn(this.zzbls.f10251c, "android.permission.INTERNET")) {
            z = true;
        } else {
            zzbat zzpv = zzwu.zzpv();
            zzbw zzbwVar = this.zzbls;
            zzpv.zza(zzbwVar.f10254f, zzbwVar.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        zzbv.e();
        if (!zzayh.zzah(this.zzbls.f10251c)) {
            zzbat zzpv2 = zzwu.zzpv();
            zzbw zzbwVar2 = this.zzbls;
            zzpv2.zza(zzbwVar2.f10254f, zzbwVar2.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && (zzbxVar = this.zzbls.f10254f) != null) {
            zzbxVar.setVisibility(0);
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaol
    public final void zzjv() {
        this.zzblr.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean a(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        zzbgg zzbggVar;
        if (zzaxfVar2.zzdyd) {
            View a2 = zzas.a(zzaxfVar2);
            if (a2 == null) {
                zzbbd.zzeo("Could not get mediation view");
                return false;
            }
            View nextView = this.zzbls.f10254f.getNextView();
            if (nextView != 0) {
                if (nextView instanceof zzbgg) {
                    ((zzbgg) nextView).destroy();
                }
                this.zzbls.f10254f.removeView(nextView);
            }
            if (!zzas.b(zzaxfVar2)) {
                try {
                    if (zzbv.E().zzv(this.zzbls.f10251c)) {
                        new zzsc(this.zzbls.f10251c, a2).zza(new zzawv(this.zzbls.f10251c, this.zzbls.f10250b));
                    }
                    if (zzaxfVar2.zzehl != null) {
                        this.zzbls.f10254f.setMinimumWidth(zzaxfVar2.zzehl.widthPixels);
                        this.zzbls.f10254f.setMinimumHeight(zzaxfVar2.zzehl.heightPixels);
                    }
                    zzg(a2);
                } catch (Exception e2) {
                    zzbv.i().zza(e2, "BannerAdManager.swapViews");
                    zzbbd.zzc("Could not add mediation view to view hierarchy.", e2);
                    return false;
                }
            }
        } else {
            zzwf zzwfVar = zzaxfVar2.zzehl;
            if (zzwfVar != null && (zzbggVar = zzaxfVar2.zzdrv) != null) {
                zzbggVar.zza(zzbht.zzb(zzwfVar));
                this.zzbls.f10254f.removeAllViews();
                this.zzbls.f10254f.setMinimumWidth(zzaxfVar2.zzehl.widthPixels);
                this.zzbls.f10254f.setMinimumHeight(zzaxfVar2.zzehl.heightPixels);
                zzg(zzaxfVar2.zzdrv.getView());
            }
        }
        if (this.zzbls.f10254f.getChildCount() > 1) {
            this.zzbls.f10254f.showNext();
        }
        if (zzaxfVar != null) {
            View nextView2 = this.zzbls.f10254f.getNextView();
            if (nextView2 instanceof zzbgg) {
                ((zzbgg) nextView2).destroy();
            } else if (nextView2 != 0) {
                this.zzbls.f10254f.removeView(nextView2);
            }
            this.zzbls.c();
        }
        this.zzbls.f10254f.setVisibility(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzaxf zzaxfVar) {
        zzbgg zzbggVar;
        if (zzaxfVar == null || zzaxfVar.zzehi || this.zzbls.f10254f == null) {
            return;
        }
        zzayh e2 = zzbv.e();
        zzbw zzbwVar = this.zzbls;
        if (e2.zza(zzbwVar.f10254f, zzbwVar.f10251c) && this.zzbls.f10254f.getGlobalVisibleRect(new Rect(), null)) {
            if (zzaxfVar != null && (zzbggVar = zzaxfVar.zzdrv) != null && zzbggVar.zzadl() != null) {
                zzaxfVar.zzdrv.zzadl().zza((zzbhr) null);
            }
            zza(zzaxfVar, false);
            zzaxfVar.zzehi = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public final void zza(zzaxf zzaxfVar, boolean z) {
        if (A()) {
            zzbgg zzbggVar = zzaxfVar != null ? zzaxfVar.zzdrv : null;
            if (zzbggVar != null) {
                if (!this.f10273c) {
                    c(zzbggVar);
                }
                if (this.zzblx != null) {
                    zzbggVar.zza("onSdkImpression", new ArrayMap());
                }
            }
        }
        super.zza(zzaxfVar, z);
        if (zzas.b(zzaxfVar)) {
            zzab zzabVar = new zzab(this);
            if (zzaxfVar == null || !zzas.b(zzaxfVar)) {
                return;
            }
            zzbgg zzbggVar2 = zzaxfVar.zzdrv;
            View view = zzbggVar2 != null ? zzbggVar2.getView() : null;
            if (view == null) {
                zzbbd.zzeo("AdWebView is null");
                return;
            }
            try {
                List<String> list = zzaxfVar.zzdnb != null ? zzaxfVar.zzdnb.zzdll : null;
                if (list != null && !list.isEmpty()) {
                    zzals zzuu = zzaxfVar.zzdnc != null ? zzaxfVar.zzdnc.zzuu() : null;
                    zzalv zzuv = zzaxfVar.zzdnc != null ? zzaxfVar.zzdnc.zzuv() : null;
                    if (list.contains("2") && zzuu != null) {
                        zzuu.zzl(ObjectWrapper.a(view));
                        if (!zzuu.getOverrideImpressionRecording()) {
                            zzuu.recordImpression();
                        }
                        zzbggVar2.zza("/nativeExpressViewClicked", zzas.a(zzuu, (zzalv) null, zzabVar));
                        return;
                    }
                    if (list.contains("1") && zzuv != null) {
                        zzuv.zzl(ObjectWrapper.a(view));
                        if (!zzuv.getOverrideImpressionRecording()) {
                            zzuv.recordImpression();
                        }
                        zzbggVar2.zza("/nativeExpressViewClicked", zzas.a((zzals) null, zzuv, zzabVar));
                        return;
                    }
                    zzbbd.zzeo("No matching template id and mapper");
                    return;
                }
                zzbbd.zzeo("No template ids present in mediation response");
            } catch (RemoteException e2) {
                zzbbd.zzc("Error occurred while recording impression and registering for clicks", e2);
            }
        }
    }
}
