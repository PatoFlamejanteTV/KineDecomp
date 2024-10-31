package com.adobe.creativesdk.foundation.internal.net;

import android.os.Handler;
import java.io.InputStream;

/* compiled from: AdobeMultiPartData.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.net.a */
/* loaded from: classes.dex */
public class C0322a {

    /* renamed from: a */
    Handler f5091a;

    /* renamed from: b */
    InterfaceC0026a f5092b;

    /* renamed from: c */
    private String f5093c = "form-data";

    /* renamed from: d */
    private String f5094d;

    /* renamed from: e */
    private String f5095e;

    /* renamed from: f */
    private String f5096f;

    /* renamed from: g */
    private String f5097g;

    /* renamed from: h */
    private byte[] f5098h;
    private InputStream i;
    private String j;

    /* compiled from: AdobeMultiPartData.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.net.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0026a {
        void a(long j, long j2);
    }

    public String a() {
        return this.f5093c;
    }

    public String b() {
        return this.f5095e;
    }

    public String c() {
        return this.f5096f;
    }

    public byte[] d() {
        return this.f5098h;
    }

    public String e() {
        return this.j;
    }

    public InputStream f() {
        return this.i;
    }

    public String g() {
        return this.f5097g;
    }

    public String h() {
        return this.f5094d;
    }

    public void a(String str) {
        this.f5095e = str;
    }

    public void b(String str) {
        this.f5096f = str;
    }

    public void a(byte[] bArr) {
        this.f5098h = bArr;
    }
}
