package com.google.android.gms.internal;

import java.util.Map;

/* loaded from: classes.dex */
public class zzmi<K, V> {
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    public zzmi() {
        this.mHashes = zzmf.EMPTY_INTS;
        this.mArray = zzmf.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public zzmi(int i) {
        if (i == 0) {
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
        } else {
            zzbO(i);
        }
        this.mSize = 0;
    }

    private static void zza(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (zzme.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (zzme.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize++;
                }
            }
        }
    }

    private void zzbO(int i) {
        if (i == 8) {
            synchronized (zzme.class) {
                if (mTwiceBaseCache != null) {
                    Object[] objArr = mTwiceBaseCache;
                    this.mArray = objArr;
                    mTwiceBaseCache = (Object[]) objArr[0];
                    this.mHashes = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (zzme.class) {
                if (mBaseCache != null) {
                    Object[] objArr2 = mBaseCache;
                    this.mArray = objArr2;
                    mBaseCache = (Object[]) objArr2[0];
                    this.mHashes = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[i << 1];
    }

    public void clear() {
        if (this.mSize != 0) {
            zza(this.mHashes, this.mArray, this.mSize);
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
            this.mSize = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? indexOfNull() >= 0 : indexOf(obj, obj.hashCode()) >= 0;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= 0;
    }

    public void ensureCapacity(int i) {
        if (this.mHashes.length < i) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(i);
            if (this.mSize > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, this.mSize);
                System.arraycopy(objArr, 0, this.mArray, 0, this.mSize << 1);
            }
            zza(iArr, objArr, this.mSize);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i = 0; i < this.mSize; i++) {
            try {
                K keyAt = keyAt(i);
                V valueAt = valueAt(i);
                Object obj2 = map.get(keyAt);
                if (valueAt == null) {
                    if (obj2 != null || !map.containsKey(keyAt)) {
                        return false;
                    }
                } else if (!valueAt.equals(obj2)) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            } catch (NullPointerException e2) {
                return false;
            }
        }
        return true;
    }

    public V get(Object obj) {
        int indexOfNull = obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
        if (indexOfNull >= 0) {
            return (V) this.mArray[(indexOfNull << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearch = zzmf.binarySearch(this.mHashes, i2, i);
        if (binarySearch < 0 || obj.equals(this.mArray[binarySearch << 1])) {
            return binarySearch;
        }
        int i3 = binarySearch + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = binarySearch - 1; i4 >= 0 && this.mHashes[i4] == i; i4--) {
            if (obj.equals(this.mArray[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearch = zzmf.binarySearch(this.mHashes, i, 0);
        if (binarySearch < 0 || this.mArray[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i2 = binarySearch + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = binarySearch - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
            if (this.mArray[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int indexOfValue(Object obj) {
        int i = 1;
        int i2 = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public K keyAt(int i) {
        return (K) this.mArray[i << 1];
    }

    public V put(K k, V v) {
        int hashCode;
        int indexOf;
        int i = 8;
        if (k == null) {
            indexOf = indexOfNull();
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
            indexOf = indexOf(k, hashCode);
        }
        if (indexOf >= 0) {
            int i2 = (indexOf << 1) + 1;
            V v2 = (V) this.mArray[i2];
            this.mArray[i2] = v;
            return v2;
        }
        int i3 = indexOf ^ (-1);
        if (this.mSize >= this.mHashes.length) {
            if (this.mSize >= 8) {
                i = this.mSize + (this.mSize >> 1);
            } else if (this.mSize < 4) {
                i = 4;
            }
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(i);
            if (this.mHashes.length > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, iArr.length);
                System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
            }
            zza(iArr, objArr, this.mSize);
        }
        if (i3 < this.mSize) {
            System.arraycopy(this.mHashes, i3, this.mHashes, i3 + 1, this.mSize - i3);
            System.arraycopy(this.mArray, i3 << 1, this.mArray, (i3 + 1) << 1, (this.mSize - i3) << 1);
        }
        this.mHashes[i3] = hashCode;
        this.mArray[i3 << 1] = k;
        this.mArray[(i3 << 1) + 1] = v;
        this.mSize++;
        return null;
    }

    public V remove(Object obj) {
        int indexOfNull = obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
        if (indexOfNull >= 0) {
            return removeAt(indexOfNull);
        }
        return null;
    }

    public V removeAt(int i) {
        V v = (V) this.mArray[(i << 1) + 1];
        if (this.mSize <= 1) {
            zza(this.mHashes, this.mArray, this.mSize);
            this.mHashes = zzmf.EMPTY_INTS;
            this.mArray = zzmf.EMPTY_OBJECTS;
            this.mSize = 0;
        } else if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
            this.mSize--;
            if (i < this.mSize) {
                System.arraycopy(this.mHashes, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(this.mArray, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
            }
            this.mArray[this.mSize << 1] = null;
            this.mArray[(this.mSize << 1) + 1] = null;
        } else {
            int i2 = this.mSize > 8 ? this.mSize + (this.mSize >> 1) : 8;
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            zzbO(i2);
            this.mSize--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.mHashes, 0, i);
                System.arraycopy(objArr, 0, this.mArray, 0, i << 1);
            }
            if (i < this.mSize) {
                System.arraycopy(iArr, i + 1, this.mHashes, i, this.mSize - i);
                System.arraycopy(objArr, (i + 1) << 1, this.mArray, i << 1, (this.mSize - i) << 1);
            }
        }
        return v;
    }

    public V setValueAt(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.mArray[i2];
        this.mArray[i2] = v;
        return v2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.mSize * 28);
        sb.append('{');
        for (int i = 0; i < this.mSize; i++) {
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
        return (V) this.mArray[(i << 1) + 1];
    }
}
