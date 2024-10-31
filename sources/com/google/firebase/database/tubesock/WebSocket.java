package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class WebSocket {

    /* renamed from: a */
    private static final AtomicInteger f17229a = new AtomicInteger(0);

    /* renamed from: b */
    private static final Charset f17230b = Charset.forName("UTF-8");

    /* renamed from: c */
    private static ThreadFactory f17231c = Executors.defaultThreadFactory();

    /* renamed from: d */
    private static ThreadInitializer f17232d = new d();

    /* renamed from: h */
    private final URI f17236h;
    private final String i;
    private final g l;
    private final LogWrapper m;

    /* renamed from: e */
    private volatile State f17233e = State.NONE;

    /* renamed from: f */
    private volatile Socket f17234f = null;

    /* renamed from: g */
    private WebSocketEventHandler f17235g = null;
    private final int n = f17229a.incrementAndGet();
    private final Thread o = g().newThread(new e(this));
    private final h j = new h(this);
    private final j k = new j(this, "TubeSock", this.n);

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum State {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public WebSocket(ConnectionContext connectionContext, URI uri, String str, Map<String, String> map) {
        this.f17236h = uri;
        this.i = connectionContext.e();
        this.m = new LogWrapper(connectionContext.d(), "WebSocket", "sk_" + this.n);
        this.l = new g(uri, str, map);
    }

    public static ThreadInitializer f() {
        return f17232d;
    }

    public static ThreadFactory g() {
        return f17231c;
    }

    private synchronized void i() {
        if (this.f17233e == State.DISCONNECTED) {
            return;
        }
        this.j.b();
        this.k.b();
        if (this.f17234f != null) {
            try {
                this.f17234f.close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        this.f17233e = State.DISCONNECTED;
        this.f17235g.onClose();
    }

    private Socket j() {
        String scheme = this.f17236h.getScheme();
        String host = this.f17236h.getHost();
        int port = this.f17236h.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e2) {
                throw new WebSocketException("unknown host: " + host, e2);
            } catch (IOException e3) {
                throw new WebSocketException("error while creating socket to " + this.f17236h, e3);
            }
        }
        if (scheme != null && scheme.equals("wss")) {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sSLSessionCache = null;
            try {
                if (this.i != null) {
                    sSLSessionCache = new SSLSessionCache(new File(this.i));
                }
            } catch (IOException e4) {
                this.m.a("Failed to initialize SSL session cache", e4, new Object[0]);
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                throw new WebSocketException("Error while verifying secure socket to " + this.f17236h);
            } catch (UnknownHostException e5) {
                throw new WebSocketException("unknown host: " + host, e5);
            } catch (IOException e6) {
                throw new WebSocketException("error while creating secure socket to " + this.f17236h, e6);
            }
        }
        throw new WebSocketException("unsupported protocol: " + scheme);
    }

    public void k() {
        try {
            try {
                Socket j = j();
                synchronized (this) {
                    this.f17234f = j;
                    if (this.f17233e == State.DISCONNECTED) {
                        try {
                            this.f17234f.close();
                            this.f17234f = null;
                            return;
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    DataInputStream dataInputStream = new DataInputStream(j.getInputStream());
                    OutputStream outputStream = j.getOutputStream();
                    outputStream.write(this.l.a());
                    ArrayList arrayList = new ArrayList();
                    byte[] bArr = new byte[1000];
                    boolean z = false;
                    while (true) {
                        int i = 0;
                        while (!z) {
                            int read = dataInputStream.read();
                            if (read != -1) {
                                bArr[i] = (byte) read;
                                i++;
                                if (bArr[i - 1] == 10 && bArr[i - 2] == 13) {
                                    String str = new String(bArr, f17230b);
                                    if (str.trim().equals("")) {
                                        z = true;
                                    } else {
                                        arrayList.add(str.trim());
                                    }
                                    bArr = new byte[1000];
                                } else if (i == 1000) {
                                    throw new WebSocketException("Unexpected long line in handshake: " + new String(bArr, f17230b));
                                }
                            } else {
                                throw new WebSocketException("Connection closed before handshake was complete");
                            }
                        }
                        this.l.a((String) arrayList.get(0));
                        arrayList.remove(0);
                        HashMap<String, String> hashMap = new HashMap<>();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String[] split = ((String) it.next()).split(": ", 2);
                            hashMap.put(split[0], split[1]);
                        }
                        this.l.a(hashMap);
                        this.k.a(outputStream);
                        this.j.a(dataInputStream);
                        this.f17233e = State.CONNECTED;
                        this.k.a().start();
                        this.f17235g.a();
                        this.j.a();
                    }
                }
            } catch (WebSocketException e3) {
                this.f17235g.a(e3);
            } catch (IOException e4) {
                this.f17235g.a(new WebSocketException("error while connecting: " + e4.getMessage(), e4));
            }
        } finally {
            b();
        }
    }

    private void l() {
        try {
            this.f17233e = State.DISCONNECTING;
            this.k.b();
            this.k.a((byte) 8, true, new byte[0]);
        } catch (IOException e2) {
            this.f17235g.a(new WebSocketException("Failed to send close frame", e2));
        }
    }

    public synchronized void b() {
        int i = f.f17247a[this.f17233e.ordinal()];
        if (i == 1) {
            this.f17233e = State.DISCONNECTED;
            return;
        }
        if (i == 2) {
            i();
            return;
        }
        if (i == 3) {
            l();
        } else if (i != 4) {
            if (i != 5) {
            }
        }
    }

    public synchronized void c() {
        if (this.f17233e != State.NONE) {
            this.f17235g.a(new WebSocketException("connect() already called"));
            b();
            return;
        }
        f().a(e(), "TubeSockReader-" + this.n);
        this.f17233e = State.CONNECTING;
        e().start();
    }

    public WebSocketEventHandler d() {
        return this.f17235g;
    }

    Thread e() {
        return this.o;
    }

    public void h() {
        i();
    }

    public void a(WebSocketEventHandler webSocketEventHandler) {
        this.f17235g = webSocketEventHandler;
    }

    public synchronized void a(String str) {
        a((byte) 1, str.getBytes(f17230b));
    }

    public synchronized void a(byte[] bArr) {
        a((byte) 10, bArr);
    }

    private synchronized void a(byte b2, byte[] bArr) {
        if (this.f17233e != State.CONNECTED) {
            this.f17235g.a(new WebSocketException("error while sending data: not connected"));
        } else {
            try {
                this.k.a(b2, true, bArr);
            } catch (IOException e2) {
                this.f17235g.a(new WebSocketException("Failed to send frame", e2));
                b();
            }
        }
    }

    public void a(WebSocketException webSocketException) {
        this.f17235g.a(webSocketException);
        if (this.f17233e == State.CONNECTED) {
            b();
        }
        i();
    }

    public void a() throws InterruptedException {
        if (this.k.a().getState() != Thread.State.NEW) {
            this.k.a().join();
        }
        e().join();
    }
}
