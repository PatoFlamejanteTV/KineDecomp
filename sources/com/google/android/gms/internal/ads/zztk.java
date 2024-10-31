package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zztk {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zztl> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, priorityQueue);
        long zzb2 = zzb(16785407L, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            zzb = ((((((zzb + 1073807359) - ((((zzth.zzba(strArr[i3 - 1]) + 2147483647L) % 1073807359) * zzb2) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((zzth.zzba(strArr[(i3 + i2) - 1]) + 2147483647L) % 1073807359)) % 1073807359;
            zza(i, zzb, zza(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzba = (zzth.zzba(strArr[0]) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzba = (((zzba * 16785407) % 1073807359) + ((zzth.zzba(strArr[i3]) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzba;
    }

    @VisibleForTesting
    private static long zzb(long j, int i) {
        if (i == 0) {
            return 1L;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return zzb((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (zzb((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    @VisibleForTesting
    private static void zza(int i, long j, String str, int i2, PriorityQueue<zztl> priorityQueue) {
        zztl zztlVar = new zztl(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzbzg <= zztlVar.zzbzg && priorityQueue.peek().value <= zztlVar.value)) && !priorityQueue.contains(zztlVar)) {
            priorityQueue.add(zztlVar);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    private static String zza(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzbbd.e("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }
}
