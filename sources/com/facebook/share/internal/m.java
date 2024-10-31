package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareMedia;
import java.util.List;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareInternalUtility.java */
/* loaded from: classes.dex */
public class M implements Utility.Mapper<ShareMedia, Bundle> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UUID f9544a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f9545b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(UUID uuid, List list) {
        this.f9544a = uuid;
        this.f9545b = list;
    }

    @Override // com.facebook.internal.Utility.Mapper
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bundle apply(ShareMedia shareMedia) {
        NativeAppCallAttachmentStore.Attachment attachment;
        attachment = ShareInternalUtility.getAttachment(this.f9544a, shareMedia);
        this.f9545b.add(attachment);
        Bundle bundle = new Bundle();
        bundle.putString("type", shareMedia.getMediaType().name());
        bundle.putString(ShareConstants.MEDIA_URI, attachment.getAttachmentUrl());
        return bundle;
    }
}
