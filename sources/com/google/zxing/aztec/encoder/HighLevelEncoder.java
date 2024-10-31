package com.google.zxing.aztec.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class HighLevelEncoder {

    /* renamed from: a */
    static final String[] f18978a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: b */
    static final int[][] f18979b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: c */
    private static final int[][] f18980c;

    /* renamed from: d */
    static final int[][] f18981d;

    /* renamed from: e */
    private final byte[] f18982e;

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        f18980c = iArr;
        iArr[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            f18980c[0][i] = (i - 65) + 2;
        }
        f18980c[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            f18980c[1][i2] = (i2 - 97) + 2;
        }
        f18980c[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            f18980c[2][i3] = (i3 - 48) + 2;
        }
        int[][] iArr2 = f18980c;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            f18980c[3][iArr3[i4]] = i4;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            if (iArr4[i5] > 0) {
                f18980c[4][iArr4[i5]] = i5;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        f18981d = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f18981d;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.f18982e = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.zxing.common.BitArray a() {
        /*
            r8 = this;
            com.google.zxing.aztec.encoder.d r0 = com.google.zxing.aztec.encoder.d.f18988a
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r0
            r0 = 0
        L9:
            byte[] r3 = r8.f18982e
            int r4 = r3.length
            if (r0 >= r4) goto L50
            int r4 = r0 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L16
            r3 = r3[r4]
            goto L17
        L16:
            r3 = 0
        L17:
            byte[] r5 = r8.f18982e
            r5 = r5[r0]
            r6 = 13
            if (r5 == r6) goto L3b
            r6 = 44
            r7 = 32
            if (r5 == r6) goto L37
            r6 = 46
            if (r5 == r6) goto L33
            r6 = 58
            if (r5 == r6) goto L2f
        L2d:
            r3 = 0
            goto L40
        L2f:
            if (r3 != r7) goto L2d
            r3 = 5
            goto L40
        L33:
            if (r3 != r7) goto L2d
            r3 = 3
            goto L40
        L37:
            if (r3 != r7) goto L2d
            r3 = 4
            goto L40
        L3b:
            r5 = 10
            if (r3 != r5) goto L2d
            r3 = 2
        L40:
            if (r3 <= 0) goto L49
            java.util.Collection r0 = a(r2, r0, r3)
            r2 = r0
            r0 = r4
            goto L4d
        L49:
            java.util.Collection r2 = r8.a(r2, r0)
        L4d:
            int r0 = r0 + 1
            goto L9
        L50:
            com.google.zxing.aztec.encoder.b r0 = new com.google.zxing.aztec.encoder.b
            r0.<init>(r8)
            java.lang.Object r0 = java.util.Collections.min(r2, r0)
            com.google.zxing.aztec.encoder.d r0 = (com.google.zxing.aztec.encoder.d) r0
            byte[] r1 = r8.f18982e
            com.google.zxing.common.BitArray r0 = r0.a(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.encoder.HighLevelEncoder.a():com.google.zxing.common.BitArray");
    }

    private Collection<d> a(Iterable<d> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        Iterator<d> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, linkedList);
        }
        return a(linkedList);
    }

    private void a(d dVar, int i, Collection<d> collection) {
        char c2 = (char) (this.f18982e[i] & 255);
        boolean z = f18980c[dVar.c()][c2] > 0;
        d dVar2 = null;
        for (int i2 = 0; i2 <= 4; i2++) {
            int i3 = f18980c[i2][c2];
            if (i3 > 0) {
                if (dVar2 == null) {
                    dVar2 = dVar.b(i);
                }
                if (!z || i2 == dVar.c() || i2 == 2) {
                    collection.add(dVar2.a(i2, i3));
                }
                if (!z && f18981d[dVar.c()][i2] >= 0) {
                    collection.add(dVar2.b(i2, i3));
                }
            }
        }
        if (dVar.a() > 0 || f18980c[dVar.c()][c2] == 0) {
            collection.add(dVar.a(i));
        }
    }

    private static Collection<d> a(Iterable<d> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<d> it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next(), i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(d dVar, int i, int i2, Collection<d> collection) {
        d b2 = dVar.b(i);
        collection.add(b2.a(4, i2));
        if (dVar.c() != 4) {
            collection.add(b2.b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b2.a(2, 16 - i2).a(2, 1));
        }
        if (dVar.a() > 0) {
            collection.add(dVar.a(i).a(i + 1));
        }
    }

    private static Collection<d> a(Iterable<d> iterable) {
        LinkedList linkedList = new LinkedList();
        for (d dVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                d dVar2 = (d) it.next();
                if (dVar2.a(dVar)) {
                    z = false;
                    break;
                }
                if (dVar.a(dVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(dVar);
            }
        }
        return linkedList;
    }
}
