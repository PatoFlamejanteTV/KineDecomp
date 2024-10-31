package android.support.constraint.solver;

import java.util.Arrays;

/* loaded from: classes.dex */
public class SolverVariable {

    /* renamed from: a */
    private static int f202a = 1;

    /* renamed from: b */
    private String f203b;

    /* renamed from: f */
    public float f207f;

    /* renamed from: h */
    Type f209h;

    /* renamed from: c */
    public int f204c = -1;

    /* renamed from: d */
    int f205d = -1;

    /* renamed from: e */
    public int f206e = 0;

    /* renamed from: g */
    float[] f208g = new float[7];
    b[] i = new b[8];
    int j = 0;
    public int k = 0;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f209h = type;
    }

    public static void a() {
        f202a++;
    }

    public final void b(b bVar) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.i[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    b[] bVarArr = this.i;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.j--;
                return;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            b[] bVarArr = this.i;
            bVarArr[i2].f221d.a(bVarArr[i2], bVar, false);
        }
        this.j = 0;
    }

    public String toString() {
        return "" + this.f203b;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.j;
            if (i < i2) {
                if (this.i[i] == bVar) {
                    return;
                } else {
                    i++;
                }
            } else {
                b[] bVarArr = this.i;
                if (i2 >= bVarArr.length) {
                    this.i = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.i;
                int i3 = this.j;
                bVarArr2[i3] = bVar;
                this.j = i3 + 1;
                return;
            }
        }
    }

    public void b() {
        this.f203b = null;
        this.f209h = Type.UNKNOWN;
        this.f206e = 0;
        this.f204c = -1;
        this.f205d = -1;
        this.f207f = 0.0f;
        this.j = 0;
        this.k = 0;
    }

    public void a(Type type, String str) {
        this.f209h = type;
    }
}
