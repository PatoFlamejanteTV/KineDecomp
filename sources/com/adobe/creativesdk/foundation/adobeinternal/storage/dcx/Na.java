package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: AdobeDCXNode.java */
/* loaded from: classes.dex */
public class Na {

    /* renamed from: a, reason: collision with root package name */
    private static String f4208a = "AdobeDCXNode";

    /* renamed from: b, reason: collision with root package name */
    private La f4209b;

    /* renamed from: c, reason: collision with root package name */
    private InterfaceC0223b f4210c;

    /* JADX INFO: Access modifiers changed from: protected */
    public Na(La la, InterfaceC0223b interfaceC0223b) {
        this.f4209b = la;
        this.f4210c = interfaceC0223b;
    }

    private boolean h() {
        return this.f4210c instanceof C0235h;
    }

    private boolean i() {
        return this.f4210c == null || h();
    }

    public List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.f4209b.c().keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        arrayList.removeAll(Fa.s());
        return arrayList;
    }

    public void b(String str) {
        this.f4209b.b(str);
        if (i()) {
            try {
                this.f4210c.a().d(this.f4209b);
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4208a, null, e2);
            }
        }
    }

    public void c(String str) {
        this.f4209b.c(str);
        if (i()) {
            try {
                this.f4210c.a().d(this.f4209b);
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4208a, null, e2);
            }
        }
    }

    public String d() {
        return this.f4209b.f();
    }

    public String e() {
        return this.f4209b.g();
    }

    public String f() {
        return this.f4209b.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        this.f4209b = this.f4209b.e();
        this.f4210c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Na(String str, String str2, String str3, String str4) {
        this.f4209b = new La(str, str2, str3);
        if (str4 != null) {
            this.f4209b.d(str4);
        }
        this.f4210c = null;
    }

    public Object a(String str) {
        return this.f4209b.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InterfaceC0223b b() {
        return this.f4210c;
    }

    public La c() {
        return this.f4209b;
    }

    public void a(Object obj, String str) {
        this.f4209b.a(obj, str);
        if (i()) {
            try {
                this.f4210c.a().d(this.f4209b);
            } catch (AdobeDCXException e2) {
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, f4208a, null, e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(La la) {
        this.f4209b = la;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(InterfaceC0223b interfaceC0223b) {
        this.f4210c = interfaceC0223b;
    }
}
