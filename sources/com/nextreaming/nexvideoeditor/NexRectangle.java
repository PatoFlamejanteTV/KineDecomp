package com.nextreaming.nexvideoeditor;

import android.graphics.Rect;

/* loaded from: classes3.dex */
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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NexRectangle.class != obj.getClass()) {
            return false;
        }
        NexRectangle nexRectangle = (NexRectangle) obj;
        return this.mLeft == nexRectangle.mLeft && this.mTop == nexRectangle.mTop && this.mRight == nexRectangle.mRight && this.mBottom == nexRectangle.mBottom;
    }

    public int hashCode() {
        return (((((this.mLeft * 31) + this.mTop) * 31) + this.mRight) * 31) + this.mBottom;
    }

    public void reset() {
        this.mLeft = 0;
        this.mTop = 0;
        this.mRight = 0;
        this.mBottom = 0;
    }

    public void setRect(int i, int i2, int i3, int i4) {
        this.mLeft = i;
        this.mTop = i2;
        this.mRight = i3;
        this.mBottom = i4;
    }

    public Rect toRect() {
        return new Rect(this.mLeft, this.mTop, this.mRight, this.mBottom);
    }
}
