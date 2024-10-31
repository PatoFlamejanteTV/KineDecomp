package com.nexstreaming.app.general.nexasset.assetpackage;

import java.io.File;
import java.util.Map;

/* compiled from: AssetInfo.kt */
/* loaded from: classes2.dex */
public interface b {
    String getAssetId();

    int getAssetIdx();

    Map<String, String> getAssetName();

    int getAssetSize();

    p getAssetSubCategory();

    String getAssetUrl();

    int getAssetVersion();

    InstallSourceType getInstallSourceType();

    File getLocalPath();

    String getPackageURI();

    String getPriceType();

    String getThumbPath();

    String getThumbUrl();

    boolean hasUpdate();
}
