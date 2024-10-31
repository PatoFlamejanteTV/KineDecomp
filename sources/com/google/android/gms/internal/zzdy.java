package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public class zzdy extends zzdv {
    private static final Set<String> zzyk = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzyl = new DecimalFormat("#,###");
    private File zzym;
    private boolean zzyn;

    public zzdy(zziz zzizVar) {
        super(zzizVar);
        File cacheDir = zzizVar.getContext().getCacheDir();
        if (cacheDir == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Context.getCacheDir() returned null");
            return;
        }
        this.zzym = new File(cacheDir, "admobVideoStreams");
        if (!this.zzym.isDirectory() && !this.zzym.mkdirs()) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not create preload cache directory at " + this.zzym.getAbsolutePath());
            this.zzym = null;
        } else {
            if (this.zzym.setReadable(true, false) && this.zzym.setExecutable(true, false)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not set cache file permissions at " + this.zzym.getAbsolutePath());
            this.zzym = null;
        }
    }

    private File zza(File file) {
        return new File(this.zzym, file.getName() + ".done");
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        }
    }

    @Override // com.google.android.gms.internal.zzdv
    public void abort() {
        this.zzyn = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0324, code lost:            r2 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0325, code lost:            r4 = "externalAbort";        r5 = r10;        r3 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0344, code lost:            r10.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x034c, code lost:            if (com.google.android.gms.ads.internal.util.client.zzb.a(3) == false) goto L224;     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x034e, code lost:            com.google.android.gms.ads.internal.util.client.zzb.a("Preloaded " + com.google.android.gms.internal.zzdy.zzyl.format(r5) + " bytes from " + r27);     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0377, code lost:            r11.setReadable(true, false);        zzb(r12);        zza(r27, r11.getAbsolutePath(), r5);        com.google.android.gms.internal.zzdy.zzyk.remove(r13);     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x038f, code lost:            r2 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0323, code lost:            throw new java.io.IOException("abort requested");     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.lang.String] */
    @Override // com.google.android.gms.internal.zzdv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean zzab(java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 966
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdy.zzab(java.lang.String):boolean");
    }

    public int zzdK() {
        int i = 0;
        if (this.zzym != null) {
            for (File file : this.zzym.listFiles()) {
                if (!file.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzdL() {
        boolean z;
        long j;
        File file;
        if (this.zzym == null) {
            return false;
        }
        File file2 = null;
        long j2 = Long.MAX_VALUE;
        File[] listFiles = this.zzym.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                j = file3.lastModified();
                if (j < j2) {
                    file = file3;
                    i++;
                    file2 = file;
                    j2 = j;
                }
            }
            j = j2;
            file = file2;
            i++;
            file2 = file;
            j2 = j;
        }
        if (file2 != null) {
            z = file2.delete();
            File zza = zza(file2);
            if (zza.isFile()) {
                z &= zza.delete();
            }
        } else {
            z = false;
        }
        return z;
    }
}
