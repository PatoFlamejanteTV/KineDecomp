package com.airbnb.lottie;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.List;

/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
class N implements InterfaceC0684ya, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private final Path f7660a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final String f7661b;

    /* renamed from: c, reason: collision with root package name */
    private final C0661ma f7662c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7663d;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0677v<?, PointF> f7664e;

    /* renamed from: f, reason: collision with root package name */
    private cb f7665f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7666g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(C0661ma c0661ma, AbstractC0683y abstractC0683y, D d2) {
        this.f7661b = d2.a();
        this.f7662c = c0661ma;
        this.f7663d = d2.c().a2();
        this.f7664e = d2.b().a2();
        abstractC0683y.a(this.f7663d);
        abstractC0683y.a(this.f7664e);
        this.f7663d.a(this);
        this.f7664e.a(this);
    }

    private void b() {
        this.f7666g = false;
        this.f7662c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7661b;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        if (this.f7666g) {
            return this.f7660a;
        }
        this.f7660a.reset();
        PointF b2 = this.f7663d.b();
        float f2 = b2.x / 2.0f;
        float f3 = b2.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = 0.55228f * f3;
        this.f7660a.reset();
        float f6 = -f3;
        this.f7660a.moveTo(0.0f, f6);
        float f7 = f4 + 0.0f;
        float f8 = 0.0f - f5;
        this.f7660a.cubicTo(f7, f6, f2, f8, f2, 0.0f);
        float f9 = f5 + 0.0f;
        this.f7660a.cubicTo(f2, f9, f7, f3, 0.0f, f3);
        float f10 = 0.0f - f4;
        float f11 = -f2;
        this.f7660a.cubicTo(f10, f3, f11, f9, f11, 0.0f);
        this.f7660a.cubicTo(f11, f8, f10, f6, 0.0f, f6);
        PointF b3 = this.f7664e.b();
        this.f7660a.offset(b3.x, b3.y);
        this.f7660a.close();
        db.a(this.f7660a, this.f7665f);
        this.f7666g = true;
        return this.f7660a;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list.size(); i++) {
            J j = list.get(i);
            if (j instanceof cb) {
                cb cbVar = (cb) j;
                if (cbVar.e() == ShapeTrimPath.Type.Simultaneously) {
                    this.f7665f = cbVar;
                    this.f7665f.a(this);
                }
            }
        }
    }
}
