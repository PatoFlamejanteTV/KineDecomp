package com.nexstreaming.kinemaster.fonts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class Font implements Comparable<Font> {

    /* renamed from: a */
    private static final b[] f20382a = {new b(" thin", 1), new b(" light", 2), new b(" regular", 3), new b(" medium", 4), new b(" bold", 5), new b(" black", 6), new b(" italic", 100), new b(" condensed", 1000)};

    /* renamed from: b */
    private final String f20383b;

    /* renamed from: c */
    private final boolean f20384c;

    /* renamed from: d */
    private final String f20385d;

    /* renamed from: e */
    private final File f20386e;

    /* renamed from: f */
    private transient WeakReference<Bitmap> f20387f;

    /* renamed from: g */
    private transient WeakReference<Typeface> f20388g;

    /* renamed from: h */
    private final transient Typeface f20389h;
    private final String i;
    private final String j;
    private a k;
    private com.nexstreaming.app.general.nexasset.assetpackage.b l;

    /* loaded from: classes.dex */
    public static class TypefaceLoadException extends Exception {
        private static final long serialVersionUID = 1;

        public TypefaceLoadException() {
        }

        public TypefaceLoadException(String str, Throwable th) {
            super(str, th);
        }

        public TypefaceLoadException(String str) {
            super(str);
        }

        public TypefaceLoadException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        static final Map<String, a> f20390a = new HashMap();

        /* renamed from: b */
        final String f20391b;

        /* renamed from: c */
        final int f20392c;

        private a(String str) {
            String trim = str.toLowerCase(Locale.ENGLISH).trim();
            int i = 0;
            while (true) {
                String str2 = trim;
                int i2 = i;
                boolean z = false;
                for (b bVar : Font.f20382a) {
                    if (str2.endsWith(bVar.f20393a)) {
                        str2 = str2.substring(0, str2.length() - bVar.f20393a.length());
                        i2 += bVar.f20394b;
                        z = true;
                    }
                }
                if (!z) {
                    this.f20391b = str2;
                    this.f20392c = i2;
                    return;
                } else {
                    trim = str2;
                    i = i2;
                }
            }
        }

        public static a a(String str) {
            a aVar = f20390a.get(str);
            return aVar != null ? aVar : new a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        final String f20393a;

        /* renamed from: b */
        final int f20394b;

        /* synthetic */ b(String str, int i, com.nexstreaming.kinemaster.fonts.b bVar) {
            this(str, i);
        }

        private b(String str, int i) {
            this.f20393a = str;
            this.f20394b = i;
        }
    }

    public Font(String str, String str2, File file, String str3, com.nexstreaming.app.general.nexasset.assetpackage.b bVar) {
        this.f20383b = str;
        this.i = str2;
        this.f20384c = false;
        this.f20389h = null;
        this.f20385d = null;
        this.f20386e = file;
        this.j = str3;
        this.l = bVar;
    }

    private Bitmap c(Context context) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(a(context, Typeface.DEFAULT));
        textPaint.setAntiAlias(true);
        textPaint.setColor(-1);
        textPaint.setTextSize(60.0f);
        StaticLayout staticLayout = new StaticLayout(TextUtils.ellipsize(this.j, textPaint, 940, TextUtils.TruncateAt.END), textPaint, 940, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        Bitmap createBitmap = Bitmap.createBitmap(1000, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.save();
        canvas.translate(30, (100 - staticLayout.getHeight()) / 2);
        staticLayout.draw(canvas);
        canvas.restore();
        return createBitmap;
    }

    private a g() {
        if (this.k == null) {
            this.k = a.a(this.j);
        }
        return this.k;
    }

    public Typeface b(Context context) throws TypefaceLoadException {
        Typeface typeface;
        WeakReference<Typeface> weakReference = this.f20388g;
        if (weakReference != null && (typeface = weakReference.get()) != null) {
            return typeface;
        }
        if (this.f20384c) {
            Typeface typeface2 = this.f20389h;
            if (typeface2 == null) {
                typeface2 = Typeface.createFromAsset(context.getAssets(), this.f20385d);
            }
            this.f20388g = new WeakReference<>(typeface2);
            return typeface2;
        }
        File file = this.f20386e;
        if (file == null) {
            return null;
        }
        try {
            Typeface createFromFile = Typeface.createFromFile(file);
            this.f20388g = new WeakReference<>(createFromFile);
            return createFromFile;
        } catch (RuntimeException e2) {
            if (e2.getMessage().contains("native typeface cannot be made")) {
                throw new TypefaceLoadException(e2);
            }
            throw e2;
        }
    }

    public com.nexstreaming.app.general.nexasset.assetpackage.b d() {
        return this.l;
    }

    public String e() {
        return this.i;
    }

    public boolean f() {
        if (this.f20384c) {
            return true;
        }
        File file = this.f20386e;
        return file != null && file.exists();
    }

    public String getId() {
        return this.f20383b;
    }

    public String toString() {
        return "[font:" + this.f20383b + ":" + System.identityHashCode(this) + "]";
    }

    public Typeface a(Context context, Typeface typeface) {
        try {
            return b(context);
        } catch (TypefaceLoadException unused) {
            return typeface;
        }
    }

    public Bitmap a(Context context) {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = this.f20387f;
        if (weakReference != null && (bitmap = weakReference.get()) != null) {
            return bitmap;
        }
        Bitmap c2 = c(context);
        if (c2 == null) {
            return null;
        }
        int[] iArr = new int[c2.getWidth() * c2.getHeight()];
        c2.getPixels(iArr, 0, c2.getWidth(), 0, 0, c2.getWidth(), c2.getHeight());
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = iArr[i] & ((iArr[i] << 8) | 255);
        }
        Bitmap createBitmap = Bitmap.createBitmap(iArr, c2.getWidth(), c2.getHeight(), Bitmap.Config.ARGB_8888);
        createBitmap.setHasAlpha(true);
        this.f20387f = new WeakReference<>(createBitmap);
        return createBitmap;
    }

    public Font(String str, String str2, String str3, String str4) {
        this.f20383b = str;
        this.i = str2;
        this.f20384c = str3 != null;
        this.f20385d = str3;
        this.f20386e = null;
        this.f20389h = null;
        this.j = str4;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Font font) {
        a g2 = g();
        a g3 = font.g();
        int compareTo = g2.f20391b.compareTo(g3.f20391b);
        return compareTo != 0 ? compareTo : g2.f20392c - g3.f20392c;
    }

    public Font(String str, String str2, Typeface typeface, String str3) {
        this.f20383b = str;
        this.i = str2;
        this.f20384c = typeface != null;
        this.f20389h = typeface;
        this.f20385d = null;
        this.f20386e = null;
        this.j = str3;
    }
}
