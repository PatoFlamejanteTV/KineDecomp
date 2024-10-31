package com.google.android.gms.internal.config;

import android.content.Context;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzam implements Runnable {
    private final Context mContext;
    private final zzaq zzak;
    private final zzan zzas;
    private final zzan zzat;
    private final zzan zzau;

    public zzam(Context context, zzan zzanVar, zzan zzanVar2, zzan zzanVar3, zzaq zzaqVar) {
        this.mContext = context;
        this.zzas = zzanVar;
        this.zzat = zzanVar2;
        this.zzau = zzanVar3;
        this.zzak = zzaqVar;
    }

    private static zzar zza(zzan zzanVar) {
        zzar zzarVar = new zzar();
        if (zzanVar.zzq() != null) {
            Map<String, Map<String, byte[]>> zzq = zzanVar.zzq();
            ArrayList arrayList = new ArrayList();
            if (zzq != null) {
                for (String str : zzq.keySet()) {
                    ArrayList arrayList2 = new ArrayList();
                    Map<String, byte[]> map = zzq.get(str);
                    if (map != null) {
                        for (String str2 : map.keySet()) {
                            zzas zzasVar = new zzas();
                            zzasVar.zzbh = str2;
                            zzasVar.zzbi = map.get(str2);
                            arrayList2.add(zzasVar);
                        }
                    }
                    zzau zzauVar = new zzau();
                    zzauVar.zzbn = str;
                    zzauVar.zzbo = (zzas[]) arrayList2.toArray(new zzas[arrayList2.size()]);
                    arrayList.add(zzauVar);
                }
            }
            zzarVar.zzbe = (zzau[]) arrayList.toArray(new zzau[arrayList.size()]);
        }
        if (zzanVar.zzh() != null) {
            List<byte[]> zzh = zzanVar.zzh();
            zzarVar.zzbf = (byte[][]) zzh.toArray(new byte[zzh.size()]);
        }
        zzarVar.timestamp = zzanVar.getTimestamp();
        return zzarVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzav zzavVar = new zzav();
        zzan zzanVar = this.zzas;
        if (zzanVar != null) {
            zzavVar.zzbp = zza(zzanVar);
        }
        zzan zzanVar2 = this.zzat;
        if (zzanVar2 != null) {
            zzavVar.zzbq = zza(zzanVar2);
        }
        zzan zzanVar3 = this.zzau;
        if (zzanVar3 != null) {
            zzavVar.zzbr = zza(zzanVar3);
        }
        if (this.zzak != null) {
            zzat zzatVar = new zzat();
            zzatVar.zzbj = this.zzak.getLastFetchStatus();
            zzatVar.zzbk = this.zzak.isDeveloperModeEnabled();
            zzavVar.zzbs = zzatVar;
        }
        zzaq zzaqVar = this.zzak;
        if (zzaqVar != null && zzaqVar.zzs() != null) {
            ArrayList arrayList = new ArrayList();
            Map<String, zzal> zzs = this.zzak.zzs();
            for (String str : zzs.keySet()) {
                if (zzs.get(str) != null) {
                    zzaw zzawVar = new zzaw();
                    zzawVar.zzbn = str;
                    zzawVar.zzbv = zzs.get(str).zzp();
                    zzawVar.resourceId = zzs.get(str).getResourceId();
                    arrayList.add(zzawVar);
                }
            }
            zzavVar.zzbt = (zzaw[]) arrayList.toArray(new zzaw[arrayList.size()]);
        }
        byte[] bArr = new byte[zzavVar.zzai()];
        try {
            zzaz zzb = zzaz.zzb(bArr, 0, bArr.length);
            zzavVar.zza(zzb);
            zzb.zzad();
            try {
                FileOutputStream openFileOutput = this.mContext.openFileOutput("persisted_config", 0);
                openFileOutput.write(bArr);
                openFileOutput.close();
            } catch (IOException e2) {
                Log.e("AsyncPersisterTask", "Could not persist config.", e2);
            }
        } catch (IOException e3) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e3);
        }
    }
}
