package android.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.google.protos.datapol.SemanticAnnotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2768a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f2769b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    private final int f2770c;

    /* renamed from: d, reason: collision with root package name */
    private final int f2771d;

    /* renamed from: e, reason: collision with root package name */
    private final StateListDrawable f2772e;

    /* renamed from: f, reason: collision with root package name */
    private final Drawable f2773f;

    /* renamed from: g, reason: collision with root package name */
    private final int f2774g;

    /* renamed from: h, reason: collision with root package name */
    private final int f2775h;
    private final StateListDrawable i;
    private final Drawable j;
    private final int k;
    private final int l;
    int m;
    int n;
    float o;
    int p;
    int q;
    float r;
    private RecyclerView u;
    private int s = 0;
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];
    private final int[] A = new int[2];
    private final ValueAnimator B = ValueAnimator.ofFloat(0.0f, 1.0f);
    private int C = 0;
    private final Runnable D = new Runnable() { // from class: android.support.v7.widget.FastScroller.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.a(500);
        }
    };
    private final RecyclerView.OnScrollListener E = new RecyclerView.OnScrollListener() { // from class: android.support.v7.widget.FastScroller.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FastScroller.this.a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface AnimationState {
    }

    /* loaded from: classes.dex */
    private class AnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f2778a;

        private AnimatorListener() {
            this.f2778a = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2778a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2778a) {
                this.f2778a = false;
            } else if (((Float) FastScroller.this.B.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller.this.C = 0;
                FastScroller.this.c(0);
            } else {
                FastScroller.this.C = 2;
                FastScroller.this.f();
            }
        }
    }

    /* loaded from: classes.dex */
    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        private AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f2772e.setAlpha(floatValue);
            FastScroller.this.f2773f.setAlpha(floatValue);
            FastScroller.this.f();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface DragState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    private @interface State {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f2772e = stateListDrawable;
        this.f2773f = drawable;
        this.i = stateListDrawable2;
        this.j = drawable2;
        this.f2774g = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f2775h = Math.max(i, drawable.getIntrinsicWidth());
        this.k = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.l = Math.max(i, drawable2.getIntrinsicWidth());
        this.f2770c = i2;
        this.f2771d = i3;
        this.f2772e.setAlpha(255);
        this.f2773f.setAlpha(255);
        this.B.addListener(new AnimatorListener());
        this.B.addUpdateListener(new AnimatorUpdater());
        attachToRecyclerView(recyclerView);
    }

    private boolean e() {
        return ViewCompat.getLayoutDirection(this.u) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.u.invalidate();
    }

    private void g() {
        this.u.addItemDecoration(this);
        this.u.addOnItemTouchListener(this);
        this.u.addOnScrollListener(this.E);
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            b();
        }
        this.u = recyclerView;
        if (this.u != null) {
            g();
        }
    }

    public void hide() {
        a(0);
    }

    public boolean isDragging() {
        return this.x == 2;
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.s == this.u.getWidth() && this.t == this.u.getHeight()) {
            if (this.C != 0) {
                if (this.v) {
                    b(canvas);
                }
                if (this.w) {
                    a(canvas);
                    return;
                }
                return;
            }
            return;
        }
        this.s = this.u.getWidth();
        this.t = this.u.getHeight();
        c(0);
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.x;
        if (i == 1) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!b2 && !a2) {
                return false;
            }
            if (a2) {
                this.y = 1;
                this.r = (int) motionEvent.getX();
            } else if (b2) {
                this.y = 2;
                this.o = (int) motionEvent.getY();
            }
            c(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean b2 = b(motionEvent.getX(), motionEvent.getY());
            boolean a2 = a(motionEvent.getX(), motionEvent.getY());
            if (b2 || a2) {
                if (a2) {
                    this.y = 1;
                    this.r = (int) motionEvent.getX();
                } else if (b2) {
                    this.y = 2;
                    this.o = (int) motionEvent.getY();
                }
                c(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.x == 2) {
            this.o = 0.0f;
            this.r = 0.0f;
            c(1);
            this.y = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.x == 2) {
            show();
            if (this.y == 1) {
                a(motionEvent.getX());
            }
            if (this.y == 2) {
                b(motionEvent.getY());
            }
        }
    }

    public void show() {
        int i = this.C;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.B.cancel();
            }
        }
        this.C = 1;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.B.setDuration(500L);
        this.B.setStartDelay(0L);
        this.B.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        if (i == 2 && this.x != 2) {
            this.f2772e.setState(f2768a);
            a();
        }
        if (i == 0) {
            f();
        } else {
            show();
        }
        if (this.x == 2 && i != 2) {
            this.f2772e.setState(f2769b);
            b(SemanticAnnotations.SemanticType.ST_SPII_ID_VALUE);
        } else if (i == 1) {
            b(SemanticAnnotations.SemanticType.ST_SOFTWARE_ID_VALUE);
        }
        this.x = i;
    }

    private int[] d() {
        int[] iArr = this.z;
        int i = this.f2771d;
        iArr[0] = i;
        iArr[1] = this.t - i;
        return iArr;
    }

    private void b() {
        this.u.removeItemDecoration(this);
        this.u.removeOnItemTouchListener(this);
        this.u.removeOnScrollListener(this.E);
        a();
    }

    void a(int i) {
        int i2 = this.C;
        if (i2 == 1) {
            this.B.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.C = 3;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.B.setDuration(i);
        this.B.start();
    }

    private void b(int i) {
        a();
        this.u.postDelayed(this.D, i);
    }

    private void a() {
        this.u.removeCallbacks(this.D);
    }

    private void b(Canvas canvas) {
        int i = this.s;
        int i2 = this.f2774g;
        int i3 = i - i2;
        int i4 = this.n;
        int i5 = this.m;
        int i6 = i4 - (i5 / 2);
        this.f2772e.setBounds(0, 0, i2, i5);
        this.f2773f.setBounds(0, 0, this.f2775h, this.t);
        if (e()) {
            this.f2773f.draw(canvas);
            canvas.translate(this.f2774g, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f2772e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f2774g, -i6);
            return;
        }
        canvas.translate(i3, 0.0f);
        this.f2773f.draw(canvas);
        canvas.translate(0.0f, i6);
        this.f2772e.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    private void a(Canvas canvas) {
        int i = this.t;
        int i2 = this.k;
        int i3 = this.q;
        int i4 = this.p;
        this.i.setBounds(0, 0, i4, i2);
        this.j.setBounds(0, 0, this.s, this.l);
        canvas.translate(0.0f, i - i2);
        this.j.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.i.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private int[] c() {
        int[] iArr = this.A;
        int i = this.f2771d;
        iArr[0] = i;
        iArr[1] = this.s - i;
        return iArr;
    }

    void a(int i, int i2) {
        int computeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i3 = this.t;
        this.v = computeVerticalScrollRange - i3 > 0 && i3 >= this.f2770c;
        int computeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i4 = this.s;
        this.w = computeHorizontalScrollRange - i4 > 0 && i4 >= this.f2770c;
        if (!this.v && !this.w) {
            if (this.x != 0) {
                c(0);
                return;
            }
            return;
        }
        if (this.v) {
            float f2 = i3;
            this.n = (int) ((f2 * (i2 + (f2 / 2.0f))) / computeVerticalScrollRange);
            this.m = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
        }
        if (this.w) {
            float f3 = i4;
            this.q = (int) ((f3 * (i + (f3 / 2.0f))) / computeHorizontalScrollRange);
            this.p = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
        }
        int i5 = this.x;
        if (i5 == 0 || i5 == 1) {
            c(1);
        }
    }

    private void b(float f2) {
        int[] d2 = d();
        float max = Math.max(d2[0], Math.min(d2[1], f2));
        if (Math.abs(this.n - max) < 2.0f) {
            return;
        }
        int a2 = a(this.o, max, d2, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (a2 != 0) {
            this.u.scrollBy(0, a2);
        }
        this.o = max;
    }

    boolean b(float f2, float f3) {
        if (!e() ? f2 >= this.s - this.f2774g : f2 <= this.f2774g / 2) {
            int i = this.n;
            int i2 = this.m;
            if (f3 >= i - (i2 / 2) && f3 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    private void a(float f2) {
        int[] c2 = c();
        float max = Math.max(c2[0], Math.min(c2[1], f2));
        if (Math.abs(this.q - max) < 2.0f) {
            return;
        }
        int a2 = a(this.r, max, c2, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (a2 != 0) {
            this.u.scrollBy(a2, 0);
        }
        this.r = max;
    }

    private int a(float f2, float f3, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f3 - f2) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a(float f2, float f3) {
        if (f3 >= this.t - this.k) {
            int i = this.q;
            int i2 = this.p;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }
}
