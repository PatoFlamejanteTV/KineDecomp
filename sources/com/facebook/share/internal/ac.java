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
public final class ac implements OpenGraphJSONUtility.PhotoJSONProcessor {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UUID f358a;
    final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(UUID uuid, ArrayList arrayList) {
        this.f358a = uuid;
        this.b = arrayList;
    }

    @Override // com.facebook.share.internal.OpenGraphJSONUtility.PhotoJSONProcessor
    public JSONObject toJSONObject(SharePhoto sharePhoto) {
        NativeAppCallAttachmentStore.Attachment attachment;
        attachment = ShareInternalUtility.getAttachment(this.f358a, sharePhoto);
        if (attachment == null) {
            return null;
        }
        this.b.add(attachment);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", attachment.getAttachmentUrl());
            if (sharePhoto.getUserGenerated()) {
                jSONObject.put(NativeProtocol.IMAGE_USER_GENERATED_KEY, true);
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new FacebookException("Unable to attach images", e);
        }
    }
}
