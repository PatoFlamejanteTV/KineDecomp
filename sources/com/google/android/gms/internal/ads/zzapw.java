package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.util.VisibleForTesting;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzapw implements Callable<zzaxf> {

    @VisibleForTesting
    private static long zzdtd = 10;
    private final Context mContext;
    private final zzaba zzbln;
    private final zzaqp zzbqa;
    private final zzcu zzdcf;
    private final zzaxg zzdsk;
    private final zzazs zzdte;
    private final com.google.android.gms.ads.internal.zzbb zzdtf;
    private JSONObject zzdti;
    private final Object mLock = new Object();
    private boolean zzdtg = false;
    private int mErrorCode = -2;
    private List<String> zzdth = null;
    private String zzdtj = null;
    private String zzdtk = null;

    public zzapw(Context context, com.google.android.gms.ads.internal.zzbb zzbbVar, zzazs zzazsVar, zzcu zzcuVar, zzaxg zzaxgVar, zzaba zzabaVar) {
        this.mContext = context;
        this.zzdtf = zzbbVar;
        this.zzdte = zzazsVar;
        this.zzdsk = zzaxgVar;
        this.zzdcf = zzcuVar;
        this.zzbln = zzabaVar;
        this.zzbqa = zzbbVar.C();
    }

    private final zzaxf zza(zzacf zzacfVar, boolean z) {
        int i;
        synchronized (this.mLock) {
            i = (zzacfVar == null && this.mErrorCode == -2) ? 0 : this.mErrorCode;
        }
        zzacf zzacfVar2 = i != -2 ? null : zzacfVar;
        zzaxg zzaxgVar = this.zzdsk;
        zzasi zzasiVar = zzaxgVar.zzeag;
        zzwb zzwbVar = zzasiVar.zzdwg;
        zzasm zzasmVar = zzaxgVar.zzehy;
        return new zzaxf(zzwbVar, null, zzasmVar.zzdlq, i, zzasmVar.zzdlr, this.zzdth, zzasmVar.orientation, zzasmVar.zzdlx, zzasiVar.zzdwj, false, null, null, null, null, null, 0L, zzaxgVar.zzbst, zzasmVar.zzdyc, zzaxgVar.zzehn, zzaxgVar.zzeho, zzasmVar.zzdyi, this.zzdti, zzacfVar2, null, null, null, zzasmVar.zzdyu, zzasmVar.zzdyv, null, zzasmVar.zzdlu, this.zzdtj, zzaxgVar.zzehw, zzasmVar.zzbph, zzaxgVar.zzehx, z, zzasmVar.zzdls, zzasmVar.zzbpi, this.zzdtk, zzasmVar.zzdzf);
    }

    private static zzbgg zzb(zzbcb<zzbgg> zzbcbVar) {
        try {
            return zzbcbVar.get(((Integer) zzwu.zzpz().zzd(zzaan.zzcui)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            zzbbd.zzc("", e2);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException e3) {
            e = e3;
            zzbbd.zzc("", e);
            return null;
        } catch (ExecutionException e4) {
            e = e4;
            zzbbd.zzc("", e);
            return null;
        } catch (TimeoutException e5) {
            e = e5;
            zzbbd.zzc("", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzadx zzadxVar, String str) {
        try {
            zzaeh zzar = this.zzdtf.zzar(zzadxVar.getCustomTemplateId());
            if (zzar != null) {
                zzar.zzb(zzadxVar, str);
            }
        } catch (RemoteException e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
            sb.append("Failed to call onCustomClick for asset ");
            sb.append(str);
            sb.append(".");
            zzbbd.zzc(sb.toString(), e2);
        }
    }

    private final void zzcs(int i) {
        synchronized (this.mLock) {
            this.zzdtg = true;
            this.mErrorCode = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <V> List<V> zzk(List<zzbcb<V>> list) throws ExecutionException, InterruptedException {
        ArrayList arrayList = new ArrayList();
        Iterator<zzbcb<V>> it = list.iterator();
        while (it.hasNext()) {
            V v = it.next().get();
            if (v != null) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:            if (r4.length() != 0) goto L16;     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TRY_LEAVE, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TRY_ENTER, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00d3 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f1 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01c1 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01c7 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01e5 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019f A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0185 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f8 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0083 A[Catch: Exception -> 0x0202, TimeoutException -> 0x0209, JSONException -> 0x0210, InterruptedException -> 0x0212, ExecutionException -> 0x0214, CancellationException -> 0x0216, TryCatch #2 {InterruptedException -> 0x0212, CancellationException -> 0x0216, ExecutionException -> 0x0214, TimeoutException -> 0x0209, JSONException -> 0x0210, Exception -> 0x0202, blocks: (B:3:0x0004, B:5:0x0010, B:8:0x002e, B:10:0x0034, B:12:0x003c, B:14:0x0046, B:16:0x005e, B:18:0x0071, B:21:0x007d, B:23:0x00af, B:27:0x00b9, B:29:0x00d3, B:30:0x00dd, B:32:0x00e5, B:34:0x00f1, B:35:0x0169, B:40:0x0175, B:45:0x01a3, B:47:0x01c1, B:48:0x01c7, B:49:0x01e1, B:51:0x01e5, B:52:0x01f4, B:56:0x019f, B:57:0x0185, B:58:0x018c, B:60:0x0192, B:63:0x00f8, B:65:0x0100, B:66:0x010a, B:68:0x0112, B:69:0x011c, B:71:0x0124, B:73:0x0141, B:74:0x0147, B:76:0x0157, B:77:0x0161, B:78:0x015c, B:79:0x0165, B:83:0x0083, B:85:0x0089, B:86:0x008e, B:88:0x009a, B:89:0x009f, B:92:0x0042), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0220  */
    @Override // java.util.concurrent.Callable
    /* renamed from: zzwd, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzaxf call() {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapw.call():com.google.android.gms.internal.ads.zzaxf");
    }

    private final boolean zzwe() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzdtg;
        }
        return z;
    }

    public final zzbcb<zzabm> zzg(JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzbbq.zzm(null);
        }
        String optString = optJSONObject.optString("text");
        int optInt = optJSONObject.optInt("text_size", -1);
        Integer zzb = zzb(optJSONObject, "text_color");
        Integer zzb2 = zzb(optJSONObject, "bg_color");
        int optInt2 = optJSONObject.optInt("animation_ms", 1000);
        int optInt3 = optJSONObject.optInt("presentation_ms", LicenseErrCode.ERROR_NO_XIAOMI_ACCOUNT);
        zzacp zzacpVar = this.zzdsk.zzeag.zzbti;
        int i = (zzacpVar == null || zzacpVar.versionCode < 2) ? 1 : zzacpVar.zzdcv;
        boolean optBoolean = optJSONObject.optBoolean("allow_pub_rendering");
        List<zzbcb<zzabr>> arrayList = new ArrayList<>();
        if (optJSONObject.optJSONArray("images") != null) {
            arrayList = zza(optJSONObject, "images", false, false, true);
        } else {
            arrayList.add(zza(optJSONObject, MessengerShareContentUtility.MEDIA_IMAGE, false, false));
        }
        zzbcl zzbclVar = new zzbcl();
        int size = arrayList.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<zzbcb<zzabr>> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(new RunnableC0840bc(atomicInteger, size, zzbclVar, arrayList), zzayf.zzeky);
            arrayList = arrayList;
        }
        return zzbbq.zza(zzbclVar, new _b(this, optString, zzb2, zzb, optInt, optInt3, optInt2, i, optBoolean), zzayf.zzeky);
    }

    public final void zzh(int i, boolean z) {
        if (z) {
            zzcs(i);
        }
    }

    public final zzbcb<zzbgg> zzc(JSONObject jSONObject, String str) throws JSONException {
        final JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzbbq.zzm(null);
        }
        if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
            zzbbd.zzeo("Required field 'vast_xml' is missing");
            return zzbbq.zzm(null);
        }
        final zzaqf zza = zza(this.mContext, this.zzdcf, this.zzdsk, this.zzbln, this.zzdtf);
        final boolean equals = "instream".equals(jSONObject.optString("type"));
        final zzbcl zzbclVar = new zzbcl();
        zzbcg.zzepo.execute(new Runnable(zza, equals, optJSONObject, zzbclVar) { // from class: com.google.android.gms.internal.ads.cc

            /* renamed from: a, reason: collision with root package name */
            private final zzaqf f12092a;

            /* renamed from: b, reason: collision with root package name */
            private final boolean f12093b;

            /* renamed from: c, reason: collision with root package name */
            private final JSONObject f12094c;

            /* renamed from: d, reason: collision with root package name */
            private final zzbcl f12095d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12092a = zza;
                this.f12093b = equals;
                this.f12094c = optJSONObject;
                this.f12095d = zzbclVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12092a.zza(this.f12093b, this.f12094c, this.f12095d);
            }
        });
        return zzbclVar;
    }

    private static Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final Future<zzabr> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean optBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, optBoolean, z);
    }

    public final zzbcb<zzabr> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public final List<zzbcb<zzabr>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = z3 ? optJSONArray.length() : 1;
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                arrayList.add(zza(jSONObject2, false, z2));
            }
            return arrayList;
        }
        zzh(0, false);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbgg zzc(zzbcb<zzbgg> zzbcbVar) {
        try {
            return zzbcbVar.get(((Integer) zzwu.zzpz().zzd(zzaan.zzcuh)).intValue(), TimeUnit.SECONDS);
        } catch (InterruptedException e2) {
            zzbbd.zzc("InterruptedException occurred while waiting for video to load", e2);
            Thread.currentThread().interrupt();
            return null;
        } catch (CancellationException e3) {
            e = e3;
            zzbbd.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (ExecutionException e4) {
            e = e4;
            zzbbd.zzc("Exception occurred while waiting for video to load", e);
            return null;
        } catch (TimeoutException e5) {
            e = e5;
            zzbbd.zzc("Exception occurred while waiting for video to load", e);
            return null;
        }
    }

    private final zzbcb<zzabr> zza(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String optString;
        if (z) {
            optString = jSONObject.getString("url");
        } else {
            optString = jSONObject.optString("url");
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(optString)) {
            zzh(0, z);
            return zzbbq.zzm(null);
        }
        if (z2) {
            return zzbbq.zzm(new zzabr(null, Uri.parse(optString), optDouble));
        }
        return this.zzdte.zza(optString, new C0825ac(this, z, optDouble, optBoolean, optString));
    }

    public final zzbcb<zzbgg> zza(final String str, final String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final zzaqf zza = zza(this.mContext, this.zzdcf, this.zzdsk, this.zzbln, this.zzdtf);
            final zzbcl zzbclVar = new zzbcl();
            final boolean z2 = true;
            zzbcg.zzepo.execute(new Runnable(zza, z2, zzbclVar, str, str2) { // from class: com.google.android.gms.internal.ads.dc

                /* renamed from: a, reason: collision with root package name */
                private final zzaqf f12115a;

                /* renamed from: b, reason: collision with root package name */
                private final boolean f12116b = true;

                /* renamed from: c, reason: collision with root package name */
                private final zzbcl f12117c;

                /* renamed from: d, reason: collision with root package name */
                private final String f12118d;

                /* renamed from: e, reason: collision with root package name */
                private final String f12119e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12115a = zza;
                    this.f12117c = zzbclVar;
                    this.f12118d = str;
                    this.f12119e = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12115a.zza(this.f12116b, this.f12117c, this.f12118d, this.f12119e);
                }
            });
            return zzbclVar;
        }
        return zzbbq.zzm(null);
    }

    @VisibleForTesting
    private static zzaqf zza(Context context, zzcu zzcuVar, zzaxg zzaxgVar, zzaba zzabaVar, com.google.android.gms.ads.internal.zzbb zzbbVar) {
        return new zzaqf(context, zzcuVar, zzaxgVar, zzabaVar, zzbbVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbcb zza(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzbv.f();
        zzbgg zza = zzbgm.zza(this.mContext, zzbht.zzaey(), "native-omid", false, false, this.zzdcf, this.zzdsk.zzeag.zzbsp, this.zzbln, null, this.zzdtf.zzid(), this.zzdsk.zzehw);
        final zzbck zzn = zzbck.zzn(zza);
        zza.zzadl().zza(new zzbho(zzn) { // from class: com.google.android.gms.internal.ads.Xb

            /* renamed from: a, reason: collision with root package name */
            private final zzbck f11954a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f11954a = zzn;
            }

            @Override // com.google.android.gms.internal.ads.zzbho
            public final void zzp(boolean z) {
                this.f11954a.zzaax();
            }
        });
        zza.loadData(str, "text/html", "UTF-8");
        return zzn;
    }
}
