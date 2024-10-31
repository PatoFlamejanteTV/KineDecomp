package android.databinding;

import android.arch.lifecycle.Lifecycle;
import android.databinding.b;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public abstract class ViewDataBinding extends android.databinding.a {

    /* renamed from: b */
    static int f143b = Build.VERSION.SDK_INT;

    /* renamed from: c */
    private static final int f144c = 8;

    /* renamed from: d */
    private static final boolean f145d;

    /* renamed from: e */
    private static final a f146e;

    /* renamed from: f */
    private static final a f147f;

    /* renamed from: g */
    private static final a f148g;

    /* renamed from: h */
    private static final a f149h;
    private static final b.a<Object, ViewDataBinding, Void> i;
    private static final ReferenceQueue<ViewDataBinding> j;
    private static final View.OnAttachStateChangeListener k;
    private final Runnable l;
    private boolean m;
    private boolean n;
    private d[] o;
    private final View p;
    private android.databinding.b<Object, ViewDataBinding, Void> q;
    private boolean r;
    private Choreographer s;
    private final Choreographer.FrameCallback t;
    private Handler u;
    protected final android.databinding.d v;
    private ViewDataBinding w;
    private android.arch.lifecycle.e x;

    /* loaded from: classes.dex */
    static class OnStartListener implements android.arch.lifecycle.d {

        /* renamed from: a */
        final WeakReference<ViewDataBinding> f150a;

        @android.arch.lifecycle.n(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f150a.get();
            if (viewDataBinding != null) {
                viewDataBinding.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final String[][] f151a;

        /* renamed from: b */
        public final int[][] f152b;

        /* renamed from: c */
        public final int[][] f153c;
    }

    /* loaded from: classes.dex */
    public interface c<T> {
        void a(T t);
    }

    /* loaded from: classes.dex */
    public static class d<T> extends WeakReference<ViewDataBinding> {

        /* renamed from: a */
        private final c<T> f154a;

        /* renamed from: b */
        private T f155b;

        public boolean a() {
            boolean z;
            T t = this.f155b;
            if (t != null) {
                this.f154a.a(t);
                z = true;
            } else {
                z = false;
            }
            this.f155b = null;
            return z;
        }
    }

    static {
        f145d = f143b >= 16;
        f146e = new i();
        f147f = new j();
        f148g = new k();
        f149h = new l();
        i = new m();
        j = new ReferenceQueue<>();
        if (Build.VERSION.SDK_INT < 19) {
            k = null;
        } else {
            k = new n();
        }
    }

    protected ViewDataBinding(android.databinding.d dVar, View view, int i2) {
        this.l = new o(this);
        this.m = false;
        this.n = false;
        this.v = dVar;
        this.o = new d[i2];
        this.p = view;
        if (Looper.myLooper() != null) {
            if (f145d) {
                this.s = Choreographer.getInstance();
                this.t = new p(this);
                return;
            } else {
                this.t = null;
                this.u = new Handler(Looper.myLooper());
                return;
            }
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    private void h() {
        if (this.r) {
            g();
            return;
        }
        if (f()) {
            this.r = true;
            this.n = false;
            android.databinding.b<Object, ViewDataBinding, Void> bVar = this.q;
            if (bVar == null) {
                if (!this.n) {
                    c();
                    android.databinding.b<Object, ViewDataBinding, Void> bVar2 = this.q;
                    if (bVar2 != null) {
                        bVar2.a(this, 3, null);
                        throw null;
                    }
                }
                this.r = false;
                return;
            }
            bVar.a(this, 1, null);
            throw null;
        }
    }

    public static void i() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = j.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof d) {
                ((d) poll).a();
            }
        }
    }

    protected abstract void c();

    public void d() {
        ViewDataBinding viewDataBinding = this.w;
        if (viewDataBinding == null) {
            h();
        } else {
            viewDataBinding.d();
        }
    }

    public View e() {
        return this.p;
    }

    public abstract boolean f();

    public void g() {
        ViewDataBinding viewDataBinding = this.w;
        if (viewDataBinding != null) {
            viewDataBinding.g();
            return;
        }
        android.arch.lifecycle.e eVar = this.x;
        if (eVar == null || eVar.getLifecycle().a().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                if (f145d) {
                    this.s.postFrameCallback(this.t);
                } else {
                    this.u.post(this.l);
                }
            }
        }
    }

    public void b(View view) {
        view.setTag(c.b.b.a.a.dataBinding, this);
    }

    private static android.databinding.d a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof android.databinding.d) {
            return (android.databinding.d) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private static int b(String str, int i2) {
        int i3 = 0;
        while (i2 < str.length()) {
            i3 = (i3 * 10) + (str.charAt(i2) - '0');
            i2++;
        }
        return i3;
    }

    public static ViewDataBinding a(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(c.b.b.a.a.dataBinding);
        }
        return null;
    }

    public static Object[] a(android.databinding.d dVar, View view, int i2, b bVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i2];
        a(dVar, view, objArr, bVar, sparseIntArray, true);
        return objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.databinding.d r16, android.view.View r17, java.lang.Object[] r18, android.databinding.ViewDataBinding.b r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.databinding.ViewDataBinding.a(android.databinding.d, android.view.View, java.lang.Object[], android.databinding.ViewDataBinding$b, android.util.SparseIntArray, boolean):void");
    }

    public ViewDataBinding(Object obj, View view, int i2) {
        this(a(obj), view, i2);
    }

    private static int a(String str, int i2, b bVar, int i3) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = bVar.f151a[i3];
        int length = strArr.length;
        while (i2 < length) {
            if (TextUtils.equals(subSequence, strArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static int a(ViewGroup viewGroup, int i2) {
        String str = (String) viewGroup.getChildAt(i2).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i3 = i2 + 1; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i2;
                }
                if (a(str2, length)) {
                    i2 = i3;
                }
            }
        }
        return i2;
    }

    private static boolean a(String str, int i2) {
        int length = str.length();
        if (length == i2) {
            return false;
        }
        while (i2 < length) {
            if (!Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static <T extends ViewDataBinding> T a(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup, boolean z, Object obj) {
        return (T) e.a(layoutInflater, i2, viewGroup, z, a(obj));
    }
}
