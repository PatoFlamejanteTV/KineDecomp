package com.facebook.login.widget;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;

/* compiled from: ProfilePictureView.java */
/* loaded from: classes.dex */
public class g implements ImageRequest.Callback {

    /* renamed from: a */
    final /* synthetic */ ProfilePictureView f9415a;

    public g(ProfilePictureView profilePictureView) {
        this.f9415a = profilePictureView;
    }

    @Override // com.facebook.internal.ImageRequest.Callback
    public void onCompleted(ImageResponse imageResponse) {
        this.f9415a.processResponse(imageResponse);
    }
}
