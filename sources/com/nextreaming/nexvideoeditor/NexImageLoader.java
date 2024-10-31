package com.nextreaming.nexvideoeditor;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class NexImageLoader {
    private static final String LOG_TAG = "NexImageLoader";
    private static final int MAX_USERSTRINGS = 3;
    private static final int NXT_ALIGNMASK = 15;
    private static final int NXT_ALIGN_CENTER = 1;
    private static final int NXT_ALIGN_LEFT = 0;
    private static final int NXT_ALIGN_RIGHT = 2;
    private static final int NXT_BLUR_INNER = 2;
    private static final int NXT_BLUR_NORMAL = 0;
    private static final int NXT_BLUR_OUTER = 3;
    private static final int NXT_BLUR_SOLID = 1;
    private static final int NXT_LONGTEXT_CROP_END = 0;
    private static final int NXT_LONGTEXT_ELLIPSIZE_END = 4;
    private static final int NXT_LONGTEXT_ELLIPSIZE_MIDDLE = 3;
    private static final int NXT_LONGTEXT_ELLIPSIZE_START = 2;
    private static final int NXT_LONGTEXT_WRAP = 1;
    private static final int NXT_TEXTFLAG_AUTOSIZE = 1024;
    private static final int NXT_TEXTFLAG_BOLD = 1;
    private static final int NXT_TEXTFLAG_CUTOUT = 2048;
    private static final int NXT_TEXTFLAG_FILL = 4;
    private static final int NXT_TEXTFLAG_ITALIC = 2;
    private static final int NXT_TEXTFLAG_LINEAR = 512;
    private static final int NXT_TEXTFLAG_SHADOW = 256;
    private static final int NXT_TEXTFLAG_STRIKE = 32;
    private static final int NXT_TEXTFLAG_STROKE = 8;
    private static final int NXT_TEXTFLAG_STROKEBACK = 4096;
    private static final int NXT_TEXTFLAG_SUBPIXEL = 128;
    private static final int NXT_TEXTFLAG_UNDERLINE = 16;
    private static final int NXT_VALIGNMASK = 240;
    private static final int NXT_VALIGN_BOTTOM = 32;
    private static final int NXT_VALIGN_CENTER = 16;
    private static final int NXT_VALIGN_TOP = 0;
    private static final String TAG_Overlay = "[Overlay]";
    private static final String TAG_PreviewThemeImage = "[PvwThImage]";
    private static final String TAG_Text = "[Text]";
    private static final String TAG_ThemeImage = "[ThemeImage]";
    private static final String TYPEFACE_ASSET = "asset:";
    private static final String TYPEFACE_FILE = "file:";
    private static final String TYPEFACE_SYSTEM = "android:";
    private static final String TYPEFACE_THEME = "theme:";
    private AssetManager m_assetManager;
    private com.nextreaming.nexvideoeditor.a m_effectResourceLoader;
    private int m_jpegMaxHeight;
    private int m_jpegMaxSize;
    private int m_jpegMaxWidth;
    private d m_overlayPathResolver;
    private Resources m_rsrc;
    private static Map<a, WeakReference<Bitmap>> sBitmapCache = new HashMap();
    private static WeakHashMap<Bitmap, c> sLoadedBitmapCache = new WeakHashMap<>();
    private static int sCleanCacheCount = 0;
    private static final Object sBitmapCacheLock = new Object();

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract String a(String str);
    }

    public NexImageLoader(Resources resources, com.nextreaming.nexvideoeditor.a aVar, d dVar, int i, int i2, int i3) {
        if (resources == null) {
            this.m_rsrc = null;
            this.m_assetManager = null;
        } else {
            this.m_rsrc = resources;
            this.m_assetManager = resources.getAssets();
        }
        this.m_effectResourceLoader = aVar;
        this.m_overlayPathResolver = dVar;
        this.m_jpegMaxWidth = i;
        this.m_jpegMaxHeight = i2;
        this.m_jpegMaxSize = i3;
    }

    public void setResources(Resources resources) {
        if (resources == null) {
            this.m_rsrc = null;
            this.m_assetManager = null;
        } else {
            this.m_rsrc = resources;
            this.m_assetManager = resources.getAssets();
        }
    }

    private String pdecode(String str) {
        StringBuilder sb = new StringBuilder(str);
        int i = -1;
        while (true) {
            i = sb.indexOf("%", i + 1);
            if (i == -1 || i + 2 >= sb.length()) {
                break;
            }
            int indexOf = "0123456789ABCDEF".indexOf(str.charAt(i + 1));
            int indexOf2 = "0123456789ABCDEF".indexOf(str.charAt(i + 2));
            if (indexOf != -1 && indexOf2 != -1) {
                sb.setCharAt(i, (char) ((indexOf << 4) | indexOf2));
                sb.delete(i + 1, i + 3);
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:175:0x0ca8, code lost:            r5 = r4;        r4 = r5;     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x086a, code lost:            if (r4 <= r19) goto L213;     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x086c, code lost:            r4 = r19;     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x086e, code lost:            if (r5 <= r14) goto L333;     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0870, code lost:            r5 = r4;        r4 = r14;     */
    /* JADX WARN: Removed duplicated region for block: B:266:0x07c1  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x07fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nextreaming.nexvideoeditor.NexImage openThemeImage(java.lang.String r46) {
        /*
            Method dump skipped, instructions count: 3318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexvideoeditor.NexImageLoader.openThemeImage(java.lang.String):com.nextreaming.nexvideoeditor.NexImage");
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private int f4802a;
        private int b;

        private c(int i, int i2) {
            this.f4802a = i;
            this.b = i2;
        }

        public int a() {
            return this.f4802a;
        }

        public int b() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Bitmap f4801a;
        private int b;
        private int c;

        private b(Bitmap bitmap, int i, int i2) {
            this.b = i;
            this.c = i2;
            this.f4801a = bitmap;
        }

        public Bitmap a() {
            return this.f4801a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }
    }

    public static b loadBitmap(String str, int i, int i2) {
        return loadBitmap(str, i, i2, Integer.MAX_VALUE);
    }

    public static b loadBitmap(InputStream inputStream, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        int i6 = 0;
        Bitmap bitmap = null;
        byte b2 = 0;
        byte b3 = 0;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        inputStream.mark(Integer.MAX_VALUE);
        BitmapFactory.decodeStream(inputStream, null, options);
        try {
            inputStream.reset();
            options.inJustDecodeBounds = false;
            int i7 = options.outWidth;
            int i8 = options.outHeight;
            while (true) {
                i4 = i5;
                if (i4 >= 8) {
                    break;
                }
                if (options.outWidth / i4 <= i || options.outHeight / i4 <= i2) {
                    if (((options.outWidth / i4) * options.outHeight) / i4 <= (i3 > 0 ? i3 : 1500000)) {
                        break;
                    }
                }
                i5 = i4 * 2;
            }
            options.inSampleSize = i4;
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (decodeStream == null) {
                return new b(bitmap, i6, i6);
            }
            return new b(decodeStream, i7, i8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to reset stream", e);
        }
    }

    public static b loadBitmap(String str, int i, int i2, int i3) {
        return loadBitmap(str, i, i2, i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final String f4800a;
        final int b;
        final int c;
        final int d;
        final Bitmap.Config e;

        private a(String str, int i, int i2, int i3, Bitmap.Config config) {
            this.f4800a = str == null ? "" : str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = config;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f4800a.equals(aVar.f4800a);
        }

        public int hashCode() {
            return (this.e == null ? 0 : this.e.hashCode()) + (this.d * 199) + this.f4800a.hashCode() + (this.b * 191) + (this.c * 61);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b loadBitmap(String str, int i, int i2, int i3, Bitmap.Config config) {
        int i4;
        Bitmap bitmap;
        Bitmap bitmap2;
        b bVar;
        ArrayList arrayList;
        Bitmap bitmap3;
        c cVar;
        a aVar = new a(str, i, i2, i3, config);
        synchronized (sBitmapCacheLock) {
            b bVar2 = null;
            WeakReference<Bitmap> weakReference = sBitmapCache.get(aVar);
            if (weakReference != null && (bitmap3 = weakReference.get()) != null && (cVar = sLoadedBitmapCache.get(bitmap3)) != null) {
                bVar2 = new b(bitmap3, cVar.a(), cVar.b());
            }
            sCleanCacheCount++;
            if (sCleanCacheCount > 30) {
                sCleanCacheCount = 0;
                ArrayList arrayList2 = null;
                for (Map.Entry<a, WeakReference<Bitmap>> entry : sBitmapCache.entrySet()) {
                    if (entry.getValue().get() == null) {
                        ArrayList arrayList3 = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList3.add(entry.getKey());
                        arrayList = arrayList3;
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                }
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        sBitmapCache.remove((a) it.next());
                    }
                }
            }
            if (bVar2 != null) {
                return bVar2;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            int i5 = 0;
            if (lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".jpg")) {
                try {
                    i5 = new ExifInterface(str).getAttributeInt("Orientation", 0);
                } catch (IOException e) {
                    i5 = 0;
                }
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = config;
            int i6 = options.outWidth;
            int i7 = options.outHeight;
            int i8 = 1;
            while (true) {
                i4 = i8;
                if (i4 >= 8) {
                    break;
                }
                if (options.outWidth / i4 <= i || options.outHeight / i4 <= i2) {
                    if (((options.outWidth / i4) * options.outHeight) / i4 <= (i3 > 0 ? i3 : 1500000)) {
                        break;
                    }
                }
                i8 = i4 * 2;
            }
            options.inSampleSize = i4;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile == null) {
                return new b(null, 0, 0);
            }
            switch (i5) {
                case 0:
                    bitmap = decodeFile;
                    break;
                case 1:
                    bitmap = decodeFile;
                    break;
                case 2:
                    Canvas canvas = new Canvas(Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888));
                    Matrix matrix = new Matrix();
                    matrix.setScale(-1.0f, 1.0f);
                    matrix.postTranslate(decodeFile.getWidth(), 0.0f);
                    canvas.drawBitmap(decodeFile, matrix, null);
                    bitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmap);
                    Matrix matrix2 = new Matrix();
                    matrix2.setScale(1.0f, -1.0f);
                    matrix2.postTranslate(0.0f, decodeFile.getHeight());
                    canvas2.drawBitmap(decodeFile, matrix2, null);
                    break;
                case 3:
                    bitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(bitmap);
                    Matrix matrix3 = new Matrix();
                    matrix3.setScale(-1.0f, -1.0f);
                    matrix3.postTranslate(decodeFile.getWidth(), decodeFile.getHeight());
                    canvas3.drawBitmap(decodeFile, matrix3, null);
                    break;
                case 4:
                    bitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas22 = new Canvas(bitmap);
                    Matrix matrix22 = new Matrix();
                    matrix22.setScale(1.0f, -1.0f);
                    matrix22.postTranslate(0.0f, decodeFile.getHeight());
                    canvas22.drawBitmap(decodeFile, matrix22, null);
                    break;
                case 5:
                    bitmap = decodeFile;
                    break;
                case 6:
                    bitmap = Bitmap.createBitmap(decodeFile.getHeight(), decodeFile.getWidth(), Bitmap.Config.ARGB_8888);
                    Canvas canvas4 = new Canvas(bitmap);
                    Matrix matrix4 = new Matrix();
                    matrix4.setRotate(90.0f);
                    matrix4.postTranslate(decodeFile.getHeight(), 0.0f);
                    canvas4.drawBitmap(decodeFile, matrix4, null);
                    break;
                case 7:
                    bitmap = decodeFile;
                    break;
                case 8:
                    bitmap = Bitmap.createBitmap(decodeFile.getHeight(), decodeFile.getWidth(), Bitmap.Config.ARGB_8888);
                    Canvas canvas5 = new Canvas(bitmap);
                    Matrix matrix5 = new Matrix();
                    matrix5.setRotate(270.0f);
                    matrix5.postTranslate(0.0f, decodeFile.getWidth());
                    canvas5.drawBitmap(decodeFile, matrix5, null);
                    break;
                default:
                    bitmap = decodeFile;
                    break;
            }
            if (config == null || bitmap.getConfig() == config) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config);
                new Canvas(bitmap2).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                bitmap.recycle();
            }
            switch (i5) {
                case 5:
                case 6:
                case 7:
                case 8:
                    bVar = new b(bitmap2, i7, i6);
                    break;
                default:
                    bVar = new b(bitmap2, i6, i7);
                    break;
            }
            sBitmapCache.put(aVar, new WeakReference<>(bitmap2));
            sLoadedBitmapCache.put(bitmap2, new c(bVar.b(), bVar.c()));
            return bVar;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, int i) {
        if (i != 0 && bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                return bitmap != createBitmap ? createBitmap : bitmap;
            } catch (OutOfMemoryError e) {
                Log.e(LOG_TAG, "rotateImage Error : " + e);
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap rotateAndFlipImage(Bitmap bitmap, int i, boolean z, boolean z2) {
        if ((i != 0 || z || z2) && bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.preRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            matrix.preScale(z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                return bitmap != createBitmap ? createBitmap : bitmap;
            } catch (OutOfMemoryError e) {
                Log.e(LOG_TAG, "rotateImage Error : " + e);
                return bitmap;
            }
        }
        return bitmap;
    }

    public static void calcSampleSize(BitmapFactory.Options options) {
        int i = 1;
        while (i < 8 && ((options.outWidth / i > 1440 && options.outHeight / i > 810) || ((options.outWidth / i) * options.outHeight) / i > 1500000)) {
            i *= 2;
        }
        options.inSampleSize = i;
    }

    public static void calcSampleSize(BitmapFactory.Options options, int i, int i2, int i3) {
        int i4;
        int i5 = 1;
        while (true) {
            i4 = i5;
            if (i4 >= 8) {
                break;
            }
            if (options.outWidth / i4 <= i || options.outHeight / i4 <= i2) {
                if (((options.outWidth / i4) * options.outHeight) / i4 <= (i3 > 0 ? i3 : 1500000)) {
                    break;
                }
            }
            i5 = i4 * 2;
        }
        options.inSampleSize = i4;
    }

    public NexImage openFile(String str) {
        if (str.startsWith("@solid:") && str.endsWith(".jpg")) {
            int parseLong = (int) Long.parseLong(str.substring(7, 15), 16);
            int[] iArr = new int[576];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = parseLong;
            }
            return new NexImage(Bitmap.createBitmap(iArr, 32, 18, Bitmap.Config.ARGB_8888), 32, 18);
        }
        try {
            Bitmap a2 = loadBitmap(str, this.m_jpegMaxWidth, this.m_jpegMaxHeight, this.m_jpegMaxSize).a();
            if (a2 != null) {
                return new NexImage(a2, a2.getWidth() & (-2), a2.getHeight() & (-2));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
