package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintWidget;

/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    static boolean[] f280a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(g gVar, android.support.constraint.solver.e eVar, ConstraintWidget constraintWidget) {
        if (gVar.F[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i = constraintWidget.v.f248e;
            int s = gVar.s() - constraintWidget.x.f248e;
            ConstraintAnchor constraintAnchor = constraintWidget.v;
            constraintAnchor.j = eVar.a(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.x;
            constraintAnchor2.j = eVar.a(constraintAnchor2);
            eVar.a(constraintWidget.v.j, i);
            eVar.a(constraintWidget.x.j, s);
            constraintWidget.f253b = 2;
            constraintWidget.a(i, s);
        }
        if (gVar.F[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || constraintWidget.F[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i2 = constraintWidget.w.f248e;
        int i3 = gVar.i() - constraintWidget.y.f248e;
        ConstraintAnchor constraintAnchor3 = constraintWidget.w;
        constraintAnchor3.j = eVar.a(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.y;
        constraintAnchor4.j = eVar.a(constraintAnchor4);
        eVar.a(constraintWidget.w.j, i2);
        eVar.a(constraintWidget.y.j, i3);
        if (constraintWidget.V > 0 || constraintWidget.r() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.z;
            constraintAnchor5.j = eVar.a(constraintAnchor5);
            eVar.a(constraintWidget.z.j, constraintWidget.V + i2);
        }
        constraintWidget.f254c = 2;
        constraintWidget.e(i2, i3);
    }

    private static boolean a(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.F;
        if (dimensionBehaviourArr[i] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            return false;
        }
        if (constraintWidget.J != 0.0f) {
            if (dimensionBehaviourArr[i != 0 ? (char) 0 : (char) 1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (constraintWidget.f257f != 0 || constraintWidget.i != 0 || constraintWidget.j != 0) {
                return false;
            }
        } else if (constraintWidget.f258g != 0 || constraintWidget.l != 0 || constraintWidget.m != 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i, ConstraintWidget constraintWidget) {
        constraintWidget.I();
        n d2 = constraintWidget.v.d();
        n d3 = constraintWidget.w.d();
        n d4 = constraintWidget.x.d();
        n d5 = constraintWidget.y.d();
        boolean z = (i & 8) == 8;
        boolean z2 = constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 0);
        if (d2.i != 4 && d4.i != 4) {
            if (constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.r() == 8)) {
                if (constraintWidget.v.f247d == null && constraintWidget.x.f247d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, constraintWidget.m());
                    } else {
                        d4.a(d2, constraintWidget.s());
                    }
                } else if (constraintWidget.v.f247d != null && constraintWidget.x.f247d == null) {
                    d2.b(1);
                    d4.b(1);
                    if (z) {
                        d4.a(d2, 1, constraintWidget.m());
                    } else {
                        d4.a(d2, constraintWidget.s());
                    }
                } else if (constraintWidget.v.f247d == null && constraintWidget.x.f247d != null) {
                    d2.b(1);
                    d4.b(1);
                    d2.a(d4, -constraintWidget.s());
                    if (z) {
                        d2.a(d4, -1, constraintWidget.m());
                    } else {
                        d2.a(d4, -constraintWidget.s());
                    }
                } else if (constraintWidget.v.f247d != null && constraintWidget.x.f247d != null) {
                    d2.b(2);
                    d4.b(2);
                    if (z) {
                        constraintWidget.m().a(d2);
                        constraintWidget.m().a(d4);
                        d2.b(d4, -1, constraintWidget.m());
                        d4.b(d2, 1, constraintWidget.m());
                    } else {
                        d2.b(d4, -constraintWidget.s());
                        d4.b(d2, constraintWidget.s());
                    }
                }
            } else if (z2) {
                int s = constraintWidget.s();
                d2.b(1);
                d4.b(1);
                if (constraintWidget.v.f247d == null && constraintWidget.x.f247d == null) {
                    if (z) {
                        d4.a(d2, 1, constraintWidget.m());
                    } else {
                        d4.a(d2, s);
                    }
                } else if (constraintWidget.v.f247d == null || constraintWidget.x.f247d != null) {
                    if (constraintWidget.v.f247d != null || constraintWidget.x.f247d == null) {
                        if (constraintWidget.v.f247d != null && constraintWidget.x.f247d != null) {
                            if (z) {
                                constraintWidget.m().a(d2);
                                constraintWidget.m().a(d4);
                            }
                            if (constraintWidget.J == 0.0f) {
                                d2.b(3);
                                d4.b(3);
                                d2.b(d4, 0.0f);
                                d4.b(d2, 0.0f);
                            } else {
                                d2.b(2);
                                d4.b(2);
                                d2.b(d4, -s);
                                d4.b(d2, s);
                                constraintWidget.o(s);
                            }
                        }
                    } else if (z) {
                        d2.a(d4, -1, constraintWidget.m());
                    } else {
                        d2.a(d4, -s);
                    }
                } else if (z) {
                    d4.a(d2, 1, constraintWidget.m());
                } else {
                    d4.a(d2, s);
                }
            }
        }
        boolean z3 = constraintWidget.F[1] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && a(constraintWidget, 1);
        if (d3.i == 4 || d5.i == 4) {
            return;
        }
        if (constraintWidget.F[1] != ConstraintWidget.DimensionBehaviour.FIXED && (!z3 || constraintWidget.r() != 8)) {
            if (z3) {
                int i2 = constraintWidget.i();
                d3.b(1);
                d5.b(1);
                if (constraintWidget.w.f247d == null && constraintWidget.y.f247d == null) {
                    if (z) {
                        d5.a(d3, 1, constraintWidget.l());
                        return;
                    } else {
                        d5.a(d3, i2);
                        return;
                    }
                }
                if (constraintWidget.w.f247d != null && constraintWidget.y.f247d == null) {
                    if (z) {
                        d5.a(d3, 1, constraintWidget.l());
                        return;
                    } else {
                        d5.a(d3, i2);
                        return;
                    }
                }
                if (constraintWidget.w.f247d == null && constraintWidget.y.f247d != null) {
                    if (z) {
                        d3.a(d5, -1, constraintWidget.l());
                        return;
                    } else {
                        d3.a(d5, -i2);
                        return;
                    }
                }
                if (constraintWidget.w.f247d == null || constraintWidget.y.f247d == null) {
                    return;
                }
                if (z) {
                    constraintWidget.l().a(d3);
                    constraintWidget.m().a(d5);
                }
                if (constraintWidget.J == 0.0f) {
                    d3.b(3);
                    d5.b(3);
                    d3.b(d5, 0.0f);
                    d5.b(d3, 0.0f);
                    return;
                }
                d3.b(2);
                d5.b(2);
                d3.b(d5, -i2);
                d5.b(d3, i2);
                constraintWidget.g(i2);
                if (constraintWidget.V > 0) {
                    constraintWidget.z.d().a(1, d3, constraintWidget.V);
                    return;
                }
                return;
            }
            return;
        }
        if (constraintWidget.w.f247d == null && constraintWidget.y.f247d == null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d5.a(d3, 1, constraintWidget.l());
            } else {
                d5.a(d3, constraintWidget.i());
            }
            ConstraintAnchor constraintAnchor = constraintWidget.z;
            if (constraintAnchor.f247d != null) {
                constraintAnchor.d().b(1);
                d3.a(1, constraintWidget.z.d(), -constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f247d != null && constraintWidget.y.f247d == null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d5.a(d3, 1, constraintWidget.l());
            } else {
                d5.a(d3, constraintWidget.i());
            }
            if (constraintWidget.V > 0) {
                constraintWidget.z.d().a(1, d3, constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f247d == null && constraintWidget.y.f247d != null) {
            d3.b(1);
            d5.b(1);
            if (z) {
                d3.a(d5, -1, constraintWidget.l());
            } else {
                d3.a(d5, -constraintWidget.i());
            }
            if (constraintWidget.V > 0) {
                constraintWidget.z.d().a(1, d3, constraintWidget.V);
                return;
            }
            return;
        }
        if (constraintWidget.w.f247d == null || constraintWidget.y.f247d == null) {
            return;
        }
        d3.b(2);
        d5.b(2);
        if (z) {
            d3.b(d5, -1, constraintWidget.l());
            d5.b(d3, 1, constraintWidget.l());
            constraintWidget.l().a(d3);
            constraintWidget.m().a(d5);
        } else {
            d3.b(d5, -constraintWidget.i());
            d5.b(d3, constraintWidget.i());
        }
        if (constraintWidget.V > 0) {
            constraintWidget.z.d().a(1, d3, constraintWidget.V);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0032, code lost:            if (r7.ma == 2) goto L14;     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:            r2 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0036, code lost:            r2 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0048, code lost:            if (r7.na == 2) goto L14;     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0105 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.support.constraint.solver.widgets.g r24, android.support.constraint.solver.e r25, int r26, int r27, android.support.constraint.solver.widgets.d r28) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.l.a(android.support.constraint.solver.widgets.g, android.support.constraint.solver.e, int, int, android.support.constraint.solver.widgets.d):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ConstraintWidget constraintWidget, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        constraintWidget.D[i3].d().f285g = constraintWidget.k().v.d();
        constraintWidget.D[i3].d().f286h = i2;
        constraintWidget.D[i3].d().f289b = 1;
        constraintWidget.D[i4].d().f285g = constraintWidget.D[i3].d();
        constraintWidget.D[i4].d().f286h = constraintWidget.d(i);
        constraintWidget.D[i4].d().f289b = 1;
    }
}
