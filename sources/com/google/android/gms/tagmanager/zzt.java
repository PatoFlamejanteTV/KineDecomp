package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
class zzt extends i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2244a = zzad.FUNCTION_CALL.toString();
    private static final String b = zzae.FUNCTION_CALL_NAME.toString();
    private static final String c = zzae.ADDITIONAL_PARAMS.toString();
    private final zza d;

    /* loaded from: classes.dex */
    public interface zza {
        Object a(String str, Map<String, Object> map);
    }

    @Override // com.google.android.gms.tagmanager.i
    public zzag.zza a(Map<String, zzag.zza> map) {
        String a2 = zzdf.a(map.get(b));
        HashMap hashMap = new HashMap();
        zzag.zza zzaVar = map.get(c);
        if (zzaVar != null) {
            Object c2 = zzdf.c(zzaVar);
            if (!(c2 instanceof Map)) {
                zzbg.b("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.b();
            }
            for (Map.Entry entry : ((Map) c2).entrySet()) {
                hashMap.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzdf.c(this.d.a(a2, hashMap));
        } catch (Exception e) {
            zzbg.b("Custom macro/tag " + a2 + " threw exception " + e.getMessage());
            return zzdf.b();
        }
    }

    @Override // com.google.android.gms.tagmanager.i
    public boolean a() {
        return false;
    }
}
