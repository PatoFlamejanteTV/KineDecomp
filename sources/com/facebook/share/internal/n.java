package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.OpenGraphJSONUtility;
import com.facebook.share.model.SharePhoto;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class N implements OpenGraphJSONUtility.PhotoJSONProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UUID f9546a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ArrayList f9547b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(UUID uuid, ArrayList arrayList) {
        this.f9546a = uuid;
        this.f9547b = arrayList;
    }

    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        NativeAppCallAttachmentStore.Attachment attachment;
        attachment = ShareInternalUtility.getAttachment(this.f9546a, sharePhoto);
        if (attachment == null) {
            return null;
        }
        this.f9547b.add(attachment);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", attachment.getAttachmentUrl());
            if (sharePhoto.getUserGenerated()) {
                jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
            }
            return jSONObject;
        } catch (JSONException e2) {
            throw new FacebookException("Unable to attach images", e2);
        }
    }
}
