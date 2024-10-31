package com.google.firebase.database.connection;

import android.support.v4.app.NotificationCompat;
import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import com.qq.e.comm.constants.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {

    /* renamed from: a */
    private static long f16741a;
    private long A;
    private boolean B;

    /* renamed from: b */
    private final PersistentConnection.Delegate f16742b;

    /* renamed from: c */
    private final HostInfo f16743c;

    /* renamed from: d */
    private String f16744d;

    /* renamed from: g */
    private long f16747g;

    /* renamed from: h */
    private Connection f16748h;
    private String p;
    private boolean q;
    private final ConnectionContext r;
    private final ConnectionAuthTokenProvider s;
    private final ScheduledExecutorService t;
    private final LogWrapper u;
    private final RetryHelper v;
    private String w;

    /* renamed from: e */
    private HashSet<String> f16745e = new HashSet<>();

    /* renamed from: f */
    private boolean f16746f = true;
    private ConnectionState i = ConnectionState.Disconnected;
    private long j = 0;
    private long k = 0;
    private long x = 0;
    private int y = 0;
    private ScheduledFuture<?> z = null;
    private Map<b, d> o = new HashMap();
    private Map<Long, a> l = new HashMap();
    private Map<Long, e> n = new HashMap();
    private List<c> m = new ArrayList();

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Map<String, Object> map);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a */
        private final List<String> f16749a;

        /* renamed from: b */
        private final Map<String, Object> f16750b;

        public b(List<String> list, Map<String, Object> map) {
            this.f16749a = list;
            this.f16750b = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f16749a.equals(bVar.f16749a)) {
                return this.f16750b.equals(bVar.f16750b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f16749a.hashCode() * 31) + this.f16750b.hashCode();
        }

        public String toString() {
            return ConnectionUtils.a(this.f16749a) + " (params: " + this.f16750b + ")";
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a */
        private final String f16751a;

        /* renamed from: b */
        private final List<String> f16752b;

        /* renamed from: c */
        private final Object f16753c;

        /* renamed from: d */
        private final RequestResultCallback f16754d;

        public String a() {
            return this.f16751a;
        }

        public Object b() {
            return this.f16753c;
        }

        public RequestResultCallback c() {
            return this.f16754d;
        }

        public List<String> d() {
            return this.f16752b;
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a */
        private final RequestResultCallback f16755a;

        /* renamed from: b */
        private final b f16756b;

        /* renamed from: c */
        private final ListenHashProvider f16757c;

        /* renamed from: d */
        private final Long f16758d;

        /* synthetic */ d(RequestResultCallback requestResultCallback, b bVar, Long l, ListenHashProvider listenHashProvider, com.google.firebase.database.connection.b bVar2) {
            this(requestResultCallback, bVar, l, listenHashProvider);
        }

        public Long c() {
            return this.f16758d;
        }

        public String toString() {
            return this.f16756b.toString() + " (Tag: " + this.f16758d + ")";
        }

        private d(RequestResultCallback requestResultCallback, b bVar, Long l, ListenHashProvider listenHashProvider) {
            this.f16755a = requestResultCallback;
            this.f16756b = bVar;
            this.f16757c = listenHashProvider;
            this.f16758d = l;
        }

        public ListenHashProvider a() {
            return this.f16757c;
        }

        public b b() {
            return this.f16756b;
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a */
        private String f16759a;

        /* renamed from: b */
        private Map<String, Object> f16760b;

        /* renamed from: c */
        private RequestResultCallback f16761c;

        /* renamed from: d */
        private boolean f16762d;

        /* synthetic */ e(String str, Map map, RequestResultCallback requestResultCallback, com.google.firebase.database.connection.b bVar) {
            this(str, map, requestResultCallback);
        }

        public String a() {
            return this.f16759a;
        }

        public RequestResultCallback b() {
            return this.f16761c;
        }

        public Map<String, Object> c() {
            return this.f16760b;
        }

        public void d() {
            this.f16762d = true;
        }

        public boolean e() {
            return this.f16762d;
        }

        private e(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.f16759a = str;
            this.f16760b = map;
            this.f16761c = requestResultCallback;
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        this.f16742b = delegate;
        this.r = connectionContext;
        this.t = connectionContext.c();
        this.s = connectionContext.a();
        this.f16743c = hostInfo;
        this.v = new RetryHelper.Builder(this.t, connectionContext.d(), "ConnectionRetryHelper").b(1000L).b(1.3d).a(com.umeng.commonsdk.proguard.c.f26227d).a(0.7d).a();
        long j = f16741a;
        f16741a = 1 + j;
        this.u = new LogWrapper(connectionContext.d(), "PersistentConnection", "pc_" + j);
        this.w = null;
        f();
    }

    public static /* synthetic */ int b(PersistentConnectionImpl persistentConnectionImpl) {
        int i = persistentConnectionImpl.y;
        persistentConnectionImpl.y = i + 1;
        return i;
    }

    public static /* synthetic */ long n(PersistentConnectionImpl persistentConnectionImpl) {
        long j = persistentConnectionImpl.x;
        persistentConnectionImpl.x = 1 + j;
        return j;
    }

    private boolean b() {
        return this.i == ConnectionState.Connected;
    }

    private boolean e() {
        ConnectionState connectionState = this.i;
        return connectionState == ConnectionState.Authenticating || connectionState == ConnectionState.Connected;
    }

    private boolean h() {
        return this.o.isEmpty() && this.l.isEmpty() && !this.B && this.n.isEmpty();
    }

    private long i() {
        long j = this.k;
        this.k = 1 + j;
        return j;
    }

    private void j() {
        if (this.u.a()) {
            this.u.a("calling restore state", new Object[0]);
        }
        ConnectionUtils.a(this.i == ConnectionState.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.i);
        if (this.p == null) {
            if (this.u.a()) {
                this.u.a("Not restoring auth because token is null.", new Object[0]);
            }
            this.i = ConnectionState.Connected;
            k();
            return;
        }
        if (this.u.a()) {
            this.u.a("Restoring auth.", new Object[0]);
        }
        this.i = ConnectionState.Authenticating;
        l();
    }

    public void k() {
        ConnectionUtils.a(this.i == ConnectionState.Connected, "Should be connected if we're restoring state, but we are: %s", this.i);
        if (this.u.a()) {
            this.u.a("Restoring outstanding listens", new Object[0]);
        }
        for (d dVar : this.o.values()) {
            if (this.u.a()) {
                this.u.a("Restoring listen " + dVar.b(), new Object[0]);
            }
            a(dVar);
        }
        if (this.u.a()) {
            this.u.a("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.n.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b(((Long) it.next()).longValue());
        }
        for (c cVar : this.m) {
            a(cVar.a(), cVar.d(), cVar.b(), cVar.c());
        }
        this.m.clear();
    }

    private void l() {
        a(true);
    }

    private void m() {
        HashMap hashMap = new HashMap();
        if (this.r.g()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        hashMap.put("sdk.android." + this.r.b().replace('.', '-'), 1);
        if (this.u.a()) {
            this.u.a("Sending first connection stats", new Object[0]);
        }
        c(hashMap);
    }

    private void n() {
        ConnectionUtils.a(e(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.a(this.p == null, "Auth token must not be set.", new Object[0]);
        a("unauth", Collections.emptyMap(), (a) null);
    }

    public void o() {
        if (a()) {
            ConnectionUtils.a(this.i == ConnectionState.Disconnected, "Not in disconnected state: %s", this.i);
            boolean z = this.q;
            this.u.a("Scheduling connection attempt", new Object[0]);
            this.q = false;
            this.v.a(new com.google.firebase.database.connection.b(this, z));
        }
    }

    private void p() {
        a(false);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void c(String str) {
        this.f16744d = str;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void d() {
        o();
    }

    public boolean f(String str) {
        return this.f16745e.contains(str);
    }

    public void g(String str) {
        ConnectionUtils.a(this.i == ConnectionState.GettingToken, "Trying to open network connection while in the wrong state: %s", this.i);
        if (str == null) {
            this.f16742b.a(false);
        }
        this.p = str;
        this.i = ConnectionState.Connecting;
        this.f16748h = new Connection(this.r, this.f16743c, this.f16744d, this, this.w);
        this.f16748h.b();
    }

    private void c() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, e>> it = this.n.entrySet().iterator();
        while (it.hasNext()) {
            e value = it.next().getValue();
            if (value.c().containsKey("h") && value.e()) {
                arrayList.add(value);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((e) it2.next()).b().a("disconnected", null);
        }
    }

    public void f() {
        if (h()) {
            ScheduledFuture<?> scheduledFuture = this.z;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.z = this.t.schedule(new h(this), 60000L, TimeUnit.MILLISECONDS);
            return;
        }
        if (f("connection_idle")) {
            ConnectionUtils.a(!h());
            d("connection_idle");
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void b(String str) {
        if (this.u.a()) {
            this.u.a("Connection interrupted for: " + str, new Object[0]);
        }
        this.f16745e.add(str);
        Connection connection = this.f16748h;
        if (connection != null) {
            connection.a();
            this.f16748h = null;
        } else {
            this.v.a();
            this.i = ConnectionState.Disconnected;
        }
        this.v.c();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void d(String str) {
        if (this.u.a()) {
            this.u.a("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.f16745e.remove(str);
        if (a() && this.i == ConnectionState.Disconnected) {
            o();
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void e(String str) {
        this.u.a("Auth token refreshed.", new Object[0]);
        this.p = str;
        if (e()) {
            if (str != null) {
                p();
            } else {
                n();
            }
        }
    }

    public boolean g() {
        return h() && System.currentTimeMillis() > this.A + 60000;
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void a(long j, String str) {
        if (this.u.a()) {
            this.u.a("onReady", new Object[0]);
        }
        this.f16747g = System.currentTimeMillis();
        a(j);
        if (this.f16746f) {
            m();
        }
        j();
        this.f16746f = false;
        this.w = str;
        this.f16742b.a();
    }

    private void b(d dVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.a((List<String>) dVar.f16756b.f16749a));
        Long c2 = dVar.c();
        if (c2 != null) {
            hashMap.put("q", dVar.b().f16750b);
            hashMap.put(com.umeng.commonsdk.proguard.e.ar, c2);
        }
        a("n", hashMap, (a) null);
    }

    private void c(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            a(com.umeng.commonsdk.proguard.e.ap, hashMap, new g(this));
        } else if (this.u.a()) {
            this.u.a("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private Collection<d> b(List<String> list) {
        if (this.u.a()) {
            this.u.a("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<b, d> entry : this.o.entrySet()) {
            b key = entry.getKey();
            d value = entry.getValue();
            if (key.f16749a.equals(list)) {
                arrayList.add(value);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.o.remove(((d) it.next()).b());
        }
        f();
        return arrayList;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void a(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l, RequestResultCallback requestResultCallback) {
        b bVar = new b(list, map);
        if (this.u.a()) {
            this.u.a("Listening on " + bVar, new Object[0]);
        }
        ConnectionUtils.a(!this.o.containsKey(bVar), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.u.a()) {
            this.u.a("Adding listen query: " + bVar, new Object[0]);
        }
        d dVar = new d(requestResultCallback, bVar, l, listenHashProvider, null);
        this.o.put(bVar, dVar);
        if (e()) {
            a(dVar);
        }
        f();
    }

    private void b(Map<String, Object> map) {
        this.u.a((String) map.get(NotificationCompat.CATEGORY_MESSAGE));
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void a(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        a("p", list, obj, (String) null, requestResultCallback);
    }

    private void b(long j) {
        e eVar = this.n.get(Long.valueOf(j));
        RequestResultCallback b2 = eVar.b();
        String a2 = eVar.a();
        eVar.d();
        a(a2, eVar.c(), new com.google.firebase.database.connection.e(this, a2, j, eVar, b2));
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void a(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        a("p", list, obj, str, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void a(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        a("m", list, map, (String) null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void a(Map<String, Object> map) {
        if (map.containsKey("r")) {
            a remove = this.l.remove(Long.valueOf(((Integer) map.get("r")).intValue()));
            if (remove != null) {
                remove.a((Map) map.get("b"));
                return;
            }
            return;
        }
        if (map.containsKey("error")) {
            return;
        }
        if (map.containsKey(com.umeng.commonsdk.proguard.e.al)) {
            a((String) map.get(com.umeng.commonsdk.proguard.e.al), (Map<String, Object>) map.get("b"));
            return;
        }
        if (this.u.a()) {
            this.u.a("Ignoring unknown message: " + map, new Object[0]);
        }
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void a(Connection.DisconnectReason disconnectReason) {
        boolean z = false;
        if (this.u.a()) {
            this.u.a("Got on disconnect due to " + disconnectReason.name(), new Object[0]);
        }
        this.i = ConnectionState.Disconnected;
        this.f16748h = null;
        this.B = false;
        this.l.clear();
        c();
        if (a()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f16747g;
            long j2 = currentTimeMillis - j;
            if (j > 0 && j2 > com.umeng.commonsdk.proguard.c.f26227d) {
                z = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z) {
                this.v.c();
            }
            o();
        }
        this.f16747g = 0L;
        this.f16742b.onDisconnect();
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void a(String str) {
        if (this.u.a()) {
            this.u.a("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str, new Object[0]);
        }
        b("server_kill");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void a(List<String> list, Map<String, Object> map) {
        b bVar = new b(list, map);
        if (this.u.a()) {
            this.u.a("unlistening on " + bVar, new Object[0]);
        }
        d a2 = a(bVar);
        if (a2 != null && e()) {
            b(a2);
        }
        f();
    }

    boolean a() {
        return this.f16745e.size() == 0;
    }

    private void a(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.a(list));
        hashMap.put(com.umeng.commonsdk.proguard.e.am, obj);
        a(str, hashMap, new com.google.firebase.database.connection.c(this, requestResultCallback));
    }

    public d a(b bVar) {
        if (this.u.a()) {
            this.u.a("removing query " + bVar, new Object[0]);
        }
        if (!this.o.containsKey(bVar)) {
            if (!this.u.a()) {
                return null;
            }
            this.u.a("Trying to remove listener for QuerySpec " + bVar + " but no listener exists.", new Object[0]);
            return null;
        }
        d dVar = this.o.get(bVar);
        this.o.remove(bVar);
        f();
        return dVar;
    }

    private void a(String str, Map<String, Object> map) {
        if (this.u.a()) {
            this.u.a("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (!str.equals(com.umeng.commonsdk.proguard.e.am) && !str.equals("m")) {
            if (str.equals("rm")) {
                String str2 = (String) map.get("p");
                List<String> a2 = ConnectionUtils.a(str2);
                Object obj = map.get(com.umeng.commonsdk.proguard.e.am);
                Long a3 = ConnectionUtils.a(map.get(com.umeng.commonsdk.proguard.e.ar));
                ArrayList arrayList = new ArrayList();
                for (Map map2 : (List) obj) {
                    String str3 = (String) map2.get(com.umeng.commonsdk.proguard.e.ap);
                    String str4 = (String) map2.get("e");
                    List<String> list = null;
                    List<String> a4 = str3 != null ? ConnectionUtils.a(str3) : null;
                    if (str4 != null) {
                        list = ConnectionUtils.a(str4);
                    }
                    arrayList.add(new RangeMerge(a4, list, map2.get("m")));
                }
                if (arrayList.isEmpty()) {
                    if (this.u.a()) {
                        this.u.a("Ignoring empty range merge for path " + str2, new Object[0]);
                        return;
                    }
                    return;
                }
                this.f16742b.a(a2, arrayList, a3);
                return;
            }
            if (str.equals("c")) {
                a(ConnectionUtils.a((String) map.get("p")));
                return;
            }
            if (str.equals("ac")) {
                a((String) map.get(com.umeng.commonsdk.proguard.e.ap), (String) map.get(com.umeng.commonsdk.proguard.e.am));
                return;
            }
            if (str.equals("sd")) {
                b(map);
                return;
            }
            if (this.u.a()) {
                this.u.a("Unrecognized action from server: " + str, new Object[0]);
                return;
            }
            return;
        }
        boolean equals = str.equals("m");
        String str5 = (String) map.get("p");
        Object obj2 = map.get(com.umeng.commonsdk.proguard.e.am);
        Long a5 = ConnectionUtils.a(map.get(com.umeng.commonsdk.proguard.e.ar));
        if (equals && (obj2 instanceof Map) && ((Map) obj2).size() == 0) {
            if (this.u.a()) {
                this.u.a("ignoring empty merge for path " + str5, new Object[0]);
                return;
            }
            return;
        }
        this.f16742b.a(ConnectionUtils.a(str5), obj2, equals, a5);
    }

    private void a(List<String> list) {
        Collection<d> b2 = b(list);
        if (b2 != null) {
            Iterator<d> it = b2.iterator();
            while (it.hasNext()) {
                it.next().f16755a.a("permission_denied", null);
            }
        }
    }

    private void a(String str, String str2) {
        this.u.a("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.p = null;
        this.q = true;
        this.f16742b.a(false);
        this.f16748h.a();
    }

    private void a(boolean z) {
        ConnectionUtils.a(e(), "Must be connected to send auth, but was: %s", this.i);
        ConnectionUtils.a(this.p != null, "Auth token must be set to authenticate!", new Object[0]);
        com.google.firebase.database.connection.d dVar = new com.google.firebase.database.connection.d(this, z);
        HashMap hashMap = new HashMap();
        GAuthToken a2 = GAuthToken.a(this.p);
        if (a2 != null) {
            hashMap.put("cred", a2.b());
            if (a2.a() != null) {
                hashMap.put("authvar", a2.a());
            }
            a("gauth", true, (Map<String, Object>) hashMap, (a) dVar);
            return;
        }
        hashMap.put("cred", this.p);
        a("auth", true, (Map<String, Object>) hashMap, (a) dVar);
    }

    private void a(long j) {
        if (this.u.a()) {
            this.u.a("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.f16742b.a(hashMap);
    }

    private Map<String, Object> a(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.a(list));
        hashMap.put(com.umeng.commonsdk.proguard.e.am, obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void a(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> a2 = a(list, obj, str2);
        long j = this.j;
        this.j = 1 + j;
        this.n.put(Long.valueOf(j), new e(str, a2, requestResultCallback, null));
        if (b()) {
            b(j);
        }
        this.A = System.currentTimeMillis();
        f();
    }

    private void a(d dVar) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("p", ConnectionUtils.a((List<String>) dVar.b().f16749a));
        Object c2 = dVar.c();
        if (c2 != null) {
            hashMap.put("q", dVar.f16756b.f16750b);
            hashMap.put(com.umeng.commonsdk.proguard.e.ar, c2);
        }
        ListenHashProvider a2 = dVar.a();
        hashMap.put("h", a2.a());
        if (a2.c()) {
            CompoundHash b2 = a2.b();
            ArrayList arrayList = new ArrayList();
            Iterator<List<String>> it = b2.b().iterator();
            while (it.hasNext()) {
                arrayList.add(ConnectionUtils.a(it.next()));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("hs", b2.a());
            hashMap2.put(Constants.KEYS.PLACEMENTS, arrayList);
            hashMap.put("ch", hashMap2);
        }
        a("q", hashMap, new f(this, dVar));
    }

    public void a(List<String> list, b bVar) {
        if (list.contains("no_index")) {
            String str = "\".indexOn\": \"" + bVar.f16750b.get(com.umeng.commonsdk.proguard.e.aq) + '\"';
            this.u.b("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + str + "' at " + ConnectionUtils.a((List<String>) bVar.f16749a) + " to your security and Firebase Database rules for better performance");
        }
    }

    private void a(String str, Map<String, Object> map, a aVar) {
        a(str, false, map, aVar);
    }

    private void a(String str, boolean z, Map<String, Object> map, a aVar) {
        long i = i();
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(i));
        hashMap.put(com.umeng.commonsdk.proguard.e.al, str);
        hashMap.put("b", map);
        this.f16748h.a(hashMap, z);
        this.l.put(Long.valueOf(i), aVar);
    }
}
