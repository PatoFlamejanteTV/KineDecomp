package com.adobe.creativesdk.foundation.adobeinternal.storage.psd;

import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdobePSDPreview.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    String f4672a;

    /* renamed from: b, reason: collision with root package name */
    h f4673b;

    /* renamed from: c, reason: collision with root package name */
    int f4674c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<b> f4675d;

    /* renamed from: e, reason: collision with root package name */
    private ArrayList<c> f4676e;

    private a(JSONObject jSONObject, String str) {
        this.f4672a = str;
        if (jSONObject != null) {
            try {
                this.f4673b = d.a(jSONObject.getJSONObject("imgdata").getJSONObject("bounds"));
                this.f4674c = jSONObject.getJSONObject("imgdata").getInt("appliedLayerCompId");
                ArrayList<b> arrayList = new ArrayList<>();
                JSONArray jSONArray = jSONObject.getJSONArray("layerComps");
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new b(jSONArray.getJSONObject(i)));
                }
                this.f4675d = arrayList;
                JSONArray jSONArray2 = jSONObject.getJSONArray("children");
                ArrayList<c> arrayList2 = new ArrayList<>(jSONArray2.length());
                int i2 = 0;
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    i2 = a(jSONArray2.getJSONObject(i3), i2, arrayList2);
                }
                this.f4676e = arrayList2;
            } catch (JSONException unused) {
            }
        }
    }

    public static a a(String str, String str2) throws AdobeDCXException {
        JSONObject jSONObject;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            jSONObject = new JSONObject(org.apache.commons.io.d.c(fileInputStream));
            try {
                fileInputStream.close();
            } catch (FileNotFoundException | IOException | JSONException unused) {
            }
        } catch (FileNotFoundException | IOException | JSONException unused2) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return new a(jSONObject, str2);
        }
        return null;
    }

    private int a(JSONObject jSONObject, int i, ArrayList<c> arrayList) {
        int i2 = i + 1;
        ArrayList<c> arrayList2 = null;
        try {
            if (jSONObject.getString("type").equals("layerSection")) {
                JSONArray jSONArray = jSONObject.getJSONArray("children");
                ArrayList<c> arrayList3 = new ArrayList<>();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    try {
                        i2 = a(jSONArray.getJSONObject(i3), i2, arrayList3);
                    } catch (JSONException e2) {
                        e = e2;
                        arrayList2 = arrayList3;
                        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "AdobePSDPreview.recursivelyAddLayerNodeFromDict", e.getMessage());
                        arrayList.add(new c(jSONObject, i, arrayList2));
                        return i2;
                    }
                }
                arrayList2 = arrayList3;
            }
        } catch (JSONException e3) {
            e = e3;
        }
        arrayList.add(new c(jSONObject, i, arrayList2));
        return i2;
    }
}
