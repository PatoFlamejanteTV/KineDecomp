package com.nexstreaming.app.general.nexasset.assetpackage;

import java.util.List;
import java.util.Map;

/* compiled from: ItemInfo.kt */
/* loaded from: classes2.dex */
public interface r {
    b getAssetPackage();

    ItemCategory getCategory();

    String getFilePath();

    String getIconPath();

    String getId();

    Map<String, String> getLabel();

    String getPackageURI();

    List<String> getRatios();

    String getSampleText();

    String getThumbPath();

    ItemType getType();

    boolean isHidden();
}
