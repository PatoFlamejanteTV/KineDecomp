package android.support.v4.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {

    /* renamed from: a */
    private static final int[] f1697a = new int[0];

    /* renamed from: b */
    private static final Object[] f1698b = new Object[0];

    /* renamed from: c */
    private static Object[] f1699c;

    /* renamed from: d */
    private static int f1700d;

    /* renamed from: e */
    private static Object[] f1701e;

    /* renamed from: f */
    private static int f1702f;

    /* renamed from: g */
    private int[] f1703g;

    /* renamed from: h */
    private Object[] f1704h;
    private int i;
    private MapCollections<E, E> j;

    /* renamed from: android.support.v4.util.ArraySet$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends MapCollections<E, E> {
        AnonymousClass1() {
        }

        @Override // android.support.v4.util.MapCollections
        protected Object a(int i, int i2) {
            return ArraySet.this.f1704h[i];
        }

        @Override // android.support.v4.util.MapCollections
        protected int b(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // android.support.v4.util.MapCollections
        protected int c() {
            return ArraySet.this.i;
        }

        @Override // android.support.v4.util.MapCollections
        protected int a(Object obj) {
            return ArraySet.this.indexOf(obj);
        }

        @Override // android.support.v4.util.MapCollections
        protected Map<E, E> b() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // android.support.v4.util.MapCollections
        protected void a(E e2, E e3) {
            ArraySet.this.add(e2);
        }

        @Override // android.support.v4.util.MapCollections
        protected E a(int i, E e2) {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // android.support.v4.util.MapCollections
        protected void a(int i) {
            ArraySet.this.removeAt(i);
        }

        @Override // android.support.v4.util.MapCollections
        protected void a() {
            ArraySet.this.clear();
        }
    }

    public ArraySet() {
        this(0);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i;
        int a2;
        if (e2 == null) {
            a2 = b();
            i = 0;
        } else {
            int hashCode = e2.hashCode();
            i = hashCode;
            a2 = a(e2, hashCode);
        }
        if (a2 >= 0) {
            return false;
        }
        int i2 = a2 ^ (-1);
        int i3 = this.i;
        if (i3 >= this.f1703g.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f1703g;
            Object[] objArr = this.f1704h;
            a(i4);
            int[] iArr2 = this.f1703g;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1704h, 0, objArr.length);
            }
            a(iArr, objArr, this.i);
        }
        int i5 = this.i;
        if (i2 < i5) {
            int[] iArr3 = this.f1703g;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f1704h;
            System.arraycopy(objArr2, i2, objArr2, i6, this.i - i2);
        }
        this.f1703g[i2] = i;
        this.f1704h[i2] = e2;
        this.i++;
        return true;
    }

    public void addAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.i;
        ensureCapacity(this.i + i);
        if (this.i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                add(arraySet.valueAt(i2));
            }
        } else if (i > 0) {
            System.arraycopy(arraySet.f1703g, 0, this.f1703g, 0, i);
            System.arraycopy(arraySet.f1704h, 0, this.f1704h, 0, i);
            this.i = i;
        }
    }

    public void append(E e2) {
        int i = this.i;
        int hashCode = e2 == null ? 0 : e2.hashCode();
        int[] iArr = this.f1703g;
        if (i < iArr.length) {
            if (i > 0 && iArr[i - 1] > hashCode) {
                add(e2);
                return;
            }
            this.i = i + 1;
            this.f1703g[i] = hashCode;
            this.f1704h[i] = e2;
            return;
        }
        throw new IllegalStateException("Array is full");
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.i;
        if (i != 0) {
            a(this.f1703g, this.f1704h, i);
            this.f1703g = f1697a;
            this.f1704h = f1698b;
            this.i = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void ensureCapacity(int i) {
        int[] iArr = this.f1703g;
        if (iArr.length < i) {
            Object[] objArr = this.f1704h;
            a(i);
            int i2 = this.i;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f1703g, 0, i2);
                System.arraycopy(objArr, 0, this.f1704h, 0, this.i);
            }
            a(iArr, objArr, this.i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.i; i++) {
                try {
                    if (!set.contains(valueAt(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1703g;
        int i = this.i;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? b() : a(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.i <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return a().getKeySet().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public boolean removeAll(ArraySet<? extends E> arraySet) {
        int i = arraySet.i;
        int i2 = this.i;
        for (int i3 = 0; i3 < i; i3++) {
            remove(arraySet.valueAt(i3));
        }
        return i2 != this.i;
    }

    public E removeAt(int i) {
        Object[] objArr = this.f1704h;
        E e2 = (E) objArr[i];
        int i2 = this.i;
        if (i2 <= 1) {
            a(this.f1703g, objArr, i2);
            this.f1703g = f1697a;
            this.f1704h = f1698b;
            this.i = 0;
        } else {
            int[] iArr = this.f1703g;
            if (iArr.length > 8 && i2 < iArr.length / 3) {
                int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr2 = this.f1703g;
                Object[] objArr2 = this.f1704h;
                a(i3);
                this.i--;
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f1703g, 0, i);
                    System.arraycopy(objArr2, 0, this.f1704h, 0, i);
                }
                int i4 = this.i;
                if (i < i4) {
                    int i5 = i + 1;
                    System.arraycopy(iArr2, i5, this.f1703g, i, i4 - i);
                    System.arraycopy(objArr2, i5, this.f1704h, i, this.i - i);
                }
            } else {
                this.i--;
                int i6 = this.i;
                if (i < i6) {
                    int[] iArr3 = this.f1703g;
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, iArr3, i, i6 - i);
                    Object[] objArr3 = this.f1704h;
                    System.arraycopy(objArr3, i7, objArr3, i, this.i - i);
                }
                this.f1704h[this.i] = null;
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.i - 1; i >= 0; i--) {
            if (!collection.contains(this.f1704h[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.i;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.i;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f1704h, 0, objArr, 0, i);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 14);
        sb.append('{');
        for (int i = 0; i < this.i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        return (E) this.f1704h[i];
    }

    public ArraySet(int i) {
        if (i == 0) {
            this.f1703g = f1697a;
            this.f1704h = f1698b;
        } else {
            a(i);
        }
        this.i = 0;
    }

    private int a(Object obj, int i) {
        int i2 = this.i;
        if (i2 == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.f1703g, i2, i);
        if (a2 < 0 || obj.equals(this.f1704h[a2])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1703g[i3] == i) {
            if (obj.equals(this.f1704h[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f1703g[i4] == i; i4--) {
            if (obj.equals(this.f1704h[i4])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    private int b() {
        int i = this.i;
        if (i == 0) {
            return -1;
        }
        int a2 = ContainerHelpers.a(this.f1703g, i, 0);
        if (a2 < 0 || this.f1704h[a2] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f1703g[i2] == 0) {
            if (this.f1704h[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a2 - 1; i3 >= 0 && this.f1703g[i3] == 0; i3--) {
            if (this.f1704h[i3] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.i) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.i));
        }
        System.arraycopy(this.f1704h, 0, tArr, 0, this.i);
        int length = tArr.length;
        int i = this.i;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(ArraySet<E> arraySet) {
        this();
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        ensureCapacity(this.i + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }

    private void a(int i) {
        if (i == 8) {
            synchronized (ArraySet.class) {
                if (f1701e != null) {
                    Object[] objArr = f1701e;
                    this.f1704h = objArr;
                    f1701e = (Object[]) objArr[0];
                    this.f1703g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1702f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArraySet.class) {
                if (f1699c != null) {
                    Object[] objArr2 = f1699c;
                    this.f1704h = objArr2;
                    f1699c = (Object[]) objArr2[0];
                    this.f1703g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1700d--;
                    return;
                }
            }
        }
        this.f1703g = new int[i];
        this.f1704h = new Object[i];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArraySet.class) {
                if (f1702f < 10) {
                    objArr[0] = f1701e;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f1701e = objArr;
                    f1702f++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (ArraySet.class) {
                if (f1700d < 10) {
                    objArr[0] = f1699c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1699c = objArr;
                    f1700d++;
                }
            }
        }
    }

    private MapCollections<E, E> a() {
        if (this.j == null) {
            this.j = new MapCollections<E, E>() { // from class: android.support.v4.util.ArraySet.1
                AnonymousClass1() {
                }

                @Override // android.support.v4.util.MapCollections
                protected Object a(int i, int i2) {
                    return ArraySet.this.f1704h[i];
                }

                @Override // android.support.v4.util.MapCollections
                protected int b(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected int c() {
                    return ArraySet.this.i;
                }

                @Override // android.support.v4.util.MapCollections
                protected int a(Object obj) {
                    return ArraySet.this.indexOf(obj);
                }

                @Override // android.support.v4.util.MapCollections
                protected Map<E, E> b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.util.MapCollections
                protected void a(E e2, E e3) {
                    ArraySet.this.add(e2);
                }

                @Override // android.support.v4.util.MapCollections
                protected E a(int i, E e2) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.util.MapCollections
                protected void a(int i) {
                    ArraySet.this.removeAt(i);
                }

                @Override // android.support.v4.util.MapCollections
                protected void a() {
                    ArraySet.this.clear();
                }
            };
        }
        return this.j;
    }
}
