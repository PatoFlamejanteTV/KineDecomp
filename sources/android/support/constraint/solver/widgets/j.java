package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class j extends ConstraintWidget {
    protected float va = -1.0f;
    protected int wa = -1;
    protected int xa = -1;
    private ConstraintAnchor ya = this.w;
    private int za = 0;
    private boolean Aa = false;
    private int Ba = 0;
    private m Ca = new m();
    private int Da = 8;

    public j() {
        this.E.clear();
        this.E.add(this.ya);
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            this.D[i] = this.ya;
        }
    }

    public int J() {
        return this.za;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (i.f279a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.za == 1) {
                    return this.ya;
                }
                break;
            case 3:
            case 4:
                if (this.za == 0) {
                    return this.ya;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public boolean a() {
        return true;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> b() {
        return this.E;
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void c(android.support.constraint.solver.e eVar) {
        if (k() == null) {
            return;
        }
        int b2 = eVar.b(this.ya);
        if (this.za == 1) {
            r(b2);
            s(0);
            g(k().i());
            o(0);
            return;
        }
        r(0);
        s(b2);
        o(k().s());
        g(0);
    }

    public void e(float f2) {
        if (f2 > -1.0f) {
            this.va = f2;
            this.wa = -1;
            this.xa = -1;
        }
    }

    public void t(int i) {
        if (i > -1) {
            this.va = -1.0f;
            this.wa = i;
            this.xa = -1;
        }
    }

    public void u(int i) {
        if (i > -1) {
            this.va = -1.0f;
            this.wa = -1;
            this.xa = i;
        }
    }

    public void v(int i) {
        if (this.za == i) {
            return;
        }
        this.za = i;
        this.E.clear();
        if (this.za == 1) {
            this.ya = this.v;
        } else {
            this.ya = this.w;
        }
        this.E.add(this.ya);
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.D[i2] = this.ya;
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void a(int i) {
        ConstraintWidget k = k();
        if (k == null) {
            return;
        }
        if (J() == 1) {
            this.w.d().a(1, k.w.d(), 0);
            this.y.d().a(1, k.w.d(), 0);
            if (this.wa != -1) {
                this.v.d().a(1, k.v.d(), this.wa);
                this.x.d().a(1, k.v.d(), this.wa);
                return;
            } else if (this.xa != -1) {
                this.v.d().a(1, k.x.d(), -this.xa);
                this.x.d().a(1, k.x.d(), -this.xa);
                return;
            } else {
                if (this.va == -1.0f || k.j() != ConstraintWidget.DimensionBehaviour.FIXED) {
                    return;
                }
                int i2 = (int) (k.H * this.va);
                this.v.d().a(1, k.v.d(), i2);
                this.x.d().a(1, k.v.d(), i2);
                return;
            }
        }
        this.v.d().a(1, k.v.d(), 0);
        this.x.d().a(1, k.v.d(), 0);
        if (this.wa != -1) {
            this.w.d().a(1, k.w.d(), this.wa);
            this.y.d().a(1, k.w.d(), this.wa);
        } else if (this.xa != -1) {
            this.w.d().a(1, k.y.d(), -this.xa);
            this.y.d().a(1, k.y.d(), -this.xa);
        } else {
            if (this.va == -1.0f || k.q() != ConstraintWidget.DimensionBehaviour.FIXED) {
                return;
            }
            int i3 = (int) (k.I * this.va);
            this.w.d().a(1, k.w.d(), i3);
            this.y.d().a(1, k.w.d(), i3);
        }
    }

    @Override // android.support.constraint.solver.widgets.ConstraintWidget
    public void a(android.support.constraint.solver.e eVar) {
        g gVar = (g) k();
        if (gVar == null) {
            return;
        }
        ConstraintAnchor a2 = gVar.a(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor a3 = gVar.a(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.G;
        boolean z = constraintWidget != null && constraintWidget.F[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.za == 0) {
            a2 = gVar.a(ConstraintAnchor.Type.TOP);
            a3 = gVar.a(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.G;
            z = constraintWidget2 != null && constraintWidget2.F[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.wa != -1) {
            SolverVariable a4 = eVar.a(this.ya);
            eVar.a(a4, eVar.a(a2), this.wa, 6);
            if (z) {
                eVar.b(eVar.a(a3), a4, 0, 5);
                return;
            }
            return;
        }
        if (this.xa == -1) {
            if (this.va != -1.0f) {
                eVar.a(android.support.constraint.solver.e.a(eVar, eVar.a(this.ya), eVar.a(a2), eVar.a(a3), this.va, this.Aa));
                return;
            }
            return;
        }
        SolverVariable a5 = eVar.a(this.ya);
        SolverVariable a6 = eVar.a(a3);
        eVar.a(a5, a6, -this.xa, 6);
        if (z) {
            eVar.b(a5, eVar.a(a2), 0, 5);
            eVar.b(a6, a5, 0, 5);
        }
    }
}
