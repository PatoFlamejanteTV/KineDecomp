package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.g.y;
import android.support.v7.b.a;
import android.support.v7.internal.widget.p;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Method f215a;
    private Handler A;
    private Rect B;
    private boolean C;
    private int D;
    int b;
    private Context c;
    private PopupWindow d;
    private ListAdapter e;
    private a f;
    private int g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    private int l;
    private boolean m;
    private boolean n;
    private View o;
    private int p;
    private DataSetObserver q;
    private View r;
    private Drawable s;
    private AdapterView.OnItemClickListener t;
    private AdapterView.OnItemSelectedListener u;
    private final g v;
    private final ViewOnTouchListenerC0022f w;
    private final e x;
    private final c y;
    private Runnable z;

    static {
        try {
            f215a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
    }

    public f(Context context) {
        this(context, null, a.C0016a.listPopupWindowStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i, int i2) {
        android.support.v7.widget.g gVar = null;
        this.g = -2;
        this.h = -2;
        this.l = 0;
        this.m = false;
        this.n = false;
        this.b = Integer.MAX_VALUE;
        this.p = 0;
        this.v = new g(this, gVar);
        this.w = new ViewOnTouchListenerC0022f(this, gVar);
        this.x = new e(this, gVar);
        this.y = new c(this, gVar);
        this.A = new Handler();
        this.B = new Rect();
        this.c = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.ListPopupWindow, i, i2);
        this.i = obtainStyledAttributes.getDimensionPixelOffset(a.i.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.j = obtainStyledAttributes.getDimensionPixelOffset(a.i.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.j != 0) {
            this.k = true;
        }
        obtainStyledAttributes.recycle();
        this.d = new android.support.v7.internal.widget.k(context, attributeSet, i);
        this.d.setInputMethodMode(1);
        this.D = android.support.v4.e.c.a(this.c.getResources().getConfiguration().locale);
    }

    public void a(ListAdapter listAdapter) {
        if (this.q == null) {
            this.q = new d(this, null);
        } else if (this.e != null) {
            this.e.unregisterDataSetObserver(this.q);
        }
        this.e = listAdapter;
        if (this.e != null) {
            listAdapter.registerDataSetObserver(this.q);
        }
        if (this.f != null) {
            this.f.setAdapter(this.e);
        }
    }

    public void a(int i) {
        this.p = i;
    }

    public void a(boolean z) {
        this.C = z;
        this.d.setFocusable(z);
    }

    public void a(Drawable drawable) {
        this.d.setBackgroundDrawable(drawable);
    }

    public View d() {
        return this.r;
    }

    public void a(View view) {
        this.r = view;
    }

    public void b(int i) {
        this.l = i;
    }

    public void c(int i) {
        this.h = i;
    }

    public void d(int i) {
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            this.h = this.B.left + this.B.right + i;
        } else {
            c(i);
        }
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.t = onItemClickListener;
    }

    public void c() {
        int i;
        int i2;
        int i3;
        boolean z = false;
        int i4 = i();
        boolean f = f();
        if (this.d.isShowing()) {
            if (this.h == -1) {
                i3 = -1;
            } else if (this.h == -2) {
                i3 = d().getWidth();
            } else {
                i3 = this.h;
            }
            if (this.g == -1) {
                if (!f) {
                    i4 = -1;
                }
                if (f) {
                    this.d.setWindowLayoutMode(this.h != -1 ? 0 : -1, 0);
                } else {
                    this.d.setWindowLayoutMode(this.h == -1 ? -1 : 0, -1);
                }
            } else if (this.g != -2) {
                i4 = this.g;
            }
            PopupWindow popupWindow = this.d;
            if (!this.n && !this.m) {
                z = true;
            }
            popupWindow.setOutsideTouchable(z);
            this.d.update(d(), this.i, this.j, i3, i4);
            return;
        }
        if (this.h == -1) {
            i = -1;
        } else if (this.h == -2) {
            this.d.setWidth(d().getWidth());
            i = 0;
        } else {
            this.d.setWidth(this.h);
            i = 0;
        }
        if (this.g == -1) {
            i2 = -1;
        } else if (this.g == -2) {
            this.d.setHeight(i4);
            i2 = 0;
        } else {
            this.d.setHeight(this.g);
            i2 = 0;
        }
        this.d.setWindowLayoutMode(i, i2);
        b(true);
        this.d.setOutsideTouchable((this.n || this.m) ? false : true);
        this.d.setTouchInterceptor(this.w);
        android.support.v4.widget.e.a(this.d, d(), this.i, this.j, this.l);
        this.f.setSelection(-1);
        if (!this.C || this.f.isInTouchMode()) {
            e();
        }
        if (!this.C) {
            this.A.post(this.y);
        }
    }

    public void a() {
        this.d.dismiss();
        h();
        this.d.setContentView(null);
        this.f = null;
        this.A.removeCallbacks(this.v);
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.d.setOnDismissListener(onDismissListener);
    }

    private void h() {
        if (this.o != null) {
            ViewParent parent = this.o.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.o);
            }
        }
    }

    public void e(int i) {
        this.d.setInputMethodMode(i);
    }

    public void e() {
        a aVar = this.f;
        if (aVar == null) {
            return;
        }
        aVar.f = true;
        aVar.requestLayout();
    }

    public boolean b() {
        return this.d.isShowing();
    }

    public boolean f() {
        return this.d.getInputMethodMode() == 2;
    }

    public ListView g() {
        return this.f;
    }

    private int i() {
        int i;
        int i2;
        int makeMeasureSpec;
        View view;
        int i3;
        if (this.f == null) {
            Context context = this.c;
            this.z = new h(this);
            this.f = new a(context, !this.C);
            if (this.s != null) {
                this.f.setSelector(this.s);
            }
            this.f.setAdapter(this.e);
            this.f.setOnItemClickListener(this.t);
            this.f.setFocusable(true);
            this.f.setFocusableInTouchMode(true);
            this.f.setOnItemSelectedListener(new i(this));
            this.f.setOnScrollListener(this.x);
            if (this.u != null) {
                this.f.setOnItemSelectedListener(this.u);
            }
            View view2 = this.f;
            View view3 = this.o;
            if (view3 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.p) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.p);
                        break;
                }
                view3.measure(View.MeasureSpec.makeMeasureSpec(this.h, NexEditorDeviceProfile.UNKNOWN), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                i3 = layoutParams2.bottomMargin + view3.getMeasuredHeight() + layoutParams2.topMargin;
                view = linearLayout;
            } else {
                view = view2;
                i3 = 0;
            }
            this.d.setContentView(view);
            i = i3;
        } else {
            View view4 = this.o;
            if (view4 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view4.getLayoutParams();
                i = layoutParams3.bottomMargin + view4.getMeasuredHeight() + layoutParams3.topMargin;
            } else {
                i = 0;
            }
        }
        Drawable background = this.d.getBackground();
        if (background != null) {
            background.getPadding(this.B);
            int i4 = this.B.top + this.B.bottom;
            if (this.k) {
                i2 = i4;
            } else {
                this.j = -this.B.top;
                i2 = i4;
            }
        } else {
            this.B.setEmpty();
            i2 = 0;
        }
        if (this.d.getInputMethodMode() == 2) {
        }
        int maxAvailableHeight = this.d.getMaxAvailableHeight(d(), this.j);
        if (this.m || this.g == -1) {
            return maxAvailableHeight + i2;
        }
        switch (this.h) {
            case -2:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), NexEditorDeviceProfile.UNKNOWN);
                break;
            case -1:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.c.getResources().getDisplayMetrics().widthPixels - (this.B.left + this.B.right), 1073741824);
                break;
            default:
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.h, 1073741824);
                break;
        }
        int a2 = this.f.a(makeMeasureSpec, 0, -1, maxAvailableHeight - i, -1);
        if (a2 > 0) {
            i += i2;
        }
        return a2 + i;
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public static abstract class b implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private final float f216a;
        private final View d;
        private Runnable e;
        private Runnable f;
        private boolean g;
        private boolean h;
        private int i;
        private final int[] j = new int[2];
        private final int b = ViewConfiguration.getTapTimeout();
        private final int c = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;

        public abstract f a();

        public b(View view) {
            this.d = view;
            this.f216a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean z;
            boolean z2 = this.g;
            if (z2) {
                if (this.h) {
                    z = b(motionEvent);
                } else {
                    z = b(motionEvent) || !c();
                }
            } else {
                boolean z3 = a(motionEvent) && b();
                if (z3) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                z = z3;
            }
            this.g = z;
            return z || z2;
        }

        protected boolean b() {
            f a2 = a();
            if (a2 != null && !a2.b()) {
                a2.c();
                return true;
            }
            return true;
        }

        protected boolean c() {
            f a2 = a();
            if (a2 != null && a2.b()) {
                a2.a();
                return true;
            }
            return true;
        }

        private boolean a(MotionEvent motionEvent) {
            android.support.v7.widget.g gVar = null;
            View view = this.d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (android.support.v4.g.n.a(motionEvent)) {
                case 0:
                    this.i = motionEvent.getPointerId(0);
                    this.h = false;
                    if (this.e == null) {
                        this.e = new a(this, gVar);
                    }
                    view.postDelayed(this.e, this.b);
                    if (this.f == null) {
                        this.f = new RunnableC0021b(this, gVar);
                    }
                    view.postDelayed(this.f, this.c);
                    return false;
                case 1:
                case 3:
                    d();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.i);
                    if (findPointerIndex < 0 || a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f216a)) {
                        return false;
                    }
                    d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private void d() {
            if (this.f != null) {
                this.d.removeCallbacks(this.f);
            }
            if (this.e != null) {
                this.d.removeCallbacks(this.e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            d();
            View view = this.d;
            if (view.isEnabled() && !view.isLongClickable() && b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.g = true;
                this.h = true;
            }
        }

        private boolean b(MotionEvent motionEvent) {
            a aVar;
            View view = this.d;
            f a2 = a();
            if (a2 == null || !a2.b() || (aVar = a2.f) == null || !aVar.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            b(view, obtainNoHistory);
            a(aVar, obtainNoHistory);
            boolean a3 = aVar.a(obtainNoHistory, this.i);
            obtainNoHistory.recycle();
            int a4 = android.support.v4.g.n.a(motionEvent);
            return a3 && (a4 != 1 && a4 != 3);
        }

        private static boolean a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean a(View view, MotionEvent motionEvent) {
            view.getLocationOnScreen(this.j);
            motionEvent.offsetLocation(-r0[0], -r0[1]);
            return true;
        }

        private boolean b(View view, MotionEvent motionEvent) {
            view.getLocationOnScreen(this.j);
            motionEvent.offsetLocation(r0[0], r0[1]);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ListPopupWindow.java */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            private a() {
            }

            /* synthetic */ a(b bVar, android.support.v7.widget.g gVar) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ListPopupWindow.java */
        /* renamed from: android.support.v7.widget.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0021b implements Runnable {
            private RunnableC0021b() {
            }

            /* synthetic */ RunnableC0021b(b bVar, android.support.v7.widget.g gVar) {
                this();
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public static class a extends p {
        private boolean f;
        private boolean g;
        private boolean h;
        private y i;
        private android.support.v4.widget.d j;

        public a(Context context, boolean z) {
            super(context, null, a.C0016a.dropDownListViewStyle);
            this.g = z;
            setCacheColorHint(0);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(android.view.MotionEvent r9, int r10) {
            /*
                r8 = this;
                r2 = 1
                r1 = 0
                int r3 = android.support.v4.g.n.a(r9)
                switch(r3) {
                    case 1: goto L2d;
                    case 2: goto L6a;
                    case 3: goto L2a;
                    default: goto L9;
                }
            L9:
                r0 = r1
                r3 = r2
            Lb:
                if (r3 == 0) goto Lf
                if (r0 == 0) goto L12
            Lf:
                r8.d()
            L12:
                if (r3 == 0) goto L60
                android.support.v4.widget.d r0 = r8.j
                if (r0 != 0) goto L1f
                android.support.v4.widget.d r0 = new android.support.v4.widget.d
                r0.<init>(r8)
                r8.j = r0
            L1f:
                android.support.v4.widget.d r0 = r8.j
                r0.a(r2)
                android.support.v4.widget.d r0 = r8.j
                r0.onTouch(r8, r9)
            L29:
                return r3
            L2a:
                r0 = r1
                r3 = r1
                goto Lb
            L2d:
                r0 = r1
            L2e:
                int r4 = r9.findPointerIndex(r10)
                if (r4 >= 0) goto L37
                r0 = r1
                r3 = r1
                goto Lb
            L37:
                float r5 = r9.getX(r4)
                int r5 = (int) r5
                float r4 = r9.getY(r4)
                int r4 = (int) r4
                int r6 = r8.pointToPosition(r5, r4)
                r7 = -1
                if (r6 != r7) goto L4b
                r3 = r0
                r0 = r2
                goto Lb
            L4b:
                int r0 = r8.getFirstVisiblePosition()
                int r0 = r6 - r0
                android.view.View r0 = r8.getChildAt(r0)
                float r5 = (float) r5
                float r4 = (float) r4
                r8.a(r0, r6, r5, r4)
                if (r3 != r2) goto L9
                r8.a(r0, r6)
                goto L9
            L60:
                android.support.v4.widget.d r0 = r8.j
                if (r0 == 0) goto L29
                android.support.v4.widget.d r0 = r8.j
                r0.a(r1)
                goto L29
            L6a:
                r0 = r2
                goto L2e
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.f.a.a(android.view.MotionEvent, int):boolean");
        }

        private void a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void d() {
            this.h = false;
            setPressed(false);
            drawableStateChanged();
            if (this.i != null) {
                this.i.a();
                this.i = null;
            }
        }

        private void a(View view, int i, float f, float f2) {
            this.h = true;
            setPressed(true);
            layoutChildren();
            setSelection(i);
            a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        @Override // android.support.v7.internal.widget.p
        protected boolean c() {
            return this.h || super.c();
        }

        @Override // android.view.View
        public boolean isInTouchMode() {
            return (this.g && this.f) || super.isInTouchMode();
        }

        @Override // android.view.View
        public boolean hasWindowFocus() {
            return this.g || super.hasWindowFocus();
        }

        @Override // android.view.View
        public boolean isFocused() {
            return this.g || super.isFocused();
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean hasFocus() {
            return this.g || super.hasFocus();
        }
    }

    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    private class d extends DataSetObserver {
        private d() {
        }

        /* synthetic */ d(f fVar, android.support.v7.widget.g gVar) {
            this();
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (f.this.b()) {
                f.this.c();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            f.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(f fVar, android.support.v7.widget.g gVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        private g() {
        }

        /* synthetic */ g(f fVar, android.support.v7.widget.g gVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f != null && f.this.f.getCount() > f.this.f.getChildCount() && f.this.f.getChildCount() <= f.this.b) {
                f.this.d.setInputMethodMode(2);
                f.this.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* renamed from: android.support.v7.widget.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnTouchListenerC0022f implements View.OnTouchListener {
        private ViewOnTouchListenerC0022f() {
        }

        /* synthetic */ ViewOnTouchListenerC0022f(f fVar, android.support.v7.widget.g gVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && f.this.d != null && f.this.d.isShowing() && x >= 0 && x < f.this.d.getWidth() && y >= 0 && y < f.this.d.getHeight()) {
                f.this.A.postDelayed(f.this.v, 250L);
                return false;
            }
            if (action == 1) {
                f.this.A.removeCallbacks(f.this.v);
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ListPopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements AbsListView.OnScrollListener {
        private e() {
        }

        /* synthetic */ e(f fVar, android.support.v7.widget.g gVar) {
            this();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !f.this.f() && f.this.d.getContentView() != null) {
                f.this.A.removeCallbacks(f.this.v);
                f.this.v.run();
            }
        }
    }

    private void b(boolean z) {
        if (f215a != null) {
            try {
                f215a.invoke(this.d, Boolean.valueOf(z));
            } catch (Exception e2) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }
}
