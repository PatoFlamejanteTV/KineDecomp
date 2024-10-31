package com.nextreaming.nexvideoeditor;

/* loaded from: classes.dex */
public final class NexRectangle {
    public int mBottom;
    public int mLeft;
    public int mRight;
    public int mTop;

    public NexRectangle(int i, int i2, int i3, int i4) {
        this.mLeft = i;
        this.mTop = i2;
        this.mRight = i3;
        this.mBottom = i4;
    }

    public void setRect(int i, int i2, int i3, int i4) {
        this.mLeft = i;
        this.mTop = i2;
        this.mRight = i3;
        this.mBottom = i4;
    }
}
