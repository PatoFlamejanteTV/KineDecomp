package com.facebook.internal;

import android.os.Bundle;
import com.facebook.internal.BundleJSONConverter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BundleJSONConverter.java */
/* loaded from: classes.dex */
final class d implements BundleJSONConverter.Setter {
    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnBundle(Bundle bundle, String str, Object obj) throws JSONException {
        bundle.putLong(str, ((Long) obj).longValue());
    }

    @Override // com.facebook.internal.BundleJSONConverter.Setter
    public void setOnJSON(JSONObject jSONObject, String str, Object obj) throws JSONException {
        jSONObject.put(str, obj);
    }
}
