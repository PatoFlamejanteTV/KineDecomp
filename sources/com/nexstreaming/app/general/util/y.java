package com.nexstreaming.app.general.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: NonZeroIntSet.java */
/* loaded from: classes2.dex */
class y implements Iterator<Integer> {

    /* renamed from: a */
    int f19905a;

    /* renamed from: b */
    int f19906b = -1;

    /* renamed from: c */
    final /* synthetic */ int f19907c;

    /* renamed from: d */
    final /* synthetic */ z f19908d;

    public y(z zVar, int i) {
        this.f19908d = zVar;
        this.f19907c = i;
        this.f19905a = this.f19907c;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f19905a >= 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.f19906b;
        if (i >= 0) {
            this.f19908d.c(i);
            this.f19906b = -1;
            return;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public Integer next() {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        if (this.f19905a >= 0) {
            iArr = this.f19908d.f19909a;
            this.f19906b = iArr[this.f19905a];
            iArr2 = this.f19908d.f19909a;
            int length = iArr2.length;
            while (this.f19905a < length) {
                iArr3 = this.f19908d.f19909a;
                int i = this.f19905a;
                if (iArr3[i] != 0) {
                    break;
                }
                this.f19905a = i + 1;
            }
            if (this.f19905a >= length) {
                this.f19905a = -1;
            }
            return Integer.valueOf(this.f19906b);
        }
        throw new NoSuchElementException();
    }
}
