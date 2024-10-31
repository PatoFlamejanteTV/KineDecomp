package com.github.ybq.android.spinkit.b;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;

/* compiled from: SpriteContainer.java */
/* loaded from: classes.dex */
public abstract class r extends q {
    private q[] E = s();
    private int F;

    public r() {
        t();
        a(this.E);
    }

    private void t() {
        q[] qVarArr = this.E;
        if (qVarArr != null) {
            for (q qVar : qVarArr) {
                qVar.setCallback(this);
            }
        }
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public int a() {
        return this.F;
    }

    @Override // com.github.ybq.android.spinkit.b.q
    protected void a(Canvas canvas) {
    }

    public void a(q... qVarArr) {
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public void b(int i) {
        this.F = i;
        for (int i2 = 0; i2 < r(); i2++) {
            h(i2).b(i);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        b(canvas);
    }

    public q h(int i) {
        q[] qVarArr = this.E;
        if (qVarArr == null) {
            return null;
        }
        return qVarArr[i];
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Animatable
    public boolean isRunning() {
        return com.github.ybq.android.spinkit.a.a.a(this.E) || super.isRunning();
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        for (q qVar : this.E) {
            qVar.setBounds(rect);
        }
    }

    @Override // com.github.ybq.android.spinkit.b.q
    public ValueAnimator p() {
        return null;
    }

    public int r() {
        q[] qVarArr = this.E;
        if (qVarArr == null) {
            return 0;
        }
        return qVarArr.length;
    }

    public abstract q[] s();

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Animatable
    public void start() {
        super.start();
        com.github.ybq.android.spinkit.a.a.b(this.E);
    }

    @Override // com.github.ybq.android.spinkit.b.q, android.graphics.drawable.Animatable
    public void stop() {
        super.stop();
        com.github.ybq.android.spinkit.a.a.c(this.E);
    }

    public void b(Canvas canvas) {
        q[] qVarArr = this.E;
        if (qVarArr != null) {
            for (q qVar : qVarArr) {
                int save = canvas.save();
                qVar.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
    }
}
