package android.support.v4.app;

import android.support.v4.app.x;
import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes2.dex */
public final class z implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f69a;
    final /* synthetic */ x.b b;
    final /* synthetic */ Map c;
    final /* synthetic */ Map d;
    final /* synthetic */ Transition e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ View g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(View view, x.b bVar, Map map, Map map2, Transition transition, ArrayList arrayList, View view2) {
        this.f69a = view;
        this.b = bVar;
        this.c = map;
        this.d = map2;
        this.e = transition;
        this.f = arrayList;
        this.g = view2;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f69a.getViewTreeObserver().removeOnPreDrawListener(this);
        View a2 = this.b.a();
        if (a2 != null) {
            if (!this.c.isEmpty()) {
                x.a((Map<String, View>) this.d, a2);
                this.d.keySet().retainAll(this.c.values());
                for (Map.Entry entry : this.c.entrySet()) {
                    View view = (View) this.d.get((String) entry.getValue());
                    if (view != null) {
                        view.setTransitionName((String) entry.getKey());
                    }
                }
            }
            if (this.e != null) {
                x.b((ArrayList<View>) this.f, a2);
                this.f.removeAll(this.d.values());
                this.f.add(this.g);
                this.e.removeTarget(this.g);
                x.b(this.e, (ArrayList<View>) this.f);
                return true;
            }
            return true;
        }
        return true;
    }
}
