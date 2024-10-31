package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.E;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a */
    public static final com.bumptech.glide.load.f<DecodeFormat> f9028a = com.bumptech.glide.load.f.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: b */
    @Deprecated
    public static final com.bumptech.glide.load.f<DownsampleStrategy> f9029b = DownsampleStrategy.f9003h;

    /* renamed from: c */
    public static final com.bumptech.glide.load.f<Boolean> f9030c = com.bumptech.glide.load.f.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);

    /* renamed from: d */
    public static final com.bumptech.glide.load.f<Boolean> f9031d = com.bumptech.glide.load.f.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);

    /* renamed from: e */
    private static final Set<String> f9032e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));

    /* renamed from: f */
    private static final a f9033f = new l();

    /* renamed from: g */
    private static final Set<ImageHeaderParser.ImageType> f9034g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: h */
    private static final Queue<BitmapFactory.Options> f9035h = com.bumptech.glide.g.n.a(0);
    private final com.bumptech.glide.load.engine.a.e i;
    private final DisplayMetrics j;
    private final com.bumptech.glide.load.engine.a.b k;
    private final List<ImageHeaderParser> l;
    private final s m = s.a();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap) throws IOException;
    }

    public m(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.l = list;
        com.bumptech.glide.g.l.a(displayMetrics);
        this.j = displayMetrics;
        com.bumptech.glide.g.l.a(eVar);
        this.i = eVar;
        com.bumptech.glide.g.l.a(bVar);
        this.k = bVar;
    }

    private static int b(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int c(double d2) {
        return (int) (d2 + 0.5d);
    }

    private static void c(BitmapFactory.Options options) {
        d(options);
        synchronized (f9035h) {
            f9035h.offer(options);
        }
    }

    private static void d(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public E<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.g gVar) throws IOException {
        return a(inputStream, i, i2, gVar, f9033f);
    }

    public boolean a(InputStream inputStream) {
        return true;
    }

    public boolean a(ByteBuffer byteBuffer) {
        return true;
    }

    private static int[] b(InputStream inputStream, BitmapFactory.Options options, a aVar, com.bumptech.glide.load.engine.a.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        a(inputStream, options, aVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public E<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.g gVar, a aVar) throws IOException {
        com.bumptech.glide.g.l.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.k.a(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) gVar.a(f9028a);
        try {
            return d.a(a(inputStream, a2, (DownsampleStrategy) gVar.a(DownsampleStrategy.f9003h), decodeFormat, gVar.a(f9031d) != null && ((Boolean) gVar.a(f9031d)).booleanValue(), i, i2, ((Boolean) gVar.a(f9030c)).booleanValue(), aVar), this.i);
        } finally {
            c(a2);
            this.k.put(bArr);
        }
    }

    private static boolean b(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    private Bitmap a(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, a aVar) throws IOException {
        int i3;
        int i4;
        m mVar;
        int round;
        int round2;
        int i5;
        long a2 = com.bumptech.glide.g.h.a();
        int[] b2 = b(inputStream, options, aVar, this.i);
        int i6 = b2[0];
        int i7 = b2[1];
        String str = options.outMimeType;
        boolean z3 = (i6 == -1 || i7 == -1) ? false : z;
        int a3 = com.bumptech.glide.load.b.a(this.l, inputStream, this.k);
        int a4 = w.a(a3);
        boolean b3 = w.b(a3);
        if (i == Integer.MIN_VALUE) {
            i3 = i2;
            i4 = i6;
        } else {
            i3 = i2;
            i4 = i;
        }
        int i8 = i3 == Integer.MIN_VALUE ? i7 : i3;
        ImageHeaderParser.ImageType b4 = com.bumptech.glide.load.b.b(this.l, inputStream, this.k);
        a(b4, inputStream, aVar, this.i, downsampleStrategy, a4, i6, i7, i4, i8, options);
        a(inputStream, decodeFormat, z3, b3, options, i4, i8);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            mVar = this;
            if (mVar.a(b4)) {
                if (i6 < 0 || i7 < 0 || !z2 || !z4) {
                    float f2 = b(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i9 = options.inSampleSize;
                    float f3 = i9;
                    int ceil = (int) Math.ceil(i6 / f3);
                    int ceil2 = (int) Math.ceil(i7 / f3);
                    round = Math.round(ceil * f2);
                    round2 = Math.round(ceil2 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + round + FragmentC2201x.f23219a + round2 + "] for source [" + i6 + FragmentC2201x.f23219a + i7 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    round = i4;
                    round2 = i8;
                }
                if (round > 0 && round2 > 0) {
                    a(options, mVar.i, round, round2);
                }
            }
        } else {
            mVar = this;
        }
        Bitmap a5 = a(inputStream, options, aVar, mVar.i);
        aVar.a(mVar.i, a5);
        if (Log.isLoggable("Downsampler", 2)) {
            i5 = a3;
            a(i6, i7, str, options, a5, i, i2, a2);
        } else {
            i5 = a3;
        }
        Bitmap bitmap = null;
        if (a5 != null) {
            a5.setDensity(mVar.j.densityDpi);
            bitmap = w.a(mVar.i, a5, i5);
            if (!a5.equals(bitmap)) {
                mVar.i.a(a5);
            }
        }
        return bitmap;
    }

    private static void a(ImageHeaderParser.ImageType imageType, InputStream inputStream, a aVar, com.bumptech.glide.load.engine.a.e eVar, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        float b2;
        int min;
        int i6;
        int floor;
        double floor2;
        int i7;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i4 + FragmentC2201x.f23219a + i5 + "]");
                return;
            }
            return;
        }
        if (i != 90 && i != 270) {
            b2 = downsampleStrategy.b(i2, i3, i4, i5);
        } else {
            b2 = downsampleStrategy.b(i3, i2, i4, i5);
        }
        if (b2 > 0.0f) {
            DownsampleStrategy.SampleSizeRounding a2 = downsampleStrategy.a(i2, i3, i4, i5);
            if (a2 != null) {
                float f2 = i2;
                float f3 = i3;
                int c2 = i2 / c(b2 * f2);
                int c3 = i3 / c(b2 * f3);
                if (a2 == DownsampleStrategy.SampleSizeRounding.MEMORY) {
                    min = Math.max(c2, c3);
                } else {
                    min = Math.min(c2, c3);
                }
                if (Build.VERSION.SDK_INT > 23 || !f9032e.contains(options.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    i6 = (a2 != DownsampleStrategy.SampleSizeRounding.MEMORY || ((float) max) >= 1.0f / b2) ? max : max << 1;
                } else {
                    i6 = 1;
                }
                options.inSampleSize = i6;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(i6, 8);
                    floor = (int) Math.ceil(f2 / min2);
                    i7 = (int) Math.ceil(f3 / min2);
                    int i8 = i6 / 8;
                    if (i8 > 0) {
                        floor /= i8;
                        i7 /= i8;
                    }
                } else {
                    if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType != ImageHeaderParser.ImageType.WEBP && imageType != ImageHeaderParser.ImageType.WEBP_A) {
                            if (i2 % i6 == 0 && i3 % i6 == 0) {
                                floor = i2 / i6;
                                i7 = i3 / i6;
                            } else {
                                int[] b3 = b(inputStream, options, aVar, eVar);
                                int i9 = b3[0];
                                i7 = b3[1];
                                floor = i9;
                            }
                        } else if (Build.VERSION.SDK_INT >= 24) {
                            float f4 = i6;
                            floor = Math.round(f2 / f4);
                            i7 = Math.round(f3 / f4);
                        } else {
                            float f5 = i6;
                            floor = (int) Math.floor(f2 / f5);
                            floor2 = Math.floor(f3 / f5);
                        }
                    } else {
                        float f6 = i6;
                        floor = (int) Math.floor(f2 / f6);
                        floor2 = Math.floor(f3 / f6);
                    }
                    i7 = (int) floor2;
                }
                double b4 = downsampleStrategy.b(floor, i7, i4, i5);
                if (Build.VERSION.SDK_INT >= 19) {
                    options.inTargetDensity = a(b4);
                    options.inDensity = b(b4);
                }
                if (b(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculate scaling, source: [" + i2 + FragmentC2201x.f23219a + i3 + "], target: [" + i4 + FragmentC2201x.f23219a + i5 + "], power of two scaled: [" + floor + FragmentC2201x.f23219a + i7 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + i6 + ", adjusted scale factor: " + b4 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + downsampleStrategy + ", source: [" + i2 + FragmentC2201x.f23219a + i3 + "], target: [" + i4 + FragmentC2201x.f23219a + i5 + "]");
    }

    private static int a(double d2) {
        int b2 = b(d2);
        double d3 = b2;
        Double.isNaN(d3);
        int c2 = c(d3 * d2);
        double d4 = c2 / b2;
        Double.isNaN(d4);
        double d5 = c2;
        Double.isNaN(d5);
        return c((d2 / d4) * d5);
    }

    private boolean a(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f9034g.contains(imageType);
    }

    private void a(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.m.a(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat != DecodeFormat.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean z3 = false;
            try {
                z3 = com.bumptech.glide.load.b.b(this.l, inputStream, this.k).hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
                }
            }
            options.inPreferredConfig = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            if (options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:            throw r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.bumptech.glide.load.resource.bitmap.m.a r8, com.bumptech.glide.load.engine.a.e r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.a()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = com.bumptech.glide.load.resource.bitmap.w.a()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.IllegalArgumentException -> L32
            java.util.concurrent.locks.Lock r9 = com.bumptech.glide.load.resource.bitmap.w.a()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r5 = move-exception
            java.io.IOException r1 = a(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L30
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L43
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L30
        L43:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5e
            r6.reset()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r9.a(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r6 = a(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.w.a()
            r7.unlock()
            return r6
        L5d:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5e:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5f:
            java.util.concurrent.locks.Lock r7 = com.bumptech.glide.load.resource.bitmap.w.a()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.m.a(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.m$a, com.bumptech.glide.load.engine.a.e):android.graphics.Bitmap");
    }

    private static void a(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + a(bitmap) + " from [" + i + FragmentC2201x.f23219a + i2 + "] " + str + " with inBitmap " + a(options) + " for [" + i3 + FragmentC2201x.f23219a + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.g.h.a(j));
    }

    private static String a(BitmapFactory.Options options) {
        return a(options.inBitmap);
    }

    @TargetApi(19)
    private static String a(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + FragmentC2201x.f23219a + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + a(options), illegalArgumentException);
    }

    @TargetApi(26)
    private static void a(BitmapFactory.Options options, com.bumptech.glide.load.engine.a.e eVar, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.b(i, i2, config);
    }

    private static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (m.class) {
            synchronized (f9035h) {
                poll = f9035h.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                d(poll);
            }
        }
        return poll;
    }
}
