package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* loaded from: classes.dex */
public class AdobeCCFilesEditAssetData {

    /* renamed from: a, reason: collision with root package name */
    public String f6025a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6026b = false;

    /* renamed from: c, reason: collision with root package name */
    public AdobeAssetFile f6027c;

    /* renamed from: d, reason: collision with root package name */
    EditStatus f6028d;

    /* loaded from: classes.dex */
    public enum EditStatus {
        Error,
        Completed
    }

    public AdobeCCFilesEditAssetData(String str, EditStatus editStatus) {
        this.f6025a = str;
        this.f6028d = editStatus;
    }

    public AdobeCCFilesEditAssetData(String str, AdobeAssetFile adobeAssetFile, EditStatus editStatus) {
        this.f6025a = str;
        this.f6027c = adobeAssetFile;
        this.f6028d = editStatus;
    }
}
