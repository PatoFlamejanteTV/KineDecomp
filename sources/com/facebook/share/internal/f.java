package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class F implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, Bundle> {
    @Override // com.facebook.internal.Utility.Mapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bundle apply(NativeAppCallAttachmentStore.Attachment attachment) {
        Bundle bundle = new Bundle();
        bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
        String uriExtension = ShareInternalUtility.getUriExtension(attachment.getOriginalUri());
        if (uriExtension != null) {
            Utility.putNonEmptyString(bundle, ShareConstants.MEDIA_EXTENSION, uriExtension);
        }
        return bundle;
    }
}
