package android.support.v4.app;

import android.transition.Transition;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FragmentTransitionCompat21.java */
/* loaded from: classes.dex */
final class ab implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f32a;
    final /* synthetic */ Transition b;
    final /* synthetic */ View c;
    final /* synthetic */ ArrayList d;
    final /* synthetic */ Transition e;
    final /* synthetic */ ArrayList f;
    final /* synthetic */ Transition g;
    final /* synthetic */ ArrayList h;
    final /* synthetic */ Map i;
    final /* synthetic */ ArrayList j;
    final /* synthetic */ Transition k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(View view, Transition transition, View view2, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4) {
        this.f32a = view;
        this.b = transition;
        this.c = view2;
        this.d = arrayList;
        this.e = transition2;
        this.f = arrayList2;
        this.g = transition3;
        this.h = arrayList3;
        this.i = map;
        this.j = arrayList4;
        this.k = transition4;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f32a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.b != null) {
            this.b.removeTarget(this.c);
            x.a(this.b, (ArrayList<View>) this.d);
        }
        if (this.e != null) {
            x.a(this.e, (ArrayList<View>) this.f);
        }
        if (this.g != null) {
            x.a(this.g, (ArrayList<View>) this.h);
        }
        for (Map.Entry entry : this.i.entrySet()) {
            ((View) entry.getValue()).setTransitionName((String) entry.getKey());
        }
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            this.k.excludeTarget((View) this.j.get(i), false);
        }
        this.k.excludeTarget(this.c, false);
        return true;
    }
}
