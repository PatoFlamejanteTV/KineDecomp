package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthSignInActivity.java */
/* loaded from: classes.dex */
public abstract class N {

    /* renamed from: a, reason: collision with root package name */
    protected AdobeAuthSignInActivity f4844a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4845b;

    /* renamed from: c, reason: collision with root package name */
    private Object f4846c;

    public N() {
        this.f4845b = false;
        this.f4845b = false;
    }

    public void a(AdobeAuthSignInActivity adobeAuthSignInActivity) {
        this.f4844a = adobeAuthSignInActivity;
    }

    protected abstract void a(Object obj);

    public abstract void a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Object obj) {
        this.f4845b = true;
        this.f4846c = obj;
    }

    public abstract void b(String str);

    public void c() {
        if (this.f4844a == null) {
            return;
        }
        a(this.f4846c);
        d();
    }

    protected void d() {
        this.f4845b = false;
        this.f4846c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AdobeAuthException adobeAuthException) {
        b(adobeAuthException);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public V a() {
        return new M(this);
    }

    public boolean b() {
        return this.f4845b;
    }

    protected void b(AdobeAuthException adobeAuthException) {
        AdobeAuthSignInActivity adobeAuthSignInActivity = this.f4844a;
        if (adobeAuthSignInActivity == null) {
            AdobeAuthSignInActivity.b(adobeAuthException);
        } else {
            adobeAuthSignInActivity.a(adobeAuthException);
        }
    }
}
