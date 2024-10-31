package com.google.android.gms.internal.config;

import android.os.Bundle;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class zzo implements zzg {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Pattern zzm = Pattern.compile("^(1|true|t|yes|y|on)$", 2);
    private static final Pattern zzn = Pattern.compile("^(0|false|f|no|n|off|)$", 2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<byte[]> zzb(zzad zzadVar) {
        DataHolder zzk;
        if (zzadVar == null || (zzk = zzadVar.zzk()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = new DataBufferSafeParcelable(zzk, zzx.CREATOR).iterator();
        while (it.hasNext()) {
            arrayList.add(((zzx) it.next()).getPayload());
        }
        zzadVar.zzm();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Status zzd(int i) {
        String str;
        if (i == -6508) {
            str = "SUCCESS_CACHE_STALE";
        } else if (i == 6507) {
            str = "FETCH_THROTTLED_STALE";
        } else if (i == -6506) {
            str = "SUCCESS_CACHE";
        } else if (i != -6505) {
            switch (i) {
                case 6500:
                    str = "NOT_AUTHORIZED_TO_FETCH";
                    break;
                case 6501:
                    str = "ANOTHER_FETCH_INFLIGHT";
                    break;
                case 6502:
                    str = "FETCH_THROTTLED";
                    break;
                case 6503:
                    str = "NOT_AVAILABLE";
                    break;
                case 6504:
                    str = "FAILURE_CACHE";
                    break;
                default:
                    str = CommonStatusCodes.a(i);
                    break;
            }
        } else {
            str = "SUCCESS_FRESH";
        }
        return new Status(i, str);
    }

    @Override // com.google.android.gms.internal.config.zzg
    public final PendingResult<zzk> zza(GoogleApiClient googleApiClient, zzi zziVar) {
        if (googleApiClient == null || zziVar == null) {
            return null;
        }
        return googleApiClient.a((GoogleApiClient) new e(this, googleApiClient, zziVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static HashMap<String, TreeMap<String, byte[]>> zza(zzad zzadVar) {
        DataHolder zzj;
        if (zzadVar == null || (zzj = zzadVar.zzj()) == null) {
            return null;
        }
        zzaj zzajVar = (zzaj) new DataBufferSafeParcelable(zzj, zzaj.CREATOR).get(0);
        zzadVar.zzl();
        HashMap<String, TreeMap<String, byte[]>> hashMap = new HashMap<>();
        for (String str : zzajVar.zzn().keySet()) {
            TreeMap<String, byte[]> treeMap = new TreeMap<>();
            hashMap.put(str, treeMap);
            Bundle bundle = zzajVar.zzn().getBundle(str);
            for (String str2 : bundle.keySet()) {
                treeMap.put(str2, bundle.getByteArray(str2));
            }
        }
        return hashMap;
    }
}
