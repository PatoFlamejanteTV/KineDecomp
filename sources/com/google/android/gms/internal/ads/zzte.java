package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzark
/* loaded from: classes2.dex */
public final class zzte {
    private final int zzbyz;
    private final zztd zzbzb = new zzti();
    private final int zzbyy = 6;
    private final int zzbza = 0;

    public zzte(int i) {
        this.zzbyz = i;
    }

    @VisibleForTesting
    private final String zzaz(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        Jm jm = new Jm();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbyz, new Im(this));
        for (String str2 : split) {
            String[] zze = zzth.zze(str2, false);
            if (zze.length != 0) {
                zztk.zza(zze, this.zzbyz, this.zzbyy, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                jm.a(this.zzbzb.zzay(((zztl) it.next()).zzbzf));
            } catch (IOException e2) {
                zzbbd.zzb("Error while writing hash to byteStream", e2);
            }
        }
        return jm.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append('\n');
        }
        return zzaz(sb.toString());
    }
}
