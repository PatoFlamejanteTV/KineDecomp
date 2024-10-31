package c.e.a.a;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.LruCache;
import android.view.View;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: ImageCache.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final Bitmap.CompressFormat f3885a = Bitmap.CompressFormat.JPEG;

    /* renamed from: b */
    private c.e.a.a.b f3886b;

    /* renamed from: c */
    private LruCache<String, Bitmap> f3887c;

    /* renamed from: d */
    private a f3888d;

    /* renamed from: e */
    private final Object f3889e = new Object();

    /* renamed from: f */
    private boolean f3890f = true;

    /* compiled from: ImageCache.java */
    /* loaded from: classes.dex */
    public static class b extends Fragment {

        /* renamed from: a */
        private Object f3899a;

        public void b(Object obj) {
            this.f3899a = obj;
        }

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setRetainInstance(true);
        }

        @Override // android.support.v4.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            com.nexstreaming.kinemaster.usage.analytics.b.a(b.class.getName());
        }

        public Object z() {
            return this.f3899a;
        }
    }

    public d(a aVar) {
        a(aVar);
    }

    private static void a(String str, String str2) {
    }

    private static void b(String str, String str2) {
        Log.e(str, str2);
    }

    @TargetApi(9)
    public static boolean f() {
        return Environment.isExternalStorageRemovable();
    }

    public void c() {
        synchronized (this.f3889e) {
            if (this.f3886b != null) {
                try {
                    if (!this.f3886b.isClosed()) {
                        this.f3886b.close();
                        this.f3886b = null;
                        a("ImageCache", "Disk cache closed");
                    }
                } catch (IOException e2) {
                    b("ImageCache", "close - " + e2);
                }
            }
        }
    }

    public void d() {
        synchronized (this.f3889e) {
            if (this.f3886b != null) {
                try {
                    this.f3886b.flush();
                    a("ImageCache", "Disk cache flushed");
                } catch (IOException e2) {
                    b("ImageCache", "flush - " + e2);
                }
            }
        }
    }

    public void e() {
        synchronized (this.f3889e) {
            if (this.f3886b == null || this.f3886b.isClosed()) {
                File file = this.f3888d.f3893c;
                if (this.f3888d.f3897g && file != null) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    long min = Math.min(a(file), this.f3888d.f3892b);
                    if (min > 0) {
                        try {
                            this.f3886b = c.e.a.a.b.a(file, 1, 1, min);
                            a("ImageCache", "Disk cache initialized");
                        } catch (IOException e2) {
                            this.f3888d.f3893c = null;
                            b("ImageCache", "initDiskCache - " + e2);
                        }
                    }
                }
            }
            this.f3890f = false;
            this.f3889e.notifyAll();
        }
    }

    /* compiled from: ImageCache.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f3891a;

        /* renamed from: c */
        public File f3893c;

        /* renamed from: b */
        public int f3892b = 268435456;

        /* renamed from: d */
        public Bitmap.CompressFormat f3894d = d.f3885a;

        /* renamed from: e */
        public int f3895e = 75;

        /* renamed from: f */
        public boolean f3896f = true;

        /* renamed from: g */
        public boolean f3897g = true;

        /* renamed from: h */
        public boolean f3898h = false;
        public boolean i = false;

        public a(Context context, String str) {
            a(context, d.a(context, str));
        }

        private void a(Context context, File file) {
            a(context, 0.15f);
            this.f3893c = file;
        }

        public void a(Context context, float f2) {
            if (f2 >= 0.05f && f2 <= 0.8f) {
                this.f3891a = Math.round(f2 * a(context) * 1024.0f * 1024.0f);
                return;
            }
            throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
        }

        private static int a(Context context) {
            return ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        }
    }

    public static d a(FragmentManager fragmentManager, a aVar) {
        b a2 = a(fragmentManager);
        d dVar = (d) a2.z();
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(aVar);
        a2.b(dVar2);
        return dVar2;
    }

    public Bitmap b(String str) {
        Bitmap bitmap;
        LruCache<String, Bitmap> lruCache = this.f3887c;
        if (lruCache == null || (bitmap = lruCache.get(str)) == null) {
            return null;
        }
        a("ImageCache", "Memory cache hit");
        return bitmap;
    }

    public void b() {
        LruCache<String, Bitmap> lruCache = this.f3887c;
        if (lruCache != null) {
            lruCache.evictAll();
            a("ImageCache", "Memory cache cleared");
        }
        synchronized (this.f3889e) {
            this.f3890f = true;
            if (this.f3886b != null && !this.f3886b.isClosed()) {
                try {
                    this.f3886b.a();
                    a("ImageCache", "Disk cache cleared");
                } catch (IOException e2) {
                    b("ImageCache", "clearCache - " + e2);
                }
                this.f3886b = null;
                e();
            }
        }
    }

    private void a(a aVar) {
        this.f3888d = aVar;
        if (this.f3888d.f3896f) {
            a("ImageCache", "Memory cache created (size = " + this.f3888d.f3891a + ")");
            this.f3887c = new c(this, this.f3888d.f3891a);
        }
        if (aVar.i) {
            e();
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:            if (r1 != null) goto L101;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:            if (0 == 0) goto L91;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r5, android.graphics.Bitmap r6) {
        /*
            r4 = this;
            if (r5 == 0) goto L96
            if (r6 != 0) goto L6
            goto L96
        L6:
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r0 = r4.f3887c
            if (r0 == 0) goto L15
            java.lang.Object r0 = r0.get(r5)
            if (r0 != 0) goto L15
            android.util.LruCache<java.lang.String, android.graphics.Bitmap> r0 = r4.f3887c
            r0.put(r5, r6)
        L15:
            java.lang.Object r0 = r4.f3889e
            monitor-enter(r0)
            c.e.a.a.b r1 = r4.f3886b     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L91
            java.lang.String r5 = c(r5)     // Catch: java.lang.Throwable -> L93
            r1 = 0
            c.e.a.a.b r2 = r4.f3886b     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            c.e.a.a.b$c r2 = r2.f(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            r3 = 0
            if (r2 != 0) goto L48
            c.e.a.a.b r2 = r4.f3886b     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            c.e.a.a.b$a r5 = r2.e(r5)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            if (r5 == 0) goto L4f
            java.io.OutputStream r1 = r5.a(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            c.e.a.a.d$a r2 = r4.f3888d     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            android.graphics.Bitmap$CompressFormat r2 = r2.f3894d     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            c.e.a.a.d$a r3 = r4.f3888d     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            int r3 = r3.f3895e     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            r6.compress(r2, r3, r1)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            r5.b()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            r1.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            goto L4f
        L48:
            java.io.InputStream r5 = r2.a(r3)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
            r5.close()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57 java.io.IOException -> L71
        L4f:
            if (r1 == 0) goto L91
        L51:
            r1.close()     // Catch: java.io.IOException -> L91 java.lang.Throwable -> L93
            goto L91
        L55:
            r5 = move-exception
            goto L8b
        L57:
            r5 = move-exception
            java.lang.String r6 = "ImageCache"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r2.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = "addBitmapToCache - "
            r2.append(r3)     // Catch: java.lang.Throwable -> L55
            r2.append(r5)     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L55
            b(r6, r5)     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L91
            goto L51
        L71:
            r5 = move-exception
            java.lang.String r6 = "ImageCache"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55
            r2.<init>()     // Catch: java.lang.Throwable -> L55
            java.lang.String r3 = "addBitmapToCache - "
            r2.append(r3)     // Catch: java.lang.Throwable -> L55
            r2.append(r5)     // Catch: java.lang.Throwable -> L55
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L55
            b(r6, r5)     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L91
            goto L51
        L8b:
            if (r1 == 0) goto L90
            r1.close()     // Catch: java.io.IOException -> L90 java.lang.Throwable -> L93
        L90:
            throw r5     // Catch: java.lang.Throwable -> L93
        L91:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            return
        L93:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            throw r5
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.a.d.a(java.lang.String, android.graphics.Bitmap):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:            if (r7 != null) goto L131;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:            if (r7 == null) goto L116;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [c.e.a.a.b] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r7 = c(r7)
            java.lang.Object r0 = r6.f3889e
            monitor-enter(r0)
        L7:
            boolean r1 = r6.f3890f     // Catch: java.lang.Throwable -> L71
            if (r1 == 0) goto L11
            java.lang.Object r1 = r6.f3889e     // Catch: java.lang.InterruptedException -> L7 java.lang.Throwable -> L71
            r1.wait()     // Catch: java.lang.InterruptedException -> L7 java.lang.Throwable -> L71
            goto L7
        L11:
            c.e.a.a.b r1 = r6.f3886b     // Catch: java.lang.Throwable -> L71
            r2 = 0
            if (r1 == 0) goto L6f
            c.e.a.a.b r1 = r6.f3886b     // Catch: java.lang.Throwable -> L42 java.lang.OutOfMemoryError -> L45 java.io.IOException -> L4d
            c.e.a.a.b$c r7 = r1.f(r7)     // Catch: java.lang.Throwable -> L42 java.lang.OutOfMemoryError -> L45 java.io.IOException -> L4d
            if (r7 == 0) goto L3b
            java.lang.String r1 = "ImageCache"
            java.lang.String r3 = "Disk cache hit"
            a(r1, r3)     // Catch: java.lang.Throwable -> L42 java.lang.OutOfMemoryError -> L45 java.io.IOException -> L4d
            r1 = 0
            java.io.InputStream r7 = r7.a(r1)     // Catch: java.lang.Throwable -> L42 java.lang.OutOfMemoryError -> L45 java.io.IOException -> L4d
            if (r7 == 0) goto L3c
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r7)     // Catch: java.lang.OutOfMemoryError -> L37 java.io.IOException -> L39 java.lang.Throwable -> L68
            if (r7 == 0) goto L35
            r7.close()     // Catch: java.io.IOException -> L35 java.lang.Throwable -> L71
        L35:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L71
            return r1
        L37:
            r1 = move-exception
            goto L47
        L39:
            r1 = move-exception
            goto L4f
        L3b:
            r7 = r2
        L3c:
            if (r7 == 0) goto L6f
        L3e:
            r7.close()     // Catch: java.io.IOException -> L6f java.lang.Throwable -> L71
            goto L6f
        L42:
            r1 = move-exception
            r7 = r2
            goto L69
        L45:
            r1 = move-exception
            r7 = r2
        L47:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L6f
            goto L3e
        L4d:
            r1 = move-exception
            r7 = r2
        L4f:
            java.lang.String r3 = "ImageCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68
            r4.<init>()     // Catch: java.lang.Throwable -> L68
            java.lang.String r5 = "getBitmapFromDiskCache - "
            r4.append(r5)     // Catch: java.lang.Throwable -> L68
            r4.append(r1)     // Catch: java.lang.Throwable -> L68
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L68
            b(r3, r1)     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L6f
            goto L3e
        L68:
            r1 = move-exception
        L69:
            if (r7 == 0) goto L6e
            r7.close()     // Catch: java.io.IOException -> L6e java.lang.Throwable -> L71
        L6e:
            throw r1     // Catch: java.lang.Throwable -> L71
        L6f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L71
            return r2
        L71:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L71
            goto L75
        L74:
            throw r7
        L75:
            goto L74
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.a.d.a(java.lang.String):android.graphics.Bitmap");
    }

    public static File a(Context context, String str) {
        File externalCacheDir = ("mounted".equals(Environment.getExternalStorageState()) || !f()) ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getExternalFilesDir(null);
            if (externalCacheDir == null) {
                externalCacheDir = context.getFilesDir();
            }
            if (externalCacheDir != null) {
                externalCacheDir = new File(externalCacheDir, "KMCache");
            }
        }
        if (externalCacheDir != null) {
            return new File(externalCacheDir, str);
        }
        throw new RuntimeException("No cache available");
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
    public static long a(File file) {
        return file.getUsableSpace();
    }

    public static b a(FragmentManager fragmentManager) {
        b bVar = (b) fragmentManager.findFragmentByTag("ImageCache");
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        fragmentManager.beginTransaction().add(bVar2, "ImageCache").commitAllowingStateLoss();
        return bVar2;
    }
}
