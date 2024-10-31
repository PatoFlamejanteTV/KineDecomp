package com.nexstreaming.kinemaster.editorwrapper;

import android.media.AudioManager;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Oa implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pa f20241a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(Pa pa) {
        this.f20241a = pa;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (i == -3 || i != -2) {
            return;
        }
        this.f20241a.f20244b.R().s();
    }
}
