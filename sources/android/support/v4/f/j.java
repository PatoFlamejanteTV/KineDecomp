package android.support.v4.f;

/* compiled from: SparseArrayCompat.java */
/* loaded from: classes.dex */
public class j<E> implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f86a = new Object();
    private boolean b;
    private int[] c;
    private Object[] d;
    private int e;

    public j() {
        this(10);
    }

    public j(int i) {
        this.b = false;
        if (i == 0) {
            this.c = c.f77a;
            this.d = c.c;
        } else {
            int a2 = c.a(i);
            this.c = new int[a2];
            this.d = new Object[a2];
        }
        this.e = 0;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public j<E> clone() {
        try {
            j<E> jVar = (j) super.clone();
            try {
                jVar.c = (int[]) this.c.clone();
                jVar.d = (Object[]) this.d.clone();
                return jVar;
            } catch (CloneNotSupportedException e) {
                return jVar;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    private void d() {
        int i = this.e;
        int[] iArr = this.c;
        Object[] objArr = this.d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f86a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.e = i2;
    }

    public int b() {
        if (this.b) {
            d();
        }
        return this.e;
    }

    public int a(int i) {
        if (this.b) {
            d();
        }
        return this.c[i];
    }

    public E b(int i) {
        if (this.b) {
            d();
        }
        return (E) this.d[i];
    }

    public void c() {
        int i = this.e;
        Object[] objArr = this.d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.e = 0;
        this.b = false;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.e * 28);
        sb.append('{');
        for (int i = 0; i < this.e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(a(i));
            sb.append('=');
            E b = b(i);
            if (b != this) {
                sb.append(b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
