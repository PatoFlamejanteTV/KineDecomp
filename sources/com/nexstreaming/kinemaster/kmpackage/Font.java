package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class Font implements Comparable<Font> {

    /* renamed from: a, reason: collision with root package name */
    private final String f3422a;
    private final boolean b;
    private final int c;
    private final String d;
    private File e;
    private File f;
    private final String g;
    private transient WeakReference<Bitmap> h;
    private transient WeakReference<Typeface> i;
    private final transient Typeface j;
    private final String k;
    private final EffectLibrary l;
    private Task m;
    private Task n;
    private String o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Font(String str, String str2, int i, String str3, String str4) {
        this.f3422a = str;
        this.k = str2;
        if (str3 == null) {
            this.b = false;
        } else {
            this.b = true;
        }
        this.c = i;
        this.d = str3;
        this.e = null;
        this.f = null;
        this.l = null;
        this.g = null;
        this.j = null;
        this.o = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Font(String str, String str2, int i, Typeface typeface, String str3) {
        this.f3422a = str;
        this.k = str2;
        if (typeface == null) {
            this.b = false;
        } else {
            this.b = true;
        }
        this.c = i;
        this.j = typeface;
        this.d = null;
        this.e = null;
        this.f = null;
        this.l = null;
        this.g = null;
        this.o = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Font(String str, String str2, File file, File file2, EffectLibrary effectLibrary, String str3, String str4) {
        this.f3422a = str;
        this.k = str2;
        this.b = false;
        this.c = 0;
        this.d = null;
        this.e = file;
        this.j = null;
        this.f = file2;
        this.l = effectLibrary;
        this.g = str3;
        this.o = str4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.g;
    }

    public String a(Context context) {
        return this.o;
    }

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

    public Typeface b(Context context) throws TypefaceLoadException {
        Typeface createFromAsset;
        Typeface typeface;
        if (this.i == null || (typeface = this.i.get()) == null) {
            if (this.b) {
                if (this.j != null) {
                    createFromAsset = this.j;
                } else {
                    createFromAsset = Typeface.createFromAsset(context.getAssets(), this.d);
                }
                this.i = new WeakReference<>(createFromAsset);
                return createFromAsset;
            }
            if (this.f != null) {
                try {
                    Typeface createFromFile = Typeface.createFromFile(this.f);
                    this.i = new WeakReference<>(createFromFile);
                    return createFromFile;
                } catch (RuntimeException e) {
                    if (e.getMessage().contains("native typeface cannot be made")) {
                        throw new TypefaceLoadException(e);
                    }
                    throw e;
                }
            }
            return null;
        }
        return typeface;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File c() {
        return this.f;
    }

    public Bitmap c(Context context) {
        Bitmap decodeFile;
        Bitmap bitmap;
        if (this.h == null || (bitmap = this.h.get()) == null) {
            if (this.b) {
                decodeFile = BitmapFactory.decodeResource(context.getResources(), this.c);
            } else {
                decodeFile = this.e != null ? BitmapFactory.decodeFile(this.e.getAbsolutePath()) : null;
            }
            if (decodeFile == null) {
                return null;
            }
            int[] iArr = new int[decodeFile.getWidth() * decodeFile.getHeight()];
            decodeFile.getPixels(iArr, 0, decodeFile.getWidth(), 0, 0, decodeFile.getWidth(), decodeFile.getHeight());
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = iArr[i] & ((iArr[i] << 8) | 255);
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr, decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.setHasAlpha(true);
            this.h = new WeakReference<>(createBitmap);
            return createBitmap;
        }
        return bitmap;
    }

    public boolean d() {
        if (this.b) {
            return true;
        }
        return this.f != null && this.f.exists();
    }

    public Task e() {
        if (this.m == null || !this.m.isRunning()) {
            return null;
        }
        return this.m;
    }

    public boolean f() {
        if (this.m == null) {
            return false;
        }
        return this.m.isRunning();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(File file) {
        this.f = file;
    }

    public boolean g() {
        return this.b;
    }

    public int h() {
        if (this.f == null || !this.f.exists()) {
            return 0;
        }
        long length = this.f.length();
        if (length > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) length;
    }

    public Task i() {
        if (this.m != null && this.m.isRunning()) {
            return this.m;
        }
        this.m = new Task();
        if (this.n != null && this.n.isRunning()) {
            this.m.signalEvent(Task.Event.FAIL);
            return this.m;
        }
        this.n = null;
        if (d() && !j()) {
            this.m.signalEvent(Task.Event.COMPLETE);
        } else if (this.l == null) {
            this.m.signalEvent(Task.Event.FAIL);
        } else {
            this.l.a(this, this.m);
        }
        return this.m;
    }

    public boolean j() {
        return false;
    }

    public boolean k() {
        return !this.b;
    }

    public Task l() {
        if (this.n != null && this.n.isRunning()) {
            return this.n;
        }
        this.n = new Task();
        if (!k()) {
            this.n.sendFailure(Theme.UninstallError.NotUninstallable);
            return this.n;
        }
        if (this.m != null && this.m.isRunning()) {
            return this.n;
        }
        this.m = null;
        if (!d()) {
            this.n.signalEvent(Task.Event.COMPLETE);
        } else if (this.l == null) {
            this.n.sendFailure(Theme.UninstallError.NoLibrary);
        } else {
            this.l.b(this, this.n);
        }
        return this.n;
    }

    public String m() {
        return this.f3422a;
    }

    public String n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        if (str.startsWith("android:") && this.j != null) {
            if (str.equalsIgnoreCase("android:Droid Sans") && this.f3422a.equalsIgnoreCase("system.droidsans")) {
                return true;
            }
            if (str.equalsIgnoreCase("android:Droid Sans Bold") && this.f3422a.equalsIgnoreCase("system.droidsansb")) {
                return true;
            }
            if (str.equalsIgnoreCase("android:Droid Serif") && this.f3422a.equalsIgnoreCase("system.droidserif")) {
                return true;
            }
            if (str.equalsIgnoreCase("android:Droid Serif Bold") && this.f3422a.equalsIgnoreCase("system.droidserifb")) {
                return true;
            }
            if (str.equalsIgnoreCase("android:Droid Serif Italic") && this.f3422a.equalsIgnoreCase("system.droidserifi")) {
                return true;
            }
            if (str.equalsIgnoreCase("android:Droid Serif Bold Italic") && this.f3422a.equalsIgnoreCase("system.droidserifbi")) {
                return true;
            }
        }
        if (this.b && this.d != null && str.startsWith("asset:")) {
            return str.substring(6).equals(this.d);
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(Font font) {
        return this.o.compareTo(font.o);
    }

    public String toString() {
        return "[font:" + this.f3422a + ":" + System.identityHashCode(this) + "]";
    }
}
