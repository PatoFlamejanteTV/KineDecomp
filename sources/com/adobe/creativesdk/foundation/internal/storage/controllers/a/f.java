package com.adobe.creativesdk.foundation.internal.storage.controllers.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import com.adobe.creativesdk.foundation.internal.storage.controllers.a.c;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.util.HashMap;

/* compiled from: ReusableImageBitmapWorker.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private final Resources f5929a;

    /* renamed from: b */
    private c.a f5930b;

    /* renamed from: c */
    private c f5931c;

    /* renamed from: e */
    private HashMap<String, a> f5933e = new HashMap<>();

    /* renamed from: d */
    private HashMap<String, byte[]> f5932d = new HashMap<>();

    /* compiled from: ReusableImageBitmapWorker.java */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<Object, Integer, Bitmap> {

        /* renamed from: a */
        private final c.a.a.a.b<Bitmap> f5934a;

        /* renamed from: b */
        private final String f5935b;

        /* renamed from: c */
        private final C0582ma f5936c;

        a(String str, c.a.a.a.b<Bitmap> bVar) {
            this.f5934a = bVar;
            this.f5935b = str;
            this.f5936c = null;
        }

        private void a() {
            if (((a) f.this.f5933e.get(this.f5935b)) == this) {
                f.this.f5933e.remove(this.f5935b);
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(Bitmap bitmap) {
            a();
            this.f5934a.b(bitmap);
        }

        @Override // android.os.AsyncTask
        public Bitmap doInBackground(Object... objArr) {
            if (objArr[0] instanceof byte[]) {
                byte[] bArr = (byte[]) objArr[0];
                if (bArr == null || isCancelled()) {
                    return null;
                }
                C0582ma c0582ma = this.f5936c;
                if (c0582ma != null) {
                    float f2 = c0582ma.f7349b;
                    float f3 = c0582ma.f7348a;
                    if (f2 > f3) {
                        f3 = f2;
                    }
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                    options.inJustDecodeBounds = false;
                    options.inSampleSize = (int) (options.outWidth / f3);
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                }
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            }
            if (objArr[0] instanceof String) {
                String str = (String) objArr[0];
                C0582ma c0582ma2 = this.f5936c;
                if (c0582ma2 != null) {
                    float f4 = c0582ma2.f7349b;
                    float f5 = c0582ma2.f7348a;
                    if (f4 > f5) {
                        f5 = f4;
                    }
                    BitmapFactory.Options options2 = new BitmapFactory.Options();
                    options2.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(str, options2);
                    options2.inJustDecodeBounds = false;
                    options2.inSampleSize = (int) (options2.outWidth / f5);
                    return BitmapFactory.decodeFile(str, options2);
                }
                return BitmapFactory.decodeFile(str);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onCancelled(Bitmap bitmap) {
            a();
            this.f5934a.b(bitmap);
        }

        a(String str, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar) {
            this.f5934a = bVar;
            this.f5935b = str;
            this.f5936c = c0582ma;
        }
    }

    public f(Context context) {
        this.f5929a = context.getResources();
    }

    public void a(FragmentManager fragmentManager, c.a aVar) {
        this.f5930b = aVar;
        this.f5931c = c.a(fragmentManager, this.f5930b);
    }

    public byte[] b(String str) {
        return this.f5932d.get(str);
    }

    public BitmapDrawable c(String str) {
        c cVar;
        if (str == null || (cVar = this.f5931c) == null) {
            return null;
        }
        return cVar.a(str);
    }

    public void a(String str, String str2, C0582ma c0582ma, c.a.a.a.b<BitmapDrawable> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        if (str == null) {
            bVar.b(null);
            return;
        }
        a(str);
        a a2 = a(str, c0582ma, new d(this, str, bVar, cVar));
        this.f5933e.put(str, a2);
        a2.execute(str2);
    }

    public boolean a(String str, Bitmap bitmap) {
        this.f5931c.a(str, new BitmapDrawable(this.f5929a, bitmap));
        return true;
    }

    public void a(String str, byte[] bArr) {
        this.f5932d.put(str, bArr);
    }

    public void a(String str, byte[] bArr, c.a.a.a.b<BitmapDrawable> bVar, c.a.a.a.c<AdobeAssetException> cVar) {
        if (str == null) {
            bVar.b(null);
            return;
        }
        a(str);
        a a2 = a(str, new e(this, str, bVar, cVar));
        this.f5933e.put(str, a2);
        a2.execute(bArr);
    }

    private a a(String str, c.a.a.a.b<Bitmap> bVar) {
        return new a(str, bVar);
    }

    private a a(String str, C0582ma c0582ma, c.a.a.a.b<Bitmap> bVar) {
        return new a(str, c0582ma, bVar);
    }

    public void a() {
        this.f5931c.b();
    }

    public void a(String str) {
        a aVar;
        if (this.f5933e.size() == 0 || (aVar = this.f5933e.get(str)) == null) {
            return;
        }
        this.f5933e.remove(str);
        aVar.cancel(false);
    }
}
