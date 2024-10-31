package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.b<V> {

    /* renamed from: a */
    ViewDragHelper f438a;

    /* renamed from: b */
    a f439b;

    /* renamed from: c */
    private boolean f440c;

    /* renamed from: e */
    private boolean f442e;

    /* renamed from: d */
    private float f441d = 0.0f;

    /* renamed from: f */
    int f443f = 2;

    /* renamed from: g */
    float f444g = 0.5f;

    /* renamed from: h */
    float f445h = 0.0f;
    float i = 0.5f;
    private final ViewDragHelper.Callback j = new C(this);

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);

        void a(View view);
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a */
        private final View f446a;

        /* renamed from: b */
        private final boolean f447b;

        public b(View view, boolean z) {
            this.f446a = view;
            this.f447b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.f438a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f446a, this);
            } else {
                if (!this.f447b || (aVar = SwipeDismissBehavior.this.f439b) == null) {
                    return;
                }
                aVar.a(this.f446a);
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.f440c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f440c = coordinatorLayout.a(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            z = this.f440c;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f440c = false;
        }
        if (!z) {
            return false;
        }
        a((ViewGroup) coordinatorLayout);
        return this.f438a.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean a(View view) {
        return true;
    }

    @Override // android.support.design.widget.CoordinatorLayout.b
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.f438a;
        if (viewDragHelper == null) {
            return false;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    private void a(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.f438a == null) {
            if (this.f442e) {
                create = ViewDragHelper.create(viewGroup, this.f441d, this.j);
            } else {
                create = ViewDragHelper.create(viewGroup, this.j);
            }
            this.f438a = create;
        }
    }

    public static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public static int a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
