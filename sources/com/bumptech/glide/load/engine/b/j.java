package com.bumptech.glide.load.engine.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* compiled from: MemorySizeCalculator.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a */
    private final int f8850a;

    /* renamed from: b */
    private final int f8851b;

    /* renamed from: c */
    private final Context f8852c;

    /* renamed from: d */
    private final int f8853d;

    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        static final int f8854a;

        /* renamed from: b */
        final Context f8855b;

        /* renamed from: c */
        ActivityManager f8856c;

        /* renamed from: d */
        c f8857d;

        /* renamed from: f */
        float f8859f;

        /* renamed from: e */
        float f8858e = 2.0f;

        /* renamed from: g */
        float f8860g = 0.4f;

        /* renamed from: h */
        float f8861h = 0.33f;
        int i = 4194304;

        static {
            f8854a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f8859f = f8854a;
            this.f8855b = context;
            this.f8856c = (ActivityManager) context.getSystemService("activity");
            this.f8857d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !j.a(this.f8856c)) {
                return;
            }
            this.f8859f = 0.0f;
        }

        public j a() {
            return new j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public static final class b implements c {

        /* renamed from: a */
        private final DisplayMetrics f8862a;

        b(DisplayMetrics displayMetrics) {
            this.f8862a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.b.j.c
        public int a() {
            return this.f8862a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.b.j.c
        public int b() {
            return this.f8862a.widthPixels;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemorySizeCalculator.java */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        int b();
    }

    j(a aVar) {
        int i;
        this.f8852c = aVar.f8855b;
        if (a(aVar.f8856c)) {
            i = aVar.i / 2;
        } else {
            i = aVar.i;
        }
        this.f8853d = i;
        int a2 = a(aVar.f8856c, aVar.f8860g, aVar.f8861h);
        float b2 = aVar.f8857d.b() * aVar.f8857d.a() * 4;
        int round = Math.round(aVar.f8859f * b2);
        int round2 = Math.round(b2 * aVar.f8858e);
        int i2 = a2 - this.f8853d;
        int i3 = round2 + round;
        if (i3 <= i2) {
            this.f8851b = round2;
            this.f8850a = round;
        } else {
            float f2 = i2;
            float f3 = aVar.f8859f;
            float f4 = aVar.f8858e;
            float f5 = f2 / (f3 + f4);
            this.f8851b = Math.round(f4 * f5);
            this.f8850a = Math.round(f5 * aVar.f8859f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f8851b));
            sb.append(", pool size: ");
            sb.append(a(this.f8850a));
            sb.append(", byte array size: ");
            sb.append(a(this.f8853d));
            sb.append(", memory class limited? ");
            sb.append(i3 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f8856c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f8856c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public int a() {
        return this.f8853d;
    }

    public int b() {
        return this.f8850a;
    }

    public int c() {
        return this.f8851b;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f8852c, i);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
