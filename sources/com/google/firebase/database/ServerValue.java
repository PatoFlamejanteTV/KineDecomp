package com.google.firebase.database;

import com.google.firebase.annotations.PublicApi;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class ServerValue {

    /* renamed from: a */
    @PublicApi
    public static final Map<String, String> f16646a = a("timestamp");

    private static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(".sv", str);
        return Collections.unmodifiableMap(hashMap);
    }
}
