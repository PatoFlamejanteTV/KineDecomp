package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ta implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor.i f20255a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20256b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(VideoEditor videoEditor, VideoEditor.i iVar) {
        this.f20256b = videoEditor;
        this.f20255a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f20255a.a(this.f20256b.h(), this.f20256b.g());
    }
}
