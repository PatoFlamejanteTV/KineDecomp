package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.SplitScreenType;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.Iterator;

/* compiled from: OptionSplitScreenFragment.java */
/* loaded from: classes.dex */
public class gz extends kp implements View.OnClickListener, ht {
    private static boolean f = false;

    /* renamed from: a */
    private NexTimelineItem.r f3943a;
    private NexLayerItem b;
    private bg c = new bg(this);
    private final com.nexstreaming.app.general.util.k<Integer, SplitScreenType> d = new com.nexstreaming.app.general.util.k<>(Integer.valueOf(R.id.split_left), SplitScreenType.LEFT, Integer.valueOf(R.id.split_right), SplitScreenType.RIGHT, Integer.valueOf(R.id.split_top), SplitScreenType.TOP, Integer.valueOf(R.id.split_bottom), SplitScreenType.BOTTOM, Integer.valueOf(R.id.split_full), SplitScreenType.FULL, Integer.valueOf(R.id.split_off), SplitScreenType.OFF);
    private View e;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.e = layoutInflater.inflate(R.layout.pedit_option_splitscreen_fragment, viewGroup, false);
        b(this.e);
        f(R.string.opt_split_screen);
        d(true);
        Iterator<Integer> it = this.d.a().iterator();
        while (it.hasNext()) {
            this.e.findViewById(it.next().intValue()).setOnClickListener(this);
        }
        f();
        return this.e;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.e = null;
        this.c.d();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.c.b();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        this.f3943a = (NexTimelineItem.r) m();
        if (this.f3943a != null) {
            this.b = (NexLayerItem) m();
            c();
            this.e.findViewById(a(this.f3943a.getSplitScreenType())).setActivated(true);
            this.c.c();
        }
    }

    private void c() {
        if (this.e != null) {
            Iterator<Integer> it = this.d.a().iterator();
            while (it.hasNext()) {
                View findViewById = this.e.findViewById(it.next().intValue());
                if (findViewById != null) {
                    findViewById.setActivated(false);
                }
            }
        }
    }

    private SplitScreenType b(int i) {
        return this.d.get(Integer.valueOf(i));
    }

    private int a(SplitScreenType splitScreenType) {
        return this.d.a(splitScreenType).intValue();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SplitScreenType b = b(view.getId());
        if (b != this.f3943a.getSplitScreenType()) {
            c();
            view.setActivated(true);
            this.f3943a.setSplitScreenType(b);
            if (this.f3943a.getSplitScreenType() != SplitScreenType.OFF) {
                this.b.fitKeyframeToSplitscreenRect(this.b.getSplitScreenKeyframe());
                if (this.c != null && !f) {
                    this.c.a();
                    f = true;
                }
            }
            VideoEditor o = o();
            if (o != null) {
                o.l();
                o.a(NexEditor.FastPreviewOption.normal, 0, true);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        return this.c.a(view, motionEvent);
    }
}
