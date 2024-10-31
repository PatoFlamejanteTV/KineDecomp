package com.google.firebase.auth.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzai {

    /* renamed from: a */
    private static String f16516a = "com.google.firebase.auth.internal.STATUS";

    /* renamed from: b */
    private static final Map<String, String> f16517b;

    static {
        HashMap hashMap = new HashMap();
        f16517b = hashMap;
        hashMap.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        f16517b.put("auth/invalid-cert-hash", "INVALID_CERT_HASH");
        f16517b.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        f16517b.put("auth/web-storage-unsupported", "WEB_STORAGE_UNSUPPORTED");
    }

    public static void a(Intent intent, Status status) {
        SafeParcelableSerializer.a(status, intent, f16516a);
    }

    public static Status b(Intent intent) {
        Preconditions.a(intent);
        Preconditions.a(a(intent));
        return (Status) SafeParcelableSerializer.a(intent, f16516a, Status.CREATOR);
    }

    public static boolean a(Intent intent) {
        Preconditions.a(intent);
        return intent.hasExtra(f16516a);
    }
}
