package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: OptionPanelMissingMedia.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.oe, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1972oe extends Bg {
    private View l;

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.option_panel_missing_media, viewGroup, false);
        a(this.l);
        g(Y().getDescriptiveTitle(getActivity()));
        na();
        NexTimelineItem Y = Y();
        View findViewById = this.l.findViewById(R.id.descTitleSm);
        if (findViewById != null && (Y instanceof NexVideoClipItem)) {
            String mediaPath = ((NexVideoClipItem) Y).getMediaPath();
            findViewById.setLongClickable(true);
            findViewById.setOnClickListener(new ViewOnClickListenerC1963ne(this, mediaPath));
        }
        return this.l;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.l = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete);
    }
}
