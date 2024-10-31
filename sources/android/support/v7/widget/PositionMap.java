package android.support.v7.widget;

import java.util.ArrayList;

/* loaded from: classes.dex */
class PositionMap<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f2872a = new Object();

    /* renamed from: b */
    private boolean f2873b;

    /* renamed from: c */
    private int[] f2874c;

    /* renamed from: d */
    private Object[] f2875d;

    /* renamed from: e */
    private int f2876e;

    /* loaded from: classes.dex */
    public static class ContainerHelpers {

        /* renamed from: a */
        static final boolean[] f2877a = new boolean[0];

        /* renamed from: b */
        static final int[] f2878b = new int[0];

        /* renamed from: c */
        static final long[] f2879c = new long[0];

        /* renamed from: d */
        static final Object[] f2880d = new Object[0];

        ContainerHelpers() {
        }

        static int a(int[] iArr, int i, int i2) {
            int i3 = i - 1;
            int i4 = 0;
            while (i4 <= i3) {
                int i5 = (i4 + i3) >>> 1;
                int i6 = iArr[i5];
                if (i6 < i2) {
                    i4 = i5 + 1;
                } else {
                    if (i6 <= i2) {
                        return i5;
                    }
                    i3 = i5 - 1;
                }
            }
            return i4 ^ (-1);
        }
    }

    PositionMap() {
        this(10);
    }

    static int a(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    private void a() {
        int i = this.f2876e;
        int[] iArr = this.f2874c;
        Object[] objArr = this.f2875d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f2872a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f2873b = false;
        this.f2876e = i2;
    }

    static int b(int i) {
        return a(i * 4) / 4;
    }

    public void append(int i, E e2) {
        int i2 = this.f2876e;
        if (i2 != 0 && i <= this.f2874c[i2 - 1]) {
            put(i, e2);
            return;
        }
        if (this.f2873b && this.f2876e >= this.f2874c.length) {
            a();
        }
        int i3 = this.f2876e;
        if (i3 >= this.f2874c.length) {
            int b2 = b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr = new Object[b2];
            int[] iArr2 = this.f2874c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2875d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2874c = iArr;
            this.f2875d = objArr;
        }
        this.f2874c[i3] = i;
        this.f2875d[i3] = e2;
        this.f2876e = i3 + 1;
    }

    public void clear() {
        int i = this.f2876e;
        Object[] objArr = this.f2875d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f2876e = 0;
        this.f2873b = false;
    }

    public void delete(int i) {
        int a2 = ContainerHelpers.a(this.f2874c, this.f2876e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f2875d;
            Object obj = objArr[a2];
            Object obj2 = f2872a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f2873b = true;
            }
        }
    }

    public E get(int i) {
        return get(i, null);
    }

    public int indexOfKey(int i) {
        if (this.f2873b) {
            a();
        }
        return ContainerHelpers.a(this.f2874c, this.f2876e, i);
    }

    public int indexOfValue(E e2) {
        if (this.f2873b) {
            a();
        }
        for (int i = 0; i < this.f2876e; i++) {
            if (this.f2875d[i] == e2) {
                return i;
            }
        }
        return -1;
    }

    public void insertKeyRange(int i, int i2) {
    }

    public int keyAt(int i) {
        if (this.f2873b) {
            a();
        }
        return this.f2874c[i];
    }

    public void put(int i, E e2) {
        int a2 = ContainerHelpers.a(this.f2874c, this.f2876e, i);
        if (a2 >= 0) {
            this.f2875d[a2] = e2;
            return;
        }
        int i2 = a2 ^ (-1);
        if (i2 < this.f2876e) {
            Object[] objArr = this.f2875d;
            if (objArr[i2] == f2872a) {
                this.f2874c[i2] = i;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f2873b && this.f2876e >= this.f2874c.length) {
            a();
            i2 = ContainerHelpers.a(this.f2874c, this.f2876e, i) ^ (-1);
        }
        int i3 = this.f2876e;
        if (i3 >= this.f2874c.length) {
            int b2 = b(i3 + 1);
            int[] iArr = new int[b2];
            Object[] objArr2 = new Object[b2];
            int[] iArr2 = this.f2874c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2875d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2874c = iArr;
            this.f2875d = objArr2;
        }
        int i4 = this.f2876e;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f2874c;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f2875d;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f2876e - i2);
        }
        this.f2874c[i2] = i;
        this.f2875d[i2] = e2;
        this.f2876e++;
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        Object[] objArr = this.f2875d;
        Object obj = objArr[i];
        Object obj2 = f2872a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f2873b = true;
        }
    }

    public void removeAtRange(int i, int i2) {
        int min = Math.min(this.f2876e, i2 + i);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public void removeKeyRange(ArrayList<E> arrayList, int i, int i2) {
    }

    public void setValueAt(int i, E e2) {
        if (this.f2873b) {
            a();
        }
        this.f2875d[i] = e2;
    }

    public int size() {
        if (this.f2873b) {
            a();
        }
        return this.f2876e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2876e * 28);
        sb.append('{');
        for (int i = 0; i < this.f2876e; i++) {
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
        if (this.f2873b) {
            a();
        }
        return (E) this.f2875d[i];
    }

    PositionMap(int i) {
        this.f2873b = false;
        if (i == 0) {
            this.f2874c = ContainerHelpers.f2878b;
            this.f2875d = ContainerHelpers.f2880d;
        } else {
            int b2 = b(i);
            this.f2874c = new int[b2];
            this.f2875d = new Object[b2];
        }
        this.f2876e = 0;
    }

    /* renamed from: clone */
    public PositionMap<E> m6clone() {
        try {
            PositionMap<E> positionMap = (PositionMap) super.clone();
            try {
                positionMap.f2874c = (int[]) this.f2874c.clone();
                positionMap.f2875d = (Object[]) this.f2875d.clone();
                return positionMap;
            } catch (CloneNotSupportedException unused) {
                return positionMap;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    public E get(int i, E e2) {
        int a2 = ContainerHelpers.a(this.f2874c, this.f2876e, i);
        if (a2 >= 0) {
            Object[] objArr = this.f2875d;
            if (objArr[a2] != f2872a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }
}
