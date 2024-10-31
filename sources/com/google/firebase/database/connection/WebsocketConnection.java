package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class WebsocketConnection {

    /* renamed from: a */
    private static long f16766a;

    /* renamed from: b */
    private a f16767b;

    /* renamed from: c */
    private boolean f16768c = false;

    /* renamed from: d */
    private boolean f16769d = false;

    /* renamed from: e */
    private long f16770e = 0;

    /* renamed from: f */
    private StringListReader f16771f;

    /* renamed from: g */
    private Delegate f16772g;

    /* renamed from: h */
    private ScheduledFuture<?> f16773h;
    private ScheduledFuture<?> i;
    private final ConnectionContext j;
    private final ScheduledExecutorService k;
    private final LogWrapper l;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface Delegate {
        void a(Map<String, Object> map);

        void a(boolean z);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);

        void close();

        void connect();
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public class b implements a, WebSocketEventHandler {

        /* renamed from: a */
        private WebSocket f16774a;

        /* synthetic */ b(WebsocketConnection websocketConnection, WebSocket webSocket, i iVar) {
            this(webSocket);
        }

        private void b() {
            this.f16774a.b();
            try {
                this.f16774a.a();
            } catch (InterruptedException e2) {
                WebsocketConnection.this.l.a("Interrupted while shutting down websocket threads", e2);
            }
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void a() {
            WebsocketConnection.this.k.execute(new k(this));
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.a
        public void close() {
            this.f16774a.b();
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.a
        public void connect() {
            try {
                this.f16774a.c();
            } catch (WebSocketException e2) {
                if (WebsocketConnection.this.l.a()) {
                    WebsocketConnection.this.l.a("Error connecting", e2, new Object[0]);
                }
                b();
            }
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onClose() {
            WebsocketConnection.this.k.execute(new m(this));
        }

        private b(WebSocket webSocket) {
            this.f16774a = webSocket;
            this.f16774a.a(this);
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void a(WebSocketMessage webSocketMessage) {
            String a2 = webSocketMessage.a();
            if (WebsocketConnection.this.l.a()) {
                WebsocketConnection.this.l.a("ws message: " + a2, new Object[0]);
            }
            WebsocketConnection.this.k.execute(new l(this, a2));
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void a(WebSocketException webSocketException) {
            WebsocketConnection.this.k.execute(new n(this, webSocketException));
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.a
        public void a(String str) {
            this.f16774a.a(str);
        }
    }

    public WebsocketConnection(ConnectionContext connectionContext, HostInfo hostInfo, String str, Delegate delegate, String str2) {
        this.j = connectionContext;
        this.k = connectionContext.c();
        this.f16772g = delegate;
        long j = f16766a;
        f16766a = 1 + j;
        this.l = new LogWrapper(connectionContext.d(), "WebSocket", "ws_" + j);
        this.f16767b = a(hostInfo, str, str2);
    }

    public void h() {
        if (this.f16769d) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.f16773h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            if (this.l.a()) {
                this.l.a("Reset keepAlive. Remaining: " + this.f16773h.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
            }
        } else if (this.l.a()) {
            this.l.a("Reset keepAlive", new Object[0]);
        }
        this.f16773h = this.k.schedule(f(), 45000L, TimeUnit.MILLISECONDS);
    }

    private void i() {
        this.f16769d = true;
        this.f16772g.a(this.f16768c);
    }

    public void c() {
    }

    public void c(String str) {
        if (this.f16769d) {
            return;
        }
        h();
        if (e()) {
            a(str);
            return;
        }
        String b2 = b(str);
        if (b2 != null) {
            a(b2);
        }
    }

    public void d() {
        if (this.f16768c || this.f16769d) {
            return;
        }
        if (this.l.a()) {
            this.l.a("timed out on connect", new Object[0]);
        }
        this.f16767b.close();
    }

    private boolean e() {
        return this.f16771f != null;
    }

    private Runnable f() {
        return new j(this);
    }

    public void g() {
        if (!this.f16769d) {
            if (this.l.a()) {
                this.l.a("closing itself", new Object[0]);
            }
            i();
        }
        this.f16767b = null;
        ScheduledFuture<?> scheduledFuture = this.f16773h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public void b() {
        this.f16767b.connect();
        this.i = this.k.schedule(new i(this), com.umeng.commonsdk.proguard.c.f26227d, TimeUnit.MILLISECONDS);
    }

    private a a(HostInfo hostInfo, String str, String str2) {
        if (str == null) {
            str = hostInfo.a();
        }
        URI a2 = HostInfo.a(str, hostInfo.c(), hostInfo.b(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put(io.fabric.sdk.android.services.common.a.HEADER_USER_AGENT, this.j.f());
        return new b(this, new WebSocket(this.j, a2, null, hashMap), null);
    }

    private String b(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt <= 0) {
                    return null;
                }
                a(parseInt);
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        a(1);
        return str;
    }

    public void a() {
        if (this.l.a()) {
            this.l.a("websocket is being closed", new Object[0]);
        }
        this.f16769d = true;
        this.f16767b.close();
        ScheduledFuture<?> scheduledFuture = this.i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.f16773h;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void a(Map<String, Object> map) {
        h();
        try {
            String[] a2 = a(JsonMapper.a(map), 16384);
            if (a2.length > 1) {
                this.f16767b.a("" + a2.length);
            }
            for (String str : a2) {
                this.f16767b.a(str);
            }
        } catch (IOException e2) {
            this.l.a("Failed to serialize message: " + map.toString(), e2);
            i();
        }
    }

    private void a(String str) {
        this.f16771f.e(str);
        this.f16770e--;
        if (this.f16770e == 0) {
            try {
                this.f16771f.a();
                Map<String, Object> a2 = JsonMapper.a(this.f16771f.toString());
                this.f16771f = null;
                if (this.l.a()) {
                    this.l.a("handleIncomingFrame complete frame: " + a2, new Object[0]);
                }
                this.f16772g.a(a2);
            } catch (IOException e2) {
                this.l.a("Error parsing frame: " + this.f16771f.toString(), e2);
                a();
                i();
            } catch (ClassCastException e3) {
                this.l.a("Error parsing frame (cast error): " + this.f16771f.toString(), e3);
                a();
                i();
            }
        }
    }

    private void a(int i) {
        this.f16770e = i;
        this.f16771f = new StringListReader();
        if (this.l.a()) {
            this.l.a("HandleNewFrameCount: " + this.f16770e, new Object[0]);
        }
    }

    private static String[] a(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int i3 = i2 + i;
            arrayList.add(str.substring(i2, Math.min(i3, str.length())));
            i2 = i3;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
