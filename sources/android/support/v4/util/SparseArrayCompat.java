package android.support.v4.util;

/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1755a = new Object();

    /* renamed from: b */
    private boolean f1756b;

    /* renamed from: c */
    private int[] f1757c;

    /* renamed from: d */
    private Object[] f1758d;

    /* renamed from: e */
    private int f1759e;

    public SparseArrayCompat() {
        this(10);
    }

    private void a() {
        int i = this.f1759e;
        int[] iArr = this.f1757c;
        Object[] objArr = this.f1758d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1755a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1756b = false;
        this.f1759e = i2;
    }

    public void append(int i, E e2) {
        int i2 = this.f1759e;
        if (i2 != 0 && i <= this.f1757c[i2 - 1]) {
            put(i, e2);
            return;
        }
        if (this.f1756b && this.f1759e >= this.f1757c.length) {
            a();
        }
        int i3 = this.f1759e;
        if (i3 >= this.f1757c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.f1757c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1758d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1757c = iArr;
            this.f1758d = objArr;
        }
        this.f1757c[i3] = i;
        this.f1758d[i3] = e2;
        this.f1759e = i3 + 1;
    }

    public void clear() {
        int i = this.f1759e;
        Object[] objArr = this.f1758d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1759e = 0;
        this.f1756b = false;
    }

    public void delete(int i) {
        int a2 = ContainerHelpers.a(this.f1757c, this.f1759e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1758d;
            Object obj = objArr[a2];
            Object obj2 = f1755a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1756b = true;
            }
        }
    }

    public E get(int i) {
        return get(i, null);
    }

    public int indexOfKey(int i) {
        if (this.f1756b) {
            a();
        }
        return ContainerHelpers.a(this.f1757c, this.f1759e, i);
    }

    public int indexOfValue(E e2) {
        if (this.f1756b) {
            a();
        }
        for (int i = 0; i < this.f1759e; i++) {
            if (this.f1758d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public int keyAt(int i) {
        if (this.f1756b) {
            a();
        }
        return this.f1757c[i];
    }

    public void put(int i, E e2) {
        int a2 = ContainerHelpers.a(this.f1757c, this.f1759e, i);
        if (a2 >= 0) {
            this.f1758d[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f1759e) {
            Object[] objArr = this.f1758d;
            if (objArr[i2] == f1755a) {
                this.f1757c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1756b && this.f1759e >= this.f1757c.length) {
            a();
            i2 = ContainerHelpers.a(this.f1757c, this.f1759e, i) ^ (-1);
        }
        int i3 = this.f1759e;
        if (i3 >= this.f1757c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.f1757c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1758d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1757c = iArr;
            this.f1758d = objArr2;
        }
        int i4 = this.f1759e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1757c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1758d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1759e - i2);
        }
        this.f1757c[i2] = i;
        this.f1758d[i2] = e2;
        this.f1759e++;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        Object[] objArr = this.f1758d;
        Object obj = objArr[i];
        Object obj2 = f1755a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1756b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f1759e, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public void setValueAt(int i, E e2) {
        if (this.f1756b) {
            a();
        }
        this.f1758d[i] = e2;
    }

    public int size() {
        if (this.f1756b) {
            a();
        }
        return this.f1759e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1759e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1759e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i));
            sb.append('=');
            E valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        if (this.f1756b) {
            a();
        }
        return (E) this.f1758d[i];
    }

    public SparseArrayCompat(int i) {
        this.f1756b = false;
        if (i == 0) {
            this.f1757c = ContainerHelpers.f1716a;
            this.f1758d = ContainerHelpers.f1718c;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i);
            this.f1757c = new int[idealIntArraySize];
            this.f1758d = new Object[idealIntArraySize];
        }
        this.f1759e = 0;
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m5clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            try {
                sparseArrayCompat.f1757c = (int[]) this.f1757c.clone();
                sparseArrayCompat.f1758d = (Object[]) this.f1758d.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException unused) {
                return sparseArrayCompat;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E get(int i, E e2) {
        int a2 = ContainerHelpers.a(this.f1757c, this.f1759e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f1758d;
            if (objArr[a2] != f1755a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }
}
