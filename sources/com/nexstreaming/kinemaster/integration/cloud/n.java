package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.sd;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.integration.cloud.KMCloud;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
class n implements sd<AdobeAssetFile, AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f20444a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f20445b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(p pVar, Task task) {
        this.f20445b = pVar;
        this.f20444a = task;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(AdobeAssetFile adobeAssetFile) {
        this.f20444a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        this.f20444a.sendFailure(KMCloud.CloudError.UPLOADING_ERROR);
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        this.f20444a.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
        this.f20444a.setProgress((int) d2, 100);
    }
}
