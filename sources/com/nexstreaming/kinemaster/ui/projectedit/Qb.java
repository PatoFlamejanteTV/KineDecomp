package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.ActivityChooserView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.GroupLayer;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineView;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: MultiSelectOptionFragment.java */
/* loaded from: classes2.dex */
public class Qb extends Bg implements VideoEditor.g {
    private ListView l;
    private b m;
    private int n;
    private a[] o = {new a(R.id.multi_opt_grouping, R.drawable.opt_icon_clip_group_normal), new a(R.id.multi_opt_align_starttime, R.drawable.opt_icon_align_starttime_normal), new a(R.id.multi_opt_align_endtime, R.drawable.opt_icon_align_endtime_normal), new a(R.id.multi_opt_trim_to_left, R.drawable.opt_icon_trim_starttime_normal), new a(R.id.multi_opt_trim_to_right, R.drawable.opt_icon_trim_endtime_normal), new a(R.id.multi_opt_split_at_playhead, R.drawable.opt_icon_split_playhead_normal)};
    private com.nexstreaming.app.general.util.z p = new com.nexstreaming.app.general.util.z();
    private AdapterView.OnItemClickListener q = new Ob(this);
    private UniformTimelineView.c r = new Pb(this);

    /* compiled from: MultiSelectOptionFragment.java */
    /* loaded from: classes2.dex */
    class a {

        /* renamed from: a, reason: collision with root package name */
        int f22030a;

        /* renamed from: b, reason: collision with root package name */
        int f22031b;

        public a(int i, int i2) {
            this.f22030a = i;
            this.f22031b = i2;
        }
    }

    /* compiled from: MultiSelectOptionFragment.java */
    /* loaded from: classes2.dex */
    public class b extends BaseAdapter {
        public b() {
        }

