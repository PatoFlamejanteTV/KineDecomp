package com.nexstreaming.kinemaster.ui.projectedit;

import android.view.View;
import android.widget.ImageButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionVolumeFragment.java */
/* loaded from: classes2.dex */
class Ze implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1857bf f22196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ze(C1857bf c1857bf) {
        this.f22196a = c1857bf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NexTimelineItem.e eVar;
        NexTimelineItem.e eVar2;
        ImageButton imageButton;
        NexTimelineItem.e eVar3;
        NexTimelineItem.e eVar4;
        ImageButton imageButton2;
        ImageButton imageButton3;
        eVar = this.f22196a.l;
        eVar2 = this.f22196a.l;
        eVar.setMuteAudio(!eVar2.getMuteAudio());
        imageButton = this.f22196a.n;
        eVar3 = this.f22196a.l;
        imageButton.setSelected(eVar3.getMuteAudio());
        eVar4 = this.f22196a.l;
        if (eVar4.getMuteAudio()) {
            imageButton3 = this.f22196a.n;
            imageButton3.setImageDrawable(this.f22196a.getResources().getDrawable(R.drawable.vol_mute_btn));
        } else {
            imageButton2 = this.f22196a.n;
            imageButton2.setImageDrawable(this.f22196a.getResources().getDrawable(R.drawable.vol_sound_btn));
        }
        this.f22196a.G();
    }
}
