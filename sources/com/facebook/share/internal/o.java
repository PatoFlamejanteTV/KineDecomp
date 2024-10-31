package com.facebook.share.internal;

import android.net.Uri;
import com.facebook.FacebookException;
import com.facebook.internal.Utility;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class O implements OpenGraphJSONUtility.PhotoJSONProcessor {
    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        Uri imageUrl = sharePhoto.getImageUrl();
        if (Utility.isWebUri(imageUrl)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", imageUrl.toString());
                return jSONObject;
            } catch (JSONException e2) {
                throw new FacebookException("Unable to attach images", e2);
            }
        }
        throw new FacebookException("Only web images may be used in OG objects shared via the web dialog");
    }
}
