package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

/* compiled from: AdobeAssetLibraryItemStockImage.java */
@Deprecated
/* loaded from: classes.dex */
public class Ba extends C0629ya {
    private String n;
    private boolean o;
    private String p;
    private String q;

    /* JADX INFO: Access modifiers changed from: protected */
    public Ba(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, String str, AdobeAssetFile adobeAssetFile, int i, int i2, AdobeAssetFile adobeAssetFile2, int i3, int i4, String str2, C0590oa c0590oa) {
        super(ha, str, adobeAssetFile, i, i2, adobeAssetFile2, i3, i4, str2, c0590oa);
        a(ha);
    }

    private void a(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha) {
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2 = null;
        com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha3 = null;
        for (com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha4 : ha.d().c(ha)) {
            if (ha4.k().equals("application/vnd.adobe.library.link+dcx")) {
                String optString = ((JSONObject) ha4.a("adobestock#trackingdata")).optString(ServerProtocol.DIALOG_PARAM_STATE);
                if (optString != null && optString.equals("purchased")) {
                    this.o = true;
                    ha2 = ha4;
                } else if (optString != null && optString.equals("not_purchased")) {
                    this.q = (String) ha4.a("library#linkurl");
                    ha3 = ha4;
                } else {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetLibraryItemStockImage", String.format("Invalid purchase_state for stock asset: %s", optString));
                }
            }
        }
        if (ha2 == null) {
            ha2 = ha3;
        }
        this.p = (String) ha2.a("library#linktype");
        String str = (String) ha2.a("library#linkurl");
        if (str != null) {
            this.n = str;
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeAssetLibraryItemStockImage", String.format("Could not find external link for child: %s", ha2));
        }
    }
}
