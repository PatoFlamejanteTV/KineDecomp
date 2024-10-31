package kotlin.c;

import java.util.Iterator;

/* compiled from: Progressions.kt */
/* loaded from: classes3.dex */
public class b implements Iterable<Integer>, kotlin.jvm.internal.a.a {

    /* renamed from: a */
    public static final a f28499a = new a(null);

    /* renamed from: b */
    private final int f28500b;

    /* renamed from: c */
    private final int f28501c;

    /* renamed from: d */
    private final int f28502d;

    /* compiled from: Progressions.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final b a(int i, int i2, int i3) {
            return new b(i, i2, i3);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public b(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f28500b = i;
            this.f28501c = kotlin.b.c.a(i, i2, i3);
            this.f28502d = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int a() {
        return this.f28502d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (!isEmpty() || !((b) obj).isEmpty()) {
                b bVar = (b) obj;
                if (this.f28500b != bVar.f28500b || this.f28501c != bVar.f28501c || this.f28502d != bVar.f28502d) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f28500b;
    }

    public final int getLast() {
        return this.f28501c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f28500b * 31) + this.f28501c) * 31) + this.f28502d;
    }

    public boolean isEmpty() {
        if (this.f28502d > 0) {
            if (this.f28500b > this.f28501c) {
                return true;
            }
        } else if (this.f28500b < this.f28501c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f28502d > 0) {
            sb = new StringBuilder();
            sb.append(this.f28500b);
            sb.append("..");
            sb.append(this.f28501c);
            sb.append(" step ");
            i = this.f28502d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f28500b);
            sb.append(" downTo ");
            sb.append(this.f28501c);
            sb.append(" step ");
            i = -this.f28502d;
        }
        sb.append(i);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new c(this.f28500b, this.f28501c, this.f28502d);
    }
}
