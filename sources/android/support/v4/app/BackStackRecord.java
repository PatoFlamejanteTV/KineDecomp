package android.support.v4.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.util.LogWriter;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManagerImpl.OpGenerator {

    /* renamed from: a, reason: collision with root package name */
    final FragmentManagerImpl f684a;

    /* renamed from: c, reason: collision with root package name */
    int f686c;

    /* renamed from: d, reason: collision with root package name */
    int f687d;

    /* renamed from: e, reason: collision with root package name */
    int f688e;

    /* renamed from: f, reason: collision with root package name */
    int f689f;

    /* renamed from: g, reason: collision with root package name */
    int f690g;

    /* renamed from: h, reason: collision with root package name */
    int f691h;
    boolean i;
    String k;
    boolean l;
    int n;
    CharSequence o;
    int p;
    CharSequence q;
    ArrayList<String> r;
    ArrayList<String> s;
    ArrayList<Runnable> u;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<Op> f685b = new ArrayList<>();
    boolean j = true;
    int m = -1;
    boolean t = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Op {

        /* renamed from: a, reason: collision with root package name */
        int f692a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f693b;

        /* renamed from: c, reason: collision with root package name */
        int f694c;

        /* renamed from: d, reason: collision with root package name */
        int f695d;

        /* renamed from: e, reason: collision with root package name */
        int f696e;

        /* renamed from: f, reason: collision with root package name */
        int f697f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Op() {
        }

        Op(int i, Fragment fragment) {
            this.f692a = i;
            this.f693b = fragment;
        }
    }

    public BackStackRecord(FragmentManagerImpl fragmentManagerImpl) {
        this.f684a = fragmentManagerImpl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Op op) {
        this.f685b.add(op);
        op.f694c = this.f686c;
        op.f695d = this.f687d;
        op.f696e = this.f688e;
        op.f697f = this.f689f;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction addSharedElement(View view, String str) {
        if (FragmentTransition.a()) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                if (this.r == null) {
                    this.r = new ArrayList<>();
                    this.s = new ArrayList<>();
                } else if (!this.s.contains(str)) {
                    if (this.r.contains(transitionName)) {
                        throw new IllegalArgumentException("A shared element with the source name '" + transitionName + " has already been added to the transaction.");
                    }
                } else {
                    throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
                }
                this.r.add(transitionName);
                this.s.add(str);
            } else {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
        }
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction addToBackStack(String str) {
        if (this.j) {
            this.i = true;
            this.k = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction attach(Fragment fragment) {
        a(new Op(7, fragment));
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        int size = this.f685b.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f685b.get(i2).f693b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commit() {
        return a(false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return a(true);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.f684a.execSingleAction(this, false);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.f684a.execSingleAction(this, true);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction detach(Fragment fragment) {
        a(new Op(6, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction disallowAddToBackStack() {
        if (!this.i) {
            this.j = false;
            return this;
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        dump(str, printWriter, true);
    }

    @Override // android.support.v4.app.FragmentManagerImpl.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.f732a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.i) {
            return true;
        }
        this.f684a.a(this);
        return true;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        if (this.p != 0) {
            return this.f684a.s.b().getText(this.p);
        }
        return this.q;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.p;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        if (this.n != 0) {
            return this.f684a.s.b().getText(this.n);
        }
        return this.o;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.n;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.m;
    }

    @Override // android.support.v4.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.k;
    }

    public int getTransition() {
        return this.f690g;
    }

    public int getTransitionStyle() {
        return this.f691h;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction hide(Fragment fragment) {
        a(new Op(4, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isAddToBackStackAllowed() {
        return this.j;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public boolean isEmpty() {
        return this.f685b.isEmpty();
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction remove(Fragment fragment) {
        a(new Op(3, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment) {
        return replace(i, fragment, null);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction runOnCommit(Runnable runnable) {
        if (runnable != null) {
            disallowAddToBackStack();
            if (this.u == null) {
                this.u = new ArrayList<>();
            }
            this.u.add(runnable);
            return this;
        }
        throw new IllegalArgumentException("runnable cannot be null");
    }

    public void runOnCommitRunnables() {
        ArrayList<Runnable> arrayList = this.u;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.u.get(i).run();
            }
            this.u = null;
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setAllowOptimization(boolean z) {
        return setReorderingAllowed(z);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(int i) {
        this.p = i;
        this.q = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(int i) {
        this.n = i;
        this.o = null;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2) {
        return setCustomAnimations(i, i2, 0, 0);
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setPrimaryNavigationFragment(Fragment fragment) {
        a(new Op(8, fragment));
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setReorderingAllowed(boolean z) {
        this.t = z;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransition(int i) {
        this.f690g = i;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setTransitionStyle(int i) {
        this.f691h = i;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction show(Fragment fragment) {
        a(new Op(5, fragment));
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.m >= 0) {
            sb.append(" #");
            sb.append(this.m);
        }
        if (this.k != null) {
            sb.append(" ");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment) {
        a(i, fragment, null, 1);
        return this;
    }

    public void dump(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.k);
            printWriter.print(" mIndex=");
            printWriter.print(this.m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.l);
            if (this.f690g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f690g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f691h));
            }
            if (this.f686c != 0 || this.f687d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f686c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f687d));
            }
            if (this.f688e != 0 || this.f689f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f688e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f689f));
            }
            if (this.n != 0 || this.o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.o);
            }
            if (this.p != 0 || this.q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.q);
            }
        }
        if (this.f685b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f685b.size();
        for (int i = 0; i < size; i++) {
            Op op = this.f685b.get(i);
            switch (op.f692a) {
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
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + op.f692a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(op.f693b);
            if (z) {
                if (op.f694c != 0 || op.f695d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(op.f694c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(op.f695d));
                }
                if (op.f696e != 0 || op.f697f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(op.f696e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(op.f697f));
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction replace(int i, Fragment fragment, String str) {
        if (i != 0) {
            a(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setCustomAnimations(int i, int i2, int i3, int i4) {
        this.f686c = i;
        this.f687d = i2;
        this.f688e = i3;
        this.f689f = i4;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction add(int i, Fragment fragment, String str) {
        a(i, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence charSequence) {
        this.p = 0;
        this.q = charSequence;
        return this;
    }

    @Override // android.support.v4.app.FragmentTransaction
    public FragmentTransaction setBreadCrumbTitle(CharSequence charSequence) {
        this.n = 0;
        this.o = charSequence;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        for (int size = this.f685b.size() - 1; size >= 0; size--) {
            Op op = this.f685b.get(size);
            Fragment fragment = op.f693b;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.f690g), this.f691h);
            }
            switch (op.f692a) {
                case 1:
                    fragment.setNextAnim(op.f697f);
                    this.f684a.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f692a);
                case 3:
                    fragment.setNextAnim(op.f696e);
                    this.f684a.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(op.f696e);
                    this.f684a.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.f697f);
                    this.f684a.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.f696e);
                    this.f684a.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.f697f);
                    this.f684a.detachFragment(fragment);
                    break;
                case 8:
                    this.f684a.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.f684a.setPrimaryNavigationFragment(fragment);
                    break;
            }
            if (!this.t && op.f692a != 3 && fragment != null) {
                this.f684a.e(fragment);
            }
        }
        if (this.t || !z) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.f684a;
        fragmentManagerImpl.a(fragmentManagerImpl.r, true);
    }

    private void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            fragment.mFragmentManager = this.f684a;
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
                }
                fragment.mTag = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.mFragmentId;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                    }
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new Op(i2, fragment));
            return;
        }
        throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        if (this.i) {
            if (FragmentManagerImpl.f732a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f685b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Op op = this.f685b.get(i2);
                Fragment fragment = op.f693b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.f732a) {
                        Log.v("FragmentManager", "Bump nesting of " + op.f693b + " to " + op.f693b.mBackStackNesting);
                    }
                }
            }
        }
    }

    int a(boolean z) {
        if (!this.l) {
            if (FragmentManagerImpl.f732a) {
                Log.v("FragmentManager", "Commit: " + this);
                PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                dump("  ", null, printWriter, null);
                printWriter.close();
            }
            this.l = true;
            if (this.i) {
                this.m = this.f684a.allocBackStackIndex(this);
            } else {
                this.m = -1;
            }
            this.f684a.enqueueAction(this, z);
            return this.m;
        }
        throw new IllegalStateException("commit already called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i = 0; i < this.f685b.size(); i++) {
            Op op = this.f685b.get(i);
            int i2 = op.f692a;
            if (i2 != 1) {
                if (i2 != 3) {
                    switch (i2) {
                        case 8:
                            fragment = null;
                            break;
                        case 9:
                            fragment = op.f693b;
                            break;
                    }
                }
                arrayList.add(op.f693b);
            }
            arrayList.remove(op.f693b);
        }
        return fragment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        for (int i = 0; i < this.f685b.size(); i++) {
            if (b(this.f685b.get(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(Op op) {
        Fragment fragment = op.f693b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ArrayList<BackStackRecord> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f685b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f685b.get(i4).f693b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    BackStackRecord backStackRecord = arrayList.get(i6);
                    int size2 = backStackRecord.f685b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = backStackRecord.f685b.get(i7).f693b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int size = this.f685b.size();
        for (int i = 0; i < size; i++) {
            Op op = this.f685b.get(i);
            Fragment fragment = op.f693b;
            if (fragment != null) {
                fragment.setNextTransition(this.f690g, this.f691h);
            }
            switch (op.f692a) {
                case 1:
                    fragment.setNextAnim(op.f694c);
                    this.f684a.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + op.f692a);
                case 3:
                    fragment.setNextAnim(op.f695d);
                    this.f684a.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(op.f695d);
                    this.f684a.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(op.f694c);
                    this.f684a.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(op.f695d);
                    this.f684a.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(op.f694c);
                    this.f684a.attachFragment(fragment);
                    break;
                case 8:
                    this.f684a.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.f684a.setPrimaryNavigationFragment(null);
                    break;
            }
            if (!this.t && op.f692a != 1 && fragment != null) {
                this.f684a.e(fragment);
            }
        }
        if (this.t) {
            return;
        }
        FragmentManagerImpl fragmentManagerImpl = this.f684a;
        fragmentManagerImpl.a(fragmentManagerImpl.r, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f685b.size()) {
            Op op = this.f685b.get(i);
            int i2 = op.f692a;
            if (i2 != 1) {
                if (i2 == 2) {
                    Fragment fragment3 = op.f693b;
                    int i3 = fragment3.mContainerId;
                    Fragment fragment4 = fragment2;
                    int i4 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        Fragment fragment5 = arrayList.get(size);
                        if (fragment5.mContainerId == i3) {
                            if (fragment5 == fragment3) {
                                z = true;
                            } else {
                                if (fragment5 == fragment4) {
                                    this.f685b.add(i4, new Op(9, fragment5));
                                    i4++;
                                    fragment4 = null;
                                }
                                Op op2 = new Op(3, fragment5);
                                op2.f694c = op.f694c;
                                op2.f696e = op.f696e;
                                op2.f695d = op.f695d;
                                op2.f697f = op.f697f;
                                this.f685b.add(i4, op2);
                                arrayList.remove(fragment5);
                                i4++;
                            }
                        }
                    }
                    if (z) {
                        this.f685b.remove(i4);
                        i4--;
                    } else {
                        op.f692a = 1;
                        arrayList.add(fragment3);
                    }
                    i = i4;
                    fragment2 = fragment4;
                } else if (i2 == 3 || i2 == 6) {
                    arrayList.remove(op.f693b);
                    Fragment fragment6 = op.f693b;
                    if (fragment6 == fragment2) {
                        this.f685b.add(i, new Op(9, fragment6));
                        i++;
                        fragment2 = null;
                    }
                } else if (i2 != 7) {
                    if (i2 == 8) {
                        this.f685b.add(i, new Op(9, fragment2));
                        i++;
                        fragment2 = op.f693b;
                    }
                }
                i++;
            }
            arrayList.add(op.f693b);
            i++;
        }
        return fragment2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.f685b.size(); i++) {
            Op op = this.f685b.get(i);
            if (b(op)) {
                op.f693b.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }
}
