package com.airbnb.lottie;

import android.graphics.Path;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.List;

/* compiled from: ShapeContent.java */
/* loaded from: classes.dex */
class Ma implements InterfaceC0684ya, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private final Path f7650a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final String f7651b;

    /* renamed from: c, reason: collision with root package name */
    private final C0661ma f7652c;

    /* renamed from: d, reason: collision with root package name */
    private final AbstractC0677v<?, Path> f7653d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f7654e;

    /* renamed from: f, reason: collision with root package name */
    private cb f7655f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(C0661ma c0661ma, AbstractC0683y abstractC0683y, Va va) {
        this.f7651b = va.a();
        this.f7652c = c0661ma;
        this.f7653d = va.b().a2();
        abstractC0683y.a(this.f7653d);
        this.f7653d.a(this);
    }

    private void b() {
        this.f7654e = false;
        this.f7652c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        b();
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7651b;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        if (this.f7654e) {
            return this.f7650a;
        }
        this.f7650a.reset();
        this.f7650a.set(this.f7653d.b());
        this.f7650a.setFillType(Path.FillType.EVEN_ODD);
        db.a(this.f7650a, this.f7655f);
        this.f7654e = true;
        return this.f7650a;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list.size(); i++) {
            J j = list.get(i);
            if (j instanceof cb) {
                cb cbVar = (cb) j;
                if (cbVar.e() == ShapeTrimPath.Type.Simultaneously) {
                    this.f7655f = cbVar;
                    this.f7655f.a(this);
                }
            }
        }
    }
}
