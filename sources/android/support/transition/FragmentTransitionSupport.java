package android.support.transition;

import android.graphics.Rect;
import android.support.v4.app.FragmentTransitionImpl;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    private static boolean a(M m) {
        return (FragmentTransitionImpl.a(m.g()) && FragmentTransitionImpl.a(m.h()) && FragmentTransitionImpl.a(m.i())) ? false : true;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((M) obj).a(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        M m = (M) obj;
        if (m == null) {
            return;
        }
        int i = 0;
        if (m instanceof T) {
            T t = (T) m;
            int n = t.n();
            while (i < n) {
                addTargets(t.a(i), arrayList);
                i++;
            }
            return;
        }
        if (a(m) || !FragmentTransitionImpl.a(m.j())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            m.a(arrayList.get(i));
            i++;
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        P.a(viewGroup, (M) obj);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof M;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((M) obj).mo1clone();
        }
        return null;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        M m = (M) obj;
        M m2 = (M) obj2;
        M m3 = (M) obj3;
        if (m != null && m2 != null) {
            T t = new T();
            t.b(m);
            t.b(m2);
            t.b(1);
            m = t;
        } else if (m == null) {
            m = m2 != null ? m2 : null;
        }
        if (m3 == null) {
            return m;
        }
        T t2 = new T();
        if (m != null) {
            t2.b(m);
        }
        t2.b(m3);
        return t2;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        T t = new T();
        if (obj != null) {
            t.b((M) obj);
        }
        if (obj2 != null) {
            t.b((M) obj2);
        }
        if (obj3 != null) {
            t.b((M) obj3);
        }
        return t;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((M) obj).d(view);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        M m = (M) obj;
        int i = 0;
        if (m instanceof T) {
            T t = (T) m;
            int n = t.n();
            while (i < n) {
                replaceTargets(t.a(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (a(m)) {
            return;
        }
        List<View> j = m.j();
        if (j.size() == arrayList.size() && j.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                m.a(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                m.d(arrayList.get(size2));
            }
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList) {
        ((M) obj).a(new C0213t(this, view, arrayList));
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((M) obj).a(new C0214u(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            a(view, rect);
            ((M) obj).a(new C0212s(this, rect));
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        T t = (T) obj;
        List<View> j = t.j();
        j.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            FragmentTransitionImpl.a(j, arrayList.get(i));
        }
        j.add(view);
        arrayList.add(view);
        addTargets(t, arrayList);
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        T t = (T) obj;
        if (t != null) {
            t.j().clear();
            t.j().addAll(arrayList2);
            replaceTargets(t, arrayList, arrayList2);
        }
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        T t = new T();
        t.b((M) obj);
        return t;
    }

    @Override // android.support.v4.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((M) obj).a(new C0215v(this, rect));
        }
    }
}
