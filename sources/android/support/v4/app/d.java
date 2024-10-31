package android.support.v4.app;

import android.os.Build;
import android.support.v4.app.x;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BackStackRecord.java */
/* loaded from: classes.dex */
public final class d extends w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f52a;
    final q b;
    a c;
    a d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    boolean l;
    String n;
    boolean o;
    int q;
    CharSequence r;
    int s;
    CharSequence t;
    ArrayList<String> u;
    ArrayList<String> v;
    boolean m = true;
    int p = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BackStackRecord.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        a f53a;
        a b;
        int c;
        Fragment d;
        int e;
        int f;
        int g;
        int h;
        ArrayList<Fragment> i;
    }

    static {
        f52a = Build.VERSION.SDK_INT >= 21;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.p >= 0) {
            sb.append(" #");
            sb.append(this.p);
        }
        if (this.n != null) {
            sb.append(" ");
            sb.append(this.n);
        }
        sb.append("}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        a(str, printWriter, true);
    }

    public void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.n);
            printWriter.print(" mIndex=");
            printWriter.print(this.p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.o);
            if (this.j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.k));
            }
            if (this.f != 0 || this.g != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.g));
            }
            if (this.h != 0 || this.i != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.i));
            }
            if (this.q != 0 || this.r != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.r);
            }
            if (this.s != 0 || this.t != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.t);
            }
        }
        if (this.c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str3 = str + "    ";
            int i = 0;
            a aVar = this.c;
            while (aVar != null) {
                switch (aVar.c) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    default:
                        str2 = "cmd=" + aVar.c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.d);
                if (z) {
                    if (aVar.e != 0 || aVar.f != 0) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.f));
                    }
                    if (aVar.g != 0 || aVar.h != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.h));
                    }
                }
                if (aVar.i != null && aVar.i.size() > 0) {
                    for (int i2 = 0; i2 < aVar.i.size(); i2++) {
                        printWriter.print(str3);
                        if (aVar.i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str3);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(aVar.i.get(i2));
                    }
                }
                aVar = aVar.f53a;
                i++;
            }
        }
    }

    public d(q qVar) {
        this.b = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        if (this.c == null) {
            this.d = aVar;
            this.c = aVar;
        } else {
            aVar.b = this.d;
            this.d.f53a = aVar;
            this.d = aVar;
        }
        aVar.e = this.f;
        aVar.f = this.g;
        aVar.g = this.h;
        aVar.h = this.i;
        this.e++;
    }

    @Override // android.support.v4.app.w
    public w a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.w
    public w a(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        fragment.mFragmentManager = this.b;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (i != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
            }
            fragment.mFragmentId = i;
            fragment.mContainerId = i;
        }
        a aVar = new a();
        aVar.c = i2;
        aVar.d = fragment;
        a(aVar);
    }

    @Override // android.support.v4.app.w
    public w a(Fragment fragment) {
        a aVar = new a();
        aVar.c = 3;
        aVar.d = fragment;
        a(aVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.l) {
            if (q.f62a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (a aVar = this.c; aVar != null; aVar = aVar.f53a) {
                if (aVar.d != null) {
                    aVar.d.mBackStackNesting += i;
                    if (q.f62a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.d + " to " + aVar.d.mBackStackNesting);
                    }
                }
                if (aVar.i != null) {
                    for (int size = aVar.i.size() - 1; size >= 0; size--) {
                        Fragment fragment = aVar.i.get(size);
                        fragment.mBackStackNesting += i;
                        if (q.f62a) {
                            Log.v("FragmentManager", "Bump nesting of " + fragment + " to " + fragment.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.w
    public int a() {
        return a(false);
    }

    @Override // android.support.v4.app.w
    public int b() {
        return a(true);
    }

    int a(boolean z) {
        if (this.o) {
            throw new IllegalStateException("commit already called");
        }
        if (q.f62a) {
            Log.v("FragmentManager", "Commit: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.f.e("FragmentManager")), (String[]) null);
        }
        this.o = true;
        if (this.l) {
            this.p = this.b.a(this);
        } else {
            this.p = -1;
        }
        this.b.a(this, z);
        return this.p;
    }

    @Override // java.lang.Runnable
    public void run() {
        b bVar;
        Fragment fragment;
        if (q.f62a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (this.l && this.p < 0) {
            throw new IllegalStateException("addToBackStack() called after commit()");
        }
        a(1);
        if (f52a) {
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            b(sparseArray, sparseArray2);
            bVar = a(sparseArray, sparseArray2, false);
        } else {
            bVar = null;
        }
        int i = bVar != null ? 0 : this.k;
        int i2 = bVar != null ? 0 : this.j;
        for (a aVar = this.c; aVar != null; aVar = aVar.f53a) {
            int i3 = bVar != null ? 0 : aVar.e;
            int i4 = bVar != null ? 0 : aVar.f;
            switch (aVar.c) {
                case 1:
                    Fragment fragment2 = aVar.d;
                    fragment2.mNextAnim = i3;
                    this.b.a(fragment2, false);
                    break;
                case 2:
                    Fragment fragment3 = aVar.d;
                    if (this.b.g != null) {
                        fragment = fragment3;
                        for (int i5 = 0; i5 < this.b.g.size(); i5++) {
                            Fragment fragment4 = this.b.g.get(i5);
                            if (q.f62a) {
                                Log.v("FragmentManager", "OP_REPLACE: adding=" + fragment + " old=" + fragment4);
                            }
                            if (fragment == null || fragment4.mContainerId == fragment.mContainerId) {
                                if (fragment4 == fragment) {
                                    aVar.d = null;
                                    fragment = null;
                                } else {
                                    if (aVar.i == null) {
                                        aVar.i = new ArrayList<>();
                                    }
                                    aVar.i.add(fragment4);
                                    fragment4.mNextAnim = i4;
                                    if (this.l) {
                                        fragment4.mBackStackNesting++;
                                        if (q.f62a) {
                                            Log.v("FragmentManager", "Bump nesting of " + fragment4 + " to " + fragment4.mBackStackNesting);
                                        }
                                    }
                                    this.b.a(fragment4, i2, i);
                                }
                            }
                        }
                    } else {
                        fragment = fragment3;
                    }
                    if (fragment != null) {
                        fragment.mNextAnim = i3;
                        this.b.a(fragment, false);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment5 = aVar.d;
                    fragment5.mNextAnim = i4;
                    this.b.a(fragment5, i2, i);
                    break;
                case 4:
                    Fragment fragment6 = aVar.d;
                    fragment6.mNextAnim = i4;
                    this.b.b(fragment6, i2, i);
                    break;
                case 5:
                    Fragment fragment7 = aVar.d;
                    fragment7.mNextAnim = i3;
                    this.b.c(fragment7, i2, i);
                    break;
                case 6:
                    Fragment fragment8 = aVar.d;
                    fragment8.mNextAnim = i4;
                    this.b.d(fragment8, i2, i);
                    break;
                case 7:
                    Fragment fragment9 = aVar.d;
                    fragment9.mNextAnim = i3;
                    this.b.e(fragment9, i2, i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.c);
            }
        }
        this.b.a(this.b.n, i2, i, true);
        if (this.l) {
            this.b.b(this);
        }
    }

    private static void a(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.mContainerId) != 0 && !fragment.isHidden() && fragment.isAdded() && fragment.getView() != null && sparseArray.get(i) == null) {
            sparseArray.put(i, fragment);
        }
    }

    private void b(SparseArray<Fragment> sparseArray, Fragment fragment) {
        int i;
        if (fragment != null && (i = fragment.mContainerId) != 0) {
            sparseArray.put(i, fragment);
        }
    }

    private void b(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        Fragment fragment;
        if (this.b.p.a()) {
            for (a aVar = this.c; aVar != null; aVar = aVar.f53a) {
                switch (aVar.c) {
                    case 1:
                        b(sparseArray2, aVar.d);
                        break;
                    case 2:
                        Fragment fragment2 = aVar.d;
                        if (this.b.g != null) {
                            int i = 0;
                            fragment = fragment2;
                            while (true) {
                                int i2 = i;
                                if (i2 < this.b.g.size()) {
                                    Fragment fragment3 = this.b.g.get(i2);
                                    if (fragment == null || fragment3.mContainerId == fragment.mContainerId) {
                                        if (fragment3 == fragment) {
                                            fragment = null;
                                        } else {
                                            a(sparseArray, fragment3);
                                        }
                                    }
                                    i = i2 + 1;
                                }
                            }
                        } else {
                            fragment = fragment2;
                        }
                        b(sparseArray2, fragment);
                        break;
                    case 3:
                        a(sparseArray, aVar.d);
                        break;
                    case 4:
                        a(sparseArray, aVar.d);
                        break;
                    case 5:
                        b(sparseArray2, aVar.d);
                        break;
                    case 6:
                        a(sparseArray, aVar.d);
                        break;
                    case 7:
                        b(sparseArray2, aVar.d);
                        break;
                }
            }
        }
    }

    public void a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (this.b.p.a()) {
            for (a aVar = this.c; aVar != null; aVar = aVar.f53a) {
                switch (aVar.c) {
                    case 1:
                        a(sparseArray, aVar.d);
                        break;
                    case 2:
                        if (aVar.i != null) {
                            for (int size = aVar.i.size() - 1; size >= 0; size--) {
                                b(sparseArray2, aVar.i.get(size));
                            }
                        }
                        a(sparseArray, aVar.d);
                        break;
                    case 3:
                        b(sparseArray2, aVar.d);
                        break;
                    case 4:
                        b(sparseArray2, aVar.d);
                        break;
                    case 5:
                        a(sparseArray, aVar.d);
                        break;
                    case 6:
                        b(sparseArray2, aVar.d);
                        break;
                    case 7:
                        a(sparseArray, aVar.d);
                        break;
                }
            }
        }
    }

    public b a(boolean z, b bVar, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        if (q.f62a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            a("  ", (FileDescriptor) null, new PrintWriter(new android.support.v4.f.e("FragmentManager")), (String[]) null);
        }
        if (f52a) {
            if (bVar == null) {
                if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
                    bVar = a(sparseArray, sparseArray2, true);
                }
            } else if (!z) {
                a(bVar, this.v, this.u);
            }
        }
        a(-1);
        int i = bVar != null ? 0 : this.k;
        int i2 = bVar != null ? 0 : this.j;
        for (a aVar = this.d; aVar != null; aVar = aVar.b) {
            int i3 = bVar != null ? 0 : aVar.g;
            int i4 = bVar != null ? 0 : aVar.h;
            switch (aVar.c) {
                case 1:
                    Fragment fragment = aVar.d;
                    fragment.mNextAnim = i4;
                    this.b.a(fragment, q.c(i2), i);
                    break;
                case 2:
                    Fragment fragment2 = aVar.d;
                    if (fragment2 != null) {
                        fragment2.mNextAnim = i4;
                        this.b.a(fragment2, q.c(i2), i);
                    }
                    if (aVar.i != null) {
                        for (int i5 = 0; i5 < aVar.i.size(); i5++) {
                            Fragment fragment3 = aVar.i.get(i5);
                            fragment3.mNextAnim = i3;
                            this.b.a(fragment3, false);
                        }
                        break;
                    } else {
                        break;
                    }
                case 3:
                    Fragment fragment4 = aVar.d;
                    fragment4.mNextAnim = i3;
                    this.b.a(fragment4, false);
                    break;
                case 4:
                    Fragment fragment5 = aVar.d;
                    fragment5.mNextAnim = i3;
                    this.b.c(fragment5, q.c(i2), i);
                    break;
                case 5:
                    Fragment fragment6 = aVar.d;
                    fragment6.mNextAnim = i4;
                    this.b.b(fragment6, q.c(i2), i);
                    break;
                case 6:
                    Fragment fragment7 = aVar.d;
                    fragment7.mNextAnim = i3;
                    this.b.e(fragment7, q.c(i2), i);
                    break;
                case 7:
                    Fragment fragment8 = aVar.d;
                    fragment8.mNextAnim = i3;
                    this.b.d(fragment8, q.c(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.c);
            }
        }
        if (z) {
            this.b.a(this.b.n, q.c(i2), i, true);
            bVar = null;
        }
        if (this.p >= 0) {
            this.b.b(this.p);
            this.p = -1;
        }
        return bVar;
    }

    public String c() {
        return this.n;
    }

    private b a(SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2, boolean z) {
        b bVar = new b();
        bVar.d = new View(this.b.o);
        int i = 0;
        boolean z2 = false;
        while (i < sparseArray.size()) {
            boolean z3 = a(sparseArray.keyAt(i), bVar, z, sparseArray, sparseArray2) ? true : z2;
            i++;
            z2 = z3;
        }
        for (int i2 = 0; i2 < sparseArray2.size(); i2++) {
            int keyAt = sparseArray2.keyAt(i2);
            if (sparseArray.get(keyAt) == null && a(keyAt, bVar, z, sparseArray, sparseArray2)) {
                z2 = true;
            }
        }
        if (!z2) {
            return null;
        }
        return bVar;
    }

    private static Object a(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return x.a(z ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    private static Object b(Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return x.a(z ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    private static Object a(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return x.a(z ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition());
    }

    private static Object a(Object obj, Fragment fragment, ArrayList<View> arrayList, android.support.v4.f.a<String, View> aVar, View view) {
        if (obj != null) {
            return x.a(obj, fragment.getView(), arrayList, aVar, view);
        }
        return obj;
    }

    private android.support.v4.f.a<String, View> a(b bVar, Fragment fragment, boolean z) {
        android.support.v4.f.a<String, View> aVar = new android.support.v4.f.a<>();
        if (this.u != null) {
            x.a((Map<String, View>) aVar, fragment.getView());
            if (z) {
                aVar.a((Collection<?>) this.v);
            } else {
                aVar = a(this.u, this.v, aVar);
            }
        }
        if (z) {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.v, aVar);
            }
            a(bVar, aVar, false);
        } else {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.v, aVar);
            }
            b(bVar, aVar, false);
        }
        return aVar;
    }

    private boolean a(int i, b bVar, boolean z, SparseArray<Fragment> sparseArray, SparseArray<Fragment> sparseArray2) {
        View view;
        ViewGroup viewGroup = (ViewGroup) this.b.p.a(i);
        if (viewGroup == null) {
            return false;
        }
        Fragment fragment = sparseArray2.get(i);
        Fragment fragment2 = sparseArray.get(i);
        Object a2 = a(fragment, z);
        Object a3 = a(fragment, fragment2, z);
        Object b2 = b(fragment2, z);
        if (a2 == null && a3 == null && b2 == null) {
            return false;
        }
        android.support.v4.f.a<String, View> aVar = null;
        ArrayList<View> arrayList = new ArrayList<>();
        if (a3 != null) {
            aVar = a(bVar, fragment2, z);
            arrayList.add(bVar.d);
            arrayList.addAll(aVar.values());
            ay ayVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
            if (ayVar != null) {
                ayVar.a(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), (List<View>) null);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Object a4 = a(b2, fragment2, (ArrayList<View>) arrayList2, aVar, bVar.d);
        if (this.v != null && aVar != null && (view = aVar.get(this.v.get(0))) != null) {
            if (a4 != null) {
                x.a(a4, view);
            }
            if (a3 != null) {
                x.a(a3, view);
            }
        }
        e eVar = new e(this, fragment);
        if (a3 != null) {
            a(bVar, viewGroup, a3, fragment, fragment2, z, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        android.support.v4.f.a aVar2 = new android.support.v4.f.a();
        Object a5 = x.a(a2, a4, a3, z ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap());
        if (a5 != null) {
            x.a(a2, a3, viewGroup, eVar, bVar.d, bVar.c, bVar.f54a, arrayList3, aVar2, arrayList);
            a(viewGroup, bVar, i, a5);
            x.a(a5, bVar.d, true);
            a(bVar, i, a5);
            x.a(viewGroup, a5);
            x.a(viewGroup, bVar.d, a2, arrayList3, a4, arrayList2, a3, arrayList, a5, bVar.b, aVar2);
        }
        return a5 != null;
    }

    private void a(b bVar, View view, Object obj, Fragment fragment, Fragment fragment2, boolean z, ArrayList<View> arrayList) {
        view.getViewTreeObserver().addOnPreDrawListener(new f(this, view, obj, arrayList, bVar, z, fragment, fragment2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Fragment fragment, Fragment fragment2, boolean z, android.support.v4.f.a<String, View> aVar) {
        ay ayVar = z ? fragment2.mEnterTransitionCallback : fragment.mEnterTransitionCallback;
        if (ayVar != null) {
            ayVar.b(new ArrayList(aVar.keySet()), new ArrayList(aVar.values()), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.support.v4.f.a<String, View> aVar, b bVar) {
        View view;
        if (this.v != null && !aVar.isEmpty() && (view = aVar.get(this.v.get(0))) != null) {
            bVar.c.f67a = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.support.v4.f.a<String, View> a(b bVar, boolean z, Fragment fragment) {
        android.support.v4.f.a<String, View> b2 = b(bVar, fragment, z);
        if (z) {
            if (fragment.mExitTransitionCallback != null) {
                fragment.mExitTransitionCallback.a(this.v, b2);
            }
            a(bVar, b2, true);
        } else {
            if (fragment.mEnterTransitionCallback != null) {
                fragment.mEnterTransitionCallback.a(this.v, b2);
            }
            b(bVar, b2, true);
        }
        return b2;
    }

    private static android.support.v4.f.a<String, View> a(ArrayList<String> arrayList, ArrayList<String> arrayList2, android.support.v4.f.a<String, View> aVar) {
        if (!aVar.isEmpty()) {
            android.support.v4.f.a<String, View> aVar2 = new android.support.v4.f.a<>();
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = aVar.get(arrayList.get(i));
                if (view != null) {
                    aVar2.put(arrayList2.get(i), view);
                }
            }
            return aVar2;
        }
        return aVar;
    }

    private android.support.v4.f.a<String, View> b(b bVar, Fragment fragment, boolean z) {
        android.support.v4.f.a<String, View> aVar = new android.support.v4.f.a<>();
        View view = fragment.getView();
        if (view != null && this.u != null) {
            x.a((Map<String, View>) aVar, view);
            if (z) {
                return a(this.u, this.v, aVar);
            }
            aVar.a((Collection<?>) this.v);
            return aVar;
        }
        return aVar;
    }

    private void a(View view, b bVar, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new g(this, view, bVar, i, obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, int i, Object obj) {
        if (this.b.g != null) {
            for (int i2 = 0; i2 < this.b.g.size(); i2++) {
                Fragment fragment = this.b.g.get(i2);
                if (fragment.mView != null && fragment.mContainer != null && fragment.mContainerId == i) {
                    if (fragment.mHidden) {
                        if (!bVar.b.contains(fragment.mView)) {
                            x.a(obj, fragment.mView, true);
                            bVar.b.add(fragment.mView);
                        }
                    } else {
                        x.a(obj, fragment.mView, false);
                        bVar.b.remove(fragment.mView);
                    }
                }
            }
        }
    }

    private static void a(android.support.v4.f.a<String, String> aVar, String str, String str2) {
        if (str != null && str2 != null && !str.equals(str2)) {
            for (int i = 0; i < aVar.size(); i++) {
                if (str.equals(aVar.c(i))) {
                    aVar.a(i, (int) str2);
                    return;
                }
            }
            aVar.put(str, str2);
        }
    }

    private static void a(b bVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    a(bVar.f54a, arrayList.get(i2), arrayList2.get(i2));
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(b bVar, android.support.v4.f.a<String, View> aVar, boolean z) {
        int size = this.v == null ? 0 : this.v.size();
        for (int i = 0; i < size; i++) {
            String str = this.u.get(i);
            View view = aVar.get(this.v.get(i));
            if (view != null) {
                String a2 = x.a(view);
                if (z) {
                    a(bVar.f54a, str, a2);
                } else {
                    a(bVar.f54a, a2, str);
                }
            }
        }
    }

    private void b(b bVar, android.support.v4.f.a<String, View> aVar, boolean z) {
        int size = aVar.size();
        for (int i = 0; i < size; i++) {
            String b2 = aVar.b(i);
            String a2 = x.a(aVar.c(i));
            if (z) {
                a(bVar.f54a, b2, a2);
            } else {
                a(bVar.f54a, a2, b2);
            }
        }
    }

    /* compiled from: BackStackRecord.java */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public android.support.v4.f.a<String, String> f54a = new android.support.v4.f.a<>();
        public ArrayList<View> b = new ArrayList<>();
        public x.a c = new x.a();
        public View d;

        public b() {
        }
    }
}
