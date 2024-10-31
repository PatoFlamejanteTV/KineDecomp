package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class zzab {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f727a;
    private final List<Command> b;
    private final long c;
    private final long d;
    private final int e;
    private final boolean f;
    private final String g;

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z) {
        this(zzcVar, map, j, z, 0L, 0, null);
    }

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z, long j2, int i) {
        this(zzcVar, map, j, z, j2, i, null);
    }

    public zzab(zzc zzcVar, Map<String, String> map, long j, boolean z, long j2, int i, List<Command> list) {
        String a2;
        String a3;
        com.google.android.gms.common.internal.zzx.a(zzcVar);
        com.google.android.gms.common.internal.zzx.a(map);
        this.d = j;
        this.f = z;
        this.c = j2;
        this.e = i;
        this.b = list != null ? list : Collections.EMPTY_LIST;
        this.g = a(list);
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (a(entry.getKey()) && (a3 = a(zzcVar, entry.getKey())) != null) {
                hashMap.put(a3, b(zzcVar, entry.getValue()));
            }
        }
        for (Map.Entry<String, String> entry2 : map.entrySet()) {
            if (!a(entry2.getKey()) && (a2 = a(zzcVar, entry2.getKey())) != null) {
                hashMap.put(a2, b(zzcVar, entry2.getValue()));
            }
        }
        if (!TextUtils.isEmpty(this.g)) {
            zzam.a(hashMap, "_v", this.g);
            if (this.g.equals("ma4.0.0") || this.g.equals("ma4.0.1")) {
                hashMap.remove("adid");
            }
        }
        this.f727a = Collections.unmodifiableMap(hashMap);
    }

    public static zzab a(zzc zzcVar, zzab zzabVar, Map<String, String> map) {
        return new zzab(zzcVar, map, zzabVar.d(), zzabVar.f(), zzabVar.c(), zzabVar.a(), zzabVar.e());
    }

    private static String a(zzc zzcVar, Object obj) {
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
            zzcVar.c("Hit param name is too long and will be trimmed", Integer.valueOf(length), obj2);
        }
        if (TextUtils.isEmpty(obj2)) {
            return null;
        }
        return obj2;
    }

    private String a(String str, String str2) {
        com.google.android.gms.common.internal.zzx.a(str);
        com.google.android.gms.common.internal.zzx.b(!str.startsWith("&"), "Short param name required");
        String str3 = this.f727a.get(str);
        return str3 != null ? str3 : str2;
    }

    private static String a(List<Command> list) {
        String str;
        if (list != null) {
            for (Command command : list) {
                if ("appendVersion".equals(command.a())) {
                    str = command.b();
                    break;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    private static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.toString().startsWith("&");
    }

    private static String b(zzc zzcVar, Object obj) {
        String obj2 = obj == null ? "" : obj.toString();
        int length = obj2.length();
        if (length <= 8192) {
            return obj2;
        }
        String substring = obj2.substring(0, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        zzcVar.c("Hit param value is too long and will be trimmed", Integer.valueOf(length), substring);
        return substring;
    }

    public int a() {
        return this.e;
    }

    public Map<String, String> b() {
        return this.f727a;
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public List<Command> e() {
        return this.b;
    }

    public boolean f() {
        return this.f;
    }

    public long g() {
        return zzam.a(a("_s", AppEventsConstants.EVENT_PARAM_VALUE_NO));
    }

    public String h() {
        return a("_m", "");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ht=").append(this.d);
        if (this.c != 0) {
            stringBuffer.append(", dbId=").append(this.c);
        }
        if (this.e != 0) {
            stringBuffer.append(", appUID=").append(this.e);
        }
        ArrayList<String> arrayList = new ArrayList(this.f727a.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            stringBuffer.append(", ");
            stringBuffer.append(str);
            stringBuffer.append("=");
            stringBuffer.append(this.f727a.get(str));
        }
        return stringBuffer.toString();
    }
}
