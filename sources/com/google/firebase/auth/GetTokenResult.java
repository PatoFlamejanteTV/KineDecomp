package com.google.firebase.auth;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.PublicApi;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
@PublicApi
/* loaded from: classes2.dex */
public class GetTokenResult {

    /* renamed from: a */
    private String f16398a;

    /* renamed from: b */
    private Map<String, Object> f16399b;

    @KeepForSdk
    public GetTokenResult(String str, Map<String, Object> map) {
        this.f16398a = str;
        this.f16399b = map;
    }

    @PublicApi
    public Map<String, Object> a() {
        return this.f16399b;
    }

    @PublicApi
    public String b() {
        Map map = (Map) this.f16399b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    @PublicApi
    public String c() {
        return this.f16398a;
    }
}
