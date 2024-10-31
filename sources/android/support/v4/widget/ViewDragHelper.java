package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: a */
    private static final Interpolator f2071a = new Interpolator() { // from class: android.support.v4.widget.ViewDragHelper.1
        AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };

    /* renamed from: b */
    private int f2072b;

    /* renamed from: c */
    private int f2073c;

    /* renamed from: e */
    private float[] f2075e;

    /* renamed from: f */
    private float[] f2076f;

    /* renamed from: g */
    private float[] f2077g;

    /* renamed from: h */
    private float[] f2078h;
    private int[] i;
    private int[] j;
    private int[] k;
    private int l;
    private VelocityTracker m;
    private float n;
    private float o;
    private int p;
    private int q;
    private OverScroller r;
    private final Callback s;
    private View t;
    private boolean u;
    private final ViewGroup v;

    /* renamed from: d */
    private int f2074d = -1;
    private final Runnable w = new Runnable() { // from class: android.support.v4.widget.ViewDragHelper.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.a(0);
        }
    };

    /* renamed from: android.support.v4.widget.ViewDragHelper$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements Interpolator {
        AnonymousClass1() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.widget.ViewDragHelper$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.a(0);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f2, float f3) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback != null) {
            this.v = viewGroup;
            this.s = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.p = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f2073c = viewConfiguration.getScaledTouchSlop();
            this.n = viewConfiguration.getScaledMaximumFlingVelocity();
            this.o = viewConfiguration.getScaledMinimumFlingVelocity();
            this.r = new OverScroller(context, f2071a);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    private int a(View view, int i, int i2, int i3, int i4) {
        float f2;
        float f3;
        float f4;
        float f5;
        int a2 = a(i3, (int) this.o, (int) this.n);
        int a3 = a(i4, (int) this.o, (int) this.n);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(a2);
        int abs4 = Math.abs(a3);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (a2 != 0) {
            f2 = abs3;
            f3 = i5;
        } else {
            f2 = abs;
            f3 = i6;
        }
        float f6 = f2 / f3;
        if (a3 != 0) {
            f4 = abs4;
            f5 = i5;
        } else {
            f4 = abs2;
            f5 = i6;
        }
        return (int) ((b(i, a2, this.s.getViewHorizontalDragRange(view)) * f6) + (b(i2, a3, this.s.getViewVerticalDragRange(view)) * (f4 / f5)));
    }

    private boolean b(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.r.abortAnimation();
            a(0);
            return false;
        }
        this.r.startScroll(left, top, i5, i6, a(this.t, i5, i6, i3, i4));
        a(2);
        return true;
    }

    private void c(int i) {
        float[] fArr = this.f2075e;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            float[] fArr6 = this.f2075e;
            if (fArr6 != null) {
                System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                float[] fArr7 = this.f2076f;
                System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                float[] fArr8 = this.f2077g;
                System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                float[] fArr9 = this.f2078h;
                System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                int[] iArr4 = this.i;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.j;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.k;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2075e = fArr2;
            this.f2076f = fArr3;
            this.f2077g = fArr4;
            this.f2078h = fArr5;
            this.i = iArr;
            this.j = iArr2;
            this.k = iArr3;
        }
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    private boolean d(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public void abort() {
        cancel();
        if (this.f2072b == 2) {
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            this.r.abortAnimation();
            int currX2 = this.r.getCurrX();
            int currY2 = this.r.getCurrY();
            this.s.onViewPositionChanged(this.t, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        a(0);
    }

    public void cancel() {
        this.f2074d = -1;
        a();
        VelocityTracker velocityTracker = this.m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.m = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() == this.v) {
            this.t = view;
            this.f2074d = i;
            this.s.onViewCaptured(view, i);
            a(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.v + ")");
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f2075e.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean continueSettling(boolean z) {
        if (this.f2072b == 2) {
            boolean computeScrollOffset = this.r.computeScrollOffset();
            int currX = this.r.getCurrX();
            int currY = this.r.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.t, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.t, top);
            }
            if (left != 0 || top != 0) {
                this.s.onViewPositionChanged(this.t, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.r.getFinalX() && currY == this.r.getFinalY()) {
                this.r.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.v.post(this.w);
                } else {
                    a(0);
                }
            }
        }
        return this.f2072b == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.v.getChildAt(this.s.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (this.u) {
            this.r.fling(this.t.getLeft(), this.t.getTop(), (int) this.m.getXVelocity(this.f2074d), (int) this.m.getYVelocity(this.f2074d), i, i3, i2, i4);
            a(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public int getActivePointerId() {
        return this.f2074d;
    }

    public View getCapturedView() {
        return this.t;
    }

    public int getEdgeSize() {
        return this.p;
    }

    public float getMinVelocity() {
        return this.o;
    }

    public int getTouchSlop() {
        return this.f2073c;
    }

    public int getViewDragState() {
        return this.f2072b;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.t, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.i.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.l) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.m == null) {
            this.m = VelocityTracker.obtain();
        }
        this.m.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            b(x, y, pointerId);
            a(findTopChildUnder, pointerId);
            int i3 = this.i[pointerId];
            int i4 = this.q;
            if ((i3 & i4) != 0) {
                this.s.onEdgeTouched(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f2072b == 1) {
                b();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.f2072b == 1) {
                if (d(this.f2074d)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f2074d);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f2077g;
                    int i5 = this.f2074d;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f2078h[i5]);
                    a(this.t.getLeft() + i6, this.t.getTop() + i7, i6, i7);
                    a(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (d(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f2 = x3 - this.f2075e[pointerId2];
                    float f3 = y3 - this.f2076f[pointerId2];
                    a(f2, f3, pointerId2);
                    if (this.f2072b != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                        if (a(findTopChildUnder2, f2, f3) && a(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            a(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f2072b == 1) {
                a(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            b(x4, y4, pointerId3);
            if (this.f2072b == 0) {
                a(findTopChildUnder((int) x4, (int) y4), pointerId3);
                int i8 = this.i[pointerId3];
                int i9 = this.q;
                if ((i8 & i9) != 0) {
                    this.s.onEdgeTouched(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
            if (isCapturedViewUnder((int) x4, (int) y4)) {
                a(this.t, pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f2072b == 1 && pointerId4 == this.f2074d) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.f2074d) {
                    View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.t;
                    if (findTopChildUnder3 == view && a(view, pointerId5)) {
                        i = this.f2074d;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                b();
            }
        }
        b(pointerId4);
    }

    public void setEdgeTrackingEnabled(int i) {
        this.q = i;
    }

    public void setMinVelocity(float f2) {
        this.o = f2;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.u) {
            return b(i, i2, (int) this.m.getXVelocity(this.f2074d), (int) this.m.getYVelocity(this.f2074d));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00dd, code lost:            if (r12 != r11) goto L139;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.t = view;
        this.f2074d = -1;
        boolean b2 = b(i, i2, 0, 0);
        if (!b2 && this.f2072b == 0 && this.t != null) {
            this.t = null;
        }
        return b2;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f2, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f2073c = (int) (create.f2073c * (1.0f / f2));
        return create;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f2 = this.f2077g[i2] - this.f2075e[i2];
        float f3 = this.f2078h[i2] - this.f2076f[i2];
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f2073c) : z2 && Math.abs(f3) > ((float) this.f2073c);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i3 = this.f2073c;
        return f4 > ((float) (i3 * i3));
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.i[i2]) != 0;
    }

    private int b(int i, int i2, int i3) {
        int abs;
        if (i == 0) {
            return 0;
        }
        int width = this.v.getWidth();
        float f2 = width / 2;
        float a2 = f2 + (a(Math.min(1.0f, Math.abs(i) / width)) * f2);
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(a2 / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    private int a(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    private float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
    }

    private float a(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    private void a(float f2, float f3) {
        this.u = true;
        this.s.onViewReleased(this.t, f2, f3);
        this.u = false;
        if (this.f2072b == 1) {
            a(0);
        }
    }

    private void b(int i) {
        if (this.f2075e == null || !isPointerDown(i)) {
            return;
        }
        this.f2075e[i] = 0.0f;
        this.f2076f[i] = 0.0f;
        this.f2077g[i] = 0.0f;
        this.f2078h[i] = 0.0f;
        this.i[i] = 0;
        this.j[i] = 0;
        this.k[i] = 0;
        this.l = ((1 << i) ^ (-1)) & this.l;
    }

    private void a() {
        float[] fArr = this.f2075e;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f2076f, 0.0f);
        Arrays.fill(this.f2077g, 0.0f);
        Arrays.fill(this.f2078h, 0.0f);
        Arrays.fill(this.i, 0);
        Arrays.fill(this.j, 0);
        Arrays.fill(this.k, 0);
        this.l = 0;
    }

    private void b(float f2, float f3, int i) {
        c(i);
        float[] fArr = this.f2075e;
        this.f2077g[i] = f2;
        fArr[i] = f2;
        float[] fArr2 = this.f2076f;
        this.f2078h[i] = f3;
        fArr2[i] = f3;
        this.i[i] = a((int) f2, (int) f3);
        this.l |= 1 << i;
    }

    private void a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (d(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2077g[pointerId] = x;
                this.f2078h[pointerId] = y;
            }
        }
    }

    private void b() {
        this.m.computeCurrentVelocity(1000, this.n);
        a(a(this.m.getXVelocity(this.f2074d), this.o, this.n), a(this.m.getYVelocity(this.f2074d), this.o, this.n));
    }

    void a(int i) {
        this.v.removeCallbacks(this.w);
        if (this.f2072b != i) {
            this.f2072b = i;
            this.s.onViewDragStateChanged(i);
            if (this.f2072b == 0) {
                this.t = null;
            }
        }
    }

    boolean a(View view, int i) {
        if (view == this.t && this.f2074d == i) {
            return true;
        }
        if (view == null || !this.s.tryCaptureView(view, i)) {
            return false;
        }
        this.f2074d = i;
        captureChildView(view, i);
        return true;
    }

    private void a(float f2, float f3, int i) {
        int i2 = a(f2, f3, i, 1) ? 1 : 0;
        if (a(f3, f2, i, 4)) {
            i2 |= 4;
        }
        if (a(f2, f3, i, 2)) {
            i2 |= 2;
        }
        if (a(f3, f2, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.j;
            iArr[i] = iArr[i] | i2;
            this.s.onEdgeDragStarted(i2, i);
        }
    }

    private boolean a(float f2, float f3, int i, int i2) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.i[i] & i2) != i2 || (this.q & i2) == 0 || (this.k[i] & i2) == i2 || (this.j[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f2073c;
        if (abs <= i3 && abs2 <= i3) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.s.onEdgeLock(i2)) {
            return (this.j[i] & i2) == 0 && abs > ((float) this.f2073c);
        }
        int[] iArr = this.k;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    private boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        boolean z = this.s.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.s.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f2) > ((float) this.f2073c) : z2 && Math.abs(f3) > ((float) this.f2073c);
        }
        float f4 = (f2 * f2) + (f3 * f3);
        int i = this.f2073c;
        return f4 > ((float) (i * i));
    }

    private void a(int i, int i2, int i3, int i4) {
        int left = this.t.getLeft();
        int top = this.t.getTop();
        if (i3 != 0) {
            i = this.s.clampViewPositionHorizontal(this.t, i, i3);
            ViewCompat.offsetLeftAndRight(this.t, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.s.clampViewPositionVertical(this.t, i2, i4);
            ViewCompat.offsetTopAndBottom(this.t, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.s.onViewPositionChanged(this.t, i5, i6, i5 - left, i6 - top);
    }

    private int a(int i, int i2) {
        int i3 = i < this.v.getLeft() + this.p ? 1 : 0;
        if (i2 < this.v.getTop() + this.p) {
            i3 |= 4;
        }
        if (i > this.v.getRight() - this.p) {
            i3 |= 2;
        }
        return i2 > this.v.getBottom() - this.p ? i3 | 8 : i3;
    }
}
