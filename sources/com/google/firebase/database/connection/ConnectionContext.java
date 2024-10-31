package com.google.firebase.database.connection;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class ConnectionContext {

    /* renamed from: a */
    private final ScheduledExecutorService f16731a;

    /* renamed from: b */
    private final ConnectionAuthTokenProvider f16732b;

    /* renamed from: c */
    private final Logger f16733c;

    /* renamed from: d */
    private final boolean f16734d;

    /* renamed from: e */
    private final String f16735e;

    /* renamed from: f */
    private final String f16736f;

    /* renamed from: g */
    private final String f16737g;

    public ConnectionContext(Logger logger, ConnectionAuthTokenProvider connectionAuthTokenProvider, ScheduledExecutorService scheduledExecutorService, boolean z, String str, String str2, String str3) {
        this.f16733c = logger;
        this.f16732b = connectionAuthTokenProvider;
        this.f16731a = scheduledExecutorService;
        this.f16734d = z;
        this.f16735e = str;
        this.f16736f = str2;
        this.f16737g = str3;
    }

    public ConnectionAuthTokenProvider a() {
        return this.f16732b;
    }

    public String b() {
        return this.f16735e;
    }

    public ScheduledExecutorService c() {
        return this.f16731a;
    }

    public Logger d() {
        return this.f16733c;
    }

    public String e() {
        return this.f16737g;
    }

    public String f() {
        return this.f16736f;
    }

    public boolean g() {
        return this.f16734d;
    }
}
