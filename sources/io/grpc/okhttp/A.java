package io.grpc.okhttp;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.okhttp.internal.Protocol;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: OkHttpTlsUpgrader.java */
/* loaded from: classes3.dex */
final class A {

    /* renamed from: a */
    @VisibleForTesting
    static final List<Protocol> f27822a = Collections.unmodifiableList(Arrays.asList(Protocol.GRPC_EXP, Protocol.HTTP_2));

    public static SSLSocket a(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i, io.grpc.okhttp.internal.b bVar) throws IOException {
        Preconditions.a(sSLSocketFactory, "sslSocketFactory");
        Preconditions.a(socket, "socket");
        Preconditions.a(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i, true);
        bVar.a(sSLSocket, false);
        String b2 = x.a().b(sSLSocket, str, bVar.b() ? f27822a : null);
        Preconditions.b(f27822a.contains(Protocol.get(b2)), "Only " + f27822a + " are supported, but negotiated protocol is %s", b2);
        if (hostnameVerifier == null) {
            hostnameVerifier = io.grpc.okhttp.internal.d.f27903a;
        }
        if (hostnameVerifier.verify(a(str), sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }

    @VisibleForTesting
    static String a(String str) {
        return (str.startsWith("[") && str.endsWith("]")) ? str.substring(1, str.length() - 1) : str;
    }
}
