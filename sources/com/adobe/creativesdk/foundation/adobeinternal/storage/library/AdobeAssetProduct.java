package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

/* loaded from: classes.dex */
public enum AdobeAssetProduct {
    AdobeAssetProductUndefined(0),
    AdobeAssetProductDraw(1),
    AdobeAssetProductLibrary(2),
    AdobeAssetProductLine(3),
    AdobeAssetProductSketch(4),
    AdobeAssetProductPSMix(5),
    AdobeAssetProductPSFix(6),
    AdobeAssetProductComposition(7);

    private int _productType;

    AdobeAssetProduct(int i) {
        this._productType = i;
    }

    public int getProductType() {
        return this._productType;
    }
}
