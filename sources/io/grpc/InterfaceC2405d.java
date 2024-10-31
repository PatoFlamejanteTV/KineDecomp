package io.grpc;

import io.grpc.C2403b;
import java.util.concurrent.Executor;

/* compiled from: CallCredentials.java */
/* renamed from: io.grpc.d */
/* loaded from: classes3.dex */
public interface InterfaceC2405d {

    /* renamed from: a */
    public static final C2403b.C0153b<SecurityLevel> f27181a = C2403b.C0153b.a("io.grpc.CallCredentials.securityLevel");

    /* renamed from: b */
    public static final C2403b.C0153b<String> f27182b = C2403b.C0153b.a("io.grpc.CallCredentials.authority");

    /* compiled from: CallCredentials.java */
    /* renamed from: io.grpc.d$a */
    /* loaded from: classes3.dex */
    public interface a {
    }

    void a(MethodDescriptor<?, ?> methodDescriptor, C2403b c2403b, Executor executor, a aVar);
}
