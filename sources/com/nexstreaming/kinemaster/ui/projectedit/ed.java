package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.projectedit.OptionMenuItem;
import com.nexstreaming.kinemaster.ui.projectedit.ep;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: OptionListFragment.java */
/* loaded from: classes.dex */
public abstract class ed extends kp implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, ep.a {

    /* renamed from: a, reason: collision with root package name */
    private ListView f3864a;
    private ep b;
    private View c;
    private com.nexstreaming.app.general.util.q d = new com.nexstreaming.app.general.util.q();
    private com.nexstreaming.app.general.util.q e = new com.nexstreaming.app.general.util.q();
    private com.nexstreaming.app.general.util.q f = new com.nexstreaming.app.general.util.q();
    private View g;
    private View h;
    private View i;
    private View j;
    private View k;
    private View l;
    private View m;

    protected abstract String a();

    protected abstract int[] c();

    protected abstract boolean d(int i);

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = a_(layoutInflater, viewGroup, bundle);
        b(this.c);
        this.f3864a = (ListView) this.c.findViewById(R.id.optionMenuList);
        this.m = layoutInflater.inflate(R.layout.option_menu_footer, (ViewGroup) this.f3864a, false);
        if (this.m != null && !j()) {
            this.f3864a.addFooterView(this.m);
            this.i = this.m.findViewById(R.id.modearrow_left);
            this.j = this.m.findViewById(R.id.modearrow_right);
            this.k = this.m.findViewById(R.id.mode_grid);
            this.l = this.m.findViewById(R.id.mode_list);
            this.k.setOnClickListener(new ee(this));
            this.l.setOnClickListener(new ef(this));
        }
        this.g = this.c.findViewById(R.id.listViewDirectionUp);
        this.h = this.c.findViewById(R.id.listViewDirectionDown);
        f();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View a_(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.option_menu_fragment, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String j_() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context i() {
        return this.c.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (getActivity() != null) {
            boolean z = PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean("km.optionListGrid", false);
            if (j() && this.m != null) {
                this.m.setVisibility(8);
            }
            if (this.i != null && this.k != null && this.j != null && this.l != null) {
                this.i.setVisibility(z ? 0 : 4);
                this.j.setVisibility(z ? 4 : 0);
                this.k.setActivated(z);
                this.l.setActivated(!z);
            }
            if (m() != null) {
                b(a());
                c(j_());
                if (this.b == null) {
                    this.b = new ep();
                    b(z);
                    this.f3864a.setAdapter((ListAdapter) this.b);
                } else {
                    b(z);
                    this.b.notifyDataSetChanged();
                }
                this.f3864a.setOnItemClickListener(this);
                this.f3864a.setOnScrollListener(this);
                this.f3864a.post(new eg(this));
                if ((m() instanceof NexTimelineItem.r) && (m() instanceof NexTimelineItem.m)) {
                    NexTimelineItem.r rVar = (NexTimelineItem.r) m();
                    NexTimelineItem.m mVar = (NexTimelineItem.m) m();
                    if (rVar.getSplitScreenType() != null && rVar.getSplitScreenType() != SplitScreenType.OFF) {
                        b(R.id.opt_layer_mask, false);
                        b(R.id.opt_splitscreen, true);
                    } else if (mVar.isLayerMaskEnabled()) {
                        b(R.id.opt_splitscreen, false);
                        b(R.id.opt_layer_mask, true);
                    }
                }
            }
        }
    }

    protected void b(boolean z) {
        int[] c = c();
        this.e.clear();
        for (int i : c) {
            if (b(i)) {
                this.e.a(i);
            }
        }
        this.b.a(c, m(), this.d, this.e, this.f, F(), z, e());
        this.b.a(this);
    }

    protected boolean e() {
        return false;
    }

    protected boolean j() {
        return false;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3864a = null;
        this.b = null;
        this.c = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, boolean z) {
        boolean z2 = !this.d.b(i);
        if (this.b != null && z2 != z) {
            if (z) {
                this.d.c(i);
            } else {
                this.d.a(i);
            }
            this.b.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, boolean z) {
        boolean b = this.f.b(i);
        if (this.b != null && b != z) {
            if (z) {
                this.f.a(i);
            } else {
                this.f.c(i);
            }
            this.b.notifyDataSetChanged();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void a(OptionMenuItem optionMenuItem) {
        b(optionMenuItem);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (isAdded()) {
            b(OptionMenuItem.fromId((int) adapterView.getItemIdAtPosition(i)));
        }
    }

    private void b(OptionMenuItem optionMenuItem) {
        if (isAdded() && optionMenuItem != null) {
            KMUsage.EditScreen_Option_Tap.logEvent("OptItem", optionMenuItem.name());
            if (this.d.b(optionMenuItem.id)) {
                this.f3864a.clearChoices();
                this.b.notifyDataSetChanged();
                return;
            }
            if (optionMenuItem.subscriptionFeature && !F()) {
                this.f3864a.clearChoices();
                this.b.notifyDataSetChanged();
                new com.nexstreaming.kinemaster.d.a((com.nextreaming.nexeditorui.ba) getActivity(), "opt:" + optionMenuItem.name()).show();
                return;
            }
            if (d(optionMenuItem.id)) {
                this.f3864a.clearChoices();
                this.b.notifyDataSetChanged();
                return;
            }
            if (optionMenuItem.id == R.id.opt_layer_name) {
                NexTimelineItem m = m();
                if (m instanceof NexLayerItem) {
                    String layerName = ((NexLayerItem) m).getLayerName();
                    FullScreenInputActivity.a a2 = FullScreenInputActivity.a(getActivity());
                    if (layerName == null) {
                        layerName = "";
                    }
                    startActivityForResult(a2.a(layerName).a(R.string.layer_name_hint).e(true).c(false).b(false).a(), R.id.req_edit_layer_name);
                }
                this.f3864a.clearChoices();
                this.b.notifyDataSetChanged();
                return;
            }
            if (optionMenuItem.type == OptionMenuItem.Type.Color) {
                ColorPickerPopup colorPickerPopup = new ColorPickerPopup(getActivity(), false);
                colorPickerPopup.a(new eh(this, optionMenuItem));
                colorPickerPopup.b(m().getColorOption(optionMenuItem.id));
                return;
            }
            if (optionMenuItem.type == OptionMenuItem.Type.ColorWithAlpha) {
                ColorPickerPopup colorPickerPopup2 = new ColorPickerPopup(getActivity(), true);
                colorPickerPopup2.a(new ei(this, optionMenuItem));
                colorPickerPopup2.b(m().getColorOption(optionMenuItem.id));
                return;
            }
            if (optionMenuItem.type != OptionMenuItem.Type.Color && optionMenuItem.type != OptionMenuItem.Type.ColorWithAlpha && optionMenuItem.switchWidget) {
                NexTimelineItem m2 = m();
                if (m2 != null) {
                    a(optionMenuItem.id, !m2.getSwitchOption(optionMenuItem.id));
                    this.f3864a.clearChoices();
                    this.b.notifyDataSetInvalidated();
                    return;
                }
                return;
            }
            if (optionMenuItem.fragmentClass == null) {
                this.f3864a.clearChoices();
                this.b.notifyDataSetChanged();
                return;
            }
            if (!optionMenuItem.expandedUI || getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder) == null || getFragmentManager().findFragmentById(R.id.expandedOptionPanelHolder).getClass() != optionMenuItem.fragmentClass) {
                try {
                    kp newInstance = optionMenuItem.fragmentClass.newInstance();
                    newInstance.a(m());
                    b(getFragmentManager().beginTransaction()).replace(optionMenuItem.expandedUI ? R.id.expandedOptionPanelHolder : R.id.optionPanelHolder, newInstance).addToBackStack("panel_" + optionMenuItem.id).commit();
                } catch (IllegalAccessException e) {
                    Log.w("OptionMenuFragment", "Failed to instantiate editing fragment", e);
                } catch (InstantiationException e2) {
                    Log.w("OptionMenuFragment", "Failed to instantiate editing fragment", e2);
                }
            }
        }
    }

    protected boolean b(int i) {
        NexTimelineItem m = m();
        return m != null && m.isOptionApplied(i);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f3864a.clearChoices();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ej(this));
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void a(int i, boolean z) {
        NexTimelineItem m = m();
        if (m != null) {
            Task switchOption = m.setSwitchOption(i, z, i());
            if (switchOption == null) {
                if (i == R.id.opt_loop) {
                    b(R.id.opt_extend_to_end, z);
                    b(R.id.opt_split_trim, (m.getSwitchOption(R.id.opt_loop) && m.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
                }
                if (i == R.id.opt_extend_to_end) {
                    b(R.id.opt_split_trim, (m.getSwitchOption(R.id.opt_loop) && m.getSwitchOption(R.id.opt_extend_to_end)) ? false : true);
                }
                if (i == R.id.opt_background_color) {
                    b(R.id.opt_background_extend, z);
                }
                z();
                d();
                return;
            }
            switchOption.onComplete(new ek(this));
            switchOption.onFailure(new el(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.g != null && this.h != null) {
            int height = absListView.getHeight();
            View childAt = absListView.getChildAt(i2 - 1);
            int bottom = childAt != null ? childAt.getBottom() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
            if (i3 > 0 && i + i2 >= i3 && i2 > 0 && bottom <= height + 5) {
                this.h.setVisibility(8);
            } else {
                this.h.setVisibility(0);
            }
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == 1 && i == R.id.req_edit_layer_name) {
            NexTimelineItem m = m();
            if (m instanceof NexLayerItem) {
                ((NexLayerItem) m).setLayerName(FullScreenInputActivity.b(intent));
                d();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
