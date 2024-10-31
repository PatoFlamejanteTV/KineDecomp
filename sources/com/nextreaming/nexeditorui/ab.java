package com.nextreaming.nexeditorui;

import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.widget.FXGripDrawingView;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class ab implements FXGripDrawingView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f24213a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24214b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(NexVideoClipItem nexVideoClipItem, VideoEditor videoEditor) {
        this.f24214b = nexVideoClipItem;
        this.f24213a = videoEditor;
    }

    @Override // com.nexstreaming.kinemaster.ui.widget.FXGripDrawingView.b
    public void a(int i, int i2) {
        this.f24214b.m_effectStartTime = i;
        this.f24214b.m_effectEndTime = i2;
        VideoEditor videoEditor = this.f24213a;
        if (videoEditor != null) {
            videoEditor.c(this.f24214b);
            this.f24213a.J();
        }
    }
}
