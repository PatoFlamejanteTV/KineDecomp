package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.OverScroller;

/* compiled from: HeaderBehavior.java */
/* loaded from: classes.dex */
abstract class w<V extends View> extends P<V> {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f511d;

    /* renamed from: e, reason: collision with root package name */
    OverScroller f512e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f513f;

    /* renamed from: g, reason: collision with root package name */
    private int f514g;

    /* renamed from: h, reason: collision with root package name */
    private int f515h;
    private int i;
    private VelocityTracker j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeaderBehavior.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f516a;

        /* renamed from: b, reason: collision with root package name */
        private final V f517b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f516a = coordinatorLayout;
            this.f517b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f517b == null || (overScroller = w.this.f512e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                w wVar = w.this;
                wVar.c(this.f516a, (CoordinatorLayout) this.f517b, wVar.f512e.getCurrY());
                ViewCompat.postOnAnimation(this.f517b, this);
                return;
            }
            w.this.e(this.f516a, this.f517b);
        }
    }

    public w() {
        this.f514g = -1;
        this.i = -1;
    }

    private void d() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:            if (r0 != 3) goto L35;     */
    @Override // android.support.design.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.support.design.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f513f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.f514g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.f515h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.i
            if (r6 <= r0) goto L83
            r4.f513f = r2
            r4.f515h = r5
            goto L83
        L51:
            r4.f513f = r3
            r4.f514g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.j = r5
            goto L83
        L60:
            r4.f513f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.a(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.a(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.f515h = r1
            int r5 = r7.getPointerId(r3)
            r4.f514g = r5
            r4.d()
        L83:
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f513f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.w.a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    abstract boolean a(V v);

    abstract int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3);

    abstract int b(V v);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:            if (r0 != 3) goto L39;     */
    @Override // android.support.design.widget.CoordinatorLayout.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(android.support.design.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.i = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L8d
            r3 = -1
            if (r0 == r1) goto L5c
            r4 = 2
            if (r0 == r4) goto L25
            r12 = 3
            if (r0 == r12) goto L7e
            goto Lae
        L25:
            int r0 = r11.f514g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r3) goto L2e
            return r2
        L2e:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f515h
            int r2 = r2 - r0
            boolean r3 = r11.f513f
            if (r3 != 0) goto L49
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.i
            if (r3 <= r4) goto L49
            r11.f513f = r1
            if (r2 <= 0) goto L48
            int r2 = r2 - r4
            goto L49
        L48:
            int r2 = r2 + r4
        L49:
            r6 = r2
            boolean r2 = r11.f513f
            if (r2 == 0) goto Lae
            r11.f515h = r0
            int r7 = r11.b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.a(r4, r5, r6, r7, r8)
            goto Lae
        L5c:
            android.view.VelocityTracker r0 = r11.j
            if (r0 == 0) goto L7e
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.j
            int r4 = r11.f514g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.c(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.a(r6, r7, r8, r9, r10)
        L7e:
            r11.f513f = r2
            r11.f514g = r3
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lae
            r12.recycle()
            r12 = 0
            r11.j = r12
            goto Lae
        L8d:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r3 = r14.getY()
            int r3 = (int) r3
            boolean r12 = r12.a(r13, r0, r3)
            if (r12 == 0) goto Lb6
            boolean r12 = r11.a(r13)
            if (r12 == 0) goto Lb6
            r11.f515h = r3
            int r12 = r14.getPointerId(r2)
            r11.f514g = r12
            r11.d()
        Lae:
            android.view.VelocityTracker r12 = r11.j
            if (r12 == 0) goto Lb5
            r12.addMovement(r14)
        Lb5:
            return r1
        Lb6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.w.b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    abstract int c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return b(coordinatorLayout, (CoordinatorLayout) v, i, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    abstract int c(V v);

    abstract void e(CoordinatorLayout coordinatorLayout, V v);

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f514g = -1;
        this.i = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return b(coordinatorLayout, (CoordinatorLayout) v, c() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        Runnable runnable = this.f511d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f511d = null;
        }
        if (this.f512e == null) {
            this.f512e = new OverScroller(v.getContext());
        }
        this.f512e.fling(0, b(), 0, Math.round(f2), 0, 0, i, i2);
        if (this.f512e.computeScrollOffset()) {
            this.f511d = new a(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.f511d);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }
}
