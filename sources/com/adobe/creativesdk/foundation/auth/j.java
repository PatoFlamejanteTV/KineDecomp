package com.adobe.creativesdk.foundation.auth;

import android.app.Activity;
import android.content.Context;

/* compiled from: AdobeAuthSessionLauncher.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a */
    private Activity f4712a = null;

    /* renamed from: b */
    private Context f4713b = null;

    /* renamed from: c */
    private int f4714c = 2002;

    /* renamed from: d */
    private int f4715d = 0;

    /* renamed from: e */
    private String[] f4716e = null;

    /* renamed from: f */
    private AdobeAuthErrorCode f4717f = null;

    /* renamed from: g */
    private String f4718g;

    protected j() {
    }

    public Context c() {
        return this.f4712a;
    }

    public Context d() {
        return this.f4713b;
    }

    @Deprecated
    public String e() {
        return this.f4718g;
    }

    public int f() {
        return this.f4714c;
    }

    @Deprecated
    public String[] g() {
        return this.f4716e;
    }

    /* compiled from: AdobeAuthSessionLauncher.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d */
        String[] f4722d;

        /* renamed from: f */
        AdobeAuthErrorCode f4724f;

        /* renamed from: a */
        Activity f4719a = null;

        /* renamed from: b */
        Context f4720b = null;

        /* renamed from: c */
        int f4721c = 2002;

        /* renamed from: e */
        int f4723e = 0;

        /* renamed from: g */
        String f4725g = null;

        public a a(Activity activity) {
            this.f4719a = activity;
            this.f4720b = null;
            return this;
        }

        public a a(Context context) {
            this.f4720b = context;
            this.f4719a = null;
            return this;
        }

        public a a(int i) {
            this.f4721c = i;
            return this;
        }

        @Deprecated
        public a a(String[] strArr) {
            this.f4722d = strArr;
            return this;
        }

        public a a(AdobeAuthErrorCode adobeAuthErrorCode) {
            this.f4724f = adobeAuthErrorCode;
            return this;
        }

        @Deprecated
        public a a(String str) {
            this.f4725g = str;
            return this;
        }

        public j a() {
            if (this.f4720b == null && this.f4719a == null) {
                throw new IllegalArgumentException("activity or context must be defined");
            }
            j jVar = new j();
            a(jVar);
            return jVar;
        }

        protected void a(j jVar) {
            jVar.f4715d = this.f4723e;
            jVar.f4714c = this.f4721c;
            jVar.f4712a = this.f4719a;
            jVar.f4713b = this.f4720b;
            jVar.f4716e = this.f4722d;
            jVar.f4717f = this.f4724f;
            jVar.f4718g = this.f4725g;
        }
    }

    public int b() {
        return this.f4715d;
    }

    public AdobeAuthErrorCode a() {
        return this.f4717f;
    }
}
