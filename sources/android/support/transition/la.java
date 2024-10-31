package android.support.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewUtilsApi14.java */
/* loaded from: classes.dex */
public class la implements qa {
    @Override // android.support.transition.qa
    public void a(View view, float f2) {
        Float f3 = (Float) view.getTag(G.save_non_transition_alpha);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    @Override // android.support.transition.qa
    public ha b(View view) {
        return fa.c(view);
    }

    @Override // android.support.transition.qa
    public void c(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(G.save_non_transition_alpha, null);
        }
    }

    @Override // android.support.transition.qa
    public float d(View view) {
        Float f2 = (Float) view.getTag(G.save_non_transition_alpha);
        if (f2 != null) {
            return view.getAlpha() / f2.floatValue();
        }
        return view.getAlpha();
    }

    @Override // android.support.transition.qa
    public va e(View view) {
        return new ta(view.getWindowToken());
    }

    @Override // android.support.transition.qa
    public void b(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            b((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    @Override // android.support.transition.qa
    public void a(View view) {
        if (view.getTag(G.save_non_transition_alpha) == null) {
            view.setTag(G.save_non_transition_alpha, Float.valueOf(view.getAlpha()));
        }
    }

    @Override // android.support.transition.qa
    public void a(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            a((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    @Override // android.support.transition.qa
    public void a(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
