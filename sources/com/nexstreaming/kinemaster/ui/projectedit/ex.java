package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediaprep.MediaPrepManager;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelAddTaskMedia.java */
/* loaded from: classes.dex */
public class ex extends kp {

    /* renamed from: a, reason: collision with root package name */
    private View f3885a;
    private Button b;
    private TextView c;
    private TextView d;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f3885a = layoutInflater.inflate(R.layout.option_panel_add_task_fail_media, viewGroup, false);
        b(this.f3885a);
        this.c = (TextView) this.f3885a.findViewById(R.id.busy_reason);
        this.d = (TextView) this.f3885a.findViewById(R.id.fail_reason);
        this.b = (Button) this.f3885a.findViewById(R.id.retryButton);
        this.b.setOnClickListener(new ey(this));
        f();
        return this.f3885a;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3885a = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete);
        super.onActivityCreated(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        MediaPrepManager B;
        MSID mediaMSID = m().getMediaMSID();
        if (mediaMSID != null && (B = B()) != null) {
            com.nexstreaming.kinemaster.mediaprep.a aVar = new com.nexstreaming.kinemaster.mediaprep.a();
            B.a(mediaMSID, aVar);
            switch (aVar.f3523a) {
                case Downloading:
                    f(R.string.file_prep_busy);
                    this.c.setText(R.string.file_prep_downloading);
                    this.d.setVisibility(8);
                    this.b.setVisibility(8);
                    break;
                case Transcoding:
                    f(R.string.file_prep_busy);
                    this.c.setText(R.string.file_prep_transcoding);
                    this.d.setVisibility(8);
                    this.b.setVisibility(8);
                    break;
                case FailDownload:
                    f(R.string.file_opt_add_fail_title);
                    this.c.setText(getResources().getString(R.string.file_download_fail));
                    this.d.setVisibility(0);
                    this.b.setVisibility(0);
                    this.d.setText("Error code : " + aVar.d.toString());
                    break;
                case FailTranscoding:
                    f(R.string.file_opt_add_fail_title);
                    this.c.setText(getResources().getString(R.string.file_transcoding_fail));
                    this.d.setText("Error code : " + aVar.d.toString());
                    this.d.setVisibility(0);
                    this.b.setVisibility(0);
                    break;
                case FailedCanRetry:
                    f(R.string.file_opt_add_fail_title);
                    this.c.setText(getResources().getString(R.string.file_add_fail));
                    this.d.setText("Error code : " + aVar.d.toString());
                    this.d.setVisibility(0);
                    this.b.setVisibility(8);
                    break;
                default:
                    f(R.string.file_prep_busy);
                    this.c.setText(R.string.file_prep_busy);
                    this.d.setVisibility(8);
                    this.b.setVisibility(8);
                    break;
            }
        }
        super.f();
    }
}
