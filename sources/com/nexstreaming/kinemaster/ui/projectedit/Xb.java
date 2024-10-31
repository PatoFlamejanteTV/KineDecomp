package com.nexstreaming.kinemaster.ui.projectedit;

import android.R;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.BlendMode;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: OptionBlendModeFragment.java */
/* loaded from: classes2.dex */
public class Xb extends Bg implements AdapterView.OnItemClickListener, AbsListView.OnScrollListener, VideoEditor.g, I.a {
    private Slider l;
    private NexTimelineItem.a m;
    private NexTimelineItem.c n;
    private ListView o;
    private C1852ba p;
    private View q;
    private View r;
    private View s;
    int t = 0;
    BlendMode[] u;
    BlendMode v;
    BlendMode w;

    public Xb() {
        BlendMode blendMode = BlendMode.NONE;
        this.v = blendMode;
        this.w = blendMode;
    }

    private IABManager va() {
        if (getActivity() == null || !(getActivity() instanceof com.nextreaming.nexeditorui.I)) {
            return null;
        }
        return ((com.nextreaming.nexeditorui.I) getActivity()).y();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ma() {
        if (!ea() && this.n.getBlendMode().getPaidType() == IABManager.BillingType.PREMIUM) {
            getFragmentManager().beginTransaction().replace(R.id.content, com.nexstreaming.kinemaster.ui.settings.tb.a(va(), 0, "OptionBlendModeHeaderView", "Blending"), com.nexstreaming.kinemaster.ui.settings.tb.f23200a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.tb.f23200a).commitAllowingStateLoss();
            return true;
        }
        VideoEditor da = da();
        if (da != null) {
            da.J();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        com.nexstreaming.kinemaster.editorwrapper.Fa ca = ca();
        this.t = 0;
        if (ca instanceof NexTimelineItem.a) {
            this.m = (NexTimelineItem.a) ca;
            this.l.setValue((this.m.getAlpha() * 100) / 255);
        }
        if (ca instanceof NexTimelineItem.c) {
            this.n = (NexTimelineItem.c) ca;
            this.u = BlendMode.getDisplayedBlend();
            this.p = new C1852ba(this.u, getActivity());
            this.o.setAdapter((ListAdapter) this.p);
            this.o.setOnItemClickListener(this);
            BlendMode[] blendModeArr = this.u;
            int length = blendModeArr.length;
            for (int i = 0; i < length && blendModeArr[i] != this.n.getBlendMode(); i++) {
                this.t++;
            }
            if (this.u.length <= this.t) {
                this.t = 0;
            }
            BlendMode[] blendModeArr2 = this.u;
            int i2 = this.t;
            BlendMode blendMode = blendModeArr2[i2];
            this.v = blendMode;
            this.w = blendMode;
            this.o.setItemChecked(i2, true);
            this.o.setOnScrollListener(this);
            this.o.post(new Vb(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        if (Y() instanceof NexLayerItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else {
            super.oa();
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.q = layoutInflater.inflate(com.nexstreaming.app.kinemasterfree.R.layout.option_blend_mode_fragment, viewGroup, false);
        a(this.q);
        n(com.nexstreaming.app.kinemasterfree.R.string.opt_blending);
        f(true);
        this.l = (Slider) this.q.findViewById(com.nexstreaming.app.kinemasterfree.R.id.opacityBar);
        this.l.setListener(new Ub(this));
        this.o = (ListView) this.q.findViewById(com.nexstreaming.app.kinemasterfree.R.id.optionMenuList);
        this.o.setChoiceMode(1);
        this.r = this.q.findViewById(com.nexstreaming.app.kinemasterfree.R.id.listViewDirectionUp);
        this.s = this.q.findViewById(com.nexstreaming.app.kinemasterfree.R.id.listViewDirectionDown);
        na();
        return this.q;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroy() {
        Log.d("BlendModeFragment", "onDestroy");
        super.onDestroy();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        Log.d("BlendModeFragment", "onDestroyView");
        ta();
        this.o = null;
        this.p = null;
        this.q = null;
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        BlendMode blendMode = (BlendMode) this.p.getItem(i);
        this.n.setBlendMode(blendMode);
        Log.d("BlendMode", "setBlendMode:" + blendMode.getBlendModeType());
        this.v = blendMode;
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.q;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new Wb(this));
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.r == null || this.s == null) {
            return;
        }
        int height = absListView.getHeight();
        int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
        if (i == 0 && (absListView.getChildAt(0) == null || absListView.getChildAt(0).getTop() >= 0)) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
        if (i3 > 0 && i + i2 >= i3 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
            this.s.setVisibility(8);
        } else {
            this.s.setVisibility(0);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        if (Y() instanceof NexLayerItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_expand_preview, com.nexstreaming.app.kinemasterfree.R.drawable.action_inset_preview, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else {
            super.pa();
        }
    }

    public BlendMode sa() {
        return this.v;
    }

    public void ta() {
        VideoEditor da;
        if (ea() || this.v.getPaidType() != IABManager.BillingType.PREMIUM || (da = da()) == null) {
            return;
        }
        for (Fa.a aVar : da.s().a().getSecondaryItems()) {
            if (aVar instanceof NexTimelineItem.c) {
                NexTimelineItem.c cVar = (NexTimelineItem.c) aVar;
                if (cVar.getBlendMode().getPaidType() == IABManager.BillingType.PREMIUM) {
                    cVar.setBlendMode(BlendMode.NONE);
                    this.v = BlendMode.NONE;
                }
            }
        }
        NexTimelineItem.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.setAlpha(255);
        }
        da.a(NexEditor.FastPreviewOption.normal, 0, true);
        da.J();
    }
}
