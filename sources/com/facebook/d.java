package com.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.facebook.GraphRequest;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.Date;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f261a;
    private final android.support.v4.a.f b;
    private final c c;
    private AccessToken d;
    private AtomicBoolean e = new AtomicBoolean(false);
    private Date f = new Date(0);

    d(android.support.v4.a.f fVar, c cVar) {
        Validate.notNull(fVar, "localBroadcastManager");
        Validate.notNull(cVar, "accessTokenCache");
        this.b = fVar;
        this.c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        if (f261a == null) {
            synchronized (d.class) {
                if (f261a == null) {
                    f261a = new d(android.support.v4.a.f.a(FacebookSdk.getApplicationContext()), new c());
                }
            }
        }
        return f261a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessToken b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        AccessToken a2 = this.c.a();
        if (a2 == null) {
            return false;
        }
        a(a2, false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AccessToken accessToken) {
        a(accessToken, true);
    }

    private void a(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.d;
        this.d = accessToken;
        this.e.set(false);
        this.f = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.c.a(accessToken);
            } else {
                this.c.b();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            a(accessToken2, accessToken);
        }
    }

    private void a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.b.a(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (f()) {
            e();
        }
    }

    private boolean f() {
        if (this.d == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        return this.d.getSource().canExtendToken() && valueOf.longValue() - this.f.getTime() > 3600000 && valueOf.longValue() - this.d.getLastRefresh().getTime() > 86400000;
    }

    private static GraphRequest a(AccessToken accessToken, GraphRequest.Callback callback) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, callback);
    }

    private static GraphRequest b(AccessToken accessToken, GraphRequest.Callback callback) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.GET, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccessTokenManager.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f262a;
        public int b;

        private a() {
        }

        /* synthetic */ a(e eVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            g();
        } else {
            new Handler(Looper.getMainLooper()).post(new e(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        AccessToken accessToken = this.d;
        if (accessToken != null && this.e.compareAndSet(false, true)) {
            Validate.runningOnUiThread();
            this.f = new Date();
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            a aVar = new a(null);
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(a(accessToken, new f(this, atomicBoolean, hashSet, hashSet2)), b(accessToken, new g(this, aVar)));
            graphRequestBatch.addCallback(new h(this, accessToken, atomicBoolean, aVar, hashSet, hashSet2));
            graphRequestBatch.executeAsync();
        }
    }
}
