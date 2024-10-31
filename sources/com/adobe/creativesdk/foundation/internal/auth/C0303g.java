package com.adobe.creativesdk.foundation.internal.auth;

import android.support.v4.app.NotificationCompat;
import com.facebook.internal.ServerProtocol;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0303g implements c.a.a.a.b<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f4885a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeAuthIdentityManagementService f4886b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0303g(AdobeAuthIdentityManagementService adobeAuthIdentityManagementService, c.a.a.a.b bVar) {
        this.f4886b = adobeAuthIdentityManagementService;
        this.f4885a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(JSONObject jSONObject) {
        if (jSONObject.optString("userId", null) != null) {
            this.f4886b.b(jSONObject.optString("userId"));
            this.f4886b.s(jSONObject.optBoolean("isEnterprise") ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
            if (jSONObject.optString("displayName", null) != null) {
                this.f4886b.m(jSONObject.optString("displayName"));
            }
            if (jSONObject.optString("first_name", null) != null) {
                this.f4886b.q(jSONObject.optString("first_name"));
            }
            if (jSONObject.optString("last_name", null) != null) {
                this.f4886b.t(jSONObject.optString("last_name"));
            }
            if (jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null) != null) {
                this.f4886b.n(jSONObject.optString(NotificationCompat.CATEGORY_EMAIL));
            }
            if (jSONObject.optString("emailVerified", null) != null) {
                this.f4886b.o(jSONObject.optString("emailVerified"));
            }
            if (jSONObject.optString("countryCode") != null) {
                this.f4886b.i(jSONObject.optString("countryCode"));
            }
            c.a.a.a.b bVar = this.f4885a;
            if (bVar != null) {
                bVar.b(jSONObject);
                return;
            }
            return;
        }
        throw new RuntimeException("User profile information not properly constructed from CC\n" + com.adobe.creativesdk.foundation.internal.utils.logging.c.a(jSONObject));
    }
}
