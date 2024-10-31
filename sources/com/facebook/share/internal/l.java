package com.facebook.share.internal;

import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class L implements Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String> {
    @Override // com.facebook.internal.Utility.Mapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String apply(NativeAppCallAttachmentStore.Attachment attachment) {
        return attachment.getAttachmentUrl();
    }
}
