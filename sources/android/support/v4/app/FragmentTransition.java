package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentTransition {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f806a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* renamed from: b, reason: collision with root package name */
    private static final FragmentTransitionImpl f807b;

    /* renamed from: c, reason: collision with root package name */
    private static final FragmentTransitionImpl f808c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FragmentContainerTransition {
        public Fragment firstOut;
        public boolean firstOutIsPop;
        public BackStackRecord firstOutTransaction;
        public Fragment lastIn;
        public boolean lastInIsPop;
        public BackStackRecord lastInTransaction;

        FragmentContainerTransition() {
        }
    }

    static {
        f807b = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        f808c = b();
    }

    FragmentTransition() {
    }

    private static FragmentTransitionImpl b() {
        try {
            return (FragmentTransitionImpl) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static ArrayMap<String, View> c(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!arrayMap.isEmpty() && obj != null) {
            Fragment fragment = fragmentContainerTransition.firstOut;
            ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
            fragmentTransitionImpl.a(arrayMap2, fragment.getView());
            BackStackRecord backStackRecord = fragmentContainerTransition.firstOutTransaction;
            if (fragmentContainerTransition.firstOutIsPop) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = backStackRecord.s;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = backStackRecord.r;
            }
            arrayMap2.retainAll(arrayList);
            if (exitTransitionCallback != null) {
                exitTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view = arrayMap2.get(str);
                    if (view == null) {
                        arrayMap.remove(str);
                    } else if (!str.equals(ViewCompat.getTransitionName(view))) {
                        arrayMap.put(ViewCompat.getTransitionName(view), arrayMap.remove(str));
                    }
                }
            } else {
                arrayMap.retainAll(arrayMap2.keySet());
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        int size = backStackRecord.f685b.size();
        for (int i = 0; i < size; i++) {
            a(backStackRecord, backStackRecord.f685b.get(i), sparseArray, false, z);
        }
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean z) {
        if (backStackRecord.f684a.t.onHasView()) {
            for (int size = backStackRecord.f685b.size() - 1; size >= 0; size--) {
                a(backStackRecord, backStackRecord.f685b.get(size), sparseArray, true, z);
            }
        }
    }

    private static void b(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl a2;
        Object obj;
        ViewGroup viewGroup = fragmentManagerImpl.t.onHasView() ? (ViewGroup) fragmentManagerImpl.t.onFindViewById(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        Object b3 = b(a2, viewGroup, view, arrayMap, fragmentContainerTransition, arrayList2, arrayList, a3, b2);
        if (a3 == null && b3 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> b4 = b(a2, obj, fragment2, arrayList2, view);
        ArrayList<View> b5 = b(a2, a3, fragment, arrayList, view);
        b(b5, 4);
        Object a4 = a(a2, a3, obj, b3, fragment, z);
        if (a4 != null) {
            a(a2, obj, fragment2, b4);
            ArrayList<String> a5 = a2.a(arrayList);
            a2.scheduleRemoveTargets(a4, a3, b5, obj, b4, b3, arrayList);
            a2.beginDelayedTransition(viewGroup, a4);
            a2.a(viewGroup, arrayList2, arrayList, a5, arrayMap);
            b(b5, 0);
            a2.swapSharedElementTargets(b3, arrayList2, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(FragmentManagerImpl fragmentManagerImpl, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (fragmentManagerImpl.r < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            BackStackRecord backStackRecord = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                calculatePopFragments(backStackRecord, sparseArray, z);
            } else {
                calculateFragments(backStackRecord, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(fragmentManagerImpl.s.b());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                ArrayMap<String, String> a2 = a(keyAt, arrayList, arrayList2, i, i2);
                FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition) sparseArray.valueAt(i4);
                if (z) {
                    b(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, a2);
                } else {
                    a(fragmentManagerImpl, keyAt, fragmentContainerTransition, view, a2);
                }
            }
        }
    }

    private static ArrayMap<String, String> a(int i, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ArrayMap<String, String> arrayMap = new ArrayMap<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            if (backStackRecord.b(i)) {
                boolean booleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = backStackRecord.r;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = backStackRecord.r;
                        arrayList4 = backStackRecord.s;
                    } else {
                        ArrayList<String> arrayList6 = backStackRecord.r;
                        arrayList3 = backStackRecord.s;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String remove = arrayMap.remove(str2);
                        if (remove != null) {
                            arrayMap.put(str, remove);
                        } else {
                            arrayMap.put(str, str2);
                        }
                    }
                }
            }
        }
        return arrayMap;
    }

    private static Object b(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return fragmentTransitionImpl.cloneTransition(exitTransition);
    }

    private static Object b(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.getView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        Object a2 = arrayMap.isEmpty() ? null : a(fragmentTransitionImpl, fragment, fragment2, z);
        ArrayMap<String, View> c2 = c(fragmentTransitionImpl, arrayMap, a2, fragmentContainerTransition);
        final ArrayMap<String, View> b2 = b(fragmentTransitionImpl, arrayMap, a2, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            if (c2 != null) {
                c2.clear();
            }
            if (b2 != null) {
                b2.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, c2, arrayMap.keySet());
            a(arrayList2, b2, arrayMap.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(fragment, fragment2, z, c2, true);
        if (obj3 != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            a(fragmentTransitionImpl, obj3, obj2, c2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            Rect rect2 = new Rect();
            View b3 = b(b2, fragmentContainerTransition, obj, z);
            if (b3 != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect2);
            }
            rect = rect2;
            view2 = b3;
        } else {
            view2 = null;
            rect = null;
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.3
            @Override // java.lang.Runnable
            public void run() {
                FragmentTransition.b(Fragment.this, fragment2, z, (ArrayMap<String, View>) b2, false);
                View view3 = view2;
                if (view3 != null) {
                    fragmentTransitionImpl.a(view3, rect);
                }
            }
        });
        return obj3;
    }

    private static void a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, final ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            fragmentTransitionImpl.scheduleHideFragmentView(obj, fragment.getView(), arrayList);
            OneShotPreDrawListener.add(fragment.mContainer, new Runnable() { // from class: android.support.v4.app.FragmentTransition.1
                @Override // java.lang.Runnable
                public void run() {
                    FragmentTransition.b(arrayList, 4);
                }
            });
        }
    }

    private static void a(FragmentManagerImpl fragmentManagerImpl, int i, FragmentContainerTransition fragmentContainerTransition, View view, ArrayMap<String, String> arrayMap) {
        Fragment fragment;
        Fragment fragment2;
        FragmentTransitionImpl a2;
        Object obj;
        ViewGroup viewGroup = fragmentManagerImpl.t.onHasView() ? (ViewGroup) fragmentManagerImpl.t.onFindViewById(i) : null;
        if (viewGroup == null || (a2 = a((fragment2 = fragmentContainerTransition.firstOut), (fragment = fragmentContainerTransition.lastIn))) == null) {
            return;
        }
        boolean z = fragmentContainerTransition.lastInIsPop;
        boolean z2 = fragmentContainerTransition.firstOutIsPop;
        Object a3 = a(a2, fragment, z);
        Object b2 = b(a2, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object a4 = a(a2, viewGroup, view, arrayMap, fragmentContainerTransition, (ArrayList<View>) arrayList, arrayList2, a3, b2);
        if (a3 == null && a4 == null) {
            obj = b2;
            if (obj == null) {
                return;
            }
        } else {
            obj = b2;
        }
        ArrayList<View> b3 = b(a2, obj, fragment2, (ArrayList<View>) arrayList, view);
        Object obj2 = (b3 == null || b3.isEmpty()) ? null : obj;
        a2.addTarget(a3, view);
        Object a5 = a(a2, a3, obj2, a4, fragment, fragmentContainerTransition.lastInIsPop);
        if (a5 != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            a2.scheduleRemoveTargets(a5, a3, arrayList3, obj2, b3, a4, arrayList2);
            a(a2, viewGroup, fragment, view, arrayList2, a3, arrayList3, obj2, b3);
            a2.a((View) viewGroup, arrayList2, (Map<String, String>) arrayMap);
            a2.beginDelayedTransition(viewGroup, a5);
            a2.a(viewGroup, arrayList2, (Map<String, String>) arrayMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayMap<String, View> b(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap<String, String> arrayMap, Object obj, FragmentContainerTransition fragmentContainerTransition) {
        SharedElementCallback enterTransitionCallback;
        ArrayList<String> arrayList;
        String a2;
        Fragment fragment = fragmentContainerTransition.lastIn;
        View view = fragment.getView();
        if (!arrayMap.isEmpty() && obj != null && view != null) {
            ArrayMap<String, View> arrayMap2 = new ArrayMap<>();
            fragmentTransitionImpl.a(arrayMap2, view);
            BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
            if (fragmentContainerTransition.lastInIsPop) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = backStackRecord.r;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = backStackRecord.s;
            }
            if (arrayList != null) {
                arrayMap2.retainAll(arrayList);
                arrayMap2.retainAll(arrayMap.values());
            }
            if (enterTransitionCallback != null) {
                enterTransitionCallback.onMapSharedElements(arrayList, arrayMap2);
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    String str = arrayList.get(size);
                    View view2 = arrayMap2.get(str);
                    if (view2 == null) {
                        String a3 = a(arrayMap, str);
                        if (a3 != null) {
                            arrayMap.remove(a3);
                        }
                    } else if (!str.equals(ViewCompat.getTransitionName(view2)) && (a2 = a(arrayMap, str)) != null) {
                        arrayMap.put(a2, ViewCompat.getTransitionName(view2));
                    }
                }
            } else {
                a(arrayMap, arrayMap2);
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }

    private static void a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final Fragment fragment, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.2
            @Override // java.lang.Runnable
            public void run() {
                Object obj3 = obj;
                if (obj3 != null) {
                    fragmentTransitionImpl.removeTarget(obj3, view);
                    arrayList2.addAll(FragmentTransition.b(fragmentTransitionImpl, obj, fragment, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        fragmentTransitionImpl.replaceTargets(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    private static FragmentTransitionImpl a(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        FragmentTransitionImpl fragmentTransitionImpl = f807b;
        if (fragmentTransitionImpl != null && a(fragmentTransitionImpl, arrayList)) {
            return f807b;
        }
        FragmentTransitionImpl fragmentTransitionImpl2 = f808c;
        if (fragmentTransitionImpl2 != null && a(fragmentTransitionImpl2, arrayList)) {
            return f808c;
        }
        if (f807b == null && f808c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static View b(ArrayMap<String, View> arrayMap, FragmentContainerTransition fragmentContainerTransition, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        BackStackRecord backStackRecord = fragmentContainerTransition.lastInTransaction;
        if (obj == null || arrayMap == null || (arrayList = backStackRecord.r) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = backStackRecord.r.get(0);
        } else {
            str = backStackRecord.s.get(0);
        }
        return arrayMap.get(str);
    }

    private static boolean a(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!fragmentTransitionImpl.canHandle(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Fragment fragment, Fragment fragment2, boolean z, ArrayMap<String, View> arrayMap, boolean z2) {
        SharedElementCallback enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = arrayMap == null ? 0 : arrayMap.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(arrayMap.keyAt(i));
                arrayList.add(arrayMap.valueAt(i));
            }
            if (z2) {
                enterTransitionCallback.onSharedElementStart(arrayList2, arrayList, null);
            } else {
                enterTransitionCallback.onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(sharedElementEnterTransition));
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return fragmentTransitionImpl.cloneTransition(enterTransition);
    }

    private static void a(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View valueAt = arrayMap.valueAt(size);
            if (collection.contains(ViewCompat.getTransitionName(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ArrayList<View> b(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View view2 = fragment.getView();
        if (view2 != null) {
            fragmentTransitionImpl.a(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        fragmentTransitionImpl.addTargets(obj, arrayList2);
        return arrayList2;
    }

    private static Object a(final FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, final View view, final ArrayMap<String, String> arrayMap, final FragmentContainerTransition fragmentContainerTransition, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object a2;
        ArrayMap<String, String> arrayMap2;
        Object obj3;
        Rect rect;
        final Fragment fragment = fragmentContainerTransition.lastIn;
        final Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        final boolean z = fragmentContainerTransition.lastInIsPop;
        if (arrayMap.isEmpty()) {
            arrayMap2 = arrayMap;
            a2 = null;
        } else {
            a2 = a(fragmentTransitionImpl, fragment, fragment2, z);
            arrayMap2 = arrayMap;
        }
        ArrayMap<String, View> c2 = c(fragmentTransitionImpl, arrayMap2, a2, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(c2.values());
            obj3 = a2;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        b(fragment, fragment2, z, c2, true);
        if (obj3 != null) {
            rect = new Rect();
            fragmentTransitionImpl.setSharedElementTargets(obj3, view, arrayList);
            a(fragmentTransitionImpl, obj3, obj2, c2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            if (obj != null) {
                fragmentTransitionImpl.setEpicenter(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransition.4
            @Override // java.lang.Runnable
            public void run() {
                ArrayMap b2 = FragmentTransition.b(FragmentTransitionImpl.this, (ArrayMap<String, String>) arrayMap, obj4, fragmentContainerTransition);
                if (b2 != null) {
                    arrayList2.addAll(b2.values());
                    arrayList2.add(view);
                }
                FragmentTransition.b(fragment, fragment2, z, (ArrayMap<String, View>) b2, false);
                Object obj5 = obj4;
                if (obj5 != null) {
                    FragmentTransitionImpl.this.swapSharedElementTargets(obj5, arrayList, arrayList2);
                    View b3 = FragmentTransition.b((ArrayMap<String, View>) b2, fragmentContainerTransition, obj, z);
                    if (b3 != null) {
                        FragmentTransitionImpl.this.a(b3, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    private static String a(ArrayMap<String, String> arrayMap, String str) {
        int size = arrayMap.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(arrayMap.valueAt(i))) {
                return arrayMap.keyAt(i);
            }
        }
        return null;
    }

    private static void a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, ArrayMap<String, View> arrayMap, boolean z, BackStackRecord backStackRecord) {
        String str;
        ArrayList<String> arrayList = backStackRecord.r;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = backStackRecord.s.get(0);
        } else {
            str = backStackRecord.r.get(0);
        }
        View view = arrayMap.get(str);
        fragmentTransitionImpl.setEpicenter(obj, view);
        if (obj2 != null) {
            fragmentTransitionImpl.setEpicenter(obj2, view);
        }
    }

    private static void a(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    private static Object a(FragmentTransitionImpl fragmentTransitionImpl, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj, obj3);
        }
        return fragmentTransitionImpl.mergeTransitionsInSequence(obj2, obj, obj3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f807b == null && f808c == null) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0092, code lost:            if (r10.mHidden == false) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:            if (r10.mAdded != false) goto L70;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0094, code lost:            r1 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0076, code lost:            r1 = true;     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(android.support.v4.app.BackStackRecord r16, android.support.v4.app.BackStackRecord.Op r17, android.util.SparseArray<android.support.v4.app.FragmentTransition.FragmentContainerTransition> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.FragmentTransition.a(android.support.v4.app.BackStackRecord, android.support.v4.app.BackStackRecord$Op, android.util.SparseArray, boolean, boolean):void");
    }

    private static FragmentContainerTransition a(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int i) {
        if (fragmentContainerTransition != null) {
            return fragmentContainerTransition;
        }
        FragmentContainerTransition fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(i, fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }
}
