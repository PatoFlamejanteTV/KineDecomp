package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.AudioManager;
import android.support.v4.app.FragmentManager;
import com.nexstreaming.kinemaster.editorwrapper.C1730a;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Jh implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Kh f21916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Jh(Kh kh) {
        this.f21916a = kh;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        Oh oh;
        Oh oh2;
        Oh oh3;
        C1730a c1730a;
        if (i != -2) {
            return;
        }
        oh = this.f21916a.f21930a.p;
        if (oh != null) {
            oh2 = this.f21916a.f21930a.p;
            if (oh2 == null) {
                kotlin.jvm.internal.h.a();
                throw null;
            }
            if (oh2.b()) {
                this.f21916a.f21930a.v = true;
                oh3 = this.f21916a.f21930a.p;
                if (oh3 != null) {
                    oh3.a(false);
                    this.f21916a.f21930a.F();
                    c1730a = this.f21916a.f21930a.y;
                    if (c1730a != null) {
                        c1730a.a();
                        FragmentManager fragmentManager = this.f21916a.f21930a.getFragmentManager();
                        if (fragmentManager != null) {
                            fragmentManager.popBackStackImmediate();
                            return;
                        } else {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }
}
