package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloudServiceType;
import java.net.URI;
import java.util.Date;
import org.json.JSONObject;

/* compiled from: AdobeAsset.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.a */
/* loaded from: classes.dex */
public class C0533a extends com.adobe.creativesdk.foundation.internal.storage.asset.c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected String GUID;
    protected Date creationDate;
    protected String etag;
    protected URI href;
    protected JSONObject links;
    protected Date modificationDate;
    protected String name;
    protected URI parentHref;

    public C0533a() {
        this.mCloud = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
    }

    public static String getValidatedAssetName(String str) {
        if (com.adobe.creativesdk.foundation.internal.storage.model.resources.f.f(str)) {
            return com.adobe.creativesdk.foundation.internal.storage.model.resources.f.a(str);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0533a)) {
            return false;
        }
        C0533a c0533a = (C0533a) obj;
        String str = this.GUID;
        if (str != null) {
            return str.equals(c0533a.getGUID());
        }
        return false;
    }

    public Date getCreationDate() {
        Date date = this.creationDate;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getGUID() {
        return this.GUID;
    }

    public URI getHref() {
        return this.href;
    }

    public JSONObject getLinks() {
        return this.links;
    }

    public Date getModificationDate() {
        Date date = this.modificationDate;
        if (date != null) {
            return new Date(date.getTime());
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public URI getParentHref() {
        return this.parentHref;
    }

    public com.adobe.creativesdk.foundation.internal.storage.a.b.ra getSession() {
        AdobeCloud adobeCloud = this.mCloud;
        if (adobeCloud != null) {
            return (com.adobe.creativesdk.foundation.internal.storage.a.b.ra) adobeCloud.getSessionForService(AdobeCloudServiceType.AdobeCloudServiceTypeStorage);
        }
        return null;
    }

    public int hashCode() {
        return 42;
    }

    public void setCloud(AdobeCloud adobeCloud) {
        this.mCloud = adobeCloud;
    }

    protected void setCreationDate(Date date) {
        this.creationDate = date;
    }

    protected void setEtag(String str) {
        this.etag = str;
    }

    protected void setGUID(String str) {
        this.GUID = str;
    }

    protected void setHref(URI uri) {
        this.href = uri;
    }

    protected void setModificationDate(Date date) {
        this.modificationDate = date;
    }

    protected void setName(String str) {
        this.name = str;
    }

    protected void setParentHref(URI uri) {
        this.parentHref = uri;
    }
}
