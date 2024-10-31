package android.support.constraint.solver;

import android.support.constraint.solver.SolverVariable;
import java.util.Arrays;

/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b */
    private final b f211b;

    /* renamed from: c */
    private final c f212c;

    /* renamed from: f */
    private int[] f215f;

    /* renamed from: g */
    private int[] f216g;

    /* renamed from: h */
    private float[] f217h;
    private int i;
    private int j;
    private boolean k;

    /* renamed from: a */
    int f210a = 0;

    /* renamed from: d */
    private int f213d = 8;

    /* renamed from: e */
    private SolverVariable f214e = null;

    public a(b bVar, c cVar) {
        int i = this.f213d;
        this.f215f = new int[i];
        this.f216g = new int[i];
        this.f217h = new float[i];
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f211b = bVar;
        this.f212c = cVar;
    }

    public final void a(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            a(solverVariable, true);
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.f217h;
            int i2 = this.i;
            fArr[i2] = f2;
            this.f215f[i2] = solverVariable.f204c;
            this.f216g[i2] = -1;
            solverVariable.k++;
            solverVariable.a(this.f211b);
            this.f210a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f215f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f210a; i5++) {
            int[] iArr2 = this.f215f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f204c;
            if (i6 == i7) {
                this.f217h[i] = f2;
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.f216g[i];
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr3 = this.f215f;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f215f;
        if (i8 >= iArr4.length && this.f210a < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f215f;
                if (i10 >= iArr5.length) {
                    break;
                }
                if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr6 = this.f215f;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            this.f213d *= 2;
            this.k = false;
            this.j = i8 - 1;
            this.f217h = Arrays.copyOf(this.f217h, this.f213d);
            this.f215f = Arrays.copyOf(this.f215f, this.f213d);
            this.f216g = Arrays.copyOf(this.f216g, this.f213d);
        }
        this.f215f[i8] = solverVariable.f204c;
        this.f217h[i8] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f216g;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.f216g[i8] = this.i;
            this.i = i8;
        }
        solverVariable.k++;
        solverVariable.a(this.f211b);
        this.f210a++;
        if (!this.k) {
            this.j++;
        }
        if (this.f210a >= this.f215f.length) {
            this.k = true;
        }
        int i11 = this.j;
        int[] iArr8 = this.f215f;
        if (i11 >= iArr8.length) {
            this.k = true;
            this.j = iArr8.length - 1;
        }
    }

    public void b() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            float[] fArr = this.f217h;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f216g[i];
        }
    }

    public String toString() {
        int i = this.i;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            str = ((str + " -> ") + this.f217h[i] + " : ") + this.f212c.f225c[this.f215f[i]];
            i = this.f216g[i];
        }
        return str;
    }

    public final float b(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f210a; i3++) {
            if (i3 == i) {
                return this.f217h[i2];
            }
            i2 = this.f216g[i2];
        }
        return 0.0f;
    }

    public final float b(SolverVariable solverVariable) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            if (this.f215f[i] == solverVariable.f204c) {
                return this.f217h[i];
            }
            i = this.f216g[i];
        }
        return 0.0f;
    }

    public final void a(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 == 0.0f) {
            return;
        }
        int i = this.i;
        if (i == -1) {
            this.i = 0;
            float[] fArr = this.f217h;
            int i2 = this.i;
            fArr[i2] = f2;
            this.f215f[i2] = solverVariable.f204c;
            this.f216g[i2] = -1;
            solverVariable.k++;
            solverVariable.a(this.f211b);
            this.f210a++;
            if (this.k) {
                return;
            }
            this.j++;
            int i3 = this.j;
            int[] iArr = this.f215f;
            if (i3 >= iArr.length) {
                this.k = true;
                this.j = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i != -1 && i5 < this.f210a; i5++) {
            int[] iArr2 = this.f215f;
            int i6 = iArr2[i];
            int i7 = solverVariable.f204c;
            if (i6 == i7) {
                float[] fArr2 = this.f217h;
                fArr2[i] = fArr2[i] + f2;
                if (fArr2[i] == 0.0f) {
                    if (i == this.i) {
                        this.i = this.f216g[i];
                    } else {
                        int[] iArr3 = this.f216g;
                        iArr3[i4] = iArr3[i];
                    }
                    if (z) {
                        solverVariable.b(this.f211b);
                    }
                    if (this.k) {
                        this.j = i;
                    }
                    solverVariable.k--;
                    this.f210a--;
                    return;
                }
                return;
            }
            if (iArr2[i] < i7) {
                i4 = i;
            }
            i = this.f216g[i];
        }
        int i8 = this.j;
        int i9 = i8 + 1;
        if (this.k) {
            int[] iArr4 = this.f215f;
            if (iArr4[i8] != -1) {
                i8 = iArr4.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr5 = this.f215f;
        if (i8 >= iArr5.length && this.f210a < iArr5.length) {
            int i10 = 0;
            while (true) {
                int[] iArr6 = this.f215f;
                if (i10 >= iArr6.length) {
                    break;
                }
                if (iArr6[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr7 = this.f215f;
        if (i8 >= iArr7.length) {
            i8 = iArr7.length;
            this.f213d *= 2;
            this.k = false;
            this.j = i8 - 1;
            this.f217h = Arrays.copyOf(this.f217h, this.f213d);
            this.f215f = Arrays.copyOf(this.f215f, this.f213d);
            this.f216g = Arrays.copyOf(this.f216g, this.f213d);
        }
        this.f215f[i8] = solverVariable.f204c;
        this.f217h[i8] = f2;
        if (i4 != -1) {
            int[] iArr8 = this.f216g;
            iArr8[i8] = iArr8[i4];
            iArr8[i4] = i8;
        } else {
            this.f216g[i8] = this.i;
            this.i = i8;
        }
        solverVariable.k++;
        solverVariable.a(this.f211b);
        this.f210a++;
        if (!this.k) {
            this.j++;
        }
        int i11 = this.j;
        int[] iArr9 = this.f215f;
        if (i11 >= iArr9.length) {
            this.k = true;
            this.j = iArr9.length - 1;
        }
    }

    public final float a(SolverVariable solverVariable, boolean z) {
        if (this.f214e == solverVariable) {
            this.f214e = null;
        }
        int i = this.i;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f210a) {
            if (this.f215f[i] == solverVariable.f204c) {
                if (i == this.i) {
                    this.i = this.f216g[i];
                } else {
                    int[] iArr = this.f216g;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    solverVariable.b(this.f211b);
                }
                solverVariable.k--;
                this.f210a--;
                this.f215f[i] = -1;
                if (this.k) {
                    this.j = i;
                }
                return this.f217h[i];
            }
            i2++;
            i3 = i;
            i = this.f216g[i];
        }
        return 0.0f;
    }

    public final void a() {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            SolverVariable solverVariable = this.f212c.f225c[this.f215f[i]];
            if (solverVariable != null) {
                solverVariable.b(this.f211b);
            }
            i = this.f216g[i];
        }
        this.i = -1;
        this.j = -1;
        this.k = false;
        this.f210a = 0;
    }

    public final boolean a(SolverVariable solverVariable) {
        int i = this.i;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            if (this.f215f[i] == solverVariable.f204c) {
                return true;
            }
            i = this.f216g[i];
        }
        return false;
    }

    public void a(float f2) {
        int i = this.i;
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            float[] fArr = this.f217h;
            fArr[i] = fArr[i] / f2;
            i = this.f216g[i];
        }
    }

    private boolean a(SolverVariable solverVariable, e eVar) {
        return solverVariable.k <= 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.support.constraint.solver.SolverVariable a(android.support.constraint.solver.e r15) {
        /*
            r14 = this;
            int r0 = r14.i
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        La:
            r9 = -1
            if (r0 == r9) goto L97
            int r9 = r14.f210a
            if (r2 >= r9) goto L97
            float[] r9 = r14.f217h
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            android.support.constraint.solver.c r12 = r14.f212c
            android.support.constraint.solver.SolverVariable[] r12 = r12.f225c
            int[] r13 = r14.f215f
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L35
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L41
            r9[r0] = r3
            android.support.constraint.solver.b r9 = r14.f211b
            r12.b(r9)
            goto L40
        L35:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L41
            r9[r0] = r3
            android.support.constraint.solver.b r9 = r14.f211b
            r12.b(r9)
        L40:
            r10 = 0
        L41:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L8f
            android.support.constraint.solver.SolverVariable$Type r11 = r12.f209h
            android.support.constraint.solver.SolverVariable$Type r13 = android.support.constraint.solver.SolverVariable.Type.UNRESTRICTED
            if (r11 != r13) goto L6b
            if (r4 != 0) goto L56
            boolean r4 = r14.a(r12, r15)
        L52:
            r6 = r4
            r5 = r10
            r4 = r12
            goto L8f
        L56:
            int r11 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r11 <= 0) goto L5f
            boolean r4 = r14.a(r12, r15)
            goto L52
        L5f:
            if (r6 != 0) goto L8f
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L8f
            r5 = r10
            r4 = r12
            r6 = 1
            goto L8f
        L6b:
            if (r4 != 0) goto L8f
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L8f
            if (r1 != 0) goto L7b
            boolean r1 = r14.a(r12, r15)
        L77:
            r8 = r1
            r7 = r10
            r1 = r12
            goto L8f
        L7b:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L84
            boolean r1 = r14.a(r12, r15)
            goto L77
        L84:
            if (r8 != 0) goto L8f
            boolean r11 = r14.a(r12, r15)
            if (r11 == 0) goto L8f
            r7 = r10
            r1 = r12
            r8 = 1
        L8f:
            int[] r9 = r14.f216g
            r0 = r9[r0]
            int r2 = r2 + 1
            goto La
        L97:
            if (r4 == 0) goto L9a
            return r4
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.a.a(android.support.constraint.solver.e):android.support.constraint.solver.SolverVariable");
    }

    public final void a(b bVar, b bVar2, boolean z) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
                int i3 = this.f215f[i];
                SolverVariable solverVariable = bVar2.f218a;
                if (i3 == solverVariable.f204c) {
                    float f2 = this.f217h[i];
                    a(solverVariable, z);
                    a aVar = bVar2.f221d;
                    int i4 = aVar.i;
                    for (int i5 = 0; i4 != -1 && i5 < aVar.f210a; i5++) {
                        a(this.f212c.f225c[aVar.f215f[i4]], aVar.f217h[i4] * f2, z);
                        i4 = aVar.f216g[i4];
                    }
                    bVar.f219b += bVar2.f219b * f2;
                    if (z) {
                        bVar2.f218a.b(bVar);
                    }
                    i = this.i;
                } else {
                    i = this.f216g[i];
                }
            }
            return;
        }
    }

    public void a(b bVar, b[] bVarArr) {
        int i = this.i;
        while (true) {
            for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
                SolverVariable solverVariable = this.f212c.f225c[this.f215f[i]];
                if (solverVariable.f205d != -1) {
                    float f2 = this.f217h[i];
                    a(solverVariable, true);
                    b bVar2 = bVarArr[solverVariable.f205d];
                    if (!bVar2.f222e) {
                        a aVar = bVar2.f221d;
                        int i3 = aVar.i;
                        for (int i4 = 0; i3 != -1 && i4 < aVar.f210a; i4++) {
                            a(this.f212c.f225c[aVar.f215f[i3]], aVar.f217h[i3] * f2, true);
                            i3 = aVar.f216g[i3];
                        }
                    }
                    bVar.f219b += bVar2.f219b * f2;
                    bVar2.f218a.b(bVar);
                    i = this.i;
                } else {
                    i = this.f216g[i];
                }
            }
            return;
        }
    }

    public SolverVariable a(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int i = this.i;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i2 = 0; i != -1 && i2 < this.f210a; i2++) {
            if (this.f217h[i] < 0.0f) {
                SolverVariable solverVariable3 = this.f212c.f225c[this.f215f[i]];
                if ((zArr == null || !zArr[solverVariable3.f204c]) && solverVariable3 != solverVariable && ((type = solverVariable3.f209h) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR)) {
                    float f3 = this.f217h[i];
                    if (f3 < f2) {
                        solverVariable2 = solverVariable3;
                        f2 = f3;
                    }
                }
            }
            i = this.f216g[i];
        }
        return solverVariable2;
    }

    public final SolverVariable a(int i) {
        int i2 = this.i;
        for (int i3 = 0; i2 != -1 && i3 < this.f210a; i3++) {
            if (i3 == i) {
                return this.f212c.f225c[this.f215f[i2]];
            }
            i2 = this.f216g[i2];
        }
        return null;
    }
}
