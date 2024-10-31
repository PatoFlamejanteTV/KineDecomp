package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.PolystarShape;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.List;

/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
class Fa implements InterfaceC0684ya, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private final Path f7607a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final String f7608b;

    /* renamed from: c, reason: collision with root package name */
    private final C0661ma f7609c;

    /* renamed from: d, reason: collision with root package name */
    private final PolystarShape.Type f7610d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0677v<?, Float> f7611e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7612f;

    /* renamed from: g, reason: collision with root package name */
    private final AbstractC0677v<?, Float> f7613g;

    /* renamed from: h, reason: collision with root package name */
    private final AbstractC0677v<?, Float> f7614h;
    private final AbstractC0677v<?, Float> i;
    private final AbstractC0677v<?, Float> j;
    private final AbstractC0677v<?, Float> k;
    private cb l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fa(C0661ma c0661ma, AbstractC0683y abstractC0683y, PolystarShape polystarShape) {
        this.f7609c = c0661ma;
        this.f7608b = polystarShape.c();
        this.f7610d = polystarShape.i();
        this.f7611e = polystarShape.f().a2();
        this.f7612f = polystarShape.g().a2();
        this.f7613g = polystarShape.h().a2();
        this.i = polystarShape.d().a2();
        this.k = polystarShape.e().a2();
        if (this.f7610d == PolystarShape.Type.Star) {
            this.f7614h = polystarShape.a().a2();
            this.j = polystarShape.b().a2();
        } else {
            this.f7614h = null;
            this.j = null;
        }
        abstractC0683y.a(this.f7611e);
        abstractC0683y.a(this.f7612f);
        abstractC0683y.a(this.f7613g);
        abstractC0683y.a(this.i);
        abstractC0683y.a(this.k);
        if (this.f7610d == PolystarShape.Type.Star) {
            abstractC0683y.a(this.f7614h);
            abstractC0683y.a(this.j);
        }
        this.f7611e.a(this);
        this.f7612f.a(this);
        this.f7613g.a(this);
        this.i.a(this);
        this.k.a(this);
        if (this.f7610d == PolystarShape.Type.Star) {
            this.i.a(this);
            this.k.a(this);
        }
    }

    private void b() {
        double d2;
        double d3;
        double d4;
        int i;
        int floor = (int) Math.floor(this.f7611e.b().floatValue());
        double radians = Math.toRadians((this.f7613g == null ? 0.0d : r2.b().floatValue()) - 90.0d);
        double d5 = floor;
        Double.isNaN(d5);
        float floatValue = this.k.b().floatValue() / 100.0f;
        float floatValue2 = this.i.b().floatValue();
        double d6 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        float f2 = (float) (cos * d6);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        float f3 = (float) (sin * d6);
        this.f7607a.moveTo(f2, f3);
        double d7 = (float) (6.283185307179586d / d5);
        Double.isNaN(d7);
        double d8 = radians + d7;
        double ceil = Math.ceil(d5);
        int i2 = 0;
        while (i2 < ceil) {
            double cos2 = Math.cos(d8);
            Double.isNaN(d6);
            float f4 = (float) (cos2 * d6);
            double sin2 = Math.sin(d8);
            Double.isNaN(d6);
            double d9 = ceil;
            float f5 = (float) (d6 * sin2);
            if (floatValue != 0.0f) {
                d3 = d6;
                i = i2;
                d2 = d8;
                double atan2 = (float) (Math.atan2(f3, f2) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d4 = d7;
                double atan22 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float f6 = floatValue2 * floatValue * 0.25f;
                this.f7607a.cubicTo(f2 - (cos3 * f6), f3 - (sin3 * f6), f4 + (((float) Math.cos(atan22)) * f6), f5 + (f6 * ((float) Math.sin(atan22))), f4, f5);
            } else {
                d2 = d8;
                d3 = d6;
                d4 = d7;
                i = i2;
                this.f7607a.lineTo(f4, f5);
            }
            Double.isNaN(d4);
            d8 = d2 + d4;
            i2 = i + 1;
            f3 = f5;
            f2 = f4;
            ceil = d9;
            d6 = d3;
            d7 = d4;
        }
        PointF b2 = this.f7612f.b();
        this.f7607a.offset(b2.x, b2.y);
        this.f7607a.close();
    }

    private void c() {
        double d2;
        float f2;
        float f3;
        float f4;
        float f5;
        double d3;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float floatValue = this.f7611e.b().floatValue();
        double radians = Math.toRadians((this.f7613g == null ? 0.0d : r2.b().floatValue()) - 90.0d);
        double d4 = floatValue;
        Double.isNaN(d4);
        float f18 = (float) (6.283185307179586d / d4);
        float f19 = f18 / 2.0f;
        float f20 = floatValue - ((int) floatValue);
        if (f20 != 0.0f) {
            double d5 = (1.0f - f20) * f19;
            Double.isNaN(d5);
            radians += d5;
        }
        float floatValue2 = this.i.b().floatValue();
        float floatValue3 = this.f7614h.b().floatValue();
        AbstractC0677v<?, Float> abstractC0677v = this.j;
        float floatValue4 = abstractC0677v != null ? abstractC0677v.b().floatValue() / 100.0f : 0.0f;
        AbstractC0677v<?, Float> abstractC0677v2 = this.k;
        float floatValue5 = abstractC0677v2 != null ? abstractC0677v2.b().floatValue() / 100.0f : 0.0f;
        if (f20 != 0.0f) {
            float f21 = ((floatValue2 - floatValue3) * f20) + floatValue3;
            double d6 = f21;
            double cos = Math.cos(radians);
            Double.isNaN(d6);
            d2 = d4;
            float f22 = (float) (d6 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d6);
            float f23 = (float) (d6 * sin);
            this.f7607a.moveTo(f22, f23);
            double d7 = (f18 * f20) / 2.0f;
            Double.isNaN(d7);
            d3 = radians + d7;
            f4 = f22;
            f6 = f21;
            f2 = floatValue2;
            f5 = f23;
            f3 = f19;
        } else {
            d2 = d4;
            f2 = floatValue2;
            double d8 = f2;
            double cos2 = Math.cos(radians);
            Double.isNaN(d8);
            f3 = f19;
            f4 = (float) (d8 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d8);
            f5 = (float) (d8 * sin2);
            this.f7607a.moveTo(f4, f5);
            double d9 = f3;
            Double.isNaN(d9);
            d3 = radians + d9;
            f6 = 0.0f;
        }
        double ceil = Math.ceil(d2) * 2.0d;
        int i = 0;
        double d10 = d3;
        boolean z = false;
        while (true) {
            double d11 = i;
            if (d11 < ceil) {
                float f24 = z ? f2 : floatValue3;
                if (f6 == 0.0f || d11 != ceil - 2.0d) {
                    f7 = f24;
                    f8 = f3;
                } else {
                    f7 = f24;
                    f8 = (f18 * f20) / 2.0f;
                }
                if (f6 == 0.0f || d11 != ceil - 1.0d) {
                    f9 = f18;
                    f10 = f7;
                    f11 = f2;
                } else {
                    f9 = f18;
                    f11 = f2;
                    f10 = f6;
                }
                double d12 = f10;
                double cos3 = Math.cos(d10);
                Double.isNaN(d12);
                float f25 = (float) (d12 * cos3);
                double sin3 = Math.sin(d10);
                Double.isNaN(d12);
                float f26 = (float) (d12 * sin3);
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f7607a.lineTo(f25, f26);
                    f16 = f26;
                    f12 = f3;
                    f13 = floatValue3;
                    f14 = floatValue4;
                    f15 = floatValue5;
                    f17 = f8;
                } else {
                    f12 = f3;
                    f13 = floatValue3;
                    f14 = floatValue4;
                    double atan2 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    f15 = floatValue5;
                    float f27 = f8;
                    f16 = f26;
                    double atan22 = (float) (Math.atan2(f26, f25) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f28 = z ? f14 : f15;
                    float f29 = z ? f15 : f14;
                    float f30 = (z ? f13 : f11) * f28 * 0.47829f;
                    float f31 = cos4 * f30;
                    float f32 = f30 * sin4;
                    float f33 = (z ? f11 : f13) * f29 * 0.47829f;
                    float f34 = cos5 * f33;
                    float f35 = f33 * sin5;
                    if (f20 != 0.0f) {
                        if (i == 0) {
                            f31 *= f20;
                            f32 *= f20;
                        } else if (d11 == ceil - 1.0d) {
                            f34 *= f20;
                            f35 *= f20;
                        }
                    }
                    this.f7607a.cubicTo(f4 - f31, f5 - f32, f25 + f34, f16 + f35, f25, f16);
                    f17 = f27;
                }
                double d13 = f17;
                Double.isNaN(d13);
                d10 += d13;
                z = !z;
                i++;
                floatValue5 = f15;
                f4 = f25;
                f3 = f12;
                f2 = f11;
                f18 = f9;
                floatValue3 = f13;
                floatValue4 = f14;
                f5 = f16;
            } else {
                PointF b2 = this.f7612f.b();
                this.f7607a.offset(b2.x, b2.y);
                this.f7607a.close();
                return;
            }
        }
    }

    private void d() {
        this.m = false;
        this.f7609c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        d();
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7608b;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        if (this.m) {
            return this.f7607a;
        }
        this.f7607a.reset();
        int i = Ea.f7606a[this.f7610d.ordinal()];
        if (i == 1) {
            c();
        } else if (i == 2) {
            b();
        }
        this.f7607a.close();
        db.a(this.f7607a, this.l);
        this.m = true;
        return this.f7607a;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list.size(); i++) {
            J j = list.get(i);
            if (j instanceof cb) {
                cb cbVar = (cb) j;
                if (cbVar.e() == ShapeTrimPath.Type.Simultaneously) {
                    this.l = cbVar;
                    this.l.a(this);
                }
            }
        }
    }
}
