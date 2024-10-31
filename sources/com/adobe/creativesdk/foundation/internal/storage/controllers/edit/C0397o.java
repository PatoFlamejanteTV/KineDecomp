package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.internal.storage.a.b.wa;
import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditAssetData;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCCFilesEditSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0397o implements wa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0533a f6056a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6057b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0399q f6058c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0397o(C0399q c0399q, C0533a c0533a, int i) {
        this.f6058c = c0399q;
        this.f6056a = c0533a;
        this.f6057b = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void a(AdobeAssetException adobeAssetException) {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        this.f6058c.f6065f++;
        C0533a c0533a = this.f6056a;
        if (c0533a instanceof AdobeAssetFile) {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) this.f6056a, AdobeCCFilesEditAssetData.EditStatus.Error);
        } else {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Error);
        }
        this.f6058c.a(adobeCCFilesEditAssetData);
        if (!com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b()) {
            C0394l.a(false);
            this.f6058c.f6061b.a();
        } else if (this.f6058c.f6065f == this.f6057b) {
            C0394l.a(false);
            this.f6058c.f6061b.onComplete();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void onComplete() {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        this.f6058c.f6065f++;
        HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditSession$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "operations");
                put(NativeProtocol.WEB_DIALOG_ACTION, "delete");
                put("assetName", C0397o.this.f6056a.getName());
                put("assetID", C0397o.this.f6056a.getGUID());
            }
        };
        C0533a c0533a = this.f6056a;
        if (c0533a instanceof AdobeAssetFile) {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) this.f6056a, AdobeCCFilesEditAssetData.EditStatus.Completed);
            hashMap.put("type", "file");
            com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.deleteFile", hashMap, null);
        } else {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Completed);
            hashMap.put("type", "folder");
            com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.deleteFolder", hashMap, null);
        }
        this.f6058c.a(adobeCCFilesEditAssetData);
        C0399q c0399q = this.f6058c;
        int i = c0399q.f6065f;
        int i2 = this.f6057b;
        if (i == i2) {
            C0394l.a(false);
            this.f6058c.f6061b.onComplete();
            return;
        }
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        c0399q.f6061b.a(d2 / d3);
    }
}
