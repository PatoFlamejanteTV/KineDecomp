package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Hb;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobeLibraryAnalyticsOperation.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0289s {

    /* renamed from: a, reason: collision with root package name */
    private String f4655a;

    /* renamed from: b, reason: collision with root package name */
    private C0614ub f4656b;

    /* renamed from: c, reason: collision with root package name */
    private C0622wb f4657c;

    /* renamed from: d, reason: collision with root package name */
    private String f4658d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f4659e = null;

    /* renamed from: f, reason: collision with root package name */
    boolean f4660f = true;

    public C0289s(String str, C0614ub c0614ub, C0622wb c0622wb, String str2) {
        this.f4655a = str;
        this.f4656b = c0614ub;
        this.f4657c = c0622wb;
        this.f4658d = str2;
    }

    public void a(AdobeCSDKException adobeCSDKException) {
        C0622wb c0622wb;
        Hb h2;
        String jSONObject;
        if (this.f4660f) {
            if (this.f4656b != null && (c0622wb = this.f4657c) != null && (h2 = c0622wb.h()) != null) {
                this.f4659e = new JSONObject();
                try {
                    this.f4659e.put("elementPrimaryType", h2.m());
                } catch (JSONException e2) {
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0289s.class.getSimpleName(), null, e2);
                }
                JSONObject l = h2.l();
                if (l.length() > 0 && (jSONObject = l.toString()) != null) {
                    try {
                        this.f4659e.put("trackingData", jSONObject);
                    } catch (JSONException e3) {
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, C0289s.class.getSimpleName(), null, e3);
                    }
                }
            }
            String str = this.f4658d;
            if (str == null || str.equals("primary")) {
                C0290t.a(this.f4655a, this.f4656b, this.f4657c, null, this.f4659e, adobeCSDKException);
            }
        }
    }
}
