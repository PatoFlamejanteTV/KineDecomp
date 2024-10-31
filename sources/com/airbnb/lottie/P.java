package com.airbnb.lottie;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.AbstractC0677v;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FillContent.java */
/* loaded from: classes.dex */
class P implements M, AbstractC0677v.a {

    /* renamed from: c, reason: collision with root package name */
    private final String f7675c;

    /* renamed from: e, reason: collision with root package name */
    private final AbstractC0651ha<Integer> f7677e;

    /* renamed from: f, reason: collision with root package name */
    private final AbstractC0651ha<Integer> f7678f;

    /* renamed from: g, reason: collision with root package name */
    private final C0661ma f7679g;

    /* renamed from: a, reason: collision with root package name */
    private final Path f7673a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Paint f7674b = new Paint(1);

    /* renamed from: d, reason: collision with root package name */
    private final List<InterfaceC0684ya> f7676d = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(C0661ma c0661ma, AbstractC0683y abstractC0683y, Qa qa) {
        this.f7675c = qa.c();
        this.f7679g = c0661ma;
        if (qa.a() != null && qa.d() != null) {
            this.f7673a.setFillType(qa.b());
            this.f7677e = qa.a().a2();
            this.f7677e.a(this);
            abstractC0683y.a(this.f7677e);
            this.f7678f = qa.d().a2();
            this.f7678f.a(this);
            abstractC0683y.a(this.f7678f);
            return;
        }
        this.f7677e = null;
        this.f7678f = null;
    }

    @Override // com.airbnb.lottie.AbstractC0677v.a
    public void a() {
        this.f7679g.invalidateSelf();
    }

    @Override // com.airbnb.lottie.J
    public String getName() {
        return this.f7675c;
    }

    @Override // com.airbnb.lottie.J
    public void a(List<J> list, List<J> list2) {
        for (int i = 0; i < list2.size(); i++) {
            J j = list2.get(i);
            if (j instanceof InterfaceC0684ya) {
                this.f7676d.add((InterfaceC0684ya) j);
            }
        }
    }

    @Override // com.airbnb.lottie.M
    public void a(String str, String str2, ColorFilter colorFilter) {
        this.f7674b.setColorFilter(colorFilter);
    }

    @Override // com.airbnb.lottie.M
    public void a(Canvas canvas, Matrix matrix, int i) {
        this.f7674b.setColor(((Integer) this.f7677e.b()).intValue());
        this.f7674b.setAlpha((int) ((((i / 255.0f) * ((Integer) this.f7678f.b()).intValue()) / 100.0f) * 255.0f));
        this.f7673a.reset();
        for (int i2 = 0; i2 < this.f7676d.size(); i2++) {
            this.f7673a.addPath(this.f7676d.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f7673a, this.f7674b);
    }

    @Override // com.airbnb.lottie.M
    public void a(RectF rectF, Matrix matrix) {
        this.f7673a.reset();
        for (int i = 0; i < this.f7676d.size(); i++) {
            this.f7673a.addPath(this.f7676d.get(i).getPath(), matrix);
        }
        this.f7673a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
