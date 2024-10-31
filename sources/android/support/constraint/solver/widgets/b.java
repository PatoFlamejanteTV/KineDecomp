package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class b extends k {
    private int xa = 0;
    private ArrayList<n> ya = new ArrayList<>(4);
    private boolean za = true;

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void F() {
        super.F();
        this.ya.clear();
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void G() {
        n d2;
        float f2;
        n nVar;
        int i = this.xa;
        float f3 = Float.MAX_VALUE;
        if (i != 0) {
            if (i == 1) {
                d2 = this.x.d();
            } else if (i == 2) {
                d2 = this.w.d();
            } else if (i != 3) {
                return;
            } else {
                d2 = this.y.d();
            }
            f3 = 0.0f;
        } else {
            d2 = this.v.d();
        }
        int size = this.ya.size();
        n nVar2 = null;
        for (int i2 = 0; i2 < size; i2++) {
            n nVar3 = this.ya.get(i2);
            if (nVar3.f289b != 1) {
                return;
            }
            int i3 = this.xa;
            if (i3 != 0 && i3 != 2) {
                f2 = nVar3.f286h;
                if (f2 > f3) {
                    nVar = nVar3.f285g;
                    nVar2 = nVar;
                    f3 = f2;
                }
            } else {
                f2 = nVar3.f286h;
                if (f2 < f3) {
                    nVar = nVar3.f285g;
                    nVar2 = nVar;
                    f3 = f2;
                }
            }
        }
        if (android.support.constraint.solver.e.e() != null) {
            android.support.constraint.solver.e.e().y++;
        }
        d2.f285g = nVar2;
        d2.f286h = f3;
        d2.a();
        int i4 = this.xa;
        if (i4 == 0) {
            this.x.d().a(nVar2, f3);
            return;
        }
        if (i4 == 1) {
            this.v.d().a(nVar2, f3);
        } else if (i4 != 2) {
            if (i4 != 3) {
                return;
            }
            this.w.d().a(nVar2, f3);
        } else {
            this.y.d().a(nVar2, f3);
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void a(int i) {
        n d2;
        n d3;
        ConstraintWidget constraintWidget = this.G;
        if (constraintWidget != null && ((g) constraintWidget).t(2)) {
            int i2 = this.xa;
            if (i2 == 0) {
                d2 = this.v.d();
            } else if (i2 == 1) {
                d2 = this.x.d();
            } else if (i2 == 2) {
                d2 = this.w.d();
            } else if (i2 != 3) {
                return;
            } else {
                d2 = this.y.d();
            }
            d2.b(5);
            int i3 = this.xa;
            if (i3 != 0 && i3 != 1) {
                this.v.d().a((n) null, 0.0f);
                this.x.d().a((n) null, 0.0f);
            } else {
                this.w.d().a((n) null, 0.0f);
                this.y.d().a((n) null, 0.0f);
            }
            this.ya.clear();
            for (int i4 = 0; i4 < this.wa; i4++) {
                ConstraintWidget constraintWidget2 = this.va[i4];
                if (this.za || constraintWidget2.a()) {
                    int i5 = this.xa;
                    if (i5 == 0) {
                        d3 = constraintWidget2.v.d();
                    } else if (i5 == 1) {
                        d3 = constraintWidget2.x.d();
                    } else if (i5 != 2) {
                        d3 = i5 != 3 ? null : constraintWidget2.y.d();
                    } else {
                        d3 = constraintWidget2.w.d();
                    }
                    if (d3 != null) {
                        this.ya.add(d3);
                        d3.a(d2);
                    }
                }
            }
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    public void c(boolean z) {
        this.za = z;
    }

    public void t(int i) {
        this.xa = i;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void a(android.support.constraint.solver.e eVar) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        int i;
        int i2;
        ConstraintAnchor[] constraintAnchorArr2 = this.D;
        constraintAnchorArr2[0] = this.v;
        constraintAnchorArr2[2] = this.w;
        constraintAnchorArr2[1] = this.x;
        constraintAnchorArr2[3] = this.y;
        int i3 = 0;
        while (true) {
            constraintAnchorArr = this.D;
            if (i3 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i3].j = eVar.a(constraintAnchorArr[i3]);
            i3++;
        }
        int i4 = this.xa;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
        for (int i5 = 0; i5 < this.wa; i5++) {
            ConstraintWidget constraintWidget = this.va[i5];
            if ((this.za || constraintWidget.a()) && ((((i = this.xa) == 0 || i == 1) && constraintWidget.j() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i2 = this.xa) == 2 || i2 == 3) && constraintWidget.q() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i6 = this.xa;
        if (i6 == 0 || i6 == 1 ? k().j() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : k().q() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i7 = 0; i7 < this.wa; i7++) {
            ConstraintWidget constraintWidget2 = this.va[i7];
            if (this.za || constraintWidget2.a()) {
                SolverVariable a2 = eVar.a(constraintWidget2.D[this.xa]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.D;
                int i8 = this.xa;
                constraintAnchorArr3[i8].j = a2;
                if (i8 != 0 && i8 != 2) {
                    eVar.a(constraintAnchor.j, a2, z);
                } else {
                    eVar.b(constraintAnchor.j, a2, z);
                }
            }
        }
        int i9 = this.xa;
        if (i9 == 0) {
            eVar.a(this.x.j, this.v.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.v.j, this.G.x.j, 0, 5);
            return;
        }
        if (i9 == 1) {
            eVar.a(this.v.j, this.x.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.v.j, this.G.v.j, 0, 5);
            return;
        }
        if (i9 == 2) {
            eVar.a(this.y.j, this.w.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.w.j, this.G.y.j, 0, 5);
            return;
        }
        if (i9 == 3) {
            eVar.a(this.w.j, this.y.j, 0, 6);
            if (z) {
                return;
            }
            eVar.a(this.w.j, this.G.w.j, 0, 5);
        }
    }
}
