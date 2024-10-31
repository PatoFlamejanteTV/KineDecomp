package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
class m implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f20443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(p pVar) {
        this.f20443a = pVar;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        p pVar = this.f20443a;
        pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
        pVar.f20419c.b("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFOLDER_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER);
    }
}
