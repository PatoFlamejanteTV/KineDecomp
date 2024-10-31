package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class an implements zzdk {
    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        PackageManager packageManager = zzizVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject(map.get(ShareConstants.WEB_DIALOG_PARAM_DATA)).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString(ShareConstants.WEB_DIALOG_PARAM_ID);
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        Intent intent = new Intent();
                        if (!TextUtils.isEmpty(optString2)) {
                            intent.setData(Uri.parse(optString2));
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            intent.setAction(optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            intent.setType(optString4);
                        }
                        if (!TextUtils.isEmpty(optString5)) {
                            intent.setPackage(optString5);
                        }
                        if (!TextUtils.isEmpty(optString6)) {
                            String[] split = optString6.split("/", 2);
                            if (split.length == 2) {
                                intent.setComponent(new ComponentName(split[0], split[1]));
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != null);
                        } catch (JSONException e) {
                            com.google.android.gms.ads.internal.util.client.zzb.b("Error constructing openable urls response.", e);
                        }
                    } catch (JSONException e2) {
                        com.google.android.gms.ads.internal.util.client.zzb.b("Error parsing the intent data.", e2);
                    }
                }
                zzizVar.zzb("openableIntents", jSONObject);
            } catch (JSONException e3) {
                zzizVar.zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException e4) {
            zzizVar.zzb("openableIntents", new JSONObject());
        }
    }
}
