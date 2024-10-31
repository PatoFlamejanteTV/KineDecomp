package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.transition.C0196b;
import android.support.transition.M;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Visibility.java */
/* loaded from: classes.dex */
public abstract class sa extends M {
    private static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    private int L = 3;

    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class a extends AnimatorListenerAdapter implements M.c, C0196b.a {

        /* renamed from: a */
        private final View f633a;

        /* renamed from: b */
        private final int f634b;

        /* renamed from: c */
        private final ViewGroup f635c;

        /* renamed from: d */
        private final boolean f636d;

        /* renamed from: e */
        private boolean f637e;

        /* renamed from: f */
        boolean f638f = false;

        a(View view, int i, boolean z) {
            this.f633a = view;
            this.f634b = i;
            this.f635c = (ViewGroup) view.getParent();
            this.f636d = z;
            a(true);
        }

        @Override // android.support.transition.M.c
        public void a(M m) {
            a(true);
        }

        @Override // android.support.transition.M.c
        public void b(M m) {
            a(false);
        }

        @Override // android.support.transition.M.c
        public void c(M m) {
        }

        @Override // android.support.transition.M.c
        public void d(M m) {
            a();
            m.b(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f638f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, android.support.transition.C0196b.a
        public void onAnimationPause(Animator animator) {
            if (this.f638f) {
                return;
            }
            ka.a(this.f633a, this.f634b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, android.support.transition.C0196b.a
        public void onAnimationResume(Animator animator) {
            if (this.f638f) {
                return;
            }
            ka.a(this.f633a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        private void a() {
            if (!this.f638f) {
                ka.a(this.f633a, this.f634b);
                ViewGroup viewGroup = this.f635c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.f636d || this.f637e == z || (viewGroup = this.f635c) == null) {
                return;
            }
            this.f637e = z;
            aa.a(viewGroup, z);
        }
    }

    /* compiled from: Visibility.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        boolean f639a;

        /* renamed from: b */
        boolean f640b;

        /* renamed from: c */
        int f641c;

        /* renamed from: d */
        int f642d;

        /* renamed from: e */
        ViewGroup f643e;

        /* renamed from: f */
        ViewGroup f644f;

        private b() {
        }

        /* synthetic */ b(ra raVar) {
            this();
        }
    }

    private b b(V v, V v2) {
        b bVar = new b(null);
        bVar.f639a = false;
        bVar.f640b = false;
        if (v != null && v.f560a.containsKey("android:visibility:visibility")) {
            bVar.f641c = ((Integer) v.f560a.get("android:visibility:visibility")).intValue();
            bVar.f643e = (ViewGroup) v.f560a.get("android:visibility:parent");
        } else {
            bVar.f641c = -1;
            bVar.f643e = null;
        }
        if (v2 != null && v2.f560a.containsKey("android:visibility:visibility")) {
            bVar.f642d = ((Integer) v2.f560a.get("android:visibility:visibility")).intValue();
            bVar.f644f = (ViewGroup) v2.f560a.get("android:visibility:parent");
        } else {
            bVar.f642d = -1;
            bVar.f644f = null;
        }
        if (v != null && v2 != null) {
            if (bVar.f641c == bVar.f642d && bVar.f643e == bVar.f644f) {
                return bVar;
            }
            int i = bVar.f641c;
            int i2 = bVar.f642d;
            if (i != i2) {
                if (i == 0) {
                    bVar.f640b = false;
                    bVar.f639a = true;
                } else if (i2 == 0) {
                    bVar.f640b = true;
                    bVar.f639a = true;
                }
            } else if (bVar.f644f == null) {
                bVar.f640b = false;
                bVar.f639a = true;
            } else if (bVar.f643e == null) {
                bVar.f640b = true;
                bVar.f639a = true;
            }
        } else if (v == null && bVar.f642d == 0) {
            bVar.f640b = true;
            bVar.f639a = true;
        } else if (v2 == null && bVar.f641c == 0) {
            bVar.f640b = false;
            bVar.f639a = true;
        }
        return bVar;
    }

    private void d(V v) {
        v.f560a.put("android:visibility:visibility", Integer.valueOf(v.f561b.getVisibility()));
        v.f560a.put("android:visibility:parent", v.f561b.getParent());
        int[] iArr = new int[2];
        v.f561b.getLocationOnScreen(iArr);
        v.f560a.put("android:visibility:screenLocation", iArr);
    }

    public abstract Animator a(ViewGroup viewGroup, View view, V v, V v2);

    public void a(int i) {
        if ((i & (-4)) == 0) {
            this.L = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public abstract Animator b(ViewGroup viewGroup, View view, V v, V v2);

    @Override // android.support.transition.M
    public void c(V v) {
        d(v);
    }

    @Override // android.support.transition.M
    public String[] k() {
        return K;
    }

    @Override // android.support.transition.M
    public void a(V v) {
        d(v);
    }

    @Override // android.support.transition.M
    public Animator a(ViewGroup viewGroup, V v, V v2) {
        b b2 = b(v, v2);
        if (!b2.f639a) {
            return null;
        }
        if (b2.f643e == null && b2.f644f == null) {
            return null;
        }
        if (b2.f640b) {
            return a(viewGroup, v, b2.f641c, v2, b2.f642d);
        }
        return b(viewGroup, v, b2.f641c, v2, b2.f642d);
    }

    public Animator a(ViewGroup viewGroup, V v, int i, V v2, int i2) {
        if ((this.L & 1) != 1 || v2 == null) {
            return null;
        }
        if (v == null) {
            View view = (View) v2.f561b.getParent();
            if (b(a(view, false), b(view, false)).f639a) {
                return null;
            }
        }
        return a(viewGroup, v2.f561b, v, v2);
    }

    @Override // android.support.transition.M
    public boolean a(V v, V v2) {
        if (v == null && v2 == null) {
            return false;
        }
        if (v != null && v2 != null && v2.f560a.containsKey("android:visibility:visibility") != v.f560a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b b2 = b(v, v2);
        if (b2.f639a) {
            return b2.f641c == 0 || b2.f642d == 0;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator b(android.view.ViewGroup r7, android.support.transition.V r8, int r9, android.support.transition.V r10, int r11) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.transition.sa.b(android.view.ViewGroup, android.support.transition.V, int, android.support.transition.V, int):android.animation.Animator");
    }
}
