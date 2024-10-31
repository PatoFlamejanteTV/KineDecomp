package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor.i f3324a;
    final /* synthetic */ VideoEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(VideoEditor videoEditor, VideoEditor.i iVar) {
        this.b = videoEditor;
        this.f3324a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3324a.a(this.b.c(), this.b.d());
    }
}
