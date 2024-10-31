package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.m;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bt implements com.nextreaming.nexvideoeditor.ar {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3346a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(VideoEditor videoEditor) {
        this.f3346a = videoEditor;
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a(NexEditor.PlayState playState, NexEditor.PlayState playState2) {
        this.f3346a.A = playState2;
        this.f3346a.Q();
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a(int i) {
        if (this.f3346a.t() == VideoEditor.State.Playing) {
            this.f3346a.b(i, i);
        } else {
            this.f3346a.b(i);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void b(int i) {
        if (this.f3346a.t() != VideoEditor.State.Playing) {
            this.f3346a.b(i);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a() {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void b(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void b() {
        com.nexstreaming.app.general.util.m mVar;
        if (this.f3346a.q()) {
            this.f3346a.a(0);
            this.f3346a.r();
        }
        mVar = this.f3346a.o;
        mVar.a((m.a) new bu(this));
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a(NexEditor.b bVar, int i) {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void c() {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void d() {
    }

    @Override // com.nextreaming.nexvideoeditor.ar
    public void a(boolean z) {
        this.f3346a.w = z;
        this.f3346a.Q();
    }
}
