package com.nexstreaming.kinemaster.ui.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CategoryAndEffectListAdapter.java */
/* loaded from: classes.dex */
public class b extends BaseExpandableListAdapter {

    /* renamed from: a, reason: collision with root package name */
    List<a> f3686a;
    int b;
    int c;
    private final boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(List<a> list, boolean z, int i, int i2) {
        this.b = -1;
        this.c = -1;
        this.f3686a = list;
        this.d = z;
        this.b = i;
        this.c = i2;
    }

    public void a(ViewGroup viewGroup, int i, int i2) {
        this.b = i;
        this.c = i2;
        long j = i2 | (i << 32);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            Object tag = childAt.getTag(R.id.tag_group_child_pos);
            if (tag != null && (tag instanceof Long)) {
                childAt.setActivated(((Long) tag).longValue() == j);
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f3686a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f3686a.get(i).b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a getGroup(int i) {
        return this.f3686a.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.nexstreaming.kinemaster.kmpackage.b getChild(int i, int i2) {
        return this.f3686a.get(i).b.get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return (i << 32) | i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_effect_browser_list_cat, viewGroup, false);
        }
        view.setActivated(false);
        view.setTag(R.id.tag_group_child_pos, 0L);
        ((TextView) view.findViewById(R.id.text)).setText(this.f3686a.get(i).f3685a);
        ImageView imageView = (ImageView) view.findViewById(R.id.expand_indicator);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.cat_icon);
        if (i == 0) {
            imageView.setVisibility(4);
            imageView2.setImageResource(this.b == 0 ? R.drawable.fx_none_sel : R.drawable.fx_none);
        } else {
            imageView.setVisibility(0);
            imageView.setImageResource(z ? R.drawable.opt_collapse : R.drawable.opt_expand);
            imageView2.setImageResource(R.drawable.fx_folder);
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        com.nexstreaming.kinemaster.kmpackage.b bVar = this.f3686a.get(i).b.get(i2);
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mini_effect_browser_list_item, viewGroup, false);
        }
        view.setTag(R.id.tag_group_child_pos, Long.valueOf((i << 32) | i2));
        view.setActivated(this.b == i && this.c == i2);
        IconView iconView = (IconView) view.findViewById(R.id.icon);
        TextView textView = (TextView) view.findViewById(R.id.text);
        View findViewById = view.findViewById(R.id.round_corners);
        if (!this.d) {
            iconView.setBackgroundColor(-16088965);
            iconView.setIconColorStateList(0);
            iconView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            iconView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        textView.setText(bVar.a(view.getContext()));
        iconView.setImageBitmap(bVar.c(view.getContext()));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        super.onGroupCollapsed(i);
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupExpanded(int i) {
        super.onGroupExpanded(i);
    }
}
