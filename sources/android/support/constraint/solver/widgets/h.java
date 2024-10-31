package android.support.constraint.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: ConstraintWidgetGroup.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public List<ConstraintWidget> f271a;

    /* renamed from: b, reason: collision with root package name */
    int f272b;

    /* renamed from: c, reason: collision with root package name */
    int f273c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f274d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f275e;

    /* renamed from: f, reason: collision with root package name */
    List<ConstraintWidget> f276f;

    /* renamed from: g, reason: collision with root package name */
    List<ConstraintWidget> f277g;

    /* renamed from: h, reason: collision with root package name */
    HashSet<ConstraintWidget> f278h;
    HashSet<ConstraintWidget> i;
    List<ConstraintWidget> j;
    List<ConstraintWidget> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<ConstraintWidget> list) {
        this.f272b = -1;
        this.f273c = -1;
        this.f274d = false;
        this.f275e = new int[]{this.f272b, this.f273c};
        this.f276f = new ArrayList();
        this.f277g = new ArrayList();
        this.f278h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f271a = list;
    }

    public List<ConstraintWidget> a(int i) {
        if (i == 0) {
            return this.f276f;
        }
        if (i == 1) {
            return this.f277g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<ConstraintWidget> b(int i) {
        if (i == 0) {
            return this.f278h;
        }
        if (i == 1) {
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ConstraintWidget constraintWidget, int i) {
        if (i == 0) {
            this.f278h.add(constraintWidget);
        } else if (i == 1) {
            this.i.add(constraintWidget);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            a(this.k.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ConstraintWidget> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f271a.size();
        for (int i = 0; i < size; i++) {
            ConstraintWidget constraintWidget = this.f271a.get(i);
            if (!constraintWidget.ja) {
                a((ArrayList<ConstraintWidget>) this.j, constraintWidget);
            }
        }
        this.k.clear();
        this.k.addAll(this.f271a);
        this.k.removeAll(this.j);
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<ConstraintWidget> list, boolean z) {
        this.f272b = -1;
        this.f273c = -1;
        this.f274d = false;
        this.f275e = new int[]{this.f272b, this.f273c};
        this.f276f = new ArrayList();
        this.f277g = new ArrayList();
        this.f278h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f271a = list;
        this.f274d = z;
    }

    private void a(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        if (constraintWidget.la) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.la = true;
        if (constraintWidget.y()) {
            return;
        }
        if (constraintWidget instanceof k) {
            k kVar = (k) constraintWidget;
            int i = kVar.wa;
            for (int i2 = 0; i2 < i; i2++) {
                a(arrayList, kVar.va[i2]);
            }
        }
        int length = constraintWidget.D.length;
        for (int i3 = 0; i3 < length; i3++) {
            ConstraintAnchor constraintAnchor = constraintWidget.D[i3].f247d;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget2 = constraintAnchor.f245b;
                if (constraintAnchor != null && constraintWidget2 != constraintWidget.k()) {
                    a(arrayList, constraintWidget2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.support.constraint.solver.widgets.ConstraintWidget r7) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.h.a(android.support.constraint.solver.widgets.ConstraintWidget):void");
    }
}
