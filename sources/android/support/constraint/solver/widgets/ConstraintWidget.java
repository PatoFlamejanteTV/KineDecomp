package android.support.constraint.solver.widgets;

import android.support.constraint.solver.widgets.ConstraintAnchor;
import android.support.v7.widget.ActivityChooserView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {

    /* renamed from: a */
    public static float f252a = 0.5f;
    protected DimensionBehaviour[] F;
    ConstraintWidget G;
    int H;
    int I;
    protected float J;
    protected int K;
    protected int L;
    protected int M;
    int N;
    int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    protected int T;
    protected int U;
    int V;
    protected int W;
    protected int X;
    private int Y;
    private int Z;
    float aa;
    float ba;
    private Object ca;

    /* renamed from: d */
    o f255d;
    private int da;

    /* renamed from: e */
    o f256e;
    private int ea;
    private String fa;
    private String ga;
    boolean ha;
    boolean ia;
    boolean ja;
    boolean ka;
    boolean la;
    int ma;
    int na;
    boolean o;
    boolean oa;
    boolean p;
    boolean pa;
    float[] qa;
    protected ConstraintWidget[] ra;
    protected ConstraintWidget[] sa;
    ConstraintWidget ta;
    ConstraintWidget ua;

    /* renamed from: b */
    public int f253b = -1;

    /* renamed from: c */
    public int f254c = -1;

    /* renamed from: f */
    int f257f = 0;

    /* renamed from: g */
    int f258g = 0;

    /* renamed from: h */
    int[] f259h = new int[2];
    int i = 0;
    int j = 0;
    float k = 1.0f;
    int l = 0;
    int m = 0;
    float n = 1.0f;
    int q = -1;
    float r = 1.0f;
    h s = null;
    private int[] t = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    private float u = 0.0f;
    ConstraintAnchor v = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
    ConstraintAnchor w = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
    ConstraintAnchor x = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
    ConstraintAnchor y = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
    ConstraintAnchor z = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
    ConstraintAnchor A = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    ConstraintAnchor B = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    ConstraintAnchor C = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
    protected ConstraintAnchor[] D = {this.v, this.x, this.w, this.y, this.z, this.C};
    protected ArrayList<ConstraintAnchor> E = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.F = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.G = null;
        this.H = 0;
        this.I = 0;
        this.J = 0.0f;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        float f2 = f252a;
        this.aa = f2;
        this.ba = f2;
        this.da = 0;
        this.ea = 0;
        this.fa = null;
        this.ga = null;
        this.ja = false;
        this.ka = false;
        this.la = false;
        this.ma = 0;
        this.na = 0;
        this.qa = new float[]{-1.0f, -1.0f};
        this.ra = new ConstraintWidget[]{null, null};
        this.sa = new ConstraintWidget[]{null, null};
        this.ta = null;
        this.ua = null;
        J();
    }

    private void J() {
        this.E.add(this.v);
        this.E.add(this.w);
        this.E.add(this.x);
        this.E.add(this.y);
        this.E.add(this.A);
        this.E.add(this.B);
        this.E.add(this.C);
        this.E.add(this.z);
    }

    public boolean A() {
        ConstraintAnchor constraintAnchor = this.w;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f247d;
        if (constraintAnchor2 != null && constraintAnchor2.f247d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.y;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f247d;
        return constraintAnchor4 != null && constraintAnchor4.f247d == constraintAnchor3;
    }

    public boolean B() {
        return this.f258g == 0 && this.J == 0.0f && this.l == 0 && this.m == 0 && this.F[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean C() {
        return this.f257f == 0 && this.J == 0.0f && this.i == 0 && this.j == 0 && this.F[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public void D() {
        this.v.j();
        this.w.j();
        this.x.j();
        this.y.j();
        this.z.j();
        this.A.j();
        this.B.j();
        this.C.j();
        this.G = null;
        this.u = 0.0f;
        this.H = 0;
        this.I = 0;
        this.J = 0.0f;
        this.K = -1;
        this.L = 0;
        this.M = 0;
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        float f2 = f252a;
        this.aa = f2;
        this.ba = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.F;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.ca = null;
        this.da = 0;
        this.ea = 0;
        this.ga = null;
        this.ha = false;
        this.ia = false;
        this.ma = 0;
        this.na = 0;
        this.oa = false;
        this.pa = false;
        float[] fArr = this.qa;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f253b = -1;
        this.f254c = -1;
        int[] iArr = this.t;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f257f = 0;
        this.f258g = 0;
        this.k = 1.0f;
        this.n = 1.0f;
        this.j = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.m = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.i = 0;
        this.l = 0;
        this.q = -1;
        this.r = 1.0f;
        o oVar = this.f255d;
        if (oVar != null) {
            oVar.d();
        }
        o oVar2 = this.f256e;
        if (oVar2 != null) {
            oVar2.d();
        }
        this.s = null;
        this.ja = false;
        this.ka = false;
        this.la = false;
    }

    public void E() {
        ConstraintWidget k = k();
        if (k != null && (k instanceof g) && ((g) k()).N()) {
            return;
        }
        int size = this.E.size();
        for (int i = 0; i < size; i++) {
            this.E.get(i).j();
        }
    }

    public void F() {
        for (int i = 0; i < 6; i++) {
            this.D[i].d().d();
        }
    }

    public void G() {
    }

    public void H() {
        int i = this.L;
        int i2 = this.M;
        int i3 = this.H + i;
        int i4 = this.I + i2;
        this.P = i;
        this.Q = i2;
        this.R = i3 - i;
        this.S = i4 - i2;
    }

    public void I() {
        for (int i = 0; i < 6; i++) {
            this.D[i].d().g();
        }
    }

    public void a(int i) {
        l.a(i, this);
    }

    public void b(boolean z) {
        this.o = z;
    }

    public int c() {
        return this.V;
    }

    public int d(int i) {
        if (i == 0) {
            return s();
        }
        if (i == 1) {
            return i();
        }
        return 0;
    }

    public Object e() {
        return this.ca;
    }

    public String f() {
        return this.fa;
    }

    public int g() {
        return this.P + this.T;
    }

    public int h() {
        return this.Q + this.U;
    }

    public void i(int i) {
        this.t[1] = i;
    }

    public void j(int i) {
        this.t[0] = i;
    }

    public ConstraintWidget k() {
        return this.G;
    }

    public o l() {
        if (this.f256e == null) {
            this.f256e = new o();
        }
        return this.f256e;
    }

    public o m() {
        if (this.f255d == null) {
            this.f255d = new o();
        }
        return this.f255d;
    }

    public void n(int i) {
        this.ea = i;
    }

    public int o() {
        return this.L + this.T;
    }

    public int p() {
        return this.M + this.U;
    }

    public void q(int i) {
        this.Y = i;
    }

    public int r() {
        return this.ea;
    }

    public int s() {
        if (this.ea == 8) {
            return 0;
        }
        return this.H;
    }

    public int t() {
        return this.Z;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.ga != null) {
            str = "type: " + this.ga + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.fa != null) {
            str2 = "id: " + this.fa + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.L);
        sb.append(", ");
        sb.append(this.M);
        sb.append(") - (");
        sb.append(this.H);
        sb.append(" x ");
        sb.append(this.I);
        sb.append(") wrap: (");
        sb.append(this.Y);
        sb.append(" x ");
        sb.append(this.Z);
        sb.append(")");
        return sb.toString();
    }

    public int u() {
        return this.Y;
    }

    public int v() {
        return this.L;
    }

    public int w() {
        return this.M;
    }

    public boolean x() {
        return this.V > 0;
    }

    public boolean y() {
        return this.v.d().f289b == 1 && this.x.d().f289b == 1 && this.w.d().f289b == 1 && this.y.d().f289b == 1;
    }

    public boolean z() {
        ConstraintAnchor constraintAnchor = this.v;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f247d;
        if (constraintAnchor2 != null && constraintAnchor2.f247d == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.x;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f247d;
        return constraintAnchor4 != null && constraintAnchor4.f247d == constraintAnchor3;
    }

    private boolean t(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.D;
        if (constraintAnchorArr[i2].f247d != null && constraintAnchorArr[i2].f247d.f247d != constraintAnchorArr[i2]) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].f247d != null && constraintAnchorArr[i3].f247d.f247d == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public void a(android.support.constraint.solver.c cVar) {
        this.v.a(cVar);
        this.w.a(cVar);
        this.x.a(cVar);
        this.y.a(cVar);
        this.z.a(cVar);
        this.C.a(cVar);
        this.A.a(cVar);
        this.B.a(cVar);
    }

    public void b(android.support.constraint.solver.e eVar) {
        eVar.a(this.v);
        eVar.a(this.w);
        eVar.a(this.x);
        eVar.a(this.y);
        if (this.V > 0) {
            eVar.a(this.z);
        }
    }

    public void c(int i, int i2) {
        this.L = i;
        this.M = i2;
    }

    public void e(int i, int i2) {
        this.M = i;
        this.I = i2 - i;
        int i3 = this.I;
        int i4 = this.X;
        if (i3 < i4) {
            this.I = i4;
        }
    }

    public void f(int i) {
        this.V = i;
    }

    public void g(int i) {
        this.I = i;
        int i2 = this.I;
        int i3 = this.X;
        if (i2 < i3) {
            this.I = i3;
        }
    }

    public void h(int i) {
        this.ma = i;
    }

    public int i() {
        if (this.ea == 8) {
            return 0;
        }
        return this.I;
    }

    public DimensionBehaviour j() {
        return this.F[0];
    }

    public void k(int i) {
        if (i < 0) {
            this.X = 0;
        } else {
            this.X = i;
        }
    }

    public int n() {
        return v() + this.H;
    }

    public void o(int i) {
        this.H = i;
        int i2 = this.H;
        int i3 = this.W;
        if (i2 < i3) {
            this.H = i3;
        }
    }

    public void p(int i) {
        this.Z = i;
    }

    public DimensionBehaviour q() {
        return this.F[1];
    }

    public void r(int i) {
        this.L = i;
    }

    public int d() {
        return w() + this.I;
    }

    public void s(int i) {
        this.M = i;
    }

    public void c(float f2) {
        this.ba = f2;
    }

    public void d(int i, int i2) {
        if (i2 == 0) {
            this.N = i;
        } else if (i2 == 1) {
            this.O = i;
        }
    }

    public void l(int i) {
        if (i < 0) {
            this.W = 0;
        } else {
            this.W = i;
        }
    }

    public void m(int i) {
        this.na = i;
    }

    public DimensionBehaviour c(int i) {
        if (i == 0) {
            return j();
        }
        if (i == 1) {
            return q();
        }
        return null;
    }

    public void d(float f2) {
        this.qa[1] = f2;
    }

    public int e(int i) {
        if (i == 0) {
            return this.N;
        }
        if (i == 1) {
            return this.O;
        }
        return 0;
    }

    public void c(android.support.constraint.solver.e eVar) {
        int b2 = eVar.b(this.v);
        int b3 = eVar.b(this.w);
        int b4 = eVar.b(this.x);
        int b5 = eVar.b(this.y);
        int i = b5 - b3;
        if (b4 - b2 < 0 || i < 0 || b2 == Integer.MIN_VALUE || b2 == Integer.MAX_VALUE || b3 == Integer.MIN_VALUE || b3 == Integer.MAX_VALUE || b4 == Integer.MIN_VALUE || b4 == Integer.MAX_VALUE || b5 == Integer.MIN_VALUE || b5 == Integer.MAX_VALUE) {
            b5 = 0;
            b2 = 0;
            b3 = 0;
            b4 = 0;
        }
        a(b2, b3, b4, b5);
    }

    public float b(int i) {
        if (i == 0) {
            return this.aa;
        }
        if (i == 1) {
            return this.ba;
        }
        return -1.0f;
    }

    public void a(ConstraintWidget constraintWidget) {
        this.G = constraintWidget;
    }

    public ArrayList<ConstraintAnchor> b() {
        return this.E;
    }

    public void a(boolean z) {
        this.p = z;
    }

    public void b(int i, int i2) {
        this.T = i;
        this.U = i2;
    }

    public void a(ConstraintWidget constraintWidget, float f2, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        a(type, constraintWidget, type, i, 0);
        this.u = f2;
    }

    public void b(int i, int i2, int i3, float f2) {
        this.f258g = i;
        this.l = i2;
        this.m = i3;
        this.n = f2;
        if (f2 >= 1.0f || this.f258g != 0) {
            return;
        }
        this.f258g = 2;
    }

    public void a(String str) {
        this.fa = str;
    }

    public void a(int i, int i2, int i3, float f2) {
        this.f257f = i;
        this.i = i2;
        this.j = i3;
        this.k = f2;
        if (f2 >= 1.0f || this.f257f != 0) {
            return;
        }
        this.f257f = 2;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please report as a decompilation issue!!! */
    public void b(String str) {
        float f2;
        int i = 0;
        if (str != null && str.length() != 0) {
            int i2 = -1;
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i3 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i2 = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i2 = 1;
                }
                i3 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 >= 0 && indexOf2 < length - 1) {
                String substring2 = str.substring(i3, indexOf2);
                String substring3 = str.substring(indexOf2 + 1);
                if (substring2.length() > 0 && substring3.length() > 0) {
                    float parseFloat = Float.parseFloat(substring2);
                    float parseFloat2 = Float.parseFloat(substring3);
                    if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                        if (i2 == 1) {
                            f2 = Math.abs(parseFloat2 / parseFloat);
                        } else {
                            f2 = Math.abs(parseFloat / parseFloat2);
                        }
                    }
                }
                f2 = 0.0f;
            } else {
                String substring4 = str.substring(i3);
                if (substring4.length() > 0) {
                    f2 = Float.parseFloat(substring4);
                }
                f2 = 0.0f;
            }
            i = (f2 > i ? 1 : (f2 == i ? 0 : -1));
            if (i > 0) {
                this.J = f2;
                this.K = i2;
                return;
            }
            return;
        }
        this.J = 0.0f;
    }

    public void a(float f2) {
        this.aa = f2;
    }

    public void a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i3 - i;
        int i8 = i4 - i2;
        this.L = i;
        this.M = i2;
        if (this.ea == 8) {
            this.H = 0;
            this.I = 0;
            return;
        }
        if (this.F[0] != DimensionBehaviour.FIXED || i7 >= (i5 = this.H)) {
            i5 = i7;
        }
        if (this.F[1] != DimensionBehaviour.FIXED || i8 >= (i6 = this.I)) {
            i6 = i8;
        }
        this.H = i5;
        this.I = i6;
        int i9 = this.I;
        int i10 = this.X;
        if (i9 < i10) {
            this.I = i10;
        }
        int i11 = this.H;
        int i12 = this.W;
        if (i11 < i12) {
            this.H = i12;
        }
        this.ka = true;
    }

    public void a(int i, int i2, int i3) {
        if (i3 == 0) {
            a(i, i2);
        } else if (i3 == 1) {
            e(i, i2);
        }
        this.ka = true;
    }

    public void a(int i, int i2) {
        this.L = i;
        this.H = i2 - i;
        int i3 = this.H;
        int i4 = this.W;
        if (i3 < i4) {
            this.H = i4;
        }
    }

    public void b(float f2) {
        this.qa[0] = f2;
    }

    public void b(DimensionBehaviour dimensionBehaviour) {
        this.F[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            g(this.Z);
        }
    }

    public void a(Object obj) {
        this.ca = obj;
    }

    public boolean a() {
        return this.ea != 8;
    }

    public void a(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        a(type).a(constraintWidget.a(type2), i, i2, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public ConstraintAnchor a(ConstraintAnchor.Type type) {
        switch (f.f269a[type.ordinal()]) {
            case 1:
                return this.v;
            case 2:
                return this.w;
            case 3:
                return this.x;
            case 4:
                return this.y;
            case 5:
                return this.z;
            case 6:
                return this.C;
            case 7:
                return this.A;
            case 8:
                return this.B;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public void a(DimensionBehaviour dimensionBehaviour) {
        this.F[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            o(this.Y);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01b0, code lost:            if (r1 != (-1)) goto L288;     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0254 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.support.constraint.solver.e r39) {
        /*
            Method dump skipped, instructions count: 856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.a(android.support.constraint.solver.e):void");
    }

    public void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.q == -1) {
            if (z3 && !z4) {
                this.q = 0;
            } else if (!z3 && z4) {
                this.q = 1;
                if (this.K == -1) {
                    this.r = 1.0f / this.r;
                }
            }
        }
        if (this.q == 0 && (!this.w.i() || !this.y.i())) {
            this.q = 1;
        } else if (this.q == 1 && (!this.v.i() || !this.x.i())) {
            this.q = 0;
        }
        if (this.q == -1 && (!this.w.i() || !this.y.i() || !this.v.i() || !this.x.i())) {
            if (this.w.i() && this.y.i()) {
                this.q = 0;
            } else if (this.v.i() && this.x.i()) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (z && !z2) {
                this.q = 0;
            } else if (!z && z2) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1) {
            if (this.i > 0 && this.l == 0) {
                this.q = 0;
            } else if (this.i == 0 && this.l > 0) {
                this.r = 1.0f / this.r;
                this.q = 1;
            }
        }
        if (this.q == -1 && z && z2) {
            this.r = 1.0f / this.r;
            this.q = 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0260, code lost:            r1 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0246, code lost:            r1 = 4;        r6 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x023e, code lost:            if (r14 > 0) goto L342;     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0240, code lost:            if (r3 <= 0) goto L341;     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0243, code lost:            r1 = 6;        r6 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0248, code lost:            r5 = r23;        r26.a(r15, r5, r32.b(), r1);        r26.a(r9, r8, -r33.b(), r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0259, code lost:            if (r14 > 0) goto L348;     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x025b, code lost:            if (r3 <= 0) goto L347;     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x025e, code lost:            r1 = false;     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0261, code lost:            r16 = r6;        r14 = 5;     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0301 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.support.constraint.solver.e r26, boolean r27, android.support.constraint.solver.SolverVariable r28, android.support.constraint.solver.SolverVariable r29, android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour r30, boolean r31, android.support.constraint.solver.widgets.ConstraintAnchor r32, android.support.constraint.solver.widgets.ConstraintAnchor r33, int r34, int r35, int r36, int r37, float r38, boolean r39, boolean r40, int r41, int r42, int r43, float r44, boolean r45) {
        /*
            Method dump skipped, instructions count: 836
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.ConstraintWidget.a(android.support.constraint.solver.e, boolean, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.SolverVariable, android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, android.support.constraint.solver.widgets.ConstraintAnchor, android.support.constraint.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }
}
