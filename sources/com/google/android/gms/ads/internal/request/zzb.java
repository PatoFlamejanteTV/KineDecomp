package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzb extends zzhz implements zzc.zza {

    /* renamed from: a, reason: collision with root package name */
    zzhz f634a;
    AdResponseParcel b;
    zzee c;
    private final zza.InterfaceC0027zza d;
    private final AdRequestInfoParcel.zza e;
    private final Object f = new Object();
    private final Context g;
    private final zzan h;
    private AdRequestInfoParcel i;
    private Runnable j;

    /* JADX INFO: Access modifiers changed from: package-private */
    @zzgr
    /* loaded from: classes.dex */
    public static final class zza extends Exception {
        private final int zzDv;

        public zza(String str, int i) {
            super(str);
            this.zzDv = i;
        }

        public int getErrorCode() {
            return this.zzDv;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, zza.InterfaceC0027zza interfaceC0027zza) {
        this.d = interfaceC0027zza;
        this.g = context;
        this.e = zzaVar;
        this.h = zzanVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        if (i == 3 || i == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.c(str);
        } else {
            com.google.android.gms.ads.internal.util.client.zzb.e(str);
        }
        if (this.b == null) {
            this.b = new AdResponseParcel(i);
        } else {
            this.b = new AdResponseParcel(i, this.b.k);
        }
        this.d.zza(new zzhs.zza(this.i, this.b, this.c, null, i, -1L, this.b.n, null));
    }

    zzhz a(AdRequestInfoParcel adRequestInfoParcel) {
        return zzc.a(this.g, adRequestInfoParcel, this);
    }

    protected void a() throws zza {
        if (this.b.e == -3) {
            return;
        }
        if (TextUtils.isEmpty(this.b.c)) {
            throw new zza("No fill from ad server.", 3);
        }
        zzp.h().zza(this.g, this.b.u);
        if (this.b.h) {
            try {
                this.c = new zzee(this.b.c);
            } catch (JSONException e) {
                throw new zza("Could not parse mediation config: " + this.b.c, 0);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void a(AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        com.google.android.gms.ads.internal.util.client.zzb.a("Received ad response.");
        this.b = adResponseParcel;
        long elapsedRealtime = zzp.i().elapsedRealtime();
        synchronized (this.f) {
            this.f634a = null;
        }
        try {
            if (this.b.e != -2 && this.b.e != -3) {
                throw new zza("There was a problem getting an ad response. ErrorCode: " + this.b.e, this.b.e);
            }
            a();
            AdSizeParcel b = this.i.d.h != null ? b(this.i) : null;
            a(this.b.v);
            if (!TextUtils.isEmpty(this.b.r)) {
                try {
                    jSONObject = new JSONObject(this.b.r);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.util.client.zzb.b("Error parsing the JSON for Active View.", e);
                }
                this.d.zza(new zzhs.zza(this.i, this.b, this.c, b, -2, elapsedRealtime, this.b.n, jSONObject));
                zzid.zzIE.removeCallbacks(this.j);
            }
            jSONObject = null;
            this.d.zza(new zzhs.zza(this.i, this.b, this.c, b, -2, elapsedRealtime, this.b.n, jSONObject));
            zzid.zzIE.removeCallbacks(this.j);
        } catch (zza e2) {
            a(e2.getErrorCode(), e2.getMessage());
            zzid.zzIE.removeCallbacks(this.j);
        }
    }

    protected void a(boolean z) {
        zzp.h().zzA(z);
        zzbk zzE = zzp.h().zzE(this.g);
        if (zzE == null || zzE.isAlive()) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("start fetching content...");
        zzE.zzct();
    }

    protected AdSizeParcel b(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.b.m == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.b.m.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.b.m, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.d.h) {
                float f = this.g.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.f == -1 ? (int) (adSizeParcel.g / f) : adSizeParcel.f;
                int i2 = adSizeParcel.c == -2 ? (int) (adSizeParcel.d / f) : adSizeParcel.c;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.d.h);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.b.m, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.b.m, 0);
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
        synchronized (this.f) {
            if (this.f634a != null) {
                this.f634a.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        com.google.android.gms.ads.internal.util.client.zzb.a("AdLoaderBackgroundTask started.");
        String zzb = this.h.zzab().zzb(this.g);
        this.j = new b(this);
        zzid.zzIE.postDelayed(this.j, zzby.zzvv.get().longValue());
        this.i = new AdRequestInfoParcel(this.e, zzb, zzp.i().elapsedRealtime());
        synchronized (this.f) {
            this.f634a = a(this.i);
            if (this.f634a == null) {
                a(0, "Could not start the ad request service.");
                zzid.zzIE.removeCallbacks(this.j);
            }
        }
    }
}
