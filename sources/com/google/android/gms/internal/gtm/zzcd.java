package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcd {
    private final List<zzbk> zzaaz;
    private final long zzaba;
    private final long zzabb;
    private final int zzabc;
    private final boolean zzabd;
    private final String zzabe;
    private final Map<String, String> zztc;

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z) {
        this(zzamVar, map, j, z, 0L, 0, null);
    }

    private static String zza(zzam zzamVar, Object obj) {
        if (obj == null) {
            return null;
        }
        String obj2 = obj.toString();
        if (obj2.startsWith("&")) {
            obj2 = obj2.substring(1);
        }
        int length = obj2.length();
        if (length > 256) {
            obj2 = obj2.substring(0, 256);
            zzamVar.zzc("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private static String zzb(zzam zzamVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, 8192);
        zzamVar.zzc("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    private static boolean zzc(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private final String zzd(String str, String str2) {
        Preconditions.b(str);
        Preconditions.a(!str.startsWith("&"), "Short param name required");
        String str3 = this.zztc.get(str);
        return str3 != null ? str3 : str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ht=");
        sb.append(this.zzabb);
        if (this.zzaba != 0) {
            sb.append(", dbId=");
            sb.append(this.zzaba);
        }
        if (this.zzabc != 0) {
            sb.append(", appUID=");
            sb.append(this.zzabc);
        }
        ArrayList arrayList = new ArrayList(this.zztc.keySet());
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            String str = (String) obj;
            sb.append(", ");
            sb.append(str);
            sb.append("=");
            sb.append(this.zztc.get(str));
        }
        return sb.toString();
    }

    public final Map<String, String> zzdm() {
        return this.zztc;
    }

    public final int zzff() {
        return this.zzabc;
    }

    public final long zzfg() {
        return this.zzaba;
    }

    public final long zzfh() {
        return this.zzabb;
    }

    public final List<zzbk> zzfi() {
        return this.zzaaz;
    }

    public final boolean zzfj() {
        return this.zzabd;
    }

    public final long zzfk() {
        return zzcz.zzag(zzd("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public final String zzfl() {
        return zzd("_m", "");
    }

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzamVar, map, j, z, j2, i, null);
    }

    public zzcd(zzam zzamVar, Map<String, String> map, long j, boolean z, long j2, int i, List<zzbk> list) {
        String str;
        String zza;
        String zza2;
        Preconditions.a(zzamVar);
        Preconditions.a(map);
        this.zzabb = j;
        this.zzabd = z;
        this.zzaba = j2;
        this.zzabc = i;
        this.zzaaz = list != null ? list : Collections.emptyList();
        if (list != null) {
            for (zzbk zzbkVar : list) {
                if ("appendVersion".equals(zzbkVar.getId())) {
                    str = zzbkVar.getValue();
                    break;
                }
            }
        }
        str = null;
        this.zzabe = TextUtils.isEmpty(str) ? null : str;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (zzc(entry.getKey()) && (zza2 = zza(zzamVar, entry.getKey())) != null) {
                hashMap.put(zza2, zzb(zzamVar, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!zzc(entry2.getKey()) && (zza = zza(zzamVar, entry2.getKey())) != null) {
                hashMap.put(zza, zzb(zzamVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.zzabe)) {
            zzcz.zzb(hashMap, "_v", this.zzabe);
            if (this.zzabe.equals("ma4.0.0") || this.zzabe.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.zztc = Collections.unmodifiableMap(hashMap);
    }
}
