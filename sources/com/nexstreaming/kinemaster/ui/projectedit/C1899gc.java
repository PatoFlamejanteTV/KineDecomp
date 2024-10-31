package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionChromaKeyFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.gc */
/* loaded from: classes2.dex */
public class C1899gc extends Bg {
    private SwitchCompat l;
    private View m;
    private ImageView n;
    private View o;
    private View p;
    private View q;
    private Slider r;
    private Slider s;
    private View t;
    private View u;
    private NexTimelineItem v;
    private NexTimelineItem.d w;
    private View x;
    private View y;

    public void o(boolean z) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(activity).edit().putBoolean("km.chroma.showmask", z).apply();
    }

    public boolean va() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        return PreferenceManager.getDefaultSharedPreferences(activity).getBoolean("km.chroma.showmask", false);
    }

    public void wa() {
        float width = this.s.getWidth() - (this.s.getPaddingLeft() + this.s.getPaddingRight());
        float value = (((int) this.r.getValue()) / this.r.getMaxValue()) * width;
        float maxValue = (((int) (this.s.getMaxValue() - this.s.getValue())) / this.s.getMaxValue()) * width;
        this.x.setX(this.s.getX() + value + this.s.getPaddingRight());
        this.y.setX(((this.r.getX() + maxValue) + this.s.getPaddingRight()) - this.y.getWidth());
        this.x.invalidate();
        this.y.invalidate();
    }

    public void xa() {
        boolean va = va();
        this.o.setSelected(va);
        this.p.setSelected(va);
        if (this.w.getChromaKeyMaskEnabled() != va) {
            this.w.setChromaKeyMaskEnabled(va);
            if (da() != null) {
                da().n().execute();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        NexTimelineItem Y = Y();
        if (Y != 0) {
            this.v = Y;
            this.w = (NexTimelineItem.d) Y;
        }
        NexTimelineItem.d dVar = this.w;
        if (dVar == null || this.v == null) {
            return;
        }
        if (dVar.getChromaKeyEnabled()) {
            this.l.setChecked(true);
            this.n.setEnabled(true);
            this.q.setEnabled(true);
            this.n.setAlpha(1.0f);
            this.m.setAlpha(1.0f);
            this.q.setAlpha(1.0f);
            this.t.setAlpha(1.0f);
            this.u.setAlpha(1.0f);
            this.r.setAlpha(1.0f);
            this.s.setAlpha(1.0f);
            this.r.setEnabled(true);
            this.s.setEnabled(true);
            this.o.setAlpha(1.0f);
            this.p.setAlpha(1.0f);
            this.x.setAlpha(1.0f);
            this.y.setAlpha(1.0f);
            this.o.setEnabled(true);
        } else {
            this.l.setChecked(false);
            this.n.setEnabled(false);
            this.q.setEnabled(false);
            this.n.setAlpha(0.3f);
            this.m.setAlpha(0.3f);
            this.q.setAlpha(0.3f);
            this.t.setAlpha(0.3f);
            this.u.setAlpha(0.3f);
            this.r.setAlpha(0.5f);
            this.s.setAlpha(0.5f);
            this.r.setEnabled(false);
            this.s.setEnabled(false);
            this.o.setAlpha(0.3f);
            this.p.setAlpha(0.3f);
            this.x.setAlpha(0.3f);
            this.y.setAlpha(0.3f);
            this.o.setEnabled(false);
        }
        this.r.setValue(this.w.getChromaKeyBGClip() * 100.0f);
        this.s.setValue(this.w.getChromaKeyFGClip() * 100.0f);
        this.s.setDraggingLimitValue((float) Math.ceil(this.r.getMaxValue() - this.r.getValue()));
        this.r.setDraggingLimitValue((float) Math.ceil(this.s.getMaxValue() - this.s.getValue()));
        this.n.setImageDrawable(new C1897ga(getActivity(), this.w.getChromaKeyColor()));
        xa();
        wa();
        super.na();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_chroma_key_fragment, viewGroup, false);
        a(inflate);
        n(R.string.opt_chroma_key);
        f(true);
        this.l = (SwitchCompat) inflate.findViewById(R.id.buttonOnOff);
        this.l.setOnCheckedChangeListener(new Yb(this));
        this.m = inflate.findViewById(R.id.colorBtnHolder);
        this.n = (ImageView) inflate.findViewById(R.id.buttonColor);
        this.m.setOnClickListener(new ViewOnClickListenerC1845ac(this));
        this.q = inflate.findViewById(R.id.detailCurveHolder);
        this.q.setOnClickListener(new ViewOnClickListenerC1854bc(this));
        this.o = inflate.findViewById(R.id.maskModeHolder);
        this.p = inflate.findViewById(R.id.buttonMask);
        this.o.setOnClickListener(new ViewOnClickListenerC1863cc(this));
        this.t = inflate.findViewById(R.id.icon_chroma_clip_bg);
        this.u = inflate.findViewById(R.id.icon_chroma_clip_fg);
        this.r = (Slider) inflate.findViewById(R.id.slider_chroma_clip_bg);
        this.r.setListener(new C1872dc(this));
        this.s = (Slider) inflate.findViewById(R.id.slider_chroma_clip_fg);
        this.s.setListener(new C1881ec(this));
        this.s.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1890fc(this));
        this.x = inflate.findViewById(R.id.fgGuideline);
        this.y = inflate.findViewById(R.id.bgGuideline);
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        NexTimelineItem.d dVar = this.w;
        if (dVar != null) {
            dVar.setChromaKeyMaskEnabled(false);
        }
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        NexTimelineItem.d dVar = this.w;
        if (dVar != null) {
            dVar.setChromaKeyMaskEnabled(va());
        }
        super.onResume();
    }
}
