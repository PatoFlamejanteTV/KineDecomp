package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImageAssetBitmapManager.java */
/* renamed from: com.airbnb.lottie.ba */
/* loaded from: classes.dex */
class C0639ba {

    /* renamed from: a */
    private final Context f7746a;

    /* renamed from: b */
    private String f7747b;

    /* renamed from: c */
    private InterfaceC0641ca f7748c;

    /* renamed from: d */
    private final Map<String, C0665oa> f7749d;

    /* renamed from: e */
    private final Map<String, Bitmap> f7750e = new HashMap();

    public C0639ba(Drawable.Callback callback, String str, InterfaceC0641ca interfaceC0641ca, Map<String, C0665oa> map) {
        if (callback != null) {
            this.f7747b = str;
            if (!TextUtils.isEmpty(str)) {
                if (this.f7747b.charAt(r4.length() - 1) != '/') {
                    this.f7747b += '/';
                }
            }
            if (!(callback instanceof View)) {
                Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
                this.f7749d = new HashMap();
                this.f7746a = null;
                return;
            } else {
                this.f7746a = ((View) callback).getContext();
                this.f7749d = map;
                a(interfaceC0641ca);
                return;
            }
        }
        throw new IllegalStateException();
    }

    void a(InterfaceC0641ca interfaceC0641ca) {
        this.f7748c = interfaceC0641ca;
    }

    public Bitmap a(String str) {
        Bitmap bitmap = this.f7750e.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        C0665oa c0665oa = this.f7749d.get(str);
        if (c0665oa == null) {
            return null;
        }
        InterfaceC0641ca interfaceC0641ca = this.f7748c;
        if (interfaceC0641ca != null) {
            Bitmap a2 = interfaceC0641ca.a(c0665oa);
            this.f7750e.put(str, a2);
            return a2;
        }
        try {
            if (!TextUtils.isEmpty(this.f7747b)) {
                InputStream open = this.f7746a.getAssets().open(this.f7747b + c0665oa.a());
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                this.f7750e.put(str, decodeStream);
                return decodeStream;
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e2) {
            Log.w("LOTTIE", "Unable to open asset.", e2);
            return null;
        }
    }

    public void a() {
        Iterator<Map.Entry<String, Bitmap>> it = this.f7750e.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().recycle();
            it.remove();
        }
    }

    public boolean a(Context context) {
        return (context == null && this.f7746a == null) || (context != null && this.f7746a.equals(context));
    }
}
