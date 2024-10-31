package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzth {
    public static int zzba(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return MurmurHash3.a(bytes, 0, bytes.length, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:            if (((r6 >= 65382 && r6 <= 65437) || (r6 >= 65441 && r6 <= 65500)) != false) goto L139;     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c4, code lost:            if (r4 == false) goto L163;     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d7, code lost:            r4 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d6, code lost:            r5 = r3;     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:            if (r4 == false) goto L163;     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] zze(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzth.zze(java.lang.String, boolean):java.lang.String[]");
    }
}
