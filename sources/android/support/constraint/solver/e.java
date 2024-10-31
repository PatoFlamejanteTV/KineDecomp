package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.constraint.solver.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static int f226a = 1000;

    /* renamed from: b, reason: collision with root package name */
    public static f f227b;

    /* renamed from: e, reason: collision with root package name */
    private a f230e;

    /* renamed from: g, reason: collision with root package name */
    private int f232g;

    /* renamed from: h, reason: collision with root package name */
    b[] f233h;
    public boolean i;
    private boolean[] j;
    int k;
    int l;
    private int m;
    final c n;
    private SolverVariable[] o;
    private int p;
    private b[] q;
    private final a r;

    /* renamed from: c, reason: collision with root package name */
    int f228c = 0;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, SolverVariable> f229d = null;

    /* renamed from: f, reason: collision with root package name */
    private int f231f = 32;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        SolverVariable a(e eVar, boolean[] zArr);

        void a(SolverVariable solverVariable);

        void a(a aVar);

        void clear();

        SolverVariable getKey();
    }

    public e() {
        int i = this.f231f;
        this.f232g = i;
        this.f233h = null;
        this.i = false;
        this.j = new boolean[i];
        this.k = 1;
        this.l = 0;
        this.m = i;
        this.o = new SolverVariable[f226a];
        this.p = 0;
        this.q = new b[i];
        this.f233h = new b[i];
        j();
        this.n = new c();
        this.f230e = new d(this.n);
        this.r = new b(this.n);
    }

    private final void d(b bVar) {
        if (this.l > 0) {
            bVar.f221d.a(bVar, this.f233h);
            if (bVar.f221d.f210a == 0) {
                bVar.f222e = true;
            }
        }
    }

    public static f e() {
        return f227b;
    }

    private void h() {
        for (int i = 0; i < this.l; i++) {
            b bVar = this.f233h[i];
            bVar.f218a.f207f = bVar.f219b;
        }
    }

    private void i() {
        this.f231f *= 2;
        this.f233h = (b[]) Arrays.copyOf(this.f233h, this.f231f);
        c cVar = this.n;
        cVar.f225c = (SolverVariable[]) Arrays.copyOf(cVar.f225c, this.f231f);
        int i = this.f231f;
        this.j = new boolean[i];
        this.f232g = i;
        this.m = i;
        f fVar = f227b;
        if (fVar != null) {
            fVar.f237d++;
            fVar.o = Math.max(fVar.o, i);
            f fVar2 = f227b;
            fVar2.A = fVar2.o;
        }
    }

    private void j() {
        int i = 0;
        while (true) {
            b[] bVarArr = this.f233h;
            if (i >= bVarArr.length) {
                return;
            }
            b bVar = bVarArr[i];
            if (bVar != null) {
                this.n.f223a.release(bVar);
            }
            this.f233h[i] = null;
            i++;
        }
    }

    public SolverVariable a(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.f232g) {
            i();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.e();
            if (solverVariable == null) {
                constraintAnchor.a(this.n);
                solverVariable = constraintAnchor.e();
            }
            int i = solverVariable.f204c;
            if (i == -1 || i > this.f228c || this.n.f225c[i] == null) {
                if (solverVariable.f204c != -1) {
                    solverVariable.b();
                }
                this.f228c++;
                this.k++;
                int i2 = this.f228c;
                solverVariable.f204c = i2;
                solverVariable.f209h = SolverVariable.Type.UNRESTRICTED;
                this.n.f225c[i2] = solverVariable;
            }
        }
        return solverVariable;
    }

    public b b() {
        b acquire = this.n.f223a.acquire();
        if (acquire == null) {
            acquire = new b(this.n);
        } else {
            acquire.d();
        }
        SolverVariable.a();
        return acquire;
    }

    public SolverVariable c() {
        f fVar = f227b;
        if (fVar != null) {
            fVar.m++;
        }
        if (this.k + 1 >= this.f232g) {
            i();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        this.f228c++;
        this.k++;
        int i = this.f228c;
        a2.f204c = i;
        this.n.f225c[i] = a2;
        return a2;
    }

    public void f() throws Exception {
        f fVar = f227b;
        if (fVar != null) {
            fVar.f238e++;
        }
        if (this.i) {
            f fVar2 = f227b;
            if (fVar2 != null) {
                fVar2.q++;
            }
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= this.l) {
                    z = true;
                    break;
                } else if (!this.f233h[i].f222e) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                a(this.f230e);
                return;
            }
            f fVar3 = f227b;
            if (fVar3 != null) {
                fVar3.p++;
            }
            h();
            return;
        }
        a(this.f230e);
    }

    public void g() {
        c cVar;
        int i = 0;
        while (true) {
            cVar = this.n;
            SolverVariable[] solverVariableArr = cVar.f225c;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.b();
            }
            i++;
        }
        cVar.f224b.a(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.f225c, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f229d;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f228c = 0;
        this.f230e.clear();
        this.k = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            this.f233h[i2].f220c = false;
        }
        j();
        this.l = 0;
    }

    private void b(b bVar) {
        bVar.a(this, 0);
    }

    public c d() {
        return this.n;
    }

    public int b(Object obj) {
        SolverVariable e2 = ((ConstraintAnchor) obj).e();
        if (e2 != null) {
            return (int) (e2.f207f + 0.5f);
        }
        return 0;
    }

    private int b(a aVar) throws Exception {
        float f2;
        boolean z;
        int i = 0;
        while (true) {
            f2 = 0.0f;
            if (i >= this.l) {
                z = false;
                break;
            }
            b[] bVarArr = this.f233h;
            if (bVarArr[i].f218a.f209h != SolverVariable.Type.UNRESTRICTED && bVarArr[i].f219b < 0.0f) {
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar = f227b;
            if (fVar != null) {
                fVar.k++;
            }
            i2++;
            int i3 = 0;
            int i4 = -1;
            int i5 = -1;
            float f3 = Float.MAX_VALUE;
            int i6 = 0;
            while (i3 < this.l) {
                b bVar = this.f233h[i3];
                if (bVar.f218a.f209h != SolverVariable.Type.UNRESTRICTED && !bVar.f222e && bVar.f219b < f2) {
                    int i7 = 1;
                    while (i7 < this.k) {
                        SolverVariable solverVariable = this.n.f225c[i7];
                        float b2 = bVar.f221d.b(solverVariable);
                        if (b2 > f2) {
                            int i8 = i6;
                            float f4 = f3;
                            int i9 = i5;
                            int i10 = i4;
                            for (int i11 = 0; i11 < 7; i11++) {
                                float f5 = solverVariable.f208g[i11] / b2;
                                if ((f5 < f4 && i11 == i8) || i11 > i8) {
                                    i9 = i7;
                                    i10 = i3;
                                    f4 = f5;
                                    i8 = i11;
                                }
                            }
                            i4 = i10;
                            i5 = i9;
                            f3 = f4;
                            i6 = i8;
                        }
                        i7++;
                        f2 = 0.0f;
                    }
                }
                i3++;
                f2 = 0.0f;
            }
            if (i4 != -1) {
                b bVar2 = this.f233h[i4];
                bVar2.f218a.f205d = -1;
                f fVar2 = f227b;
                if (fVar2 != null) {
                    fVar2.j++;
                }
                bVar2.d(this.n.f225c[i5]);
                SolverVariable solverVariable2 = bVar2.f218a;
                solverVariable2.f205d = i4;
                solverVariable2.c(bVar2);
            } else {
                z2 = true;
            }
            if (i2 > this.k / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i2;
    }

    private final void c(b bVar) {
        b[] bVarArr = this.f233h;
        int i = this.l;
        if (bVarArr[i] != null) {
            this.n.f223a.release(bVarArr[i]);
        }
        b[] bVarArr2 = this.f233h;
        int i2 = this.l;
        bVarArr2[i2] = bVar;
        SolverVariable solverVariable = bVar.f218a;
        solverVariable.f205d = i2;
        this.l = i2 + 1;
        solverVariable.c(bVar);
    }

    public SolverVariable a() {
        f fVar = f227b;
        if (fVar != null) {
            fVar.n++;
        }
        if (this.k + 1 >= this.f232g) {
            i();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, (String) null);
        this.f228c++;
        this.k++;
        int i = this.f228c;
        a2.f204c = i;
        this.n.f225c[i] = a2;
        return a2;
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b b2 = b();
        SolverVariable c2 = c();
        c2.f206e = 0;
        b2.b(solverVariable, solverVariable2, c2, i);
        if (i2 != 6) {
            a(b2, (int) (b2.f221d.b(c2) * (-1.0f)), i2);
        }
        a(b2);
    }

    void a(b bVar, int i, int i2) {
        bVar.a(a(i2, (String) null), i);
    }

    public SolverVariable a(int i, String str) {
        f fVar = f227b;
        if (fVar != null) {
            fVar.l++;
        }
        if (this.k + 1 >= this.f232g) {
            i();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        this.f228c++;
        this.k++;
        int i2 = this.f228c;
        a2.f204c = i2;
        a2.f206e = i;
        this.n.f225c[i2] = a2;
        this.f230e.a(a2);
        return a2;
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b b2 = b();
        SolverVariable c2 = c();
        c2.f206e = 0;
        b2.a(solverVariable, solverVariable2, c2, i);
        if (i2 != 6) {
            a(b2, (int) (b2.f221d.b(c2) * (-1.0f)), i2);
        }
        a(b2);
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.n.f224b.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.a(type, str);
        } else {
            acquire.b();
            acquire.a(type, str);
        }
        int i = this.p;
        int i2 = f226a;
        if (i >= i2) {
            f226a = i2 * 2;
            this.o = (SolverVariable[]) Arrays.copyOf(this.o, f226a);
        }
        SolverVariable[] solverVariableArr = this.o;
        int i3 = this.p;
        this.p = i3 + 1;
        solverVariableArr[i3] = acquire;
        return acquire;
    }

    public void b(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b b2 = b();
        SolverVariable c2 = c();
        c2.f206e = 0;
        b2.b(solverVariable, solverVariable2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f221d.b(c2) * (-1.0f)), 1);
        }
        a(b2);
    }

    void a(a aVar) throws Exception {
        f fVar = f227b;
        if (fVar != null) {
            fVar.s++;
            fVar.t = Math.max(fVar.t, this.k);
            f fVar2 = f227b;
            fVar2.u = Math.max(fVar2.u, this.l);
        }
        d((b) aVar);
        b(aVar);
        a(aVar, false);
        h();
    }

    public void a(b bVar) {
        SolverVariable c2;
        if (bVar == null) {
            return;
        }
        f fVar = f227b;
        if (fVar != null) {
            fVar.f239f++;
            if (bVar.f222e) {
                fVar.f240g++;
            }
        }
        if (this.l + 1 >= this.m || this.k + 1 >= this.f232g) {
            i();
        }
        boolean z = false;
        if (!bVar.f222e) {
            d(bVar);
            if (bVar.c()) {
                return;
            }
            bVar.a();
            if (bVar.a(this)) {
                SolverVariable a2 = a();
                bVar.f218a = a2;
                c(bVar);
                this.r.a(bVar);
                a(this.r, true);
                if (a2.f205d == -1) {
                    if (bVar.f218a == a2 && (c2 = bVar.c(a2)) != null) {
                        f fVar2 = f227b;
                        if (fVar2 != null) {
                            fVar2.j++;
                        }
                        bVar.d(c2);
                    }
                    if (!bVar.f222e) {
                        bVar.f218a.c(bVar);
                    }
                    this.l--;
                }
                z = true;
            }
            if (!bVar.b()) {
                return;
            }
        }
        if (z) {
            return;
        }
        c(bVar);
    }

    private final int a(a aVar, boolean z) {
        f fVar = f227b;
        if (fVar != null) {
            fVar.f241h++;
        }
        for (int i = 0; i < this.k; i++) {
            this.j[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            f fVar2 = f227b;
            if (fVar2 != null) {
                fVar2.i++;
            }
            i2++;
            if (i2 >= this.k * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.j[aVar.getKey().f204c] = true;
            }
            SolverVariable a2 = aVar.a(this, this.j);
            if (a2 != null) {
                boolean[] zArr = this.j;
                int i3 = a2.f204c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (a2 != null) {
                int i4 = -1;
                float f2 = Float.MAX_VALUE;
                for (int i5 = 0; i5 < this.l; i5++) {
                    b bVar = this.f233h[i5];
                    if (bVar.f218a.f209h != SolverVariable.Type.UNRESTRICTED && !bVar.f222e && bVar.b(a2)) {
                        float b2 = bVar.f221d.b(a2);
                        if (b2 < 0.0f) {
                            float f3 = (-bVar.f219b) / b2;
                            if (f3 < f2) {
                                i4 = i5;
                                f2 = f3;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    b bVar2 = this.f233h[i4];
                    bVar2.f218a.f205d = -1;
                    f fVar3 = f227b;
                    if (fVar3 != null) {
                        fVar3.j++;
                    }
                    bVar2.d(a2);
                    SolverVariable solverVariable = bVar2.f218a;
                    solverVariable.f205d = i4;
                    solverVariable.c(bVar2);
                }
            }
            z2 = true;
        }
        return i2;
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        b b2 = b();
        SolverVariable c2 = c();
        c2.f206e = 0;
        b2.a(solverVariable, solverVariable2, c2, 0);
        if (z) {
            a(b2, (int) (b2.f221d.b(c2) * (-1.0f)), 1);
        }
        a(b2);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2, int i3) {
        b b2 = b();
        b2.a(solverVariable, solverVariable2, i, f2, solverVariable3, solverVariable4, i2);
        if (i3 != 6) {
            b2.a(this, i3);
        }
        a(b2);
    }

    public void a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i) {
        b b2 = b();
        b2.a(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i != 6) {
            b2.a(this, i);
        }
        a(b2);
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i2) {
        b b2 = b();
        b2.a(solverVariable, solverVariable2, i);
        if (i2 != 6) {
            b2.a(this, i2);
        }
        a(b2);
        return b2;
    }

    public void a(SolverVariable solverVariable, int i) {
        int i2 = solverVariable.f205d;
        if (i2 != -1) {
            b bVar = this.f233h[i2];
            if (bVar.f222e) {
                bVar.f219b = i;
                return;
            }
            if (bVar.f221d.f210a == 0) {
                bVar.f222e = true;
                bVar.f219b = i;
                return;
            } else {
                b b2 = b();
                b2.c(solverVariable, i);
                a(b2);
                return;
            }
        }
        b b3 = b();
        b3.b(solverVariable, i);
        a(b3);
    }

    public static b a(e eVar, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z) {
        b b2 = eVar.b();
        if (z) {
            eVar.b(b2);
        }
        b2.a(solverVariable, solverVariable2, solverVariable3, f2);
        return b2;
    }

    public void a(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i) {
        SolverVariable a2 = a(constraintWidget.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a3 = a(constraintWidget.a(ConstraintAnchor.Type.TOP));
        SolverVariable a4 = a(constraintWidget.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a5 = a(constraintWidget.a(ConstraintAnchor.Type.BOTTOM));
        SolverVariable a6 = a(constraintWidget2.a(ConstraintAnchor.Type.LEFT));
        SolverVariable a7 = a(constraintWidget2.a(ConstraintAnchor.Type.TOP));
        SolverVariable a8 = a(constraintWidget2.a(ConstraintAnchor.Type.RIGHT));
        SolverVariable a9 = a(constraintWidget2.a(ConstraintAnchor.Type.BOTTOM));
        b b2 = b();
        double d2 = f2;
        double sin = Math.sin(d2);
        double d3 = i;
        Double.isNaN(d3);
        b2.b(a3, a5, a7, a9, (float) (sin * d3));
        a(b2);
        b b3 = b();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        b3.b(a2, a4, a6, a8, (float) (cos * d3));
        a(b3);
    }
}
