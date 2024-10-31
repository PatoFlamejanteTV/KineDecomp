package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediaprep.C1803a;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* compiled from: OptionPanelAddTaskMedia.java */
/* loaded from: classes2.dex */
public class Ad extends Bg {
    private View l;
    private Button m;
    private TextView n;
    private TextView o;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        MediaPrepManager N;
        MediaStoreItemId mediaMSID = Y().getMediaMSID();
        if (mediaMSID != null && (N = N()) != null) {
            C1803a c1803a = new C1803a();
            N.a(mediaMSID, c1803a);
            int i = C2089zd.f22805a[c1803a.f20781a.ordinal()];
            if (i == 1) {
                n(R.string.file_prep_busy);
                this.n.setText(R.string.file_prep_downloading);
                this.o.setVisibility(8);
                this.m.setVisibility(8);
            } else if (i == 2) {
                n(R.string.file_prep_busy);
                this.n.setText(R.string.file_prep_transcoding);
                this.o.setVisibility(8);
                this.m.setVisibility(8);
            } else if (i == 3) {
                n(R.string.file_opt_add_fail_title);
                this.n.setText(getResources().getString(R.string.file_download_fail));
                this.o.setVisibility(0);
                this.m.setVisibility(0);
                this.o.setText("Error code : " + c1803a.f20784d.toString());
            } else if (i == 4) {
                n(R.string.file_opt_add_fail_title);
                this.n.setText(getResources().getString(R.string.file_transcoding_fail));
                this.o.setText("Error code : " + c1803a.f20784d.toString());
                this.o.setVisibility(0);
                this.m.setVisibility(0);
            } else if (i != 5) {
                n(R.string.file_prep_busy);
                this.n.setText(R.string.file_prep_busy);
                this.o.setVisibility(8);
                this.m.setVisibility(8);
            } else {
                n(R.string.file_opt_add_fail_title);
                this.n.setText(getResources().getString(R.string.file_add_fail));
                this.o.setText("Error code : " + c1803a.f20784d.toString());
                this.o.setVisibility(0);
                this.m.setVisibility(8);
            }
        }
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.l = layoutInflater.inflate(R.layout.option_panel_add_task_fail_media, viewGroup, false);
        a(this.l);
        this.n = (TextView) this.l.findViewById(R.id.busy_reason);
        this.o = (TextView) this.l.findViewById(R.id.fail_reason);
        this.m = (Button) this.l.findViewById(R.id.retryButton);
        this.m.setOnClickListener(new ViewOnClickListenerC2081yd(this));
        na();
        return this.l;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.l = null;
        super.onDestroyView();
    }
}
