package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: AudioFocusHelper.java */
/* renamed from: com.nexstreaming.kinemaster.editorwrapper.a */
/* loaded from: classes.dex */
public class C1730a implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    AudioManager f20290a;

    /* renamed from: b */
    Context f20291b;

    /* renamed from: c */
    AudioManager.OnAudioFocusChangeListener f20292c = null;

    public C1730a(Context context) {
        this.f20291b = context;
        this.f20290a = (AudioManager) this.f20291b.getSystemService("audio");
    }

    public boolean a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i) {
        if (onAudioFocusChangeListener == null || this.f20292c == onAudioFocusChangeListener) {
            return false;
        }
        this.f20292c = onAudioFocusChangeListener;
        return 1 == this.f20290a.requestAudioFocus(this.f20292c, i, 1);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
    }

    public boolean a() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.f20292c;
        return onAudioFocusChangeListener != null ? 1 == this.f20290a.abandonAudioFocus(onAudioFocusChangeListener) : 1 == this.f20290a.abandonAudioFocus(this);
    }
}
