package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaaq {

    @VisibleForTesting
    private Context mContext;

    @VisibleForTesting
    private String zzbuk;

    @VisibleForTesting
    private String zzcyt;

    @VisibleForTesting
    private ExecutorService zzcyw;
    private AtomicBoolean zzcyz;
    private File zzcza;

    @VisibleForTesting
    private BlockingQueue<zzaba> zzcyv = new ArrayBlockingQueue(100);

    @VisibleForTesting
    private LinkedHashMap<String, String> zzcyx = new LinkedHashMap<>();

    @VisibleForTesting
    private Map<String, zzaau> zzcyy = new HashMap();

    public final void zzrc() {
        while (true) {
            try {
                zzaba take = this.zzcyv.take();
                String zzrh = take.zzrh();
                if (!TextUtils.isEmpty(zzrh)) {
                    Map<String, String> zza = zza(this.zzcyx, take.zzri());
                    Uri.Builder buildUpon = Uri.parse(this.zzcyt).buildUpon();
                    for (Map.Entry<String, String> entry : zza.entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
                    }
                    String str = buildUpon.build().toString() + "&it=" + zzrh;
                    if (this.zzcyz.get()) {
                        File file = this.zzcza;
                        if (file != null) {
                            FileOutputStream fileOutputStream = null;
                            try {
                                try {
                                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
                                    try {
                                        fileOutputStream2.write(str.getBytes());
                                        fileOutputStream2.write(10);
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e2) {
                                            zzbbd.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                                        }
                                    } catch (IOException e3) {
                                        e = e3;
                                        fileOutputStream = fileOutputStream2;
                                        zzbbd.zzc("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e4) {
                                                zzbbd.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e5) {
                                                zzbbd.zzc("CsiReporter: Cannot close file: sdk_csi_data.txt.", e5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (IOException e6) {
                                e = e6;
                            }
                        } else {
                            zzbbd.zzeo("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
                        }
                    } else {
                        com.google.android.gms.ads.internal.zzbv.e();
                        zzayh.zzc(this.mContext, this.zzbuk, str);
                    }
                }
            } catch (InterruptedException e7) {
                zzbbd.zzc("CsiReporter:reporter interrupted", e7);
                return;
            }
        }
    }

    public final void zza(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzbuk = str;
        this.zzcyt = str2;
        this.zzcyz = new AtomicBoolean(false);
        this.zzcyz.set(((Boolean) zzwu.zzpz().zzd(zzaan.zzcpy)).booleanValue());
        if (this.zzcyz.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzcza = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.zzcyx.put(entry.getKey(), entry.getValue());
        }
        this.zzcyw = Executors.newSingleThreadExecutor();
        this.zzcyw.execute(new RunnableC0937i(this));
        this.zzcyy.put(NativeProtocol.WEB_DIALOG_ACTION, zzaau.zzczd);
        this.zzcyy.put("ad_format", zzaau.zzczd);
        this.zzcyy.put("e", zzaau.zzcze);
    }

    public final zzaau zzbn(String str) {
        zzaau zzaauVar = this.zzcyy.get(str);
        return zzaauVar != null ? zzaauVar : zzaau.zzczc;
    }

    public final void zzg(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.zzcyx.put("e", TextUtils.join(",", list));
    }

    public final boolean zza(zzaba zzabaVar) {
        return this.zzcyv.offer(zzabaVar);
    }

    public final Map<String, String> zza(Map<String, String> map, Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            linkedHashMap.put(key, zzbn(key).zzf((String) linkedHashMap.get(key), value));
        }
        return linkedHashMap;
    }
}
