package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexAudioClipItem;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ch f21794a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f21795b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bh(Ch ch, NexAudioClipItem nexAudioClipItem) {
        this.f21794a = ch;
        this.f21795b = nexAudioClipItem;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zh zhVar = this.f21794a.f21804a.f21906a;
        NexAudioClipItem nexAudioClipItem = this.f21795b;
        kotlin.jvm.internal.h.a((Object) nexAudioClipItem, "item");
        zhVar.f(nexAudioClipItem);
        this.f21794a.f21804a.f21906a.w = false;
    }
}
