package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: RequestHandler.java */
/* loaded from: classes3.dex */
public abstract class E {

    /* compiled from: RequestHandler.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a */
        private final Picasso.LoadedFrom f25571a;

        /* renamed from: b */
        private final Bitmap f25572b;

        /* renamed from: c */
        private final InputStream f25573c;

        /* renamed from: d */
        private final int f25574d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this(bitmap, null, loadedFrom, 0);
            N.a(bitmap, "bitmap == null");
        }

        public Bitmap a() {
            return this.f25572b;
        }

        public int b() {
            return this.f25574d;
        }

        public Picasso.LoadedFrom c() {
            return this.f25571a;
        }

        public InputStream d() {
            return this.f25573c;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(InputStream inputStream, Picasso.LoadedFrom loadedFrom) {
            this(null, inputStream, loadedFrom, 0);
            N.a(inputStream, "stream == null");
        }

        public a(Bitmap bitmap, InputStream inputStream, Picasso.LoadedFrom loadedFrom, int i) {
            if ((inputStream != null) ^ (bitmap != null)) {
                this.f25572b = bitmap;
                this.f25573c = inputStream;
                N.a(loadedFrom, "loadedFrom == null");
                this.f25571a = loadedFrom;
                this.f25574d = i;
                return;
            }
            throw new AssertionError();
        }
    }

    public static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public static BitmapFactory.Options b(C c2) {
        boolean c3 = c2.c();
        boolean z = c2.r != null;
        BitmapFactory.Options options = null;
        if (c3 || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = c3;
            if (z) {
                options.inPreferredConfig = c2.r;
            }
        }
        return options;
    }

    public int a() {
        return 0;
    }

    public abstract a a(C c2, int i) throws IOException;

    public abstract boolean a(C c2);

    public boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public static void a(int i, int i2, BitmapFactory.Options options, C c2) {
        a(i, i2, options.outWidth, options.outHeight, options, c2);
    }

    public static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C c2) {
        int min;
        double floor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                floor = Math.floor(i3 / i);
            } else if (i == 0) {
                floor = Math.floor(i4 / i2);
            } else {
                int floor2 = (int) Math.floor(i4 / i2);
                int floor3 = (int) Math.floor(i3 / i);
                if (c2.l) {
                    min = Math.max(floor2, floor3);
                } else {
                    min = Math.min(floor2, floor3);
                }
            }
            min = (int) floor;
        } else {
            min = 1;
        }
        options.inSampleSize = min;
        options.inJustDecodeBounds = false;
    }
}
