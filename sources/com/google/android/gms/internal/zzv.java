package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class zzv implements zzb {
    private final int zzaA;
    private final Map<String, a> zzax;
    private long zzay;
    private final File zzaz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f1834a;
        public String b;
        public String c;
        public long d;
        public long e;
        public long f;
        public long g;
        public Map<String, String> h;

        private a() {
        }

        public a(String str, zzb.zza zzaVar) {
            this.b = str;
            this.f1834a = zzaVar.data.length;
            this.c = zzaVar.zzb;
            this.d = zzaVar.zzc;
            this.e = zzaVar.zzd;
            this.f = zzaVar.zze;
            this.g = zzaVar.zzf;
            this.h = zzaVar.zzg;
        }

        public static a a(InputStream inputStream) throws IOException {
            a aVar = new a();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            aVar.b = zzv.zzd(inputStream);
            aVar.c = zzv.zzd(inputStream);
            if (aVar.c.equals("")) {
                aVar.c = null;
            }
            aVar.d = zzv.zzc(inputStream);
            aVar.e = zzv.zzc(inputStream);
            aVar.f = zzv.zzc(inputStream);
            aVar.g = zzv.zzc(inputStream);
            aVar.h = zzv.zze(inputStream);
            return aVar;
        }

        public zzb.zza a(byte[] bArr) {
            zzb.zza zzaVar = new zzb.zza();
            zzaVar.data = bArr;
            zzaVar.zzb = this.c;
            zzaVar.zzc = this.d;
            zzaVar.zzd = this.e;
            zzaVar.zze = this.f;
            zzaVar.zzf = this.g;
            zzaVar.zzg = this.h;
            return zzaVar;
        }

        public boolean a(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.b);
                zzv.zza(outputStream, this.c == null ? "" : this.c);
                zzv.zza(outputStream, this.d);
                zzv.zza(outputStream, this.e);
                zzv.zza(outputStream, this.f);
                zzv.zza(outputStream, this.g);
                zzv.zza(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class b extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private int f1835a;

        private b(InputStream inputStream) {
            super(inputStream);
            this.f1835a = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f1835a++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.f1835a += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzax = new LinkedHashMap(16, 0.75f, true);
        this.zzay = 0L;
        this.zzaz = file;
        this.zzaA = i;
    }

    private void removeEntry(String str) {
        a aVar = this.zzax.get(str);
        if (aVar != null) {
            this.zzay -= aVar.f1834a;
            this.zzax.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Keyczar.DEFAULT_ENCODING);
        zza(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, a aVar) {
        if (this.zzax.containsKey(str)) {
            this.zzay = (aVar.f1834a - this.zzax.get(str).f1834a) + this.zzay;
        } else {
            this.zzay += aVar.f1834a;
        }
        this.zzax.put(str, aVar);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map == null) {
            zza(outputStream, 0);
            return;
        }
        zza(outputStream, map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zza(outputStream, entry.getKey());
            zza(outputStream, entry.getValue());
        }
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 != i) {
            throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
        }
        return bArr;
    }

    static int zzb(InputStream inputStream) throws IOException {
        return 0 | (zza(inputStream) << 0) | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | ((zza(inputStream) & 255) << 0) | ((zza(inputStream) & 255) << 8) | ((zza(inputStream) & 255) << 16) | ((zza(inputStream) & 255) << 24) | ((zza(inputStream) & 255) << 32) | ((zza(inputStream) & 255) << 40) | ((zza(inputStream) & 255) << 48) | ((zza(inputStream) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzay + i < this.zzaA) {
            return;
        }
        if (zzs.DEBUG) {
            zzs.zza("Pruning old cache entries.", new Object[0]);
        }
        long j = this.zzay;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.zzax.entrySet().iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = i3;
                break;
            }
            a value = it.next().getValue();
            if (zzf(value.b).delete()) {
                this.zzay -= value.f1834a;
            } else {
                zzs.zzb("Could not delete cache entry for key=%s, filename=%s", value.b, zze(value.b));
            }
            it.remove();
            i2 = i3 + 1;
            if (((float) (this.zzay + i)) < this.zzaA * 0.9f) {
                break;
            } else {
                i3 = i2;
            }
        }
        if (zzs.DEBUG) {
            zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzay - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), Keyczar.DEFAULT_ENCODING);
    }

    private String zze(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb = zzb(inputStream);
        Map<String, String> emptyMap = zzb == 0 ? Collections.emptyMap() : new HashMap<>(zzb);
        for (int i = 0; i < zzb; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized zzb.zza zza(String str) {
        b bVar;
        zzb.zza zzaVar;
        a aVar = this.zzax.get(str);
        if (aVar == null) {
            zzaVar = null;
        } else {
            try {
                File zzf = zzf(str);
                try {
                    bVar = new b(new FileInputStream(zzf));
                } catch (IOException e) {
                    e = e;
                    bVar = null;
                } catch (Throwable th) {
                    th = th;
                    bVar = null;
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e2) {
                            zzaVar = null;
                        }
                    }
                    throw th;
                }
                try {
                    a.a(bVar);
                    zzaVar = aVar.a(zza(bVar, (int) (zzf.length() - bVar.f1835a)));
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e3) {
                            zzaVar = null;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    zzs.zzb("%s: %s", zzf.getAbsolutePath(), e.toString());
                    remove(str);
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (IOException e5) {
                            zzaVar = null;
                        }
                    }
                    zzaVar = null;
                    return zzaVar;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza() {
        BufferedInputStream bufferedInputStream;
        if (this.zzaz.exists()) {
            File[] listFiles = this.zzaz.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    BufferedInputStream bufferedInputStream2 = null;
                    try {
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    } catch (IOException e) {
                        bufferedInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        try {
                            a a2 = a.a(bufferedInputStream);
                            a2.f1834a = file.length();
                            zza(a2.b, a2);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                        } catch (Throwable th2) {
                            bufferedInputStream2 = bufferedInputStream;
                            th = th2;
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException e3) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e4) {
                        if (file != null) {
                            file.delete();
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            }
        } else if (!this.zzaz.mkdirs()) {
            zzs.zzc("Unable to create cache dir %s", this.zzaz.getAbsolutePath());
        }
    }

    @Override // com.google.android.gms.internal.zzb
    public synchronized void zza(String str, zzb.zza zzaVar) {
        FileOutputStream fileOutputStream;
        a aVar;
        zzc(zzaVar.data.length);
        File zzf = zzf(str);
        try {
            fileOutputStream = new FileOutputStream(zzf);
            aVar = new a(str, zzaVar);
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
        if (!aVar.a(fileOutputStream)) {
            fileOutputStream.close();
            zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
            throw new IOException();
        }
        fileOutputStream.write(zzaVar.data);
        fileOutputStream.close();
        zza(str, aVar);
    }

    public File zzf(String str) {
        return new File(this.zzaz, zze(str));
    }
}
