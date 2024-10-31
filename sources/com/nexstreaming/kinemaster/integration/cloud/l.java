package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.storage.C0578la;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
public class l implements c.a.a.a.b<C0578la> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f20442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(p pVar) {
        this.f20442a = pVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(C0578la c0578la) {
        this.f20442a.k = c0578la;
        p pVar = this.f20442a;
        pVar.f20418b = KMCloud.KMCloudState.KM_CLOUD_STATE_LOGGED_IN;
        pVar.f20419c.a("Adobe Creative Cloud", KMCloud.KMCloudReturnValue.KM_CLOUD_RETURN_SUCCESS, KMCloud.KMCloudState.KM_CLOUD_STATE_CREATED_FOLDER);
    }
}
