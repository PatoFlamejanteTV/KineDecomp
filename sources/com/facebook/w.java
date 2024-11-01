package com.facebook;

import android.net.Uri;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

/* compiled from: GraphRequest.java */
/* loaded from: classes.dex */
final class w implements OpenGraphJSONUtility.PhotoJSONProcessor {
    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        Uri imageUrl = sharePhoto.getImageUrl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", imageUrl.toString());
            return jSONObject;
        } catch (Exception e) {
            throw new FacebookException("Unable to attach images", e);
        }
    }
}
