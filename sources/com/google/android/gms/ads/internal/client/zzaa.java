package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzfx;
import com.google.android.gms.internal.zzgb;

/* loaded from: classes.dex */
public class zzaa {

    /* renamed from: a, reason: collision with root package name */
    private final zzel f536a;
    private final Context b;
    private final zzh c;
    private AdListener d;
    private zza e;
    private zzs f;
    private String g;
    private String h;
    private AppEventListener i;
    private PlayStorePurchaseListener j;
    private InAppPurchaseListener k;
    private PublisherInterstitialAd l;
    private OnCustomRenderedAdLoadedListener m;

    public zzaa(Context context) {
        this(context, zzh.a(), null);
    }

    public zzaa(Context context, zzh zzhVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.f536a = new zzel();
        this.b = context;
        this.c = zzhVar;
        this.l = publisherInterstitialAd;
    }

    private void b(String str) throws RemoteException {
        if (this.g == null) {
            c(str);
        }
        this.f = zzl.b().b(this.b, new AdSizeParcel(), this.g, this.f536a);
        if (this.d != null) {
            this.f.zza(new zzc(this.d));
        }
        if (this.e != null) {
            this.f.zza(new zzb(this.e));
        }
        if (this.i != null) {
            this.f.zza(new zzj(this.i));
        }
        if (this.k != null) {
            this.f.zza(new zzfx(this.k));
        }
        if (this.j != null) {
            this.f.zza(new zzgb(this.j), this.h);
        }
        if (this.m != null) {
            this.f.zza(new zzcl(this.m));
        }
    }

    private void c(String str) {
        if (this.f == null) {
            throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + str + " is called.");
        }
    }

    public void a() {
        try {
            c("show");
            this.f.showInterstitial();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to show interstitial.", e);
        }
    }

    public void a(AdListener adListener) {
        try {
            this.d = adListener;
            if (this.f != null) {
                this.f.zza(adListener != null ? new zzc(adListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the AdListener.", e);
        }
    }

    public void a(zza zzaVar) {
        try {
            this.e = zzaVar;
            if (this.f != null) {
                this.f.zza(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to set the AdClickListener.", e);
        }
    }

    public void a(zzy zzyVar) {
        try {
            if (this.f == null) {
                b("loadAd");
            }
            if (this.f.zzb(this.c.a(this.b, zzyVar))) {
                this.f536a.zze(zzyVar.j());
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to load ad.", e);
        }
    }

    public void a(String str) {
        if (this.g != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.g = str;
    }
}
