package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* loaded from: classes.dex */
public class cr extends kp {

    /* renamed from: a, reason: collision with root package name */
    private SwitchCompat f3825a;
    private View b;
    private ImageView c;
    private View d;
    private View e;
    private View f;
    private Slider g;
    private Slider h;
    private View i;
    private View j;
    private NexTimelineItem k;
    private NexTimelineItem.c l;
    private View m;
    private View n;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        Activity activity = getActivity();
        if (activity == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("km.chroma.showmask", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Activity activity = getActivity();
        if (activity != null) {
            PreferenceManager.getDefaultSharedPreferences(activity).edit().putBoolean("km.chroma.showmask", z).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        boolean c = c();
        this.d.setSelected(c);
        this.e.setSelected(c);
        if (this.l.getChromaKeyMaskEnabled() != c) {
            this.l.setChromaKeyMaskEnabled(c);
            if (o() != null) {
                o().z().a();
            }
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_chroma_key_fragment, viewGroup, false);
        b(inflate);
        f(R.string.opt_chroma_key);
        d(true);
        this.f3825a = (SwitchCompat) inflate.findViewById(R.id.buttonOnOff);
        this.f3825a.setOnCheckedChangeListener(new cs(this));
        this.b = inflate.findViewById(R.id.colorBtnHolder);
        this.c = (ImageView) inflate.findViewById(R.id.buttonColor);
        this.b.setOnClickListener(new ct(this));
        this.f = inflate.findViewById(R.id.detailCurveHolder);
        this.f.setOnClickListener(new cw(this));
        this.d = inflate.findViewById(R.id.maskModeHolder);
        this.e = inflate.findViewById(R.id.buttonMask);
        this.d.setOnClickListener(new cx(this));
        this.i = inflate.findViewById(R.id.icon_chroma_clip_bg);
        this.j = inflate.findViewById(R.id.icon_chroma_clip_fg);
        this.g = (Slider) inflate.findViewById(R.id.slider_chroma_clip_bg);
        this.g.setListener(new cy(this));
        this.h = (Slider) inflate.findViewById(R.id.slider_chroma_clip_fg);
        this.h.setListener(new cz(this));
        this.h.getViewTreeObserver().addOnGlobalLayoutListener(new da(this));
        this.m = inflate.findViewById(R.id.fgGuideline);
        this.n = inflate.findViewById(R.id.bgGuideline);
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (m() instanceof NexPrimaryTimelineItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        NexTimelineItem m = m();
        if (m != 0) {
            this.k = m;
            this.l = (NexTimelineItem.c) m;
        }
        if (this.l != null && this.k != null) {
            if (this.l.getChromaKeyEnabled()) {
                this.f3825a.setChecked(true);
                this.c.setEnabled(true);
                this.f.setEnabled(true);
                this.c.setAlpha(1.0f);
                this.b.setAlpha(1.0f);
                this.f.setAlpha(1.0f);
                this.i.setAlpha(1.0f);
                this.j.setAlpha(1.0f);
                this.g.setAlpha(1.0f);
                this.h.setAlpha(1.0f);
                this.g.setEnabled(true);
                this.h.setEnabled(true);
                this.d.setAlpha(1.0f);
                this.e.setAlpha(1.0f);
                this.m.setAlpha(1.0f);
                this.n.setAlpha(1.0f);
                this.d.setEnabled(true);
            } else {
                this.f3825a.setChecked(false);
                this.c.setEnabled(false);
                this.f.setEnabled(false);
                this.c.setAlpha(0.3f);
                this.b.setAlpha(0.3f);
                this.f.setAlpha(0.3f);
                this.i.setAlpha(0.3f);
                this.j.setAlpha(0.3f);
                this.g.setAlpha(0.5f);
                this.h.setAlpha(0.5f);
                this.g.setEnabled(false);
                this.h.setEnabled(false);
                this.d.setAlpha(0.3f);
                this.e.setAlpha(0.3f);
                this.m.setAlpha(0.3f);
                this.n.setAlpha(0.3f);
                this.d.setEnabled(false);
            }
            this.g.setValue(this.l.getChromaKeyBGClip() * 100.0f);
            this.h.setValue(this.l.getChromaKeyFGClip() * 100.0f);
            this.h.setDraggingLimitValue((float) Math.ceil(this.g.getMaxValue() - this.g.getValue()));
            this.g.setDraggingLimitValue((float) Math.ceil(this.h.getMaxValue() - this.h.getValue()));
            this.c.setImageDrawable(new q(getActivity(), this.l.getChromaKeyColor()));
            e();
            h();
            super.f();
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.l != null) {
            this.l.setChromaKeyMaskEnabled(false);
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        if (this.l != null) {
            this.l.setChromaKeyMaskEnabled(c());
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int width = this.h.getWidth() - (this.h.getPaddingLeft() + this.h.getPaddingRight());
        float value = (((int) this.g.getValue()) / this.g.getMaxValue()) * width;
        float maxValue = width * (((int) (this.h.getMaxValue() - this.h.getValue())) / this.h.getMaxValue());
        this.m.setX(value + this.h.getX() + this.h.getPaddingRight());
        this.n.setX(((maxValue + this.g.getX()) + this.h.getPaddingRight()) - this.n.getWidth());
        this.m.invalidate();
        this.n.invalidate();
    }
}
