package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.auth.AdobeAuthException;
import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
public class g implements AdobeAuthSessionHelper.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f20433a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(p pVar) {
        this.f20433a = pVar;
    }

    @Override // com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper.a
    public void a(AdobeAuthSessionHelper.AdobeAuthStatus adobeAuthStatus, AdobeAuthException adobeAuthException) {
        com.adobe.creativesdk.foundation.auth.k kVar;
        kVar = this.f20433a.i;
        if (!kVar.c()) {
            this.f20433a.f();
        }
        int i = o.f20446a[adobeAuthStatus.ordinal()];
        if (i == 1) {
            p pVar = this.f20433a;
            pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
            pVar.f20419c.a("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_SUCCESS, KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN);
            return;
        }
        if (i == 2) {
            p pVar2 = this.f20433a;
            pVar2.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT;
            pVar2.f20419c.b("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_LOGIN_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT);
        } else if (i == 3) {
            p pVar3 = this.f20433a;
            pVar3.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT;
            pVar3.f20419c.a("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_SUCCESS, KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_OUT);
        } else {
            if (i != 4) {
                return;
            }
            p pVar4 = this.f20433a;
            pVar4.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
            pVar4.f20419c.b("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_LOGOUT_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN);
        }
    }
}
