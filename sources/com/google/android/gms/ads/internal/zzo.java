package com.google.android.gms.ads.internal;

import android.location.Location;
import android.os.Bundle;
import com.facebook.applinks.AppLinkData;
import com.facebook.places.model.PlaceFields;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzo {
    public static Object[] a(String str, zzwb zzwbVar, String str2, int i, zzwf zzwfVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        if (hashSet.contains("formatString")) {
            arrayList.add(null);
        }
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzwbVar.zzcjb));
        }
        if (hashSet.contains(AppLinkData.ARGUMENTS_EXTRAS_KEY)) {
            arrayList.add(a(zzwbVar.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzwbVar.zzcjc));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzwbVar.zzcjd;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzwbVar.zzcje));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzwbVar.zzcjf));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzwbVar.zzcjg));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzwbVar.zzcjh);
        }
        if (hashSet.contains(PlaceFields.LOCATION)) {
            Location location = zzwbVar.zzcjj;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzwbVar.zzcjk);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(a(zzwbVar.zzcjl));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(a(zzwbVar.zzcjm));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzwbVar.zzcjn;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzwbVar.zzcjo);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzwbVar.zzcjp);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzwbVar.zzcjq));
        }
        return arrayList.toArray();
    }

    private static String a(Bundle bundle) {
        String obj;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj2 = bundle.get((String) it.next());
            if (obj2 == null) {
                obj = "null";
            } else if (obj2 instanceof Bundle) {
                obj = a((Bundle) obj2);
            } else {
                obj = obj2.toString();
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}
