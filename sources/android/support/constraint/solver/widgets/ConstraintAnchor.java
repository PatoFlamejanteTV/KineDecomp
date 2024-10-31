package android.support.constraint.solver.widgets;

import android.support.constraint.solver.SolverVariable;

/* loaded from: classes.dex */
public class ConstraintAnchor {

    /* renamed from: b */
    final ConstraintWidget f245b;

    /* renamed from: c */
    final Type f246c;

    /* renamed from: d */
    ConstraintAnchor f247d;
    SolverVariable j;

    /* renamed from: a */
    private n f244a = new n(this);

    /* renamed from: e */
    public int f248e = 0;

    /* renamed from: f */
    int f249f = -1;

    /* renamed from: g */
    private Strength f250g = Strength.NONE;

    /* renamed from: h */
    private ConnectionType f251h = ConnectionType.RELAXED;
    private int i = 0;

    /* loaded from: classes.dex */
    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    /* loaded from: classes.dex */
    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    /* loaded from: classes.dex */
    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f245b = constraintWidget;
        this.f246c = type;
    }

    public void a(android.support.constraint.solver.c cVar) {
        SolverVariable solverVariable = this.j;
        if (solverVariable == null) {
            this.j = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
        } else {
            solverVariable.b();
        }
    }

    public int b() {
        ConstraintAnchor constraintAnchor;
        if (this.f245b.r() == 8) {
            return 0;
        }
        if (this.f249f > -1 && (constraintAnchor = this.f247d) != null && constraintAnchor.f245b.r() == 8) {
            return this.f249f;
        }
        return this.f248e;
    }

    public ConstraintWidget c() {
        return this.f245b;
    }

    public n d() {
        return this.f244a;
    }

    public SolverVariable e() {
        return this.j;
    }

    public Strength f() {
        return this.f250g;
    }

    public ConstraintAnchor g() {
        return this.f247d;
    }

    public Type h() {
        return this.f246c;
    }

    public boolean i() {
        return this.f247d != null;
    }

    public void j() {
        this.f247d = null;
        this.f248e = 0;
        this.f249f = -1;
        this.f250g = Strength.STRONG;
        this.i = 0;
        this.f251h = ConnectionType.RELAXED;
        this.f244a.d();
    }

    public String toString() {
        return this.f245b.f() + ":" + this.f246c.toString();
    }

    public int a() {
        return this.i;
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, Strength strength, int i2) {
        return a(constraintAnchor, i, -1, strength, i2, false);
    }

    public boolean a(ConstraintAnchor constraintAnchor, int i, int i2, Strength strength, int i3, boolean z) {
        if (constraintAnchor == null) {
            this.f247d = null;
            this.f248e = 0;
            this.f249f = -1;
            this.f250g = Strength.NONE;
            this.i = 2;
            return true;
        }
        if (!z && !a(constraintAnchor)) {
            return false;
        }
        this.f247d = constraintAnchor;
        if (i > 0) {
            this.f248e = i;
        } else {
            this.f248e = 0;
        }
        this.f249f = i2;
        this.f250g = strength;
        this.i = i3;
        return true;
    }

    public boolean a(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type h2 = constraintAnchor.h();
        Type type = this.f246c;
        if (h2 == type) {
            return type != Type.BASELINE || (constraintAnchor.c().x() && c().x());
        }
        switch (e.f268a[type.ordinal()]) {
            case 1:
                return (h2 == Type.BASELINE || h2 == Type.CENTER_X || h2 == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = h2 == Type.LEFT || h2 == Type.RIGHT;
                return constraintAnchor.c() instanceof j ? z || h2 == Type.CENTER_X : z;
            case 4:
            case 5:
                boolean z2 = h2 == Type.TOP || h2 == Type.BOTTOM;
                return constraintAnchor.c() instanceof j ? z2 || h2 == Type.CENTER_Y : z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f246c.name());
        }
    }
}
