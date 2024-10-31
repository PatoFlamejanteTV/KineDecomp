package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* compiled from: AdobeUploadThumbnailMgr.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: a */
    private static v f6478a;

    /* renamed from: b */
    private LruCache<String, Bitmap> f6479b;

    private v() {
        d();
    }

    public static synchronized void b() {
        synchronized (v.class) {
            if (f6478a != null) {
                f6478a.a();
            }
            f6478a = null;
        }
    }

    public static v c() {
        if (f6478a == null) {
            synchronized (v.class) {
                if (f6478a == null) {
                    f6478a = new v();
                }
            }
        }
        return f6478a;
    }

    private void d() {
        if (this.f6479b != null) {
            return;
        }
        this.f6479b = new LruCache<>(40);
    }

    public void a() {
        LruCache<String, Bitmap> lruCache = this.f6479b;
        if (lruCache == null) {
            return;
        }
        lruCache.evictAll();
        this.f6479b = null;
    }

    public void a(AdobeUploadAssetData adobeUploadAssetData, c.a.a.a.b<Bitmap> bVar) {
        b(adobeUploadAssetData, bVar);
    }

    public void b(AdobeUploadAssetData adobeUploadAssetData, c.a.a.a.b<Bitmap> bVar) {
        Bitmap bitmap = this.f6479b.get(adobeUploadAssetData.f5272a);
        if (bitmap != null) {
            bVar.b(bitmap);
        } else {
            new u(this, adobeUploadAssetData, bVar).execute(adobeUploadAssetData.l);
        }
    }

    public static Bitmap a(String str, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, new C0582ma(i, i2));
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static int a(BitmapFactory.Options options, C0582ma c0582ma) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        float f2 = c0582ma.f7348a;
        float f3 = c0582ma.f7349b;
        if (f2 > f3) {
            f3 = f2;
        }
        if (i > i2) {
            i2 = i;
        }
        int i3 = 1;
        if (i2 > f3) {
            while ((i2 / 2) / i3 > f3) {
                i3 *= 2;
            }
        }
        return i3;
    }

    private static InputStream a(URL url) {
        try {
            return url.openStream();
        } catch (IOException unused) {
            return null;
        }
    }

    public static Bitmap a(URL url, C0582ma c0582ma) {
        InputStream a2 = a(url);
        if (a2 == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(a2, null, options);
        options.inSampleSize = a(options, c0582ma);
        options.inJustDecodeBounds = false;
        InputStream a3 = a(url);
        Bitmap decodeStream = BitmapFactory.decodeStream(a3, null, options);
        try {
            a3.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return decodeStream;
    }
}
