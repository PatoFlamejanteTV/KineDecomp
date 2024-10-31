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
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0396n implements wa {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0533a f6053a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f6054b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0399q f6055c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0396n(C0399q c0399q, C0533a c0533a, int i) {
        this.f6055c = c0399q;
        this.f6053a = c0533a;
        this.f6054b = i;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void a(AdobeAssetException adobeAssetException) {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        C0533a c0533a = this.f6053a;
        if (c0533a instanceof AdobeAssetFile) {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) this.f6053a, AdobeCCFilesEditAssetData.EditStatus.Error);
        } else {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Error);
        }
        this.f6055c.a(adobeCCFilesEditAssetData);
        C0399q c0399q = this.f6055c;
        c0399q.f6065f++;
        if (c0399q.f6065f == this.f6054b) {
            C0394l.a(false);
            this.f6055c.f6061b.onComplete();
        }
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.a.b.wa
    public void onComplete() {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        this.f6055c.f6065f++;
        HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditSession$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                put("area", "operations");
                put(NativeProtocol.WEB_DIALOG_ACTION, "move");
                put("assetName", C0396n.this.f6053a.getName());
                put("assetID", C0396n.this.f6053a.getGUID());
            }
        };
        C0533a c0533a = this.f6053a;
        if (c0533a instanceof AdobeAssetFile) {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) this.f6053a, AdobeCCFilesEditAssetData.EditStatus.Completed);
            hashMap.put("type", "file");
            com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.moveFile", hashMap, null);
        } else {
            adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Completed);
            hashMap.put("type", "folder");
            com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.moveFolder", hashMap, null);
        }
        this.f6055c.a(adobeCCFilesEditAssetData);
        C0399q c0399q = this.f6055c;
        int i = c0399q.f6065f;
        int i2 = this.f6054b;
        if (i == i2) {
            C0394l.a(false);
            this.f6055c.f6061b.onComplete();
            return;
        }
        double d2 = i;
        double d3 = i2;
        Double.isNaN(d2);
        Double.isNaN(d3);
        c0399q.f6061b.a(d2 / d3);
    }
}
