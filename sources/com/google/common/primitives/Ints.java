package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Ints {
    private Ints() {
    }

    public static int a(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return NexEditorDeviceProfile.UNKNOWN;
        }
        return (int) j;
    }

    public static int a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int a(int... iArr) {
        Preconditions.a(iArr.length > 0);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    @GwtIncompatible
    public static int a(byte b, byte b2, byte b3, byte b4) {
        return (b << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255);
    }
}
