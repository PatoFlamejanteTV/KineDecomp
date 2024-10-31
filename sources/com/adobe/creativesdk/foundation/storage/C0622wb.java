package com.adobe.creativesdk.foundation.storage;

import java.util.List;

/* compiled from: AdobeLibraryElement.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.wb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0622wb {

    /* renamed from: a, reason: collision with root package name */
    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f7459a;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0622wb(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        this.f7459a = null;
        this.f7459a = ha;
    }

    public Hb a(String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public Object b(String str) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha = this.f7459a;
        if (ha != null) {
            return ha.c().opt(str);
        }
        return null;
    }

    public String c() {
        return this.f7459a.g();
    }

    public long d() {
        return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(b("library#modified"));
    }

    public String e() {
        return this.f7459a.f();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0622wb)) {
            return false;
        }
        return com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(c(), ((C0622wb) obj).c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha f() {
        return this.f7459a;
    }

    public String g() {
        return this.f7459a.k();
    }

    public Hb h() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public List<Hb> i() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public String j() {
        return g();
    }

    public Hb a(String str, String str2) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Na b() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public Hb c(String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public void d(String str) {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "Setters not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
    }

    public Hb a(String str, String str2, String str3, boolean z, String str4, Integer num, Integer num2, boolean z2) throws AdobeLibraryException {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "This method not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
        return null;
    }

    public void a() {
        com.adobe.creativesdk.foundation.internal.storage.model.util.e.b(false, "Setters not allowed on AdobeLibraryElement when using deprecated immutable/mutable model.");
    }
}
