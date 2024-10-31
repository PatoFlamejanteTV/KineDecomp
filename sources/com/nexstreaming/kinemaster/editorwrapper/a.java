package com.nexstreaming.kinemaster.editorwrapper;

import android.content.Context;
import android.media.AudioManager;

/* compiled from: AudioFocusHelper.java */
/* loaded from: classes.dex */
public class a implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    AudioManager f3306a;
    Context b;
    AudioManager.OnAudioFocusChangeListener c = null;

    public a(Context context) {
        this.b = context;
        this.f3306a = (AudioManager) this.b.getSystemService("audio");
    }

    public boolean a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, int i) {
        if (onAudioFocusChangeListener == null || this.c == onAudioFocusChangeListener) {
            return false;
        }
        this.c = onAudioFocusChangeListener;
        return 1 == this.f3306a.requestAudioFocus(this.c, i, 1);
    }

    public boolean a() {
        return this.c != null ? 1 == this.f3306a.abandonAudioFocus(this.c) : 1 == this.f3306a.abandonAudioFocus(this);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
    }
}
