package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0590oa;
import com.adobe.creativesdk.foundation.storage.C0605sa;
import org.json.JSONObject;

/* compiled from: AdobeAssetLibraryItemCharacterStyle.java */
@Deprecated
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0272a extends C0605sa {

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f4576g;

    /* renamed from: h, reason: collision with root package name */
    private AdobeAssetFile f4577h;
    private float i;
    private float j;

    public C0272a(Ha ha, String str, JSONObject jSONObject, AdobeAssetFile adobeAssetFile, int i, int i2, C0590oa c0590oa) {
        super(ha, str, c0590oa);
        this.f4576g = jSONObject;
        this.f4577h = adobeAssetFile;
        this.i = i;
        this.j = i2;
    }
}
