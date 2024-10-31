package com.nexstreaming.kinemaster.ad;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.nexstreaming.kinemaster.ad.f;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* compiled from: ImageBanner.java */
/* loaded from: classes.dex */
public class i extends f {

    /* renamed from: f */
    private int f19958f;

    /* renamed from: g */
    private int f19959g;

    /* renamed from: h */
    private int f19960h;
    private int i;
    private long j;
    private int k;
    protected Bitmap l;

    public i(BannerInfo bannerInfo) {
        super(bannerInfo);
        this.f19958f = bannerInfo.getWidth() / Math.max(1, bannerInfo.getColumns());
        this.f19959g = bannerInfo.getHeight() / Math.max(1, bannerInfo.getRows());
        this.f19960h = Math.max(1, bannerInfo.getColumns() * bannerInfo.getRows());
        if (bannerInfo.getCount() > 0) {
            this.f19960h = Math.min(this.f19960h, bannerInfo.getCount());
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(f.a aVar) {
        com.bumptech.glide.h<Bitmap> a2 = com.bumptech.glide.c.b(KineMasterApplication.f24056d).a();
        a2.a(this.f19951a.getUrl());
        a2.a((com.bumptech.glide.h<Bitmap>) new h(this, this.f19951a.getWidth(), this.f19951a.getHeight(), aVar));
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public boolean h() {
        return this.l != null;
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public boolean i() {
        return this.f19960h > 1 && this.f19951a.getDuration() > 0 && (this.f19951a.getRepeat() <= 0 || this.k < this.f19951a.getRepeat());
    }

    public String toString() {
        return "Banner {  frameWidth: " + this.f19958f + ", frameHeight: " + this.f19959g + ", frameCount: " + this.f19960h + " }";
    }

    public void a(Bitmap bitmap) {
        this.l = bitmap;
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(long j) {
        if (h()) {
            long duration = this.j + this.f19951a.getDuration();
            if (this.i == 0) {
                duration += this.f19951a.getDelay();
            }
            if (j >= duration) {
                this.j = j;
                int i = this.i + 1;
                this.i = i;
                this.i = i % this.f19960h;
                if (this.i == 0) {
                    this.k++;
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ad.f
    public void a(Canvas canvas) {
        float f2;
        int i;
        if (h()) {
            int width = this.f19952b.width();
            int height = this.f19952b.height();
            if (Math.abs(width - this.f19958f) < Math.abs(height - this.f19959g)) {
                f2 = width;
                i = this.f19958f;
            } else {
                f2 = height;
                i = this.f19959g;
            }
            float f3 = f2 / i;
            Rect rect = new Rect();
            Rect rect2 = this.f19952b;
            int i2 = rect2.left;
            int i3 = this.f19958f;
            rect.left = i2 + ((width - ((int) (i3 * f3))) / 2) + this.f19953c;
            int i4 = rect2.top;
            int i5 = this.f19959g;
            rect.top = i4 + ((height - ((int) (i5 * f3))) / 2) + this.f19954d;
            rect.right = rect.left + ((int) (i3 * f3));
            rect.bottom = rect.top + ((int) (i5 * f3));
            if (this.f19951a.getType() == 1) {
                int columns = this.f19958f * (this.i % this.f19951a.getColumns());
                int columns2 = this.f19959g * (this.i / this.f19951a.getColumns());
                canvas.drawBitmap(this.l, new Rect(columns, columns2, this.f19958f + columns, this.f19959g + columns2), rect, (Paint) null);
                return;
            }
            canvas.drawBitmap(this.l, (Rect) null, rect, (Paint) null);
        }
    }
}
