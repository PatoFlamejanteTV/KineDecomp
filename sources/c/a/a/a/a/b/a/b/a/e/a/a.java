package c.a.a.a.a.b.a.b.a.e.a;

import c.a.a.a.a.b.a.b.a.e.b.d;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Hb;
import com.facebook.share.internal.ShareConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ACColorThemeAssetHelper.java */
/* loaded from: classes.dex */
public class a {
    public static d a(C0614ub c0614ub, C0622wb c0622wb) {
        Hb a2 = c0614ub.a("application/vnd.adobe.colortheme+json", c0622wb);
        if (a2 == null) {
            return null;
        }
        return a((JSONObject) a2.a(ShareConstants.WEB_DIALOG_PARAM_DATA, "colortheme"));
    }

    protected static int a(JSONArray jSONArray) {
        if (jSONArray.length() > 0 && jSONArray.optJSONArray(0).length() > 0) {
            for (int i = 0; i < jSONArray.optJSONArray(0).length(); i++) {
                String optString = jSONArray.optJSONArray(0).optJSONObject(i).optString("mode");
                if (optString.equals("RGB") || optString.equals("rgb")) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static d a(JSONObject jSONObject) {
        d dVar = new d();
        JSONArray optJSONArray = jSONObject.optJSONArray("swatches");
        int a2 = a(optJSONArray);
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                double optDouble = optJSONArray.optJSONArray(i).optJSONObject(a2).optJSONObject("value").optDouble("r");
                double optDouble2 = optJSONArray.optJSONArray(i).optJSONObject(a2).optJSONObject("value").optDouble("g");
                double optDouble3 = optJSONArray.optJSONArray(i).optJSONObject(a2).optJSONObject("value").optDouble("b");
                c.a.a.a.a.b.a.b.a.e.b.a aVar = new c.a.a.a.a.b.a.b.a.e.b.a();
                aVar.a(optDouble, optDouble2, optDouble3);
                dVar.f3444a.add(aVar);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("tags");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                dVar.f3445b.add(i2, optJSONArray2.opt(i2).toString());
            }
        }
        try {
            dVar.f3446c = jSONObject.getInt("baseSwatchIndex");
        } catch (JSONException unused) {
            dVar.f3446c = 2;
        }
        return dVar;
    }
}
