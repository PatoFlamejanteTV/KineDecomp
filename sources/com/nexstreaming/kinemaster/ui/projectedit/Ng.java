package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.SpeedControlSpinner;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;

/* compiled from: SpeedControlFragment.java */
/* loaded from: classes2.dex */
public class Ng extends Bg {
    private final int l = 1;
    private final int m = 4;
    private final int n = 8;
    private final int o = 2;
    private int p;
    private NexVideoClipItem q;
    private Button r;
    private Button s;
    private Button t;
    private SpeedControlSpinner u;
    private SwitchCompat v;
    private SwitchCompat w;

    private void q(int i) {
        this.p = this.q.getPlaybackSpeed();
        this.u.setSpeed(i);
        this.q.setPlaybackSpeed(i * 100);
        this.q.setUseIFrameOnly(i >= 2);
        xa();
    }

    private float va() {
        float wa;
        if (this.q.getTransition().isSet()) {
            float duration = this.q.getTransition().getDuration();
            if (duration == 0.0f) {
                return Math.max(1.0f, Math.min(16.0f, wa() / 1000.0f));
            }
            wa = ((wa() - duration) / (duration / 1000.0f)) / 1000.0f;
        } else {
            wa = wa() / 1000.0f;
        }
        if (wa < 1.0f) {
            return 1.0f;
        }
        if (wa >= 16.0f) {
            return 16.0f;
        }
        return wa;
    }

    private int wa() {
        return (this.q.getDuration() - this.q.getTrimTimeStart()) - this.q.getTrimTimeEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xa() {
        NexVideoClipItem nexVideoClipItem = this.q;
        nexVideoClipItem.checkEffectTime((nexVideoClipItem.getEffectStartTime() * this.p) / 100, (this.q.getEffectEndTime() * this.p) / 100, 3);
    }

    private void ya() {
        if (Y() != null) {
            NexTimelineItem Y = Y();
            if (Y instanceof NexVideoClipItem) {
                this.q = (NexVideoClipItem) Y;
                this.p = this.q.getPlaybackSpeed();
                float va = va();
                this.u.setMaxSpeed(va);
                this.u.setSpeed(this.q.getPlaybackSpeed() / 100.0f);
                this.v.setChecked(this.q.getMuteAudio());
                this.w.setChecked(this.q.hasKeepPitch());
                this.w.setEnabled(!this.v.isChecked());
                this.s.setEnabled(va >= 4.0f);
                this.t.setEnabled(va >= 8.0f);
            }
        }
    }

    public /* synthetic */ void c(View view) {
        q(4);
    }

    public /* synthetic */ void d(View view) {
        q(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        ya();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_speed_control, viewGroup, false);
        a(inflate);
        n(R.string.spcontrol_panel_title);
        f(true);
        o(R.id.editmode_speed_control);
        this.r = (Button) inflate.findViewById(R.id.button_x1);
        this.s = (Button) inflate.findViewById(R.id.button_x4);
        this.t = (Button) inflate.findViewById(R.id.button_x8);
        this.u = (SpeedControlSpinner) inflate.findViewById(R.id.speed_control_spinner);
        this.v = (SwitchCompat) inflate.findViewById(R.id.switch_mute_audio);
        this.w = (SwitchCompat) inflate.findViewById(R.id.switch_keep_pitch);
        ya();
        this.r.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ng.this.b(view);
            }
        });
        this.s.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ng.this.c(view);
            }
        });
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Ng.this.d(view);
            }
        });
        this.u.setListener(new Mg(this));
        this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Ng.this.a(compoundButton, z);
            }
        });
        this.w.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.nexstreaming.kinemaster.ui.projectedit.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Ng.this.b(compoundButton, z);
            }
        });
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        G();
    }

    public /* synthetic */ void b(View view) {
        q(1);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.w.setEnabled(!z);
        this.q.setMuteAudio(z);
    }

    public /* synthetic */ void b(CompoundButton compoundButton, boolean z) {
        this.q.setKeepPitch(z);
    }
}
