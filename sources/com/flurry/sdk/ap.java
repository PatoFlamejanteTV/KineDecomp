package com.flurry.sdk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: classes.dex */
public class ap implements LayeredSocketFactory, SocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private SSLContext f464a = null;

    private static SSLContext a() throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new aq(null)}, null);
            return sSLContext;
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    private SSLContext b() throws IOException {
        if (this.f464a == null) {
            this.f464a = a();
        }
        return this.f464a;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket connectSocket(Socket socket, String str, int i, InetAddress inetAddress, int i2, HttpParams httpParams) throws IOException, UnknownHostException, ConnectTimeoutException {
        int connectionTimeout = HttpConnectionParams.getConnectionTimeout(httpParams);
        int soTimeout = HttpConnectionParams.getSoTimeout(httpParams);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
        SSLSocket sSLSocket = (SSLSocket) (socket != null ? socket : createSocket());
        if (inetAddress != null || i2 > 0) {
            if (i2 < 0) {
                i2 = 0;
            }
            sSLSocket.bind(new InetSocketAddress(inetAddress, i2));
        }
        sSLSocket.connect(inetSocketAddress, connectionTimeout);
        sSLSocket.setSoTimeout(soTimeout);
        return sSLSocket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        return b().getSocketFactory().createSocket();
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(Socket socket) throws IllegalArgumentException {
        return true;
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
        return b().getSocketFactory().createSocket(socket, str, i, z);
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass().equals(ap.class);
    }

    public int hashCode() {
        return ap.class.hashCode();
    }
}
