package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* loaded from: classes2.dex */
public final class zzgh {
    private static final zzgh zzabe = new zzgh(new int[]{2}, 2);
    private final int[] zzabf;
    private final int zzabg;

    private zzgh(int[] iArr, int i) {
        this.zzabf = Arrays.copyOf(iArr, iArr.length);
        Arrays.sort(this.zzabf);
        this.zzabg = 2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgh)) {
            return false;
        }
        zzgh zzghVar = (zzgh) obj;
        return Arrays.equals(this.zzabf, zzghVar.zzabf) && this.zzabg == zzghVar.zzabg;
    }

    public final int hashCode() {
        return this.zzabg + (Arrays.hashCode(this.zzabf) * 31);
    }

    public final String toString() {
        int i = this.zzabg;
        String arrays = Arrays.toString(this.zzabf);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(i);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zzk(int i) {
        return Arrays.binarySearch(this.zzabf, i) >= 0;
    }
}
