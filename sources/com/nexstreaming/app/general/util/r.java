package com.nexstreaming.app.general.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: NonZeroIntSet.java */
/* loaded from: classes.dex */
class r implements Iterator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    int f3237a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ q d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, int i) {
        this.d = qVar;
        this.c = i;
        this.f3237a = this.c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3237a >= 0;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer next() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        if (this.f3237a >= 0) {
            iArr = this.d.f3236a;
            this.b = iArr[this.f3237a];
            iArr2 = this.d.f3236a;
            int length = iArr2.length;
            while (this.f3237a < length) {
                iArr3 = this.d.f3236a;
                if (iArr3[this.f3237a] != 0) {
                    break;
                }
                this.f3237a++;
            }
            if (this.f3237a >= length) {
                this.f3237a = -1;
            }
            return Integer.valueOf(this.b);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.b < 0) {
            throw new IllegalStateException();
        }
        this.d.c(this.b);
        this.b = -1;
    }
}
