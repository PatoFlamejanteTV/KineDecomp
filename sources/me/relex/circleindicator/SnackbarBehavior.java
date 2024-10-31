package me.relex.circleindicator;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar$SnackbarLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import java.util.List;

/* loaded from: classes3.dex */
public class SnackbarBehavior extends CoordinatorLayout.b<CircleIndicator> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        return view instanceof Snackbar$SnackbarLayout;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator, View view) {
        circleIndicator.setTranslationY(a(coordinatorLayout, circleIndicator));
        return true;
    }

    private float a(CoordinatorLayout coordinatorLayout, CircleIndicator circleIndicator) {
        List<View> b2 = coordinatorLayout.b(circleIndicator);
        int size = b2.size();
        float f2 = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = b2.get(i);
            if ((view instanceof Snackbar$SnackbarLayout) && coordinatorLayout.a(circleIndicator, view)) {
                f2 = Math.min(f2, ViewCompat.getTranslationY(view) - view.getHeight());
            }
        }
        return f2;
    }
}
