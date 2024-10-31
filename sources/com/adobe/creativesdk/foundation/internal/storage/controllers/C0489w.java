package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;

/* compiled from: AdobeMobilePackageCollectionConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.w */
/* loaded from: classes.dex */
public class C0489w extends C0474t {

    /* renamed from: h */
    private String f6514h;
    private String i;
    private String j;

    @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.C0474t
    public void a(Bundle bundle) {
        super.a(bundle);
        this.f6514h = (String) bundle.get("mobilePackageCollectionHref");
        this.i = (String) bundle.get("mobilePackageCollectionParentHref");
        this.j = (String) bundle.get("mobilePackageCollectionModifiedDate");
    }

    public String h() {
        return this.f6514h;
    }

    public String i() {
        return this.j;
    }

    public String j() {
        return this.i;
    }
}
