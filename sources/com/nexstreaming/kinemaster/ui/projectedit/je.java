package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.util.C1712p;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nexstreaming.kinemaster.ui.widget.PopoutListMenu;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Iterator;

/* compiled from: OptionSplitScreenFragment.java */
/* loaded from: classes2.dex */
public class Je extends Bg implements View.OnClickListener, InterfaceC1866cf, View.OnLongClickListener {
    private NexTimelineItem.t l;
    private NexLayerItem m;
    private ViewOnLayoutChangeListenerC1995rb n = new ViewOnLayoutChangeListenerC1995rb(this);
    private final C1712p<Integer, SplitScreenType> o = new C1712p<>(Integer.valueOf(R.id.split_left), SplitScreenType.LEFT, Integer.valueOf(R.id.split_right), SplitScreenType.RIGHT, Integer.valueOf(R.id.split_top), SplitScreenType.TOP, Integer.valueOf(R.id.split_bottom), SplitScreenType.BOTTOM, Integer.valueOf(R.id.split_full), SplitScreenType.FULL, Integer.valueOf(R.id.split_off), SplitScreenType.OFF);
    private View p;

    private int a(SplitScreenType splitScreenType) {
        return this.o.a(splitScreenType).intValue();
    }

    private SplitScreenType q(int i) {
        return this.o.get(Integer.valueOf(i));
    }

    private void va() {
        if (this.p == null) {
            return;
        }
        Iterator<Integer> it = this.o.a().iterator();
        while (it.hasNext()) {
            View findViewById = this.p.findViewById(it.next().intValue());
            if (findViewById != null) {
                findViewById.setActivated(false);
            }
        }
    }

    private void wa() {
        ViewOnLayoutChangeListenerC1995rb viewOnLayoutChangeListenerC1995rb;
        if (!this.m.isSplitScreenEnabled() || getActivity() == null || getActivity().getIntent() == null || getActivity().getIntent().getBooleanExtra("split_screen_guide_animation", false) || (viewOnLayoutChangeListenerC1995rb = this.n) == null) {
            return;
        }
        viewOnLayoutChangeListenerC1995rb.d();
        this.n.b();
        getActivity().getIntent().putExtra("split_screen_guide_animation", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        this.l = (NexTimelineItem.t) Y();
        if (this.l != null) {
            this.m = (NexLayerItem) Y();
            va();
            this.p.findViewById(a(this.l.getSplitScreenType())).setActivated(true);
            this.n.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        wa();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SplitScreenType q = q(view.getId());
        if (q == this.l.getSplitScreenType()) {
            return;
        }
        va();
        view.setActivated(true);
        this.l.setSplitScreenType(q);
        if (this.l.getSplitScreenType() != SplitScreenType.OFF) {
            NexLayerItem nexLayerItem = this.m;
            nexLayerItem.fitKeyframeToSplitscreenRect(nexLayerItem.getSplitScreenKeyframe());
            wa();
        }
        VideoEditor da = da();
        if (da != null) {
            da.J();
            da.a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.p = layoutInflater.inflate(R.layout.pedit_option_splitscreen_fragment, viewGroup, false);
        a(this.p);
        n(R.string.opt_split_screen);
        f(true);
        Iterator<Integer> it = this.o.a().iterator();
        while (it.hasNext()) {
            View findViewById = this.p.findViewById(it.next().intValue());
            findViewById.setOnClickListener(this);
            findViewById.setOnLongClickListener(this);
        }
        na();
        Q().addOnLayoutChangeListener(this.n);
        return this.p;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.p = null;
        Q().removeOnLayoutChangeListener(this.n);
        this.n.a();
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        SplitScreenType q = q(view.getId());
        PopoutListMenu popoutListMenu = new PopoutListMenu(getActivity(), PopoutListMenu.ArrowDirection.RIGHT_CENTER);
        popoutListMenu.a(-1, R.string.layer_menu_setdefault);
        popoutListMenu.a(new Ie(this, q));
        popoutListMenu.a(view, 3);
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.n.c();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        return this.n.a(view, motionEvent);
    }
}
