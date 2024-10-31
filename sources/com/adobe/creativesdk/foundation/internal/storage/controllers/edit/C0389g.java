package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import java.util.HashMap;

/* compiled from: AdobeAssetViewEditActivityConfiguration.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0389g {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f6040a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private AdobeCloud f6041b;

    private C0389g(AdobeAssetViewEditActivityOperationMode adobeAssetViewEditActivityOperationMode) {
        this.f6040a.put("EDIT_ACTIVITY_OPERATION_MODE", adobeAssetViewEditActivityOperationMode);
    }

    public void a(String str) {
        this.f6040a.put("MULTI_SELECT_EDIT_TARGET_HREF", str);
    }

    public AdobeAssetViewEditActivityOperationMode b() {
        return (AdobeAssetViewEditActivityOperationMode) this.f6040a.get("EDIT_ACTIVITY_OPERATION_MODE");
    }

    public String c() {
        return (String) this.f6040a.get("MULTI_SELECT_EDIT_TARGET_HREF");
    }

    public static C0389g a(Bundle bundle) {
        C0389g c0389g = new C0389g((AdobeAssetViewEditActivityOperationMode) bundle.getSerializable("EDIT_ACTIVITY_OPERATION_MODE"));
        if (c0389g.b() == AdobeAssetViewEditActivityOperationMode.ADOBE_ASSET_VIEW_EDIT_ACTIVITY_OPERATION_MODE_MULTI_SELECT_EDIT) {
            c0389g.a(bundle.getString("MULTI_SELECT_EDIT_TARGET_HREF"));
        }
        AdobeCloud adobeCloud = (AdobeCloud) bundle.getSerializable("ADOBE_CLOUD");
        if (adobeCloud != null) {
            c0389g.a(com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().b(adobeCloud));
        }
        return c0389g;
    }

    public AdobeCloud a() {
        return this.f6041b;
    }

    public void a(AdobeCloud adobeCloud) {
        this.f6041b = adobeCloud;
    }
}
