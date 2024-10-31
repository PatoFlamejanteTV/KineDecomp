package com.adobe.creativesdk.foundation.storage;

import android.graphics.Color;
import com.facebook.share.internal.ShareConstants;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AdobeDesignLibraryUtils.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.eb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0551eb {
    public static Integer a(C0622wb c0622wb, C0614ub c0614ub) {
        List<Hb> i;
        JSONObject jSONObject;
        if (c0614ub != null && c0622wb != null && c0622wb.j().equals("application/vnd.adobe.element.color+dcx") && (i = c0622wb.i()) != null) {
            for (Hb hb : i) {
                if (hb.m().compareTo("application/vnd.adobe.color+json") == 0 && (jSONObject = (JSONObject) hb.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "color")) != null && "RGB".compareTo(jSONObject.optString("mode")) == 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONObject.opt("value");
                    return Integer.valueOf(Color.argb(255, jSONObject2.optInt("r"), jSONObject2.optInt("g"), jSONObject2.optInt("b")));
                }
            }
        }
        return 0;
    }
}
