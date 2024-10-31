package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzib;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Future;

@zzgr
/* loaded from: classes.dex */
public class zzhu implements zzib.zzb {
    private Context mContext;
    private final String zzHP;
    private final zzhv zzHQ;
    private String zzIa;
    private zzay zzov;
    private VersionInfoParcel zzpb;
    private final Object zzpd = new Object();
    private BigInteger zzHR = BigInteger.ONE;
    private final HashSet<zzht> zzHS = new HashSet<>();
    private final HashMap<String, zzhx> zzHT = new HashMap<>();
    private boolean zzHU = false;
    private boolean zzGg = true;
    private int zzHV = 0;
    private boolean zzpA = false;
    private zzca zzHW = null;
    private boolean zzGh = true;
    private zzbj zzsa = null;
    private zzbk zzHX = null;
    private zzbi zzsb = null;
    private final LinkedList<Thread> zzHY = new LinkedList<>();
    private final zzgq zzsc = null;
    private Boolean zzHZ = null;
    private boolean zzIb = false;
    private boolean zzIc = false;

    public zzhu(zzid zzidVar) {
        this.zzHP = zzidVar.zzgD();
        this.zzHQ = new zzhv(this.zzHP);
    }

    public String getSessionId() {
        return this.zzHP;
    }

    public void zzA(boolean z) {
        synchronized (this.zzpd) {
            this.zzGh = z;
        }
    }

    public void zzB(boolean z) {
        synchronized (this.zzpd) {
            this.zzIb = z;
        }
    }

    public zzbk zzE(Context context) {
        if (!zzby.zzuT.get().booleanValue() || !zzmx.zzqx() || zzgl()) {
            return null;
        }
        synchronized (this.zzpd) {
            if (this.zzsa == null) {
                if (!(context instanceof Activity)) {
                    return null;
                }
                this.zzsa = new zzbj((Application) context.getApplicationContext(), (Activity) context);
            }
            if (this.zzsb == null) {
                this.zzsb = new zzbi();
            }
            if (this.zzHX == null) {
                this.zzHX = new zzbk(this.zzsa, this.zzsb, new zzgq(this.mContext, this.zzpb, null, null));
            }
            this.zzHX.zzct();
            return this.zzHX;
        }
    }

    public Bundle zza(Context context, zzhw zzhwVar, String str) {
        Bundle bundle;
        synchronized (this.zzpd) {
            bundle = new Bundle();
            bundle.putBundle("app", this.zzHQ.zze(context, str));
            Bundle bundle2 = new Bundle();
            for (String str2 : this.zzHT.keySet()) {
                bundle2.putBundle(str2, this.zzHT.get(str2).toBundle());
            }
            bundle.putBundle("slots", bundle2);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzht> it = this.zzHS.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzhwVar.zza(this.zzHS);
            this.zzHS.clear();
        }
        return bundle;
    }

    public Future zza(Context context, boolean z) {
        Future future;
        synchronized (this.zzpd) {
            if (z != this.zzGg) {
                this.zzGg = z;
                future = zzib.zza(context, z);
            } else {
                future = null;
            }
        }
        return future;
    }

    public void zza(zzht zzhtVar) {
        synchronized (this.zzpd) {
            this.zzHS.add(zzhtVar);
        }
    }

    public void zza(String str, zzhx zzhxVar) {
        synchronized (this.zzpd) {
            this.zzHT.put(str, zzhxVar);
        }
    }

    public void zza(Thread thread) {
        zzgq.zza(this.mContext, thread, this.zzpb);
    }

    public void zzb(Context context, VersionInfoParcel versionInfoParcel) {
        synchronized (this.zzpd) {
            if (!this.zzpA) {
                this.mContext = context.getApplicationContext();
                this.zzpb = versionInfoParcel;
                zzib.zza(context, this);
                zzib.zzb(context, this);
                zza(Thread.currentThread());
                this.zzIa = com.google.android.gms.ads.internal.zzp.e().zzf(context, versionInfoParcel.b);
                if (zzmx.zzqE() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                    this.zzIc = true;
                }
                this.zzov = new zzay(context.getApplicationContext(), this.zzpb, new zzdz(context.getApplicationContext(), this.zzpb, zzby.zzul.get()));
                zzgw();
                com.google.android.gms.ads.internal.zzp.o().a(this.mContext);
                this.zzpA = true;
            }
        }
    }

    public void zzb(Boolean bool) {
        synchronized (this.zzpd) {
            this.zzHZ = bool;
        }
    }

    public void zzb(HashSet<zzht> hashSet) {
        synchronized (this.zzpd) {
            this.zzHS.addAll(hashSet);
        }
    }

    public void zzc(Throwable th, boolean z) {
        new zzgq(this.mContext, this.zzpb, null, null).zza(th, z);
    }

    public String zzd(int i, String str) {
        Resources resources = this.zzpb.e ? this.mContext.getResources() : GooglePlayServicesUtil.d(this.mContext);
        return resources == null ? str : resources.getString(i);
    }

    @Override // com.google.android.gms.internal.zzib.zzb
    public void zzd(Bundle bundle) {
        synchronized (this.zzpd) {
            this.zzGg = bundle.containsKey("use_https") ? bundle.getBoolean("use_https") : this.zzGg;
            this.zzHV = bundle.containsKey("webview_cache_version") ? bundle.getInt("webview_cache_version") : this.zzHV;
        }
    }

    public boolean zzgl() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzGh;
        }
        return z;
    }

    public String zzgm() {
        String bigInteger;
        synchronized (this.zzpd) {
            bigInteger = this.zzHR.toString();
            this.zzHR = this.zzHR.add(BigInteger.ONE);
        }
        return bigInteger;
    }

    public zzhv zzgn() {
        zzhv zzhvVar;
        synchronized (this.zzpd) {
            zzhvVar = this.zzHQ;
        }
        return zzhvVar;
    }

    public zzca zzgo() {
        zzca zzcaVar;
        synchronized (this.zzpd) {
            zzcaVar = this.zzHW;
        }
        return zzcaVar;
    }

    public boolean zzgp() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzHU;
            this.zzHU = true;
        }
        return z;
    }

    public boolean zzgq() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzGg || this.zzIc;
        }
        return z;
    }

    public String zzgr() {
        String str;
        synchronized (this.zzpd) {
            str = this.zzIa;
        }
        return str;
    }

    public Boolean zzgs() {
        Boolean bool;
        synchronized (this.zzpd) {
            bool = this.zzHZ;
        }
        return bool;
    }

    public zzay zzgt() {
        return this.zzov;
    }

    public boolean zzgu() {
        boolean z;
        synchronized (this.zzpd) {
            if (this.zzHV < zzby.zzvh.get().intValue()) {
                this.zzHV = zzby.zzvh.get().intValue();
                zzib.zza(this.mContext, this.zzHV);
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean zzgv() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzIb;
        }
        return z;
    }

    void zzgw() {
        try {
            this.zzHW = com.google.android.gms.ads.internal.zzp.j().zza(new zzbz(this.mContext, this.zzpb.b));
        } catch (IllegalArgumentException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Cannot initialize CSI reporter.", e);
        }
    }
}
