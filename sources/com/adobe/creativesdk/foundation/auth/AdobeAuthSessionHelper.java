package com.adobe.creativesdk.foundation.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.adobe.creativesdk.foundation.internal.auth.E;
import com.adobe.creativesdk.foundation.internal.auth.X;
import com.adobe.creativesdk.foundation.internal.auth.Y;
import com.adobe.creativesdk.foundation.internal.auth.aa;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* loaded from: classes.dex */
public class AdobeAuthSessionHelper {

    /* renamed from: a */
    private static final String f4693a = "AdobeAuthSessionHelper";

    /* renamed from: b */
    a f4694b;

    /* renamed from: e */
    Y f4697e;

    /* renamed from: f */
    X f4698f;

    /* renamed from: g */
    aa f4699g;

    /* renamed from: c */
    private E f4695c = E.m();

    /* renamed from: d */
    private Intent f4696d = null;

    /* renamed from: h */
    Handler f4700h = null;

    /* loaded from: classes.dex */
    public enum AdobeAuthStatus {
        AdobeAuthLoggedIn,
        AdobeAuthLoginAttemptFailed,
        AdobeAuthLoggedOut,
        AdobeAuthLogoutAttemptFailed,
        AdobeAuthContinuableEvent,
        AdobeAuthSocialRecoverableSDK
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(AdobeAuthStatus adobeAuthStatus, AdobeAuthException adobeAuthException);
    }

    public AdobeAuthSessionHelper(a aVar) {
        this.f4694b = null;
        this.f4697e = null;
        this.f4698f = null;
        this.f4699g = null;
        this.f4694b = aVar;
        this.f4698f = new d(this);
        this.f4697e = new g(this);
        this.f4699g = new i(this);
    }

    public void a() {
    }

    public void a(int i, int i2, Intent intent) {
        j d2 = this.f4695c.d();
        if (d2 == null || d2.f() != i) {
            return;
        }
        this.f4696d = intent;
    }

    public void a(Bundle bundle) {
    }

    public void b() {
        this.f4695c.b(this.f4698f);
        this.f4695c.b(this.f4697e);
        this.f4695c.b(this.f4699g);
        this.f4695c.a((Activity) null);
    }

    public void c() {
        this.f4695c.a(this.f4698f);
        this.f4695c.a(this.f4697e);
        this.f4695c.a(this.f4699g);
        if (!this.f4695c.h() && !this.f4695c.a()) {
            if (this.f4695c.c() != null) {
                AdobeAuthException b2 = this.f4695c.b();
                if (b2 != null) {
                    this.f4699g.a(b2);
                    return;
                }
                return;
            }
            Intent intent = this.f4696d;
            if (intent != null) {
                int intExtra = intent.getIntExtra("AdobeAuthErrorCode", -1);
                this.f4696d = null;
                if (intExtra != -1) {
                    this.f4698f.a(new AdobeAuthException(AdobeAuthErrorCode.fromInt(intExtra)));
                    return;
                } else {
                    this.f4698f.a(this.f4695c.f());
                    return;
                }
            }
            this.f4697e.onSuccess();
            return;
        }
        if (this.f4695c.h()) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4693a, "Has got valid access token(inside AdobeAuthSessionHelper)");
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4693a, "Has refresh access token(inside AdobeAuthSessionHelper)");
        }
        this.f4698f.a(this.f4695c.f());
    }

    public void d() {
    }

    public void e() {
    }
}
