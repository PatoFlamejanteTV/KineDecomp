package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.ba;
import java.io.File;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
public class mf extends kp implements VideoEditor.g, ba.a {
    private PowerManager.WakeLock c;
    private ClipDrawable d;
    private Button e;
    private mr f;
    private mr g;
    private File i;
    private int j;
    private boolean k;
    private com.nexstreaming.kinemaster.editorwrapper.a o;
    private int p;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4087a = false;
    private boolean b = false;
    private int h = -1;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.voice_recorder_fragment, viewGroup, false);
        b(inflate);
        NexTimelineItem m = m();
        if (m != null) {
            f(R.string.opt_rerecord);
            c(false);
            d(true);
            this.h = m.getAbsStartTime();
        } else {
            e(R.drawable.default_r_icon_voice_record);
            f(R.string.voicerec_desc_title_ready);
            c(true);
        }
        this.o = new com.nexstreaming.kinemaster.editorwrapper.a(getActivity().getApplicationContext());
        this.g = new mr(getActivity(), true);
        this.f = new mr(getActivity(), false);
        this.f.a(o());
        this.f.a(2147483647L);
        this.f.a();
        this.g.a(new mg(this));
        this.f.a(new mh(this));
        this.d = (ClipDrawable) ((ImageView) inflate.findViewById(R.id.voicerec_meter_view)).getDrawable();
        this.e = (Button) inflate.findViewById(R.id.rec_start_stop_btn);
        this.e.setEnabled(true);
        this.e.setText(getResources().getText(R.string.voicerec_btn_start));
        this.e.setOnClickListener(new mp(this));
        this.g.b();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_play_pause, R.drawable.action_play_pause, R.id.action_change_theme, R.drawable.action_icon_change_theme, R.id.action_share, R.drawable.action_icon_share);
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (this.p < this.j) {
            a(this.h, i2, this.p);
        } else {
            b(this.h, i2);
        }
        if (i2 >= this.p) {
            this.f.a(false);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        if (this.f != null) {
            this.f.a(true);
        }
        if (this.g != null) {
            this.g.a(true);
        }
        this.f = null;
        this.g = null;
        n();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        this.j = o().f().a().getTotalTime();
        int i = this.j - this.h;
        File b = com.nexstreaming.kinemaster.h.c.b(getActivity());
        b.mkdirs();
        long freeSpace = b.getFreeSpace();
        long j = ((44100 * i) / 8000) + 3145728;
        long min = (int) Math.min(i, ((freeSpace - 3145728) * 8000) / 44100);
        if (min < 1000 && freeSpace < j) {
            a(getResources().getString(R.string.fail_enospc), 1);
            return false;
        }
        if (o().f().a().getPrimaryItemCount() < 1) {
            a(getResources().getString(R.string.add_video_before_audio), 1);
            return false;
        }
        if (!o().f().a().checkResources(getActivity())) {
            a(getResources().getString(R.string.rec_audio_missing_rsrc), 1);
            return false;
        }
        if (this.j - this.h < 500) {
            a(getResources().getString(R.string.rec_audio_no_space), 1);
            this.k = true;
            return false;
        }
        this.p = this.h + ((int) min);
        return true;
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.f != null && this.f.c()) {
            this.l = true;
            this.e.callOnClick();
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onStart() {
        if (this.l) {
            this.l = false;
            do {
            } while (getFragmentManager().popBackStackImmediate());
        }
        super.onStart();
    }

    @Override // com.nextreaming.nexeditorui.ba.a
    public boolean l_() {
        if (this.f != null && this.f.c()) {
            this.f.a(true);
            this.f = null;
            n();
            return false;
        }
        return false;
    }
}
