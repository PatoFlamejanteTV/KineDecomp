package io.reactivex.internal.util;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes3.dex */
public class a<T> {

    /* renamed from: a */
    final int f28477a;

    /* renamed from: b */
    final Object[] f28478b;

    /* renamed from: c */
    Object[] f28479c;

    /* renamed from: d */
    int f28480d;

    public a(int i) {
        this.f28477a = i;
        this.f28478b = new Object[i + 1];
        this.f28479c = this.f28478b;
    }

    public void a(T t) {
        int i = this.f28477a;
        int i2 = this.f28480d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f28479c[i] = objArr;
            this.f28479c = objArr;
            i2 = 0;
        }
        this.f28479c[i2] = t;
        this.f28480d = i2 + 1;
    }

    public void b(T t) {
        this.f28478b[0] = t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:            continue;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <U> boolean a(io.reactivex.q<? super U> r5) {
        /*
            r4 = this;
            java.lang.Object[] r0 = r4.f28478b
            int r1 = r4.f28477a
        L4:
            r2 = 0
            if (r0 == 0) goto L1e
        L7:
            if (r2 >= r1) goto L19
            r3 = r0[r2]
            if (r3 != 0) goto Le
            goto L19
        Le:
            boolean r3 = io.reactivex.internal.util.NotificationLite.acceptFull(r3, r5)
            if (r3 == 0) goto L16
            r5 = 1
            return r5
        L16:
            int r2 = r2 + 1
            goto L7
        L19:
            r0 = r0[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            goto L4
        L1e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.util.a.a(io.reactivex.q):boolean");
    }
}
