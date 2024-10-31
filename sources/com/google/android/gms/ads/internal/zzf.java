package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zziz;

@zzgr
/* loaded from: classes.dex */
public class zzf extends zzc {

    /* renamed from: a, reason: collision with root package name */
    private boolean f658a;

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzem zzemVar, VersionInfoParcel versionInfoParcel, zzd zzdVar) {
        super(context, adSizeParcel, str, zzemVar, versionInfoParcel, zzdVar);
    }

    private AdSizeParcel a(zzhs.zza zzaVar) {
        AdSize b;
        if (zzaVar.zzHD.B) {
            return this.zzot.i;
        }
        String str = zzaVar.zzHD.m;
        if (str != null) {
            String[] split = str.split("[xX]");
            split[0] = split[0].trim();
            split[1] = split[1].trim();
            b = new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        } else {
            b = this.zzot.i.b();
        }
        return new AdSizeParcel(this.zzot.c, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(zzhs zzhsVar, zzhs zzhsVar2) {
        boolean z;
        if (zzhsVar2.zzEK) {
            try {
                com.google.android.gms.dynamic.zzd view = zzhsVar2.zzzv.getView();
                if (view == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.e("View in mediation adapter is null.");
                    z = false;
                } else {
                    View view2 = (View) com.google.android.gms.dynamic.zze.a(view);
                    View nextView = this.zzot.f.getNextView();
                    if (nextView != 0) {
                        if (nextView instanceof zziz) {
                            ((zziz) nextView).destroy();
                        }
                        this.zzot.f.removeView(nextView);
                    }
                    try {
                        zzb(view2);
                    } catch (Throwable th) {
                        com.google.android.gms.ads.internal.util.client.zzb.d("Could not add mediation view to view hierarchy.", th);
                        z = false;
                    }
                }
                return z;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Could not get View from mediation adapter.", e);
                return false;
            }
        }
        if (zzhsVar2.zzHy != null && zzhsVar2.zzBD != null) {
            zzhsVar2.zzBD.zza(zzhsVar2.zzHy);
            this.zzot.f.removeAllViews();
            this.zzot.f.setMinimumWidth(zzhsVar2.zzHy.g);
            this.zzot.f.setMinimumHeight(zzhsVar2.zzHy.d);
            zzb(zzhsVar2.zzBD.getView());
        }
        if (this.zzot.f.getChildCount() > 1) {
            this.zzot.f.showNext();
        }
        if (zzhsVar != null) {
            View nextView2 = this.zzot.f.getNextView();
            if (nextView2 instanceof zziz) {
                ((zziz) nextView2).zza(this.zzot.c, this.zzot.i, this.zzoo);
            } else if (nextView2 != 0) {
                this.zzot.f.removeView(nextView2);
            }
            this.zzot.d();
        }
        this.zzot.f.setVisibility(0);
        z = true;
        return z;
    }

    AdRequestParcel a(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.h == this.f658a) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.f533a, adRequestParcel.b, adRequestParcel.c, adRequestParcel.d, adRequestParcel.e, adRequestParcel.f, adRequestParcel.g, adRequestParcel.h || this.f658a, adRequestParcel.i, adRequestParcel.j, adRequestParcel.k, adRequestParcel.l, adRequestParcel.m, adRequestParcel.n, adRequestParcel.o, adRequestParcel.p, adRequestParcel.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zzc
    public zziz a(zzhs.zza zzaVar, zze zzeVar) {
        if (this.zzot.i.j) {
            this.zzot.i = a(zzaVar);
        }
        return super.a(zzaVar, zzeVar);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public void setManualImpressionsEnabled(boolean z) {
        zzx.b("setManualImpressionsEnabled must be called from the main thread.");
        this.f658a = z;
    }

    @Override // com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.client.zzs
    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    @Override // com.google.android.gms.ads.internal.zzc, com.google.android.gms.ads.internal.zzb, com.google.android.gms.ads.internal.zza
    public boolean zza(zzhs zzhsVar, zzhs zzhsVar2) {
        if (!super.zza(zzhsVar, zzhsVar2)) {
            return false;
        }
        if (this.zzot.e() && !a(zzhsVar, zzhsVar2)) {
            zze(0);
            return false;
        }
        zza(zzhsVar2, false);
        if (this.zzot.e()) {
            if (zzhsVar2.zzBD != null) {
                if (zzhsVar2.zzHw != null) {
                    this.zzov.zza(this.zzot.i, zzhsVar2);
                }
                if (zzhsVar2.zzbY()) {
                    this.zzov.zza(this.zzot.i, zzhsVar2).zza(zzhsVar2.zzBD);
                } else {
                    zzhsVar2.zzBD.zzhe().zza(new f(this, zzhsVar2));
                }
            }
        } else if (this.zzot.B != null && zzhsVar2.zzHw != null) {
            this.zzov.zza(this.zzot.i, zzhsVar2, this.zzot.B);
        }
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zzb
    protected boolean zzaU() {
        boolean z = true;
        if (!zzp.e().zza(this.zzot.c.getPackageManager(), this.zzot.c.getPackageName(), "android.permission.INTERNET")) {
            com.google.android.gms.ads.internal.client.zzl.a().a(this.zzot.f, this.zzot.i, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzp.e().zzH(this.zzot.c)) {
            com.google.android.gms.ads.internal.client.zzl.a().a(this.zzot.f, this.zzot.i, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzot.f != null) {
            this.zzot.f.setVisibility(0);
        }
        return z;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.ads.internal.client.zzs
    public boolean zzb(AdRequestParcel adRequestParcel) {
        return super.zzb(a(adRequestParcel));
    }
}
