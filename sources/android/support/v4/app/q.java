package android.support.v4.app;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.app.d;
import android.support.v4.app.p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class q extends p implements android.support.v4.g.h {
    static final Interpolator A;
    static final Interpolator B;
    static final Interpolator C;

    /* renamed from: a, reason: collision with root package name */
    static boolean f62a = false;
    static final boolean b;
    static final Interpolator z;
    ArrayList<Runnable> c;
    Runnable[] d;
    boolean e;
    ArrayList<Fragment> f;
    ArrayList<Fragment> g;
    ArrayList<Integer> h;
    ArrayList<d> i;
    ArrayList<Fragment> j;
    ArrayList<d> k;
    ArrayList<Integer> l;
    ArrayList<p.a> m;
    l o;
    o p;
    Fragment q;
    boolean r;
    boolean s;
    boolean t;
    String u;
    boolean v;
    int n = 0;
    Bundle w = null;
    SparseArray<Parcelable> x = null;
    Runnable y = new r(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f63a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    static {
        b = Build.VERSION.SDK_INT >= 11;
        z = new DecelerateInterpolator(2.5f);
        A = new DecelerateInterpolator(1.5f);
        B = new AccelerateInterpolator(2.5f);
        C = new AccelerateInterpolator(1.5f);
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new android.support.v4.f.e("FragmentManager"));
        if (this.o != null) {
            try {
                this.o.dump("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw runtimeException;
            }
        }
        try {
            a("  ", (FileDescriptor) null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    @Override // android.support.v4.app.p
    public w a() {
        return new d(this);
    }

    @Override // android.support.v4.app.p
    public boolean b() {
        return g();
    }

    public boolean e() {
        w();
        b();
        return a(this.o.mHandler, (String) null, -1, 0);
    }

    @Override // android.support.v4.app.p
    public void a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Bad id: " + i);
        }
        a((Runnable) new s(this, i, i2), false);
    }

    public void a(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mIndex < 0) {
            a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, fragment.mIndex);
    }

    public Fragment a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f.size()) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        Fragment fragment = this.f.get(i);
        if (fragment == null) {
            a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
            return fragment;
        }
        return fragment;
    }

    @Override // android.support.v4.app.p
    public List<Fragment> c() {
        return this.f;
    }

    @Override // android.support.v4.app.p
    public boolean d() {
        return this.t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (this.q != null) {
            android.support.v4.f.d.a(this.q, sb);
        } else {
            android.support.v4.f.d.a(this.o, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        int size6;
        String str2 = str + "    ";
        if (this.f != null && (size6 = this.f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size6; i++) {
                Fragment fragment = this.f.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        if (this.g != null && (size5 = this.g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size5; i2++) {
                Fragment fragment2 = this.g.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        if (this.j != null && (size4 = this.j.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment3 = this.j.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment3.toString());
            }
        }
        if (this.i != null && (size3 = this.i.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                d dVar = this.i.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(dVar.toString());
                dVar.a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.k != null && (size2 = this.k.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (d) this.k.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.l != null && this.l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.l.toArray()));
            }
        }
        if (this.c != null && (size = this.c.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (Runnable) this.c.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mActivity=");
        printWriter.println(this.o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.p);
        if (this.q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.s);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.t);
        if (this.r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.r);
        }
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.u);
        }
        if (this.h != null && this.h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.h.toArray()));
        }
    }

    static Animation a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(z);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    static Animation a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(A);
        alphaAnimation.setDuration(220L);
        return alphaAnimation;
    }

    Animation a(Fragment fragment, int i, boolean z2, int i2) {
        int b2;
        Animation loadAnimation;
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z2, fragment.mNextAnim);
        if (onCreateAnimation == null) {
            if (fragment.mNextAnim == 0 || (loadAnimation = AnimationUtils.loadAnimation(this.o, fragment.mNextAnim)) == null) {
                if (i != 0 && (b2 = b(i, z2)) >= 0) {
                    switch (b2) {
                        case 1:
                            return a(this.o, 1.125f, 1.0f, 0.0f, 1.0f);
                        case 2:
                            return a(this.o, 1.0f, 0.975f, 1.0f, 0.0f);
                        case 3:
                            return a(this.o, 0.975f, 1.0f, 0.0f, 1.0f);
                        case 4:
                            return a(this.o, 1.0f, 1.075f, 1.0f, 0.0f);
                        case 5:
                            return a(this.o, 0.0f, 1.0f);
                        case 6:
                            return a(this.o, 1.0f, 0.0f);
                        default:
                            if (i2 == 0 && this.o.getWindow() != null) {
                                i2 = this.o.getWindow().getAttributes().windowAnimations;
                            }
                            return i2 == 0 ? null : null;
                    }
                }
                return null;
            }
            return loadAnimation;
        }
        return onCreateAnimation;
    }

    public void a(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.e) {
                this.v = true;
            } else {
                fragment.mDeferStart = false;
                a(fragment, this.n, 0, 0, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:118:0x026b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.support.v4.app.Fragment r11, int r12, int r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    void b(Fragment fragment) {
        a(fragment, this.n, 0, 0, false);
    }

    void a(int i, boolean z2) {
        a(i, 0, 0, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, int i3, boolean z2) {
        if (this.o == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z2 || this.n != i) {
            this.n = i;
            if (this.f != null) {
                int i4 = 0;
                boolean z3 = false;
                while (i4 < this.f.size()) {
                    Fragment fragment = this.f.get(i4);
                    if (fragment != null) {
                        a(fragment, i, i2, i3, false);
                        if (fragment.mLoaderManager != null) {
                            z3 |= fragment.mLoaderManager.a();
                        }
                    }
                    i4++;
                    z3 = z3;
                }
                if (!z3) {
                    f();
                }
                if (this.r && this.o != null && this.n == 5) {
                    this.o.supportInvalidateOptionsMenu();
                    this.r = false;
                }
            }
        }
    }

    void f() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    Fragment fragment = this.f.get(i2);
                    if (fragment != null) {
                        a(fragment);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void c(Fragment fragment) {
        if (fragment.mIndex < 0) {
            if (this.h == null || this.h.size() <= 0) {
                if (this.f == null) {
                    this.f = new ArrayList<>();
                }
                fragment.setIndex(this.f.size(), this.q);
                this.f.add(fragment);
            } else {
                fragment.setIndex(this.h.remove(this.h.size() - 1).intValue(), this.q);
                this.f.set(fragment.mIndex, fragment);
            }
            if (f62a) {
                Log.v("FragmentManager", "Allocated fragment index " + fragment);
            }
        }
    }

    void d(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            if (f62a) {
                Log.v("FragmentManager", "Freeing fragment index " + fragment);
            }
            this.f.set(fragment.mIndex, null);
            if (this.h == null) {
                this.h = new ArrayList<>();
            }
            this.h.add(Integer.valueOf(fragment.mIndex));
            this.o.invalidateSupportFragment(fragment.mWho);
            fragment.initState();
        }
    }

    public void a(Fragment fragment, boolean z2) {
        if (this.g == null) {
            this.g = new ArrayList<>();
        }
        if (f62a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        c(fragment);
        if (!fragment.mDetached) {
            if (this.g.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
            this.g.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.r = true;
            }
            if (z2) {
                b(fragment);
            }
        }
    }

    public void a(Fragment fragment, int i, int i2) {
        if (f62a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            if (this.g != null) {
                this.g.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.r = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            a(fragment, z2 ? 0 : 1, i, i2, false);
        }
    }

    public void b(Fragment fragment, int i, int i2) {
        if (f62a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation a2 = a(fragment, i, false, i2);
                if (a2 != null) {
                    fragment.mView.startAnimation(a2);
                }
                fragment.mView.setVisibility(8);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.r = true;
            }
            fragment.onHiddenChanged(true);
        }
    }

    public void c(Fragment fragment, int i, int i2) {
        if (f62a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation a2 = a(fragment, i, true, i2);
                if (a2 != null) {
                    fragment.mView.startAnimation(a2);
                }
                fragment.mView.setVisibility(0);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                this.r = true;
            }
            fragment.onHiddenChanged(false);
        }
    }

    public void d(Fragment fragment, int i, int i2) {
        if (f62a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (this.g != null) {
                    if (f62a) {
                        Log.v("FragmentManager", "remove from detach: " + fragment);
                    }
                    this.g.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.r = true;
                }
                fragment.mAdded = false;
                a(fragment, 1, i, i2, false);
            }
        }
    }

    public void e(Fragment fragment, int i, int i2) {
        if (f62a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                if (this.g.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (f62a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                this.g.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.r = true;
                }
                a(fragment, this.n, i, i2, false);
            }
        }
    }

    public Fragment a(int i) {
        if (this.g != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && fragment.mFragmentId == i) {
                    return fragment;
                }
            }
        }
        if (this.f != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f.get(size2);
                if (fragment2 != null && fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    @Override // android.support.v4.app.p
    public Fragment a(String str) {
        if (this.g != null && str != null) {
            for (int size = this.g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (this.f != null && str != null) {
            for (int size2 = this.f.size() - 1; size2 >= 0; size2--) {
                Fragment fragment2 = this.f.get(size2);
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment b(String str) {
        Fragment findFragmentByWho;
        if (this.f != null && str != null) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f.get(size);
                if (fragment != null && (findFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    private void w() {
        if (this.s) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.u != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.u);
        }
    }

    public void a(Runnable runnable, boolean z2) {
        if (!z2) {
            w();
        }
        synchronized (this) {
            if (this.t || this.o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.c == null) {
                this.c = new ArrayList<>();
            }
            this.c.add(runnable);
            if (this.c.size() == 1) {
                this.o.mHandler.removeCallbacks(this.y);
                this.o.mHandler.post(this.y);
            }
        }
    }

    public int a(d dVar) {
        int size;
        synchronized (this) {
            if (this.l == null || this.l.size() <= 0) {
                if (this.k == null) {
                    this.k = new ArrayList<>();
                }
                size = this.k.size();
                if (f62a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + dVar);
                }
                this.k.add(dVar);
            } else {
                size = this.l.remove(this.l.size() - 1).intValue();
                if (f62a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + dVar);
                }
                this.k.set(size, dVar);
            }
        }
        return size;
    }

    public void a(int i, d dVar) {
        synchronized (this) {
            if (this.k == null) {
                this.k = new ArrayList<>();
            }
            int size = this.k.size();
            if (i < size) {
                if (f62a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + dVar);
                }
                this.k.set(i, dVar);
            } else {
                while (size < i) {
                    this.k.add(null);
                    if (this.l == null) {
                        this.l = new ArrayList<>();
                    }
                    if (f62a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.l.add(Integer.valueOf(size));
                    size++;
                }
                if (f62a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + dVar);
                }
                this.k.add(dVar);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            this.k.set(i, null);
            if (this.l == null) {
                this.l = new ArrayList<>();
            }
            if (f62a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.l.add(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:            r6.e = true;        r1 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0086, code lost:            if (r1 >= r3) goto L49;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:            r6.d[r1].run();        r6.d[r1] = null;        r1 = r1 + 1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g() {
        /*
            r6 = this;
            r0 = 1
            r2 = 0
            boolean r1 = r6.e
            if (r1 == 0) goto Le
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Recursive entry to executePendingTransactions"
            r0.<init>(r1)
            throw r0
        Le:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.support.v4.app.l r3 = r6.o
            android.os.Handler r3 = r3.mHandler
            android.os.Looper r3 = r3.getLooper()
            if (r1 == r3) goto L24
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Must be called from main thread of process"
            r0.<init>(r1)
            throw r0
        L24:
            r1 = r2
        L25:
            monitor-enter(r6)
            java.util.ArrayList<java.lang.Runnable> r3 = r6.c     // Catch: java.lang.Throwable -> L97
            if (r3 == 0) goto L32
            java.util.ArrayList<java.lang.Runnable> r3 = r6.c     // Catch: java.lang.Throwable -> L97
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L97
            if (r3 != 0) goto L5a
        L32:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L97
            boolean r0 = r6.v
            if (r0 == 0) goto La5
            r3 = r2
            r4 = r2
        L39:
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f
            int r0 = r0.size()
            if (r3 >= r0) goto L9e
            java.util.ArrayList<android.support.v4.app.Fragment> r0 = r6.f
            java.lang.Object r0 = r0.get(r3)
            android.support.v4.app.Fragment r0 = (android.support.v4.app.Fragment) r0
            if (r0 == 0) goto L56
            android.support.v4.app.ad r5 = r0.mLoaderManager
            if (r5 == 0) goto L56
            android.support.v4.app.ad r0 = r0.mLoaderManager
            boolean r0 = r0.a()
            r4 = r4 | r0
        L56:
            int r0 = r3 + 1
            r3 = r0
            goto L39
        L5a:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.c     // Catch: java.lang.Throwable -> L97
            int r3 = r1.size()     // Catch: java.lang.Throwable -> L97
            java.lang.Runnable[] r1 = r6.d     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L69
            java.lang.Runnable[] r1 = r6.d     // Catch: java.lang.Throwable -> L97
            int r1 = r1.length     // Catch: java.lang.Throwable -> L97
            if (r1 >= r3) goto L6d
        L69:
            java.lang.Runnable[] r1 = new java.lang.Runnable[r3]     // Catch: java.lang.Throwable -> L97
            r6.d = r1     // Catch: java.lang.Throwable -> L97
        L6d:
            java.util.ArrayList<java.lang.Runnable> r1 = r6.c     // Catch: java.lang.Throwable -> L97
            java.lang.Runnable[] r4 = r6.d     // Catch: java.lang.Throwable -> L97
            r1.toArray(r4)     // Catch: java.lang.Throwable -> L97
            java.util.ArrayList<java.lang.Runnable> r1 = r6.c     // Catch: java.lang.Throwable -> L97
            r1.clear()     // Catch: java.lang.Throwable -> L97
            android.support.v4.app.l r1 = r6.o     // Catch: java.lang.Throwable -> L97
            android.os.Handler r1 = r1.mHandler     // Catch: java.lang.Throwable -> L97
            java.lang.Runnable r4 = r6.y     // Catch: java.lang.Throwable -> L97
            r1.removeCallbacks(r4)     // Catch: java.lang.Throwable -> L97
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L97
            r6.e = r0
            r1 = r2
        L86:
            if (r1 >= r3) goto L9a
            java.lang.Runnable[] r4 = r6.d
            r4 = r4[r1]
            r4.run()
            java.lang.Runnable[] r4 = r6.d
            r5 = 0
            r4[r1] = r5
            int r1 = r1 + 1
            goto L86
        L97:
            r0 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L97
            throw r0
        L9a:
            r6.e = r2
            r1 = r0
            goto L25
        L9e:
            if (r4 != 0) goto La5
            r6.v = r2
            r6.f()
        La5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.q.g():boolean");
    }

    void h() {
        if (this.m != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.m.size()) {
                    this.m.get(i2).a();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(d dVar) {
        if (this.i == null) {
            this.i = new ArrayList<>();
        }
        this.i.add(dVar);
        h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Handler handler, String str, int i, int i2) {
        if (this.i == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = this.i.size() - 1;
            if (size < 0) {
                return false;
            }
            d remove = this.i.remove(size);
            SparseArray<Fragment> sparseArray = new SparseArray<>();
            SparseArray<Fragment> sparseArray2 = new SparseArray<>();
            remove.a(sparseArray, sparseArray2);
            remove.a(true, (d.b) null, sparseArray, sparseArray2);
            h();
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = this.i.size() - 1;
                while (size2 >= 0) {
                    d dVar = this.i.get(size2);
                    if ((str != null && str.equals(dVar.c())) || (i >= 0 && i == dVar.p)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    size2--;
                    while (size2 >= 0) {
                        d dVar2 = this.i.get(size2);
                        if ((str == null || !str.equals(dVar2.c())) && (i < 0 || i != dVar2.p)) {
                            break;
                        }
                        size2--;
                    }
                }
                i3 = size2;
            }
            if (i3 == this.i.size() - 1) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int size3 = this.i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.i.remove(size3));
            }
            int size4 = arrayList.size() - 1;
            SparseArray<Fragment> sparseArray3 = new SparseArray<>();
            SparseArray<Fragment> sparseArray4 = new SparseArray<>();
            for (int i4 = 0; i4 <= size4; i4++) {
                ((d) arrayList.get(i4)).a(sparseArray3, sparseArray4);
            }
            d.b bVar = null;
            int i5 = 0;
            while (i5 <= size4) {
                if (f62a) {
                    Log.v("FragmentManager", "Popping back stack state: " + arrayList.get(i5));
                }
                i5++;
                bVar = ((d) arrayList.get(i5)).a(i5 == size4, bVar, sparseArray3, sparseArray4);
            }
            h();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Fragment> i() {
        ArrayList<Fragment> arrayList = null;
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                Fragment fragment = this.f.get(i2);
                if (fragment != null && fragment.mRetainInstance) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (f62a) {
                        Log.v("FragmentManager", "retainNonConfig: keeping retained " + fragment);
                    }
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    void e(Fragment fragment) {
        if (fragment.mInnerView != null) {
            if (this.x == null) {
                this.x = new SparseArray<>();
            } else {
                this.x.clear();
            }
            fragment.mInnerView.saveHierarchyState(this.x);
            if (this.x.size() > 0) {
                fragment.mSavedViewState = this.x;
                this.x = null;
            }
        }
    }

    Bundle f(Fragment fragment) {
        Bundle bundle;
        if (this.w == null) {
            this.w = new Bundle();
        }
        fragment.performSaveInstanceState(this.w);
        if (this.w.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.w;
            this.w = null;
        }
        if (fragment.mView != null) {
            e(fragment);
        }
        if (fragment.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
        }
        if (!fragment.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable j() {
        int[] iArr;
        int size;
        int size2;
        boolean z2;
        BackStackState[] backStackStateArr = null;
        g();
        if (b) {
            this.s = true;
        }
        if (this.f == null || this.f.size() <= 0) {
            return null;
        }
        int size3 = this.f.size();
        FragmentState[] fragmentStateArr = new FragmentState[size3];
        int i = 0;
        boolean z3 = false;
        while (i < size3) {
            Fragment fragment = this.f.get(i);
            if (fragment != null) {
                if (fragment.mIndex < 0) {
                    a(new IllegalStateException("Failure saving state: active " + fragment + " has cleared index: " + fragment.mIndex));
                }
                FragmentState fragmentState = new FragmentState(fragment);
                fragmentStateArr[i] = fragmentState;
                if (fragment.mState > 0 && fragmentState.j == null) {
                    fragmentState.j = f(fragment);
                    if (fragment.mTarget != null) {
                        if (fragment.mTarget.mIndex < 0) {
                            a(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTarget));
                        }
                        if (fragmentState.j == null) {
                            fragmentState.j = new Bundle();
                        }
                        a(fragmentState.j, "android:target_state", fragment.mTarget);
                        if (fragment.mTargetRequestCode != 0) {
                            fragmentState.j.putInt("android:target_req_state", fragment.mTargetRequestCode);
                        }
                    }
                } else {
                    fragmentState.j = fragment.mSavedFragmentState;
                }
                if (f62a) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.j);
                }
                z2 = true;
            } else {
                z2 = z3;
            }
            i++;
            z3 = z2;
        }
        if (!z3) {
            if (!f62a) {
                return null;
            }
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
        if (this.g == null || (size2 = this.g.size()) <= 0) {
            iArr = null;
        } else {
            iArr = new int[size2];
            for (int i2 = 0; i2 < size2; i2++) {
                iArr[i2] = this.g.get(i2).mIndex;
                if (iArr[i2] < 0) {
                    a(new IllegalStateException("Failure saving state: active " + this.g.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f62a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.g.get(i2));
                }
            }
        }
        if (this.i != null && (size = this.i.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i3 = 0; i3 < size; i3++) {
                backStackStateArr[i3] = new BackStackState(this, this.i.get(i3));
                if (f62a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.i.get(i3));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f28a = fragmentStateArr;
        fragmentManagerState.b = iArr;
        fragmentManagerState.c = backStackStateArr;
        return fragmentManagerState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, ArrayList<Fragment> arrayList) {
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f28a != null) {
                if (arrayList != null) {
                    for (int i = 0; i < arrayList.size(); i++) {
                        Fragment fragment = arrayList.get(i);
                        if (f62a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                        }
                        FragmentState fragmentState = fragmentManagerState.f28a[fragment.mIndex];
                        fragmentState.k = fragment;
                        fragment.mSavedViewState = null;
                        fragment.mBackStackNesting = 0;
                        fragment.mInLayout = false;
                        fragment.mAdded = false;
                        fragment.mTarget = null;
                        if (fragmentState.j != null) {
                            fragmentState.j.setClassLoader(this.o.getClassLoader());
                            fragment.mSavedViewState = fragmentState.j.getSparseParcelableArray("android:view_state");
                            fragment.mSavedFragmentState = fragmentState.j;
                        }
                    }
                }
                this.f = new ArrayList<>(fragmentManagerState.f28a.length);
                if (this.h != null) {
                    this.h.clear();
                }
                for (int i2 = 0; i2 < fragmentManagerState.f28a.length; i2++) {
                    FragmentState fragmentState2 = fragmentManagerState.f28a[i2];
                    if (fragmentState2 != null) {
                        Fragment a2 = fragmentState2.a(this.o, this.q);
                        if (f62a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + a2);
                        }
                        this.f.add(a2);
                        fragmentState2.k = null;
                    } else {
                        this.f.add(null);
                        if (this.h == null) {
                            this.h = new ArrayList<>();
                        }
                        if (f62a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.h.add(Integer.valueOf(i2));
                    }
                }
                if (arrayList != null) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        Fragment fragment2 = arrayList.get(i3);
                        if (fragment2.mTargetIndex >= 0) {
                            if (fragment2.mTargetIndex < this.f.size()) {
                                fragment2.mTarget = this.f.get(fragment2.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                                fragment2.mTarget = null;
                            }
                        }
                    }
                }
                if (fragmentManagerState.b != null) {
                    this.g = new ArrayList<>(fragmentManagerState.b.length);
                    for (int i4 = 0; i4 < fragmentManagerState.b.length; i4++) {
                        Fragment fragment3 = this.f.get(fragmentManagerState.b[i4]);
                        if (fragment3 == null) {
                            a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.b[i4]));
                        }
                        fragment3.mAdded = true;
                        if (f62a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + i4 + ": " + fragment3);
                        }
                        if (this.g.contains(fragment3)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.g.add(fragment3);
                    }
                } else {
                    this.g = null;
                }
                if (fragmentManagerState.c != null) {
                    this.i = new ArrayList<>(fragmentManagerState.c.length);
                    for (int i5 = 0; i5 < fragmentManagerState.c.length; i5++) {
                        d a3 = fragmentManagerState.c[i5].a(this);
                        if (f62a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i5 + " (index " + a3.p + "): " + a3);
                            a3.a("  ", new PrintWriter(new android.support.v4.f.e("FragmentManager")), false);
                        }
                        this.i.add(a3);
                        if (a3.p >= 0) {
                            a(a3.p, a3);
                        }
                    }
                    return;
                }
                this.i = null;
            }
        }
    }

    public void a(l lVar, o oVar, Fragment fragment) {
        if (this.o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.o = lVar;
        this.p = oVar;
        this.q = fragment;
    }

    public void k() {
        this.s = false;
    }

    public void l() {
        this.s = false;
        a(1, false);
    }

    public void m() {
        this.s = false;
        a(2, false);
    }

    public void n() {
        this.s = false;
        a(4, false);
    }

    public void o() {
        this.s = false;
        a(5, false);
    }

    public void p() {
        a(4, false);
    }

    public void q() {
        this.s = true;
        a(3, false);
    }

    public void r() {
        a(2, false);
    }

    public void s() {
        a(1, false);
    }

    public void t() {
        this.t = true;
        g();
        a(0, false);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public void a(Configuration configuration) {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.performConfigurationChanged(configuration);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void u() {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.performLowMemory();
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public boolean a(Menu menu, MenuInflater menuInflater) {
        boolean z2;
        ArrayList<Fragment> arrayList = null;
        if (this.g != null) {
            int i = 0;
            z2 = false;
            while (i < this.g.size()) {
                Fragment fragment = this.g.get(i);
                if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                    z2 = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(fragment);
                }
                i++;
                z2 = z2;
            }
        } else {
            z2 = false;
        }
        if (this.j != null) {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                Fragment fragment2 = this.j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.j = arrayList;
        return z2;
    }

    public boolean a(Menu menu) {
        if (this.g == null) {
            return false;
        }
        boolean z2 = false;
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    public boolean a(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean b(MenuItem menuItem) {
        if (this.g == null) {
            return false;
        }
        for (int i = 0; i < this.g.size(); i++) {
            Fragment fragment = this.g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void b(Menu menu) {
        if (this.g != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.g.size()) {
                    Fragment fragment = this.g.get(i2);
                    if (fragment != null) {
                        fragment.performOptionsMenuClosed(menu);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static int c(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    public static int b(int i, boolean z2) {
        switch (i) {
            case 4097:
                return z2 ? 1 : 2;
            case 4099:
                return z2 ? 5 : 6;
            case 8194:
                return z2 ? 3 : 4;
            default:
                return -1;
        }
    }

    @Override // android.support.v4.g.h
    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f63a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.o, string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        Fragment a2 = resourceId != -1 ? a(resourceId) : null;
        if (a2 == null && string2 != null) {
            a2 = a(string2);
        }
        if (a2 == null && id != -1) {
            a2 = a(id);
        }
        if (f62a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + a2);
        }
        if (a2 == null) {
            Fragment instantiate = Fragment.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.onInflate(this.o, attributeSet, instantiate.mSavedFragmentState);
            a(instantiate, true);
            fragment = instantiate;
        } else {
            if (a2.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
            }
            a2.mInLayout = true;
            if (!a2.mRetaining) {
                a2.onInflate(this.o, attributeSet, a2.mSavedFragmentState);
            }
            fragment = a2;
        }
        if (this.n < 1 && fragment.mFromLayout) {
            a(fragment, 1, 0, 0, false);
        } else {
            b(fragment);
        }
        if (fragment.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            fragment.mView.setId(resourceId);
        }
        if (fragment.mView.getTag() == null) {
            fragment.mView.setTag(string2);
        }
        return fragment.mView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.support.v4.g.h v() {
        return this;
    }
}
