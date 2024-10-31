package com.nexstreaming.kinemaster.ui.projectedit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexeditorui.ba;

/* compiled from: OptionAudioEffectFragment.java */
/* loaded from: classes.dex */
public class ce extends kp implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, VideoEditor.g, ba.a {

    /* renamed from: a, reason: collision with root package name */
    private ListView f3812a;
    private d b;
    private View c;
    private View d;
    private View e;
    private boolean f;
    private boolean g;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.c = layoutInflater.inflate(R.layout.option_audio_effects_fragment, viewGroup, false);
        b(this.c);
        f(R.string.opt_audio_effect);
        d(true);
        this.f3812a = (ListView) this.c.findViewById(R.id.optionMenuList);
        this.f3812a.setChoiceMode(1);
        this.d = this.c.findViewById(R.id.listViewDirectionUp);
        this.e = this.c.findViewById(R.id.listViewDirectionDown);
        f();
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        super.f();
        if (m() != null) {
            int[] iArr = {R.string.audio_effect_none, R.string.audio_effect_chipmunk, R.string.audio_effect_robot, R.string.audio_effect_deep, R.string.audio_effect_modulation};
            int audioEffect = c().getAudioEffect();
            this.b = new d(iArr, getActivity());
            this.b.a(audioEffect);
            this.b.a(this.f);
            this.f3812a.setAdapter((ListAdapter) this.b);
            this.f3812a.setOnItemClickListener(this);
            this.f3812a.setItemChecked(audioEffect, true);
            this.f3812a.setOnScrollListener(this);
            this.f3812a.post(new cf(this, audioEffect));
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.c != null) {
            this.c.getViewTreeObserver().addOnGlobalLayoutListener(new ch(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        if (m() instanceof NexAudioClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof NexVideoClipItem) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (m() instanceof VideoLayer) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f3812a = null;
        this.b = null;
        this.c = null;
        super.onDestroyView();
    }

    private NexTimelineItem.b c() {
        if (m() instanceof NexTimelineItem.b) {
            return (NexTimelineItem.b) m();
        }
        return null;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        NexTimelineItem.b c = c();
        if (c.getAudioEffect() == i && c.getAudioEffect() != 0) {
            if (this.f) {
                o().p().onComplete(new ci(this));
                return;
            } else {
                e();
                h();
                return;
            }
        }
        if (i != 0) {
            c.setAudioEffect(i);
            if (this.f) {
                o().p().onComplete(new cj(this));
                return;
            }
            d();
            e();
            h();
            return;
        }
        if (i == 0) {
            c.setAudioEffect(i);
            if (this.f) {
                o().p().onComplete(new ck(this));
            } else {
                d();
                h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (!this.f && !this.g) {
            this.f = true;
            this.g = true;
            a(false);
            e(m().getAbsStartTime(), false);
            VideoEditor o = o();
            o.a(m().getAbsStartTime(), true, true).onComplete(new cm(this, o)).onFailure(new cl(this, o));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.b != null) {
            this.b.a(this.f);
            this.b.b(this.g);
            if (c() != null) {
                this.b.a(c().getAudioEffect());
            }
            this.b.notifyDataSetInvalidated();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.d != null && this.e != null) {
            int height = absListView.getHeight();
            int height2 = absListView.getChildAt(0) != null ? absListView.getChildAt(0).getHeight() : 0;
            if (i != 0 || (absListView.getChildAt(0) != null && absListView.getChildAt(0).getTop() < 0)) {
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
            if (i3 > 0 && i + i2 >= i3 && absListView.getChildAt(i2 - 1).getTop() <= height - height2) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (this.f && !this.g) {
            int totalTime = o().f().a().getTotalTime();
            if (m().getAbsEndTime() - 100 <= i2 || totalTime <= i2) {
                g(false);
                o().p().onComplete(new cp(this));
            }
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Context context) {
        if (o() != null) {
            o().a(this);
        }
        super.onAttach(context);
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        if (o() != null) {
            o().a(this);
        }
        super.onAttach(activity);
    }

    @Override // android.app.Fragment
    public void onDetach() {
        o().b(this);
        o().b(false);
        a(true);
        super.onDetach();
    }

    @Override // android.app.Fragment
    public void onPause() {
        VideoEditor o;
        if (this.f && (o = o()) != null) {
            o.p().onComplete(new cq(this, o));
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        k(z);
        i(z);
        j(z);
    }

    @Override // com.nextreaming.nexeditorui.ba.a
    public boolean l_() {
        if (this.f || o() != null) {
            o().p().onComplete(new cg(this));
        }
        a(true);
        return false;
    }
}
