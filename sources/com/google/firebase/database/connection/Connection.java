package com.google.firebase.database.connection;

import com.google.firebase.database.connection.WebsocketConnection;
import com.google.firebase.database.logging.LogWrapper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Connection implements WebsocketConnection.Delegate {

    /* renamed from: a */
    private static long f16725a;

    /* renamed from: b */
    private HostInfo f16726b;

    /* renamed from: c */
    private WebsocketConnection f16727c;

    /* renamed from: d */
    private Delegate f16728d;

    /* renamed from: e */
    private State f16729e;

    /* renamed from: f */
    private final LogWrapper f16730f;

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface Delegate {
        void a(long j, String str);

        void a(DisconnectReason disconnectReason);

        void a(String str);

        void a(Map<String, Object> map);

        void c(String str);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum DisconnectReason {
        SERVER_RESET,
        OTHER
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum State {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public Connection(ConnectionContext connectionContext, HostInfo hostInfo, String str, Delegate delegate, String str2) {
        long j = f16725a;
        f16725a = 1 + j;
        this.f16726b = hostInfo;
        this.f16728d = delegate;
        this.f16730f = new LogWrapper(connectionContext.d(), "Connection", "conn_" + j);
        this.f16729e = State.REALTIME_CONNECTING;
        this.f16727c = new WebsocketConnection(connectionContext, hostInfo, str, this, str2);
    }

    private void c(Map<String, Object> map) {
        if (this.f16730f.a()) {
            this.f16730f.a("received data message: " + map.toString(), new Object[0]);
        }
        this.f16728d.a(map);
    }

    private void d(Map<String, Object> map) {
        long longValue = ((Long) map.get("ts")).longValue();
        this.f16728d.c((String) map.get("h"));
        String str = (String) map.get(com.umeng.commonsdk.proguard.e.ap);
        if (this.f16729e == State.REALTIME_CONNECTING) {
            this.f16727c.c();
            a(longValue, str);
        }
    }

    public void a(DisconnectReason disconnectReason) {
        if (this.f16729e != State.REALTIME_DISCONNECTED) {
            if (this.f16730f.a()) {
                this.f16730f.a("closing realtime connection", new Object[0]);
            }
            this.f16729e = State.REALTIME_DISCONNECTED;
            WebsocketConnection websocketConnection = this.f16727c;
            if (websocketConnection != null) {
                websocketConnection.a();
                this.f16727c = null;
            }
            this.f16728d.a(disconnectReason);
        }
    }

    public void b() {
        if (this.f16730f.a()) {
            this.f16730f.a("Opening a connection", new Object[0]);
        }
        this.f16727c.b();
    }

    private void b(Map<String, Object> map) {
        if (this.f16730f.a()) {
            this.f16730f.a("Got control message: " + map.toString(), new Object[0]);
        }
        try {
            String str = (String) map.get(com.umeng.commonsdk.proguard.e.ar);
            if (str != null) {
                if (str.equals(com.umeng.commonsdk.proguard.e.ap)) {
                    a((String) map.get(com.umeng.commonsdk.proguard.e.am));
                    return;
                }
                if (str.equals("r")) {
                    b((String) map.get(com.umeng.commonsdk.proguard.e.am));
                    return;
                }
                if (str.equals("h")) {
                    d((Map) map.get(com.umeng.commonsdk.proguard.e.am));
                    return;
                }
                if (this.f16730f.a()) {
                    this.f16730f.a("Ignoring unknown control message: " + str, new Object[0]);
                    return;
                }
                return;
            }
            if (this.f16730f.a()) {
                this.f16730f.a("Got invalid control message: " + map.toString(), new Object[0]);
            }
            a();
        } catch (ClassCastException e2) {
            if (this.f16730f.a()) {
                this.f16730f.a("Failed to parse control message: " + e2.toString(), new Object[0]);
            }
            a();
        }
    }

    public void a() {
        a(DisconnectReason.OTHER);
    }

    public void a(Map<String, Object> map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(com.umeng.commonsdk.proguard.e.ar, com.umeng.commonsdk.proguard.e.am);
        hashMap.put(com.umeng.commonsdk.proguard.e.am, map);
        b(hashMap, z);
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection.Delegate
    public void a(Map<String, Object> map) {
        try {
            String str = (String) map.get(com.umeng.commonsdk.proguard.e.ar);
            if (str != null) {
                if (str.equals(com.umeng.commonsdk.proguard.e.am)) {
                    c((Map) map.get(com.umeng.commonsdk.proguard.e.am));
                    return;
                }
                if (str.equals("c")) {
                    b((Map<String, Object>) map.get(com.umeng.commonsdk.proguard.e.am));
                    return;
                }
                if (this.f16730f.a()) {
                    this.f16730f.a("Ignoring unknown server message type: " + str, new Object[0]);
                    return;
                }
                return;
            }
            if (this.f16730f.a()) {
                this.f16730f.a("Failed to parse server message: missing message type:" + map.toString(), new Object[0]);
            }
            a();
        } catch (ClassCastException e2) {
            if (this.f16730f.a()) {
                this.f16730f.a("Failed to parse server message: " + e2.toString(), new Object[0]);
            }
            a();
        }
    }

    private void b(String str) {
        if (this.f16730f.a()) {
            this.f16730f.a("Got a reset; killing connection to " + this.f16726b.a() + "; Updating internalHost to " + str, new Object[0]);
        }
        this.f16728d.c(str);
        a(DisconnectReason.SERVER_RESET);
    }

    private void b(Map<String, Object> map, boolean z) {
        if (this.f16729e != State.REALTIME_CONNECTED) {
            this.f16730f.a("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z) {
            this.f16730f.a("Sending data (contents hidden)", new Object[0]);
        } else {
            this.f16730f.a("Sending data: %s", map);
        }
        this.f16727c.a(map);
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection.Delegate
    public void a(boolean z) {
        this.f16727c = null;
        if (!z && this.f16729e == State.REALTIME_CONNECTING) {
            if (this.f16730f.a()) {
                this.f16730f.a("Realtime connection failed", new Object[0]);
            }
        } else if (this.f16730f.a()) {
            this.f16730f.a("Realtime connection lost", new Object[0]);
        }
        a();
    }

    private void a(String str) {
        if (this.f16730f.a()) {
            this.f16730f.a("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f16728d.a(str);
        a();
    }

    private void a(long j, String str) {
        if (this.f16730f.a()) {
            this.f16730f.a("realtime connection established", new Object[0]);
        }
        this.f16729e = State.REALTIME_CONNECTED;
        this.f16728d.a(j, str);
    }
}
