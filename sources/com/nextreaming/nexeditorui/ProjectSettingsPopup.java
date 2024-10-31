package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.Slider;

/* loaded from: classes.dex */
public class ProjectSettingsPopup extends com.nexstreaming.kinemaster.ui.a.a {

    /* renamed from: a, reason: collision with root package name */
    private static SELECT_TAB f4501a = SELECT_TAB.AUDIO;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private a j;
    private NexTimeline k;
    private SwitchCompat l;
    private SwitchCompat m;
    private Slider n;
    private Slider o;
    private SwitchCompat p;
    private SwitchCompat q;
    private Slider r;
    private Slider s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum SELECT_TAB {
        AUDIO,
        VIDEO
    }

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public ProjectSettingsPopup(Context context) {
        super(context);
        View inflate = View.inflate(context, R.layout.project_settings_popup, null);
        a(inflate);
        setTitle(b().getString(R.string.settings_popup_title));
        setCancelable(true);
        this.l = (SwitchCompat) inflate.findViewById(R.id.fadeInSwitch);
        this.m = (SwitchCompat) inflate.findViewById(R.id.fadeOutSwitch);
        this.n = (Slider) inflate.findViewById(R.id.fadeInSlider);
        this.o = (Slider) inflate.findViewById(R.id.fadeOutSlider);
        this.p = (SwitchCompat) inflate.findViewById(R.id.videoFadeInSwitch);
        this.q = (SwitchCompat) inflate.findViewById(R.id.videoFadeOutSwitch);
        this.r = (Slider) inflate.findViewById(R.id.videoFadeInSlider);
        this.s = (Slider) inflate.findViewById(R.id.videoFadeOutSlider);
        this.t = inflate.findViewById(R.id.audioTab);
        this.u = inflate.findViewById(R.id.videoTab);
        this.v = inflate.findViewById(R.id.audioFadeHolder);
        this.w = inflate.findViewById(R.id.videoFadeHolder);
        this.x = inflate.findViewById(R.id.tabHolder);
        a(b().getString(R.string.project_settings_done), new dq(this, context));
        b(b().getString(R.string.project_settings_cancel), new du(this));
    }

    public void a(NexTimeline nexTimeline) {
        this.k = nexTimeline;
    }

    private Resources b() {
        return getContext().getResources();
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.a.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
        c();
        this.t.setOnClickListener(new dv(this));
        this.u.setOnClickListener(new dw(this));
        e();
    }

    private void c() {
        if (this.k != null) {
            this.l.setChecked(this.k.isProjectAudioFadeInTimeOn());
            this.m.setChecked(this.k.isProjectAudioFadeOutTimeOn());
            this.n.setEnabled(this.l.isChecked());
            this.o.setEnabled(this.m.isChecked());
            this.n.setValue(this.k.getProjectAudioFadeInTimeMillis() / 1000.0f);
            this.o.setValue(this.k.getProjectAudioFadeOutTimeMillis() / 1000.0f);
            this.f = this.k.isProjectAudioFadeInTimeOn();
            this.g = this.k.isProjectAudioFadeOutTimeOn();
            this.b = this.k.getProjectAudioFadeInTimeMillis();
            this.c = this.k.getProjectAudioFadeOutTimeMillis();
        }
        this.l.setOnCheckedChangeListener(new dx(this));
        this.m.setOnCheckedChangeListener(new dy(this));
        this.n.setListener(new dz(this));
        this.o.setListener(new ea(this));
    }

    private void d() {
        if (this.k != null) {
            this.p.setChecked(this.k.isProjectVideoFadeInTimeOn());
            this.q.setChecked(this.k.isProjectVideoFadeOutTimeOn());
            this.r.setEnabled(this.p.isChecked());
            this.s.setEnabled(this.q.isChecked());
            this.r.setValue(this.k.getProjectVideoFadeInTimeMillis() / 1000.0f);
            this.s.setValue(this.k.getProjectVideoFadeOutTimeMillis() / 1000.0f);
            this.h = this.k.isProjectVideoFadeInTimeOn();
            this.i = this.k.isProjectVideoFadeOutTimeOn();
            this.d = this.k.getProjectVideoFadeInTimeMillis();
            this.e = this.k.getProjectVideoFadeOutTimeMillis();
        }
        this.p.setOnCheckedChangeListener(new eb(this));
        this.q.setOnCheckedChangeListener(new dr(this));
        this.r.setListener(new ds(this));
        this.s.setListener(new dt(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        switch (f4501a) {
            case AUDIO:
                this.t.setSelected(true);
                this.u.setSelected(false);
                this.v.setVisibility(0);
                this.w.setVisibility(8);
                return;
            case VIDEO:
                this.t.setSelected(false);
                this.u.setSelected(true);
                this.v.setVisibility(8);
                this.w.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
