package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import io.reactivex.subjects.PublishSubject;
import kotlin.Pair;

/* compiled from: AudioEffectContract.kt */
/* loaded from: classes2.dex */
public interface g {
    void a(b bVar);

    PublishSubject<Pair<AudioPlayStatus, b>> c();

    int d();

    void dispose();
}
