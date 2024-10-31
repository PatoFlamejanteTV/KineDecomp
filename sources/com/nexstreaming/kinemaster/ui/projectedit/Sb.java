package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.Locale;

/* compiled from: NudgeFragment.java */
/* loaded from: classes2.dex */
public class Sb extends Bg implements InterfaceC1866cf {
    private NexLayerItem l;
    private View o;
    private ViewOnLayoutChangeListenerC1995rb m = new ViewOnLayoutChangeListenerC1995rb(this);
    private transient boolean n = false;
    private View.OnClickListener p = new Rb(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void va() {
        NexLayerItem nexLayerItem;
        if (this.o == null || (nexLayerItem = this.l) == null) {
            return;
        }
        NexLayerItem.b bVar = nexLayerItem.getKeyFrames().get(0);
        TextView textView = (TextView) this.o.findViewById(R.id.nudge_info);
        if (textView != null) {
            Rect rect = new Rect();
            this.l.getBounds(rect);
            textView.setText("x: " + String.format(Locale.ENGLISH, "%.1f", Float.valueOf(bVar.f20232c)) + "  y: " + String.format(Locale.ENGLISH, "%.1f", Float.valueOf(bVar.f20233d)) + "  (" + rect.width() + FragmentC2201x.f23219a + rect.height() + " @ " + String.format(Locale.ENGLISH, "%.2f", Float.valueOf(bVar.f20231b)) + "x)");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        this.l = (NexLayerItem) Y();
        this.m.b();
        va();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.o = layoutInflater.inflate(R.layout.pedit_option_nudge_fragment, viewGroup, false);
        a(this.o);
        n(R.string.opt_split_screen);
        f(true);
        na();
        Q().addOnLayoutChangeListener(this.m);
        this.o.findViewById(R.id.nudge_up).setOnClickListener(this.p);
        this.o.findViewById(R.id.nudge_down).setOnClickListener(this.p);
        this.o.findViewById(R.id.nudge_left).setOnClickListener(this.p);
        this.o.findViewById(R.id.nudge_right).setOnClickListener(this.p);
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.o = null;
        Q().removeOnLayoutChangeListener(this.m);
        this.m.a();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.n) {
            G();
            this.n = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.m.c();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_general, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        NexLayerItem.b bVar = this.l.getKeyFrames().get(0);
        NexLayerItem.b bVar2 = new NexLayerItem.b(bVar);
        boolean a2 = this.m.a(view, motionEvent);
        if (!bVar2.equals(bVar)) {
            va();
        }
        return a2;
    }
}
