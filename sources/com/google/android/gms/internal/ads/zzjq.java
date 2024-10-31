package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzjq {
    public static byte[] zza(UUID uuid, byte[] bArr) {
        int length = bArr.length + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(Ek.U);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        return allocate.array();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.UUID zze(byte[] r9) {
        /*
            com.google.android.gms.internal.ads.zzpx r0 = new com.google.android.gms.internal.ads.zzpx
            r0.<init>(r9)
            int r9 = r0.limit()
            r1 = 0
            r2 = 32
            if (r9 >= r2) goto L10
        Le:
            r9 = r1
            goto L7a
        L10:
            r9 = 0
            r0.setPosition(r9)
            int r2 = r0.readInt()
            int r3 = r0.zzhb()
            int r3 = r3 + 4
            if (r2 == r3) goto L21
            goto Le
        L21:
            int r2 = r0.readInt()
            int r3 = com.google.android.gms.internal.ads.Ek.U
            if (r2 == r3) goto L2a
            goto Le
        L2a:
            int r2 = r0.readInt()
            int r2 = com.google.android.gms.internal.ads.Ek.a(r2)
            r3 = 1
            if (r2 <= r3) goto L4e
            r9 = 37
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            java.lang.String r9 = "Unsupported pssh version: "
            r0.append(r9)
            r0.append(r2)
            java.lang.String r9 = r0.toString()
            java.lang.String r0 = "PsshAtomUtil"
            android.util.Log.w(r0, r9)
            goto Le
        L4e:
            java.util.UUID r4 = new java.util.UUID
            long r5 = r0.readLong()
            long r7 = r0.readLong()
            r4.<init>(r5, r7)
            if (r2 != r3) goto L66
            int r2 = r0.zzhg()
            int r2 = r2 << 4
            r0.zzbl(r2)
        L66:
            int r2 = r0.zzhg()
            int r3 = r0.zzhb()
            if (r2 == r3) goto L71
            goto Le
        L71:
            byte[] r3 = new byte[r2]
            r0.zze(r3, r9, r2)
            android.util.Pair r9 = android.util.Pair.create(r4, r3)
        L7a:
            if (r9 != 0) goto L7d
            return r1
        L7d:
            java.lang.Object r9 = r9.first
            java.util.UUID r9 = (java.util.UUID) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjq.zze(byte[]):java.util.UUID");
    }
}
