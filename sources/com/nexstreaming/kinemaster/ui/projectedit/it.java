package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class it implements ProjectEditActivity.c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ is f3990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public it(is isVar) {
        this.f3990a = isVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity.c
    public boolean a(NexVideoClipItem nexVideoClipItem) {
        if (!nexVideoClipItem.isImage()) {
            nexVideoClipItem.setTrim(this.f3990a.b.startTrim, (int) Math.max(0.0d, (nexVideoClipItem.getDuration() - this.f3990a.b.startTrim) - (this.f3990a.b.duration * (this.f3990a.b.playbackSpeed / 100.0d))));
            nexVideoClipItem.setPlaybackSpeed(this.f3990a.b.playbackSpeed);
            nexVideoClipItem.setClipVolume(this.f3990a.b.volume);
            nexVideoClipItem.setMuteAudio(this.f3990a.b.mute);
        } else {
            nexVideoClipItem.setDuration(this.f3990a.b.duration);
        }
        nexVideoClipItem.setRotation(this.f3990a.b.rotation);
        nexVideoClipItem.setBrightness(this.f3990a.b.brightness);
        nexVideoClipItem.setContrast(this.f3990a.b.contrast);
        nexVideoClipItem.setSaturation(this.f3990a.b.saturation);
        nexVideoClipItem.setEffectID(this.f3990a.b.clipEffectId);
        nexVideoClipItem.setColorEffect(ColorEffect.fromPresetName(this.f3990a.b.colorFilterId));
        if (this.f3990a.b.cropStartLeft != this.f3990a.b.cropStartRight && this.f3990a.b.cropStartTop != this.f3990a.b.cropStartBottom) {
            nexVideoClipItem.setStartPosition(new Rect((int) this.f3990a.b.cropStartLeft, (int) this.f3990a.b.cropStartTop, (int) this.f3990a.b.cropStartRight, (int) this.f3990a.b.cropStartBottom));
        }
        if (this.f3990a.b.cropEndLeft != this.f3990a.b.cropEndRight && this.f3990a.b.cropEndTop != this.f3990a.b.cropEndBottom) {
            nexVideoClipItem.setEndPosition(new Rect((int) this.f3990a.b.cropEndLeft, (int) this.f3990a.b.cropEndTop, (int) this.f3990a.b.cropEndRight, (int) this.f3990a.b.cropEndBottom));
        }
        nexVideoClipItem.setFlipH(this.f3990a.b.fliph);
        nexVideoClipItem.setFlipV(this.f3990a.b.flipv);
        nexVideoClipItem.getTransition().setTransitionEffectID(this.f3990a.b.transitionEffectId);
        nexVideoClipItem.getTransition().setDuration(this.f3990a.b.transitionDuration);
        return true;
    }
}
