package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import java.util.List;

/* compiled from: OptionColorTintFragment.java */
/* loaded from: classes.dex */
public class dc extends kp implements AbsListView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    private NexTimelineItem.g f3837a;
    private NexTimelineItem.f b;
    private List<ColorEffect> c;
    private com.nextreaming.nexeditorui.b d;
    private GridView e;
    private View f;
    private View g;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.color_tint_fragment, viewGroup, false);
        b(inflate);
        f(R.string.colortint_panel_title);
        d(true);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new dd(this, inflate));
        this.e = (GridView) inflate.findViewById(R.id.gridView_color_effects);
        this.c = ColorEffect.getPresetList();
        this.d = new com.nextreaming.nexeditorui.b(getActivity(), this.c);
        this.e.setAdapter((ListAdapter) this.d);
        this.d.a(new de(this));
        this.f = inflate.findViewById(R.id.listViewDirectionUp);
        this.g = inflate.findViewById(R.id.listViewDirectionDown);
        this.e.setOnScrollListener(this);
        f();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        NexTimelineItem m = m();
        if (m != null && (m instanceof NexLayerItem)) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if ((m instanceof NexVideoClipItem) && ((NexVideoClipItem) m).isVideo() && Build.VERSION.SDK_INT >= 18) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_capture, R.drawable.action_icon_capture, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        int i = 0;
        super.f();
        if (m() != null) {
            if (m() != null && (m() instanceof NexTimelineItem.g)) {
                this.f3837a = (NexTimelineItem.g) m();
            }
            if (m() != null && (m() instanceof NexTimelineItem.f)) {
                this.b = (NexTimelineItem.f) m();
            }
            ColorEffect colorEffect = this.f3837a.getColorEffect();
            if (colorEffect == null) {
                this.d.a(0);
            } else {
                while (true) {
                    if (i >= this.c.size()) {
                        break;
                    }
                    if (!colorEffect.equals(this.c.get(i))) {
                        i++;
                    } else {
                        this.d.a(i);
                        break;
                    }
                }
            }
            this.e.setAdapter((ListAdapter) this.d);
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.e = null;
        this.d = null;
        this.f = null;
        this.g = null;
        super.onDestroyView();
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
