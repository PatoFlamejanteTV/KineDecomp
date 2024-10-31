package com.google.firebase.inappmessaging.internal.injection.modules;

import io.grpc.AbstractC2407f;
import io.grpc.L;
import javax.inject.Named;
import javax.inject.Singleton;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class GrpcChannelModule {
    @Singleton
    public AbstractC2407f a(@Named("host") String str) {
        return L.a(str).a();
    }

    @Singleton
    public String a() {
        return "firebaseinappmessaging.googleapis.com";
    }
}
