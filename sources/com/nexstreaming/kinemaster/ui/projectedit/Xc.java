package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1697a;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.projectedit.C1935kd;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionListFragment.java */
/* loaded from: classes2.dex */
public abstract class Xc extends Bg implements C1935kd.a {
    private ListView l;
    private View m;
    private View n;
    private C1935kd o;
    private View s;
    private View t;
    private View u;
    private View v;
    private View w;
    private View x;
    private C2073xd y;
    private com.nexstreaming.app.general.util.z p = new com.nexstreaming.app.general.util.z();
    private com.nexstreaming.app.general.util.z q = new com.nexstreaming.app.general.util.z();
    private com.nexstreaming.app.general.util.z r = new com.nexstreaming.app.general.util.z();
    private InterfaceC1997rd z = InterfaceC1997rd.f22506a;
    private AdapterView.OnItemClickListener A = new Sc(this);
    private AbsListView.OnScrollListener B = new Wc(this);

    private void za() {
        if (this.o != null) {
            C2073xd c2073xd = this.y;
            if (c2073xd == null || c2073xd.a() != this.o) {
                this.y = new C2073xd(this.l, this.o, this, this, this.z);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        View view;
        super.na();
        if (getActivity() == null) {
            return;
        }
        boolean z = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("km.optionListGrid", false);
        if ((ya() || sa()) && (view = this.x) != null) {
            view.setVisibility(8);
            if (sa()) {
                z = false;
            }
        }
        View view2 = this.t;
        if (view2 != null && this.v != null && this.u != null && this.w != null) {
            view2.setVisibility(z ? 0 : 4);
            this.u.setVisibility(z ? 4 : 0);
            this.v.setActivated(z);
            this.w.setActivated(!z);
        }
        if (Y() == null && aa() == null) {
            return;
        }
        g(wa());
        f(va());
        if (this.o == null) {
            this.o = new C1935kd();
            this.o.a(this.z);
            o(z);
            this.l.setAdapter((ListAdapter) this.o);
            za();
        } else {
            this.l.clearChoices();
            o(z);
            this.o.notifyDataSetChanged();
        }
        this.l.setOnItemClickListener(this.A);
        this.l.setOnScrollListener(this.B);
        this.l.post(new Rc(this));
        if (Y() != null && (Y() instanceof NexTimelineItem.t) && (Y() instanceof NexTimelineItem.o)) {
            NexTimelineItem.t tVar = (NexTimelineItem.t) Y();
            NexTimelineItem.o oVar = (NexTimelineItem.o) Y();
            if (tVar.getSplitScreenType() != null && tVar.getSplitScreenType() != SplitScreenType.OFF) {
                d(R.id.opt_layer_mask, false);
                d(R.id.opt_splitscreen, true);
            } else if (oVar.isLayerMaskEnabled()) {
                d(R.id.opt_splitscreen, false);
                d(R.id.opt_layer_mask, true);
            }
        }
    }

    protected void o(boolean z) {
        int[] a2 = C1697a.a(ua(), R.id.opt_layer_nudge);
        this.q.clear();
        for (int i : a2) {
            if (q(i)) {
                this.q.a(i);
            }
        }
        this.o.a(a2, Y() != null ? Y() : aa(), this.p, this.q, this.r, ea(), z, ta());
        this.o.a(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        C2073xd c2073xd = this.y;
        if (c2073xd != null) {
            c2073xd.a(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.s = a(layoutInflater, viewGroup, bundle);
        a(this.s);
        this.l = (ListView) this.s.findViewById(R.id.optionMenuList);
        this.l.setItemsCanFocus(true);
        this.x = layoutInflater.inflate(R.layout.option_menu_footer, (ViewGroup) this.l, false);
        if (this.x != null && !ya()) {
            this.l.addFooterView(this.x);
            this.t = this.x.findViewById(R.id.modearrow_left);
            this.u = this.x.findViewById(R.id.modearrow_right);
            this.v = this.x.findViewById(R.id.mode_grid);
            this.w = this.x.findViewById(R.id.mode_list);
            this.v.setOnClickListener(new Pc(this));
            this.w.setOnClickListener(new Qc(this));
        }
        this.m = this.s.findViewById(R.id.listViewDirectionUp);
        this.n = this.s.findViewById(R.id.listViewDirectionDown);
        na();
        return this.s;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        this.l = null;
        this.o = null;
        this.s = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.s;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new Tc(this));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.l.clearChoices();
    }

    protected boolean q(int i) {
        NexTimelineItem Y = Y();
        return Y != null && Y.isOptionApplied(i);
    }

    protected abstract boolean r(int i);

    protected boolean sa() {
        return false;
    }

    protected boolean ta() {
        return false;
    }

    protected abstract int[] ua();

    protected String va() {
        return null;
    }

    protected abstract String wa();

    public Context xa() {
        return this.s.getContext();
    }

    protected boolean ya() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public boolean b(int i) {
        return r(i);
    }

    public void d(int i, boolean z) {
        boolean z2 = !this.p.b(i);
        if (this.o == null || z2 == z) {
            return;
        }
        if (z) {
            this.p.c(i);
        } else {
            this.p.a(i);
        }
        this.o.notifyDataSetChanged();
    }

    public void e(int i, boolean z) {
        boolean b2 = this.r.b(i);
        if (this.o == null || b2 == z) {
            return;
        }
        if (z) {
            this.r.a(i);
        } else {
            this.r.c(i);
        }
        this.o.notifyDataSetChanged();
    }

    public void b(OptionMenuItem optionMenuItem) {
        C2073xd c2073xd = this.y;
        if (c2073xd != null) {
            c2073xd.a(optionMenuItem, this.p);
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.option_menu_fragment, viewGroup, false);
    }

    public void a(InterfaceC1997rd interfaceC1997rd) {
        if (interfaceC1997rd == null) {
            interfaceC1997rd = InterfaceC1997rd.f22506a;
        }
        this.z = interfaceC1997rd;
        C1935kd c1935kd = this.o;
        if (c1935kd != null) {
            c1935kd.a(this.z);
            this.y = null;
            za();
            this.o.notifyDataSetChanged();
        }
    }

    public void a(int i) {
        if (i == R.id.opt_color) {
            f(va());
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(OptionMenuItem optionMenuItem) {
        if (isAdded()) {
            b(optionMenuItem);
        }
    }

    public void a(int i, boolean z) {
        NexTimelineItem Y = Y();
        if (Y != null) {
            Task switchOption = Y.setSwitchOption(i, z, xa());
            if (switchOption == null) {
                if (i == R.id.opt_loop) {
                    d(R.id.opt_extend_to_end, z);
                    d(R.id.opt_split_trim, (Y.getSwitchOption(R.id.opt_loop) && Y.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
                }
                if (i == R.id.opt_extend_to_end) {
                    d(R.id.opt_split_trim, (Y.getSwitchOption(R.id.opt_loop) && Y.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
                }
                if (i == R.id.opt_background_color) {
                    d(R.id.opt_background_extend, z);
                }
                ra();
                G();
                return;
            }
            switchOption.onComplete(new Uc(this));
            switchOption.onFailure(new Vc(this));
            return;
        }
        if (aa() == null || aa().a(i, z, xa()) != null) {
            return;
        }
        if (i == R.id.opt_apply_style_to_all) {
            d(R.id.opt_text_font, z);
            d(R.id.opt_color, z);
            d(R.id.opt_shadow, z);
            d(R.id.opt_glow, z);
            d(R.id.opt_outline, z);
        }
        ra();
        G();
    }
}
