package com.google.firebase.inappmessaging.display.internal;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging-display@@17.0.5 */
@Singleton
/* loaded from: classes2.dex */
public class FiamWindowManager {

    /* renamed from: a */
    private BindingWrapper f17544a;

    @Inject
    public FiamWindowManager() {
    }

    private Point b(Activity activity) {
        Point point = new Point();
        Display defaultDisplay = e(activity).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    private Rect c(Activity activity) {
        Rect rect = new Rect();
        Rect d2 = d(activity);
        Point b2 = b(activity);
        rect.top = d2.top;
        rect.left = d2.left;
        rect.right = b2.x - d2.right;
        rect.bottom = b2.y - d2.bottom;
        return rect;
    }

    private Rect d(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect;
    }

    private WindowManager e(Activity activity) {
        return (WindowManager) activity.getSystemService("window");
    }

    public void a(BindingWrapper bindingWrapper, Activity activity) {
        if (a()) {
            Logging.c("Fiam already active. Cannot show new Fiam.");
            return;
        }
        InAppMessageLayoutConfig b2 = bindingWrapper.b();
        WindowManager.LayoutParams a2 = a(b2, activity);
        WindowManager e2 = e(activity);
        e2.addView(bindingWrapper.f(), a2);
        Rect c2 = c(activity);
        Logging.a("Inset (top, bottom)", c2.top, c2.bottom);
        Logging.a("Inset (left, right)", c2.left, c2.right);
        if (bindingWrapper.a()) {
            bindingWrapper.c().setOnTouchListener(a(b2, bindingWrapper, e2, a2));
        }
        this.f17544a = bindingWrapper;
    }

    public boolean a() {
        return this.f17544a != null;
    }

    public void a(Activity activity) {
        if (a()) {
            e(activity).removeViewImmediate(this.f17544a.f());
            this.f17544a = null;
        }
    }

    private WindowManager.LayoutParams a(InAppMessageLayoutConfig inAppMessageLayoutConfig, Activity activity) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(inAppMessageLayoutConfig.n().intValue(), inAppMessageLayoutConfig.m().intValue(), 1003, inAppMessageLayoutConfig.l().intValue(), -3);
        Rect c2 = c(activity);
        if ((inAppMessageLayoutConfig.k().intValue() & 48) == 48) {
            layoutParams.y = c2.top;
        }
        layoutParams.dimAmount = 0.3f;
        layoutParams.gravity = inAppMessageLayoutConfig.k().intValue();
        layoutParams.windowAnimations = 0;
        return layoutParams;
    }

    private SwipeDismissTouchListener a(InAppMessageLayoutConfig inAppMessageLayoutConfig, BindingWrapper bindingWrapper, WindowManager windowManager, WindowManager.LayoutParams layoutParams) {
        c cVar = new c(this, bindingWrapper);
        if (inAppMessageLayoutConfig.n().intValue() == -1) {
            return new SwipeDismissTouchListener(bindingWrapper.c(), null, cVar);
        }
        return new d(this, bindingWrapper.c(), null, cVar, layoutParams, windowManager, bindingWrapper);
    }
}
