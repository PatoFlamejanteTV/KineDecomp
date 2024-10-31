package com.facebook.share.internal;

import com.facebook.FacebookException;
import com.facebook.share.internal.VideoUploader;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUploader.java */
/* loaded from: classes.dex */
public class ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FacebookException f360a;
    final /* synthetic */ String b;
    final /* synthetic */ VideoUploader.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(VideoUploader.e eVar, FacebookException facebookException, String str) {
        this.c = eVar;
        this.f360a = facebookException;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoUploader.issueResponse(this.c.b, this.f360a, this.b);
    }
}
