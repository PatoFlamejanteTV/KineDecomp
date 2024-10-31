package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
final class ad implements OpenGraphJSONUtility.PhotoJSONProcessor {
    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        Uri imageUrl = sharePhoto.getImageUrl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", imageUrl.toString());
            return jSONObject;
        } catch (JSONException e) {
            throw new FacebookException("Unable to attach images", e);
        }
    }
}
