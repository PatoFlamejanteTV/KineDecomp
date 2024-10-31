package com.facebook;

import android.net.Uri;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import org.json.JSONObject;

/* compiled from: ShareGraphRequest.java */
/* loaded from: classes.dex */
class I implements OpenGraphJSONUtility.PhotoJSONProcessor {
    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        Uri imageUrl = sharePhoto.getImageUrl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", imageUrl.toString());
            return jSONObject;
        } catch (Exception e2) {
            throw new FacebookException("Unable to attach images", e2);
        }
    }
}
