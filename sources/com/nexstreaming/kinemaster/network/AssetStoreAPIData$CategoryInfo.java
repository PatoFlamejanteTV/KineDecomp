package com.nexstreaming.kinemaster.network;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class AssetStoreAPIData$CategoryInfo implements Serializable {
    public List<AssetStoreAPIData$LangString> categoryName;
    public String category_aliasName;
    public int category_idx;
    public String category_url;
    public String imagePath;
    public String imagePath_on;
    public List<AssetStoreAPIData$SubcategoryInfo> subcategory_info;
    public String view_type;
}
