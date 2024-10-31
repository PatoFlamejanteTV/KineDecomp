package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zzgr
/* loaded from: classes.dex */
public class zzca {
    final Context mContext;
    final String zzqV;
    String zzvB;
    BlockingQueue<zzcg> zzvD;
    ExecutorService zzvE;
    LinkedHashMap<String, String> zzvF = new LinkedHashMap<>();
    Map<String, zzcd> zzvG = new HashMap();
    private AtomicBoolean zzvH = new AtomicBoolean(false);
    private File zzvI;

    public zzca(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzqV = str;
        this.zzvB = str2;
        this.zzvH.set(zzby.zzuS.get().booleanValue());
        if (this.zzvH.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzvI = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzvF.put(entry.getKey(), entry.getValue());
        }
        this.zzvD = new ArrayBlockingQueue(30);
        this.zzvE = Executors.newSingleThreadExecutor();
        this.zzvE.execute(new af(this));
        this.zzvG.put(NativeProtocol.WEB_DIALOG_ACTION, zzcd.zzvL);
        this.zzvG.put("ad_format", zzcd.zzvL);
        this.zzvG.put("e", zzcd.zzvM);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zza(java.io.File r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L45
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L36
            r0 = 1
            r1.<init>(r4, r0)     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L36
            byte[] r0 = r5.getBytes()     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4d
            r1.write(r0)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4d
            r0 = 10
            r1.write(r0)     // Catch: java.lang.Throwable -> L4b java.io.IOException -> L4d
            if (r1 == 0) goto L1a
            r1.close()     // Catch: java.io.IOException -> L1b
        L1a:
            return
        L1b:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.d(r1, r0)
            goto L1a
        L22:
            r0 = move-exception
            r1 = r2
        L24:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.d(r2, r0)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L1a
            r1.close()     // Catch: java.io.IOException -> L2f
            goto L1a
        L2f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.d(r1, r0)
            goto L1a
        L36:
            r0 = move-exception
            r1 = r2
        L38:
            if (r1 == 0) goto L3d
            r1.close()     // Catch: java.io.IOException -> L3e
        L3d:
            throw r0
        L3e:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.ads.internal.util.client.zzb.d(r2, r1)
            goto L3d
        L45:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.ads.internal.util.client.zzb.e(r0)
            goto L1a
        L4b:
            r0 = move-exception
            goto L38
        L4d:
            r0 = move-exception
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzca.zza(java.io.File, java.lang.String):void");
    }

    private void zzc(Map<String, String> map, String str) {
        String zza = zza(this.zzvB, map, str);
        if (this.zzvH.get()) {
            zza(this.zzvI, zza);
        } else {
            com.google.android.gms.ads.internal.zzp.e().zzc(this.mContext, this.zzqV, zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzdj() {
        while (true) {
            try {
                zzcg take = this.zzvD.take();
                String zzdp = take.zzdp();
                if (!TextUtils.isEmpty(zzdp)) {
                    zzc(zza(this.zzvF, take.zzn()), zzdp);
                }
            } catch (InterruptedException e) {
                com.google.android.gms.ads.internal.util.client.zzb.d("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    public zzcd zzR(String str) {
        zzcd zzcdVar = this.zzvG.get(str);
        return zzcdVar != null ? zzcdVar : zzcd.zzvK;
    }

    String zza(String str, Map<String, String> map, String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        StringBuilder sb = new StringBuilder(buildUpon.build().toString());
        sb.append("&").append("it").append("=").append(str2);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzR(key).zzd((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }

    public boolean zza(zzcg zzcgVar) {
        return this.zzvD.offer(zzcgVar);
    }

    public void zzb(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzvF.put("e", TextUtils.join(",", list));
    }
}
