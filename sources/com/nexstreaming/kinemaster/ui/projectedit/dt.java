package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.ui.widget.DurationSpinner;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.xiaomi.licensinglibrary.LicenseErrCode;

/* compiled from: OptionExpressionFragment.java */
/* loaded from: classes.dex */
public abstract class dt extends kp implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    private ListView b;
    private y c;
    private View d;
    private DurationSpinner e;
    private long g;
    private View h;
    private View i;
    private Handler f = new Handler();

    /* renamed from: a, reason: collision with root package name */
    VideoEditor.b f3854a = new du(this);
    private Runnable j = new dz(this);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract LayerExpression.Type a();

    protected abstract String c();

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.d = a(layoutInflater, viewGroup, bundle);
        b(this.d);
        d(true);
        this.b = (ListView) this.d.findViewById(R.id.optionMenuList);
        this.b.setChoiceMode(1);
        this.e = (DurationSpinner) this.d.findViewById(R.id.durationSpinner);
        if (a().hasDuration()) {
            this.e.setOnValueChangeListener(new dv(this));
        }
        this.h = this.d.findViewById(R.id.listViewDirectionUp);
        this.i = this.d.findViewById(R.id.listViewDirectionDown);
        f();
        return this.d;
    }

    protected String e() {
        return null;
    }

    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.option_expression_fragment, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() != null) {
            b(c());
            c(e());
            NexLayerItem nexLayerItem = (NexLayerItem) m();
            o().a(nexLayerItem, this.f3854a, (VideoEditor.b) null);
            this.c = new y(a(), nexLayerItem);
            int a2 = this.c.a(nexLayerItem.getLayerExpression(a()).getId());
            this.b.setAdapter((ListAdapter) this.c);
            this.b.setOnItemClickListener(this);
            this.b.setItemChecked(a2, true);
            this.b.setOnScrollListener(this);
            if (a().hasDuration()) {
                float duration = nexLayerItem.getDuration() / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                this.e.setMaxValue(duration / 2.0f);
                this.e.setScrollMaxValue(duration / 2.0f);
                this.e.a(nexLayerItem.getLayerExpressionDuration(a()) / 1000.0f, false);
                if (nexLayerItem.getLayerExpression(a()) == LayerExpression.None) {
                    this.e.setVisibility(8);
                } else {
                    this.e.setVisibility(0);
                }
            } else {
                this.e.setVisibility(8);
            }
            this.b.post(new dw(this, a2));
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.d != null) {
            this.d.getViewTreeObserver().addOnGlobalLayoutListener(new dx(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (m() instanceof TextLayer) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LayerExpression fromId = LayerExpression.fromId((int) j);
        ((NexLayerItem) m()).setLayerExpression(a(), fromId);
        o().l();
        switch (a()) {
            case In:
                KMUsage.EditScreen_InAnimation.logEvent("animation", fromId.name(), "layerType", m().getClass().getSimpleName());
                break;
            case Out:
                KMUsage.EditScreen_OutAnimation.logEvent("animation", fromId.name(), "layerType", m().getClass().getSimpleName());
                break;
            case Overall:
                KMUsage.EditScreen_OverallAnimation.logEvent("animation", fromId.name(), "layerType", m().getClass().getSimpleName());
                break;
        }
        if (this.e != null) {
            if (fromId == LayerExpression.None || !a().hasDuration()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
                this.b.postOnAnimation(new dy(this, this.c.a(fromId.getId())));
            }
        }
        this.g = System.nanoTime();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        o().a((NexLayerItem) m(), this.f3854a, (VideoEditor.b) null);
        this.g = System.nanoTime();
        this.j.run();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.f.removeCallbacks(this.j);
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.h != null && this.i != null) {
            int height = absListView.getHeight();
            int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                this.h.setVisibility(0);
            } else {
                this.h.setVisibility(8);
            }
            if (i3 > 0 && i + i2 >= i3 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
