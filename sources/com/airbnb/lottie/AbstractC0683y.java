package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.Log;
import com.airbnb.lottie.AbstractC0677v;
import com.airbnb.lottie.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseLayer.java */
/* renamed from: com.airbnb.lottie.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0683y implements M, AbstractC0677v.a {
    final C0661ma l;
    final Layer m;
    private C0669qa n;
    private AbstractC0683y o;
    private AbstractC0683y p;
    private List<AbstractC0683y> q;
    final bb s;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7839a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f7840b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Paint f7841c = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    private final Paint f7842d = new Paint(1);

    /* renamed from: e, reason: collision with root package name */
    private final Paint f7843e = new Paint(1);

    /* renamed from: f, reason: collision with root package name */
    private final Paint f7844f = new Paint();

    /* renamed from: g, reason: collision with root package name */
    private final RectF f7845g = new RectF();

    /* renamed from: h, reason: collision with root package name */
    private final RectF f7846h = new RectF();
    private final RectF i = new RectF();
    private final RectF j = new RectF();
    final Matrix k = new Matrix();
    private final List<AbstractC0677v<?, ?>> r = new ArrayList();
    private boolean t = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractC0683y(C0661ma c0661ma, Layer layer) {
        this.l = c0661ma;
        this.m = layer;
        this.f7844f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f7842d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        if (layer.e() == Layer.MatteType.Invert) {
            this.f7843e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            this.f7843e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        this.s = layer.n().a();
        this.s.a((AbstractC0677v.a) this);
        this.s.a(this);
        if (layer.d() != null && !layer.d().isEmpty()) {
            this.n = new C0669qa(layer.d());
            for (AbstractC0677v<?, Path> abstractC0677v : this.n.a()) {
                a(abstractC0677v);
                abstractC0677v.a(this);
            }
        }
        g();
    }

    private void c(RectF rectF, Matrix matrix) {
        if (d() && this.m.e() != Layer.MatteType.Invert) {
            this.o.a(this.i, matrix);
            rectF.set(Math.max(rectF.left, this.i.left), Math.max(rectF.top, this.i.top), Math.min(rectF.right, this.i.right), Math.min(rectF.bottom, this.i.bottom));
        }
    }

    private void e() {
        if (this.q != null) {
            return;
        }
        if (this.p == null) {
            this.q = Collections.emptyList();
            return;
        }
        this.q = new ArrayList();
        for (AbstractC0683y abstractC0683y = this.p; abstractC0683y != null; abstractC0683y = abstractC0683y.p) {
            this.q.add(abstractC0683y);
        }
    }

    private void f() {
        this.l.invalidateSelf();
    }

    private void g() {
        if (!this.m.b().isEmpty()) {
            Q q = new Q(this.m.b());
            q.c();
            q.a(new C0679w(this, q));
            a(((Float) q.b()).floatValue() == 1.0f);
            a(q);
            return;
        }
        a(true);
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer b() {
        return this.m;
    }

    abstract void b(Canvas canvas, Matrix matrix, int i);

    boolean d() {
        return this.o != null;
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.m.f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AbstractC0683y a(Layer layer, C0661ma c0661ma, C0657ka c0657ka) {
        int i = C0681x.f7837a[layer.c().ordinal()];
        if (i == 1) {
            return new Ta(c0661ma, layer);
        }
        if (i == 2) {
            return new H(c0661ma, layer, c0657ka.a(layer.h()), c0657ka);
        }
        if (i == 3) {
            return new Ya(c0661ma, layer);
        }
        if (i == 4) {
            return new C0643da(c0661ma, layer, c0657ka.b());
        }
        if (i != 5) {
            Log.w("LOTTIE", "Unknown layer type " + layer.c());
            return null;
        }
        return new C0680wa(c0661ma, layer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AbstractC0683y abstractC0683y) {
        this.p = abstractC0683y;
    }

    private void b(RectF rectF, Matrix matrix) {
        this.f7846h.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (c()) {
            int size = this.n.b().size();
            for (int i = 0; i < size; i++) {
                Mask mask = this.n.b().get(i);
                this.f7839a.set(this.n.a().get(i).b());
                this.f7839a.transform(matrix);
                if (C0681x.f7838b[mask.a().ordinal()] == 1) {
                    return;
                }
                this.f7839a.computeBounds(this.j, false);
                if (i == 0) {
                    this.f7846h.set(this.j);
                } else {
                    RectF rectF2 = this.f7846h;
                    rectF2.set(Math.min(rectF2.left, this.j.left), Math.min(this.f7846h.top, this.j.top), Math.max(this.f7846h.right, this.j.right), Math.max(this.f7846h.bottom, this.j.bottom));
                }
            }
            rectF.set(Math.max(rectF.left, this.f7846h.left), Math.max(rectF.top, this.f7846h.top), Math.min(rectF.right, this.f7846h.right), Math.min(rectF.bottom, this.f7846h.bottom));
        }
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        f();
    }

    boolean c() {
        C0669qa c0669qa = this.n;
        return (c0669qa == null || c0669qa.a().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0683y abstractC0683y) {
        this.o = abstractC0683y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AbstractC0677v<?, ?> abstractC0677v) {
        if (abstractC0677v instanceof _a) {
            return;
        }
        this.r.add(abstractC0677v);
    }

    @Override // com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        this.k.set(matrix);
        this.k.preConcat(this.s.a());
    }

    @Override // com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        if (this.t) {
            e();
            this.f7840b.reset();
            this.f7840b.set(matrix);
            for (int size = this.q.size() - 1; size >= 0; size--) {
                this.f7840b.preConcat(this.q.get(size).s.a());
            }
            int intValue = (int) ((((i / 255.0f) * this.s.b().b().intValue()) / 100.0f) * 255.0f);
            if (!d() && !c()) {
                this.f7840b.preConcat(this.s.a());
                b(canvas, this.f7840b, intValue);
                return;
            }
            this.f7845g.set(0.0f, 0.0f, 0.0f, 0.0f);
            a(this.f7845g, this.f7840b);
            c(this.f7845g, this.f7840b);
            this.f7840b.preConcat(this.s.a());
            b(this.f7845g, this.f7840b);
            this.f7845g.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.saveLayer(this.f7845g, this.f7841c, 31);
            a(canvas);
            b(canvas, this.f7840b, intValue);
            if (c()) {
                a(canvas, this.f7840b);
            }
            if (d()) {
                canvas.saveLayer(this.f7845g, this.f7843e, 31);
                a(canvas);
                this.o.a(canvas, matrix, intValue);
                canvas.restore();
            }
            canvas.restore();
        }
    }

    private void a(Canvas canvas) {
        RectF rectF = this.f7845g;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f7844f);
    }

    private void a(Canvas canvas, Matrix matrix) {
        canvas.saveLayer(this.f7845g, this.f7842d, 31);
        a(canvas);
        int size = this.n.b().size();
        for (int i = 0; i < size; i++) {
            Mask mask = this.n.b().get(i);
            this.f7839a.set(this.n.a().get(i).b());
            this.f7839a.transform(matrix);
            if (C0681x.f7838b[mask.a().ordinal()] != 1) {
                this.f7839a.setFillType(Path.FillType.WINDING);
            } else {
                this.f7839a.setFillType(Path.FillType.INVERSE_WINDING);
            }
            canvas.drawPath(this.f7839a, this.f7841c);
        }
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z != this.t) {
            this.t = z;
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f2) {
        AbstractC0683y abstractC0683y = this.o;
        if (abstractC0683y != null) {
            abstractC0683y.a(f2);
        }
        for (int i = 0; i < this.r.size(); i++) {
            this.r.get(i).a(f2);
        }
    }
}
