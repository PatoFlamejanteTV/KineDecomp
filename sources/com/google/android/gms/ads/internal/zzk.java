package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.Window;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
/* loaded from: classes.dex */
public class zzk extends zzc implements zzdo {

    /* renamed from: a, reason: collision with root package name */
    protected transient boolean f661a;
    private boolean b;
    private float c;
    private String d;

    /* JADX INFO: Access modifiers changed from: private */
    @zzgr
    /* loaded from: classes.dex */
    public class a extends zzhz {
        private final String b;

        public a(String str) {
            this.b = str;
        }

        @Override // com.google.android.gms.internal.zzhz
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzhz
        public void zzbn() {
            zzp.e().zzh(zzk.this.zzot.c, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @zzgr
    /* loaded from: classes.dex */
    public class b extends zzhz {
        private final Bitmap b;
        private final String c;

        public b(Bitmap bitmap, String str) {
            this.b = bitmap;
            this.c = str;
        }

        @Override // com.google.android.gms.internal.zzhz
        public void onStop() {
        }

        @Override // com.google.android.gms.internal.zzhz
        public void zzbn() {
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(zzk.this.zzot.E, zzk.this.b(), zzk.this.zzot.E ? zzp.e().zza(zzk.this.zzot.c, this.b, this.c) : false ? this.c : null, zzk.this.b, zzk.this.c);
            int requestedOrientation = zzk.this.zzot.j.zzBD.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = zzk.this.zzot.j.orientation;
            }
            zzid.zzIE.post(new i(this, new AdOverlayInfoParcel(zzk.this, zzk.this, zzk.this, zzk.this.zzot.j.zzBD, requestedOrientation, zzk.this.zzot.e, zzk.this.zzot.j.zzEP, interstitialAdParameterParcel)));
        }
    }

    public zzk(Context context, AdSizeParcel adSizeParcel, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzemVar, versionInfoParcel, zzdVar);
        this.f661a = false;
        this.d = "background" + hashCode() + ".png";
    }

    private void a(Bundle bundle) {
        zzp.e().zzb(this.zzot.c, this.zzot.e.b, "gmob-apps", bundle, false);
    }

    private void c() {
        new a(this.d).zzfu();
        if (this.zzot.e()) {
            this.zzot.b();
            this.zzot.j = null;
            this.zzot.E = false;
            this.f661a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public zziz a(zzhs.zza zzaVar, zze zzeVar) {
        zziz zza = zzp.f().zza(this.zzot.c, this.zzot.i, false, false, this.zzot.d, this.zzot.e, this.zzoo, this.zzow);
        zza.zzhe().zzb(this, null, this, this, zzby.zzvc.get().booleanValue(), this, this, zzeVar, null);
        zza.zzaJ(zzaVar.zzHC.w);
        return zza;
    }

    protected boolean b() {
        Window window;
        if (!(this.zzot.c instanceof Activity) || (window = ((Activity) this.zzot.c).getWindow()) == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        return (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzs
    public void showInterstitial() {
        zzx.b("showInterstitial must be called on the main UI thread.");
        if (this.zzot.j == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("The interstitial has not loaded.");
            return;
        }
        if (zzby.zzvo.get().booleanValue()) {
            String packageName = this.zzot.c.getApplicationContext() != null ? this.zzot.c.getApplicationContext().getPackageName() : this.zzot.c.getPackageName();
            if (!this.f661a) {
                com.google.android.gms.ads.internal.util.client.zzb.e("It is not recommended to show an interstitial before onAdLoaded completes.");
                Bundle bundle = new Bundle();
                bundle.putString("appid", packageName);
                bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_before_load_finish");
                a(bundle);
            }
            if (!zzp.e().zzN(this.zzot.c)) {
                com.google.android.gms.ads.internal.util.client.zzb.e("It is not recommended to show an interstitial when app is not in foreground.");
                Bundle bundle2 = new Bundle();
                bundle2.putString("appid", packageName);
                bundle2.putString(NativeProtocol.WEB_DIALOG_ACTION, "show_interstitial_app_not_in_foreground");
                a(bundle2);
            }
        }
        if (this.zzot.f()) {
            return;
        }
        if (this.zzot.j.zzEK) {
            try {
                this.zzot.j.zzzv.showInterstitial();
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not show interstitial.", e);
                c();
                return;
            }
        }
        if (this.zzot.j.zzBD == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("The interstitial failed to load.");
            return;
        }
        if (this.zzot.j.zzBD.zzhi()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("The interstitial is already showing.");
            return;
        }
        this.zzot.j.zzBD.zzC(true);
        if (this.zzot.j.zzHw != null) {
            this.zzov.zza(this.zzot.i, this.zzot.j);
        }
        Bitmap zzO = this.zzot.E ? zzp.e().zzO(this.zzot.c) : null;
        if (zzby.zzvz.get().booleanValue() && zzO != null) {
            new b(zzO, this.d).zzfu();
            return;
        }
        InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzot.E, b(), null, false, 0.0f);
        int requestedOrientation = this.zzot.j.zzBD.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.zzot.j.orientation;
        }
        zzp.c().a(this.zzot.c, new AdOverlayInfoParcel(this, this, this, this.zzot.j.zzBD, requestedOrientation, this.zzot.e, this.zzot.j.zzEP, interstitialAdParameterParcel));
    }

    @Override // com.google.android.gms.internal.zzdo
    public void zza(boolean z, float f) {
        this.b = z;
        this.c = f;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(AdRequestParcel adRequestParcel, zzcg zzcgVar) {
        if (this.zzot.j == null) {
            return super.zza(adRequestParcel, zzcgVar);
        }
        com.google.android.gms.ads.internal.util.client.zzb.e("An interstitial is already loading. Aborting.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zza(AdRequestParcel adRequestParcel, zzhs zzhsVar, boolean z) {
        if (this.zzot.e() && zzhsVar.zzBD != null) {
            zzp.g().zza(zzhsVar.zzBD.getWebView());
        }
        return this.zzos.d();
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        if (!super.zza(zzhsVar, zzhsVar2)) {
            return false;
        }
        if (!this.zzot.e() && this.zzot.B != null && zzhsVar2.zzHw != null) {
            this.zzov.zza(this.zzot.i, zzhsVar2, this.zzot.B);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzaQ() {
        c();
        return super.zzaQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zzaT() {
        if (!super.zzaT()) {
            return false;
        }
        this.f661a = true;
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.overlay.zzg
    public void zzaW() {
        recordImpression();
        super.zzaW();
    }

    @Override // com.google.android.gms.internal.zzdo
    public void zzd(boolean z) {
        this.zzot.E = z;
    }
}
