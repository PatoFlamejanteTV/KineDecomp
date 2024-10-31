package com.facebook.share.internal;

import com.facebook.internal.Utility;
import com.facebook.share.model.SharePhoto;

/* compiled from: WebDialogParameters.java */
/* loaded from: classes.dex */
public class U implements Utility.Mapper<SharePhoto, String> {
    @Override // com.facebook.internal.Utility.Mapper
    /* renamed from: a */
    public String apply(SharePhoto sharePhoto) {
        return sharePhoto.getImageUrl().toString();
    }
}
