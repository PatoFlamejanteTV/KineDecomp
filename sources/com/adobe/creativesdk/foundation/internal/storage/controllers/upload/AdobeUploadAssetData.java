package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.graphics.Bitmap;
import com.adobe.creativesdk.foundation.internal.storage.C0330a;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFileRenditionType;
import com.adobe.creativesdk.foundation.storage.C0582ma;
import java.net.URL;

/* loaded from: classes.dex */
public class AdobeUploadAssetData extends C0330a {
    private AdobeFileUploadType j;
    public URL l;
    private String o;
    public AdobeAssetFileRenditionType p;
    public C0582ma r;
    public Bitmap k = null;
    public String q = null;
    private UploadStatus m = UploadStatus.YetToStart;
    private double n = 0.0d;

    /* loaded from: classes.dex */
    public enum UploadStatus {
        YetToStart,
        Started,
        InProgress,
        Error,
        Cancelled,
        Completed,
        StorageFull
    }

    public AdobeUploadAssetData() {
        a(AdobeFileUploadType.ADOBE_UPLOAD_DATA_TYPE_PATH);
    }

    public void a(AdobeFileUploadType adobeFileUploadType) {
        this.j = adobeFileUploadType;
    }

    public String b() {
        return this.o;
    }

    public double c() {
        return this.n;
    }

    public UploadStatus d() {
        return this.m;
    }

    public boolean e() {
        UploadStatus uploadStatus = this.m;
        if (uploadStatus != UploadStatus.Cancelled && uploadStatus != UploadStatus.Completed && uploadStatus != UploadStatus.Error) {
            UploadStatus uploadStatus2 = UploadStatus.Cancelled;
            if (uploadStatus != UploadStatus.StorageFull) {
                return false;
            }
        }
        return true;
    }

    public URL a() {
        return this.l;
    }
}
