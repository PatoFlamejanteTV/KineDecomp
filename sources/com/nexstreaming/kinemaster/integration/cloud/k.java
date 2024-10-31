package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.storage.C0578la;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
public class k implements b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20440a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f20441b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(p pVar, String str) {
        this.f20441b = pVar;
        this.f20440a = str;
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.b
    public void a(Boolean bool) {
        C0578la c0578la;
        if (bool.booleanValue()) {
            p pVar = this.f20441b;
            c0578la = pVar.k;
            pVar.a(c0578la, new j(this));
            return;
        }
        this.f20441b.c(this.f20440a);
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.b
    public void onFailure() {
        p pVar = this.f20441b;
        pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER;
        pVar.f20419c.b("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFOLDER_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER);
    }
}
