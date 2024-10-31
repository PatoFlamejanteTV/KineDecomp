package com.nexstreaming.kinemaster.editorwrapper;

import android.media.AudioManager;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class be implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bd f3332a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f3332a = bdVar;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
            default:
                return;
            case -2:
                this.f3332a.b.N().m();
                return;
        }
    }
}
