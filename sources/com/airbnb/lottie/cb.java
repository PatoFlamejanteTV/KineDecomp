package com.airbnb.lottie;

import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public class cb implements J, AbstractC0677v.a {

    /* renamed from: a */
    private String f7757a;

    /* renamed from: b */
    private final List<AbstractC0677v.a> f7758b = new ArrayList();

    /* renamed from: c */
    private final ShapeTrimPath.Type f7759c;

    /* renamed from: d */
    private final AbstractC0677v<?, Float> f7760d;

    /* renamed from: e */
    private final AbstractC0677v<?, Float> f7761e;

    /* renamed from: f */
    private final AbstractC0677v<?, Float> f7762f;

    public cb(AbstractC0683y abstractC0683y, ShapeTrimPath shapeTrimPath) {
        this.f7757a = shapeTrimPath.b();
        this.f7759c = shapeTrimPath.e();
        this.f7760d = shapeTrimPath.d().a();
        this.f7761e = shapeTrimPath.a().a();
        this.f7762f = shapeTrimPath.c().a();
        abstractC0683y.a(this.f7760d);
        abstractC0683y.a(this.f7761e);
        abstractC0683y.a(this.f7762f);
        this.f7760d.a(this);
        this.f7761e.a(this);
        this.f7762f.a(this);
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        for (int i = 0; i < this.f7758b.size(); i++) {
            this.f7758b.get(i).a();
        }
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
    }

    public AbstractC0677v<?, Float> b() {
        return this.f7761e;
    }

    public AbstractC0677v<?, Float> c() {
        return this.f7762f;
    }

    public AbstractC0677v<?, Float> d() {
        return this.f7760d;
    }

    public ShapeTrimPath.Type e() {
        return this.f7759c;
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7757a;
    }

    public void a(AbstractC0677v.a aVar) {
        this.f7758b.add(aVar);
    }
}
