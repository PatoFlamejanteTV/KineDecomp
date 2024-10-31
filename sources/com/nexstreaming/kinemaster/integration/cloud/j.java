package com.nexstreaming.kinemaster.integration.cloud;

import com.nexstreaming.kinemaster.integration.cloud.KMCloud;
import java.util.List;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
class j implements c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f20439a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f20439a = kVar;
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.c
    public void a(List<? extends KMCloud.a> list) {
        this.f20439a.f20441b.a((List<? extends KMCloud.a>) list);
        p pVar = this.f20439a.f20441b;
        pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER;
        pVar.f20419c.a("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_SUCCESS, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER);
    }

    @Override // com.nexstreaming.kinemaster.integration.cloud.c
    public void onFailure() {
        p pVar = this.f20439a.f20441b;
        pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER;
        pVar.f20419c.b("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_CREATEFOLDER_FAILED, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER);
    }
}
