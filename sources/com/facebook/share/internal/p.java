package com.facebook.share.internal;

import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.model.SharePhoto;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class P implements Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UUID f9548a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(UUID uuid) {
        this.f9548a = uuid;
    }

    @Override // com.facebook.internal.Utility.Mapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NativeAppCallAttachmentStore.Attachment apply(SharePhoto sharePhoto) {
        NativeAppCallAttachmentStore.Attachment attachment;
        attachment = ShareInternalUtility.getAttachment(this.f9548a, sharePhoto);
        return attachment;
    }
}
