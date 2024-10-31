package android.support.transition;

import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class P {

    /* renamed from: a, reason: collision with root package name */
    private static M f552a = new C0199e();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<M>>>> f553b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<ViewGroup> f554c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TransitionManager.java */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        M f555a;

        /* renamed from: b, reason: collision with root package name */
        ViewGroup f556b;

        a(M m, ViewGroup viewGroup) {
            this.f555a = m;
            this.f556b = viewGroup;
        }

        private void a() {
            this.f556b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f556b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!P.f554c.remove(this.f556b)) {
                return true;
            }
            ArrayMap<ViewGroup, ArrayList<M>> b2 = P.b();
            ArrayList<M> arrayList = b2.get(this.f556b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b2.put(this.f556b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f555a);
            this.f555a.a(new O(this, b2));
            this.f555a.a(this.f556b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((M) it.next()).e(this.f556b);
                }
            }
            this.f555a.a(this.f556b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            P.f554c.remove(this.f556b);
            ArrayList<M> arrayList = P.b().get(this.f556b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<M> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().e(this.f556b);
                }
            }
            this.f555a.a(true);
        }
    }

    static ArrayMap<ViewGroup, ArrayList<M>> b() {
        WeakReference<ArrayMap<ViewGroup, ArrayList<M>>> weakReference = f553b.get();
        if (weakReference == null || weakReference.get() == null) {
            WeakReference<ArrayMap<ViewGroup, ArrayList<M>>> weakReference2 = new WeakReference<>(new ArrayMap());
            f553b.set(weakReference2);
            weakReference = weakReference2;
        }
        return weakReference.get();
    }

    private static void c(ViewGroup viewGroup, M m) {
        ArrayList<M> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<M> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().c(viewGroup);
            }
        }
        if (m != null) {
            m.a(viewGroup, true);
        }
        I a2 = I.a(viewGroup);
        if (a2 != null) {
            a2.a();
        }
    }

    public static void a(ViewGroup viewGroup, M m) {
        if (f554c.contains(viewGroup) || !ViewCompat.isLaidOut(viewGroup)) {
            return;
        }
        f554c.add(viewGroup);
        if (m == null) {
            m = f552a;
        }
        M mo1clone = m.mo1clone();
        c(viewGroup, mo1clone);
        I.a(viewGroup, null);
        b(viewGroup, mo1clone);
    }

    private static void b(ViewGroup viewGroup, M m) {
        if (m == null || viewGroup == null) {
            return;
        }
        a aVar = new a(m, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }
}
