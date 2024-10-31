package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class zzam implements zzb {
    private final Map<String, Ab> zzbw;
    private long zzbx;
    private final File zzby;
    private final int zzbz;

    public zzam(File file, int i) {
        this.zzbw = new LinkedHashMap(16, 0.75f, true);
        this.zzbx = 0L;
        this.zzby = file;
        this.zzbz = i;
    }

    private final synchronized void remove(String str) {
        boolean delete = zze(str).delete();
        removeEntry(str);
        if (!delete) {
            zzaf.d("Could not delete cache entry for key=%s, filename=%s", str, zzd(str));
        }
    }

    private final void removeEntry(String str) {
        Ab remove = this.zzbw.remove(str);
        if (remove != null) {
            this.zzbx -= remove.f11363a;
        }
    }

    public static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 24) | zza(inputStream) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16);
    }

    public static long zzc(InputStream inputStream) throws IOException {
        return (zza(inputStream) & 255) | 0 | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((255 & zza(inputStream)) << 56);
    }

    private static String zzd(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private final File zze(String str) {
        return new File(this.zzby, zzd(str));
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized zzc zza(String str) {
        Ab ab = this.zzbw.get(str);
        if (ab == null) {
            return null;
        }
        File zze = zze(str);
        try {
            Kb kb = new Kb(new BufferedInputStream(zza(zze)), zze.length());
            try {
                Ab a2 = Ab.a(kb);
                if (!TextUtils.equals(str, a2.f11364b)) {
                    zzaf.d("%s: key=%s, found=%s", zze.getAbsolutePath(), str, a2.f11364b);
                    removeEntry(str);
                    return null;
                }
                byte[] zza = zza(kb, kb.a());
                zzc zzcVar = new zzc();
                zzcVar.data = zza;
                zzcVar.zza = ab.f11365c;
                zzcVar.zzb = ab.f11366d;
                zzcVar.zzc = ab.f11367e;
                zzcVar.zzd = ab.f11368f;
                zzcVar.zze = ab.f11369g;
                List<zzl> list = ab.f11370h;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzl zzlVar : list) {
                    treeMap.put(zzlVar.getName(), zzlVar.getValue());
                }
                zzcVar.zzf = treeMap;
                zzcVar.zzg = Collections.unmodifiableList(ab.f11370h);
                return zzcVar;
            } finally {
                kb.close();
            }
        } catch (IOException e2) {
            zzaf.d("%s: %s", zze.getAbsolutePath(), e2.toString());
            remove(str);
            return null;
        }
    }

    public static List<zzl> zzb(Kb kb) throws IOException {
        int zzb = zzb((InputStream) kb);
        if (zzb >= 0) {
            List<zzl> emptyList = zzb == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < zzb; i++) {
                emptyList.add(new zzl(zza(kb).intern(), zza(kb).intern()));
            }
            return emptyList;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("readHeaderList size=");
        sb.append(zzb);
        throw new IOException(sb.toString());
    }

    public zzam(File file) {
        this(file, 5242880);
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void zza() {
        if (!this.zzby.exists()) {
            if (!this.zzby.mkdirs()) {
                zzaf.e("Unable to create cache dir %s", this.zzby.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.zzby.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                long length = file.length();
                Kb kb = new Kb(new BufferedInputStream(zza(file)), length);
                try {
                    Ab a2 = Ab.a(kb);
                    a2.f11363a = length;
                    zza(a2.f11364b, a2);
                    kb.close();
                } catch (Throwable th) {
                    kb.close();
                    throw th;
                    break;
                }
            } catch (IOException unused) {
                file.delete();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzb
    public final synchronized void zza(String str, zzc zzcVar) {
        long j;
        Iterator<Map.Entry<String, Ab>> it;
        long length = zzcVar.data.length;
        if (this.zzbx + length >= this.zzbz) {
            if (zzaf.DEBUG) {
                zzaf.v("Pruning old cache entries.", new Object[0]);
            }
            long j2 = this.zzbx;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, Ab>> it2 = this.zzbw.entrySet().iterator();
            int i = 0;
            while (true) {
                if (!it2.hasNext()) {
                    j = j2;
                    break;
                }
                Ab value = it2.next().getValue();
                if (zze(value.f11364b).delete()) {
                    j = j2;
                    it = it2;
                    this.zzbx -= value.f11363a;
                } else {
                    j = j2;
                    it = it2;
                    zzaf.d("Could not delete cache entry for key=%s, filename=%s", value.f11364b, zzd(value.f11364b));
                }
                it.remove();
                i++;
                if (((float) (this.zzbx + length)) < this.zzbz * 0.9f) {
                    break;
                }
                j2 = j;
                it2 = it;
            }
            if (zzaf.DEBUG) {
                zzaf.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.zzbx - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
        File zze = zze(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(zze));
            Ab ab = new Ab(str, zzcVar);
            if (ab.a(bufferedOutputStream)) {
                bufferedOutputStream.write(zzcVar.data);
                bufferedOutputStream.close();
                zza(str, ab);
            } else {
                bufferedOutputStream.close();
                zzaf.d("Failed to write header for %s", zze.getAbsolutePath());
                throw new IOException();
            }
        } catch (IOException unused) {
            if (zze.delete()) {
                return;
            }
            zzaf.d("Could not clean up file %s", zze.getAbsolutePath());
        }
    }

    private final void zza(String str, Ab ab) {
        if (!this.zzbw.containsKey(str)) {
            this.zzbx += ab.f11363a;
        } else {
            this.zzbx += ab.f11363a - this.zzbw.get(str).f11363a;
        }
        this.zzbw.put(str, ab);
    }

    private static byte[] zza(Kb kb, long j) throws IOException {
        long a2 = kb.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(kb).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(73);
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(a2);
        throw new IOException(sb.toString());
    }

    private static InputStream zza(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    public static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write(i >>> 24);
    }

    public static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    public static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    public static String zza(Kb kb) throws IOException {
        return new String(zza(kb, zzc(kb)), "UTF-8");
    }
}
