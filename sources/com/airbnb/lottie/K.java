package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.airbnb.lottie.AbstractC0677v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class K implements M, InterfaceC0684ya, AbstractC0677v.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7628a = "K";

    /* renamed from: e, reason: collision with root package name */
    private final String f7632e;

    /* renamed from: g, reason: collision with root package name */
    private final C0661ma f7634g;

    /* renamed from: h, reason: collision with root package name */
    private List<InterfaceC0684ya> f7635h;
    private bb i;

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f7629b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Path f7630c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final RectF f7631d = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final List<J> f7633f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(C0661ma c0661ma, AbstractC0683y abstractC0683y, Ra ra) {
        this.f7632e = ra.b();
        this.f7634g = c0661ma;
        List<Object> a2 = ra.a();
        if (a2.isEmpty()) {
            return;
        }
        Object obj = a2.get(a2.size() - 1);
        if (obj instanceof r) {
            this.i = ((r) obj).a();
            this.i.a(abstractC0683y);
            this.i.a(this);
        }
        for (int i = 0; i < a2.size(); i++) {
            Object obj2 = a2.get(i);
            if (obj2 instanceof Qa) {
                this.f7633f.add(new P(c0661ma, abstractC0683y, (Qa) obj2));
            } else if (obj2 instanceof W) {
                this.f7633f.add(new X(c0661ma, abstractC0683y, (W) obj2));
            } else if (obj2 instanceof ShapeStroke) {
                this.f7633f.add(new ab(c0661ma, abstractC0683y, (ShapeStroke) obj2));
            } else if (obj2 instanceof Z) {
                this.f7633f.add(new C0637aa(c0661ma, abstractC0683y, (Z) obj2));
            } else if (obj2 instanceof Ra) {
                this.f7633f.add(new K(c0661ma, abstractC0683y, (Ra) obj2));
            } else if (obj2 instanceof Ja) {
                this.f7633f.add(new Ha(c0661ma, abstractC0683y, (Ja) obj2));
            } else if (obj2 instanceof D) {
                this.f7633f.add(new N(c0661ma, abstractC0683y, (D) obj2));
            } else if (obj2 instanceof Va) {
                this.f7633f.add(new Ma(c0661ma, abstractC0683y, (Va) obj2));
            } else if (obj2 instanceof PolystarShape) {
                this.f7633f.add(new Fa(c0661ma, abstractC0683y, (PolystarShape) obj2));
            } else if (obj2 instanceof ShapeTrimPath) {
                this.f7633f.add(new cb(abstractC0683y, (ShapeTrimPath) obj2));
            } else if (obj2 instanceof MergePaths) {
                if (c0661ma.a()) {
                    this.f7633f.add(new C0674ta((MergePaths) obj2));
                } else {
                    Log.w(f7628a, "Animation contains merge paths but they are disabled.");
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        C0674ta c0674ta = null;
        for (int size = this.f7633f.size() - 1; size >= 0; size--) {
            J j = this.f7633f.get(size);
            c0674ta = j instanceof C0674ta ? (C0674ta) j : c0674ta;
            if (c0674ta != null && j != c0674ta) {
                c0674ta.a(j);
                arrayList.add(j);
            }
        }
        Iterator<J> it = this.f7633f.iterator();
        while (it.hasNext()) {
            if (arrayList.contains(it.next())) {
                it.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        this.f7634g.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<InterfaceC0684ya> b() {
        if (this.f7635h == null) {
            this.f7635h = new ArrayList();
            for (int i = 0; i < this.f7633f.size(); i++) {
                J j = this.f7633f.get(i);
                if (j instanceof InterfaceC0684ya) {
                    this.f7635h.add((InterfaceC0684ya) j);
                }
            }
        }
        return this.f7635h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix c() {
        bb bbVar = this.i;
        if (bbVar != null) {
            return bbVar.a();
        }
        this.f7629b.reset();
        return this.f7629b;
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7632e;
    }

    @Override // com.airbnb.lottie.InterfaceC0684ya
    public Path getPath() {
        this.f7629b.reset();
        bb bbVar = this.i;
        if (bbVar != null) {
            this.f7629b.set(bbVar.a());
        }
        this.f7630c.reset();
        for (int size = this.f7633f.size() - 1; size >= 0; size--) {
            J j = this.f7633f.get(size);
            if (j instanceof InterfaceC0684ya) {
                this.f7630c.addPath(((InterfaceC0684ya) j).getPath(), this.f7629b);
            }
        }
        return this.f7630c;
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        for (int i = 0; i < this.f7633f.size(); i++) {
            J j = this.f7633f.get(i);
            if (j instanceof M) {
                M m = (M) j;
                if (str2 != null && !str2.equals(j.getName())) {
                    m.a(str, str2, colorFilter);
                } else {
                    m.a(str, (String) null, colorFilter);
                }
            }
        }
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f7633f.size());
        arrayList.addAll(list);
        for (int size = this.f7633f.size() - 1; size >= 0; size--) {
            J j = this.f7633f.get(size);
            j.a(arrayList, this.f7633f.subList(0, size));
            arrayList.add(j);
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7629b.set(matrix);
        bb bbVar = this.i;
        if (bbVar != null) {
            this.f7629b.preConcat(bbVar.a());
            i = (int) ((((this.i.b().b().intValue() / 100.0f) * i) / 255.0f) * 255.0f);
        }
        for (int size = this.f7633f.size() - 1; size >= 0; size--) {
            J j = this.f7633f.get(size);
            if (j instanceof M) {
                ((M) j).a(canvas, this.f7629b, i);
            }
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        this.f7629b.set(matrix);
        bb bbVar = this.i;
        if (bbVar != null) {
            this.f7629b.preConcat(bbVar.a());
        }
        this.f7631d.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f7633f.size() - 1; size >= 0; size--) {
            J j = this.f7633f.get(size);
            if (j instanceof M) {
                ((M) j).a(this.f7631d, this.f7629b);
                if (rectF.isEmpty()) {
                    rectF.set(this.f7631d);
                } else {
                    rectF.set(Math.min(rectF.left, this.f7631d.left), Math.min(rectF.top, this.f7631d.top), Math.max(rectF.right, this.f7631d.right), Math.max(rectF.bottom, this.f7631d.bottom));
                }
            }
        }
    }
}
