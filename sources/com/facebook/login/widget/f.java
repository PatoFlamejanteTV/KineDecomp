package com.facebook.login.widget;

import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProfilePictureView.java */
/* loaded from: classes.dex */
public class f implements ImageRequest.Callback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProfilePictureView f327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ProfilePictureView profilePictureView) {
        this.f327a = profilePictureView;
    }

    @Override // com.facebook.internal.ImageRequest.Callback
    public void onCompleted(ImageResponse imageResponse) {
        this.f327a.processResponse(imageResponse);
    }
}
