package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.settings.tb;
import com.nextreaming.nexeditorui.I;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: OptionAudioEffectFragment.kt */
/* loaded from: classes2.dex */
public final class w extends Bg implements j, VideoEditor.g, I.a {
    static final /* synthetic */ kotlin.reflect.g[] l;
    private RecyclerView m;
    private View n;
    private View o;
    private View p;
    private final kotlin.d q;
    private final kotlin.d r;
    private boolean s;
    public AudioViewType t;
    private HashMap u;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(w.class), "iabManager", "getIabManager()Lcom/nexstreaming/app/general/iab/IABManager;");
        kotlin.jvm.internal.j.a(propertyReference1Impl);
        PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(w.class), "presenter", "getPresenter()Lcom/nexstreaming/kinemaster/ui/projectedit/audioeffect/AudioEffectPresenter;");
        kotlin.jvm.internal.j.a(propertyReference1Impl2);
        l = new kotlin.reflect.g[]{propertyReference1Impl, propertyReference1Impl2};
    }

    public w() {
        kotlin.d a2;
        kotlin.d a3;
        a2 = kotlin.f.a(new kotlin.jvm.a.a<IABManager>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.OptionAudioEffectFragment$iabManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final IABManager invoke() {
                ProjectEditActivity M;
                M = w.this.M();
                return M.y();
            }
        });
        this.q = a2;
        a3 = kotlin.f.a(new kotlin.jvm.a.a<r>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.OptionAudioEffectFragment$presenter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final r invoke() {
                return new r(w.this);
            }
        });
        this.r = a3;
        this.s = isAdded();
    }

    public static final /* synthetic */ View a(w wVar) {
        View view = wVar.n;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.h.b("contentView");
        throw null;
    }

    public static final /* synthetic */ View b(w wVar) {
        View view = wVar.p;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.h.b("directionDown");
        throw null;
    }

    public static final /* synthetic */ View c(w wVar) {
        View view = wVar.o;
        if (view != null) {
            return view;
        }
        kotlin.jvm.internal.h.b("directionUp");
        throw null;
    }

    private final void va() {
        VideoEditor i;
        if (ea() || sa().c().d() != IABManager.BillingType.PREMIUM || (i = i()) == null) {
            return;
        }
        C1780za s = i.s();
        kotlin.jvm.internal.h.a((Object) s, "it.project");
        NexTimeline a2 = s.a();
        kotlin.jvm.internal.h.a((Object) a2, "timeline");
        List<NexPrimaryTimelineItem> primaryItems = a2.getPrimaryItems();
        kotlin.jvm.internal.h.a((Object) primaryItems, "timeline.primaryItems");
        a(primaryItems);
        List<NexSecondaryTimelineItem> secondaryItems = a2.getSecondaryItems();
        kotlin.jvm.internal.h.a((Object) secondaryItems, "timeline.secondaryItems");
        a(secondaryItems);
        y();
    }

    private final IABManager wa() {
        kotlin.d dVar = this.q;
        kotlin.reflect.g gVar = l[0];
        return (IABManager) dVar.getValue();
    }

    private final void xa() {
        FragmentTransaction beginTransaction;
        FragmentTransaction replace;
        FragmentTransaction addToBackStack;
        if (getTimeline() != null) {
            tb a2 = tb.a(wa(), 0, w.class.getSimpleName(), "Voice Changer");
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager == null || (beginTransaction = fragmentManager.beginTransaction()) == null || (replace = beginTransaction.replace(R.id.content, a2, tb.f23200a)) == null || (addToBackStack = replace.addToBackStack(tb.f23200a)) == null) {
                return;
            }
            addToBackStack.commitAllowingStateLoss();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public int f() {
        NexTimelineItem Y = Y();
        if (Y != null) {
            return Y.getAbsStartTime();
        }
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public NexTimelineItem.b getTimeline() {
        if (!(Y() instanceof NexTimelineItem.b)) {
            return null;
        }
        Fa.a Y = Y();
        if (Y != null) {
            return (NexTimelineItem.b) Y;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.nextreaming.nexeditorui.NexTimelineItem.AudioEffectInterface");
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public AudioViewType getViewType() {
        AudioViewType audioViewType = this.t;
        if (audioViewType != null) {
            return audioViewType;
        }
        kotlin.jvm.internal.h.b("viewType");
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public VideoEditor i() {
        return da();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public boolean isActive() {
        return this.s;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public boolean ma() {
        NexTimelineItem.b timeline;
        if (!ea() && sa().c().d() == IABManager.BillingType.PREMIUM && (timeline = getTimeline()) != null && ((getViewType() == AudioViewType.VOICE_CHANGER && timeline.getVoiceChanger() != null) || (getViewType() == AudioViewType.EQ && timeline.getEqualizer() != null))) {
            xa();
            return true;
        }
        VideoEditor i = i();
        if (i == null) {
            return false;
        }
        i.J();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        super.na();
        va();
        if (getTimeline() != null) {
            RecyclerView recyclerView = this.m;
            if (recyclerView != null) {
                recyclerView.scrollToPosition(sa().f());
            } else {
                kotlin.jvm.internal.h.b("optionMenuList");
                throw null;
            }
        }
    }

    public void o(boolean z) {
        this.s = z;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onAttach(Context context) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        VideoEditor da = da();
        if (da != null) {
            da.a(this);
        }
        super.onAttach(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nextreaming.nexeditorui.I.a
    public boolean onBackPressed() {
        sa().b((kotlin.jvm.a.a<kotlin.k>) null);
        a(true);
        return ma();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(com.nexstreaming.app.kinemasterfree.R.layout.option_audio_effects_fragment, viewGroup, false);
        kotlin.jvm.internal.h.a((Object) inflate, "inflater.inflate(R.layou…agment, container, false)");
        this.n = inflate;
        View view = this.n;
        if (view != null) {
            a(view);
            n(getViewType() == AudioViewType.VOICE_CHANGER ? com.nexstreaming.app.kinemasterfree.R.string.opt_audio_voice_changer : com.nexstreaming.app.kinemasterfree.R.string.opt_audio_eq);
            f(true);
            View view2 = this.n;
            if (view2 != null) {
                View findViewById = view2.findViewById(com.nexstreaming.app.kinemasterfree.R.id.optionMenuList);
                kotlin.jvm.internal.h.a((Object) findViewById, "contentView.findViewById(R.id.optionMenuList)");
                this.m = (RecyclerView) findViewById;
                View view3 = this.n;
                if (view3 != null) {
                    View findViewById2 = view3.findViewById(com.nexstreaming.app.kinemasterfree.R.id.listViewDirectionUp);
                    kotlin.jvm.internal.h.a((Object) findViewById2, "contentView.findViewById(R.id.listViewDirectionUp)");
                    this.o = findViewById2;
                    View view4 = this.n;
                    if (view4 != null) {
                        View findViewById3 = view4.findViewById(com.nexstreaming.app.kinemasterfree.R.id.listViewDirectionDown);
                        kotlin.jvm.internal.h.a((Object) findViewById3, "contentView.findViewById…id.listViewDirectionDown)");
                        this.p = findViewById3;
                        RecyclerView recyclerView = this.m;
                        if (recyclerView != null) {
                            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
                            g b2 = sa().b();
                            if (b2 != null) {
                                recyclerView.setAdapter((f) b2);
                                recyclerView.addOnScrollListener(new u(recyclerView, this));
                                na();
                                View view5 = this.n;
                                if (view5 != null) {
                                    return view5;
                                }
                                kotlin.jvm.internal.h.b("contentView");
                                throw null;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter");
                        }
                        kotlin.jvm.internal.h.b("optionMenuList");
                        throw null;
                    }
                    kotlin.jvm.internal.h.b("contentView");
                    throw null;
                }
                kotlin.jvm.internal.h.b("contentView");
                throw null;
            }
            kotlin.jvm.internal.h.b("contentView");
            throw null;
        }
        kotlin.jvm.internal.h.b("contentView");
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        sa().a();
        super.onDestroyView();
        z();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        VideoEditor i = i();
        if (i != null) {
            i.b(this);
        }
        VideoEditor i2 = i();
        if (i2 != null) {
            i2.b(false);
        }
        a(true);
        va();
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        o(false);
        sa().b(new kotlin.jvm.a.a<kotlin.k>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.OptionAudioEffectFragment$onPause$1
            @Override // kotlin.jvm.a.a
            public /* bridge */ /* synthetic */ kotlin.k invoke() {
                invoke2();
                return kotlin.k.f28545a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }
        });
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        o(true);
        View view = this.n;
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new v(this));
        } else {
            kotlin.jvm.internal.h.b("contentView");
            throw null;
        }
    }

    public r sa() {
        kotlin.d dVar = this.r;
        kotlin.reflect.g gVar = l[1];
        return (r) dVar.getValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public void v() {
        b(f(), false);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public void y() {
        b(Y());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void z() {
        HashMap hashMap = this.u;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void a(AudioViewType audioViewType) {
        kotlin.jvm.internal.h.b(audioViewType, "<set-?>");
        this.t = audioViewType;
    }

    private final void a(List<? extends NexTimelineItem> list) {
        String equalizer;
        for (Fa.a aVar : list) {
            if (aVar instanceof NexTimelineItem.b) {
                if (getViewType() == AudioViewType.VOICE_CHANGER) {
                    equalizer = ((NexTimelineItem.b) aVar).getVoiceChanger();
                } else {
                    equalizer = ((NexTimelineItem.b) aVar).getEqualizer();
                }
                if (sa().e().a(equalizer).d() == IABManager.BillingType.PREMIUM) {
                    if (getViewType() == AudioViewType.VOICE_CHANGER) {
                        ((NexTimelineItem.b) aVar).setVoiceChanger(b.f22223b.a().f());
                    } else {
                        ((NexTimelineItem.b) aVar).setEqualizer(b.f22223b.a().f());
                    }
                }
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.j
    public void a(boolean z) {
        j(z);
        l(z);
        k(z);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.g
    public void a(int i, int i2) {
        if (sa().d() == AudioPlayStatus.PLAY) {
            VideoEditor da = da();
            if (da != null) {
                C1780za s = da.s();
                kotlin.jvm.internal.h.a((Object) s, "getVideoEditor()!!.project");
                NexTimeline a2 = s.a();
                kotlin.jvm.internal.h.a((Object) a2, "getVideoEditor()!!.project.timeline");
                int totalTime = a2.getTotalTime();
                if (Y() == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (r1.getAbsEndTime() - 100 <= i2) {
                    c(false);
                    sa().b(new kotlin.jvm.a.a<kotlin.k>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.OptionAudioEffectFragment$onTimeChange$1
                        @Override // kotlin.jvm.a.a
                        public /* bridge */ /* synthetic */ kotlin.k invoke() {
                            invoke2();
                            return kotlin.k.f28545a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }
                    });
                    return;
                } else {
                    if (totalTime <= i2) {
                        sa().b(new kotlin.jvm.a.a<kotlin.k>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.OptionAudioEffectFragment$onTimeChange$2
                            @Override // kotlin.jvm.a.a
                            public /* bridge */ /* synthetic */ kotlin.k invoke() {
                                invoke2();
                                return kotlin.k.f28545a;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
