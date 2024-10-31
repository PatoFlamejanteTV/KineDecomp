package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import c.a.a.a.a.b.a.c.g;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.events.ACLibraryManagerLibOpEvent;
import com.adobe.creativesdk.foundation.internal.storage.a.b.ra;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AbstractC0618vb;
import com.adobe.creativesdk.foundation.storage.AdobeLibraryException;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.Gb;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ACLibraryManager extends AbstractC0618vb {

    /* renamed from: e, reason: collision with root package name */
    private c.a.a.a.a.b.a.a f4075e;

    /* renamed from: f, reason: collision with root package name */
    private e f4076f;

    /* renamed from: g, reason: collision with root package name */
    private Gb f4077g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4078h = false;

    /* loaded from: classes.dex */
    public enum ACLibraryNotificationID implements com.adobe.creativesdk.foundation.internal.notification.d {
        ACLibrarySyncStartedNotification,
        ACLibrarySyncFinishedNotification
    }

    protected ACLibraryManager() {
    }

    private void b(e eVar, c.a.a.a.a.b.a.a aVar) {
        this.f4075e = aVar;
        this.f4076f = eVar;
        this.f4077g = k();
    }

    private void j() {
        if (this.f4077g.l()) {
            this.f4077g.s();
        }
    }

    private Gb k() {
        ra raVar;
        Gb f2 = Gb.f();
        this.f7450a = this.f4076f.f4092b;
        try {
            raVar = (ra) com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c().getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
        } catch (AdobeLibraryException e2) {
            e = e2;
            raVar = null;
        }
        try {
            if (!f2.i()) {
                f2.h(this.f4076f.f4093c);
            }
            f2.a(this, this.f4076f.f4091a);
            f2.b(true);
            if (f2.g().a()) {
                b();
            }
            return f2;
        } catch (AdobeLibraryException e3) {
            e = e3;
            StringBuilder sb = new StringBuilder();
            sb.append("Failed with AdobeLibraryException in ACLibraryManager createLibraryManager method error code : ");
            sb.append(e.getErrorCode().name());
            sb.append("   and storage session was : ");
            sb.append(raVar != null ? " =VALID " : " =INVALID ");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static boolean l() {
        return g.a();
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    protected void a(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    protected void a(C0614ub c0614ub, AdobeCSDKException adobeCSDKException) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public boolean a(String str) {
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    protected String b(String str) {
        return null;
    }

    public void c() {
        i();
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void d(String str) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kLibraryUnShared);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4096c = str;
        a(aCLibraryManagerLibOpEvent);
    }

    public C0614ub e(String str) {
        return this.f4077g.d(str);
    }

    public boolean f() {
        ArrayList<C0614ub> e2 = e();
        return (e2 != null && e2.size() > 0) || this.f4078h;
    }

    public boolean g() {
        return this.f4077g != null;
    }

    public void h() {
        if (this.f4077g != null) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, " LibraryManager- shutDown", "ACLibraryManager-shutDOwn");
            this.f4077g.a(this);
            this.f4077g.p();
        }
        this.f4077g = null;
    }

    public void i() {
        j();
        this.f4077g.r();
    }

    public static ACLibraryManager a(e eVar, c.a.a.a.a.b.a.a aVar) {
        if (l()) {
            ACLibraryManager aCLibraryManager = new ACLibraryManager();
            aCLibraryManager.b(eVar, aVar);
            return aCLibraryManager;
        }
        throw new IllegalArgumentException("ACLibraryManager Failed to create instance : User not authenticated");
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void c(C0614ub c0614ub, String str) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kElementUpdated);
        aCLibraryManagerLibOpEvent.f4095b = str;
        aCLibraryManagerLibOpEvent.f4097d = c0614ub;
        a(aCLibraryManagerLibOpEvent);
    }

    public ArrayList<C0614ub> e() {
        return this.f4077g.e();
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void b(C0614ub c0614ub, String str) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kElementRemoved);
        aCLibraryManagerLibOpEvent.f4095b = str;
        aCLibraryManagerLibOpEvent.f4097d = c0614ub;
        a(aCLibraryManagerLibOpEvent);
    }

    public C0614ub d() {
        ArrayList<C0614ub> e2 = e();
        if (e2 == null || e2.size() == 0) {
            return null;
        }
        C0614ub c0614ub = e2.get(0);
        for (int i = 1; i < e2.size(); i++) {
            C0614ub c0614ub2 = e2.get(i);
            if (c0614ub2.l() > c0614ub.l()) {
                c0614ub = c0614ub2;
            }
        }
        return c0614ub;
    }

    public void a(c.a.a.a.a.b.a.a.d dVar) {
        boolean[] zArr = {this.f4077g.g().a()};
        if (!zArr[0]) {
            this.f4077g.r();
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(ACLibraryNotificationID.ACLibrarySyncFinishedNotification, new c(this, dVar));
        } else {
            com.adobe.creativesdk.foundation.internal.notification.b.a().a(ACLibraryNotificationID.ACLibrarySyncFinishedNotification, new d(this, zArr, dVar));
        }
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void c(String str) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kLibraryDeleted);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4096c = str;
        a(aCLibraryManagerLibOpEvent);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void b(C0614ub c0614ub) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kLibraryUpdated);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4097d = c0614ub;
        aCLibraryManagerLibOpEvent.f4096c = c0614ub.k();
        a(aCLibraryManagerLibOpEvent);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void a(C0614ub c0614ub, String str) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kElementAdded);
        aCLibraryManagerLibOpEvent.f4095b = str;
        aCLibraryManagerLibOpEvent.f4097d = c0614ub;
        a(aCLibraryManagerLibOpEvent);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void b() {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kSyncStarted);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4097d = null;
        a(aCLibraryManagerLibOpEvent);
    }

    private void a(ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent) {
        this.f4075e.a(aCLibraryManagerLibOpEvent);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    public void a(C0614ub c0614ub) {
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kLibraryAdded);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4097d = c0614ub;
        a(aCLibraryManagerLibOpEvent);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    protected void b(AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        if (adobeNetworkStatusCode == AdobeNetworkReachability.AdobeNetworkStatusCode.AdobeNetworkNotReachable) {
            ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kSyncUnavailableDueToNoInternat);
            aCLibraryManagerLibOpEvent.f4095b = null;
            aCLibraryManagerLibOpEvent.f4096c = null;
            a(aCLibraryManagerLibOpEvent);
            return;
        }
        a(new com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.events.a());
    }

    @Override // com.adobe.creativesdk.foundation.storage.AbstractC0618vb
    protected void a() {
        this.f4078h = true;
        ACLibraryManagerLibOpEvent aCLibraryManagerLibOpEvent = new ACLibraryManagerLibOpEvent(ACLibraryManagerLibOpEvent.Type.kSyncFinished);
        aCLibraryManagerLibOpEvent.f4095b = null;
        aCLibraryManagerLibOpEvent.f4096c = null;
        a(aCLibraryManagerLibOpEvent);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(new com.adobe.creativesdk.foundation.internal.notification.c(ACLibraryNotificationID.ACLibrarySyncFinishedNotification, null));
    }

    private void a(Object obj) {
        this.f4075e.a(obj);
    }
}
