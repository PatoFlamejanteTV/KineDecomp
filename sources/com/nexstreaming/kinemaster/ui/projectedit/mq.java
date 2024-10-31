package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.AudioManager;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mq implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mp f4098a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mq(mp mpVar) {
        this.f4098a = mpVar;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        mr mrVar;
        mr mrVar2;
        mr mrVar3;
        com.nexstreaming.kinemaster.editorwrapper.a aVar;
        switch (i) {
            case -2:
                mrVar = this.f4098a.f4097a.f;
                if (mrVar != null) {
                    mrVar2 = this.f4098a.f4097a.f;
                    if (mrVar2.c()) {
                        this.f4098a.f4097a.l = true;
                        mrVar3 = this.f4098a.f4097a.f;
                        mrVar3.a(false);
                        this.f4098a.f4097a.n();
                        aVar = this.f4098a.f4097a.o;
                        aVar.a();
                        this.f4098a.f4097a.getFragmentManager().popBackStackImmediate();
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
