package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.app.FragmentTransitionImpl$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f847a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f848b;

        /* renamed from: c */
        final /* synthetic */ ArrayList f849c;

        /* renamed from: d */
        final /* synthetic */ ArrayList f850d;

        /* renamed from: e */
        final /* synthetic */ ArrayList f851e;

        AnonymousClass1(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            size = i;
            arrayList2 = arrayList;
            arrayList3 = arrayList2;
            arrayList = arrayList3;
            arrayList4 = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < size; i++) {
                ViewCompat.setTransitionName((View) arrayList2.get(i), (String) arrayList3.get(i));
                ViewCompat.setTransitionName((View) arrayList.get(i), (String) arrayList4.get(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.app.FragmentTransitionImpl$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f853a;

        /* renamed from: b */
        final /* synthetic */ Map f854b;

        AnonymousClass2(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                String transitionName = ViewCompat.getTransitionName(view);
                if (transitionName != null) {
                    ViewCompat.setTransitionName(view, FragmentTransitionImpl.a((Map<String, String>) map, transitionName));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.app.FragmentTransitionImpl$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ArrayList f856a;

        /* renamed from: b */
        final /* synthetic */ Map f857b;

        AnonymousClass3(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                ViewCompat.setTransitionName(view, (String) map.get(ViewCompat.getTransitionName(view)));
            }
        }
    }

    public void a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract void addTarget(Object obj, View view);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public abstract Object cloneTransition(Object obj);

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public abstract void removeTarget(Object obj, View view);

    public abstract void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(Object obj, Rect rect);

    public abstract void setEpicenter(Object obj, View view);

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);

    public ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(ViewCompat.getTransitionName(view));
            ViewCompat.setTransitionName(view, null);
        }
        return arrayList2;
    }

    public void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String transitionName = ViewCompat.getTransitionName(view2);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                ViewCompat.setTransitionName(view2, null);
                String str = map.get(transitionName);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        ViewCompat.setTransitionName(arrayList2.get(i2), transitionName);
                        break;
                    }
                    i2++;
                }
            }
        }
        OneShotPreDrawListener.add(view, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.1

            /* renamed from: a */
            final /* synthetic */ int f847a;

            /* renamed from: b */
            final /* synthetic */ ArrayList f848b;

            /* renamed from: c */
            final /* synthetic */ ArrayList f849c;

            /* renamed from: d */
            final /* synthetic */ ArrayList f850d;

            /* renamed from: e */
            final /* synthetic */ ArrayList f851e;

            AnonymousClass1(int size2, ArrayList arrayList22, ArrayList arrayList32, ArrayList arrayList5, ArrayList arrayList42) {
                size = size2;
                arrayList2 = arrayList22;
                arrayList3 = arrayList32;
                arrayList = arrayList5;
                arrayList4 = arrayList42;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    ViewCompat.setTransitionName((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    ViewCompat.setTransitionName((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(view, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.2

            /* renamed from: a */
            final /* synthetic */ ArrayList f853a;

            /* renamed from: b */
            final /* synthetic */ Map f854b;

            AnonymousClass2(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String transitionName = ViewCompat.getTransitionName(view2);
                    if (transitionName != null) {
                        ViewCompat.setTransitionName(view2, FragmentTransitionImpl.a((Map<String, String>) map, transitionName));
                    }
                }
            }
        });
    }

    public void a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: android.support.v4.app.FragmentTransitionImpl.3

            /* renamed from: a */
            final /* synthetic */ ArrayList f856a;

            /* renamed from: b */
            final /* synthetic */ Map f857b;

            AnonymousClass3(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    ViewCompat.setTransitionName(view, (String) map.get(ViewCompat.getTransitionName(view)));
                }
            }
        });
    }

    public static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
