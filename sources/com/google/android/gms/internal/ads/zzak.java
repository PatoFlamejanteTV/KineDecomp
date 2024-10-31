package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzak {
    private static final Comparator<byte[]> zzbv = new C0966kb();
    private final List<byte[]> zzbr = new ArrayList();
    private final List<byte[]> zzbs = new ArrayList(64);
    private int zzbt = 0;
    private final int zzbu = 4096;

    public zzak(int i) {
    }

    private final synchronized void zzo() {
        while (this.zzbt > this.zzbu) {
            byte[] remove = this.zzbr.remove(0);
            this.zzbs.remove(remove);
            this.zzbt -= remove.length;
        }
    }

    public final synchronized void zza(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.zzbu) {
                this.zzbr.add(bArr);
                int binarySearch = Collections.binarySearch(this.zzbs, bArr, zzbv);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.zzbs.add(binarySearch, bArr);
                this.zzbt += bArr.length;
                zzo();
            }
        }
    }

    public final synchronized byte[] zzb(int i) {
        for (int i2 = 0; i2 < this.zzbs.size(); i2++) {
            byte[] bArr = this.zzbs.get(i2);
            if (bArr.length >= i) {
                this.zzbt -= bArr.length;
                this.zzbs.remove(i2);
                this.zzbr.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
