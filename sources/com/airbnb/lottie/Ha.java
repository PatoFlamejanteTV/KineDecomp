package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.List;

/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
class Ha implements InterfaceC0684ya, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private final Path f7616a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final RectF f7617b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    private final String f7618c;

    /* renamed from: d, reason: collision with root package name */
    private final C0661ma f7619d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7620e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7621f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0677v<?, Float> f7622g;

    /* renamed from: h, reason: collision with root package name */
    private cb f7623h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(C0661ma c0661ma, AbstractC0683y abstractC0683y, Ja ja) {
        this.f7618c = ja.b();
        this.f7619d = c0661ma;
        this.f7620e = ja.c().a2();
        this.f7621f = ja.d().a2();
        this.f7622g = ja.a().a2();
        abstractC0683y.a(this.f7620e);
        abstractC0683y.a(this.f7621f);
        abstractC0683y.a(this.f7622g);
        this.f7620e.a(this);
        this.f7621f.a(this);
        this.f7622g.a(this);
    }

    private void b() {
        this.i = false;
        this.f7619d.invalidateSelf();
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7618c;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        if (this.i) {
            return this.f7616a;
        }
        this.f7616a.reset();
        PointF b2 = this.f7621f.b();
        float f2 = b2.x / 2.0f;
        float f3 = b2.y / 2.0f;
        AbstractC0677v<?, Float> abstractC0677v = this.f7622g;
        float floatValue = abstractC0677v == null ? 0.0f : abstractC0677v.b().floatValue();
        float min = Math.min(f2, f3);
        if (floatValue > min) {
            floatValue = min;
        }
        PointF b3 = this.f7620e.b();
        this.f7616a.moveTo(b3.x + f2, (b3.y - f3) + floatValue);
        this.f7616a.lineTo(b3.x + f2, (b3.y + f3) - floatValue);
        if (floatValue > 0.0f) {
            RectF rectF = this.f7617b;
            float f4 = b3.x;
            float f5 = floatValue * 2.0f;
            float f6 = b3.y;
            rectF.set((f4 + f2) - f5, (f6 + f3) - f5, f4 + f2, f6 + f3);
            this.f7616a.arcTo(this.f7617b, 0.0f, 90.0f, false);
        }
        this.f7616a.lineTo((b3.x - f2) + floatValue, b3.y + f3);
        if (floatValue > 0.0f) {
            RectF rectF2 = this.f7617b;
            float f7 = b3.x;
            float f8 = b3.y;
            float f9 = floatValue * 2.0f;
            rectF2.set(f7 - f2, (f8 + f3) - f9, (f7 - f2) + f9, f8 + f3);
            this.f7616a.arcTo(this.f7617b, 90.0f, 90.0f, false);
        }
        float f10 = 2.0f * floatValue;
        this.f7616a.lineTo(b3.x - f2, (b3.y - f3) + f10);
        if (floatValue > 0.0f) {
            RectF rectF3 = this.f7617b;
            float f11 = b3.x;
            float f12 = b3.y;
            rectF3.set(f11 - f2, f12 - f3, (f11 - f2) + f10, (f12 - f3) + f10);
            this.f7616a.arcTo(this.f7617b, 180.0f, 90.0f, false);
        }
        this.f7616a.lineTo((b3.x + f2) - f10, b3.y - f3);
        if (floatValue > 0.0f) {
            RectF rectF4 = this.f7617b;
            float f13 = b3.x;
            float f14 = b3.y;
            rectF4.set((f13 + f2) - f10, f14 - f3, f13 + f2, (f14 - f3) + f10);
            this.f7616a.arcTo(this.f7617b, 270.0f, 90.0f, false);
        }
        this.f7616a.close();
        db.a(this.f7616a, this.f7623h);
        this.i = true;
        return this.f7616a;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list.size(); i++) {
            J j = list.get(i);
            if (j instanceof cb) {
                cb cbVar = (cb) j;
                if (cbVar.e() == ShapeTrimPath.Type.Simultaneously) {
                    this.f7623h = cbVar;
                    this.f7623h.a(this);
                }
            }
        }
    }
}
