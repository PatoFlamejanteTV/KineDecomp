package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.C0582ma;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONObject;

/* compiled from: AdobeDesignLibraryUtilsInternal.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0288q {
    public static long a(C0622wb c0622wb) {
        return c0622wb.d();
    }

    public static String b(C0622wb c0622wb) {
        if (c0622wb.e() != null) {
            return c0622wb.e();
        }
        return c0622wb.c();
    }

    public static C0582ma c(C0622wb c0622wb, C0614ub c0614ub) {
        Hb a2;
        if (c0614ub == null || c0622wb == null || !(c0614ub instanceof F) || (a2 = c0622wb.a("rendition")) == null) {
            return null;
        }
        return new C0582ma(a2.n(), a2.e());
    }

    public static JSONObject a(C0622wb c0622wb, C0614ub c0614ub) {
        if (c0614ub == null || c0622wb == null || !c0622wb.j().equals("application/vnd.adobe.element.colortheme+dcx") || !(c0614ub instanceof F)) {
            return null;
        }
        Hb c2 = ((F) c0614ub).c(c0622wb);
        if (c2.m().compareTo("application/vnd.adobe.colortheme+json") != 0) {
            return null;
        }
        return (JSONObject) c2.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "colortheme");
    }

    public static C0582ma b(C0622wb c0622wb, C0614ub c0614ub) {
        if (c0614ub == null || c0622wb == null || !c0622wb.j().equals("application/vnd.adobe.element.image+dcx") || !(c0614ub instanceof F)) {
            return null;
        }
        Hb c2 = ((F) c0614ub).c(c0622wb);
        return new C0582ma(c2 != null ? c2.n() : 0, c2 == null ? 0 : c2.e());
    }
}
