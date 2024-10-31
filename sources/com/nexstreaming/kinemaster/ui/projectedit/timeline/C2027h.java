package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/* compiled from: ItemSnapshot.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.h */
/* loaded from: classes2.dex */
public class C2027h implements z {

    /* renamed from: a */
    private final Bitmap f22667a;

    /* renamed from: b */
    private final int f22668b;

    /* renamed from: c */
    private final int f22669c;

    /* renamed from: d */
    private final int f22670d;

    /* renamed from: e */
    private Paint f22671e;

    /* renamed from: f */
    private int f22672f;

    /* renamed from: g */
    private int f22673g;

    /* renamed from: h */
    private float f22674h;

    public C2027h(Bitmap bitmap) {
        this(bitmap, 0, 0, 0);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int a() {
        return this.f22669c;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getHeight() {
        return this.f22673g;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getIndex() {
        return this.f22670d;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public int getWidth() {
        return this.f22672f;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public boolean isValid() {
        Bitmap bitmap = this.f22667a;
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public C2027h(Bitmap bitmap, int i, int i2, int i3) {
        this.f22674h = 1.0f;
        this.f22667a = bitmap;
        this.f22668b = i;
        this.f22669c = i2;
        this.f22670d = i3;
        this.f22672f = bitmap.getWidth();
        this.f22673g = bitmap.getHeight();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(int i) {
        this.f22673g = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(float f2) {
        this.f22674h = f2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.z
    public void a(Canvas canvas, float f2, float f3) {
        if (this.f22671e == null) {
            this.f22671e = new Paint(1);
        }
        this.f22671e.setAlpha((int) (this.f22674h * 255.0f));
        canvas.drawBitmap(this.f22667a, f2 + this.f22668b, f3 + this.f22669c, this.f22671e);
    }
}
