package com.facebook;

import com.facebook.AccessToken;
import com.facebook.AccessTokenManager;
import com.facebook.GraphRequestBatch;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccessTokenManager.java */
/* renamed from: com.facebook.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0728g implements GraphRequestBatch.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AccessToken f9257a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AccessToken.AccessTokenRefreshCallback f9258b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicBoolean f9259c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager.a f9260d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Set f9261e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Set f9262f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ AccessTokenManager f9263g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0728g(AccessTokenManager accessTokenManager, AccessToken accessToken, AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback, AtomicBoolean atomicBoolean, AccessTokenManager.a aVar, Set set, Set set2) {
        this.f9263g = accessTokenManager;
        this.f9257a = accessToken;
        this.f9258b = accessTokenRefreshCallback;
        this.f9259c = atomicBoolean;
        this.f9260d = aVar;
        this.f9261e = set;
        this.f9262f = set2;
    }

    @Override // com.facebook.GraphRequestBatch.Callback
    public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        AtomicBoolean atomicBoolean4;
        AccessToken accessToken = null;
        try {
            if (AccessTokenManager.getInstance().getCurrentAccessToken() != null && AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() == this.f9257a.getUserId()) {
                if (!this.f9259c.get() && this.f9260d.f9115a == null && this.f9260d.f9116b == 0) {
                    if (this.f9258b != null) {
                        this.f9258b.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                    }
                    atomicBoolean4 = this.f9263g.tokenRefreshInProgress;
                    atomicBoolean4.set(false);
                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback = this.f9258b;
                    return;
                }
                AccessToken accessToken2 = new AccessToken(this.f9260d.f9115a != null ? this.f9260d.f9115a : this.f9257a.getToken(), this.f9257a.getApplicationId(), this.f9257a.getUserId(), this.f9259c.get() ? this.f9261e : this.f9257a.getPermissions(), this.f9259c.get() ? this.f9262f : this.f9257a.getDeclinedPermissions(), this.f9257a.getSource(), this.f9260d.f9116b != 0 ? new Date(this.f9260d.f9116b * 1000) : this.f9257a.getExpires(), new Date());
                try {
                    AccessTokenManager.getInstance().setCurrentAccessToken(accessToken2);
                    atomicBoolean3 = this.f9263g.tokenRefreshInProgress;
                    atomicBoolean3.set(false);
                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback2 = this.f9258b;
                    if (accessTokenRefreshCallback2 != null) {
                        accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th = th;
                    accessToken = accessToken2;
                    atomicBoolean = this.f9263g.tokenRefreshInProgress;
                    atomicBoolean.set(false);
                    AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback3 = this.f9258b;
                    if (accessTokenRefreshCallback3 != null && accessToken != null) {
                        accessTokenRefreshCallback3.OnTokenRefreshed(accessToken);
                    }
                    throw th;
                }
            }
            if (this.f9258b != null) {
                this.f9258b.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            atomicBoolean2 = this.f9263g.tokenRefreshInProgress;
            atomicBoolean2.set(false);
            AccessToken.AccessTokenRefreshCallback accessTokenRefreshCallback4 = this.f9258b;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
