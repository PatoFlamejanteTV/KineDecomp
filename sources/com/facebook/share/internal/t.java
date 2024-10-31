package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.share.internal.VideoUploader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUploader.java */
/* loaded from: classes.dex */
public class T implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookException f9551a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f9552b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ VideoUploader.e f9553c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(VideoUploader.e eVar, FacebookException facebookException, String str) {
        this.f9553c = eVar;
        this.f9551a = facebookException;
        this.f9552b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoUploader.issueResponse(this.f9553c.f9567a, this.f9551a, this.f9552b);
    }
}
