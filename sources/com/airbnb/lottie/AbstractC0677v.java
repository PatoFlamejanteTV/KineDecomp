package com.airbnb.lottie;

import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* renamed from: com.airbnb.lottie.v */
/* loaded from: classes.dex */
abstract class AbstractC0677v<K, A> {

    /* renamed from: c */
    private final List<? extends C0649ga<K>> f7832c;

    /* renamed from: e */
    private C0649ga<K> f7834e;

    /* renamed from: a */
    final List<a> f7830a = new ArrayList();

    /* renamed from: b */
    private boolean f7831b = false;

    /* renamed from: d */
    private float f7833d = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: com.airbnb.lottie.v$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public AbstractC0677v(List<? extends C0649ga<K>> list) {
        this.f7832c = list;
    }

    private C0649ga<K> d() {
        if (!this.f7832c.isEmpty()) {
            C0649ga<K> c0649ga = this.f7834e;
            if (c0649ga != null && c0649ga.a(this.f7833d)) {
                return this.f7834e;
            }
            C0649ga<K> c0649ga2 = this.f7832c.get(0);
            if (this.f7833d < c0649ga2.c()) {
                this.f7834e = c0649ga2;
                return c0649ga2;
            }
            for (int i = 0; !c0649ga2.a(this.f7833d) && i < this.f7832c.size(); i++) {
                c0649ga2 = this.f7832c.get(i);
            }
            this.f7834e = c0649ga2;
            return c0649ga2;
        }
        throw new IllegalStateException("There are no keyframes");
    }

    private float e() {
        if (this.f7831b) {
            return 0.0f;
        }
        C0649ga<K> d2 = d();
        if (d2.d()) {
            return 0.0f;
        }
        return d2.f7774e.getInterpolation((this.f7833d - d2.c()) / (d2.b() - d2.c()));
    }

    private float f() {
        if (this.f7832c.isEmpty()) {
            return 1.0f;
        }
        return this.f7832c.get(r0.size() - 1).b();
    }

    private float g() {
        if (this.f7832c.isEmpty()) {
            return 0.0f;
        }
        return this.f7832c.get(0).c();
    }

    abstract A a(C0649ga<K> c0649ga, float f2);

    public void a(a aVar) {
        this.f7830a.add(aVar);
    }

    public A b() {
        return a(d(), e());
    }

    public void c() {
        this.f7831b = true;
    }

    public void a(float f2) {
        if (f2 < g()) {
            f2 = 0.0f;
        } else if (f2 > f()) {
            f2 = 1.0f;
        }
        if (f2 == this.f7833d) {
            return;
        }
        this.f7833d = f2;
        for (int i = 0; i < this.f7830a.size(); i++) {
            this.f7830a.get(i).a();
        }
    }

    public float a() {
        return this.f7833d;
    }
}
