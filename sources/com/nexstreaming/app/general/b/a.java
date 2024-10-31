package com.nexstreaming.app.general.b;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: NoSSLv3Factory.java */
/* loaded from: classes.dex */
public class a extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f3121a = HttpsURLConnection.getDefaultSSLSocketFactory();

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f3121a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f3121a.getSupportedCipherSuites();
    }

    private static Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            return new b((SSLSocket) socket);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a(this.f3121a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return a(this.f3121a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a(this.f3121a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a(this.f3121a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a(this.f3121a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* compiled from: NoSSLv3Factory.java */
    /* renamed from: com.nexstreaming.app.general.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0061a extends SSLSocket {

        /* renamed from: a, reason: collision with root package name */
        protected final SSLSocket f3122a;

        C0061a(SSLSocket sSLSocket) {
            this.f3122a = sSLSocket;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            return this.f3122a.getSupportedCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            return this.f3122a.getEnabledCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] strArr) {
            this.f3122a.setEnabledCipherSuites(strArr);
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            return this.f3122a.getSupportedProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            return this.f3122a.getEnabledProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            this.f3122a.setEnabledProtocols(strArr);
        }

        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            return this.f3122a.getSession();
        }

        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f3122a.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.f3122a.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            this.f3122a.startHandshake();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean z) {
            this.f3122a.setUseClientMode(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            return this.f3122a.getUseClientMode();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean z) {
            this.f3122a.setNeedClientAuth(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean z) {
            this.f3122a.setWantClientAuth(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            return this.f3122a.getNeedClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            return this.f3122a.getWantClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean z) {
            this.f3122a.setEnableSessionCreation(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            return this.f3122a.getEnableSessionCreation();
        }

        @Override // java.net.Socket
        public void bind(SocketAddress socketAddress) throws IOException {
            this.f3122a.bind(socketAddress);
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.f3122a.close();
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress) throws IOException {
            this.f3122a.connect(socketAddress);
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress, int i) throws IOException {
            this.f3122a.connect(socketAddress, i);
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            return this.f3122a.getChannel();
        }

        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            return this.f3122a.getInetAddress();
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return this.f3122a.getInputStream();
        }

        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            return this.f3122a.getKeepAlive();
        }

        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            return this.f3122a.getLocalAddress();
        }

        @Override // java.net.Socket
        public int getLocalPort() {
            return this.f3122a.getLocalPort();
        }

        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            return this.f3122a.getLocalSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            return this.f3122a.getOOBInline();
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return this.f3122a.getOutputStream();
        }

        @Override // java.net.Socket
        public int getPort() {
            return this.f3122a.getPort();
        }

        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.f3122a.getReceiveBufferSize();
        }

        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            return this.f3122a.getRemoteSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            return this.f3122a.getReuseAddress();
        }

        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            return this.f3122a.getSendBufferSize();
        }

        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            return this.f3122a.getSoLinger();
        }

        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            return this.f3122a.getSoTimeout();
        }

        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            return this.f3122a.getTcpNoDelay();
        }

        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            return this.f3122a.getTrafficClass();
        }

        @Override // java.net.Socket
        public boolean isBound() {
            return this.f3122a.isBound();
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            return this.f3122a.isClosed();
        }

        @Override // java.net.Socket
        public boolean isConnected() {
            return this.f3122a.isConnected();
        }

        @Override // java.net.Socket
        public boolean isInputShutdown() {
            return this.f3122a.isInputShutdown();
        }

        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            return this.f3122a.isOutputShutdown();
        }

        @Override // java.net.Socket
        public void sendUrgentData(int i) throws IOException {
            this.f3122a.sendUrgentData(i);
        }

        @Override // java.net.Socket
        public void setKeepAlive(boolean z) throws SocketException {
            this.f3122a.setKeepAlive(z);
        }

        @Override // java.net.Socket
        public void setOOBInline(boolean z) throws SocketException {
            this.f3122a.setOOBInline(z);
        }

        @Override // java.net.Socket
        public void setPerformancePreferences(int i, int i2, int i3) {
            this.f3122a.setPerformancePreferences(i, i2, i3);
        }

        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int i) throws SocketException {
            this.f3122a.setReceiveBufferSize(i);
        }

        @Override // java.net.Socket
        public void setReuseAddress(boolean z) throws SocketException {
            this.f3122a.setReuseAddress(z);
        }

        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int i) throws SocketException {
            this.f3122a.setSendBufferSize(i);
        }

        @Override // java.net.Socket
        public void setSoLinger(boolean z, int i) throws SocketException {
            this.f3122a.setSoLinger(z, i);
        }

        @Override // java.net.Socket
        public synchronized void setSoTimeout(int i) throws SocketException {
            this.f3122a.setSoTimeout(i);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setSSLParameters(SSLParameters sSLParameters) {
            this.f3122a.setSSLParameters(sSLParameters);
        }

        @Override // java.net.Socket
        public void setTcpNoDelay(boolean z) throws SocketException {
            this.f3122a.setTcpNoDelay(z);
        }

        @Override // java.net.Socket
        public void setTrafficClass(int i) throws SocketException {
            this.f3122a.setTrafficClass(i);
        }

        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            this.f3122a.shutdownInput();
        }

        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            this.f3122a.shutdownOutput();
        }

        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            return this.f3122a.toString();
        }

        public boolean equals(Object obj) {
            return this.f3122a.equals(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NoSSLv3Factory.java */
    /* loaded from: classes.dex */
    public static class b extends C0061a {
        private b(SSLSocket sSLSocket) {
            super(sSLSocket);
            if (!sSLSocket.getClass().getCanonicalName().equals("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl")) {
                try {
                    Method method = sSLSocket.getClass().getMethod("setUseSessionTickets", Boolean.TYPE);
                    if (method != null) {
                        method.invoke(sSLSocket, true);
                    }
                } catch (IllegalAccessException e) {
                } catch (NoSuchMethodException e2) {
                } catch (InvocationTargetException e3) {
                }
            }
        }

        @Override // com.nexstreaming.app.general.b.a.C0061a, javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                ArrayList arrayList = new ArrayList(Arrays.asList(this.f3122a.getEnabledProtocols()));
                if (arrayList.size() > 1) {
                    arrayList.remove("SSLv3");
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            super.setEnabledProtocols(strArr);
        }
    }
}
