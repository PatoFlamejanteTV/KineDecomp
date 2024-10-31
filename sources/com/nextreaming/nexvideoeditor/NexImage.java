package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.util.Log;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

/* loaded from: classes3.dex */
public class NexImage {

    /* renamed from: a */
    private final Bitmap f24614a;

    /* renamed from: b */
    private final int f24615b;

    /* renamed from: c */
    private final int f24616c;

    /* renamed from: d */
    private final int f24617d = 1;

    public NexImage(Bitmap bitmap, int i, int i2) {
        this.f24614a = bitmap;
        this.f24615b = i;
        this.f24616c = i2;
    }

    public Bitmap getBitmap() {
        return this.f24614a;
    }

    public int getHeight() {
        return this.f24616c;
    }

    public int getLoadedType() {
        return this.f24617d;
    }

    public void getPixels(int[] iArr) {
        Bitmap bitmap = this.f24614a;
        if (bitmap == null) {
            return;
        }
        try {
            bitmap.getPixels(iArr, 0, this.f24615b, 0, 0, this.f24615b, this.f24616c);
        } catch (ArrayIndexOutOfBoundsException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("w=");
            sb.append(this.f24615b);
            sb.append(" h=");
            sb.append(this.f24616c);
            sb.append(" bm=");
            sb.append(this.f24614a.getWidth());
            sb.append(FragmentC2201x.f23219a);
            sb.append(this.f24614a.getHeight());
            sb.append(" pixels=");
            sb.append(iArr == null ? "null" : Integer.valueOf(iArr.length));
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
    }

    public int getWidth() {
        return this.f24615b;
    }

    public void recycle() {
        this.f24614a.recycle();
        Log.d("NexImage", "recycle Bitmap from native");
    }

    public void getPixels(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmap = this.f24614a;
        if (bitmap != null && i4 + i6 <= bitmap.getHeight() && i3 + i5 <= this.f24614a.getWidth()) {
            this.f24614a.getPixels(iArr, i, i2, i3, i4, i5, i6);
        }
    }
}
