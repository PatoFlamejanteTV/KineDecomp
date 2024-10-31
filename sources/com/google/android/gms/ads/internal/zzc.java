package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzaeh;
import com.google.android.gms.internal.ads.zzahq;
import com.google.android.gms.internal.ads.zzakq;
import com.google.android.gms.internal.ads.zzakr;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzakz;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzatd;
import com.google.android.gms.internal.ads.zzaxf;
import com.google.android.gms.internal.ads.zzaxh;
import com.google.android.gms.internal.ads.zzaxj;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbi;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcg;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzsx;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzur;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyv;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzc extends zza implements zzn, zzbo, zzaks {
    protected final zzalg zzbma;
    private transient boolean zzbmb;

    public zzc(Context context, zzwf zzwfVar, String str, zzalg zzalgVar, zzbbi zzbbiVar, zzv zzvVar) {
        this(new zzbw(context, zzwfVar, str, zzbbiVar), zzalgVar, null, zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String getMediationAdapterClassName() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null) {
            return null;
        }
        return zzaxfVar.zzdnd;
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzvt
    public void onAdClicked() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null) {
            zzbbd.zzeo("Ad state was null when trying to ping click URLs.");
            return;
        }
        zzakr zzakrVar = zzaxfVar.zzehj;
        if (zzakrVar != null && zzakrVar.zzdlq != null) {
            zzbv.y();
            zzbw zzbwVar = this.zzbls;
            Context context = zzbwVar.f10251c;
            String str = zzbwVar.f10253e.zzdp;
            zzaxf zzaxfVar2 = zzbwVar.j;
            zzakz.zza(context, str, zzaxfVar2, zzbwVar.f10250b, false, zza(zzaxfVar2.zzehj.zzdlq, zzaxfVar2.zzdzf));
        }
        zzakq zzakqVar = this.zzbls.j.zzdnb;
        if (zzakqVar != null && zzakqVar.zzdkz != null) {
            zzbv.y();
            zzbw zzbwVar2 = this.zzbls;
            Context context2 = zzbwVar2.f10251c;
            String str2 = zzbwVar2.f10253e.zzdp;
            zzaxf zzaxfVar3 = zzbwVar2.j;
            zzakz.zza(context2, str2, zzaxfVar3, zzbwVar2.f10250b, false, zzaxfVar3.zzdnb.zzdkz);
        }
        super.onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onPause() {
        this.zzblu.zzj(this.zzbls.j);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzn
    public final void onResume() {
        this.zzblu.zzk(this.zzbls.j);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public void pause() {
        zzalj zzaljVar;
        Preconditions.a("pause must be called on the main UI thread.");
        zzbw zzbwVar = this.zzbls;
        zzaxf zzaxfVar = zzbwVar.j;
        if (zzaxfVar != null && zzaxfVar.zzdrv != null && zzbwVar.d()) {
            zzbv.g();
            zzayp.zzi(this.zzbls.j.zzdrv);
        }
        zzaxf zzaxfVar2 = this.zzbls.j;
        if (zzaxfVar2 != null && (zzaljVar = zzaxfVar2.zzdnc) != null) {
            try {
                zzaljVar.pause();
            } catch (RemoteException unused) {
                zzbbd.zzeo("Could not pause mediation adapter.");
            }
        }
        this.zzblu.zzj(this.zzbls.j);
        this.zzblr.b();
    }

    public final void recordImpression() {
        zza(this.zzbls.j, false);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzxl
    public void resume() {
        zzbgg zzbggVar;
        zzalj zzaljVar;
        Preconditions.a("resume must be called on the main UI thread.");
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null || (zzbggVar = zzaxfVar.zzdrv) == null) {
            zzbggVar = null;
        }
        if (zzbggVar != null && this.zzbls.d()) {
            zzbv.g();
            zzayp.zzj(this.zzbls.j.zzdrv);
        }
        zzaxf zzaxfVar2 = this.zzbls.j;
        if (zzaxfVar2 != null && (zzaljVar = zzaxfVar2.zzdnc) != null) {
            try {
                zzaljVar.resume();
            } catch (RemoteException unused) {
                zzbbd.zzeo("Could not resume mediation adapter.");
            }
        }
        if (zzbggVar == null || !zzbggVar.zzadt()) {
            this.zzblr.c();
        }
        this.zzblu.zzk(this.zzbls.j);
    }

    public void showInterstitial() {
        zzbbd.zzeo("showInterstitial is not supported for current ad type");
    }

    public final boolean zza(zzwb zzwbVar, zzaba zzabaVar, int i) {
        zzaxj zzaxjVar;
        if (!zziu()) {
            return false;
        }
        zzbv.e();
        zzsx zzzo = zzbv.i().zzyq().zzzo();
        Bundle zza = zzzo == null ? null : zzayh.zza(zzzo);
        this.zzblr.a();
        this.zzbls.L = 0;
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcuz)).booleanValue()) {
            zzaxjVar = zzbv.i().zzyq().zzzi();
            zzad m = zzbv.m();
            zzbw zzbwVar = this.zzbls;
            m.a(zzbwVar.f10251c, zzbwVar.f10253e, false, zzaxjVar, zzaxjVar != null ? zzaxjVar.zzyf() : null, zzbwVar.f10250b, null);
        } else {
            zzaxjVar = null;
        }
        return zza(zza(zzwbVar, zza, zzaxjVar, i), zzabaVar);
    }

    @Override // com.google.android.gms.ads.internal.zza, com.google.android.gms.internal.ads.zzapm
    public final void zzb(zzaxf zzaxfVar) {
        zzakr zzakrVar;
        List<String> list;
        super.zzb(zzaxfVar);
        if (zzaxfVar.zzdnb != null) {
            zzbbd.zzdn("Disable the debug gesture detector on the mediation ad frame.");
            zzbx zzbxVar = this.zzbls.f10254f;
            if (zzbxVar != null) {
                zzbxVar.d();
            }
            zzbbd.zzdn("Pinging network fill URLs.");
            zzbv.y();
            zzbw zzbwVar = this.zzbls;
            zzakz.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzaxfVar, zzbwVar.f10250b, false, zzaxfVar.zzdnb.zzdld);
            zzakr zzakrVar2 = zzaxfVar.zzehj;
            if (zzakrVar2 != null && (list = zzakrVar2.zzdlu) != null && list.size() > 0) {
                zzbbd.zzdn("Pinging urls remotely");
                zzbv.e().zza(this.zzbls.f10251c, zzaxfVar.zzehj.zzdlu);
            }
        } else {
            zzbbd.zzdn("Enable the debug gesture detector on the admob ad frame.");
            zzbx zzbxVar2 = this.zzbls.f10254f;
            if (zzbxVar2 != null) {
                zzbxVar2.c();
            }
        }
        if (zzaxfVar.errorCode != 3 || (zzakrVar = zzaxfVar.zzehj) == null || zzakrVar.zzdlt == null) {
            return;
        }
        zzbbd.zzdn("Pinging no fill URLs.");
        zzbv.y();
        zzbw zzbwVar2 = this.zzbls;
        zzakz.zza(zzbwVar2.f10251c, zzbwVar2.f10253e.zzdp, zzaxfVar, zzbwVar2.f10250b, false, zzaxfVar.zzehj.zzdlt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public final boolean zzc(zzwb zzwbVar) {
        return super.zzc(zzwbVar) && !this.zzbmb;
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzd(String str, String str2) {
        onAppEvent(str, str2);
    }

    protected boolean zziu() {
        zzbv.e();
        if (zzayh.zzn(this.zzbls.f10251c, "android.permission.INTERNET")) {
            zzbv.e();
            if (zzayh.zzah(this.zzbls.f10251c)) {
                return true;
            }
        }
        return false;
    }

    public void zziv() {
        this.zzbmb = false;
        zzii();
        this.zzbls.l.zzxx();
    }

    public void zziw() {
        this.zzbmb = true;
        zzik();
    }

    public void zzix() {
        zzbbd.zzeo("Mediated ad does not support onVideoEnd callback");
    }

    public void zziy() {
        onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zziz() {
        zziv();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzja() {
        zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzjb() {
        zziw();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzjc() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar != null) {
            String str = zzaxfVar.zzdnd;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
            sb.append("Mediation adapter ");
            sb.append(str);
            sb.append(" refreshed, but mediation adapters should never refresh.");
            zzbbd.zzeo(sb.toString());
        }
        zza(this.zzbls.j, true);
        zzb(this.zzbls.j, true);
        zzil();
    }

    public void zzjd() {
        recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzxl
    public final String zzje() {
        zzaxf zzaxfVar = this.zzbls.j;
        if (zzaxfVar == null) {
            return null;
        }
        return zzc(zzaxfVar);
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjf() {
        Executor executor = zzbcg.zzepo;
        zzbl zzblVar = this.zzblr;
        zzblVar.getClass();
        executor.execute(F.a(zzblVar));
    }

    @Override // com.google.android.gms.ads.internal.zzbo
    public final void zzjg() {
        Executor executor = zzbcg.zzepo;
        zzbl zzblVar = this.zzblr;
        zzblVar.getClass();
        executor.execute(G.a(zzblVar));
    }

    @VisibleForTesting
    private zzc(zzbw zzbwVar, zzalg zzalgVar, zzbl zzblVar, zzv zzvVar) {
        super(zzbwVar, null, zzvVar);
        this.zzbma = zzalgVar;
        this.zzbmb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzc(zzaxf zzaxfVar) {
        zzakq zzakqVar;
        if (zzaxfVar == null) {
            return null;
        }
        String str = zzaxfVar.zzdnd;
        if (("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) && (zzakqVar = zzaxfVar.zzdnb) != null) {
            try {
                return new JSONObject(zzakqVar.zzdle).getString("class_name");
            } catch (NullPointerException | JSONException unused) {
            }
        }
        return str;
    }

    public final boolean zza(zzasj zzasjVar, zzaba zzabaVar) {
        zzaxv zzarnVar;
        this.zzbln = zzabaVar;
        zzabaVar.zzg("seq_num", zzasjVar.zzdwj);
        zzabaVar.zzg("request_id", zzasjVar.zzdws);
        zzabaVar.zzg(com.umeng.analytics.pro.q.f25955c, zzasjVar.zzclm);
        PackageInfo packageInfo = zzasjVar.zzdwh;
        if (packageInfo != null) {
            zzabaVar.zzg("app_version", String.valueOf(packageInfo.versionCode));
        }
        zzbw zzbwVar = this.zzbls;
        zzbv.a();
        Context context = this.zzbls.f10251c;
        zzur zzurVar = this.zzbly.f10267d;
        if (zzasjVar.zzdwg.extras.getBundle("sdk_less_server_data") != null) {
            zzarnVar = new zzatd(context, zzasjVar, this, zzurVar);
        } else {
            zzarnVar = new zzarn(context, zzasjVar, this, zzurVar);
        }
        zzarnVar.zzyz();
        zzbwVar.f10255g = zzarnVar;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzb(zzaxf zzaxfVar, boolean z) {
        if (zzaxfVar == null) {
            return;
        }
        if (zzaxfVar != null && zzaxfVar.zzdls != null && !zzaxfVar.zzehr) {
            zzbv.e();
            zzbw zzbwVar = this.zzbls;
            zzayh.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zzc(zzaxfVar.zzdls));
            zzaxfVar.zzehr = true;
        }
        if (!zzaxfVar.zzeht || z) {
            zzakr zzakrVar = zzaxfVar.zzehj;
            if (zzakrVar != null && zzakrVar.zzdls != null) {
                zzbv.y();
                zzbw zzbwVar2 = this.zzbls;
                zzakz.zza(zzbwVar2.f10251c, zzbwVar2.f10253e.zzdp, zzaxfVar, zzbwVar2.f10250b, z, zzc(zzaxfVar.zzehj.zzdls));
            }
            zzakq zzakqVar = zzaxfVar.zzdnb;
            if (zzakqVar != null && zzakqVar.zzdlb != null) {
                zzbv.y();
                zzbw zzbwVar3 = this.zzbls;
                zzakz.zza(zzbwVar3.f10251c, zzbwVar3.f10253e.zzdp, zzaxfVar, zzbwVar3.f10250b, z, zzaxfVar.zzdnb.zzdlb);
            }
            zzaxfVar.zzeht = true;
        }
    }

    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzwb zzwbVar, zzaba zzabaVar) {
        return zza(zzwbVar, zzabaVar, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.ads.internal.zza
    public boolean zza(zzaxf zzaxfVar, zzaxf zzaxfVar2) {
        int i;
        zzakt zzaktVar;
        if (zzaxfVar != null && (zzaktVar = zzaxfVar.zzdne) != null) {
            zzaktVar.zza((zzaks) null);
        }
        zzakt zzaktVar2 = zzaxfVar2.zzdne;
        if (zzaktVar2 != null) {
            zzaktVar2.zza(this);
        }
        zzakr zzakrVar = zzaxfVar2.zzehj;
        int i2 = 0;
        if (zzakrVar != null) {
            i2 = zzakrVar.zzdmg;
            i = zzakrVar.zzdmh;
        } else {
            i = 0;
        }
        this.zzbls.J.zzl(i2, i);
        return true;
    }

    @Override // com.google.android.gms.ads.internal.zza
    final boolean zza(zzaxf zzaxfVar) {
        zzwb zzwbVar = this.zzblt;
        boolean z = false;
        if (zzwbVar != null) {
            this.zzblt = null;
        } else {
            zzwbVar = zzaxfVar.zzdwg;
            Bundle bundle = zzwbVar.extras;
            if (bundle != null) {
                z = bundle.getBoolean("_noRefresh", false);
            }
        }
        return zza(zzwbVar, zzaxfVar, z);
    }

    protected boolean zza(zzwb zzwbVar, zzaxf zzaxfVar, boolean z) {
        if (!z && this.zzbls.d()) {
            long j = zzaxfVar.zzdlx;
            if (j > 0) {
                this.zzblr.a(zzwbVar, j);
            } else {
                zzakr zzakrVar = zzaxfVar.zzehj;
                if (zzakrVar != null) {
                    long j2 = zzakrVar.zzdlx;
                    if (j2 > 0) {
                        this.zzblr.a(zzwbVar, j2);
                    }
                }
                if (!zzaxfVar.zzdyd && zzaxfVar.errorCode == 2) {
                    this.zzblr.b(zzwbVar);
                }
            }
        }
        return this.zzblr.e();
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zza(zzadx zzadxVar, String str) {
        String customTemplateId;
        zzaeh zzaehVar = null;
        if (zzadxVar != null) {
            try {
                customTemplateId = zzadxVar.getCustomTemplateId();
            } catch (RemoteException e2) {
                zzbbd.zzc("Unable to call onCustomClick.", e2);
                return;
            }
        } else {
            customTemplateId = null;
        }
        if (this.zzbls.v != null && customTemplateId != null) {
            zzaehVar = this.zzbls.v.get(customTemplateId);
        }
        if (zzaehVar == null) {
            zzbbd.zzeo("Mediation adapter invoked onCustomClick but no listeners were set.");
        } else {
            zzaehVar.zzb(zzadxVar, str);
        }
    }

    private final zzasj zza(zzwb zzwbVar, Bundle bundle, zzaxj zzaxjVar, int i) {
        PackageInfo packageInfo;
        Bundle bundle2;
        String str;
        JSONArray optJSONArray;
        ApplicationInfo applicationInfo = this.zzbls.f10251c.getApplicationInfo();
        try {
            packageInfo = Wrappers.a(this.zzbls.f10251c).b(applicationInfo.packageName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzbls.f10251c.getResources().getDisplayMetrics();
        zzbx zzbxVar = this.zzbls.f10254f;
        if (zzbxVar == null || zzbxVar.getParent() == null) {
            bundle2 = null;
        } else {
            int[] iArr = new int[2];
            this.zzbls.f10254f.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.zzbls.f10254f.getWidth();
            int height = this.zzbls.f10254f.getHeight();
            int i4 = (!this.zzbls.f10254f.isShown() || i2 + width <= 0 || i3 + height <= 0 || i2 > displayMetrics.widthPixels || i3 > displayMetrics.heightPixels) ? 0 : 1;
            Bundle bundle3 = new Bundle(5);
            bundle3.putInt(FragmentC2201x.f23219a, i2);
            bundle3.putInt("y", i3);
            bundle3.putInt("width", width);
            bundle3.putInt("height", height);
            bundle3.putInt("visible", i4);
            bundle2 = bundle3;
        }
        this.zzbls.l = zzbv.i().zzys().zza(zzbv.l(), this.zzbls.f10250b);
        this.zzbls.l.zzn(zzwbVar);
        zzbv.e();
        zzbw zzbwVar = this.zzbls;
        String zza = zzayh.zza(zzbwVar.f10251c, zzbwVar.f10254f, zzbwVar.i);
        long j = 0;
        zzxz zzxzVar = this.zzbls.q;
        if (zzxzVar != null) {
            try {
                j = zzxzVar.getValue();
            } catch (RemoteException unused2) {
                zzbbd.zzeo("Cannot get correlation id, default to 0.");
            }
        }
        long j2 = j;
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzbv.i().zzys().zza(this.zzbls.f10251c, this);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i5 = 0; i5 < this.zzbls.w.size(); i5++) {
            String keyAt = this.zzbls.w.keyAt(i5);
            arrayList.add(keyAt);
            if (this.zzbls.v.containsKey(keyAt) && this.zzbls.v.get(keyAt) != null) {
                arrayList2.add(keyAt);
            }
        }
        zzbcb zza3 = zzayf.zza(new H(this));
        zzbcb zza4 = zzayf.zza(new I(this));
        String zzye = zzaxjVar != null ? zzaxjVar.zzye() : null;
        List<String> list = this.zzbls.I;
        if (list != null && list.size() > 0) {
            int i6 = packageInfo != null ? packageInfo.versionCode : 0;
            if (i6 > zzbv.i().zzyq().zzzh()) {
                zzbv.i().zzyq().zzzn();
                zzbv.i().zzyq().zzcv(i6);
            } else {
                JSONObject zzzm = zzbv.i().zzyq().zzzm();
                if (zzzm != null && (optJSONArray = zzzm.optJSONArray(this.zzbls.f10250b)) != null) {
                    str = optJSONArray.toString();
                    zzbw zzbwVar2 = this.zzbls;
                    zzwf zzwfVar = zzbwVar2.i;
                    String str2 = zzbwVar2.f10250b;
                    String zzxy = zzbwVar2.l.zzxy();
                    String zzqa = zzwu.zzqa();
                    zzbw zzbwVar3 = this.zzbls;
                    zzbbi zzbbiVar = zzbwVar3.f10253e;
                    List<String> list2 = zzbwVar3.I;
                    boolean zzzb = zzbv.i().zzyq().zzzb();
                    int i7 = displayMetrics.widthPixels;
                    int i8 = displayMetrics.heightPixels;
                    float f2 = displayMetrics.density;
                    List<String> zzqw = zzaan.zzqw();
                    zzbw zzbwVar4 = this.zzbls;
                    String str3 = zzbwVar4.f10249a;
                    zzacp zzacpVar = zzbwVar4.x;
                    String f3 = zzbwVar4.f();
                    float zzkj = zzbv.j().zzkj();
                    boolean zzkk = zzbv.j().zzkk();
                    zzbv.e();
                    int zzas = zzayh.zzas(this.zzbls.f10251c);
                    zzbv.e();
                    int zzy = zzayh.zzy(this.zzbls.f10254f);
                    boolean z = this.zzbls.f10251c instanceof Activity;
                    boolean zzzg = zzbv.i().zzyq().zzzg();
                    boolean zzyj = zzbv.i().zzyj();
                    int zzada = zzbv.C().zzada();
                    zzbv.e();
                    Bundle zzzv = zzayh.zzzv();
                    String zzaag = zzbv.o().zzaag();
                    zzyv zzyvVar = this.zzbls.A;
                    boolean zzaah = zzbv.o().zzaah();
                    Bundle zztx = zzahq.zzto().zztx();
                    boolean zzdu = zzbv.i().zzyq().zzdu(this.zzbls.f10250b);
                    zzbw zzbwVar5 = this.zzbls;
                    List<Integer> list3 = zzbwVar5.C;
                    boolean a2 = Wrappers.a(zzbwVar5.f10251c).a();
                    boolean zzyk = zzbv.i().zzyk();
                    zzbv.g();
                    return new zzasj(bundle2, zzwbVar, zzwfVar, str2, applicationInfo, packageInfo, zzxy, zzqa, zzbbiVar, zza2, list2, arrayList, bundle, zzzb, i7, i8, f2, zza, j2, uuid, zzqw, str3, zzacpVar, f3, zzkj, zzkk, zzas, zzy, z, zzzg, zza3, zzye, zzyj, zzada, zzzv, zzaag, zzyvVar, zzaah, zztx, zzdu, zza4, list3, str, arrayList2, i, a2, zzyk, zzayp.zzaaa(), (ArrayList) zzbbq.zza(zzbv.i().zzyr(), (Object) null, 1000L, TimeUnit.MILLISECONDS), zzbv.e().zzaw(this.zzbls.f10251c), this.zzbls.z, zzbv.e().zzax(this.zzbls.f10251c));
                }
            }
        }
        str = null;
        zzbw zzbwVar22 = this.zzbls;
        zzwf zzwfVar2 = zzbwVar22.i;
        String str22 = zzbwVar22.f10250b;
        String zzxy2 = zzbwVar22.l.zzxy();
        String zzqa2 = zzwu.zzqa();
        zzbw zzbwVar32 = this.zzbls;
        zzbbi zzbbiVar2 = zzbwVar32.f10253e;
        List<String> list22 = zzbwVar32.I;
        boolean zzzb2 = zzbv.i().zzyq().zzzb();
        int i72 = displayMetrics.widthPixels;
        int i82 = displayMetrics.heightPixels;
        float f22 = displayMetrics.density;
        List<String> zzqw2 = zzaan.zzqw();
        zzbw zzbwVar42 = this.zzbls;
        String str32 = zzbwVar42.f10249a;
        zzacp zzacpVar2 = zzbwVar42.x;
        String f32 = zzbwVar42.f();
        float zzkj2 = zzbv.j().zzkj();
        boolean zzkk2 = zzbv.j().zzkk();
        zzbv.e();
        int zzas2 = zzayh.zzas(this.zzbls.f10251c);
        zzbv.e();
        int zzy2 = zzayh.zzy(this.zzbls.f10254f);
        boolean z2 = this.zzbls.f10251c instanceof Activity;
        boolean zzzg2 = zzbv.i().zzyq().zzzg();
        boolean zzyj2 = zzbv.i().zzyj();
        int zzada2 = zzbv.C().zzada();
        zzbv.e();
        Bundle zzzv2 = zzayh.zzzv();
        String zzaag2 = zzbv.o().zzaag();
        zzyv zzyvVar2 = this.zzbls.A;
        boolean zzaah2 = zzbv.o().zzaah();
        Bundle zztx2 = zzahq.zzto().zztx();
        boolean zzdu2 = zzbv.i().zzyq().zzdu(this.zzbls.f10250b);
        zzbw zzbwVar52 = this.zzbls;
        List<Integer> list32 = zzbwVar52.C;
        boolean a22 = Wrappers.a(zzbwVar52.f10251c).a();
        boolean zzyk2 = zzbv.i().zzyk();
        zzbv.g();
        return new zzasj(bundle2, zzwbVar, zzwfVar2, str22, applicationInfo, packageInfo, zzxy2, zzqa2, zzbbiVar2, zza2, list22, arrayList, bundle, zzzb2, i72, i82, f22, zza, j2, uuid, zzqw2, str32, zzacpVar2, f32, zzkj2, zzkk2, zzas2, zzy2, z2, zzzg2, zza3, zzye, zzyj2, zzada2, zzzv2, zzaag2, zzyvVar2, zzaah2, zztx2, zzdu2, zza4, list32, str, arrayList2, i, a22, zzyk2, zzayp.zzaaa(), (ArrayList) zzbbq.zza(zzbv.i().zzyr(), (Object) null, 1000L, TimeUnit.MILLISECONDS), zzbv.e().zzaw(this.zzbls.f10251c), this.zzbls.z, zzbv.e().zzax(this.zzbls.f10251c));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zza(zzaxf zzaxfVar, boolean z) {
        if (zzaxfVar == null) {
            zzbbd.zzeo("Ad state was null when trying to ping impression URLs.");
            return;
        }
        if (zzaxfVar == null) {
            zzbbd.zzeo("Ad state was null when trying to ping impression URLs.");
        } else {
            zzbbd.zzdn("Pinging Impression URLs.");
            zzaxh zzaxhVar = this.zzbls.l;
            if (zzaxhVar != null) {
                zzaxhVar.zzxv();
            }
            zzaxfVar.zzehw.zza(zzuo.zza.zzb.AD_IMPRESSION);
            if (zzaxfVar.zzdlr != null && !zzaxfVar.zzehq) {
                zzbv.e();
                zzbw zzbwVar = this.zzbls;
                zzayh.zza(zzbwVar.f10251c, zzbwVar.f10253e.zzdp, zza(zzaxfVar.zzdlr, zzaxfVar.zzdzf));
                zzaxfVar.zzehq = true;
            }
        }
        if (!zzaxfVar.zzehs || z) {
            zzakr zzakrVar = zzaxfVar.zzehj;
            if (zzakrVar != null && zzakrVar.zzdlr != null) {
                zzbv.y();
                zzbw zzbwVar2 = this.zzbls;
                zzakz.zza(zzbwVar2.f10251c, zzbwVar2.f10253e.zzdp, zzaxfVar, zzbwVar2.f10250b, z, zza(zzaxfVar.zzehj.zzdlr, zzaxfVar.zzdzf));
            }
            zzakq zzakqVar = zzaxfVar.zzdnb;
            if (zzakqVar != null && zzakqVar.zzdla != null) {
                zzbv.y();
                zzbw zzbwVar3 = this.zzbls;
                zzakz.zza(zzbwVar3.f10251c, zzbwVar3.f10253e.zzdp, zzaxfVar, zzbwVar3.f10250b, z, zzaxfVar.zzdnb.zzdla);
            }
            zzaxfVar.zzehs = true;
        }
    }
}
