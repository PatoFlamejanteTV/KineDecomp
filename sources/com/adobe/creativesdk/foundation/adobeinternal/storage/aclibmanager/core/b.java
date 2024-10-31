package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import c.a.a.a.a.b.a.c.g;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.events.ACLibraryManagerLibOpEvent;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* compiled from: ACLibraryController.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ACLibraryManager f4083a;

    /* renamed from: b, reason: collision with root package name */
    private final c.a.a.a.a.b.a.a f4084b;

    /* renamed from: c, reason: collision with root package name */
    private C0614ub f4085c;

    public b(ACLibraryManager aCLibraryManager) {
        this(aCLibraryManager, c.a.a.a.a.b.a.a.a());
    }

    private void a(boolean z) {
        C0614ub a2 = g.a(this.f4083a);
        if (a2 == null) {
            a2 = c();
        }
        a(a2, z);
    }

    public C0614ub b() {
        return this.f4085c;
    }

    protected C0614ub c() {
        return this.f4083a.d();
    }

    public ACLibraryManager d() {
        return this.f4083a;
    }

    public boolean e() {
        return !this.f4083a.f();
    }

    public void f() {
        this.f4083a.h();
        this.f4083a = null;
    }

    public b(ACLibraryManager aCLibraryManager, c.a.a.a.a.b.a.a aVar) {
        this.f4083a = aCLibraryManager;
        this.f4084b = aVar;
        this.f4083a.i();
        a(false);
        this.f4084b.b(this);
    }

    private void a(C0614ub c0614ub, boolean z) {
        this.f4085c = c0614ub;
        if (z) {
            a(ACLibraryManagerLibOpEvent.Type.kCurrentLibrarySwitched);
        }
    }

    private void a(Object obj) {
        this.f4084b.a(obj);
    }

    private void a(ACLibraryManagerLibOpEvent.Type type) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(type);
        aCLibraryManagerLibOpEvent.f4097d = b();
        a(aCLibraryManagerLibOpEvent);
    }

    public void a() {
        this.f4083a.c();
    }

    public void a(c.a.a.a.a.b.a.a.d dVar) {
        this.f4083a.a(dVar);
    }
}
