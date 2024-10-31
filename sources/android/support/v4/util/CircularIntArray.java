package android.support.v4.util;

/* loaded from: classes.dex */
public final class CircularIntArray {

    /* renamed from: a */
    private int[] f1712a;

    /* renamed from: b */
    private int f1713b;

    /* renamed from: c */
    private int f1714c;

    /* renamed from: d */
    private int f1715d;

    public CircularIntArray() {
        this(8);
    }

    private void a() {
        int[] iArr = this.f1712a;
        int length = iArr.length;
        int i = this.f1713b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            int[] iArr2 = new int[i3];
            System.arraycopy(iArr, i, iArr2, 0, i2);
            System.arraycopy(this.f1712a, 0, iArr2, i2, this.f1713b);
            this.f1712a = iArr2;
            this.f1713b = 0;
            this.f1714c = length;
            this.f1715d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(int i) {
        this.f1713b = (this.f1713b - 1) & this.f1715d;
        int[] iArr = this.f1712a;
        int i2 = this.f1713b;
        iArr[i2] = i;
        if (i2 == this.f1714c) {
            a();
        }
    }

    public void addLast(int i) {
        int[] iArr = this.f1712a;
        int i2 = this.f1714c;
        iArr[i2] = i;
        this.f1714c = this.f1715d & (i2 + 1);
        if (this.f1714c == this.f1713b) {
            a();
        }
    }

    public void clear() {
        this.f1714c = this.f1713b;
    }

    public int get(int i) {
        if (i >= 0 && i < size()) {
            return this.f1712a[this.f1715d & (this.f1713b + i)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getFirst() {
        int i = this.f1713b;
        if (i != this.f1714c) {
            return this.f1712a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i = this.f1713b;
        int i2 = this.f1714c;
        if (i != i2) {
            return this.f1712a[(i2 - 1) & this.f1715d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1713b == this.f1714c;
    }

    public int popFirst() {
        int i = this.f1713b;
        if (i != this.f1714c) {
            int i2 = this.f1712a[i];
            this.f1713b = (i + 1) & this.f1715d;
            return i2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int popLast() {
        int i = this.f1713b;
        int i2 = this.f1714c;
        if (i != i2) {
            int i3 = this.f1715d & (i2 - 1);
            int i4 = this.f1712a[i3];
            this.f1714c = i3;
            return i4;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            this.f1714c = this.f1715d & (this.f1714c - i);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            this.f1713b = this.f1715d & (this.f1713b + i);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.f1714c - this.f1713b) & this.f1715d;
    }

    public CircularIntArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1715d = i - 1;
            this.f1712a = new int[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
