package com.google.android.gms.internal.ads;

import android.os.Environment;
import com.google.android.gms.internal.ads.zzuo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzark
/* loaded from: classes2.dex */
public final class zzum {
    private final zzur zzcan;
    private final zzvp zzcao;
    private final boolean zzcap;

    public zzum(zzur zzurVar) {
        this.zzcan = zzurVar;
        this.zzcap = ((Boolean) zzwu.zzpz().zzd(zzaan.zzcwp)).booleanValue();
        this.zzcao = new zzvp();
        zzoj();
    }

    private final synchronized void zzb(zzuo.zza.zzb zzbVar) {
        this.zzcao.zzcht = zzok();
        this.zzcan.zzg(zzbuz.zzb(this.zzcao)).zzbz(zzbVar.zzom()).zzbd();
        String valueOf = String.valueOf(Integer.toString(zzbVar.zzom(), 10));
        zzaxz.v(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzuo.zza.zzb zzbVar) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
            try {
                try {
                    fileOutputStream.write(zzd(zzbVar).getBytes());
                    fileOutputStream.write(10);
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzaxz.v("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzaxz.v("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzaxz.v("Could not close Clearcut output stream.");
                    }
                }
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused4) {
                    zzaxz.v("Could not close Clearcut output stream.");
                }
                throw th;
            }
        } catch (FileNotFoundException unused5) {
            zzaxz.v("Could not find file for Clearcut");
        }
    }

    private final synchronized String zzd(zzuo.zza.zzb zzbVar) {
        return String.format("id=%s,timestamp=%s,event=%s", this.zzcao.zzchp, Long.valueOf(com.google.android.gms.ads.internal.zzbv.l().c()), Integer.valueOf(zzbVar.zzom()));
    }

    public static zzum zzoi() {
        return new zzum();
    }

    private final synchronized void zzoj() {
        this.zzcao.zzchx = new zzvl();
        this.zzcao.zzchx.zzcgp = new zzvm();
        this.zzcao.zzchu = new zzvn();
    }

    private static long[] zzok() {
        int i;
        List<String> zzqx = zzaan.zzqx();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = zzqx.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = it.next().split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException unused) {
                    zzaxz.v("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }

    public final synchronized void zza(zzuo.zza.zzb zzbVar) {
        if (this.zzcap) {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwq)).booleanValue()) {
                zzc(zzbVar);
            } else {
                zzb(zzbVar);
            }
        }
    }

    private zzum() {
        this.zzcap = false;
        this.zzcan = new zzur();
        this.zzcao = new zzvp();
        zzoj();
    }

    public final synchronized void zza(zzun zzunVar) {
        if (this.zzcap) {
            try {
                zzunVar.zza(this.zzcao);
            } catch (NullPointerException e2) {
                com.google.android.gms.ads.internal.zzbv.i().zza(e2, "AdMobClearcutLogger.modify");
            }
        }
    }
}
