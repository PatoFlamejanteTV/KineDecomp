package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditAssetData;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.C0533a;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCCFilesEditSession.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0395m implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0533a f6051a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ C0399q f6052b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0395m(C0399q c0399q, C0533a c0533a) {
        this.f6052b = c0399q;
        this.f6051a = c0533a;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData;
        AdobeCCFilesEditAssetData adobeCCFilesEditAssetData2;
        AdobeCCFilesEditRenameOperationStatus adobeCCFilesEditRenameOperationStatus = (AdobeCCFilesEditRenameOperationStatus) obj;
        if (adobeCCFilesEditRenameOperationStatus == AdobeCCFilesEditRenameOperationStatus.ADOBE_CC_FILES_EDIT_RENAME_OPERATION_STATUS_COMPLETED) {
            HashMap<String, String> hashMap = new HashMap<String, String>() { // from class: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.AdobeCCFilesEditSession$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    put("area", "operations");
                    put(NativeProtocol.WEB_DIALOG_ACTION, "rename");
                    put("assetName", C0395m.this.f6051a.getName());
                    put("assetID", C0395m.this.f6051a.getGUID());
                }
            };
            C0533a c0533a = this.f6051a;
            if (c0533a instanceof AdobeAssetFile) {
                adobeCCFilesEditAssetData2 = new AdobeCCFilesEditAssetData(c0533a.getName(), (AdobeAssetFile) this.f6051a, AdobeCCFilesEditAssetData.EditStatus.Completed);
                hashMap.put("type", "file");
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.renameFile", hashMap, null);
            } else {
                adobeCCFilesEditAssetData2 = new AdobeCCFilesEditAssetData(c0533a.getName(), AdobeCCFilesEditAssetData.EditStatus.Completed);
                hashMap.put("type", "folder");
                com.adobe.creativesdk.foundation.internal.analytics.q.a("mobile.ccmobile.renameFolder", hashMap, null);
            }
            this.f6052b.c();
            this.f6052b.a(adobeCCFilesEditAssetData2);
            C0394l.a(false);
            this.f6052b.f6061b.onComplete();
            return;
        }
        if (adobeCCFilesEditRenameOperationStatus == AdobeCCFilesEditRenameOperationStatus.ADOBE_CC_FILES_EDIT_RENAME_OPERATION_STATUS_FAILED) {
            C0533a c0533a2 = this.f6051a;
            if (c0533a2 instanceof AdobeAssetFile) {
                adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a2.getName(), (AdobeAssetFile) this.f6051a, AdobeCCFilesEditAssetData.EditStatus.Error);
            } else {
                adobeCCFilesEditAssetData = new AdobeCCFilesEditAssetData(c0533a2.getName(), AdobeCCFilesEditAssetData.EditStatus.Error);
            }
            this.f6052b.c();
            this.f6052b.a(adobeCCFilesEditAssetData);
            C0394l.a(false);
            this.f6052b.f6061b.onComplete();
            return;
        }
        this.f6052b.f6061b.a();
    }
}
