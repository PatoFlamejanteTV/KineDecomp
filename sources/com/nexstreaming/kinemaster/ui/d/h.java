package com.nexstreaming.kinemaster.ui.d;

import android.R;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nextreaming.nexeditorui.C2302d;
import com.nextreaming.nexeditorui.C2304e;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OptionGroupFilterFragment.java */
/* loaded from: classes.dex */
public class h extends m {
    private AdapterView.OnItemClickListener D = new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.d.d
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
            h.this.a(adapterView, view, i, j);
        }
    };
    private AdapterView.OnItemClickListener E = new AdapterView.OnItemClickListener() { // from class: com.nexstreaming.kinemaster.ui.d.a
        @Override // android.widget.AdapterView.OnItemClickListener
        public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
            h.this.b(adapterView, view, i, j);
        }
    };

    private IABManager Da() {
        if (getActivity() == null || !(getActivity() instanceof I)) {
            return null;
        }
        return ((I) getActivity()).y();
    }

    private void Ea() {
        VideoEditor da = da();
        if (da != null) {
            da.J();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.d.m
    public boolean Aa() {
        return true;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.m
    protected void Ba() {
        Fa.a Y = Y();
        if (Y instanceof NexTimelineItem.h) {
            r(0);
            ColorEffect colorEffect = ((NexTimelineItem.h) Y).getColorEffect();
            if (colorEffect != null) {
                Iterator<n> it = this.u.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Iterator<f> it2 = it.next().a().iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        if (it2.next().a(colorEffect)) {
                            r(i);
                            q(i2);
                            break;
                        }
                        i2++;
                    }
                    i++;
                }
            }
        }
    }

    public void Ca() {
        VideoEditor da;
        NexTimelineItem.h hVar;
        ColorEffect colorEffect;
        NexTimelineItem.h hVar2;
        ColorEffect colorEffect2;
        if (ea() || (da = da()) == null) {
            return;
        }
        NexTimeline a2 = da.s().a();
        for (Fa.a aVar : a2.getPrimaryItems()) {
            if ((aVar instanceof NexTimelineItem.h) && (colorEffect2 = (hVar2 = (NexTimelineItem.h) aVar).getColorEffect()) != null && colorEffect2.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_NONE && colorEffect2.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_BASIC) {
                hVar2.setColorEffect(ColorEffect.COLOR_FILTER_NONE);
            }
        }
        for (Fa.a aVar2 : a2.getSecondaryItems()) {
            if ((aVar2 instanceof NexTimelineItem.h) && (colorEffect = (hVar = (NexTimelineItem.h) aVar2).getColorEffect()) != null && colorEffect.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_NONE && colorEffect.getFilterType() != ColorEffect.FilterType.FILTER_TYPE_BASIC) {
                hVar.setColorEffect(ColorEffect.COLOR_FILTER_NONE);
            }
        }
        da.c(Y());
        da.H();
        Ea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.d.m
    public void a(f fVar) {
        Object object = fVar.getObject();
        Fa.a Y = Y();
        if ((Y instanceof NexTimelineItem.h) && (object instanceof ColorEffect)) {
            ((NexTimelineItem.h) Y).setColorEffect((ColorEffect) object);
        }
    }

    public /* synthetic */ void b(AdapterView adapterView, View view, final int i, long j) {
        if (this.w.a()) {
            return;
        }
        this.w.a(i);
        this.t.post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.d.c
            @Override // java.lang.Runnable
            public final void run() {
                h.this.s(i);
            }
        });
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ma() {
        ColorEffect.FilterType filterType;
        if (!ea()) {
            Fa.a Y = Y();
            if (Y instanceof NexTimelineItem.h) {
                NexTimelineItem.h hVar = (NexTimelineItem.h) Y;
                if (hVar.getColorEffect() != null && (filterType = hVar.getColorEffect().getFilterType()) != null && filterType != ColorEffect.FilterType.FILTER_TYPE_NONE && filterType != ColorEffect.FilterType.FILTER_TYPE_BASIC) {
                    getFragmentManager().beginTransaction().replace(R.id.content, tb.a(Da(), 0, "OptionGroupColorFilterHeaderView", "Color Filter"), tb.f23200a).addToBackStack(tb.f23200a).commitAllowingStateLoss();
                    return true;
                }
            }
        }
        Ea();
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        NexTimelineItem Y = Y();
        if (Y instanceof NexLayerItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else if (Y instanceof NexVideoClipItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else {
            super.oa();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        return ma();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        Ca();
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        NexTimelineItem Y = Y();
        if (Y instanceof NexLayerItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_expand_preview, com.nexstreaming.app.kinemasterfree.R.drawable.action_inset_preview, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else if (Y instanceof NexVideoClipItem) {
            a(com.nexstreaming.app.kinemasterfree.R.id.action_undo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_redo, 0, com.nexstreaming.app.kinemasterfree.R.id.action_expand_preview, com.nexstreaming.app.kinemasterfree.R.drawable.action_inset_preview, com.nexstreaming.app.kinemasterfree.R.id.action_delete, com.nexstreaming.app.kinemasterfree.R.drawable.action_icon_delete);
        } else {
            super.pa();
        }
    }

    public /* synthetic */ void s(int i) {
        Fa.a Y = Y();
        if (Y instanceof NexTimelineItem.h) {
            NexTimelineItem.h hVar = (NexTimelineItem.h) Y;
            Object object = ((f) this.w.getItem(i)).getObject();
            if (object instanceof ColorEffect) {
                ColorEffect colorEffect = (ColorEffect) object;
                hVar.setColorEffect(colorEffect);
                colorEffect.getPresetName();
            }
            VideoEditor da = da();
            if (da != null) {
                da.c(Y());
                da.H();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.d.m
    protected AdapterView.OnItemClickListener wa() {
        return this.E;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.m
    protected AdapterView.OnItemClickListener xa() {
        return this.D;
    }

    @Override // com.nexstreaming.kinemaster.ui.d.m
    protected List<n> ya() {
        ArrayList arrayList = new ArrayList();
        C2304e c2304e = new C2304e(0, true, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.effect_browser_default_effect), null, com.nexstreaming.app.kinemasterfree.R.drawable.fx_none);
        c2304e.a(new C2302d(ColorEffect.COLOR_FILTER_NONE.getPresetName(), ColorEffect.COLOR_FILTER_NONE));
        arrayList.add(c2304e);
        C2304e c2304e2 = new C2304e(1, true, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_basic), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_b07);
        for (ColorEffect colorEffect : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_BASIC)) {
            c2304e2.a(new C2302d(colorEffect.getPresetName(), colorEffect));
        }
        arrayList.add(c2304e2);
        C2304e c2304e3 = new C2304e(2, false, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_warm), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_w03);
        for (ColorEffect colorEffect2 : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_WARM)) {
            c2304e3.a(new C2302d(colorEffect2.getPresetName(), colorEffect2));
        }
        arrayList.add(c2304e3);
        C2304e c2304e4 = new C2304e(3, false, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_cold), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_c02);
        for (ColorEffect colorEffect3 : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_COLD)) {
            c2304e4.a(new C2302d(colorEffect3.getPresetName(), colorEffect3));
        }
        arrayList.add(c2304e4);
        C2304e c2304e5 = new C2304e(4, false, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_vivid), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_v02);
        for (ColorEffect colorEffect4 : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_VIVID)) {
            c2304e5.a(new C2302d(colorEffect4.getPresetName(), colorEffect4));
        }
        arrayList.add(c2304e5);
        C2304e c2304e6 = new C2304e(5, false, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_mono), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_m01);
        for (ColorEffect colorEffect5 : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_MONOCHROME)) {
            c2304e6.a(new C2302d(colorEffect5.getPresetName(), colorEffect5));
        }
        arrayList.add(c2304e6);
        C2304e c2304e7 = new C2304e(6, false, getResources().getString(com.nexstreaming.app.kinemasterfree.R.string.filter_low_saturation), null, com.nexstreaming.app.kinemasterfree.R.drawable.thumb_lut_l12);
        for (ColorEffect colorEffect6 : ColorEffect.getColorFilters(ColorEffect.FilterType.FILTER_TYPE_LOWSATURATION)) {
            c2304e7.a(new C2302d(colorEffect6.getPresetName(), colorEffect6));
        }
        arrayList.add(c2304e7);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.d.m
    public int za() {
        return com.nexstreaming.app.kinemasterfree.R.string.colortint_panel_title;
    }

    public /* synthetic */ void a(AdapterView adapterView, View view, int i, long j) {
        g gVar = this.v;
        if (gVar == null || gVar.getCount() > i) {
            if (i != this.v.a()) {
                va();
            }
            final C2304e c2304e = (C2304e) this.v.getItem(i);
            if (i == this.x) {
                return;
            }
            this.x = i;
            this.v.a(i);
            if (c2304e.getType() == 0) {
                a(getResources().getDimensionPixelOffset(com.nexstreaming.app.kinemasterfree.R.dimen.pedit_expand_option_panel_width));
                this.v.a(i);
                n(za());
                this.s.post(new Runnable() { // from class: com.nexstreaming.kinemaster.ui.d.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.a(c2304e);
                    }
                });
                return;
            }
            a(getResources().getDimensionPixelOffset(com.nexstreaming.app.kinemasterfree.R.dimen.pedit_expand_option_panel_width_half));
            if (this.w == null) {
                this.w = new e(requireContext(), Aa());
                this.t.setAdapter((ListAdapter) this.w);
            }
            this.w.a(false);
            this.w.a(c2304e.f());
            Fa.a Y = Y();
            if (Y instanceof NexTimelineItem.h) {
                NexTimelineItem.h hVar = (NexTimelineItem.h) Y;
                for (int i2 = 0; i2 < this.w.getCount(); i2++) {
                    if (((f) this.w.getItem(i2)).a(hVar)) {
                        this.w.a(i2);
                        this.t.setSelection(i2);
                        return;
                    }
                }
                return;
            }
            this.t.setSelection(0);
        }
    }

    public /* synthetic */ void a(C2304e c2304e) {
        Fa.a Y = Y();
        if (Y instanceof NexTimelineItem.h) {
            NexTimelineItem.h hVar = (NexTimelineItem.h) Y;
            ColorEffect colorEffect = ColorEffect.COLOR_FILTER_NONE;
            if (c2304e.e().size() > 0 && c2304e.e().get(0).a() != null) {
                colorEffect = c2304e.e().get(0).a();
            }
            hVar.setColorEffect(colorEffect);
            VideoEditor da = da();
            if (da != null) {
                da.c(Y());
                da.H();
            }
        }
    }
}
