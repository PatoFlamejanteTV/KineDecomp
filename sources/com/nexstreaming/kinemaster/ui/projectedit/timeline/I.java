package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.animation.ValueAnimator;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.RecyclerView;
import android.transition.ArcMotion;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TimelineItemDragDecoration.java */
/* loaded from: classes2.dex */
public abstract class I<T extends Fa> extends A {
    private static final String l = "I";
    protected boolean m;
    protected boolean n;
    protected final Rect o;
    protected final InterfaceC2023d<T> p;
    protected float q;
    protected float r;
    protected int s;
    protected int t;
    protected int u;
    protected int v;
    protected final InterfaceC2024e w;
    private final a x;
    protected List<e> y;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: TimelineItemDragDecoration.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Interpolator interpolator);

        float b();

        void cancel();

        boolean isRunning();

        void start();
    }

    /* compiled from: TimelineItemDragDecoration.java */
    /* loaded from: classes2.dex */
    private final class b implements a, Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final View f22577a;

        /* renamed from: b, reason: collision with root package name */
        private int f22578b = 300;

        /* renamed from: c, reason: collision with root package name */
        private Interpolator f22579c;

        /* renamed from: d, reason: collision with root package name */
        private OverScroller f22580d;

        /* renamed from: e, reason: collision with root package name */
        private float f22581e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f22582f;

        b(View view) {
            this.f22577a = view;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.a
        public void a(Interpolator interpolator) {
            this.f22579c = interpolator;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.a
        public float b() {
            return this.f22581e;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.a
        public void cancel() {
            if (this.f22582f) {
                this.f22580d.abortAnimation();
                this.f22577a.invalidate();
                this.f22581e = 0.0f;
                this.f22582f = false;
            }
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.a
        public boolean isRunning() {
            return this.f22582f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f22582f && this.f22580d.computeScrollOffset()) {
                this.f22581e = this.f22580d.getCurrX() / 100.0f;
                this.f22577a.postOnAnimation(this);
            } else if (this.f22581e < 1.0f) {
                this.f22581e = 1.0f;
                this.f22577a.postOnAnimation(this);
            } else {
                this.f22582f = false;
            }
            this.f22577a.postInvalidateOnAnimation();
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.I.a
        public void start() {
            I.this.a(this);
            this.f22580d = new OverScroller(this.f22577a.getContext(), this.f22579c);
            this.f22580d.startScroll(0, 0, 100, 0, this.f22578b);
            this.f22577a.postOnAnimation(this);
            this.f22582f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimelineItemDragDecoration.java */
    /* loaded from: classes2.dex */
    public class c implements InterfaceC2023d<T> {

        /* renamed from: a, reason: collision with root package name */
        final T f22584a;

        /* renamed from: b, reason: collision with root package name */
        final float f22585b;

        /* renamed from: c, reason: collision with root package name */
        final float f22586c;

        /* renamed from: d, reason: collision with root package name */
        final float f22587d;

        /* renamed from: e, reason: collision with root package name */
        final float f22588e;

        /* renamed from: f, reason: collision with root package name */
        final Rect f22589f;

        /* renamed from: g, reason: collision with root package name */
        final float f22590g;

        /* renamed from: h, reason: collision with root package name */
        final float f22591h;

        c(T t, float f2, float f3, float f4, float f5, Rect rect) {
            this.f22584a = t;
            this.f22585b = f2;
            this.f22586c = f3;
            this.f22587d = f4;
            this.f22588e = f5;
            this.f22589f = new Rect(rect);
            this.f22590g = f2 - rect.left;
            this.f22591h = f3 - rect.top;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public float a() {
            return this.f22591h;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public float b() {
            return this.f22590g;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public float c() {
            return this.f22587d;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public float d() {
            return this.f22586c;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public float e() {
            return this.f22588e;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public Rect getBounds() {
            return this.f22589f;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2023d
        public T getItem() {
            return this.f22584a;
        }
    }

    /* compiled from: TimelineItemDragDecoration.java */
    /* loaded from: classes2.dex */
    protected class d implements InterfaceC2024e {
        d() {
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public int a() {
            return I.this.t;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public InterfaceC2023d b() {
            return I.this.p;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public int c() {
            return I.this.v;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public float d() {
            return I.this.q;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public int getAction() {
            return I.this.s;
        }

        @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2024e
        public Fa getItem() {
            return I.this.p.getItem();
        }
    }

    /* compiled from: TimelineItemDragDecoration.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a(I i, InterfaceC2024e interfaceC2024e);

        void b(I i, InterfaceC2024e interfaceC2024e);

        void c(I i, InterfaceC2024e interfaceC2024e);

        void d(I i, InterfaceC2024e interfaceC2024e);
    }

    public I(UniformTimelineView uniformTimelineView, T t, MotionEvent motionEvent) {
        super(uniformTimelineView, true);
        this.p = a((I<T>) t, motionEvent);
        this.o = new Rect(this.p.getBounds());
        this.s = 0;
        this.t = 0;
        this.w = new d();
        this.x = new b(uniformTimelineView);
    }

    private void I() {
        Log.d(l, "[dragDirChanged] dir: " + this.t);
    }

    private InterfaceC2023d<T> a(T t, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f2 = h().t;
        float f3 = h().u;
        Rect rect = new Rect();
        X a2 = a(t);
        if (a2 != null) {
            a2.itemView.getDrawingRect(rect);
            rect.offset(a2.itemView.getLeft(), a2.itemView.getTop());
        }
        return new c(t, x, y, f2, f3, rect);
    }

    protected void A() {
        this.s = 2;
        w();
    }

    protected void B() {
        this.s = 1;
        x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        RecyclerView.ItemAnimator itemAnimator = n().getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        n().stopScroll();
        if (n().isComputingLayout()) {
            n().postOnAnimation(new C(this));
        } else {
            n().removeItemDecoration(this);
        }
        n().setTimelineGuideVisibility(true);
        this.n = false;
        this.m = false;
        this.s = 3;
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
        this.s = this.u;
        z();
    }

    public void E() {
        H();
        G();
        n().postInvalidateOnAnimation();
    }

    public I F() {
        List<e> list = this.y;
        if (list != null) {
            list.clear();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G() {
        this.o.offsetTo((int) (this.q + 0.5f), (int) (this.r + 0.5f));
        int p = (int) ((p() - this.p.d()) + 0.5f);
        int i = p < 0 ? -1 : p > 0 ? 1 : 0;
        if (this.t != i) {
            this.t = i;
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H() {
        if (this.p.b() < i() / 2) {
            this.q = o() - this.p.b();
        } else if (this.p.getBounds().width() > i() && this.p.getBounds().width() - this.p.b() < i() / 2) {
            this.q = (o() - i()) + (this.p.getBounds().width() - this.p.b());
        } else {
            this.q = o() - (i() / 2);
        }
        this.r = p() - this.p.a();
    }

    protected abstract void a(a aVar);

    public void b(MotionEvent motionEvent) {
        if (this.m) {
            E();
            A();
        }
    }

    public void c(MotionEvent motionEvent) {
        if (this.m) {
            return;
        }
        E();
        n().addItemDecoration(this);
        this.n = false;
        this.m = true;
        this.x.start();
        B();
    }

    public void d(MotionEvent motionEvent) {
        if (this.m) {
            E();
            this.n = true;
            this.u = u();
            if (this.u != 0) {
                D();
            } else if (v()) {
                a(this.p.getBounds().left, this.p.getBounds().top).a((bolts.i) new B(this));
            } else {
                C();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    protected void r() {
        E();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a s() {
        return this.x;
    }

    public final T t() {
        return this.p.getItem();
    }

    protected abstract int u();

    protected boolean v() {
        return true;
    }

    protected void w() {
        List<e> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).a(this, this.w);
            }
        }
    }

    protected void x() {
        List<e> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).b(this, this.w);
            }
        }
    }

    protected void y() {
        List<e> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).c(this, this.w);
            }
        }
    }

    protected void z() {
        List<e> list = this.y;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.y.get(size).d(this, this.w);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void b() {
        if (this.m) {
            C();
        }
        super.b();
    }

    public I a(e eVar) {
        if (this.y == null) {
            this.y = new ArrayList();
        }
        if (eVar != null && !this.y.contains(eVar)) {
            this.y.add(eVar);
        }
        return this;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.A
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    b(motionEvent);
                    return;
                } else if (actionMasked != 3 && actionMasked != 4) {
                    return;
                }
            }
            d(motionEvent);
            return;
        }
        c(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bolts.p a(int i, int i2) {
        return a(i, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public bolts.p a(int i, int i2, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        bolts.q qVar = new bolts.q();
        float c2 = this.p.c() - h().t;
        float e2 = this.p.e() - h().u;
        float f2 = i;
        int i3 = (int) ((this.q - f2) - c2);
        float f3 = i2;
        int i4 = (int) ((this.r - f3) - e2);
        if (i3 == 0 && i4 == 0) {
            n().postOnAnimationDelayed(new D(this, qVar), 125L);
            return qVar.a();
        }
        float f4 = f2 + c2;
        float f5 = f3 + e2;
        ViewPropertyAnimator animate = n().animate();
        animate.setInterpolator(new FastOutSlowInInterpolator());
        animate.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 21) {
            animate.setUpdateListener(new E(this, new PathMeasure(new ArcMotion().getPath(i3, i4, 0.0f, 0.0f), false), f4, f5, animatorUpdateListener));
        }
        animate.withEndAction(new G(this, qVar));
        animate.setListener(new H(this, animate));
        animate.start();
        return qVar.a();
    }
}
