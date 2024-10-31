package android.support.v4.util;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {

    /* renamed from: a */
    static Object[] f1748a;

    /* renamed from: b */
    static int f1749b;

    /* renamed from: c */
    static Object[] f1750c;

    /* renamed from: d */
    static int f1751d;

    /* renamed from: e */
    int[] f1752e;

    /* renamed from: f */
    Object[] f1753f;

    /* renamed from: g */
    int f1754g;

    public SimpleArrayMap() {
        this.f1752e = ContainerHelpers.f1716a;
        this.f1753f = ContainerHelpers.f1718c;
        this.f1754g = 0;
    }

    private static int a(int[] iArr, int i, int i2) {
        try {
            return ContainerHelpers.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i = this.f1754g;
        if (i > 0) {
            int[] iArr = this.f1752e;
            Object[] objArr = this.f1753f;
            this.f1752e = ContainerHelpers.f1716a;
            this.f1753f = ContainerHelpers.f1718c;
            this.f1754g = 0;
            a(iArr, objArr, i);
        }
        if (this.f1754g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        int i2 = this.f1754g;
        int[] iArr = this.f1752e;
        if (iArr.length < i) {
            Object[] objArr = this.f1753f;
            a(i);
            if (this.f1754g > 0) {
                System.arraycopy(iArr, 0, this.f1752e, 0, i2);
                System.arraycopy(objArr, 0, this.f1753f, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.f1754g != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleArrayMap) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
            if (size() != simpleArrayMap.size()) {
                return false;
            }
            for (int i = 0; i < this.f1754g; i++) {
                try {
                    K keyAt = keyAt(i);
                    V valueAt = valueAt(i);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1754g; i2++) {
                try {
                    K keyAt2 = keyAt(i2);
                    V valueAt2 = valueAt(i2);
                    Object obj3 = map.get(keyAt2);
                    if (valueAt2 == null) {
                        if (obj3 != null || !map.containsKey(keyAt2)) {
                            return false;
                        }
                    } else if (!valueAt2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return (V) this.f1753f[(indexOfKey << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f1752e;
        Object[] objArr = this.f1753f;
        int i = this.f1754g;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1754g <= 0;
    }

    public K keyAt(int i) {
        return (K) this.f1753f[i << 1];
    }

    public V put(K k, V v) {
        int i;
        int a2;
        int i2 = this.f1754g;
        if (k == null) {
            a2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i3 = (a2 << 1) + 1;
            Object[] objArr = this.f1753f;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = a2 ^ (-1);
        if (i2 >= this.f1752e.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f1752e;
            Object[] objArr2 = this.f1753f;
            a(i5);
            if (i2 == this.f1754g) {
                int[] iArr2 = this.f1752e;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.f1753f, 0, objArr2.length);
                }
                a(iArr, objArr2, i2);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i4 < i2) {
            int[] iArr3 = this.f1752e;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.f1753f;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.f1754g - i4) << 1);
        }
        int i7 = this.f1754g;
        if (i2 == i7) {
            int[] iArr4 = this.f1752e;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.f1753f;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.f1754g = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.f1754g;
        ensureCapacity(this.f1754g + i);
        if (this.f1754g != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.f1752e, 0, this.f1752e, 0, i);
            System.arraycopy(simpleArrayMap.f1753f, 0, this.f1753f, 0, i << 1);
            this.f1754g = i;
        }
    }

    public V remove(Object obj) {
        int indexOfKey = indexOfKey(obj);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V removeAt(int i) {
        int i2;
        Object[] objArr = this.f1753f;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f1754g;
        if (i4 <= 1) {
            a(this.f1752e, objArr, i4);
            this.f1752e = ContainerHelpers.f1716a;
            this.f1753f = ContainerHelpers.f1718c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f1752e;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.f1752e;
                Object[] objArr2 = this.f1753f;
                a(i5);
                if (i4 != this.f1754g) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f1752e, 0, i);
                    System.arraycopy(objArr2, 0, this.f1753f, 0, i3);
                }
                if (i < i2) {
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, this.f1752e, i, i7);
                    System.arraycopy(objArr2, i6 << 1, this.f1753f, i3, i7 << 1);
                }
            } else {
                if (i < i2) {
                    int[] iArr3 = this.f1752e;
                    int i8 = i + 1;
                    int i9 = i2 - i;
                    System.arraycopy(iArr3, i8, iArr3, i, i9);
                    Object[] objArr3 = this.f1753f;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.f1753f;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 == this.f1754g) {
            this.f1754g = i2;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.f1753f;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public int size() {
        return this.f1754g;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1754g * 28);
        sb.append('{');
        for (int i = 0; i < this.f1754g; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i);
            if (keyAt != this) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i) {
        return (V) this.f1753f[(i << 1) + 1];
    }

    int a(Object obj, int i) {
        int i2 = this.f1754g;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f1752e, i2, i);
        if (a2 < 0 || obj.equals(this.f1753f[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1752e[i3] == i) {
            if (obj.equals(this.f1753f[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f1752e[i4] == i; i4--) {
            if (obj.equals(this.f1753f[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.f1752e = ContainerHelpers.f1716a;
            this.f1753f = ContainerHelpers.f1718c;
        } else {
            a(i);
        }
        this.f1754g = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    int a() {
        int i = this.f1754g;
        if (i == 0) {
            return -1;
        }
        int a2 = a(this.f1752e, i, 0);
        if (a2 < 0 || this.f1753f[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f1752e[i2] == 0) {
            if (this.f1753f[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a2 - 1; i3 >= 0 && this.f1752e[i3] == 0; i3--) {
            if (this.f1753f[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (f1750c != null) {
                    Object[] objArr = f1750c;
                    this.f1753f = objArr;
                    f1750c = (Object[]) objArr[0];
                    this.f1752e = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1751d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (f1748a != null) {
                    Object[] objArr2 = f1748a;
                    this.f1753f = objArr2;
                    f1748a = (Object[]) objArr2[0];
                    this.f1752e = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1749b--;
                    return;
                }
            }
        }
        this.f1752e = new int[i];
        this.f1753f = new Object[i << 1];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (f1751d < 10) {
                    objArr[0] = f1750c;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1750c = objArr;
                    f1751d++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (f1749b < 10) {
                    objArr[0] = f1748a;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1748a = objArr;
                    f1749b++;
                }
            }
        }
    }

    public int a(Object obj) {
        int i = this.f1754g * 2;
        Object[] objArr = this.f1753f;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }
}
