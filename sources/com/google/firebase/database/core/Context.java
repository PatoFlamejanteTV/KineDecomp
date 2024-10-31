package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class Context {

    /* renamed from: a, reason: collision with root package name */
    protected Logger f16840a;

    /* renamed from: b, reason: collision with root package name */
    protected EventTarget f16841b;

    /* renamed from: c, reason: collision with root package name */
    protected AuthTokenProvider f16842c;

    /* renamed from: d, reason: collision with root package name */
    protected RunLoop f16843d;

    /* renamed from: e, reason: collision with root package name */
    protected String f16844e;

    /* renamed from: f, reason: collision with root package name */
    protected List<String> f16845f;

    /* renamed from: g, reason: collision with root package name */
    protected String f16846g;
    protected boolean i;
    protected FirebaseApp k;
    private PersistenceManager l;
    private Platform o;

    /* renamed from: h, reason: collision with root package name */
    protected Logger.Level f16847h = Logger.Level.INFO;
    protected long j = 10485760;
    private boolean m = false;
    private boolean n = false;

    private void o() {
        if (this.f16842c == null) {
            this.f16842c = v().a(u());
        }
    }

    private void p() {
        if (this.f16841b == null) {
            this.f16841b = v().a(this);
        }
    }

    private void q() {
        if (this.f16840a == null) {
            this.f16840a = v().a(this, this.f16847h, this.f16845f);
        }
    }

    private void r() {
        if (this.f16843d == null) {
            this.f16843d = this.o.c(this);
        }
    }

    private void s() {
        if (this.f16844e == null) {
            this.f16844e = "default";
        }
    }

    private void t() {
        if (this.f16846g == null) {
            this.f16846g = c(v().b(this));
        }
    }

    private ScheduledExecutorService u() {
        RunLoop h2 = h();
        if (h2 instanceof DefaultRunLoop) {
            return ((DefaultRunLoop) h2).b();
        }
        throw new RuntimeException("Custom run loops are not supported!");
    }

    private Platform v() {
        if (this.o == null) {
            x();
        }
        return this.o;
    }

    private void w() {
        q();
        v();
        t();
        p();
        r();
        s();
        o();
    }

    private synchronized void x() {
        this.o = new AndroidPlatform(this.k);
    }

    private void y() {
        this.f16841b.a();
        this.f16843d.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        if (l()) {
            throw new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b() {
        if (!this.m) {
            this.m = true;
            w();
        }
    }

    public AuthTokenProvider c() {
        return this.f16842c;
    }

    public ConnectionContext d() {
        return new ConnectionContext(f(), a(c()), u(), m(), FirebaseDatabase.b(), k(), i().getAbsolutePath());
    }

    public EventTarget e() {
        return this.f16841b;
    }

    public Logger f() {
        return this.f16840a;
    }

    public long g() {
        return this.j;
    }

    public RunLoop h() {
        return this.f16843d;
    }

    public File i() {
        return v().a();
    }

    public String j() {
        return this.f16844e;
    }

    public String k() {
        return this.f16846g;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.i;
    }

    public void n() {
        if (this.n) {
            y();
            this.n = false;
        }
    }

    private String c(String str) {
        return "Firebase/5/" + FirebaseDatabase.b() + "/" + str;
    }

    public LogWrapper a(String str) {
        return new LogWrapper(this.f16840a, str);
    }

    public PersistentConnection a(HostInfo hostInfo, PersistentConnection.Delegate delegate) {
        return v().a(this, d(), hostInfo, delegate);
    }

    private static ConnectionAuthTokenProvider a(AuthTokenProvider authTokenProvider) {
        return new C1589e(authTokenProvider);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PersistenceManager b(String str) {
        PersistenceManager persistenceManager = this.l;
        if (persistenceManager != null) {
            return persistenceManager;
        }
        if (this.i) {
            PersistenceManager a2 = this.o.a(this, str);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
        }
        return new NoopPersistenceManager();
    }
}
