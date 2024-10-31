package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class M implements Cloneable {

    /* renamed from: a */
    private static final int[] f537a = {2, 1, 3, 4};

    /* renamed from: b */
    private static final A f538b = new J();

    /* renamed from: c */
    private static ThreadLocal<ArrayMap<Animator, a>> f539c = new ThreadLocal<>();
    Q G;
    private b H;
    private ArrayMap<String, String> I;
    private ArrayList<V> w;
    private ArrayList<V> x;

    /* renamed from: d */
    private String f540d = getClass().getName();

    /* renamed from: e */
    private long f541e = -1;

    /* renamed from: f */
    long f542f = -1;

    /* renamed from: g */
    private TimeInterpolator f543g = null;

    /* renamed from: h */
    ArrayList<Integer> f544h = new ArrayList<>();
    ArrayList<View> i = new ArrayList<>();
    private ArrayList<String> j = null;
    private ArrayList<Class> k = null;
    private ArrayList<Integer> l = null;
    private ArrayList<View> m = null;
    private ArrayList<Class> n = null;
    private ArrayList<String> o = null;
    private ArrayList<Integer> p = null;
    private ArrayList<View> q = null;
    private ArrayList<Class> r = null;
    private W s = new W();
    private W t = new W();
    T u = null;
    private int[] v = f537a;
    private ViewGroup y = null;
    boolean z = false;
    private ArrayList<Animator> A = new ArrayList<>();
    private int B = 0;
    private boolean C = false;
    private boolean D = false;
    private ArrayList<c> E = null;
    private ArrayList<Animator> F = new ArrayList<>();
    private A J = f538b;

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        View f545a;

        /* renamed from: b */
        String f546b;

        /* renamed from: c */
        V f547c;

        /* renamed from: d */
        va f548d;

        /* renamed from: e */
        M f549e;

        a(View view, String str, M m, va vaVar, V v) {
            this.f545a = view;
            this.f546b = str;
            this.f547c = v;
            this.f548d = vaVar;
            this.f549e = m;
        }
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public static abstract class b {
    }

    /* compiled from: Transition.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(M m);

        void b(M m);

        void c(M m);

        void d(M m);
    }

    private static ArrayMap<Animator, a> n() {
        ArrayMap<Animator, a> arrayMap = f539c.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, a> arrayMap2 = new ArrayMap<>();
        f539c.set(arrayMap2);
        return arrayMap2;
    }

    public Animator a(ViewGroup viewGroup, V v, V v2) {
        return null;
    }

    public abstract void a(V v);

    public long b() {
        return this.f542f;
    }

    public TimeInterpolator c() {
        return this.f543g;
    }

    public abstract void c(V v);

    public M d(View view) {
        this.i.remove(view);
        return this;
    }

    public void e(View view) {
        if (this.C) {
            if (!this.D) {
                ArrayMap<Animator, a> n = n();
                int size = n.size();
                va d2 = ka.d(view);
                for (int i = size - 1; i >= 0; i--) {
                    a valueAt = n.valueAt(i);
                    if (valueAt.f545a != null && d2.equals(valueAt.f548d)) {
                        C0195a.b(n.keyAt(i));
                    }
                }
                ArrayList<c> arrayList = this.E;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.E.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((c) arrayList2.get(i2)).a(this);
                    }
                }
            }
            this.C = false;
        }
    }

    public long f() {
        return this.f541e;
    }

    public List<Integer> g() {
        return this.f544h;
    }

    public List<String> h() {
        return this.j;
    }

    public List<Class> i() {
        return this.k;
    }

    public List<View> j() {
        return this.i;
    }

    public String[] k() {
        return null;
    }

    public void l() {
        m();
        ArrayMap<Animator, a> n = n();
        Iterator<Animator> it = this.F.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (n.containsKey(next)) {
                m();
                a(next, n);
            }
        }
        this.F.clear();
        a();
    }

    public void m() {
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).c(this);
                }
            }
            this.D = false;
        }
        this.B++;
    }

    public String toString() {
        return a("");
    }

    private void c(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.l;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.m;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.n;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.n.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    V v = new V();
                    v.f561b = view;
                    if (z) {
                        c(v);
                    } else {
                        a(v);
                    }
                    v.f562c.add(this);
                    b(v);
                    if (z) {
                        a(this.s, view, v);
                    } else {
                        a(this.t, view, v);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.p;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.q;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.r;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.r.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                c(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    public M a(long j) {
        this.f542f = j;
        return this;
    }

    public M b(long j) {
        this.f541e = j;
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public M mo1clone() {
        try {
            M m = (M) super.clone();
            m.F = new ArrayList<>();
            m.s = new W();
            m.t = new W();
            m.w = null;
            m.x = null;
            return m;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String d() {
        return this.f540d;
    }

    private void a(ArrayMap<View, V> arrayMap, ArrayMap<View, V> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View view;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = longSparseArray.valueAt(i);
            if (valueAt != null && b(valueAt) && (view = longSparseArray2.get(longSparseArray.keyAt(i))) != null && b(view)) {
                V v = arrayMap.get(valueAt);
                V v2 = arrayMap2.get(view);
                if (v != null && v2 != null) {
                    this.w.add(v);
                    this.x.add(v2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void b(ArrayMap<View, V> arrayMap, ArrayMap<View, V> arrayMap2) {
        V remove;
        View view;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View keyAt = arrayMap.keyAt(size);
            if (keyAt != null && b(keyAt) && (remove = arrayMap2.remove(keyAt)) != null && (view = remove.f561b) != null && b(view)) {
                this.w.add(arrayMap.removeAt(size));
                this.x.add(remove);
            }
        }
    }

    public boolean b(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.l;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.m;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.n;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.n.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.o != null && ViewCompat.getTransitionName(view) != null && this.o.contains(ViewCompat.getTransitionName(view))) {
            return false;
        }
        if ((this.f544h.size() == 0 && this.i.size() == 0 && (((arrayList = this.k) == null || arrayList.isEmpty()) && ((arrayList2 = this.j) == null || arrayList2.isEmpty()))) || this.f544h.contains(Integer.valueOf(id)) || this.i.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.j;
        if (arrayList6 != null && arrayList6.contains(ViewCompat.getTransitionName(view))) {
            return true;
        }
        if (this.k != null) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                if (this.k.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void a(ArrayMap<View, V> arrayMap, ArrayMap<View, V> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && b(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && b(view)) {
                V v = arrayMap.get(valueAt);
                V v2 = arrayMap2.get(view);
                if (v != null && v2 != null) {
                    this.w.add(v);
                    this.x.add(v2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    public A e() {
        return this.J;
    }

    private void a(ArrayMap<View, V> arrayMap, ArrayMap<View, V> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i = 0; i < size; i++) {
            View valueAt = arrayMap3.valueAt(i);
            if (valueAt != null && b(valueAt) && (view = arrayMap4.get(arrayMap3.keyAt(i))) != null && b(view)) {
                V v = arrayMap.get(valueAt);
                V v2 = arrayMap2.get(view);
                if (v != null && v2 != null) {
                    this.w.add(v);
                    this.x.add(v2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    public void c(View view) {
        if (this.D) {
            return;
        }
        ArrayMap<Animator, a> n = n();
        int size = n.size();
        va d2 = ka.d(view);
        for (int i = size - 1; i >= 0; i--) {
            a valueAt = n.valueAt(i);
            if (valueAt.f545a != null && d2.equals(valueAt.f548d)) {
                C0195a.a(n.keyAt(i));
            }
        }
        ArrayList<c> arrayList = this.E;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.E.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((c) arrayList2.get(i2)).b(this);
            }
        }
        this.C = true;
    }

    public V b(View view, boolean z) {
        T t = this.u;
        if (t != null) {
            return t.b(view, z);
        }
        return (z ? this.s : this.t).f563a.get(view);
    }

    public M b(c cVar) {
        ArrayList<c> arrayList = this.E;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(cVar);
        if (this.E.size() == 0) {
            this.E = null;
        }
        return this;
    }

    private void a(ArrayMap<View, V> arrayMap, ArrayMap<View, V> arrayMap2) {
        for (int i = 0; i < arrayMap.size(); i++) {
            V valueAt = arrayMap.valueAt(i);
            if (b(valueAt.f561b)) {
                this.w.add(valueAt);
                this.x.add(null);
            }
        }
        for (int i2 = 0; i2 < arrayMap2.size(); i2++) {
            V valueAt2 = arrayMap2.valueAt(i2);
            if (b(valueAt2.f561b)) {
                this.x.add(valueAt2);
                this.w.add(null);
            }
        }
    }

    public void b(V v) {
        String[] a2;
        if (this.G == null || v.f560a.isEmpty() || (a2 = this.G.a()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= a2.length) {
                z = true;
                break;
            } else if (!v.f560a.containsKey(a2[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.G.a(v);
    }

    private void a(W w, W w2) {
        ArrayMap<View, V> arrayMap = new ArrayMap<>(w.f563a);
        ArrayMap<View, V> arrayMap2 = new ArrayMap<>(w2.f563a);
        int i = 0;
        while (true) {
            int[] iArr = this.v;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    b(arrayMap, arrayMap2);
                } else if (i2 == 2) {
                    a(arrayMap, arrayMap2, w.f566d, w2.f566d);
                } else if (i2 == 3) {
                    a(arrayMap, arrayMap2, w.f564b, w2.f564b);
                } else if (i2 == 4) {
                    a(arrayMap, arrayMap2, w.f565c, w2.f565c);
                }
                i++;
            } else {
                a(arrayMap, arrayMap2);
                return;
            }
        }
    }

    public void a(ViewGroup viewGroup, W w, W w2, ArrayList<V> arrayList, ArrayList<V> arrayList2) {
        Animator a2;
        int i;
        int i2;
        View view;
        Animator animator;
        V v;
        Animator animator2;
        V v2;
        ArrayMap<Animator, a> n = n();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = Long.MAX_VALUE;
        int i3 = 0;
        while (i3 < size) {
            V v3 = arrayList.get(i3);
            V v4 = arrayList2.get(i3);
            if (v3 != null && !v3.f562c.contains(this)) {
                v3 = null;
            }
            if (v4 != null && !v4.f562c.contains(this)) {
                v4 = null;
            }
            if (v3 != null || v4 != null) {
                if ((v3 == null || v4 == null || a(v3, v4)) && (a2 = a(viewGroup, v3, v4)) != null) {
                    if (v4 != null) {
                        view = v4.f561b;
                        String[] k = k();
                        if (view == null || k == null || k.length <= 0) {
                            i = size;
                            i2 = i3;
                            animator2 = a2;
                            v2 = null;
                        } else {
                            v2 = new V();
                            v2.f561b = view;
                            i = size;
                            V v5 = w2.f563a.get(view);
                            if (v5 != null) {
                                int i4 = 0;
                                while (i4 < k.length) {
                                    v2.f560a.put(k[i4], v5.f560a.get(k[i4]));
                                    i4++;
                                    i3 = i3;
                                    v5 = v5;
                                }
                            }
                            i2 = i3;
                            int size2 = n.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = a2;
                                    break;
                                }
                                a aVar = n.get(n.keyAt(i5));
                                if (aVar.f547c != null && aVar.f545a == view && aVar.f546b.equals(d()) && aVar.f547c.equals(v2)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        }
                        animator = animator2;
                        v = v2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = v3.f561b;
                        animator = a2;
                        v = null;
                    }
                    if (animator != null) {
                        Q q = this.G;
                        if (q != null) {
                            long a3 = q.a(viewGroup, this, v3, v4);
                            sparseIntArray.put(this.F.size(), (int) a3);
                            j = Math.min(a3, j);
                        }
                        n.put(animator, new a(view, d(), this, ka.d(viewGroup), v));
                        this.F.add(animator);
                        j = j;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (j != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.F.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((sparseIntArray.valueAt(i6) - j) + animator3.getStartDelay());
            }
        }
    }

    private void a(Animator animator, ArrayMap<Animator, a> arrayMap) {
        if (animator != null) {
            animator.addListener(new K(this, arrayMap));
            a(animator);
        }
    }

    public M a(View view) {
        this.i.add(view);
        return this;
    }

    public void a(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        ArrayMap<String, String> arrayMap;
        a(z);
        if ((this.f544h.size() <= 0 && this.i.size() <= 0) || (((arrayList = this.j) != null && !arrayList.isEmpty()) || ((arrayList2 = this.k) != null && !arrayList2.isEmpty()))) {
            c(viewGroup, z);
        } else {
            for (int i = 0; i < this.f544h.size(); i++) {
                View findViewById = viewGroup.findViewById(this.f544h.get(i).intValue());
                if (findViewById != null) {
                    V v = new V();
                    v.f561b = findViewById;
                    if (z) {
                        c(v);
                    } else {
                        a(v);
                    }
                    v.f562c.add(this);
                    b(v);
                    if (z) {
                        a(this.s, findViewById, v);
                    } else {
                        a(this.t, findViewById, v);
                    }
                }
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                View view = this.i.get(i2);
                V v2 = new V();
                v2.f561b = view;
                if (z) {
                    c(v2);
                } else {
                    a(v2);
                }
                v2.f562c.add(this);
                b(v2);
                if (z) {
                    a(this.s, view, v2);
                } else {
                    a(this.t, view, v2);
                }
            }
        }
        if (z || (arrayMap = this.I) == null) {
            return;
        }
        int size = arrayMap.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.s.f566d.remove(this.I.keyAt(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.s.f566d.put(this.I.valueAt(i4), view2);
            }
        }
    }

    private static void a(W w, View view, V v) {
        w.f563a.put(view, v);
        int id = view.getId();
        if (id >= 0) {
            if (w.f564b.indexOfKey(id) >= 0) {
                w.f564b.put(id, null);
            } else {
                w.f564b.put(id, view);
            }
        }
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            if (w.f566d.containsKey(transitionName)) {
                w.f566d.put(transitionName, null);
            } else {
                w.f566d.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (w.f565c.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = w.f565c.get(itemIdAtPosition);
                    if (view2 != null) {
                        ViewCompat.setHasTransientState(view2, false);
                        w.f565c.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.setHasTransientState(view, true);
                w.f565c.put(itemIdAtPosition, view);
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            this.s.f563a.clear();
            this.s.f564b.clear();
            this.s.f565c.clear();
        } else {
            this.t.f563a.clear();
            this.t.f564b.clear();
            this.t.f565c.clear();
        }
    }

    public V a(View view, boolean z) {
        T t = this.u;
        if (t != null) {
            return t.a(view, z);
        }
        ArrayList<V> arrayList = z ? this.w : this.x;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            V v = arrayList.get(i2);
            if (v == null) {
                return null;
            }
            if (v.f561b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.x : this.w).get(i);
        }
        return null;
    }

    public void a(ViewGroup viewGroup) {
        a aVar;
        this.w = new ArrayList<>();
        this.x = new ArrayList<>();
        a(this.s, this.t);
        ArrayMap<Animator, a> n = n();
        int size = n.size();
        va d2 = ka.d(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator keyAt = n.keyAt(i);
            if (keyAt != null && (aVar = n.get(keyAt)) != null && aVar.f545a != null && d2.equals(aVar.f548d)) {
                V v = aVar.f547c;
                View view = aVar.f545a;
                V b2 = b(view, true);
                V a2 = a(view, true);
                if (!(b2 == null && a2 == null) && aVar.f549e.a(v, a2)) {
                    if (!keyAt.isRunning() && !keyAt.isStarted()) {
                        n.remove(keyAt);
                    } else {
                        keyAt.cancel();
                    }
                }
            }
        }
        a(viewGroup, this.s, this.t, this.w, this.x);
        l();
    }

    public boolean a(V v, V v2) {
        if (v == null || v2 == null) {
            return false;
        }
        String[] k = k();
        if (k != null) {
            for (String str : k) {
                if (!a(v, v2, str)) {
                }
            }
            return false;
        }
        Iterator<String> it = v.f560a.keySet().iterator();
        while (it.hasNext()) {
            if (a(v, v2, it.next())) {
            }
        }
        return false;
        return true;
    }

    private static boolean a(V v, V v2, String str) {
        Object obj = v.f560a.get(str);
        Object obj2 = v2.f560a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    protected void a(Animator animator) {
        if (animator == null) {
            a();
            return;
        }
        if (b() >= 0) {
            animator.setDuration(b());
        }
        if (f() >= 0) {
            animator.setStartDelay(f());
        }
        if (c() != null) {
            animator.setInterpolator(c());
        }
        animator.addListener(new L(this));
        animator.start();
    }

    public void a() {
        this.B--;
        if (this.B == 0) {
            ArrayList<c> arrayList = this.E;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.E.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((c) arrayList2.get(i)).d(this);
                }
            }
            for (int i2 = 0; i2 < this.s.f565c.size(); i2++) {
                View valueAt = this.s.f565c.valueAt(i2);
                if (valueAt != null) {
                    ViewCompat.setHasTransientState(valueAt, false);
                }
            }
            for (int i3 = 0; i3 < this.t.f565c.size(); i3++) {
                View valueAt2 = this.t.f565c.valueAt(i3);
                if (valueAt2 != null) {
                    ViewCompat.setHasTransientState(valueAt2, false);
                }
            }
            this.D = true;
        }
    }

    public M a(c cVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(cVar);
        return this;
    }

    public void a(b bVar) {
        this.H = bVar;
    }

    public String a(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f542f != -1) {
            str2 = str2 + "dur(" + this.f542f + ") ";
        }
        if (this.f541e != -1) {
            str2 = str2 + "dly(" + this.f541e + ") ";
        }
        if (this.f543g != null) {
            str2 = str2 + "interp(" + this.f543g + ") ";
        }
        if (this.f544h.size() <= 0 && this.i.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f544h.size() > 0) {
            String str4 = str3;
            for (int i = 0; i < this.f544h.size(); i++) {
                if (i > 0) {
                    str4 = str4 + ", ";
                }
                str4 = str4 + this.f544h.get(i);
            }
            str3 = str4;
        }
        if (this.i.size() > 0) {
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.i.get(i2);
            }
        }
        return str3 + ")";
    }
}
