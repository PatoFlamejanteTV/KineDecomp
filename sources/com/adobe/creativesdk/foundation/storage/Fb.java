package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.adobeinternal.storage.library.C0290t;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
public class Fb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0618vb f6973a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f6974b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0614ub f6975c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f6976d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeCSDKException f6977e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f6978f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ AdobeNetworkReachability.AdobeNetworkStatusCode f6979g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Gb f6980h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(Gb gb, AbstractC0618vb abstractC0618vb, String str, C0614ub c0614ub, String str2, AdobeCSDKException adobeCSDKException, String str3, AdobeNetworkReachability.AdobeNetworkStatusCode adobeNetworkStatusCode) {
        this.f6980h = gb;
        this.f6973a = abstractC0618vb;
        this.f6974b = str;
        this.f6975c = c0614ub;
        this.f6976d = str2;
        this.f6977e = adobeCSDKException;
        this.f6978f = str3;
        this.f6979g = adobeNetworkStatusCode;
    }

    @Override // java.lang.Runnable
    public void run() {
        AbstractC0618vb abstractC0618vb;
        Map<AbstractC0618vb, Jb> map = this.f6980h.x;
        if (map == null || !map.containsKey(this.f6973a) || (abstractC0618vb = this.f6973a) == null) {
            return;
        }
        if ("elementWasAdded".equals(this.f6974b)) {
            abstractC0618vb.a(this.f6975c, this.f6976d);
            return;
        }
        if ("elementWasRemoved".equals(this.f6974b)) {
            abstractC0618vb.b(this.f6975c, this.f6976d);
            return;
        }
        if ("elementWasUpdated".equals(this.f6974b)) {
            abstractC0618vb.c(this.f6975c, this.f6976d);
            return;
        }
        if ("onSyncError".equals(this.f6974b)) {
            abstractC0618vb.a(this.f6975c, this.f6977e);
            C0290t.a(this.f6977e);
            return;
        }
        if ("libraryWasAdded".equals(this.f6974b)) {
            abstractC0618vb.a(this.f6975c);
            return;
        }
        if ("libraryWasDeleted".equals(this.f6974b)) {
            abstractC0618vb.c(this.f6978f);
            return;
        }
        if ("libraryWasUnshared".equals(this.f6974b)) {
            abstractC0618vb.d(this.f6978f);
            return;
        }
        if ("libraryWasUpdated".equals(this.f6974b)) {
            abstractC0618vb.b(this.f6975c);
            return;
        }
        if ("syncStarted".equals(this.f6974b)) {
            abstractC0618vb.b();
            return;
        }
        if ("syncFinished".equals(this.f6974b)) {
            abstractC0618vb.a();
        } else if ("syncUnavailable".equals(this.f6974b)) {
            abstractC0618vb.b(this.f6979g);
        } else if ("syncAvailable".equals(this.f6974b)) {
            abstractC0618vb.a(this.f6979g);
        }
    }
}
