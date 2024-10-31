package android.support.v4.util;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1721a = new Object();

    /* renamed from: b */
    private boolean f1722b;

    /* renamed from: c */
    private long[] f1723c;

    /* renamed from: d */
    private Object[] f1724d;

    /* renamed from: e */
    private int f1725e;

    public LongSparseArray() {
        this(10);
    }

    private void a() {
        int i = this.f1725e;
        long[] jArr = this.f1723c;
        Object[] objArr = this.f1724d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f1721a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f1722b = false;
        this.f1725e = i2;
    }

    public void append(long j, E e2) {
        int i = this.f1725e;
        if (i != 0 && j <= this.f1723c[i - 1]) {
            put(j, e2);
            return;
        }
        if (this.f1722b && this.f1725e >= this.f1723c.length) {
            a();
        }
        int i2 = this.f1725e;
        if (i2 >= this.f1723c.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.f1723c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1724d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1723c = jArr;
            this.f1724d = objArr;
        }
        this.f1723c[i2] = j;
        this.f1724d[i2] = e2;
        this.f1725e = i2 + 1;
    }

    public void clear() {
        int i = this.f1725e;
        Object[] objArr = this.f1724d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1725e = 0;
        this.f1722b = false;
    }

    public void delete(long j) {
        int a2 = ContainerHelpers.a(this.f1723c, this.f1725e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1724d;
            Object obj = objArr[a2];
            Object obj2 = f1721a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1722b = true;
            }
        }
    }

    public E get(long j) {
        return get(j, null);
    }

    public int indexOfKey(long j) {
        if (this.f1722b) {
            a();
        }
        return ContainerHelpers.a(this.f1723c, this.f1725e, j);
    }

    public int indexOfValue(E e2) {
        if (this.f1722b) {
            a();
        }
        for (int i = 0; i < this.f1725e; i++) {
            if (this.f1724d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public long keyAt(int i) {
        if (this.f1722b) {
            a();
        }
        return this.f1723c[i];
    }

    public void put(long j, E e2) {
        int a2 = ContainerHelpers.a(this.f1723c, this.f1725e, j);
        if (a2 >= 0) {
            this.f1724d[a2] = e2;
            return;
        }
        int i = a2 ^ (-1);
        if (i < this.f1725e) {
            Object[] objArr = this.f1724d;
            if (objArr[i] == f1721a) {
                this.f1723c[i] = j;
                objArr[i] = e2;
                return;
            }
        }
        if (this.f1722b && this.f1725e >= this.f1723c.length) {
            a();
            i = ContainerHelpers.a(this.f1723c, this.f1725e, j) ^ (-1);
        }
        int i2 = this.f1725e;
        if (i2 >= this.f1723c.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.f1723c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1724d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1723c = jArr;
            this.f1724d = objArr2;
        }
        int i3 = this.f1725e;
        if (i3 - i != 0) {
            long[] jArr3 = this.f1723c;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f1724d;
            System.arraycopy(objArr4, i, objArr4, i4, this.f1725e - i);
        }
        this.f1723c[i] = j;
        this.f1724d[i] = e2;
        this.f1725e++;
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        Object[] objArr = this.f1724d;
        Object obj = objArr[i];
        Object obj2 = f1721a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f1722b = true;
        }
    }

    public void setValueAt(int i, E e2) {
        if (this.f1722b) {
            a();
        }
        this.f1724d[i] = e2;
    }

    public int size() {
        if (this.f1722b) {
            a();
        }
        return this.f1725e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1725e * 28);
        sb.append('{');
        for (int i = 0; i < this.f1725e; i++) {
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
        if (this.f1722b) {
            a();
        }
        return (E) this.f1724d[i];
    }

    public LongSparseArray(int i) {
        this.f1722b = false;
        if (i == 0) {
            this.f1723c = ContainerHelpers.f1717b;
            this.f1724d = ContainerHelpers.f1718c;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i);
            this.f1723c = new long[idealLongArraySize];
            this.f1724d = new Object[idealLongArraySize];
        }
        this.f1725e = 0;
    }

    /* renamed from: clone */
    public LongSparseArray<E> m4clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            try {
                longSparseArray.f1723c = (long[]) this.f1723c.clone();
                longSparseArray.f1724d = (Object[]) this.f1724d.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException unused) {
                return longSparseArray;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E get(long j, E e2) {
        int a2 = ContainerHelpers.a(this.f1723c, this.f1725e, j);
        if (a2 >= 0) {
            Object[] objArr = this.f1724d;
            if (objArr[a2] != f1721a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }
}
