package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public class NexImage {

    /* renamed from: a, reason: collision with root package name */
    private final Bitmap f4799a;
    private final int b;
    private final int c;

    public NexImage(Bitmap bitmap, int i, int i2) {
        this.f4799a = bitmap;
        this.b = i;
        this.c = i2;
    }

    public int getWidth() {
        return this.b;
    }

    public int getHeight() {
        return this.c;
    }

    public void getPixels(int[] iArr) {
        if (this.f4799a != null) {
            try {
                this.f4799a.getPixels(iArr, 0, this.b, 0, 0, this.b, this.c);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new ArrayIndexOutOfBoundsException("w=" + this.b + " h=" + this.c + " bm=" + this.f4799a.getWidth() + "x" + this.f4799a.getHeight() + " pixels=" + (iArr == null ? "null" : Integer.valueOf(iArr.length)));
            }
        }
    }

    public void getPixels(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f4799a != null && i4 + i6 <= this.f4799a.getHeight() && i3 + i5 <= this.f4799a.getWidth()) {
            this.f4799a.getPixels(iArr, i, i2, i3, i4, i5, i6);
        }
    }

    public Bitmap getBitmap() {
        return this.f4799a;
    }
}
