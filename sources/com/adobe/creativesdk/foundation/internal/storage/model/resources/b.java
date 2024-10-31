package com.adobe.creativesdk.foundation.internal.storage.model.resources;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationRoleType;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import java.net.URI;
import org.json.JSONObject;

/* compiled from: AdobeStorageResource.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public String f6609a;

    /* renamed from: b */
    public URI f6610b;

    /* renamed from: c */
    public String f6611c;

    /* renamed from: d */
    public String f6612d;

    /* renamed from: e */
    public String f6613e;

    /* renamed from: f */
    public String f6614f;

    /* renamed from: g */
    public String f6615g;

    /* renamed from: h */
    public boolean f6616h;
    public long i;
    public JSONObject j;
    public AdobeCollaborationType k;
    public AdobeCollaborationRoleType l;
    protected AdobeCloud m;

    public b() {
        this.k = AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
        this.l = AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_OWNER;
    }

    public AdobeCloud a() {
        if (this.m == null) {
            this.m = com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c();
        }
        return this.m;
    }

    public boolean b() {
        return this.l == AdobeCollaborationRoleType.ADOBE_COLLABORATION_ROLE_TYPE_VIEWER;
    }

    public boolean c() {
        return this.k != AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_PRIVATE;
    }

    public b(b bVar) {
        URI uri = bVar.f6610b;
        if (uri != null) {
            this.f6610b = URI.create(uri.toString());
        }
        this.f6611c = bVar.f6611c;
        this.f6612d = bVar.f6612d;
        this.f6613e = bVar.f6613e;
        this.f6614f = bVar.f6614f;
        this.f6615g = bVar.f6615g;
        this.f6616h = bVar.f6616h;
        this.i = bVar.i;
        this.k = bVar.k;
        this.m = bVar.m;
        this.l = bVar.l;
    }

    public void a(AdobeCloud adobeCloud) {
        this.m = adobeCloud;
    }
}