        public void a(int i, boolean z) {
            if ((!Qb.this.p.b(i)) == z) {
                return;
            }
            if (z) {
                Qb.this.p.c(i);
            } else {
                Qb.this.p.a(i);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return Qb.this.o.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (i < 0) {
                return null;
            }
            return Qb.this.o[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return Qb.this.o[i].f22030a;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.multi_sel_menu_list_item, viewGroup, false);
            }
            IconView iconView = (IconView) view.findViewById(R.id.icon);
            iconView.setIconColorStateList(R.color.pedit_icon_color_non_activated);
            iconView.setImageResource(Qb.this.o[i].f22031b);
            if (Qb.this.p.b(Qb.this.o[i].f22030a)) {
                iconView.setEnabled(false);
            } else {
                iconView.setEnabled(true);
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        da().f();
        int intValue = L().intValue();
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexSecondaryTimelineItem) {
                NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) fa;
                nexSecondaryTimelineItem.trimClip(intValue, nexSecondaryTimelineItem.getEndTime());
            }
        }
        ia();
        da().l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        da().f();
        int intValue = L().intValue();
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexSecondaryTimelineItem) {
                NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) fa;
                nexSecondaryTimelineItem.trimClip(nexSecondaryTimelineItem.getStartTime(), intValue);
            }
            da().c((NexTimelineItem) fa);
        }
        ia();
        da().l();
    }

    private boolean Ca() {
        int i = this.n;
        if (i > 1) {
            return false;
        }
        if (i == 1 && this.m != null) {
            int xa = xa();
            for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
                if ((fa instanceof NexSecondaryTimelineItem) && xa - ((NexSecondaryTimelineItem) fa).getDuration() < 0) {
                    this.m.a(R.id.multi_opt_align_endtime, false);
                    return false;
                }
            }
        }
        this.m.a(R.id.multi_opt_align_endtime, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Da() {
        if (this.m == null || P() == null) {
            return;
        }
        int i = this.n;
        if (i == 1) {
            this.m.a(R.id.multi_opt_grouping, false);
            this.m.a(R.id.multi_opt_trim_to_left, false);
            this.m.a(R.id.multi_opt_trim_to_right, false);
            this.m.a(R.id.multi_opt_split_at_playhead, false);
            this.m.a(R.id.multi_opt_align_starttime, true);
            Ca();
        } else if (i < 2 && P().size() != 0) {
            this.m.a(R.id.multi_opt_grouping, true);
            this.m.a(R.id.multi_opt_align_starttime, true);
            this.m.a(R.id.multi_opt_align_endtime, true);
            q(da().v());
        } else {
            this.m.a(R.id.multi_opt_grouping, false);
            this.m.a(R.id.multi_opt_trim_to_left, false);
            this.m.a(R.id.multi_opt_trim_to_right, false);
            this.m.a(R.id.multi_opt_split_at_playhead, false);
            this.m.a(R.id.multi_opt_align_starttime, false);
            this.m.a(R.id.multi_opt_align_endtime, false);
        }
        this.m.notifyDataSetInvalidated();
        this.m.a(R.id.multi_opt_grouping, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int j(Qb qb) {
        int i = qb.n;
        qb.n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int k(Qb qb) {
        int i = qb.n;
        qb.n = i - 1;
        return i;
    }

    private void q(int i) {
        b bVar;
        if (this.n > 0) {
            return;
        }
        if (P() != null && P().size() <= 0) {
            this.m.a(R.id.multi_opt_split_at_playhead, false);
            this.m.a(R.id.multi_opt_trim_to_left, false);
            this.m.a(R.id.multi_opt_trim_to_right, false);
            return;
        }
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexTimelineItem) {
                NexTimelineItem nexTimelineItem = (NexTimelineItem) fa;
                int absStartTime = nexTimelineItem.getAbsStartTime();
                int absEndTime = nexTimelineItem.getAbsEndTime();
                if ((i <= absStartTime || i >= absEndTime) && (bVar = this.m) != null) {
                    bVar.a(R.id.multi_opt_split_at_playhead, false);
                    this.m.a(R.id.multi_opt_trim_to_left, false);
                    this.m.a(R.id.multi_opt_trim_to_right, false);
                    this.m.notifyDataSetInvalidated();
                    return;
                }
                boolean isLoop = fa instanceof NexAudioClipItem ? ((NexAudioClipItem) fa).isLoop() : false;
                if (z && (i - absStartTime <= 500 || absEndTime - i <= 500 || isLoop || i >= V().intValue())) {
                    z = false;
                }
                if (z2 && (i - absStartTime <= 100 || absEndTime - i <= 500)) {
                    z2 = false;
                }
                if (z3 && (i - absStartTime <= 500 || absEndTime - i <= 100)) {
                    z3 = false;
                }
            }
        }
        b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.a(R.id.multi_opt_split_at_playhead, z);
            this.m.a(R.id.multi_opt_trim_to_left, z2);
            this.m.a(R.id.multi_opt_trim_to_right, z3);
        }
        this.m.notifyDataSetInvalidated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        int xa = xa();
        if (xa > V().intValue()) {
            xa = V().intValue();
        }
        da().f();
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexSecondaryTimelineItem) {
                NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) fa;
                int duration = xa - nexSecondaryTimelineItem.getDuration();
                if (duration >= 0) {
                    nexSecondaryTimelineItem.moveClip(duration);
                }
            }
        }
        ia();
        da().l();
        b(xa, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wa() {
        Iterator<com.nexstreaming.kinemaster.editorwrapper.Fa> it = P().iterator();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.nexstreaming.kinemaster.editorwrapper.Fa next = it.next();
            if (next instanceof NexVideoClipItem) {
                i = ((NexVideoClipItem) next).getUIStartTime();
                break;
            } else {
                int absStartTime = next instanceof NexTimelineItem ? ((NexTimelineItem) next).getAbsStartTime() : 0;
                if (i > absStartTime) {
                    i = absStartTime;
                }
            }
        }
        da().f();
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexSecondaryTimelineItem) {
                ((NexSecondaryTimelineItem) fa).moveClip(i);
            }
        }
        ia();
        da().l();
        b(i, true);
    }

    private int xa() {
        int i = Integer.MIN_VALUE;
        if (this.n > 1) {
            return Integer.MIN_VALUE;
        }
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexVideoClipItem) {
                return ((NexVideoClipItem) fa).getUIEndTime();
            }
            int absEndTime = fa instanceof NexSecondaryTimelineItem ? ((NexTimelineItem) fa).getAbsEndTime() : 0;
            if (i < absEndTime) {
                i = absEndTime;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ya() {
        if (P() == null || P().size() > 0) {
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i2 = Integer.MIN_VALUE;
            ArrayList<NexSecondaryTimelineItem> arrayList = new ArrayList();
            int i3 = -1;
            boolean z = true;
            for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
                if (!(fa instanceof NexSecondaryTimelineItem)) {
                    return;
                }
                NexSecondaryTimelineItem nexSecondaryTimelineItem = (NexSecondaryTimelineItem) fa;
                if (i > nexSecondaryTimelineItem.getStartTime()) {
                    i = nexSecondaryTimelineItem.getStartTime();
                }
                if (i2 < nexSecondaryTimelineItem.getEndTime()) {
                    i2 = nexSecondaryTimelineItem.getEndTime();
                }
                if (i3 != -1 && i3 != nexSecondaryTimelineItem.getTrackId()) {
                    z = false;
                }
                arrayList.add(nexSecondaryTimelineItem);
                i3 = nexSecondaryTimelineItem.getTrackId();
            }
            GroupLayer groupLayer = new GroupLayer();
            groupLayer.setRelativeStartTime(i);
            groupLayer.setRelativeEndTime(i2);
            da().f();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                da().a((NexTimelineItem) it.next());
            }
            da().l();
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem2 : arrayList) {
                nexSecondaryTimelineItem2.moveClip(nexSecondaryTimelineItem2.getStartTime() - i);
            }
            groupLayer.setChildItems(arrayList);
            NexLayerItem.b closestKeyframe = groupLayer.getClosestKeyframe(0.0f);
            groupLayer.getBounds(new Rect());
            closestKeyframe.f20232c = r3.centerX();
            closestKeyframe.f20233d = r3.centerY();
            closestKeyframe.f20231b = 1.0f;
            closestKeyframe.f20234e = 0.0f;
            for (NexSecondaryTimelineItem nexSecondaryTimelineItem3 : groupLayer.getChildList()) {
                if (nexSecondaryTimelineItem3 instanceof NexLayerItem) {
                    for (NexLayerItem.b bVar : ((NexLayerItem) nexSecondaryTimelineItem3).getKeyFrames()) {
                        bVar.f20232c -= closestKeyframe.f20232c;
                        bVar.f20233d -= closestKeyframe.f20233d;
                    }
                }
            }
            if (z) {
                groupLayer.setTrackId(i3);
            }
            da().a((NexLayerItem) groupLayer);
            f(groupLayer);
            a((NexTimelineItem) groupLayer);
            new Handler().post(new Nb(this, groupLayer));
            da().J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void za() {
        da().f();
        int intValue = L().intValue();
        for (com.nexstreaming.kinemaster.editorwrapper.Fa fa : P()) {
            if (fa instanceof NexSecondaryTimelineItem) {
                da().a((NexSecondaryTimelineItem) fa, intValue, O());
            }
        }
        da().l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        Da();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_multi_select, R.drawable.icon_multi_select_normal, R.id.action_delete, R.drawable.action_icon_delete);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.option_panel_multi_select, viewGroup, false);
        this.l = (ListView) inflate.findViewById(R.id.optionMenuList);
        this.m = new b();
        this.l.setAdapter((ListAdapter) this.m);
        this.l.setOnItemClickListener(this.q);
        a(this.r);
        da().a(this);
        na();
        return inflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        da().b(this);
        super.onDetach();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        q(i);
    }
}
