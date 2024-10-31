package com.nexstreaming.kinemaster.usage;

import com.facebook.GraphResponse;

/* loaded from: classes2.dex */
public enum AssetDownloadResult {
    SUCCESS(GraphResponse.SUCCESS_KEY),
    FAIL("fail"),
    PURCHASE_SUCCESS("purchase_success"),
    PURCHASE_FAIL("purchase_fail"),
    PURCHASE_CANCEL("purchase_cancel"),
    DOWNLOAD_CANCEL("download_cancel"),
    DOWNLOAD_FAIL("download_fail");

    String mResult;

    AssetDownloadResult(String str) {
        this.mResult = str;
    }

    public String getValue() {
        return this.mResult;
    }
}
