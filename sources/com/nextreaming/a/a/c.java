package com.nextreaming.a.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.LruCache;
import com.nextreaming.a.a.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ImageCache.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Bitmap.CompressFormat f4452a = Bitmap.CompressFormat.JPEG;
    private com.nextreaming.a.a.a b;
    private LruCache<String, Bitmap> c;
    private a d;
    private final Object e = new Object();
    private boolean f = true;

    private static void a(String str, String str2) {
    }

    private static void b(String str, String str2) {
        Log.e(str, str2);
    }

    public c(a aVar) {
        a(aVar);
    }

    public static c a(FragmentManager fragmentManager, a aVar) {
        b a2 = a(fragmentManager);
        c cVar = (c) a2.a();
        if (cVar == null) {
            c cVar2 = new c(aVar);
            a2.a(cVar2);
            return cVar2;
        }
        return cVar;
    }

    private void a(a aVar) {
        this.d = aVar;
        if (this.d.f) {
            a("ImageCache", "Memory cache created (size = " + this.d.f4453a + ")");
            this.c = new d(this, this.d.f4453a);
        }
        if (aVar.i) {
            a();
        }
    }

    public void a() {
        synchronized (this.e) {
            if (this.b == null || this.b.a()) {
                File file = this.d.c;
                if (this.d.g && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    long min = Math.min(a(file), this.d.b);
                    if (min > 0) {
                        try {
                            this.b = com.nextreaming.a.a.a.a(file, 1, 1, min);
                            a("ImageCache", "Disk cache initialized");
                        } catch (IOException e) {
                            this.d.c = null;
                            b("ImageCache", "initDiskCache - " + e);
                        }
                    }
                }
            }
            this.f = false;
            this.e.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.nextreaming.a.a.a] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.nextreaming.a.a.a] */
    public void a(String str, Bitmap bitmap) {
        Throwable th;
        Exception exc;
        IOException iOException;
        if (str == null || bitmap == null) {
            return;
        }
        if (this.c != null && this.c.get(str) == null) {
            this.c.put(str, bitmap);
        }
        synchronized (this.e) {
            if (this.b != null) {
                ?? c = c(str);
                OutputStream outputStream = null;
                try {
                    try {
                        a.c a2 = this.b.a(c);
                        if (a2 == null) {
                            a.C0080a b2 = this.b.b(c);
                            if (b2 != null) {
                                outputStream = b2.a(0);
                                try {
                                    bitmap.compress(this.d.d, this.d.e, outputStream);
                                    b2.a();
                                    outputStream.close();
                                } catch (IOException e) {
                                    c = outputStream;
                                    iOException = e;
                                    b("ImageCache", "addBitmapToCache - " + iOException);
                                    if (c != 0) {
                                        try {
                                            c.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                } catch (Exception e3) {
                                    c = outputStream;
                                    exc = e3;
                                    b("ImageCache", "addBitmapToCache - " + exc);
                                    if (c != 0) {
                                        try {
                                            c.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    c = outputStream;
                                    th = th2;
                                    if (c != 0) {
                                        try {
                                            c.close();
                                        } catch (IOException e5) {
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } else {
                            a2.a(0).close();
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e6) {
                            }
                        }
                    } catch (IOException e7) {
                        c = 0;
                        iOException = e7;
                    } catch (Exception e8) {
                        c = 0;
                        exc = e8;
                    } catch (Throwable th3) {
                        c = 0;
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
    }

    public Bitmap a(String str) {
        Bitmap bitmap;
        if (this.c == null || (bitmap = this.c.get(str)) == null) {
            return null;
        }
        a("ImageCache", "Memory cache hit");
        return bitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.nextreaming.a.a.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public Bitmap b(String str) {
        InputStream inputStream;
        Bitmap bitmap = null;
        String c = c(str);
        synchronized (this.e) {
            while (this.f) {
                try {
                    this.e.wait();
                } catch (InterruptedException e) {
                }
            }
            ?? r2 = this.b;
            try {
                if (r2 != 0) {
                    try {
                        a.c a2 = this.b.a(c);
                        if (a2 != null) {
                            a("ImageCache", "Disk cache hit");
                            inputStream = a2.a(0);
                            if (inputStream != null) {
                                try {
                                    bitmap = BitmapFactory.decodeStream(inputStream);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    b("ImageCache", "getBitmapFromDiskCache - " + e);
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    return bitmap;
                                } catch (OutOfMemoryError e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    return bitmap;
                                }
                            }
                        } else {
                            inputStream = null;
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                    } catch (IOException e8) {
                        e = e8;
                        inputStream = null;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        inputStream = null;
                    } catch (Throwable th) {
                        r2 = 0;
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e10) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return bitmap;
    }

    public void b() {
        if (this.c != null) {
            this.c.evictAll();
            a("ImageCache", "Memory cache cleared");
        }
        synchronized (this.e) {
            this.f = true;
            if (this.b != null && !this.b.a()) {
                try {
                    this.b.c();
                    a("ImageCache", "Disk cache cleared");
                } catch (IOException e) {
                    b("ImageCache", "clearCache - " + e);
                }
                this.b = null;
                a();
            }
        }
    }

    public void c() {
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    this.b.b();
                    a("ImageCache", "Disk cache flushed");
                } catch (IOException e) {
                    b("ImageCache", "flush - " + e);
                }
            }
        }
    }

    public void d() {
        synchronized (this.e) {
            if (this.b != null) {
                try {
                    if (!this.b.a()) {
                        this.b.close();
                        this.b = null;
                        a("ImageCache", "Disk cache closed");
                    }
                } catch (IOException e) {
                    b("ImageCache", "close - " + e);
                }
            }
        }
    }

    /* compiled from: ImageCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f4453a;
        public File c;
        public int b = 268435456;
        public Bitmap.CompressFormat d = c.f4452a;
        public int e = 75;
        public boolean f = true;
        public boolean g = true;
        public boolean h = false;
        public boolean i = false;

        public a(Context context, String str) {
            a(context, c.a(context, str));
        }

        public a(Context context, File file) {
            a(context, file);
        }

        private void a(Context context, File file) {
            a(context, 0.15f);
            this.c = file;
        }

        public void a(Context context, float f) {
            if (f < 0.05f || f > 0.8f) {
                throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
            }
            this.f4453a = Math.round(a(context) * f * 1024.0f * 1024.0f);
        }

        private static int a(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }
    }

    public static File a(Context context, String str) {
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !e()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir == null) {
                externalFilesDir = context.getFilesDir();
            }
            externalCacheDir = externalFilesDir != null ? new File(externalFilesDir, "KMCache") : externalFilesDir;
        }
        if (externalCacheDir == null) {
            throw new RuntimeException("No cache available");
        }
        return new File(externalCacheDir, str);
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            return String.valueOf(str.hashCode());
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    @TargetApi(12)
    public static int a(Bitmap bitmap) {
        return bitmap.getByteCount();
    }

    @TargetApi(9)
    public static boolean e() {
        return Environment.isExternalStorageRemovable();
    }

    @TargetApi(9)
    public static long a(File file) {
        return file.getUsableSpace();
    }

    public static b a(FragmentManager fragmentManager) {
        b bVar = (b) fragmentManager.findFragmentByTag("ImageCache");
        if (bVar == null) {
            b bVar2 = new b();
            fragmentManager.beginTransaction().add(bVar2, "ImageCache").commitAllowingStateLoss();
            return bVar2;
        }
        return bVar;
    }

    /* compiled from: ImageCache.java */
    /* loaded from: classes.dex */
    public static class b extends Fragment {

        /* renamed from: a, reason: collision with root package name */
        private Object f4454a;

        @Override // android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        public void a(Object obj) {
            this.f4454a = obj;
        }

        public Object a() {
            return this.f4454a;
        }
    }
}
