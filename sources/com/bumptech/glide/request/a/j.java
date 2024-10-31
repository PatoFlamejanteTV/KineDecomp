package com.bumptech.glide.request.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.g.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class j<T extends View, Z> extends com.bumptech.glide.request.a.a<Z> {

    /* renamed from: b */
    private static boolean f9082b;

    /* renamed from: c */
    private static Integer f9083c;

    /* renamed from: d */
    protected final T f9084d;

    /* renamed from: e */
    private final a f9085e;

    /* renamed from: f */
    private View.OnAttachStateChangeListener f9086f;

    /* renamed from: g */
    private boolean f9087g;

    /* renamed from: h */
    private boolean f9088h;

    public j(T t) {
        l.a(t);
        this.f9084d = t;
        this.f9085e = new a(t);
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9086f;
        if (onAttachStateChangeListener == null || this.f9088h) {
            return;
        }
        this.f9084d.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9088h = true;
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f9086f;
        if (onAttachStateChangeListener == null || !this.f9088h) {
            return;
        }
        this.f9084d.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.f9088h = false;
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void a(Drawable drawable) {
        super.a(drawable);
        c();
    }

    @Override // com.bumptech.glide.request.a.i
    public void b(h hVar) {
        this.f9085e.a(hVar);
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public com.bumptech.glide.request.c getRequest() {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof com.bumptech.glide.request.c) {
            return (com.bumptech.glide.request.c) b2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public T getView() {
        return this.f9084d;
    }

    public String toString() {
        return "Target for: " + this.f9084d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a */
        static Integer f9089a;

        /* renamed from: b */
        private final View f9090b;

        /* renamed from: c */
        private final List<h> f9091c = new ArrayList();

        /* renamed from: d */
        boolean f9092d;

        /* renamed from: e */
        private ViewTreeObserverOnPreDrawListenerC0057a f9093e;

        /* compiled from: ViewTarget.java */
        /* renamed from: com.bumptech.glide.request.a.j$a$a */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserverOnPreDrawListenerC0057a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            private final WeakReference<a> f9094a;

            ViewTreeObserverOnPreDrawListenerC0057a(a aVar) {
                this.f9094a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f9094a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f9090b = view;
        }

        private static int a(Context context) {
            if (f9089a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                l.a(windowManager);
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f9089a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f9089a.intValue();
        }

        private boolean a(int i) {
            return i > 0 || i == Integer.MIN_VALUE;
        }

        private void b(int i, int i2) {
            Iterator it = new ArrayList(this.f9091c).iterator();
            while (it.hasNext()) {
                ((h) it.next()).a(i, i2);
            }
        }

        private int c() {
            int paddingTop = this.f9090b.getPaddingTop() + this.f9090b.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f9090b.getLayoutParams();
            return a(this.f9090b.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f9090b.getPaddingLeft() + this.f9090b.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f9090b.getLayoutParams();
            return a(this.f9090b.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        void b(h hVar) {
            this.f9091c.remove(hVar);
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f9090b.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f9093e);
            }
            this.f9093e = null;
            this.f9091c.clear();
        }

        void a() {
            if (this.f9091c.isEmpty()) {
                return;
            }
            int d2 = d();
            int c2 = c();
            if (a(d2, c2)) {
                b(d2, c2);
                b();
            }
        }

        void a(h hVar) {
            int d2 = d();
            int c2 = c();
            if (a(d2, c2)) {
                hVar.a(d2, c2);
                return;
            }
            if (!this.f9091c.contains(hVar)) {
                this.f9091c.add(hVar);
            }
            if (this.f9093e == null) {
                ViewTreeObserver viewTreeObserver = this.f9090b.getViewTreeObserver();
                this.f9093e = new ViewTreeObserverOnPreDrawListenerC0057a(this);
                viewTreeObserver.addOnPreDrawListener(this.f9093e);
            }
        }

        private boolean a(int i, int i2) {
            return a(i) && a(i2);
        }

        private int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.f9092d && this.f9090b.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.f9090b.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f9090b.getContext());
        }
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void b(Drawable drawable) {
        super.b(drawable);
        this.f9085e.b();
        if (this.f9087g) {
            return;
        }
        d();
    }

    @Override // com.bumptech.glide.request.a.i
    public void a(h hVar) {
        this.f9085e.b(hVar);
    }

    @Override // com.bumptech.glide.request.a.a, com.bumptech.glide.request.a.i
    public void a(com.bumptech.glide.request.c cVar) {
        a((Object) cVar);
    }

    private void a(Object obj) {
        Integer num = f9083c;
        if (num == null) {
            f9082b = true;
            this.f9084d.setTag(obj);
        } else {
            this.f9084d.setTag(num.intValue(), obj);
        }
    }

    private Object b() {
        Integer num = f9083c;
        if (num == null) {
            return this.f9084d.getTag();
        }
        return this.f9084d.getTag(num.intValue());
    }
}
