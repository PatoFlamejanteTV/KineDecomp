package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.firebase.auth.GetTokenResult;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzaa {

    /* renamed from: a */
    private static final Logger f16501a = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult a(String str) {
        Map<String, Object> map;
        try {
            map = a.a(str);
        } catch (zzaf e2) {
            f16501a.a("Error parsing token claims", e2, new Object[0]);
            map = Collections.EMPTY_MAP;
        }
        return new GetTokenResult(str, map);
    }
}
