package com.facebook.ads.redexgen.X;

import java.io.File;
import java.util.Comparator;

/* renamed from: com.facebook.ads.redexgen.X.0H, reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C0H implements Comparator<File> {
    public C0H() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x001d, code lost:            return r1;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A00(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L1b
            r0 = 2
        L6:
            switch(r0) {
                case 2: goto La;
                case 3: goto L1d;
                case 4: goto Ld;
                case 5: goto L15;
                case 6: goto L18;
                default: goto L9;
            }
        L9:
            goto L6
        La:
            r1 = -1
            r0 = 3
            goto L6
        Ld:
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L13
            r0 = 5
            goto L6
        L13:
            r0 = 6
            goto L6
        L15:
            r1 = 0
            r0 = 3
            goto L6
        L18:
            r1 = 1
            r0 = 3
            goto L6
        L1b:
            r0 = 4
            goto L6
        L1d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C0H.A00(long, long):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compare(File file, File file2) {
        return A00(file.lastModified(), file2.lastModified());
    }
}
