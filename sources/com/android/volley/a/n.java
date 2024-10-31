package com.android.volley.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.m;
import com.android.volley.p;

/* compiled from: ImageRequest.java */
/* loaded from: classes.dex */
public class n extends Request<Bitmap> {
    private static final Object p = new Object();
    private final Object q;
    private m.b<Bitmap> r;
    private final Bitmap.Config s;
    private final int t;
    private final int u;
    private final ImageView.ScaleType v;

    public n(String str, m.b<Bitmap> bVar, int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, m.a aVar) {
        super(0, str, aVar);
        this.q = new Object();
        a((com.android.volley.o) new com.android.volley.d(1000, 2, 2.0f));
        this.r = bVar;
        this.s = config;
        this.t = i;
        this.u = i2;
        this.v = scaleType;
    }

    private com.android.volley.m<Bitmap> b(com.android.volley.j jVar) {
        Bitmap decodeByteArray;
        byte[] bArr = jVar.f8071b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.t == 0 && this.u == 0) {
            options.inPreferredConfig = this.s;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int a2 = a(this.t, this.u, i, i2, this.v);
            int a3 = a(this.u, this.t, i2, i, this.v);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i, i2, a2, a3);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a2 || decodeByteArray.getHeight() > a3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                decodeByteArray.recycle();
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray == null) {
            return com.android.volley.m.a(new ParseError(jVar));
        }
        return com.android.volley.m.a(decodeByteArray, f.a(jVar));
    }

    @Override // com.android.volley.Request
    public Request.Priority getPriority() {
        return Request.Priority.LOW;
    }

    private static int a(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            double d2 = i2;
            double d3 = i4;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i3;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        }
        if (i2 == 0) {
            return i;
        }
        double d5 = i4;
        double d6 = i3;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double d7 = d5 / d6;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d8 = i;
            Double.isNaN(d8);
            double d9 = i2;
            if (d8 * d7 >= d9) {
                return i;
            }
            Double.isNaN(d9);
            return (int) (d9 / d7);
        }
        double d10 = i;
        Double.isNaN(d10);
        double d11 = i2;
        if (d10 * d7 <= d11) {
            return i;
        }
        Double.isNaN(d11);
        return (int) (d11 / d7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public com.android.volley.m<Bitmap> a(com.android.volley.j jVar) {
        com.android.volley.m<Bitmap> b2;
        synchronized (p) {
            try {
                try {
                    b2 = b(jVar);
                } catch (OutOfMemoryError e2) {
                    p.b("Caught OOM for %d byte image, url=%s", Integer.valueOf(jVar.f8071b.length), q());
                    return com.android.volley.m.a(new ParseError(e2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.volley.Request
    public void a(Bitmap bitmap) {
        m.b<Bitmap> bVar;
        synchronized (this.q) {
            bVar = this.r;
        }
        if (bVar != null) {
            bVar.a(bitmap);
        }
    }

    static int a(int i, int i2, int i3, int i4) {
        double d2 = i;
        double d3 = i3;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = i2;
        double d5 = i4;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double min = Math.min(d2 / d3, d4 / d5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
