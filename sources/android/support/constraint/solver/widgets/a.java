package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Analyzer.java */
/* loaded from: classes.dex */
public class a {
    public static void a(g gVar) {
        if ((gVar.M() & 32) != 32) {
            b(gVar);
            return;
        }
        gVar.Oa = true;
        gVar.Ia = false;
        gVar.Ja = false;
        gVar.Ka = false;
        ArrayList<ConstraintWidget> arrayList = gVar.va;
        List<h> list = gVar.Ha;
        boolean z = gVar.j() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z2 = gVar.q() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.s = null;
            constraintWidget.la = false;
            constraintWidget.F();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.s == null && !a(constraintWidget2, list, z3)) {
                b(gVar);
                gVar.Oa = false;
                return;
            }
        }
        int i = 0;
        int i2 = 0;
        for (h hVar : list) {
            i = Math.max(i, a(hVar, 0));
            i2 = Math.max(i2, a(hVar, 1));
        }
        if (z) {
            gVar.a(ConstraintWidget.DimensionBehaviour.FIXED);
            gVar.o(i);
            gVar.Ia = true;
            gVar.Ja = true;
            gVar.La = i;
        }
        if (z2) {
            gVar.b(ConstraintWidget.DimensionBehaviour.FIXED);
            gVar.g(i2);
            gVar.Ia = true;
            gVar.Ka = true;
            gVar.Ma = i2;
        }
        a(list, 0, gVar.s());
        a(list, 1, gVar.i());
    }

    private static void b(g gVar) {
        gVar.Ha.clear();
        gVar.Ha.add(0, new h(gVar.va));
    }

    private static boolean a(ConstraintWidget constraintWidget, List<h> list, boolean z) {
        h hVar = new h(new ArrayList(), true);
        list.add(hVar);
        return a(constraintWidget, hVar, list, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:139:0x0181, code lost:            if (r3.f245b == r4) goto L123;     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0128, code lost:            if (r3.f245b == r4) goto L92;     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.support.constraint.solver.widgets.ConstraintWidget r8, android.support.constraint.solver.widgets.h r9, java.util.List<android.support.constraint.solver.widgets.h> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.a.a(android.support.constraint.solver.widgets.ConstraintWidget, android.support.constraint.solver.widgets.h, java.util.List, boolean):boolean");
    }

    private static void a(g gVar, ConstraintWidget constraintWidget, h hVar) {
        hVar.f274d = false;
        gVar.Oa = false;
        constraintWidget.ja = false;
    }

    private static int a(h hVar, int i) {
        int i2 = i * 2;
        List<ConstraintWidget> a2 = hVar.a(i);
        int size = a2.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            ConstraintWidget constraintWidget = a2.get(i4);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
            int i5 = i2 + 1;
            i3 = Math.max(i3, a(constraintWidget, i, constraintAnchorArr[i5].f247d == null || !(constraintAnchorArr[i2].f247d == null || constraintAnchorArr[i5].f247d == null), 0));
        }
        hVar.f275e[i] = i3;
        return i3;
    }

    private static int a(ConstraintWidget constraintWidget, int i, boolean z, int i2) {
        int i3;
        int c2;
        int i4;
        int i5;
        int i6;
        int i7;
        int s;
        int i8;
        int i9;
        int i10;
        int i11 = 0;
        if (!constraintWidget.ja) {
            return 0;
        }
        boolean z2 = constraintWidget.z.f247d != null && i == 1;
        if (z) {
            i3 = constraintWidget.c();
            c2 = constraintWidget.i() - constraintWidget.c();
            i5 = i * 2;
            i4 = i5 + 1;
        } else {
            i3 = constraintWidget.i() - constraintWidget.c();
            c2 = constraintWidget.c();
            i4 = i * 2;
            i5 = i4 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        if (constraintAnchorArr[i4].f247d == null || constraintAnchorArr[i5].f247d != null) {
            i6 = i4;
            i7 = 1;
        } else {
            i6 = i5;
            i5 = i4;
            i7 = -1;
        }
        int i12 = z2 ? i2 - i3 : i2;
        int b2 = (constraintWidget.D[i5].b() * i7) + a(constraintWidget, i);
        int i13 = i12 + b2;
        int s2 = (i == 0 ? constraintWidget.s() : constraintWidget.i()) * i7;
        Iterator<p> it = constraintWidget.D[i5].d().f288a.iterator();
        while (it.hasNext()) {
            i11 = Math.max(i11, a(((n) it.next()).f281c.f245b, i, z, i13));
        }
        int i14 = 0;
        for (Iterator<p> it2 = constraintWidget.D[i6].d().f288a.iterator(); it2.hasNext(); it2 = it2) {
            i14 = Math.max(i14, a(((n) it2.next()).f281c.f245b, i, z, s2 + i13));
        }
        if (z2) {
            i11 -= i3;
            s = i14 + c2;
        } else {
            s = i14 + ((i == 0 ? constraintWidget.s() : constraintWidget.i()) * i7);
        }
        int i15 = 1;
        if (i == 1) {
            Iterator<p> it3 = constraintWidget.z.d().f288a.iterator();
            int i16 = 0;
            while (it3.hasNext()) {
                Iterator<p> it4 = it3;
                n nVar = (n) it3.next();
                if (i7 == i15) {
                    i16 = Math.max(i16, a(nVar.f281c.f245b, i, z, i3 + i13));
                    i10 = i6;
                } else {
                    i10 = i6;
                    i16 = Math.max(i16, a(nVar.f281c.f245b, i, z, (c2 * i7) + i13));
                }
                it3 = it4;
                i6 = i10;
                i15 = 1;
            }
            i8 = i6;
            int i17 = i16;
            i9 = (constraintWidget.z.d().f288a.size() <= 0 || z2) ? i17 : i7 == 1 ? i17 + i3 : i17 - c2;
        } else {
            i8 = i6;
            i9 = 0;
        }
        int max = b2 + Math.max(i11, Math.max(s, i9));
        int i18 = i13 + s2;
        if (i7 != -1) {
            i13 = i18;
            i18 = i13;
        }
        if (z) {
            l.a(constraintWidget, i, i18);
            constraintWidget.a(i18, i13, i);
        } else {
            constraintWidget.s.a(constraintWidget, i);
            constraintWidget.d(i18, i);
        }
        if (constraintWidget.c(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.J != 0.0f) {
            constraintWidget.s.a(constraintWidget, i);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.D;
        if (constraintAnchorArr2[i5].f247d != null && constraintAnchorArr2[i8].f247d != null) {
            ConstraintWidget k = constraintWidget.k();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.D;
            if (constraintAnchorArr3[i5].f247d.f245b == k && constraintAnchorArr3[i8].f247d.f245b == k) {
                constraintWidget.s.a(constraintWidget, i);
            }
        }
        return max;
    }

    private static void a(ConstraintAnchor constraintAnchor) {
        n d2 = constraintAnchor.d();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f247d;
        if (constraintAnchor2 == null || constraintAnchor2.f247d == constraintAnchor) {
            return;
        }
        constraintAnchor2.d().a(d2);
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (ConstraintWidget constraintWidget : list.get(i3).b(i)) {
                if (constraintWidget.ja) {
                    a(constraintWidget, i, i2);
                }
            }
        }
    }

    private static void a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3 + 1];
        if ((constraintAnchor.f247d == null || constraintAnchor2.f247d == null) ? false : true) {
            l.a(constraintWidget, i, a(constraintWidget, i) + constraintAnchor.b());
            return;
        }
        if (constraintWidget.J != 0.0f && constraintWidget.c(i) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int a2 = a(constraintWidget);
            int i4 = (int) constraintWidget.D[i3].d().f286h;
            constraintAnchor2.d().f285g = constraintAnchor.d();
            constraintAnchor2.d().f286h = a2;
            constraintAnchor2.d().f289b = 1;
            constraintWidget.a(i4, i4 + a2, i);
            return;
        }
        int e2 = i2 - constraintWidget.e(i);
        int d2 = e2 - constraintWidget.d(i);
        constraintWidget.a(d2, e2, i);
        l.a(constraintWidget, i, d2);
    }

    private static int a(ConstraintWidget constraintWidget, int i) {
        ConstraintAnchor constraintAnchor;
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.D;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i2];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i2 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.f247d;
        if (constraintAnchor4 == null) {
            return 0;
        }
        ConstraintWidget constraintWidget2 = constraintAnchor4.f245b;
        ConstraintWidget constraintWidget3 = constraintWidget.G;
        if (constraintWidget2 != constraintWidget3 || (constraintAnchor = constraintAnchor3.f247d) == null || constraintAnchor.f245b != constraintWidget3) {
            return 0;
        }
        return (int) ((((constraintWidget3.d(i) - constraintAnchor2.b()) - constraintAnchor3.b()) - constraintWidget.d(i)) * (i == 0 ? constraintWidget.aa : constraintWidget.ba));
    }

    private static int a(ConstraintWidget constraintWidget) {
        float s;
        float i;
        if (constraintWidget.j() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            if (constraintWidget.K == 0) {
                i = constraintWidget.i() * constraintWidget.J;
            } else {
                i = constraintWidget.i() / constraintWidget.J;
            }
            int i2 = (int) i;
            constraintWidget.o(i2);
            return i2;
        }
        if (constraintWidget.q() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return -1;
        }
        if (constraintWidget.K == 1) {
            s = constraintWidget.s() * constraintWidget.J;
        } else {
            s = constraintWidget.s() / constraintWidget.J;
        }
        int i3 = (int) s;
        constraintWidget.g(i3);
        return i3;
    }
}
