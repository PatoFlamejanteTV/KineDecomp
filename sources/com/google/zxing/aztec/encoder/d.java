package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: State.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a */
    static final d f18988a = new d(e.f18993a, 0, 0, 0);

    /* renamed from: b */
    private final int f18989b;

    /* renamed from: c */
    private final e f18990c;

    /* renamed from: d */
    private final int f18991d;

    /* renamed from: e */
    private final int f18992e;

    private d(e eVar, int i, int i2, int i3) {
        this.f18990c = eVar;
        this.f18989b = i;
        this.f18991d = i2;
        this.f18992e = i3;
    }

    public int a() {
        return this.f18991d;
    }

    public int b() {
        return this.f18992e;
    }

    public int c() {
        return this.f18989b;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.f18978a[this.f18989b], Integer.valueOf(this.f18992e), Integer.valueOf(this.f18991d));
    }

    public d a(int i, int i2) {
        int i3 = this.f18992e;
        e eVar = this.f18990c;
        int i4 = this.f18989b;
        if (i != i4) {
            int i5 = HighLevelEncoder.f18979b[i4][i];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            eVar = eVar.a(i6, i7);
            i3 += i7;
        }
        int i8 = i == 2 ? 4 : 5;
        return new d(eVar.a(i2, i8), i, 0, i3 + i8);
    }

    public d b(int i, int i2) {
        e eVar = this.f18990c;
        int i3 = this.f18989b == 2 ? 4 : 5;
        return new d(eVar.a(HighLevelEncoder.f18981d[this.f18989b][i], i3).a(i2, 5), this.f18989b, 0, this.f18992e + i3 + 5);
    }

    public d b(int i) {
        int i2 = this.f18991d;
        return i2 == 0 ? this : new d(this.f18990c.b(i - i2, i2), this.f18989b, 0, this.f18992e);
    }

    public d a(int i) {
        e eVar = this.f18990c;
        int i2 = this.f18989b;
        int i3 = this.f18992e;
        if (i2 == 4 || i2 == 2) {
            int i4 = HighLevelEncoder.f18979b[i2][0];
            int i5 = 65535 & i4;
            int i6 = i4 >> 16;
            eVar = eVar.a(i5, i6);
            i3 += i6;
            i2 = 0;
        }
        int i7 = this.f18991d;
        d dVar = new d(eVar, i2, this.f18991d + 1, i3 + ((i7 == 0 || i7 == 31) ? 18 : i7 == 62 ? 9 : 8));
        return dVar.f18991d == 2078 ? dVar.b(i + 1) : dVar;
    }

    public boolean a(d dVar) {
        int i;
        int i2 = this.f18992e + (HighLevelEncoder.f18979b[this.f18989b][dVar.f18989b] >> 16);
        int i3 = dVar.f18991d;
        if (i3 > 0 && ((i = this.f18991d) == 0 || i > i3)) {
            i2 += 10;
        }
        return i2 <= dVar.f18992e;
    }

    public BitArray a(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (e eVar = b(bArr.length).f18990c; eVar != null; eVar = eVar.a()) {
            linkedList.addFirst(eVar);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(bitArray, bArr);
        }
        return bitArray;
    }
}
