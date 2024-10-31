package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.internal.net.F;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public class i implements F {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.adobe.creativesdk.foundation.internal.storage.model.resources.f f4015a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f4016b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f4017c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ t f4018d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(t tVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.f fVar, String str, v vVar) {
        this.f4018d = tVar;
        this.f4015a = fVar;
        this.f4016b = str;
        this.f4017c = vVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(com.adobe.creativesdk.foundation.internal.net.l lVar) {
        String str;
        String str2;
        String str3;
        int g2 = lVar.g();
        AdobeNetworkException adobeNetworkException = null;
        if (g2 >= 200 && g2 <= 300) {
            try {
                try {
                    this.f4015a.f6613e = (String) ((JSONObject) ((JSONObject) new JSONObject(lVar.d()).get("outputs")).get(this.f4016b)).opt("if-match");
                } catch (NullPointerException e2) {
                    Level level = Level.ERROR;
                    str3 = t.j;
                    com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, str3, "", e2);
                }
                this.f4017c.a((b) null);
                return;
            } catch (JSONException e3) {
                Level level2 = Level.ERROR;
                str2 = t.j;
                com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level2, str2, "", e3);
                this.f4017c.a(new AdobeNetworkException(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest));
                return;
            }
        }
        try {
            JSONObject jSONObject = (JSONObject) new JSONObject(lVar.d()).get("error-response");
            if (jSONObject != null) {
                String string = jSONObject.getString(ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
                adobeNetworkException = "bad_request".equalsIgnoreCase(jSONObject.getString("reason")) ? this.f4018d.a(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, string) : this.f4018d.a(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, string);
            }
        } catch (JSONException e4) {
            adobeNetworkException = this.f4018d.a(AdobeNetworkException.AdobeNetworkErrorCode.AdobeNetworkErrorBadRequest, "An unexpected response was returned");
            Level level3 = Level.ERROR;
            str = t.j;
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level3, str, "", e4);
        }
        this.f4017c.a(adobeNetworkException);
    }

    @Override // com.adobe.creativesdk.foundation.internal.net.F
    public void a(AdobeNetworkException adobeNetworkException) {
        this.f4017c.a(adobeNetworkException);
    }
}
