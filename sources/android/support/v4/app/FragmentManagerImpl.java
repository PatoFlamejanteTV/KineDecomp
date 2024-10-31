package android.support.v4.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.r;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.ArraySet;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public final class FragmentManagerImpl extends FragmentManager implements LayoutInflater.Factory2 {
    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    public static final int ANIM_STYLE_FADE_ENTER = 5;
    public static final int ANIM_STYLE_FADE_EXIT = 6;
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    public static final int ANIM_STYLE_OPEN_EXIT = 2;

    /* renamed from: a, reason: collision with root package name */
    static boolean f732a = false;

    /* renamed from: b, reason: collision with root package name */
    static Field f733b;

    /* renamed from: c, reason: collision with root package name */
    static final Interpolator f734c = new DecelerateInterpolator(2.5f);

    /* renamed from: d, reason: collision with root package name */
    static final Interpolator f735d = new DecelerateInterpolator(1.5f);

    /* renamed from: e, reason: collision with root package name */
    static final Interpolator f736e = new AccelerateInterpolator(2.5f);

    /* renamed from: f, reason: collision with root package name */
    static final Interpolator f737f = new AccelerateInterpolator(1.5f);
    String A;
    boolean B;
    ArrayList<BackStackRecord> C;
    ArrayList<Boolean> D;
    ArrayList<Fragment> E;
    ArrayList<StartEnterTransitionListener> H;
    FragmentManagerNonConfig I;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<OpGenerator> f738g;

    /* renamed from: h, reason: collision with root package name */
    boolean f739h;
    SparseArray<Fragment> k;
    ArrayList<BackStackRecord> l;
    ArrayList<Fragment> m;
    ArrayList<BackStackRecord> n;
    ArrayList<Integer> o;
    ArrayList<FragmentManager.OnBackStackChangedListener> p;
    FragmentHostCallback s;
    FragmentContainer t;
    Fragment u;
    Fragment v;
    boolean w;
    boolean x;
    boolean y;
    boolean z;
    int i = 0;
    final ArrayList<Fragment> j = new ArrayList<>();
    private final CopyOnWriteArrayList<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> q = new CopyOnWriteArrayList<>();
    int r = 0;
    Bundle F = null;
    SparseArray<Parcelable> G = null;
    Runnable J = new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.1
        @Override // java.lang.Runnable
        public void run() {
            FragmentManagerImpl.this.execPendingActions();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class AnimateOnHWLayerIfNeededListener extends AnimationListenerWrapper {

        /* renamed from: b, reason: collision with root package name */
        View f753b;

        AnimateOnHWLayerIfNeededListener(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f753b = view;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!ViewCompat.isAttachedToWindow(this.f753b) && Build.VERSION.SDK_INT < 24) {
                this.f753b.setLayerType(0, null);
            } else {
                this.f753b.post(new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.AnimateOnHWLayerIfNeededListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnimateOnHWLayerIfNeededListener.this.f753b.setLayerType(0, null);
                    }
                });
            }
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    private static class AnimationListenerWrapper implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        private final Animation.AnimationListener f755a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f755a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f755a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f755a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }

        private AnimationListenerWrapper(Animation.AnimationListener animationListener) {
            this.f755a = animationListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class AnimatorOnHWLayerIfNeededListener extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        View f756a;

        AnimatorOnHWLayerIfNeededListener(View view) {
            this.f756a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f756a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f756a.setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class FragmentTag {
        public static final int[] Fragment = {R.attr.name, R.attr.id, R.attr.tag};
        public static final int Fragment_id = 1;
        public static final int Fragment_name = 0;
        public static final int Fragment_tag = 2;

        FragmentTag() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    private class PopBackStackState implements OpGenerator {

        /* renamed from: a, reason: collision with root package name */
        final String f761a;

        /* renamed from: b, reason: collision with root package name */
        final int f762b;

        /* renamed from: c, reason: collision with root package name */
        final int f763c;

        PopBackStackState(String str, int i, int i2) {
            this.f761a = str;
            this.f762b = i;
            this.f763c = i2;
        }

        @Override // android.support.v4.app.FragmentManagerImpl.OpGenerator
        public boolean generateOps(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            FragmentManager peekChildFragmentManager;
            Fragment fragment = FragmentManagerImpl.this.v;
            if (fragment == null || this.f762b >= 0 || this.f761a != null || (peekChildFragmentManager = fragment.peekChildFragmentManager()) == null || !peekChildFragmentManager.popBackStackImmediate()) {
                return FragmentManagerImpl.this.a(arrayList, arrayList2, this.f761a, this.f762b, this.f763c);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class StartEnterTransitionListener implements Fragment.OnStartEnterTransitionListener {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f765a;

        /* renamed from: b, reason: collision with root package name */
        private final BackStackRecord f766b;

        /* renamed from: c, reason: collision with root package name */
        private int f767c;

        StartEnterTransitionListener(BackStackRecord backStackRecord, boolean z) {
            this.f765a = z;
            this.f766b = backStackRecord;
        }

        public void cancelTransaction() {
            BackStackRecord backStackRecord = this.f766b;
            backStackRecord.f684a.a(backStackRecord, this.f765a, false, false);
        }

        public void completeTransaction() {
            boolean z = this.f767c > 0;
            FragmentManagerImpl fragmentManagerImpl = this.f766b.f684a;
            int size = fragmentManagerImpl.j.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = fragmentManagerImpl.j.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            BackStackRecord backStackRecord = this.f766b;
            backStackRecord.f684a.a(backStackRecord, this.f765a, !z, true);
        }

        public boolean isReady() {
            return this.f767c == 0;
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        public void onStartEnterTransition() {
            this.f767c--;
            if (this.f767c != 0) {
                return;
            }
            this.f766b.f684a.o();
        }

        @Override // android.support.v4.app.Fragment.OnStartEnterTransitionListener
        public void startListening() {
            this.f767c++;
        }
    }

    private void j() {
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.k.valueAt(size) == null) {
                    SparseArray<Fragment> sparseArray2 = this.k;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    private void k() {
        if (!isStateSaved()) {
            if (this.A == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.A);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    private void l() {
        this.f739h = false;
        this.D.clear();
        this.C.clear();
    }

    private void m() {
        SparseArray<Fragment> sparseArray = this.k;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = this.k.valueAt(i);
            if (valueAt != null) {
                if (valueAt.getAnimatingAway() != null) {
                    int stateAfterAnimating = valueAt.getStateAfterAnimating();
                    View animatingAway = valueAt.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    valueAt.setAnimatingAway(null);
                    a(valueAt, stateAfterAnimating, 0, 0, false);
                } else if (valueAt.getAnimator() != null) {
                    valueAt.getAnimator().end();
                }
            }
        }
    }

    private void n() {
        if (this.H != null) {
            while (!this.H.isEmpty()) {
                this.H.remove(0).completeTransaction();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.H == null || this.H.isEmpty()) ? false : true;
            if (this.f738g != null && this.f738g.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.s.d().removeCallbacks(this.J);
                this.s.d().post(this.J);
            }
        }
    }

    public static int reverseTransit(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    public static int transitToStyleIndex(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    public void addFragment(Fragment fragment, boolean z) {
        if (f732a) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        c(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.j.contains(fragment)) {
            synchronized (this.j) {
                this.j.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.w = true;
            }
            if (z) {
                f(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    @Override // android.support.v4.app.FragmentManager
    public void addOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        if (this.p == null) {
            this.p = new ArrayList<>();
        }
        this.p.add(onBackStackChangedListener);
    }

    public int allocBackStackIndex(BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.o != null && this.o.size() > 0) {
                int intValue = this.o.remove(this.o.size() - 1).intValue();
                if (f732a) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + backStackRecord);
                }
                this.n.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (f732a) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.n.add(backStackRecord);
            return size;
        }
    }

    public void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.s == null) {
            this.s = fragmentHostCallback;
            this.t = fragmentContainer;
            this.u = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void attachFragment(Fragment fragment) {
        if (f732a) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.j.contains(fragment)) {
                if (f732a) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.j) {
                    this.j.add(fragment);
                }
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    this.w = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.size();
    }

    @Override // android.support.v4.app.FragmentManager
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> c() {
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null) {
            return null;
        }
        int size = sparseArray.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(this.k.valueAt(i));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater.Factory2 d() {
        return this;
    }

    void d(Fragment fragment) {
        if (fragment.mIndex < 0) {
            return;
        }
        if (f732a) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.k.put(fragment.mIndex, null);
        fragment.initState();
    }

    public void detachFragment(Fragment fragment) {
        if (f732a) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            if (f732a) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.w = true;
            }
            fragment.mAdded = false;
        }
    }

    public void dispatchActivityCreated() {
        this.x = false;
        this.y = false;
        b(2);
    }

    public void dispatchConfigurationChanged(Configuration configuration) {
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchCreate() {
        this.x = false;
        this.y = false;
        b(1);
    }

    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.r < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.m != null) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                Fragment fragment2 = this.m.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.m = arrayList;
        return z;
    }

    public void dispatchDestroy() {
        this.z = true;
        execPendingActions();
        b(0);
        this.s = null;
        this.t = null;
        this.u = null;
    }

    public void dispatchDestroyView() {
        b(1);
    }

    public void dispatchLowMemory() {
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void dispatchMultiWindowModeChanged(boolean z) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.r < 1) {
            return false;
        }
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void dispatchOptionsMenuClosed(Menu menu) {
        if (this.r < 1) {
            return;
        }
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    public void dispatchPause() {
        b(4);
    }

    public void dispatchPictureInPictureModeChanged(boolean z) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        if (this.r < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.j.size(); i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public void dispatchReallyStop() {
        b(2);
    }

    public void dispatchResume() {
        this.x = false;
        this.y = false;
        b(5);
    }

    public void dispatchStart() {
        this.x = false;
        this.y = false;
        b(4);
    }

    public void dispatchStop() {
        this.y = true;
        b(3);
    }

    @Override // android.support.v4.app.FragmentManager
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment valueAt = this.k.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.dump(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.j.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                Fragment fragment = this.j.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<Fragment> arrayList = this.m;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                Fragment fragment2 = this.m.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(fragment2.toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.l;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.l.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.n != null && (size2 = this.n.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (BackStackRecord) this.n.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.o != null && this.o.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.o.toArray()));
            }
        }
        ArrayList<OpGenerator> arrayList3 = this.f738g;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (OpGenerator) this.f738g.get(i6);
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
        printWriter.print("  mHost=");
        printWriter.println(this.s);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.t);
        if (this.u != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.u);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.r);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.x);
        printWriter.print(" mStopped=");
        printWriter.print(this.y);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.z);
        if (this.w) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.w);
        }
        if (this.A != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.A);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int i = this.r;
        if (fragment.mRemoving) {
            if (fragment.isInBackStack()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, 0);
            }
        }
        a(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
        if (fragment.mView != null) {
            Fragment i2 = i(fragment);
            if (i2 != null) {
                View view = i2.mView;
                ViewGroup viewGroup = fragment.mContainer;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.mView);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.mView, indexOfChild);
                }
            }
            if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                fragment.mPostponedAlpha = 0.0f;
                fragment.mIsNewlyAdded = false;
                AnimationOrAnimator a2 = a(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                if (a2 != null) {
                    b(fragment.mView, a2);
                    Animation animation = a2.animation;
                    if (animation != null) {
                        fragment.mView.startAnimation(animation);
                    } else {
                        a2.animator.setTarget(fragment.mView);
                        a2.animator.start();
                    }
                }
            }
        }
        if (fragment.mHiddenChanged) {
            a(fragment);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0027, code lost:            return;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void enqueueAction(android.support.v4.app.FragmentManagerImpl.OpGenerator r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.k()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.z     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            android.support.v4.app.FragmentHostCallback r0 = r1.s     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<android.support.v4.app.FragmentManagerImpl$OpGenerator> r3 = r1.f738g     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.f738g = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<android.support.v4.app.FragmentManagerImpl$OpGenerator> r3 = r1.f738g     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.o()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.enqueueAction(android.support.v4.app.FragmentManagerImpl$OpGenerator, boolean):void");
    }

    public boolean execPendingActions() {
        a(true);
        boolean z = false;
        while (b(this.C, this.D)) {
            this.f739h = true;
            try {
                c(this.C, this.D);
                l();
                z = true;
            } catch (Throwable th) {
                l();
                throw th;
            }
        }
        a();
        j();
        return z;
    }

    public void execSingleAction(OpGenerator opGenerator, boolean z) {
        if (z && (this.s == null || this.z)) {
            return;
        }
        a(z);
        if (opGenerator.generateOps(this.C, this.D)) {
            this.f739h = true;
            try {
                c(this.C, this.D);
            } finally {
                l();
            }
        }
        a();
        j();
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean executePendingTransactions() {
        boolean execPendingActions = execPendingActions();
        n();
        return execPendingActions;
    }

    void f(Fragment fragment) {
        a(fragment, this.r, 0, 0, false);
    }

    @Override // android.support.v4.app.FragmentManager
    public Fragment findFragmentById(int i) {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            Fragment fragment = this.j.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.k.valueAt(size2);
            if (valueAt != null && valueAt.mFragmentId == i) {
                return valueAt;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentManager
    public Fragment findFragmentByTag(String str) {
        if (str != null) {
            for (int size = this.j.size() - 1; size >= 0; size--) {
                Fragment fragment = this.j.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.k.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.mTag)) {
                return valueAt;
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        Fragment findFragmentByWho;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment valueAt = this.k.valueAt(size);
            if (valueAt != null && (findFragmentByWho = valueAt.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public void freeBackStackIndex(int i) {
        synchronized (this) {
            this.n.set(i, null);
            if (this.o == null) {
                this.o = new ArrayList<>();
            }
            if (f732a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.o.add(Integer.valueOf(i));
        }
    }

    Bundle g(Fragment fragment) {
        Bundle bundle;
        if (this.F == null) {
            this.F = new Bundle();
        }
        fragment.performSaveInstanceState(this.F);
        d(fragment, this.F, false);
        if (this.F.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.F;
            this.F = null;
        }
        if (fragment.mView != null) {
            h(fragment);
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

    @Override // android.support.v4.app.FragmentManager
    public FragmentManager.BackStackEntry getBackStackEntryAt(int i) {
        return this.l.get(i);
    }

    @Override // android.support.v4.app.FragmentManager
    public int getBackStackEntryCount() {
        ArrayList<BackStackRecord> arrayList = this.l;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.support.v4.app.FragmentManager
    public Fragment getFragment(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = this.k.get(i);
        if (fragment != null) {
            return fragment;
        }
        a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        throw null;
    }

    @Override // android.support.v4.app.FragmentManager
    public List<Fragment> getFragments() {
        List<Fragment> list;
        if (this.j.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.j) {
            list = (List) this.j.clone();
        }
        return list;
    }

    @Override // android.support.v4.app.FragmentManager
    public Fragment getPrimaryNavigationFragment() {
        return this.v;
    }

    void h() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (this.k != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.k.size(); i++) {
                Fragment valueAt = this.k.valueAt(i);
                if (valueAt != null) {
                    if (valueAt.mRetainInstance) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        Fragment fragment = valueAt.mTarget;
                        valueAt.mTargetIndex = fragment != null ? fragment.mIndex : -1;
                        if (f732a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    FragmentManagerImpl fragmentManagerImpl = valueAt.mChildFragmentManager;
                    if (fragmentManagerImpl != null) {
                        fragmentManagerImpl.h();
                        fragmentManagerNonConfig = valueAt.mChildFragmentManager.I;
                    } else {
                        fragmentManagerNonConfig = valueAt.mChildNonConfig;
                    }
                    if (arrayList2 == null && fragmentManagerNonConfig != null) {
                        arrayList2 = new ArrayList(this.k.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(fragmentManagerNonConfig);
                    }
                    if (arrayList3 == null && valueAt.mViewModelStore != null) {
                        arrayList3 = new ArrayList(this.k.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.mViewModelStore);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.I = null;
        } else {
            this.I = new FragmentManagerNonConfig(arrayList, arrayList2, arrayList3);
        }
    }

    public void hideFragment(Fragment fragment) {
        if (f732a) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.mHidden) {
            return;
        }
        fragment.mHidden = true;
        fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
    }

    void i() {
        if (this.k == null) {
            return;
        }
        for (int i = 0; i < this.k.size(); i++) {
            Fragment valueAt = this.k.valueAt(i);
            if (valueAt != null) {
                performPendingDeferredStart(valueAt);
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean isDestroyed() {
        return this.z;
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean isStateSaved() {
        return this.x || this.y;
    }

    public void noteStateNotSaved() {
        this.I = null;
        this.x = false;
        this.y = false;
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.j.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FragmentTag.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!Fragment.isSupportFragmentClass(this.s.b(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        Fragment findFragmentById = resourceId != -1 ? findFragmentById(resourceId) : null;
        if (findFragmentById == null && string != null) {
            findFragmentById = findFragmentByTag(string);
        }
        if (findFragmentById == null && id != -1) {
            findFragmentById = findFragmentById(id);
        }
        if (f732a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + findFragmentById);
        }
        if (findFragmentById == null) {
            Fragment instantiate = this.t.instantiate(context, str2, null);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            FragmentHostCallback fragmentHostCallback = this.s;
            instantiate.mHost = fragmentHostCallback;
            instantiate.onInflate(fragmentHostCallback.b(), attributeSet, instantiate.mSavedFragmentState);
            addFragment(instantiate, true);
            fragment = instantiate;
        } else if (!findFragmentById.mInLayout) {
            findFragmentById.mInLayout = true;
            FragmentHostCallback fragmentHostCallback2 = this.s;
            findFragmentById.mHost = fragmentHostCallback2;
            if (!findFragmentById.mRetaining) {
                findFragmentById.onInflate(fragmentHostCallback2.b(), attributeSet, findFragmentById.mSavedFragmentState);
            }
            fragment = findFragmentById;
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
        }
        if (this.r < 1 && fragment.mFromLayout) {
            a(fragment, 1, 0, 0, false);
        } else {
            f(fragment);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    public void performPendingDeferredStart(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f739h) {
                this.B = true;
            } else {
                fragment.mDeferStart = false;
                a(fragment, this.r, 0, 0, false);
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack() {
        enqueueAction(new PopBackStackState(null, -1, 0), false);
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate() {
        k();
        return a((String) null, -1, 0);
    }

    @Override // android.support.v4.app.FragmentManager
    public void putFragment(Bundle bundle, String str, Fragment fragment) {
        int i = fragment.mIndex;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    @Override // android.support.v4.app.FragmentManager
    public void registerFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks, boolean z) {
        this.q.add(new Pair<>(fragmentLifecycleCallbacks, Boolean.valueOf(z)));
    }

    public void removeFragment(Fragment fragment) {
        if (f732a) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.j) {
                this.j.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                this.w = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public void removeOnBackStackChangedListener(FragmentManager.OnBackStackChangedListener onBackStackChangedListener) {
        ArrayList<FragmentManager.OnBackStackChangedListener> arrayList = this.p;
        if (arrayList != null) {
            arrayList.remove(onBackStackChangedListener);
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Bundle g2;
        if (fragment.mIndex >= 0) {
            if (fragment.mState <= 0 || (g2 = g(fragment)) == null) {
                return null;
            }
            return new Fragment.SavedState(g2);
        }
        a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    public void setBackStackIndex(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.n == null) {
                this.n = new ArrayList<>();
            }
            int size = this.n.size();
            if (i < size) {
                if (f732a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.n.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.n.add(null);
                    if (this.o == null) {
                        this.o = new ArrayList<>();
                    }
                    if (f732a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.o.add(Integer.valueOf(size));
                    size++;
                }
                if (f732a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.n.add(backStackRecord);
            }
        }
    }

    public void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null && (this.k.get(fragment.mIndex) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.v = fragment;
    }

    public void showFragment(Fragment fragment) {
        if (f732a) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.u;
        if (fragment != null) {
            DebugUtils.buildShortClassTag(fragment, sb);
        } else {
            DebugUtils.buildShortClassTag(this.s, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override // android.support.v4.app.FragmentManager
    public void unregisterFragmentLifecycleCallbacks(FragmentManager.FragmentLifecycleCallbacks fragmentLifecycleCallbacks) {
        synchronized (this.q) {
            int i = 0;
            int size = this.q.size();
            while (true) {
                if (i >= size) {
                    break;
                }
                if (this.q.get(i).first == fragmentLifecycleCallbacks) {
                    this.q.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        private AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        private AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentManagerNonConfig f() {
        a(this.I);
        return this.I;
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack(String str, int i) {
        enqueueAction(new PopBackStackState(str, -1, i), false);
    }

    static boolean a(AnimationOrAnimator animationOrAnimator) {
        Animation animation = animationOrAnimator.animation;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return a(animationOrAnimator.animator);
    }

    private static void b(View view, AnimationOrAnimator animationOrAnimator) {
        if (view == null || animationOrAnimator == null || !a(view, animationOrAnimator)) {
            return;
        }
        Animator animator = animationOrAnimator.animator;
        if (animator != null) {
            animator.addListener(new AnimatorOnHWLayerIfNeededListener(view));
            return;
        }
        Animation.AnimationListener a2 = a(animationOrAnimator.animation);
        view.setLayerType(2, null);
        animationOrAnimator.animation.setAnimationListener(new AnimateOnHWLayerIfNeededListener(view, a2));
    }

    @Override // android.support.v4.app.FragmentManager
    public void popBackStack(int i, int i2) {
        if (i >= 0) {
            enqueueAction(new PopBackStackState(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate(String str, int i) {
        k();
        return a(str, -1, i);
    }

    void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).f(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentStopped(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static class EndViewTransitionAnimator extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f757a;

        /* renamed from: b, reason: collision with root package name */
        private final View f758b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f759c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f760d;

        EndViewTransitionAnimator(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f757a = viewGroup;
            this.f758b = view;
            addAnimation(animation);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (this.f759c) {
                return !this.f760d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f759c = true;
                OneShotPreDrawListener.add(this.f757a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f757a.endViewTransition(this.f758b);
            this.f760d = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f2) {
            if (this.f759c) {
                return !this.f760d;
            }
            if (!super.getTransformation(j, transformation, f2)) {
                this.f759c = true;
                OneShotPreDrawListener.add(this.f757a, this);
            }
            return true;
        }
    }

    private Fragment i(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        View view = fragment.mView;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.j.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.j.get(indexOf);
                if (fragment2.mContainer == viewGroup && fragment2.mView != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment) {
        if (fragment.mIndex >= 0) {
            return;
        }
        int i = this.i;
        this.i = i + 1;
        fragment.setIndex(i, this.u);
        if (this.k == null) {
            this.k = new SparseArray<>();
        }
        this.k.put(fragment.mIndex, fragment);
        if (f732a) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).d(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentResumed(this, fragment);
            }
        }
    }

    @Override // android.support.v4.app.FragmentManager
    public boolean popBackStackImmediate(int i, int i2) {
        k();
        execPendingActions();
        if (i >= 0) {
            return a((String) null, i, i2);
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    static boolean a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    void b(Fragment fragment) {
        if (!fragment.mFromLayout || fragment.mPerformedCreateView) {
            return;
        }
        fragment.mView = fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            fragment.mInnerView = view;
            view.setSaveFromParentEnabled(false);
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            fragment.onViewCreated(fragment.mView, fragment.mSavedFragmentState);
            a(fragment, fragment.mView, fragment.mSavedFragmentState, false);
            return;
        }
        fragment.mInnerView = null;
    }

    private void c(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).t) {
                    if (i2 != i) {
                        b(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).t) {
                            i2++;
                        }
                    }
                    b(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                b(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    void d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).d(fragment, bundle, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentSaveInstanceState(this, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Parcelable g() {
        int[] iArr;
        int size;
        n();
        m();
        execPendingActions();
        this.x = true;
        BackStackState[] backStackStateArr = null;
        this.I = null;
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.k.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Fragment valueAt = this.k.valueAt(i);
            if (valueAt != null) {
                if (valueAt.mIndex >= 0) {
                    FragmentState fragmentState = new FragmentState(valueAt);
                    fragmentStateArr[i] = fragmentState;
                    if (valueAt.mState > 0 && fragmentState.k == null) {
                        fragmentState.k = g(valueAt);
                        Fragment fragment = valueAt.mTarget;
                        if (fragment != null) {
                            if (fragment.mIndex >= 0) {
                                if (fragmentState.k == null) {
                                    fragmentState.k = new Bundle();
                                }
                                putFragment(fragmentState.k, "android:target_state", valueAt.mTarget);
                                int i2 = valueAt.mTargetRequestCode;
                                if (i2 != 0) {
                                    fragmentState.k.putInt("android:target_req_state", i2);
                                }
                            } else {
                                a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.mTarget));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.k = valueAt.mSavedFragmentState;
                    }
                    if (f732a) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + fragmentState.k);
                    }
                    z = true;
                } else {
                    a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.mIndex));
                    throw null;
                }
            }
        }
        if (!z) {
            if (f732a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.j.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.j.get(i3).mIndex;
                if (iArr[i3] >= 0) {
                    if (f732a) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.j.get(i3));
                    }
                } else {
                    a(new IllegalStateException("Failure saving state: active " + this.j.get(i3) + " has cleared index: " + iArr[i3]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<BackStackRecord> arrayList = this.l;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (int i4 = 0; i4 < size; i4++) {
                backStackStateArr[i4] = new BackStackState(this.l.get(i4));
                if (f732a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.l.get(i4));
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f771a = fragmentStateArr;
        fragmentManagerState.f772b = iArr;
        fragmentManagerState.f773c = backStackStateArr;
        Fragment fragment2 = this.v;
        if (fragment2 != null) {
            fragmentManagerState.f774d = fragment2.mIndex;
        }
        fragmentManagerState.f775e = this.i;
        h();
        return fragmentManagerState;
    }

    static boolean a(View view, AnimationOrAnimator animationOrAnimator) {
        return view != null && animationOrAnimator != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.hasOverlappingRendering(view) && a(animationOrAnimator);
    }

    private void b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).t;
        ArrayList<Fragment> arrayList3 = this.E;
        if (arrayList3 == null) {
            this.E = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.E.addAll(this.j);
        Fragment primaryNavigationFragment = getPrimaryNavigationFragment();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            BackStackRecord backStackRecord = arrayList.get(i6);
            if (!arrayList2.get(i6).booleanValue()) {
                primaryNavigationFragment = backStackRecord.a(this.E, primaryNavigationFragment);
            } else {
                primaryNavigationFragment = backStackRecord.b(this.E, primaryNavigationFragment);
            }
            z2 = z2 || backStackRecord.i;
        }
        this.E.clear();
        if (!z) {
            FragmentTransition.a(this, arrayList, arrayList2, i, i2, false);
        }
        a(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            a(arraySet);
            int a2 = a(arrayList, arrayList2, i, i2, arraySet);
            b(arraySet);
            i3 = a2;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            FragmentTransition.a(this, arrayList, arrayList2, i, i3, true);
            a(this.r, true);
        }
        while (i5 < i2) {
            BackStackRecord backStackRecord2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = backStackRecord2.m) >= 0) {
                freeBackStackIndex(i4);
                backStackRecord2.m = -1;
            }
            backStackRecord2.runOnCommitRunnables();
            i5++;
        }
        if (z2) {
            e();
        }
    }

    private void a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback fragmentHostCallback = this.s;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.onDump("  ", null, printWriter, new String[0]);
                throw runtimeException;
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
                throw runtimeException;
            }
        }
        try {
            dump("  ", null, printWriter, new String[0]);
            throw runtimeException;
        } catch (Exception e3) {
            Log.e("FragmentManager", "Failed dumping state", e3);
            throw runtimeException;
        }
    }

    void h(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.G;
        if (sparseArray == null) {
            this.G = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.G);
        if (this.G.size() > 0) {
            fragment.mSavedViewState = this.G;
            this.G = null;
        }
    }

    void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).c(fragment, bundle, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentPreCreated(this, fragment, bundle);
            }
        }
    }

    void e() {
        if (this.p != null) {
            for (int i = 0; i < this.p.size(); i++) {
                this.p.get(i).onBackStackChanged();
            }
        }
    }

    void c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).c(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentPaused(this, fragment);
            }
        }
    }

    private boolean a(String str, int i, int i2) {
        FragmentManager peekChildFragmentManager;
        execPendingActions();
        a(true);
        Fragment fragment = this.v;
        if (fragment != null && i < 0 && str == null && (peekChildFragmentManager = fragment.peekChildFragmentManager()) != null && peekChildFragmentManager.popBackStackImmediate()) {
            return true;
        }
        boolean a2 = a(this.C, this.D, str, i, i2);
        if (a2) {
            this.f739h = true;
            try {
                c(this.C, this.D);
            } finally {
                l();
            }
        }
        a();
        j();
        return a2;
    }

    void e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).e(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentStarted(this, fragment);
            }
        }
    }

    static AnimationOrAnimator a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f734c);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f735d);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new AnimationOrAnimator(animationSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    private void b(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = arraySet.valueAt(i);
            if (!valueAt.mAdded) {
                View view = valueAt.getView();
                valueAt.mPostponedAlpha = view.getAlpha();
                view.setAlpha(0.0f);
            }
        }
    }

    private boolean b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f738g != null && this.f738g.size() != 0) {
                int size = this.f738g.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.f738g.get(i).generateOps(arrayList, arrayList2);
                }
                this.f738g.clear();
                this.s.d().removeCallbacks(this.J);
                return z;
            }
            return false;
        }
    }

    static AnimationOrAnimator a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f735d);
        alphaAnimation.setDuration(220L);
        return new AnimationOrAnimator(alphaAnimation);
    }

    AnimationOrAnimator a(Fragment fragment, int i, boolean z, int i2) {
        int transitToStyleIndex;
        int nextAnim = fragment.getNextAnim();
        Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(this.s.b().getResources().getResourceTypeName(nextAnim));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.s.b(), nextAnim);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.s.b(), nextAnim);
                    if (loadAnimator != null) {
                        return new AnimationOrAnimator(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.s.b(), nextAnim);
                        if (loadAnimation2 != null) {
                            return new AnimationOrAnimator(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        if (i == 0 || (transitToStyleIndex = transitToStyleIndex(i, z)) < 0) {
            return null;
        }
        switch (transitToStyleIndex) {
            case 1:
                return a(this.s.b(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return a(this.s.b(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return a(this.s.b(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return a(this.s.b(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return a(this.s.b(), 0.0f, 1.0f);
            case 6:
                return a(this.s.b(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.s.onHasWindowAnimations()) {
                    i2 = this.s.onGetWindowAnimations();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    private void b(int i) {
        try {
            this.f739h = true;
            a(i, false);
            this.f739h = false;
            execPendingActions();
        } catch (Throwable th) {
            this.f739h = false;
            throw th;
        }
    }

    void b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, context, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentPreAttached(this, fragment, context);
            }
        }
    }

    void g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).g(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentViewDestroyed(this, fragment);
            }
        }
    }

    void b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, bundle, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentCreated(this, fragment, bundle);
            }
        }
    }

    private static Animation.AnimationListener a(Animation animation) {
        try {
            if (f733b == null) {
                f733b = Animation.class.getDeclaredField("mListener");
                f733b.setAccessible(true);
            }
            return (Animation.AnimationListener) f733b.get(animation);
        } catch (IllegalAccessException e2) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
            return null;
        } catch (NoSuchFieldException e3) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e3);
            return null;
        }
    }

    void b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).b(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentDetached(this, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return this.r >= i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:            if (r0 != 4) goto L231;     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.support.v4.app.Fragment r18, int r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1148
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentManagerImpl.a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    private void a(final Fragment fragment, AnimationOrAnimator animationOrAnimator, int i) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        fragment.setStateAfterAnimating(i);
        Animation animation = animationOrAnimator.animation;
        if (animation != null) {
            EndViewTransitionAnimator endViewTransitionAnimator = new EndViewTransitionAnimator(animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimator.setAnimationListener(new AnimationListenerWrapper(a(endViewTransitionAnimator)) { // from class: android.support.v4.app.FragmentManagerImpl.2
                @Override // android.support.v4.app.FragmentManagerImpl.AnimationListenerWrapper, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation2) {
                    super.onAnimationEnd(animation2);
                    viewGroup.post(new Runnable() { // from class: android.support.v4.app.FragmentManagerImpl.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                                Fragment fragment2 = fragment;
                                fragmentManagerImpl.a(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            b(view, animationOrAnimator);
            fragment.mView.startAnimation(endViewTransitionAnimator);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animator);
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                FragmentManagerImpl fragmentManagerImpl = FragmentManagerImpl.this;
                Fragment fragment2 = fragment;
                fragmentManagerImpl.a(fragment2, fragment2.getStateAfterAnimating(), 0, 0, false);
            }
        });
        animator.setTarget(fragment.mView);
        b(fragment.mView, animationOrAnimator);
        animator.start();
    }

    void a(final Fragment fragment) {
        Animator animator;
        if (fragment.mView != null) {
            AnimationOrAnimator a2 = a(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
            if (a2 != null && (animator = a2.animator) != null) {
                animator.setTarget(fragment.mView);
                if (fragment.mHidden) {
                    if (fragment.isHideReplaced()) {
                        fragment.setHideReplaced(false);
                    } else {
                        final ViewGroup viewGroup = fragment.mContainer;
                        final View view = fragment.mView;
                        viewGroup.startViewTransition(view);
                        a2.animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.FragmentManagerImpl.4
                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public void onAnimationEnd(Animator animator2) {
                                viewGroup.endViewTransition(view);
                                animator2.removeListener(this);
                                View view2 = fragment.mView;
                                if (view2 != null) {
                                    view2.setVisibility(8);
                                }
                            }
                        });
                    }
                } else {
                    fragment.mView.setVisibility(0);
                }
                b(fragment.mView, a2);
                a2.animator.start();
            } else {
                if (a2 != null) {
                    b(fragment.mView, a2);
                    fragment.mView.startAnimation(a2.animation);
                    a2.animation.start();
                }
                fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                if (fragment.isHideReplaced()) {
                    fragment.setHideReplaced(false);
                }
            }
        }
        if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
            this.w = true;
        }
        fragment.mHiddenChanged = false;
        fragment.onHiddenChanged(fragment.mHidden);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.s == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.r) {
            this.r = i;
            if (this.k != null) {
                int size = this.j.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e(this.j.get(i2));
                }
                int size2 = this.k.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment valueAt = this.k.valueAt(i3);
                    if (valueAt != null && ((valueAt.mRemoving || valueAt.mDetached) && !valueAt.mIsNewlyAdded)) {
                        e(valueAt);
                    }
                }
                i();
                if (this.w && (fragmentHostCallback = this.s) != null && this.r == 5) {
                    fragmentHostCallback.onSupportInvalidateOptionsMenu();
                    this.w = false;
                }
            }
        }
    }

    private void a(boolean z) {
        if (!this.f739h) {
            if (this.s != null) {
                if (Looper.myLooper() == this.s.d().getLooper()) {
                    if (!z) {
                        k();
                    }
                    if (this.C == null) {
                        this.C = new ArrayList<>();
                        this.D = new ArrayList<>();
                    }
                    this.f739h = true;
                    try {
                        a((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
                        return;
                    } finally {
                        this.f739h = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    private void a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<StartEnterTransitionListener> arrayList3 = this.H;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            StartEnterTransitionListener startEnterTransitionListener = this.H.get(i);
            if (arrayList != null && !startEnterTransitionListener.f765a && (indexOf2 = arrayList.indexOf(startEnterTransitionListener.f766b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                startEnterTransitionListener.cancelTransaction();
            } else if (startEnterTransitionListener.isReady() || (arrayList != null && startEnterTransitionListener.f766b.a(arrayList, 0, arrayList.size()))) {
                this.H.remove(i);
                i--;
                size--;
                if (arrayList != null && !startEnterTransitionListener.f765a && (indexOf = arrayList.indexOf(startEnterTransitionListener.f766b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                    startEnterTransitionListener.cancelTransaction();
                } else {
                    startEnterTransitionListener.completeTransaction();
                }
            }
            i++;
        }
    }

    private int a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.b() && !backStackRecord.a(arrayList, i4 + 1, i2)) {
                if (this.H == null) {
                    this.H = new ArrayList<>();
                }
                StartEnterTransitionListener startEnterTransitionListener = new StartEnterTransitionListener(backStackRecord, booleanValue);
                this.H.add(startEnterTransitionListener);
                backStackRecord.a(startEnterTransitionListener);
                if (booleanValue) {
                    backStackRecord.a();
                } else {
                    backStackRecord.b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                a(arraySet);
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.b(z3);
        } else {
            backStackRecord.a();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.a(this, (ArrayList<BackStackRecord>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            a(this.r, true);
        }
        SparseArray<Fragment> sparseArray = this.k;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                Fragment valueAt = this.k.valueAt(i);
                if (valueAt != null && valueAt.mView != null && valueAt.mIsNewlyAdded && backStackRecord.b(valueAt.mContainerId)) {
                    float f2 = valueAt.mPostponedAlpha;
                    if (f2 > 0.0f) {
                        valueAt.mView.setAlpha(f2);
                    }
                    if (z3) {
                        valueAt.mPostponedAlpha = 0.0f;
                    } else {
                        valueAt.mPostponedAlpha = -1.0f;
                        valueAt.mIsNewlyAdded = false;
                    }
                }
            }
        }
    }

    private static void a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.a(-1);
                backStackRecord.b(i == i2 + (-1));
            } else {
                backStackRecord.a(1);
                backStackRecord.a();
            }
            i++;
        }
    }

    private void a(ArraySet<Fragment> arraySet) {
        int i = this.r;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 4);
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.j.get(i2);
            if (fragment.mState < min) {
                a(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    void a() {
        if (this.B) {
            this.B = false;
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(BackStackRecord backStackRecord) {
        if (this.l == null) {
            this.l = new ArrayList<>();
        }
        this.l.add(backStackRecord);
    }

    boolean a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        ArrayList<BackStackRecord> arrayList3 = this.l;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.l.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.l.size() - 1;
                while (size >= 0) {
                    BackStackRecord backStackRecord = this.l.get(size);
                    if ((str != null && str.equals(backStackRecord.getName())) || (i >= 0 && i == backStackRecord.m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.l.get(size);
                        if (str == null || !str.equals(backStackRecord2.getName())) {
                            if (i < 0 || i != backStackRecord2.m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.l.size() - 1) {
                return false;
            }
            for (int size3 = this.l.size() - 1; size3 > size; size3--) {
                arrayList.add(this.l.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    private static void a(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig == null) {
            return;
        }
        List<Fragment> b2 = fragmentManagerNonConfig.b();
        if (b2 != null) {
            Iterator<Fragment> it = b2.iterator();
            while (it.hasNext()) {
                it.next().mRetaining = true;
            }
        }
        List<FragmentManagerNonConfig> a2 = fragmentManagerNonConfig.a();
        if (a2 != null) {
            Iterator<FragmentManagerNonConfig> it2 = a2.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        List<FragmentManagerNonConfig> list;
        List<r> list2;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f771a == null) {
            return;
        }
        if (fragmentManagerNonConfig != null) {
            List<Fragment> b2 = fragmentManagerNonConfig.b();
            list = fragmentManagerNonConfig.a();
            list2 = fragmentManagerNonConfig.c();
            int size = b2 != null ? b2.size() : 0;
            for (int i = 0; i < size; i++) {
                Fragment fragment = b2.get(i);
                if (f732a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                int i2 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr = fragmentManagerState.f771a;
                    if (i2 >= fragmentStateArr.length || fragmentStateArr[i2].f780b == fragment.mIndex) {
                        break;
                    } else {
                        i2++;
                    }
                }
                FragmentState[] fragmentStateArr2 = fragmentManagerState.f771a;
                if (i2 != fragmentStateArr2.length) {
                    FragmentState fragmentState = fragmentStateArr2[i2];
                    fragmentState.l = fragment;
                    fragment.mSavedViewState = null;
                    fragment.mBackStackNesting = 0;
                    fragment.mInLayout = false;
                    fragment.mAdded = false;
                    fragment.mTarget = null;
                    Bundle bundle = fragmentState.k;
                    if (bundle != null) {
                        bundle.setClassLoader(this.s.b().getClassLoader());
                        fragment.mSavedViewState = fragmentState.k.getSparseParcelableArray("android:view_state");
                        fragment.mSavedFragmentState = fragmentState.k;
                    }
                } else {
                    a(new IllegalStateException("Could not find active fragment with index " + fragment.mIndex));
                    throw null;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.k = new SparseArray<>(fragmentManagerState.f771a.length);
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr3 = fragmentManagerState.f771a;
            if (i3 >= fragmentStateArr3.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr3[i3];
            if (fragmentState2 != null) {
                Fragment instantiate = fragmentState2.instantiate(this.s, this.t, this.u, (list == null || i3 >= list.size()) ? null : list.get(i3), (list2 == null || i3 >= list2.size()) ? null : list2.get(i3));
                if (f732a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + instantiate);
                }
                this.k.put(instantiate.mIndex, instantiate);
                fragmentState2.l = null;
            }
            i3++;
        }
        if (fragmentManagerNonConfig != null) {
            List<Fragment> b3 = fragmentManagerNonConfig.b();
            int size2 = b3 != null ? b3.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                Fragment fragment2 = b3.get(i4);
                int i5 = fragment2.mTargetIndex;
                if (i5 >= 0) {
                    fragment2.mTarget = this.k.get(i5);
                    if (fragment2.mTarget == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.mTargetIndex);
                    }
                }
            }
        }
        this.j.clear();
        if (fragmentManagerState.f772b != null) {
            int i6 = 0;
            while (true) {
                int[] iArr = fragmentManagerState.f772b;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.k.get(iArr[i6]);
                if (fragment3 != null) {
                    fragment3.mAdded = true;
                    if (f732a) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + fragment3);
                    }
                    if (!this.j.contains(fragment3)) {
                        synchronized (this.j) {
                            this.j.add(fragment3);
                        }
                        i6++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    a(new IllegalStateException("No instantiated fragment for index #" + fragmentManagerState.f772b[i6]));
                    throw null;
                }
            }
        }
        BackStackState[] backStackStateArr = fragmentManagerState.f773c;
        if (backStackStateArr != null) {
            this.l = new ArrayList<>(backStackStateArr.length);
            int i7 = 0;
            while (true) {
                BackStackState[] backStackStateArr2 = fragmentManagerState.f773c;
                if (i7 >= backStackStateArr2.length) {
                    break;
                }
                BackStackRecord instantiate2 = backStackStateArr2[i7].instantiate(this);
                if (f732a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + instantiate2.m + "): " + instantiate2);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    instantiate2.dump("  ", printWriter, false);
                    printWriter.close();
                }
                this.l.add(instantiate2);
                int i8 = instantiate2.m;
                if (i8 >= 0) {
                    setBackStackIndex(i8, instantiate2);
                }
                i7++;
            }
        } else {
            this.l = null;
        }
        int i9 = fragmentManagerState.f774d;
        if (i9 >= 0) {
            this.v = this.k.get(i9);
        }
        this.i = fragmentManagerState.f775e;
    }

    void a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, context, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentAttached(this, fragment, context);
            }
        }
    }

    void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, bundle, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentActivityCreated(this, fragment, bundle);
            }
        }
    }

    void a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, view, bundle, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentViewCreated(this, fragment, view, bundle);
            }
        }
    }

    void a(Fragment fragment, boolean z) {
        Fragment fragment2 = this.u;
        if (fragment2 != null) {
            FragmentManager fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof FragmentManagerImpl) {
                ((FragmentManagerImpl) fragmentManager).a(fragment, true);
            }
        }
        Iterator<Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean>> it = this.q.iterator();
        while (it.hasNext()) {
            Pair<FragmentManager.FragmentLifecycleCallbacks, Boolean> next = it.next();
            if (!z || next.second.booleanValue()) {
                next.first.onFragmentDestroyed(this, fragment);
            }
        }
    }
}
