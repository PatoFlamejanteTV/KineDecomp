package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.net.AdobeNetworkHttpRequestMethod;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderByProperty;
import com.adobe.creativesdk.foundation.internal.storage.model.resources.AdobeStorageOrderRelation;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.lang.ref.WeakReference;
import java.net.URI;
import java.util.Date;

/* compiled from: AdobeAssetPackage.java */
/* loaded from: classes.dex */
public class Ya extends C0578la {
    private com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa p;
    private com.adobe.creativesdk.foundation.internal.storage.model.resources.e q;
    private boolean r;

    /* JADX INFO: Access modifiers changed from: protected */
    public Ya() {
        this.r = false;
    }

    public void b(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        this.r = false;
        a(vdVar, cVar);
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof Ya) {
            return super.equals(obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.storage.C0578la
    public com.adobe.creativesdk.foundation.internal.storage.model.resources.e g() {
        if (this.q == null) {
            this.q = com.adobe.creativesdk.foundation.internal.storage.model.resources.e.a(this.href);
            com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar = this.q;
            eVar.f6611c = this.name;
            eVar.f6609a = this.GUID;
            eVar.f6610b = this.href;
            eVar.f6613e = this.etag;
            eVar.a(getCloud());
        }
        return this.q;
    }

    @Deprecated
    public com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa h() {
        return this.p;
    }

    @Override // com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return super.hashCode();
    }

    public boolean i() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.storage.C0533a
    public void setCloud(AdobeCloud adobeCloud) {
        this.mCloud = adobeCloud;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Ya(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2) {
        this(eVar, eVar2 != null ? eVar2.j() : AdobeStorageOrderByProperty.ADOBE_STORAGE_ORDER_BY_NAME, eVar2 != null ? eVar2.i() : AdobeStorageOrderRelation.ADOBE_STORAGE_ORDER_ASCENDING, eVar2 != null ? eVar2.f6610b : null);
    }

    public void a(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        if (i()) {
            vdVar.a();
        } else {
            b(new Va(this, new WeakReference(this), vdVar), new Wa(this, cVar));
        }
    }

    void b(c.a.a.a.b<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Fa> bVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        com.adobe.creativesdk.foundation.internal.storage.model.resources.b bVar2 = new com.adobe.creativesdk.foundation.internal.storage.model.resources.b();
        bVar2.f6610b = URI.create(String.format("%s%s", this.href, "manifest"));
        com.adobe.creativesdk.foundation.internal.storage.a.b.ra session = getSession();
        if (session == null) {
            return;
        }
        session.a(session.a(bVar2, AdobeNetworkHttpRequestMethod.AdobeNetworkHttpRequestMethodGET, (String) null, false), (String) null, (byte[]) null, new Xa(this, new WeakReference(this), cVar, bVar));
    }

    protected Ya(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, AdobeStorageOrderByProperty adobeStorageOrderByProperty, AdobeStorageOrderRelation adobeStorageOrderRelation, URI uri) {
        Date date;
        this.q = eVar;
        this.GUID = eVar.f6609a;
        this.href = eVar.f6610b;
        this.etag = eVar.f6613e;
        this.name = eVar.f6611c;
        this.parentHref = uri;
        this.creationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(eVar.f6614f);
        this.modificationDate = com.adobe.creativesdk.foundation.internal.storage.model.util.i.b(eVar.f6615g);
        if (this.creationDate == null && (date = this.modificationDate) != null) {
            this.creationDate = date;
        }
        this.q.a(adobeStorageOrderByProperty);
        this.q.a(adobeStorageOrderRelation);
    }
}
