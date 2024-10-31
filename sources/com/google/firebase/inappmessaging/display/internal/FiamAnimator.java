package com.google.firebase.inappmessaging.display.internal;

import android.app.Application;
import android.graphics.Point;
import android.view.View;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@FirebaseAppScope
/* loaded from: classes2.dex */
public class FiamAnimator {

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public interface AnimationCompleteListener {
    }

    /* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
    /* loaded from: classes2.dex */
    public enum Position {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM;

        public static Point a(Position position, View view) {
            view.measure(-2, -2);
            int i = b.f17574a[position.ordinal()];
            if (i == 1) {
                return new Point(view.getMeasuredWidth() * (-1), 0);
            }
            if (i == 2) {
                return new Point(view.getMeasuredWidth() * 1, 0);
            }
            if (i == 3) {
                return new Point(0, view.getMeasuredHeight() * (-1));
            }
            if (i != 4) {
                return new Point(0, view.getMeasuredHeight() * (-1));
            }
            return new Point(0, view.getMeasuredHeight() * 1);
        }
    }

    @Inject
    public FiamAnimator() {
    }

    public void a(Application application, View view, Position position) {
        view.setAlpha(0.0f);
        Point a2 = Position.a(position, view);
        view.animate().translationX(a2.x).translationY(a2.y).setDuration(1L).setListener(new a(this, view, application));
    }
}
