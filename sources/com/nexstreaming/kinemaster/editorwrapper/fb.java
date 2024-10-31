package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.util.u;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class fb implements com.nextreaming.nexvideoeditor.ha {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20314a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fb(VideoEditor videoEditor) {
        this.f20314a = videoEditor;
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i, int i2) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.PlayState playState, NexEditor.PlayState playState2) {
        this.f20314a.B = playState2;
        this.f20314a.X();
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar, int i) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(NexEditor.b bVar, int i, int i2) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(int i) {
        boolean z;
        z = this.f20314a.da;
        if (z) {
            return;
        }
        if (this.f20314a.w() != VideoEditor.State.Playing) {
            this.f20314a.c(i);
        } else {
            this.f20314a.b(i, i);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void b(NexEditor.b bVar, int i) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void c() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void c(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void d() {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void d(NexEditor.b bVar) {
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i) {
        boolean z;
        if (this.f20314a.w() != VideoEditor.State.Playing) {
            z = this.f20314a.da;
            if (z) {
                return;
            }
            this.f20314a.c(i);
        }
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a() {
        com.nexstreaming.app.general.util.u uVar;
        if (this.f20314a.A()) {
            this.f20314a.b(0);
            this.f20314a.D();
        }
        uVar = this.f20314a.r;
        uVar.a((u.a) new db(this));
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(boolean z) {
        this.f20314a.x = z;
        this.f20314a.X();
    }

    @Override // com.nextreaming.nexvideoeditor.ha
    public void a(int i, int i2, int i3) {
        com.nexstreaming.app.general.util.u uVar;
        uVar = this.f20314a.s;
        uVar.a((u.a) new eb(this, i, i2, i3));
    }
}
