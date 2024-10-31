package com.mixpanel.android.java_websocket.a;

import android.annotation.SuppressLint;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.b;
import com.mixpanel.android.java_websocket.b.d;
import com.mixpanel.android.java_websocket.b.f;
import com.mixpanel.android.java_websocket.b.h;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: WebSocketClient.java */
@SuppressLint({"Assert"})
/* loaded from: classes.dex */
public abstract class a extends com.mixpanel.android.java_websocket.a implements WebSocket, Runnable {
    static final /* synthetic */ boolean b;

    /* renamed from: a, reason: collision with root package name */
    protected URI f2988a;
    private b c;
    private InputStream e;
    private OutputStream f;
    private Thread h;
    private Draft i;
    private Map<String, String> j;
    private int m;
    private Socket d = null;
    private Proxy g = Proxy.NO_PROXY;
    private CountDownLatch k = new CountDownLatch(1);
    private CountDownLatch l = new CountDownLatch(1);

    public abstract void a(h hVar);

    public abstract void a(Exception exc);

    public abstract void a(String str);

    public abstract void b(int i, String str, boolean z);

    static {
        b = !a.class.desiredAssertionStatus();
    }

    public a(URI uri, Draft draft, Map<String, String> map, int i) {
        this.f2988a = null;
        this.c = null;
        this.m = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.f2988a = uri;
        this.i = draft;
        this.j = map;
        this.m = i;
        this.c = new b(this, draft);
    }

    public void b() {
        if (this.h != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        this.h = new Thread(this);
        this.h.start();
    }

    public boolean c() throws InterruptedException {
        b();
        this.k.await();
        return this.c.c();
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            if (this.d == null) {
                this.d = new Socket(this.g);
            } else if (this.d.isClosed()) {
                throw new IOException();
            }
            if (!this.d.isBound()) {
                this.d.connect(new InetSocketAddress(this.f2988a.getHost(), g()), this.m);
            }
            this.e = this.d.getInputStream();
            this.f = this.d.getOutputStream();
            h();
            this.h = new Thread(new RunnableC0055a());
            this.h.start();
            byte[] bArr = new byte[b.f2990a];
            while (!e() && (read = this.e.read(bArr)) != -1) {
                try {
                    this.c.a(ByteBuffer.wrap(bArr, 0, read));
                } catch (IOException e) {
                    this.c.b();
                } catch (RuntimeException e2) {
                    a(e2);
                    this.c.b(1006, e2.getMessage());
                }
            }
            this.c.b();
            if (!b && !this.d.isClosed()) {
                throw new AssertionError();
            }
        } catch (Exception e3) {
            a(this.c, e3);
            this.c.b(-1, e3.getMessage());
        }
    }

    private int g() {
        int port = this.f2988a.getPort();
        if (port == -1) {
            String scheme = this.f2988a.getScheme();
            if (scheme.equals("wss")) {
                return 443;
            }
            if (scheme.equals("ws")) {
                return 80;
            }
            throw new RuntimeException("unkonow scheme" + scheme);
        }
        return port;
    }

    private void h() throws InvalidHandshakeException {
        String path = this.f2988a.getPath();
        String query = this.f2988a.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int g = g();
        String str = this.f2988a.getHost() + (g != 80 ? ":" + g : "");
        d dVar = new d();
        dVar.a(path);
        dVar.a("Host", str);
        if (this.j != null) {
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                dVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.c.a((com.mixpanel.android.java_websocket.b.b) dVar);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void a(WebSocket webSocket, String str) {
        a(str);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void a(WebSocket webSocket, ByteBuffer byteBuffer) {
        a(byteBuffer);
    }

    @Override // com.mixpanel.android.java_websocket.a, com.mixpanel.android.java_websocket.c
    public void a(WebSocket webSocket, Framedata framedata) {
        b(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void a(WebSocket webSocket, f fVar) {
        this.k.countDown();
        a((h) fVar);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void a(WebSocket webSocket, int i, String str, boolean z) {
        this.k.countDown();
        this.l.countDown();
        if (this.h != null) {
            this.h.interrupt();
        }
        try {
            if (this.d != null) {
                this.d.close();
            }
        } catch (IOException e) {
            a(this, e);
        }
        b(i, str, z);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void a(WebSocket webSocket, Exception exc) {
        a(exc);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public final void b(WebSocket webSocket) {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void a(WebSocket webSocket, int i, String str) {
        a(i, str);
    }

    @Override // com.mixpanel.android.java_websocket.c
    public void b(WebSocket webSocket, int i, String str, boolean z) {
        a(i, str, z);
    }

    public void a(int i, String str) {
    }

    public void a(int i, String str, boolean z) {
    }

    @Override // com.mixpanel.android.java_websocket.c
    public InetSocketAddress c(WebSocket webSocket) {
        if (this.d != null) {
            return (InetSocketAddress) this.d.getLocalSocketAddress();
        }
        return null;
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public void b(Framedata framedata) {
    }

    /* compiled from: WebSocketClient.java */
    /* renamed from: com.mixpanel.android.java_websocket.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class RunnableC0055a implements Runnable {
        private RunnableC0055a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = a.this.c.f.take();
                    a.this.f.write(take.array(), 0, take.limit());
                    a.this.f.flush();
                } catch (IOException e) {
                    a.this.c.b();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public void a(Socket socket) {
        if (this.d != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.d = socket;
    }

    public void a(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.c.a(opcode, byteBuffer, z);
    }

    public boolean d() {
        return this.c.e();
    }

    public boolean e() {
        return this.c.f();
    }

    public boolean f() {
        return this.c.d();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public void a(Framedata framedata) {
        this.c.a(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public InetSocketAddress a() {
        return this.c.a();
    }
}
