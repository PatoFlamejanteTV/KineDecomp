package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public interface Connections {

    /* renamed from: a, reason: collision with root package name */
    public static final List<Integer> f2094a = Arrays.asList(1, 2);

    /* loaded from: classes.dex */
    public interface ConnectionRequestListener {
        void a(String str, String str2, String str3, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface ConnectionResponseCallback {
        void a(String str, Status status, byte[] bArr);
    }

    /* loaded from: classes.dex */
    public interface EndpointDiscoveryListener {
        void a(String str);

        void a(String str, String str2, String str3, String str4);
    }

    /* loaded from: classes.dex */
    public interface MessageListener {
        void a(String str);

        void a(String str, byte[] bArr, boolean z);
    }

    /* loaded from: classes.dex */
    public interface StartAdvertisingResult extends Result {
    }
}
