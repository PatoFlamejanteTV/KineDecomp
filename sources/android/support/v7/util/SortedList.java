package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* loaded from: classes.dex */
public class SortedList<T> {
    public static final int INVALID_POSITION = -1;

    /* renamed from: a */
    T[] f2345a;

    /* renamed from: b */
    private T[] f2346b;

    /* renamed from: c */
    private int f2347c;

    /* renamed from: d */
    private int f2348d;

    /* renamed from: e */
    private int f2349e;

    /* renamed from: f */
    private Callback f2350f;

    /* renamed from: g */
    private BatchedCallback f2351g;

    /* renamed from: h */
    private int f2352h;
    private final Class<T> i;

    /* loaded from: classes.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {

        /* renamed from: a */
        final Callback<T2> f2353a;

        /* renamed from: b */
        private final BatchingListUpdateCallback f2354b;

        public BatchedCallback(Callback<T2> callback) {
            this.f2353a = callback;
            this.f2354b = new BatchingListUpdateCallback(this.f2353a);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.f2353a.areContentsTheSame(t2, t22);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.f2353a.areItemsTheSame(t2, t22);
        }

        @Override // android.support.v7.util.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            return this.f2353a.compare(t2, t22);
        }

        public void dispatchLastEvent() {
            this.f2354b.dispatchLastEvent();
        }

        @Override // android.support.v7.util.SortedList.Callback
        public Object getChangePayload(T2 t2, T2 t22) {
            return this.f2353a.getChangePayload(t2, t22);
        }

        @Override // android.support.v7.util.SortedList.Callback
        public void onChanged(int i, int i2) {
            this.f2354b.onChanged(i, i2, null);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onInserted(int i, int i2) {
            this.f2354b.onInserted(i, i2);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onMoved(int i, int i2) {
            this.f2354b.onMoved(i, i2);
        }

        @Override // android.support.v7.util.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            this.f2354b.onRemoved(i, i2);
        }

        @Override // android.support.v7.util.SortedList.Callback, android.support.v7.util.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.f2354b.onChanged(i, i2, obj);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        public Object getChangePayload(T2 t2, T2 t22) {
            return null;
        }

        public abstract void onChanged(int i, int i2);

        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void a(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int d2 = d(tArr);
        if (this.f2352h == 0) {
            this.f2345a = tArr;
            this.f2352h = d2;
            this.f2350f.onInserted(0, d2);
            return;
        }
        a(tArr, d2);
    }

    private void b() {
        if (this.f2346b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    private void c(T[] tArr) {
        boolean z = !(this.f2350f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f2347c = 0;
        this.f2348d = this.f2352h;
        this.f2346b = this.f2345a;
        this.f2349e = 0;
        int d2 = d(tArr);
        this.f2345a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, d2));
        while (true) {
            if (this.f2349e >= d2 && this.f2347c >= this.f2348d) {
                break;
            }
            int i = this.f2347c;
            int i2 = this.f2348d;
            if (i >= i2) {
                int i3 = this.f2349e;
                int i4 = d2 - i3;
                System.arraycopy(tArr, i3, this.f2345a, i3, i4);
                this.f2349e += i4;
                this.f2352h += i4;
                this.f2350f.onInserted(i3, i4);
                break;
            }
            int i5 = this.f2349e;
            if (i5 >= d2) {
                int i6 = i2 - i;
                this.f2352h -= i6;
                this.f2350f.onRemoved(i5, i6);
                break;
            }
            T t = this.f2346b[i];
            T t2 = tArr[i5];
            int compare = this.f2350f.compare(t, t2);
            if (compare < 0) {
                a();
            } else if (compare > 0) {
                a((SortedList<T>) t2);
            } else if (!this.f2350f.areItemsTheSame(t, t2)) {
                a();
                a((SortedList<T>) t2);
            } else {
                T[] tArr2 = this.f2345a;
                int i7 = this.f2349e;
                tArr2[i7] = t2;
                this.f2347c++;
                this.f2349e = i7 + 1;
                if (!this.f2350f.areContentsTheSame(t, t2)) {
                    Callback callback = this.f2350f;
                    callback.onChanged(this.f2349e - 1, 1, callback.getChangePayload(t, t2));
                }
            }
        }
        this.f2346b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private int d(T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f2350f);
        int i = 1;
        int i2 = 0;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T t = tArr[i3];
            if (this.f2350f.compare(tArr[i2], t) == 0) {
                int a2 = a((SortedList<T>) t, (SortedList<T>[]) tArr, i2, i);
                if (a2 != -1) {
                    tArr[a2] = t;
                } else {
                    if (i != i3) {
                        tArr[i] = t;
                    }
                    i++;
                }
            } else {
                if (i != i3) {
                    tArr[i] = t;
                }
                i2 = i;
                i++;
            }
        }
        return i;
    }

    public int add(T t) {
        b();
        return a((SortedList<T>) t, true);
    }

    public void addAll(T[] tArr, boolean z) {
        b();
        if (tArr.length == 0) {
            return;
        }
        if (z) {
            a((Object[]) tArr);
        } else {
            a((Object[]) b(tArr));
        }
    }

    public void beginBatchedUpdates() {
        b();
        Callback callback = this.f2350f;
        if (callback instanceof BatchedCallback) {
            return;
        }
        if (this.f2351g == null) {
            this.f2351g = new BatchedCallback(callback);
        }
        this.f2350f = this.f2351g;
    }

    public void clear() {
        b();
        int i = this.f2352h;
        if (i == 0) {
            return;
        }
        Arrays.fill(this.f2345a, 0, i, (Object) null);
        this.f2352h = 0;
        this.f2350f.onRemoved(0, i);
    }

    public void endBatchedUpdates() {
        b();
        Callback callback = this.f2350f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).dispatchLastEvent();
        }
        Callback callback2 = this.f2350f;
        BatchedCallback batchedCallback = this.f2351g;
        if (callback2 == batchedCallback) {
            this.f2350f = batchedCallback.f2353a;
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        int i2;
        if (i < this.f2352h && i >= 0) {
            T[] tArr = this.f2346b;
            if (tArr != null && i >= (i2 = this.f2349e)) {
                return tArr[(i - i2) + this.f2347c];
            }
            return this.f2345a[i];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.f2352h);
    }

    public int indexOf(T t) {
        if (this.f2346b != null) {
            int a2 = a(t, this.f2345a, 0, this.f2349e, 4);
            if (a2 != -1) {
                return a2;
            }
            int a3 = a(t, this.f2346b, this.f2347c, this.f2348d, 4);
            if (a3 != -1) {
                return (a3 - this.f2347c) + this.f2349e;
            }
            return -1;
        }
        return a(t, this.f2345a, 0, this.f2352h, 4);
    }

    public void recalculatePositionOfItemAt(int i) {
        b();
        T t = get(i);
        a(i, false);
        int a2 = a((SortedList<T>) t, false);
        if (i != a2) {
            this.f2350f.onMoved(i, a2);
        }
    }

    public boolean remove(T t) {
        b();
        return b(t, true);
    }

    public T removeItemAt(int i) {
        b();
        T t = get(i);
        a(i, true);
        return t;
    }

    public void replaceAll(T[] tArr, boolean z) {
        b();
        if (z) {
            c(tArr);
        } else {
            c(b(tArr));
        }
    }

    public int size() {
        return this.f2352h;
    }

    public void updateItemAt(int i, T t) {
        b();
        T t2 = get(i);
        boolean z = t2 == t || !this.f2350f.areContentsTheSame(t2, t);
        if (t2 != t && this.f2350f.compare(t2, t) == 0) {
            this.f2345a[i] = t;
            if (z) {
                Callback callback = this.f2350f;
                callback.onChanged(i, 1, callback.getChangePayload(t2, t));
                return;
            }
            return;
        }
        if (z) {
            Callback callback2 = this.f2350f;
            callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
        }
        a(i, false);
        int a2 = a((SortedList<T>) t, false);
        if (i != a2) {
            this.f2350f.onMoved(i, a2);
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.i = cls;
        this.f2345a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.f2350f = callback;
        this.f2352h = 0;
    }

    private boolean b(T t, boolean z) {
        int a2 = a(t, this.f2345a, 0, this.f2352h, 2);
        if (a2 == -1) {
            return false;
        }
        a(a2, z);
        return true;
    }

    public void replaceAll(T... tArr) {
        replaceAll(tArr, false);
    }

    private T[] b(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(Collection<T> collection) {
        replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.i, collection.size())), true);
    }

    private void a(T t) {
        T[] tArr = this.f2345a;
        int i = this.f2349e;
        tArr[i] = t;
        this.f2349e = i + 1;
        this.f2352h++;
        this.f2350f.onInserted(this.f2349e - 1, 1);
    }

    private void a() {
        this.f2352h--;
        this.f2347c++;
        this.f2350f.onRemoved(this.f2349e, 1);
    }

    private int a(T t, T[] tArr, int i, int i2) {
        while (i < i2) {
            if (this.f2350f.areItemsTheSame(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void a(T[] tArr, int i) {
        int i2 = 0;
        boolean z = !(this.f2350f instanceof BatchedCallback);
        if (z) {
            beginBatchedUpdates();
        }
        this.f2346b = this.f2345a;
        this.f2347c = 0;
        int i3 = this.f2352h;
        this.f2348d = i3;
        this.f2345a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, i3 + i + 10));
        this.f2349e = 0;
        while (true) {
            if (this.f2347c >= this.f2348d && i2 >= i) {
                break;
            }
            int i4 = this.f2347c;
            int i5 = this.f2348d;
            if (i4 == i5) {
                int i6 = i - i2;
                System.arraycopy(tArr, i2, this.f2345a, this.f2349e, i6);
                this.f2349e += i6;
                this.f2352h += i6;
                this.f2350f.onInserted(this.f2349e - i6, i6);
                break;
            }
            if (i2 == i) {
                int i7 = i5 - i4;
                System.arraycopy(this.f2346b, i4, this.f2345a, this.f2349e, i7);
                this.f2349e += i7;
                break;
            }
            T t = this.f2346b[i4];
            T t2 = tArr[i2];
            int compare = this.f2350f.compare(t, t2);
            if (compare > 0) {
                T[] tArr2 = this.f2345a;
                int i8 = this.f2349e;
                this.f2349e = i8 + 1;
                tArr2[i8] = t2;
                this.f2352h++;
                i2++;
                this.f2350f.onInserted(this.f2349e - 1, 1);
            } else if (compare == 0 && this.f2350f.areItemsTheSame(t, t2)) {
                T[] tArr3 = this.f2345a;
                int i9 = this.f2349e;
                this.f2349e = i9 + 1;
                tArr3[i9] = t2;
                i2++;
                this.f2347c++;
                if (!this.f2350f.areContentsTheSame(t, t2)) {
                    Callback callback = this.f2350f;
                    callback.onChanged(this.f2349e - 1, 1, callback.getChangePayload(t, t2));
                }
            } else {
                T[] tArr4 = this.f2345a;
                int i10 = this.f2349e;
                this.f2349e = i10 + 1;
                tArr4[i10] = t;
                this.f2347c++;
            }
        }
        this.f2346b = null;
        if (z) {
            endBatchedUpdates();
        }
    }

    private int a(T t, boolean z) {
        int a2 = a(t, this.f2345a, 0, this.f2352h, 1);
        if (a2 == -1) {
            a2 = 0;
        } else if (a2 < this.f2352h) {
            T t2 = this.f2345a[a2];
            if (this.f2350f.areItemsTheSame(t2, t)) {
                if (this.f2350f.areContentsTheSame(t2, t)) {
                    this.f2345a[a2] = t;
                    return a2;
                }
                this.f2345a[a2] = t;
                Callback callback = this.f2350f;
                callback.onChanged(a2, 1, callback.getChangePayload(t2, t));
                return a2;
            }
        }
        a(a2, (int) t);
        if (z) {
            this.f2350f.onInserted(a2, 1);
        }
        return a2;
    }

    private void a(int i, boolean z) {
        T[] tArr = this.f2345a;
        System.arraycopy(tArr, i + 1, tArr, i, (this.f2352h - i) - 1);
        this.f2352h--;
        this.f2345a[this.f2352h] = null;
        if (z) {
            this.f2350f.onRemoved(i, 1);
        }
    }

    private int a(T t, T[] tArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            T t2 = tArr[i4];
            int compare = this.f2350f.compare(t2, t);
            if (compare < 0) {
                i = i4 + 1;
            } else {
                if (compare == 0) {
                    if (this.f2350f.areItemsTheSame(t2, t)) {
                        return i4;
                    }
                    int a2 = a((SortedList<T>) t, i4, i, i2);
                    return (i3 == 1 && a2 == -1) ? i4 : a2;
                }
                i2 = i4;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    private int a(T t, int i, int i2, int i3) {
        T t2;
        for (int i4 = i - 1; i4 >= i2; i4--) {
            T t3 = this.f2345a[i4];
            if (this.f2350f.compare(t3, t) != 0) {
                break;
            }
            if (this.f2350f.areItemsTheSame(t3, t)) {
                return i4;
            }
        }
        do {
            i++;
            if (i >= i3) {
                return -1;
            }
            t2 = this.f2345a[i];
            if (this.f2350f.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.f2350f.areItemsTheSame(t2, t));
        return i;
    }

    private void a(int i, T t) {
        int i2 = this.f2352h;
        if (i <= i2) {
            T[] tArr = this.f2345a;
            if (i2 == tArr.length) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.i, tArr.length + 10));
                System.arraycopy(this.f2345a, 0, tArr2, 0, i);
                tArr2[i] = t;
                System.arraycopy(this.f2345a, i, tArr2, i + 1, this.f2352h - i);
                this.f2345a = tArr2;
            } else {
                System.arraycopy(tArr, i, tArr, i + 1, i2 - i);
                this.f2345a[i] = t;
            }
            this.f2352h++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.f2352h);
    }
}
