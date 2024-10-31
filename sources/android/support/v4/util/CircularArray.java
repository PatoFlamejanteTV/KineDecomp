package android.support.v4.util;

/* loaded from: classes.dex */
public final class CircularArray<E> {

    /* renamed from: a */
    private E[] f1708a;

    /* renamed from: b */
    private int f1709b;

    /* renamed from: c */
    private int f1710c;

    /* renamed from: d */
    private int f1711d;

    public CircularArray() {
        this(8);
    }

    private void a() {
        E[] eArr = this.f1708a;
        int length = eArr.length;
        int i = this.f1709b;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            E[] eArr2 = (E[]) new Object[i3];
            System.arraycopy(eArr, i, eArr2, 0, i2);
            System.arraycopy(this.f1708a, 0, eArr2, i2, this.f1709b);
            this.f1708a = eArr2;
            this.f1709b = 0;
            this.f1710c = length;
            this.f1711d = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public void addFirst(E e2) {
        this.f1709b = (this.f1709b - 1) & this.f1711d;
        E[] eArr = this.f1708a;
        int i = this.f1709b;
        eArr[i] = e2;
        if (i == this.f1710c) {
            a();
        }
    }

    public void addLast(E e2) {
        E[] eArr = this.f1708a;
        int i = this.f1710c;
        eArr[i] = e2;
        this.f1710c = this.f1711d & (i + 1);
        if (this.f1710c == this.f1709b) {
            a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i) {
        if (i >= 0 && i < size()) {
            return this.f1708a[this.f1711d & (this.f1709b + i)];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getFirst() {
        int i = this.f1709b;
        if (i != this.f1710c) {
            return this.f1708a[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i = this.f1709b;
        int i2 = this.f1710c;
        if (i != i2) {
            return this.f1708a[(i2 - 1) & this.f1711d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1709b == this.f1710c;
    }

    public E popFirst() {
        int i = this.f1709b;
        if (i != this.f1710c) {
            E[] eArr = this.f1708a;
            E e2 = eArr[i];
            eArr[i] = null;
            this.f1709b = (i + 1) & this.f1711d;
            return e2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E popLast() {
        int i = this.f1709b;
        int i2 = this.f1710c;
        if (i != i2) {
            int i3 = this.f1711d & (i2 - 1);
            E[] eArr = this.f1708a;
            E e2 = eArr[i3];
            eArr[i3] = null;
            this.f1710c = i3;
            return e2;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromEnd(int i) {
        int i2;
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            int i3 = this.f1710c;
            int i4 = i < i3 ? i3 - i : 0;
            int i5 = i4;
            while (true) {
                i2 = this.f1710c;
                if (i5 >= i2) {
                    break;
                }
                this.f1708a[i5] = null;
                i5++;
            }
            int i6 = i2 - i4;
            int i7 = i - i6;
            this.f1710c = i2 - i6;
            if (i7 > 0) {
                this.f1710c = this.f1708a.length;
                int i8 = this.f1710c - i7;
                for (int i9 = i8; i9 < this.f1710c; i9++) {
                    this.f1708a[i9] = null;
                }
                this.f1710c = i8;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i <= size()) {
            int length = this.f1708a.length;
            int i2 = this.f1709b;
            if (i < length - i2) {
                length = i2 + i;
            }
            for (int i3 = this.f1709b; i3 < length; i3++) {
                this.f1708a[i3] = null;
            }
            int i4 = this.f1709b;
            int i5 = length - i4;
            int i6 = i - i5;
            this.f1709b = this.f1711d & (i4 + i5);
            if (i6 > 0) {
                for (int i7 = 0; i7 < i6; i7++) {
                    this.f1708a[i7] = null;
                }
                this.f1709b = i6;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        return (this.f1710c - this.f1709b) & this.f1711d;
    }

    public CircularArray(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.f1711d = i - 1;
            this.f1708a = (E[]) new Object[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
