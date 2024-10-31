package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import java.util.HashMap;

/* compiled from: AdobeOneUpViewerController.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    protected HashMap<String, b> f5766a = new HashMap<>();

    /* renamed from: b */
    private String f5767b;

    public b a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return this.f5766a.get(str);
    }

    public void b(String str) {
        this.f5767b = str;
    }

    public void a(f fVar) {
        this.f5766a.put("ADOBE_ONE_UP_VIEW_ASSET_CONFIGURATION", fVar);
    }

    public void a(i iVar) {
        this.f5766a.put("ADOBE_ONE_UP_VIEW_PHOTO_CONFIGURATION", iVar);
    }

    public void a(g gVar) {
        this.f5766a.put("ADOBE_ONE_UP_VIEW_LIBRARY_CONFIGURATION", gVar);
    }

    public void a(h hVar) {
        this.f5766a.put("ADOBE_ONE_UP_VIEW_MOBILE_CREATION_CONFIGURATION", hVar);
    }

    public String a() {
        return this.f5767b;
    }
}
