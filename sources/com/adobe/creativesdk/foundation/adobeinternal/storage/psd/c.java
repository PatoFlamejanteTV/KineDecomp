package com.adobe.creativesdk.foundation.adobeinternal.storage.psd;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePSDPreviewLayerNode.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private String f4679a;

    /* renamed from: b */
    private int f4680b;

    /* renamed from: c */
    private AdobePSDPreviewLayerNodeType f4681c;

    /* renamed from: d */
    private AdobePSDPreviewContentLayerClass f4682d;

    /* renamed from: e */
    private boolean f4683e;

    /* renamed from: f */
    private int f4684f;

    /* renamed from: g */
    private h f4685g;

    /* renamed from: h */
    private ArrayList<c> f4686h;
    private boolean i;
    private boolean j;
    private JSONObject k;
    private ArrayList<c> l;

    public c(JSONObject jSONObject, int i, ArrayList<c> arrayList) {
        if (jSONObject != null) {
            try {
                this.l = arrayList;
                this.f4686h = arrayList;
                this.f4679a = jSONObject.getString("layerName");
                this.f4680b = jSONObject.getInt("layerId");
                this.f4684f = i;
                String string = jSONObject.getString("type");
                if (string.equals("layer")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypePixelsLayer;
                } else if (string.equals("textLayer")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeTextLayer;
                } else if (string.equals("layerSection")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeLayerGroup;
                } else if (string.equals("contentLayer")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeContentLayer;
                } else if (string.equals("backgroundLayer")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeBackgroundLayer;
                } else if (string.equals("adjustmentLayer")) {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeAdjustmentLayer;
                } else {
                    this.f4681c = AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeUnknown;
                }
                if (this.f4681c == AdobePSDPreviewLayerNodeType.AdobePSDPreviewLayerNodeTypeContentLayer) {
                    String string2 = jSONObject.getJSONObject("properties").getString("class");
                    if (string2.equals("solidColorLayer")) {
                        this.f4682d = AdobePSDPreviewContentLayerClass.AdobePSDPreviewContentLayerClassSolidColorFill;
                    } else if (string2.equals("gradientLayer")) {
                        this.f4682d = AdobePSDPreviewContentLayerClass.AdobePSDPreviewContentLayerClassGradientFill;
                    } else if (string2.equals("patternLayer")) {
                        this.f4682d = AdobePSDPreviewContentLayerClass.AdobePSDPreviewContentLayerClassPatternFill;
                    } else {
                        this.f4682d = AdobePSDPreviewContentLayerClass.AdobePSDPreviewContentLayerClassUnknown;
                    }
                }
                if (jSONObject.has("visible")) {
                    this.f4683e = jSONObject.getBoolean("visible");
                }
                if (jSONObject.has("hasPixelMask")) {
                    this.i = jSONObject.getBoolean("hasPixelMask");
                }
                if (jSONObject.has("pixelMaskEnabled")) {
                    this.j = jSONObject.getBoolean("pixelMaskEnabled");
                }
                if (jSONObject.has("bounds")) {
                    this.f4685g = d.a(jSONObject.getJSONObject("bounds"));
                }
                if (jSONObject.has("properties") && jSONObject.getJSONObject("properties").has("color")) {
                    this.k = jSONObject.getJSONObject("properties").getJSONObject("color");
                }
            } catch (JSONException unused) {
            }
        }
    }
}
