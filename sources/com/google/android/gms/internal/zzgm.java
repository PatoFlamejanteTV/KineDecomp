package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.internal.zzhs;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public class zzgm implements Callable<zzhs> {
    private static final long zzDE = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zzih zzDF;
    private final com.google.android.gms.ads.internal.zzn zzDG;
    private final zzbc zzDH;
    private final zzhs.zza zzDe;
    private final zzan zzwL;
    private final Object zzpd = new Object();
    private boolean zzDI = false;
    private int zzDv = -2;
    private List<String> zzDJ = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public zzdk f1721a;

        a() {
        }
    }

    /* loaded from: classes.dex */
    public interface zza<T extends zzh.zza> {
        T zza(zzgm zzgmVar, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException;
    }

    public zzgm(Context context, com.google.android.gms.ads.internal.zzn zznVar, zzbc zzbcVar, zzih zzihVar, zzan zzanVar, zzhs.zza zzaVar) {
        this.mContext = context;
        this.zzDG = zznVar;
        this.zzDF = zzihVar;
        this.zzDH = zzbcVar;
        this.zzDe = zzaVar;
        this.zzwL = zzanVar;
    }

    private zzh.zza zza(zzbb zzbbVar, zza zzaVar, JSONObject jSONObject) throws ExecutionException, InterruptedException, JSONException {
        if (zzfD()) {
            return null;
        }
        String[] zzc = zzc(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzDJ = zzc == null ? null : Arrays.asList(zzc);
        zzh.zza zza2 = zzaVar.zza(this, jSONObject);
        if (zza2 == null) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Failed to retrieve ad assets.");
            return null;
        }
        zza2.a(new com.google.android.gms.ads.internal.formats.zzh(this.mContext, this.zzDG, zzbbVar, this.zzwL, jSONObject, zza2, this.zzDe.zzHC.k));
        return zza2;
    }

    private zzhs zza(zzh.zza zzaVar) {
        int i;
        synchronized (this.zzpd) {
            i = this.zzDv;
            if (zzaVar == null && this.zzDv == -2) {
                i = 0;
            }
        }
        return new zzhs(this.zzDe.zzHC.c, null, this.zzDe.zzHD.d, i, this.zzDe.zzHD.f, this.zzDJ, this.zzDe.zzHD.l, this.zzDe.zzHD.k, this.zzDe.zzHC.i, false, null, null, null, null, null, 0L, this.zzDe.zzqn, this.zzDe.zzHD.g, this.zzDe.zzHz, this.zzDe.zzHA, this.zzDe.zzHD.o, this.zzDe.zzHw, i != -2 ? null : zzaVar);
    }

    private zziq<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString("url") : jSONObject.optString("url");
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzio(new com.google.android.gms.ads.internal.formats.zzc(null, Uri.parse(string), optDouble)) : this.zzDF.zza(string, new ct(this, z, optDouble, string));
        }
        zza(0, z);
        return new zzio(null);
    }

    private void zza(zzh.zza zzaVar, zzbb zzbbVar) {
        if (zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) {
            a aVar = new a();
            cr crVar = new cr(this, (com.google.android.gms.ads.internal.formats.zzf) zzaVar);
            aVar.f1721a = crVar;
            zzbbVar.zza("/nativeAdCustomClick", crVar);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(zzbb zzbbVar) throws TimeoutException, JSONException {
        if (zzfD()) {
            return null;
        }
        zzin zzinVar = new zzin();
        a aVar = new a();
        cp cpVar = new cp(this, zzbbVar, aVar, zzinVar);
        aVar.f1721a = cpVar;
        zzbbVar.zza("/nativeAdPreProcess", cpVar);
        zzbbVar.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzDe.zzHD.c));
        return (JSONObject) zzinVar.get(zzDE, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(zzcu zzcuVar, String str) {
        try {
            zzcy a2 = this.zzDG.a(zzcuVar.getCustomTemplateId());
            if (a2 != null) {
                a2.zza(zzcuVar, str);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<Drawable> zzd(List<com.google.android.gms.ads.internal.formats.zzc> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        Iterator<com.google.android.gms.ads.internal.formats.zzc> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((Drawable) com.google.android.gms.dynamic.zze.a(it.next().zzdv()));
        }
        return arrayList;
    }

    private zzbb zzfC() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (zzfD()) {
            return null;
        }
        zzbb zzbbVar = this.zzDH.zza(this.mContext, this.zzDe.zzHC.k, (this.zzDe.zzHD.b.indexOf("https") == 0 ? "https:" : "http:") + zzby.zzvj.get(), this.zzwL).get(zzDE, TimeUnit.MILLISECONDS);
        zzbbVar.zza(this.zzDG, this.zzDG, this.zzDG, this.zzDG, false, null, null, null, null);
        return zzbbVar;
    }

    public void zzC(int i) {
        synchronized (this.zzpd) {
            this.zzDI = true;
            this.zzDv = i;
        }
    }

    public zziq<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zziq<com.google.android.gms.ads.internal.formats.zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzC(i);
        }
    }

    protected zza zzd(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzfD()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzDe.zzHC.z != null ? this.zzDe.zzHC.z.b : false;
        boolean z2 = this.zzDe.zzHC.z != null ? this.zzDe.zzHC.z.d : false;
        if ("2".equals(string)) {
            return new zzgn(z, z2);
        }
        if (AppEventsConstants.EVENT_PARAM_VALUE_YES.equals(string)) {
            return new zzgo(z, z2);
        }
        if ("3".equals(string)) {
            String string2 = jSONObject.getString("custom_template_id");
            zzin zzinVar = new zzin();
            zzid.zzIE.post(new cq(this, zzinVar, string2));
            if (zzinVar.get(zzDE, TimeUnit.MILLISECONDS) != null) {
                return new zzgp(z);
            }
            com.google.android.gms.ads.internal.util.client.zzb.b("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzC(0);
        }
        return null;
    }

    public zziq<com.google.android.gms.ads.internal.formats.zza> zze(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return new zzio(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", LicenseErrCode.LICENSE_STATUS_NOT_LICENSED);
        int optInt3 = optJSONObject.optInt("presentation_ms", LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT);
        List<zziq<com.google.android.gms.ads.internal.formats.zzc>> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, "image", false, false));
        }
        return zzip.zza(zzip.zzh(arrayList), new cs(this, optString, zzb2, zzb, optInt, optInt3, optInt2));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzfB, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.internal.zzhs call() {
        /*
            r3 = this;
            com.google.android.gms.internal.zzbb r0 = r3.zzfC()     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
            org.json.JSONObject r1 = r3.zzb(r0)     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
            com.google.android.gms.internal.zzgm$zza r2 = r3.zzd(r1)     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
            com.google.android.gms.ads.internal.formats.zzh$zza r1 = r3.zza(r0, r2, r1)     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
            r3.zza(r1, r0)     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
            com.google.android.gms.internal.zzhs r0 = r3.zza(r1)     // Catch: org.json.JSONException -> L18 java.util.concurrent.TimeoutException -> L2c java.lang.InterruptedException -> L33 java.util.concurrent.ExecutionException -> L35 java.util.concurrent.CancellationException -> L37
        L17:
            return r0
        L18:
            r0 = move-exception
            java.lang.String r1 = "Malformed native JSON response."
            com.google.android.gms.ads.internal.util.client.zzb.d(r1, r0)
        L1e:
            boolean r0 = r3.zzDI
            if (r0 != 0) goto L26
            r0 = 0
            r3.zzC(r0)
        L26:
            r0 = 0
            com.google.android.gms.internal.zzhs r0 = r3.zza(r0)
            goto L17
        L2c:
            r0 = move-exception
            java.lang.String r1 = "Timeout when loading native ad."
            com.google.android.gms.ads.internal.util.client.zzb.d(r1, r0)
            goto L1e
        L33:
            r0 = move-exception
            goto L1e
        L35:
            r0 = move-exception
            goto L1e
        L37:
            r0 = move-exception
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgm.call():com.google.android.gms.internal.zzhs");
    }

    public boolean zzfD() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzDI;
        }
        return z;
    }
}
