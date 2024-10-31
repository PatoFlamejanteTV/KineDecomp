package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import android.support.constraint.solver.e;
import com.facebook.appevents.UserDataStore;

/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements e.a {

    /* renamed from: d */
    public final a f221d;

    /* renamed from: a */
    SolverVariable f218a = null;

    /* renamed from: b */
    float f219b = 0.0f;

    /* renamed from: c */
    boolean f220c = false;

    /* renamed from: e */
    boolean f222e = false;

    public b(c cVar) {
        this.f221d = new a(this, cVar);
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f219b = i;
        }
        if (!z) {
            this.f221d.a(solverVariable, -1.0f);
            this.f221d.a(solverVariable2, 1.0f);
        } else {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
        }
        return this;
    }

    public boolean b() {
        SolverVariable solverVariable = this.f218a;
        return solverVariable != null && (solverVariable.f209h == SolverVariable.Type.UNRESTRICTED || this.f219b >= 0.0f);
    }

    public b c(SolverVariable solverVariable, int i) {
        if (i < 0) {
            this.f219b = i * (-1);
            this.f221d.a(solverVariable, 1.0f);
        } else {
            this.f219b = i;
            this.f221d.a(solverVariable, -1.0f);
        }
        return this;
    }

    @Override // android.support.constraint.solver.e.a
    public void clear() {
        this.f221d.a();
        this.f218a = null;
        this.f219b = 0.0f;
    }

    public void d() {
        this.f218a = null;
        this.f221d.a();
        this.f219b = 0.0f;
        this.f222e = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String e() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.b.e():java.lang.String");
    }

    @Override // android.support.constraint.solver.e.a
    public SolverVariable getKey() {
        return this.f218a;
    }

    public String toString() {
        return e();
    }

    public boolean b(SolverVariable solverVariable) {
        return this.f221d.a(solverVariable);
    }

    public b b(SolverVariable solverVariable, int i) {
        this.f218a = solverVariable;
        float f2 = i;
        solverVariable.f207f = f2;
        this.f219b = f2;
        this.f222e = true;
        return this;
    }

    public SolverVariable c(SolverVariable solverVariable) {
        return this.f221d.a((boolean[]) null, solverVariable);
    }

    public void d(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f218a;
        if (solverVariable2 != null) {
            this.f221d.a(solverVariable2, -1.0f);
            this.f218a = null;
        }
        float a2 = this.f221d.a(solverVariable, true) * (-1.0f);
        this.f218a = solverVariable;
        if (a2 == 1.0f) {
            return;
        }
        this.f219b /= a2;
        this.f221d.a(a2);
    }

    public b a(SolverVariable solverVariable, int i) {
        this.f221d.a(solverVariable, i);
        return this;
    }

    public boolean c() {
        return this.f218a == null && this.f219b == 0.0f && this.f221d.f210a == 0;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f219b = i;
        }
        if (!z) {
            this.f221d.a(solverVariable, -1.0f);
            this.f221d.a(solverVariable2, 1.0f);
            this.f221d.a(solverVariable3, 1.0f);
        } else {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
            this.f221d.a(solverVariable3, -1.0f);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f219b = i;
        }
        if (!z) {
            this.f221d.a(solverVariable, -1.0f);
            this.f221d.a(solverVariable2, 1.0f);
            this.f221d.a(solverVariable3, -1.0f);
        } else {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
            this.f221d.a(solverVariable3, 1.0f);
        }
        return this;
    }

    public b a(float f2, float f3, float f4, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f219b = 0.0f;
        if (f3 == 0.0f || f2 == f4) {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
            this.f221d.a(solverVariable4, 1.0f);
            this.f221d.a(solverVariable3, -1.0f);
        } else if (f2 == 0.0f) {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
        } else if (f4 == 0.0f) {
            this.f221d.a(solverVariable3, 1.0f);
            this.f221d.a(solverVariable4, -1.0f);
        } else {
            float f5 = (f2 / f3) / (f4 / f3);
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
            this.f221d.a(solverVariable4, f5);
            this.f221d.a(solverVariable3, -f5);
        }
        return this;
    }

    public b b(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f221d.a(solverVariable3, 0.5f);
        this.f221d.a(solverVariable4, 0.5f);
        this.f221d.a(solverVariable, -0.5f);
        this.f221d.a(solverVariable2, -0.5f);
        this.f219b = -f2;
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i2) {
        if (solverVariable2 == solverVariable3) {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable4, 1.0f);
            this.f221d.a(solverVariable2, -2.0f);
            return this;
        }
        if (f2 == 0.5f) {
            this.f221d.a(solverVariable, 1.0f);
            this.f221d.a(solverVariable2, -1.0f);
            this.f221d.a(solverVariable3, -1.0f);
            this.f221d.a(solverVariable4, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f219b = (-i) + i2;
            }
        } else if (f2 <= 0.0f) {
            this.f221d.a(solverVariable, -1.0f);
            this.f221d.a(solverVariable2, 1.0f);
            this.f219b = i;
        } else if (f2 >= 1.0f) {
            this.f221d.a(solverVariable3, -1.0f);
            this.f221d.a(solverVariable4, 1.0f);
            this.f219b = i2;
        } else {
            float f3 = 1.0f - f2;
            this.f221d.a(solverVariable, f3 * 1.0f);
            this.f221d.a(solverVariable2, f3 * (-1.0f));
            this.f221d.a(solverVariable3, (-1.0f) * f2);
            this.f221d.a(solverVariable4, 1.0f * f2);
            if (i > 0 || i2 > 0) {
                this.f219b = ((-i) * f3) + (i2 * f2);
            }
        }
        return this;
    }

    public b a(e eVar, int i) {
        this.f221d.a(eVar.a(i, "ep"), 1.0f);
        this.f221d.a(eVar.a(i, UserDataStore.EMAIL), -1.0f);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2) {
        this.f221d.a(solverVariable, -1.0f);
        this.f221d.a(solverVariable2, 1.0f - f2);
        this.f221d.a(solverVariable3, f2);
        return this;
    }

    public b a(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2) {
        this.f221d.a(solverVariable, -1.0f);
        this.f221d.a(solverVariable2, 1.0f);
        this.f221d.a(solverVariable3, f2);
        this.f221d.a(solverVariable4, -f2);
        return this;
    }

    public void a() {
        float f2 = this.f219b;
        if (f2 < 0.0f) {
            this.f219b = f2 * (-1.0f);
            this.f221d.b();
        }
    }

    public boolean a(e eVar) {
        boolean z;
        SolverVariable a2 = this.f221d.a(eVar);
        if (a2 == null) {
            z = true;
        } else {
            d(a2);
            z = false;
        }
        if (this.f221d.f210a == 0) {
            this.f222e = true;
        }
        return z;
    }

    @Override // android.support.constraint.solver.e.a
    public SolverVariable a(e eVar, boolean[] zArr) {
        return this.f221d.a(zArr, (SolverVariable) null);
    }

    @Override // android.support.constraint.solver.e.a
    public void a(e.a aVar) {
        if (!(aVar instanceof b)) {
            return;
        }
        b bVar = (b) aVar;
        this.f218a = null;
        this.f221d.a();
        int i = 0;
        while (true) {
            a aVar2 = bVar.f221d;
            if (i >= aVar2.f210a) {
                return;
            }
            this.f221d.a(aVar2.a(i), bVar.f221d.b(i), true);
            i++;
        }
    }

    @Override // android.support.constraint.solver.e.a
    public void a(SolverVariable solverVariable) {
        int i = solverVariable.f206e;
        float f2 = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f2 = 1000.0f;
            } else if (i == 3) {
                f2 = 1000000.0f;
            } else if (i == 4) {
                f2 = 1.0E9f;
            } else if (i == 5) {
                f2 = 1.0E12f;
            }
        }
        this.f221d.a(solverVariable, f2);
    }
}
