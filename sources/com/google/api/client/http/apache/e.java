package com.google.api.client.http.apache;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: SSLSocketFactoryExtension.java */
/* loaded from: classes.dex */
final class e extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final javax.net.ssl.SSLSocketFactory f2482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SSLContext sSLContext) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException {
        super((KeyStore) null);
        this.f2482a = sSLContext.getSocketFactory();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return this.f2482a.createSocket();
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        SSLSocket sSLSocket = (SSLSocket) this.f2482a.createSocket(socket, str, i, z);
        getHostnameVerifier().verify(str, sSLSocket);
        return sSLSocket;
    }
}
