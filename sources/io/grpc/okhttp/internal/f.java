package io.grpc.okhttp.internal;

import java.lang.reflect.Method;
import java.security.PrivilegedExceptionAction;
import javax.net.ssl.SSLEngine;

/* compiled from: Platform.java */
/* loaded from: classes3.dex */
class f implements PrivilegedExceptionAction<Method> {
    @Override // java.security.PrivilegedExceptionAction
    public Method run() throws Exception {
        return SSLEngine.class.getMethod("getApplicationProtocol", new Class[0]);
    }
}
