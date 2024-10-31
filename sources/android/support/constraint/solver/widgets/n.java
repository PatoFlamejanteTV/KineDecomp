package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;

/* compiled from: ResolutionAnchor.java */
/* loaded from: classes.dex */
public class n extends p {

    /* renamed from: c, reason: collision with root package name */
    ConstraintAnchor f281c;

    /* renamed from: d, reason: collision with root package name */
    float f282d;

    /* renamed from: e, reason: collision with root package name */
    n f283e;

    /* renamed from: f, reason: collision with root package name */
    float f284f;

    /* renamed from: g, reason: collision with root package name */
    n f285g;

    /* renamed from: h, reason: collision with root package name */
    float f286h;
    private n j;
    private float k;
    int i = 0;
    private o l = null;
    private int m = 1;
    private o n = null;
    private int o = 1;

    public n(ConstraintAnchor constraintAnchor) {
        this.f281c = constraintAnchor;
    }

    String a(int i) {
        return i == 1 ? "DIRECT" : i == 2 ? "CENTER" : i == 3 ? "MATCH" : i == 4 ? "CHAIN" : i == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void a(n nVar, float f2) {
        if (this.f289b == 0 || !(this.f285g == nVar || this.f286h == f2)) {
            this.f285g = nVar;
            this.f286h = f2;
            if (this.f289b == 1) {
                b();
            }
            a();
        }
    }

    public void b(int i) {
        this.i = i;
    }

    @Override // android.support.constraint.solver.widgets.p
    public void d() {
        super.d();
        this.f283e = null;
        this.f284f = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.f285g = null;
        this.f286h = 0.0f;
        this.f282d = 0.0f;
        this.j = null;
        this.k = 0.0f;
        this.i = 0;
    }

    @Override // android.support.constraint.solver.widgets.p
    public void e() {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        float f2;
        float f3;
        float s;
        float f4;
        n nVar7;
        boolean z = true;
        if (this.f289b == 1 || this.i == 4) {
            return;
        }
        o oVar = this.l;
        if (oVar != null) {
            if (oVar.f289b != 1) {
                return;
            } else {
                this.f284f = this.m * oVar.f287c;
            }
        }
        o oVar2 = this.n;
        if (oVar2 != null) {
            if (oVar2.f289b != 1) {
                return;
            } else {
                this.k = this.o * oVar2.f287c;
            }
        }
        if (this.i == 1 && ((nVar7 = this.f283e) == null || nVar7.f289b == 1)) {
            n nVar8 = this.f283e;
            if (nVar8 == null) {
                this.f285g = this;
                this.f286h = this.f284f;
            } else {
                this.f285g = nVar8.f285g;
                this.f286h = nVar8.f286h + this.f284f;
            }
            a();
            return;
        }
        if (this.i == 2 && (nVar4 = this.f283e) != null && nVar4.f289b == 1 && (nVar5 = this.j) != null && (nVar6 = nVar5.f283e) != null && nVar6.f289b == 1) {
            if (android.support.constraint.solver.e.e() != null) {
                android.support.constraint.solver.e.e().v++;
            }
            this.f285g = this.f283e.f285g;
            n nVar9 = this.j;
            nVar9.f285g = nVar9.f283e.f285g;
            ConstraintAnchor.Type type = this.f281c.f246c;
            int i = 0;
            if (type != ConstraintAnchor.Type.RIGHT && type != ConstraintAnchor.Type.BOTTOM) {
                z = false;
            }
            if (z) {
                f2 = this.f283e.f286h;
                f3 = this.j.f283e.f286h;
            } else {
                f2 = this.j.f283e.f286h;
                f3 = this.f283e.f286h;
            }
            float f5 = f2 - f3;
            ConstraintAnchor.Type type2 = this.f281c.f246c;
            if (type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) {
                s = f5 - r2.f245b.i();
                f4 = this.f281c.f245b.ba;
            } else {
                s = f5 - this.f281c.f245b.s();
                f4 = this.f281c.f245b.aa;
            }
            int b2 = this.f281c.b();
            int b3 = this.j.f281c.b();
            if (this.f281c.g() == this.j.f281c.g()) {
                f4 = 0.5f;
                b3 = 0;
            } else {
                i = b2;
            }
            float f6 = i;
            float f7 = b3;
            float f8 = (s - f6) - f7;
            if (z) {
                n nVar10 = this.j;
                nVar10.f286h = nVar10.f283e.f286h + f7 + (f8 * f4);
                this.f286h = (this.f283e.f286h - f6) - (f8 * (1.0f - f4));
            } else {
                this.f286h = this.f283e.f286h + f6 + (f8 * f4);
                n nVar11 = this.j;
                nVar11.f286h = (nVar11.f283e.f286h - f7) - (f8 * (1.0f - f4));
            }
            a();
            this.j.a();
            return;
        }
        if (this.i == 3 && (nVar = this.f283e) != null && nVar.f289b == 1 && (nVar2 = this.j) != null && (nVar3 = nVar2.f283e) != null && nVar3.f289b == 1) {
            if (android.support.constraint.solver.e.e() != null) {
                android.support.constraint.solver.e.e().w++;
            }
            n nVar12 = this.f283e;
            this.f285g = nVar12.f285g;
            n nVar13 = this.j;
            n nVar14 = nVar13.f283e;
            nVar13.f285g = nVar14.f285g;
            this.f286h = nVar12.f286h + this.f284f;
            nVar13.f286h = nVar14.f286h + nVar13.f284f;
            a();
            this.j.a();
            return;
        }
        if (this.i == 5) {
            this.f281c.f245b.G();
        }
    }

    public float f() {
        return this.f286h;
    }

    public void g() {
        ConstraintAnchor g2 = this.f281c.g();
        if (g2 == null) {
            return;
        }
        if (g2.g() == this.f281c) {
            this.i = 4;
            g2.d().i = 4;
        }
        int b2 = this.f281c.b();
        ConstraintAnchor.Type type = this.f281c.f246c;
        if (type == ConstraintAnchor.Type.RIGHT || type == ConstraintAnchor.Type.BOTTOM) {
            b2 = -b2;
        }
        a(g2.d(), b2);
    }

    public String toString() {
        if (this.f289b == 1) {
            if (this.f285g == this) {
                return "[" + this.f281c + ", RESOLVED: " + this.f286h + "]  type: " + a(this.i);
            }
            return "[" + this.f281c + ", RESOLVED: " + this.f285g + ":" + this.f286h + "] type: " + a(this.i);
        }
        return "{ " + this.f281c + " UNRESOLVED} type: " + a(this.i);
    }

    public void b(n nVar, float f2) {
        this.j = nVar;
        this.k = f2;
    }

    public void b(n nVar, int i, o oVar) {
        this.j = nVar;
        this.n = oVar;
        this.o = i;
    }

    public void a(int i, n nVar, int i2) {
        this.i = i;
        this.f283e = nVar;
        this.f284f = i2;
        this.f283e.a(this);
    }

    public void a(n nVar, int i) {
        this.f283e = nVar;
        this.f284f = i;
        this.f283e.a(this);
    }

    public void a(n nVar, int i, o oVar) {
        this.f283e = nVar;
        this.f283e.a(this);
        this.l = oVar;
        this.m = i;
        this.l.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(android.support.constraint.solver.e eVar) {
        SolverVariable e2 = this.f281c.e();
        n nVar = this.f285g;
        if (nVar == null) {
            eVar.a(e2, (int) (this.f286h + 0.5f));
        } else {
            eVar.a(e2, eVar.a(nVar.f281c), (int) (this.f286h + 0.5f), 6);
        }
    }
}
