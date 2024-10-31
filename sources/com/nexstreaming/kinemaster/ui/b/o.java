package com.nexstreaming.kinemaster.ui.b;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.util.v;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.at;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: MiniFxGroupBrowserFragment.java */
/* loaded from: classes.dex */
public class o extends c implements AbsListView.OnScrollListener, ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener {

    /* renamed from: a, reason: collision with root package name */
    private String f3702a;
    private ExpandableListView b;
    private b c;
    private Set<String> d = new HashSet(Arrays.asList("com.nexstreaming.kinemaster.builtin3.overlay.sticker", "com.nexstreaming.kinemaster.builtin.overlay.handwriting", "com.nexstreaming.kinemaster.basic.accent", "com.nexstreaming.kinemaster.basic.transition", "com.nexstreaming.kinemaster.energy.accent"));
    private boolean e = false;
    private View f;
    private View g;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.effect_expandable_list_fragment, viewGroup, false);
        b(inflate);
        this.b = (ExpandableListView) inflate.findViewById(R.id.effectExpandableList);
        inflate.findViewById(R.id.optionMenuDone).setOnClickListener(new p(this));
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new q(this, inflate));
        this.f = inflate.findViewById(R.id.listViewDirectionUp);
        this.g = inflate.findViewById(R.id.listViewDirectionDown);
        this.b.setOnScrollListener(this);
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (h()) {
            a(R.id.action_undo, 0, R.id.action_redo, 0);
        } else if ((m() instanceof NexVideoClipItem) && ((NexVideoClipItem) m()).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() != null) {
            if (h()) {
                f(R.string.transition_effect_panel_title);
            } else {
                f(R.string.clip_effect_panel_title);
                d(true);
            }
            this.c = e();
            this.b.setAdapter(this.c);
            this.b.setOnChildClickListener(this);
            this.b.setOnGroupClickListener(this);
            if (this.c.c >= 0 && this.c.b >= 0) {
                this.b.expandGroup(this.c.b);
                this.b.setSelectedChild(this.c.b, this.c.c, true);
                this.b.post(new r(this));
            }
        }
    }

    private String a(com.nexstreaming.kinemaster.kmpackage.b bVar) {
        String b = bVar.b(getActivity());
        if (b == null || b.trim().length() < 1) {
            return "???";
        }
        return b;
    }

    private boolean h() {
        return m() != null && (m() instanceof NexTransitionItem);
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        if (i == 0) {
            this.c.a(expandableListView, 0, 0);
            this.c.notifyDataSetChanged();
            ((NexTimelineItem.j) m()).setEffect(null);
            c();
            if (o() != null) {
                o().a(m());
            }
            o().a(e(false), true);
            g(0);
        } else if (expandableListView.isGroupExpanded(i)) {
            expandableListView.collapseGroup(i);
        } else {
            for (int i2 = 0; i2 < this.c.f3686a.size(); i2++) {
                if (i2 == i) {
                    expandableListView.expandGroup(i);
                } else if (expandableListView.isGroupExpanded(i2)) {
                    expandableListView.collapseGroup(i2);
                }
            }
            expandableListView.postOnAnimation(new s(this, expandableListView, i));
        }
        return true;
    }

    protected b e() {
        at[] b;
        int i;
        int i2 = -1;
        this.f3702a = ((NexTimelineItem.j) m()).getEffectID();
        EffectLibrary a2 = EffectLibrary.a(getActivity());
        if (m() instanceof NexTransitionItem) {
            b = a2.a(6);
        } else {
            b = a2.b(6);
        }
        HashMap hashMap = new HashMap();
        for (at atVar : b) {
            if (!this.d.contains(atVar.a())) {
                String a3 = a(atVar);
                Set set = (Set) hashMap.get(a3);
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(a3, set);
                }
                set.add(atVar);
            }
        }
        ArrayList arrayList = new ArrayList(hashMap.size() + 1);
        for (Map.Entry entry : hashMap.entrySet()) {
            ArrayList arrayList2 = new ArrayList((Collection) entry.getValue());
            Collections.sort(arrayList2, new t(this));
            arrayList.add(new a((String) entry.getKey(), arrayList2));
        }
        Collections.sort(arrayList, new u(this));
        arrayList.add(0, new a(getResources().getString(R.string.transition_none), null));
        int size = arrayList.size();
        int i3 = 0;
        loop2: while (true) {
            if (i3 >= size) {
                i = -1;
                break;
            }
            a aVar = (a) arrayList.get(i3);
            if (aVar.b != null) {
                int size2 = aVar.b.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    if (aVar.b.get(i4).a().equals(this.f3702a)) {
                        i = i4;
                        i2 = i3;
                        break loop2;
                    }
                }
            }
            i3++;
        }
        return new b(arrayList, m() instanceof NexTransitionItem, i2, i);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (v.a(((NexTimelineItem.j) m()).getEffectID(), this.f3702a) != 0 && o() != null) {
            o().l();
        }
        c();
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onStart() {
        String str = null;
        if (m() != null) {
            str = ((NexTimelineItem.j) m()).getEffectID();
        }
        if (str == null) {
            c();
        } else {
            g_();
        }
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onPause() {
        if (this.e) {
            this.e = false;
            d();
            String effectID = ((NexTimelineItem.j) m()).getEffectID();
            if (h()) {
                KMUsage.EditScreen_Transition.logEvent(ShareConstants.WEB_DIALOG_PARAM_ID, effectID);
            } else {
                KMUsage.EditScreen_ClipEffect.logEvent(ShareConstants.WEB_DIALOG_PARAM_ID, effectID);
            }
        }
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onStop() {
        c();
        super.onStop();
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        if (this.c.c == i2 && this.c.b == i) {
            b(getFragmentManager().beginTransaction()).replace(R.id.optionPanelHolder, new f().a(m())).addToBackStack("").commit();
        } else {
            String effectID = ((NexTimelineItem.j) m()).getEffectID();
            com.nexstreaming.kinemaster.kmpackage.b child = this.c.getChild(i, i2);
            if (effectID == null || child == null || !child.a().equals(effectID)) {
                ((NexTimelineItem.j) m()).setEffect(child);
                if (m() instanceof NexTransitionItem) {
                    NexTransitionItem nexTransitionItem = (NexTransitionItem) m();
                    if (nexTransitionItem.getEffectDuration() > (30000 < nexTransitionItem.getDurationLimit() ? 30.0f : nexTransitionItem.getDurationLimit() / 1000.0f) * 1000.0f) {
                        nexTransitionItem.setDuration(nexTransitionItem.getEffectDuration());
                    }
                }
                this.c.a(expandableListView, i, i2);
                this.c.notifyDataSetChanged();
                g(R.id.editmode_fxtime);
                f_();
                this.e = true;
            }
        }
        return true;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.f != null && this.g != null) {
            int height = absListView.getHeight();
            int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
            if (i3 > 0 && i + i2 >= i3 && i2 > 0 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
