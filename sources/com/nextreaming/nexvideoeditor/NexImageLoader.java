package com.nextreaming.nexvideoeditor;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
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
    private InterfaceC2350a m_effectResourceLoader;
    private int m_jpegMaxHeight;
    private int m_jpegMaxSize;
    private int m_jpegMaxWidth;
    private d m_overlayPathResolver;
    private Resources m_rsrc;
    private static Map<a, WeakReference<Bitmap>> sBitmapCache = new HashMap();
    private static WeakHashMap<Bitmap, c> sLoadedBitmapCache = new WeakHashMap<>();
    private static int sCleanCacheCount = 0;
    private static final Object sBitmapCacheLock = new Object();

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a */
        final String f24618a;

        /* renamed from: b */
        final int f24619b;

        /* renamed from: c */
        final int f24620c;

        /* renamed from: d */
        final int f24621d;

        /* renamed from: e */
        final Bitmap.Config f24622e;

        /* synthetic */ a(String str, int i, int i2, int i3, Bitmap.Config config, ia iaVar) {
            this(str, i, i2, i3, config);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return this.f24619b == aVar.f24619b && this.f24620c == aVar.f24620c && this.f24621d == aVar.f24621d && this.f24622e == aVar.f24622e && this.f24618a.equals(aVar.f24618a);
        }

        public int hashCode() {
            int hashCode = this.f24618a.hashCode() + (this.f24619b * 191) + (this.f24620c * 61) + (this.f24621d * 199);
            Bitmap.Config config = this.f24622e;
            return hashCode + (config == null ? 0 : config.hashCode());
        }

        private a(String str, int i, int i2, int i3, Bitmap.Config config) {
            this.f24618a = str == null ? "" : str;
            this.f24619b = i;
            this.f24620c = i2;
            this.f24621d = i3;
            this.f24622e = config;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a */
        private Bitmap f24623a;

        /* renamed from: b */
        private int f24624b;

        /* renamed from: c */
        private int f24625c;

        /* synthetic */ b(Bitmap bitmap, int i, int i2, ia iaVar) {
            this(bitmap, i, i2);
        }

        public Bitmap a() {
            return this.f24623a;
        }

        public int b() {
            return this.f24625c;
        }

        public int c() {
            return this.f24624b;
        }

        private b(Bitmap bitmap, int i, int i2) {
            this.f24624b = i;
            this.f24625c = i2;
            this.f24623a = bitmap;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a */
        private int f24626a;

        /* renamed from: b */
        private int f24627b;

        /* synthetic */ c(int i, int i2, ia iaVar) {
            this(i, i2);
        }

        public int a() {
            return this.f24627b;
        }

        public int b() {
            return this.f24626a;
        }

        private c(int i, int i2) {
            this.f24626a = i;
            this.f24627b = i2;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract String a(String str);
    }

    public NexImageLoader(Resources resources, InterfaceC2350a interfaceC2350a, d dVar, int i, int i2, int i3) {
        if (resources == null) {
            this.m_rsrc = null;
            this.m_assetManager = null;
        } else {
            this.m_rsrc = resources;
            this.m_assetManager = resources.getAssets();
        }
        this.m_effectResourceLoader = interfaceC2350a;
        this.m_overlayPathResolver = dVar;
        this.m_jpegMaxWidth = i;
        this.m_jpegMaxHeight = i2;
        this.m_jpegMaxSize = i3;
    }

    public static void calcSampleSize(BitmapFactory.Options options) {
        int i = 1;
        while (i < 8 && ((options.outWidth / i > 1440 && options.outHeight / i > 810) || ((options.outWidth / i) * options.outHeight) / i > 1500000)) {
            i *= 2;
        }
        options.inSampleSize = i;
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static b loadBitmap(String str, int i, int i2) {
        return loadBitmap(str, i, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private String pdecode(String str) {
        int i;
        StringBuilder sb = new StringBuilder(str);
        String str2 = str;
        int i2 = -1;
        while (true) {
            i2 = sb.indexOf("%", i2 + 1);
            if (i2 == -1 || (i = i2 + 2) >= sb.length()) {
                break;
            }
            int i3 = i2 + 1;
            int indexOf = "0123456789ABCDEF".indexOf(str2.charAt(i3));
            int indexOf2 = "0123456789ABCDEF".indexOf(str2.charAt(i));
            if (indexOf != -1 && indexOf2 != -1) {
                sb.setCharAt(i2, (char) ((indexOf << 4) | indexOf2));
                sb.delete(i3, i2 + 3);
                str2 = sb.toString();
            }
        }
        return sb.toString();
    }

    private static String relativePath(String str, String str2) {
        if (!str2.startsWith("..") && !str2.contains("/..")) {
            if (str.endsWith("/")) {
                return str + str2;
            }
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf < 0) {
                return str2;
            }
            return str.substring(0, lastIndexOf + 1) + str2;
        }
        throw new SecurityException("Parent Path References Not Allowed");
    }

    public static Bitmap rotateAndFlipImage(Bitmap bitmap, int i, boolean z, boolean z2) {
        if ((i == 0 && !z && !z2) || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.preRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        matrix.preScale(z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError e2) {
            Log.e(LOG_TAG, "rotateImage Error : " + e2);
            return bitmap;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            return bitmap != createBitmap ? createBitmap : bitmap;
        } catch (OutOfMemoryError e2) {
            Log.e(LOG_TAG, "rotateImage Error : " + e2);
            return bitmap;
        }
    }

    public byte[] callbackReadAssetItemFile(String str, String str2) {
        String filePath;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(str);
        if (a2 == null) {
            return null;
        }
        try {
            AssetPackageReader a3 = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), a2.getPackageURI(), a2.getAssetPackage().getAssetId());
            if (str2 != null && str2.length() >= 1) {
                filePath = relativePath(a2.getFilePath(), str2);
            } else {
                filePath = a2.getFilePath();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream g2 = a3.g(filePath);
            try {
                copy(g2, byteArrayOutputStream);
                g2.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                g2.close();
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public NexImage openFile(String str, int i) {
        if (str.startsWith("@solid:") && str.endsWith(".jpg")) {
            int parseLong = (int) Long.parseLong(str.substring(7, 15), 16);
            int[] iArr = new int[576];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr[i2] = parseLong;
            }
            return new NexImage(Bitmap.createBitmap(iArr, 32, 18, Bitmap.Config.ARGB_8888), 32, 18);
        }
        try {
            Bitmap a2 = loadBitmap(str, this.m_jpegMaxWidth, this.m_jpegMaxHeight, this.m_jpegMaxSize).a();
            if (a2 != null) {
                return new NexImage(a2, a2.getWidth() & (-2), a2.getHeight() & (-2));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public byte[] openThemeFile(String str) {
        String str2;
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            str = str.substring(indexOf + 1);
        } else {
            str2 = "";
        }
        InterfaceC2350a interfaceC2350a = this.m_effectResourceLoader;
        if (interfaceC2350a == null) {
            return null;
        }
        try {
            interfaceC2350a.a(str2, str);
            throw null;
        } catch (IOException e2) {
            Log.e(LOG_TAG, "Error loading bitmap for effect(" + str2 + ") : " + str);
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:200:0x062a, code lost:            r8 = r10;     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x05d6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0668 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x069a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x06c9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x071a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x073e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0762  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x070a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0694  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05dd  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x056f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x090b  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0919  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x0a27  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0a35  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0ad9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x056a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x057b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0582  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x05b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nextreaming.nexvideoeditor.NexImage openThemeImage(java.lang.String r47) {
        /*
            Method dump skipped, instructions count: 2811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexvideoeditor.NexImageLoader.openThemeImage(java.lang.String):com.nextreaming.nexvideoeditor.NexImage");
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

    public static b loadBitmap(InputStream inputStream, int i, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i4 = 1;
        options.inJustDecodeBounds = true;
        inputStream.mark(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        BitmapFactory.decodeStream(inputStream, null, options);
        try {
            inputStream.reset();
            options.inJustDecodeBounds = false;
            int i5 = options.outWidth;
            int i6 = options.outHeight;
            while (i4 < 8) {
                if (options.outWidth / i4 <= i || options.outHeight / i4 <= i2) {
                    if (((options.outWidth / i4) * options.outHeight) / i4 <= (i3 > 0 ? i3 : 1500000)) {
                        break;
                    }
                }
                i4 *= 2;
            }
            options.inSampleSize = i4;
            Crashlytics.log("[loadBitmap]w:" + options.outWidth + ", h:" + options.outHeight + ", s:" + i4);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
            if (decodeStream == null) {
                return new b(null, 0, 0);
            }
            return new b(decodeStream, i5, i6);
        } catch (IOException e2) {
            throw new RuntimeException("Failed to reset stream", e2);
        }
    }

    public static void calcSampleSize(BitmapFactory.Options options, int i, int i2, int i3) {
        int i4 = 1;
        while (i4 < 8) {
            if (options.outWidth / i4 <= i || options.outHeight / i4 <= i2) {
                if (((options.outWidth / i4) * options.outHeight) / i4 <= (i3 > 0 ? i3 : 1500000)) {
                    break;
                }
            }
            i4 *= 2;
        }
        options.inSampleSize = i4;
    }

    public static b loadBitmap(String str, int i, int i2, int i3) {
        return loadBitmap(str, i, i2, i3, null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.nextreaming.nexvideoeditor.NexImageLoader.b loadBitmap(java.lang.String r16, int r17, int r18, int r19, android.graphics.Bitmap.Config r20) {
        /*
            Method dump skipped, instructions count: 654
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexvideoeditor.NexImageLoader.loadBitmap(java.lang.String, int, int, int, android.graphics.Bitmap$Config):com.nextreaming.nexvideoeditor.NexImageLoader$b");
    }
}
