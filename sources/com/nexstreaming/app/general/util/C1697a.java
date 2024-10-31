package com.nexstreaming.app.general.util;

/* compiled from: ArrayUtil.java */
/* renamed from: com.nexstreaming.app.general.util.a */
/* loaded from: classes2.dex */
public class C1697a {
    public static int[] a(int[] iArr, int i) {
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == i) {
                i2++;
            }
        }
        if (i2 < 1) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length - i2];
        int i4 = 0;
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] != i) {
                iArr2[i4] = iArr[i5];
                i4++;
            }
        }
        return iArr2;
    }
}
