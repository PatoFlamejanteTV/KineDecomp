package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaay;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzabg;
import com.google.android.gms.internal.ads.zzagf;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzaow;
import com.google.android.gms.internal.ads.zzapc;
import com.google.android.gms.internal.ads.zzapm;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzasm;
import com.google.android.gms.internal.ads.zzaul;
import com.google.android.gms.internal.ads.zzauu;
import com.google.android.gms.internal.ads.zzavb;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxh;
import com.google.android.gms.internal.ads.zzaxk;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzaxs;
import com.google.android.gms.internal.ads.zzaxx;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxa;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyp;
import com.google.android.gms.internal.ads.zzyv;
import com.google.android.gms.internal.ads.zzzu;
import com.google.android.gms.internal.ads.zzzw;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zza extends zzxm implements zzb, zzd, zzt, zzapm, zzarm, zzaxq, zzvt {
    protected zzaba zzbln;
    protected zzaay zzblo;
    private zzaay zzblp;
    protected final zzbw zzbls;
    protected transient zzwb zzblt;
    protected final zzrf zzblu;
    protected IObjectWrapper zzblx;
    protected final zzv zzbly;
    protected boolean zzblq = false;
    private final Bundle zzblv = new Bundle();
    private boolean zzblw = false;
    protected final zzbl zzblr = new zzbl(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zza(zzbw zzbwVar, zzbl zzblVar, zzv zzvVar) {
        this.zzbls = zzbwVar;
        this.zzbly = zzvVar;
        zzbv.e().zzai(this.zzbls.f10251c);
        zzbv.e().zzaj(this.zzbls.f10251c);
        zzaxx.zzag(this.zzbls.f10251c);
        zzbv.q().initialize(this.zzbls.f10251c);
        zzaxk i = zzbv.i();
        zzbw zzbwVar2 = this.zzbls;
        i.zzd(zzbwVar2.f10251c, zzbwVar2.f10253e);
        zzbv.k().initialize(this.zzbls.f10251c);
        this.zzblu = zzbv.i().zzym();
        zzbv.h().initialize(this.zzbls.f10251c);
        zzbv.B().initialize(this.zzbls.f10251c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean zza(zzwb zzwbVar) {
        Bundle bundle = zzwbVar.zzcjl.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        return bundle == null || !bundle.containsKey("gw");
    }

    @VisibleForTesting
    private static long zzaq(String str) {
        int indexOf = str.indexOf("ufe");
        int indexOf2 = str.indexOf(44, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        try {
            return Long.parseLong(str.substring(indexOf + 4, indexOf2));
        } catch (IndexOutOfBoundsException | NumberFormatException e2) {
            zzbbd.zzb("", e2);
            return -1L;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void destroy() {
        Preconditions.a("#008 Must be called on the main UI thread.: destroy");
        this.zzblr.a();
        this.zzblu.zzi(this.zzbls.j);
        zzbw zzbwVar = this.zzbls;
        zzbx zzbxVar = zzbwVar.f10254f;
        if (zzbxVar != null) {
            zzbxVar.b();
        }
        zzbwVar.n = null;
        zzbwVar.p = null;
        zzbwVar.o = null;
        zzbwVar.D = null;
        zzbwVar.q = null;
        zzbwVar.a(false);
        zzbx zzbxVar2 = zzbwVar.f10254f;
        if (zzbxVar2 != null) {
            zzbxVar2.removeAllViews();
        }
        zzbwVar.b();
        zzbwVar.c();
        zzbwVar.j = null;
        this.zzblx = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final Bundle getAdMetadata() {
        if (this.zzblw) {
            return this.zzblv;
        }
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public String getAdUnitId() {
        return this.zzbls.f10250b;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public zzyp getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isLoading() {
        return this.zzblq;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final boolean isReady() {
        Preconditions.a("#008 Must be called on the main UI thread.: isLoaded");
        zzbw zzbwVar = this.zzbls;
        return zzbwVar.f10255g == null && zzbwVar.f10256h == null && zzbwVar.j != null;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    public void onAdClicked() {
        if (this.zzbls.j == null) {
            zzbbd.zzeo("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzbbd.zzdn("Pinging click URLs.");
        zzaxh zzaxhVar = this.zzbls.l;
        if (zzaxhVar != null) {
            zzaxhVar.zzxw();
        }
        if (this.zzbls.j.zzdlq != null) {
            zzbv.e();
            zzbw zzbwVar = this.zzbls;
            Context context = zzbwVar.f10251c;
            String str = zzbwVar.f10253e.zzdp;
            zzaxf zzaxfVar = zzbwVar.j;
            zzayh.zza(context, str, zza(zzaxfVar.zzdlq, zzaxfVar.zzdzf));
        }
        zzwx zzwxVar = this.zzbls.m;
        if (zzwxVar != null) {
            try {
                zzwxVar.onAdClicked();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzd
    public final void onAppEvent(String str, String str2) {
        zzxt zzxtVar = this.zzbls.o;
        if (zzxtVar != null) {
            try {
                zzxtVar.onAppEvent(str, str2);
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void pause() {
        Preconditions.a("#008 Must be called on the main UI thread.: pause");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void resume() {
        Preconditions.a("#008 Must be called on the main UI thread.: resume");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void setImmersiveMode(boolean z) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void setManualImpressionsEnabled(boolean z) {
        zzbbd.zzeo("Attempt to call setManualImpressionsEnabled for an unsupported ad type.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void setUserId(String str) {
        Preconditions.a("#008 Must be called on the main UI thread.: setUserId");
        this.zzbls.G = str;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void stopLoading() {
        Preconditions.a("#008 Must be called on the main UI thread.: stopLoading");
        this.zzblq = false;
        this.zzbls.a(true);
    }

    protected abstract void zza(zzaxg zzaxgVar, zzaba zzabaVar);

    boolean zza(zzaxf zzaxfVar) {
        return false;
    }

    protected abstract boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2);

    protected abstract boolean zza(zzwb zzwbVar, zzaba zzabaVar);

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzap(String str) {
        Preconditions.a("#008 Must be called on the main UI thread.: setCustomData");
        this.zzbls.H = str;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public boolean zzb(zzwb zzwbVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: loadAd");
        zzbv.k().zzod();
        this.zzblv.clear();
        this.zzblw = false;
        zzwb zzpm = zzwbVar.zzpm();
        zzpm.extras.putInt("dv", DynamiteModule.b(this.zzbls.f10251c, ModuleDescriptor.MODULE_ID));
        zzpm.extras.putBoolean(AdMobAdapter.NEW_BUNDLE, true);
        if (DeviceProperties.b(this.zzbls.f10251c) && zzpm.zzcjj != null) {
            zzpm = new zzwc(zzpm).zza(null).zzpn();
        }
        zzbw zzbwVar = this.zzbls;
        if (zzbwVar.f10255g == null && zzbwVar.f10256h == null) {
            zzbbd.zzen("Starting ad request.");
            String valueOf = String.valueOf(this.zzbls.f10253e.zzdp);
            zzbbd.zzen(valueOf.length() != 0 ? "SDK version: ".concat(valueOf) : new String("SDK version: "));
            zza((zzaay) null);
            this.zzblo = this.zzbln.zzrg();
            if (zzpm.zzcje) {
                zzbbd.zzen("This request is sent from a test device.");
            } else {
                zzwu.zzpv();
                String zzbf = zzbat.zzbf(this.zzbls.f10251c);
                StringBuilder sb = new StringBuilder(String.valueOf(zzbf).length() + 71);
                sb.append("Use AdRequest.Builder.addTestDevice(\"");
                sb.append(zzbf);
                sb.append("\") to get test ads on this device.");
                zzbbd.zzen(sb.toString());
            }
            this.zzblr.a(zzpm);
            this.zzblq = zza(zzpm, this.zzbln);
            return this.zzblq;
        }
        if (this.zzblt != null) {
            zzbbd.zzeo("Aborting last ad request since another ad request is already in progress. The current request object will still be cached for future refreshes.");
        } else {
            zzbbd.zzeo("Loading already in progress, saving this object for future refreshes.");
        }
        this.zzblt = zzpm;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzbr(int i) {
        zzg(i, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean zzc(zzwb zzwbVar) {
        zzbx zzbxVar = this.zzbls.f10254f;
        if (zzbxVar == null) {
            return false;
        }
        Object parent = zzbxVar.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        return zzbv.e().zza(view, view.getContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg(View view) {
        zzbx zzbxVar = this.zzbls.f10254f;
        if (zzbxVar != null) {
            zzbxVar.addView(view, zzbv.g().zzzz());
        }
    }

    public final zzv zzid() {
        return this.zzbly;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final IObjectWrapper zzie() {
        Preconditions.a("#008 Must be called on the main UI thread.: getAdFrame");
        return ObjectWrapper.a(this.zzbls.f10254f);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzwf zzif() {
        Preconditions.a("#008 Must be called on the main UI thread.: getAdSize");
        zzwf zzwfVar = this.zzbls.i;
        if (zzwfVar == null) {
            return null;
        }
        return new zzzu(zzwfVar);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zzig() {
        zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zzih() {
        List<String> list;
        Preconditions.a("#008 Must be called on the main UI thread.: recordManualImpression");
        if (this.zzbls.j == null) {
            zzbbd.zzeo("Ad state was null when trying to ping manual tracking URLs.");
            return;
        }
        zzbbd.zzdn("Pinging manual tracking URLs.");
        if (this.zzbls.j.zzehu) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<String> list2 = this.zzbls.j.zzdyf;
        if (list2 != null) {
            arrayList.addAll(list2);
        }
        zzakq zzakqVar = this.zzbls.j.zzdnb;
        if (zzakqVar != null && (list = zzakqVar.zzdlc) != null) {
            arrayList.addAll(list);
        }
        if (arrayList.isEmpty()) {
            return;
        }
        zzbv.e();
        zzbw zzbwVar = this.zzbls;
        zzayh.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, arrayList);
        this.zzbls.j.zzehu = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzii() {
        zzaxz.v("Ad closing.");
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdClosed();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar != null) {
            try {
                zzavbVar.onRewardedVideoAdClosed();
            } catch (RemoteException e3) {
                zzbbd.zzd("#007 Could not call remote method.", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzij() {
        zzaxz.v("Ad leaving application.");
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdLeftApplication();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar != null) {
            try {
                zzavbVar.onRewardedVideoAdLeftApplication();
            } catch (RemoteException e3) {
                zzbbd.zzd("#007 Could not call remote method.", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzik() {
        zzaxz.v("Ad opening.");
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdOpened();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar != null) {
            try {
                zzavbVar.onRewardedVideoAdOpened();
            } catch (RemoteException e3) {
                zzbbd.zzd("#007 Could not call remote method.", e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzil() {
        zzm(false);
    }

    public final void zzim() {
        zzbbd.zzen("Ad impression.");
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdImpression();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    public final void zzin() {
        zzbbd.zzen("Ad clicked.");
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdClicked();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzio() {
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar == null) {
            return;
        }
        try {
            zzavbVar.onRewardedVideoStarted();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzip() {
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar == null) {
            return;
        }
        try {
            zzavbVar.onRewardedVideoCompleted();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    public final void zziq() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || TextUtils.isEmpty(zzaxfVar.zzdyy) || zzaxfVar.zzehv || !zzbv.o().zzaah()) {
            return;
        }
        zzbbd.zzdn("Sending troubleshooting signals to the server.");
        zzazj o = zzbv.o();
        zzbw zzbwVar = this.zzbls;
        o.zzb(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzaxfVar.zzdyy, zzbwVar.f10250b);
        zzaxfVar.zzehv = true;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxt zzir() {
        return this.zzbls.o;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final zzxa zzis() {
        return this.zzbls.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String zzit() {
        zzasm zzasmVar;
        zzaxg zzaxgVar = this.zzbls.k;
        if (zzaxgVar == null || (zzasmVar = zzaxgVar.zzehy) == null) {
            return "javascript";
        }
        String str = zzasmVar.zzdzd;
        if (TextUtils.isEmpty(str)) {
            return "javascript";
        }
        try {
            if (new JSONObject(str).optInt(MessengerShareContentUtility.MEDIA_TYPE, -1) == 0) {
                return null;
            }
            return "javascript";
        } catch (JSONException e2) {
            zzbbd.zzc("", e2);
            return "javascript";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzm(boolean z) {
        zzaxz.v("Ad finished loading.");
        this.zzblq = z;
        this.zzblw = true;
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdLoaded();
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar != null) {
            try {
                zzavbVar.onRewardedVideoAdLoaded();
            } catch (RemoteException e3) {
                zzbbd.zzd("#007 Could not call remote method.", e3);
            }
        }
        zzxq zzxqVar = this.zzbls.p;
        if (zzxqVar != null) {
            try {
                zzxqVar.onAdMetadataChanged();
            } catch (RemoteException e4) {
                zzbbd.zzd("#007 Could not call remote method.", e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzg(int i, boolean z) {
        StringBuilder sb = new StringBuilder(30);
        sb.append("Failed to load ad: ");
        sb.append(i);
        zzbbd.zzeo(sb.toString());
        this.zzblq = z;
        zzxa zzxaVar = this.zzbls.n;
        if (zzxaVar != null) {
            try {
                zzxaVar.onAdFailedToLoad(i);
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
            }
        }
        zzavb zzavbVar = this.zzbls.E;
        if (zzavbVar != null) {
            try {
                zzavbVar.onRewardedVideoAdFailedToLoad(i);
            } catch (RemoteException e3) {
                zzbbd.zzd("#007 Could not call remote method.", e3);
            }
        }
        zzagf zzagfVar = this.zzbls.u;
        if (zzagfVar != null) {
            try {
                zzagfVar.zzcm(i);
            } catch (RemoteException e4) {
                zzbbd.zzd("#007 Could not call remote method.", e4);
            }
        }
    }

    public final void zza(zzaay zzaayVar) {
        this.zzbln = new zzaba(((Boolean) zzwu.zzpz().zzd(zzaan.zzcpw)).booleanValue(), "load_ad", this.zzbls.i.zzckk);
        this.zzblp = new zzaay(-1L, null, null);
        if (zzaayVar == null) {
            this.zzblo = new zzaay(-1L, null, null);
        } else {
            this.zzblo = new zzaay(zzaayVar.getTime(), zzaayVar.zzrd(), zzaayVar.zzre());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> zzc(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzawz.zzb(it.next(), this.zzbls.f10251c));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void zza(zzaxg zzaxgVar) {
        zzasm zzasmVar = zzaxgVar.zzehy;
        if (zzasmVar.zzdyh != -1 && !TextUtils.isEmpty(zzasmVar.zzdyq)) {
            long zzaq = zzaq(zzaxgVar.zzehy.zzdyq);
            if (zzaq != -1) {
                this.zzbln.zza(this.zzbln.zzao(zzaxgVar.zzehy.zzdyh + zzaq), "stc");
            }
        }
        this.zzbln.zzbp(zzaxgVar.zzehy.zzdyq);
        this.zzbln.zza(this.zzblo, "arf");
        this.zzblp = this.zzbln.zzrg();
        this.zzbln.zzg("gqi", zzaxgVar.zzehy.zzcgx);
        zzbw zzbwVar = this.zzbls;
        zzbwVar.f10255g = null;
        zzbwVar.k = zzaxgVar;
        zzaxgVar.zzehw.zza(new C0789o(this, zzaxgVar));
        zzaxgVar.zzehw.zza(zzuo.zza.zzb.AD_LOADED);
        zza(zzaxgVar, this.zzbln);
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzb
    public final void zza(String str, Bundle bundle) {
        zzxq zzxqVar;
        this.zzblv.putAll(bundle);
        if (!this.zzblw || (zzxqVar = this.zzbls.p) == null) {
            return;
        }
        try {
            zzxqVar.onAdMetadataChanged();
        } catch (RemoteException e2) {
            zzbbd.zzd("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapm
    public void zzb(zzaxf zzaxfVar) {
        this.zzbln.zza(this.zzblp, "awr");
        zzbw zzbwVar = this.zzbls;
        zzbwVar.f10256h = null;
        int i = zzaxfVar.errorCode;
        if (i != -2 && i != 3 && zzbwVar.a() != null) {
            zzbv.i().zzys().zzb(this.zzbls.a());
        }
        if (zzaxfVar.errorCode == -1) {
            this.zzblq = false;
            return;
        }
        if (zza(zzaxfVar)) {
            zzbbd.zzdn("Ad refresh scheduled.");
        }
        int i2 = zzaxfVar.errorCode;
        if (i2 != -2) {
            if (i2 == 3) {
                zzaxfVar.zzehw.zza(zzuo.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
            } else {
                zzaxfVar.zzehw.zza(zzuo.zza.zzb.AD_FAILED_TO_LOAD);
            }
            zzbr(zzaxfVar.errorCode);
            return;
        }
        zzbw zzbwVar2 = this.zzbls;
        if (zzbwVar2.J == null) {
            zzbwVar2.J = new zzaxs(zzbwVar2.f10250b);
        }
        zzbx zzbxVar = this.zzbls.f10254f;
        if (zzbxVar != null) {
            zzbxVar.a().zzeg(zzaxfVar.zzdyy);
        }
        this.zzblu.zzh(this.zzbls.j);
        if (zza(this.zzbls.j, zzaxfVar)) {
            zzbw zzbwVar3 = this.zzbls;
            zzbwVar3.j = zzaxfVar;
            zzaxh zzaxhVar = zzbwVar3.l;
            if (zzaxhVar != null) {
                zzaxf zzaxfVar2 = zzbwVar3.j;
                if (zzaxfVar2 != null) {
                    zzaxhVar.zzas(zzaxfVar2.zzehn);
                    zzbwVar3.l.zzat(zzbwVar3.j.zzeho);
                    zzbwVar3.l.zzak(zzbwVar3.j.zzdyd);
                }
                zzbwVar3.l.zzaj(zzbwVar3.i.zzckl);
            }
            this.zzbln.zzg("is_mraid", this.zzbls.j.zzmu() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.zzbln.zzg("is_mediation", this.zzbls.j.zzdyd ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            zzbgg zzbggVar = this.zzbls.j.zzdrv;
            if (zzbggVar != null && zzbggVar.zzadl() != null) {
                this.zzbln.zzg("is_delay_pl", this.zzbls.j.zzdrv.zzadl().zzaee() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.zzbln.zza(this.zzblo, "ttc");
            if (zzbv.i().zzyh() != null) {
                zzbv.i().zzyh().zza(this.zzbln);
            }
            zziq();
            if (this.zzbls.d()) {
                zzil();
            }
        }
        if (zzaxfVar.zzdlu != null) {
            zzbv.e().zza(this.zzbls.f10251c, zzaxfVar.zzdlu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxa zzxaVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setAdListener");
        this.zzbls.n = zzxaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzavb zzavbVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setRewardedVideoAdListener");
        this.zzbls.E = zzavbVar;
    }

    public final void zza(zzauu zzauuVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzbls.F = zzauuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwx zzwxVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setAdClickListener");
        this.zzbls.m = zzwxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzwf zzwfVar) {
        zzbgg zzbggVar;
        Preconditions.a("#008 Must be called on the main UI thread.: setAdSize");
        zzbw zzbwVar = this.zzbls;
        zzbwVar.i = zzwfVar;
        zzaxf zzaxfVar = zzbwVar.j;
        if (zzaxfVar != null && (zzbggVar = zzaxfVar.zzdrv) != null && zzbwVar.L == 0) {
            zzbggVar.zza(zzbht.zzb(zzwfVar));
        }
        zzbx zzbxVar = this.zzbls.f10254f;
        if (zzbxVar == null) {
            return;
        }
        if (zzbxVar.getChildCount() > 1) {
            zzbx zzbxVar2 = this.zzbls.f10254f;
            zzbxVar2.removeView(zzbxVar2.getNextView());
        }
        this.zzbls.f10254f.setMinimumWidth(zzwfVar.widthPixels);
        this.zzbls.f10254f.setMinimumHeight(zzwfVar.heightPixels);
        this.zzbls.f10254f.requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxt zzxtVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setAppEventListener");
        this.zzbls.o = zzxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxq zzxqVar) {
        this.zzbls.p = zzxqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void zza(zzaow zzaowVar) {
        zzbbd.zzeo("#006 Unexpected call to a deprecated method.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public void zza(zzabg zzabgVar) {
        throw new IllegalStateException("#005 Unexpected call to an abstract (unimplemented) method.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzapc zzapcVar, String str) {
        zzbbd.zzeo("#006 Unexpected call to a deprecated method.");
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzxz zzxzVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setCorrelationIdProvider");
        this.zzbls.q = zzxzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzzw zzzwVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setVideoOptions");
        this.zzbls.y = zzzwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final void zza(zzyv zzyvVar) {
        Preconditions.a("#008 Must be called on the main UI thread.: setIconAdOptions");
        this.zzbls.A = zzyvVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(zzawd zzawdVar) {
        if (this.zzbls.E == null) {
            return;
        }
        String str = "";
        int i = 1;
        if (zzawdVar != null) {
            try {
                str = zzawdVar.type;
                i = zzawdVar.zzefo;
            } catch (RemoteException e2) {
                zzbbd.zzd("#007 Could not call remote method.", e2);
                return;
            }
        }
        zzaul zzaulVar = new zzaul(str, i);
        this.zzbls.E.zza(zzaulVar);
        if (this.zzbls.F != null) {
            this.zzbls.F.zza(zzaulVar, this.zzbls.k.zzeag.zzdws);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxq
    public final void zza(HashSet<zzaxh> hashSet) {
        this.zzbls.a(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> zza(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(zzawz.zzb(it.next(), this.zzbls.f10251c, z));
        }
        return arrayList;
    }
}
