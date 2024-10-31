package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexeditorui.NexTimelineItem;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
public final class r implements i {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f22254a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22255b;

    /* renamed from: c, reason: collision with root package name */
    private final VideoEditor f22256c;

    /* renamed from: d, reason: collision with root package name */
    private final NexTimelineItem.b f22257d;

    /* renamed from: e, reason: collision with root package name */
    private AudioPlayStatus f22258e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.d f22259f;

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.d f22260g;

    /* renamed from: h, reason: collision with root package name */
    private final j f22261h;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(r.class), "model", "getModel()Lcom/nexstreaming/kinemaster/ui/projectedit/audioeffect/AudioEffectRepository;");
        kotlin.jvm.internal.j.a(propertyReference1Impl);
        PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(r.class), "adapterModel", "getAdapterModel()Lcom/nexstreaming/kinemaster/ui/projectedit/audioeffect/AudioEffectContract$Adapter$Model;");
        kotlin.jvm.internal.j.a(propertyReference1Impl2);
        f22254a = new kotlin.reflect.g[]{propertyReference1Impl, propertyReference1Impl2};
    }

    public r(j jVar) {
        kotlin.d a2;
        kotlin.d a3;
        kotlin.jvm.internal.h.b(jVar, "fragmentView");
        this.f22261h = jVar;
        this.f22255b = "AudioEffect";
        this.f22256c = this.f22261h.i();
        this.f22257d = this.f22261h.getTimeline();
        this.f22258e = AudioPlayStatus.STOP;
        a2 = kotlin.f.a(new kotlin.jvm.a.a<t>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectPresenter$model$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final t invoke() {
                return new t();
            }
        });
        this.f22259f = a2;
        a3 = kotlin.f.a(new kotlin.jvm.a.a<f>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectPresenter$adapterModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final f invoke() {
                j jVar2;
                f fVar = new f(r.this);
                t e2 = r.this.e();
                jVar2 = r.this.f22261h;
                fVar.a(e2.a(jVar2.getViewType()));
                return fVar;
            }
        });
        this.f22260g = a3;
        b().a(c());
    }

    public g b() {
        kotlin.d dVar = this.f22260g;
        kotlin.reflect.g gVar = f22254a[1];
        return (g) dVar.getValue();
    }

    public void b(kotlin.jvm.a.a<kotlin.k> aVar) {
        Task M;
        Task onComplete;
        VideoEditor videoEditor = this.f22256c;
        if (videoEditor == null || (M = videoEditor.M()) == null || (onComplete = M.onComplete(new p(videoEditor, this, aVar))) == null) {
            return;
        }
        onComplete.onFailure(new q(this, aVar));
    }

    public b c() {
        String str = null;
        if (this.f22261h.getViewType() == AudioViewType.VOICE_CHANGER) {
            NexTimelineItem.b bVar = this.f22257d;
            if (bVar != null) {
                str = bVar.getVoiceChanger();
            }
        } else {
            NexTimelineItem.b bVar2 = this.f22257d;
            if (bVar2 != null) {
                str = bVar2.getEqualizer();
            }
        }
        return e().a(str);
    }

    public AudioPlayStatus d() {
        return this.f22258e;
    }

    public t e() {
        kotlin.d dVar = this.f22259f;
        kotlin.reflect.g gVar = f22254a[0];
        return (t) dVar.getValue();
    }

    public int f() {
        return b().d();
    }

    public void a(AudioPlayStatus audioPlayStatus) {
        kotlin.jvm.internal.h.b(audioPlayStatus, "<set-?>");
        this.f22258e = audioPlayStatus;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.i
    public void a(final b bVar) {
        kotlin.jvm.internal.h.b(bVar, "selectEffect");
        if (kotlin.jvm.internal.h.a(bVar, c())) {
            int i = k.f22238a[d().ordinal()];
            if (i == 1) {
                b((kotlin.jvm.a.a<kotlin.k>) null);
                return;
            } else {
                if (i == 2 || i != 3) {
                    return;
                }
                a((kotlin.jvm.a.a<kotlin.k>) null);
                return;
            }
        }
        int i2 = k.f22239b[d().ordinal()];
        if (i2 == 1) {
            b(new kotlin.jvm.a.a<kotlin.k>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectPresenter$playOrStopAudioEffect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ kotlin.k invoke() {
                    invoke2();
                    return kotlin.k.f28545a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    r.this.b(bVar);
                    r.this.a((kotlin.jvm.a.a<kotlin.k>) null);
                }
            });
        } else {
            if (i2 == 2 || i2 != 3) {
                return;
            }
            b(bVar);
            a((kotlin.jvm.a.a<kotlin.k>) null);
        }
    }

    public void b(b bVar) {
        kotlin.jvm.internal.h.b(bVar, "effect");
        int i = k.f22240c[bVar.e().ordinal()];
        if (i == 1) {
            NexTimelineItem.b bVar2 = this.f22257d;
            if (bVar2 != null) {
                bVar2.setVoiceChanger(bVar.f());
            }
        } else if (i == 2) {
            NexTimelineItem.b bVar3 = this.f22257d;
            if (bVar3 != null) {
                bVar3.setEqualizer(bVar.f());
            }
        } else if (i == 3) {
            if (this.f22261h.getViewType() == AudioViewType.VOICE_CHANGER) {
                NexTimelineItem.b bVar4 = this.f22257d;
                if (bVar4 != null) {
                    bVar4.setVoiceChanger(bVar.f());
                }
            } else {
                NexTimelineItem.b bVar5 = this.f22257d;
                if (bVar5 != null) {
                    bVar5.setEqualizer(bVar.f());
                }
            }
        }
        this.f22261h.y();
        b().a(bVar);
    }

    public void a(kotlin.jvm.a.a<kotlin.k> aVar) {
        Task a2;
        Task onComplete;
        if (d() != AudioPlayStatus.STOP) {
            return;
        }
        a(AudioPlayStatus.PENDING);
        b().c().onNext(new Pair<>(d(), c()));
        this.f22261h.a(false);
        if (this.f22257d != null) {
            this.f22261h.v();
            VideoEditor videoEditor = this.f22256c;
            if (videoEditor == null || (a2 = videoEditor.a(this.f22261h.f(), true, true)) == null || (onComplete = a2.onComplete(new n(videoEditor, this, aVar))) == null) {
                return;
            }
            onComplete.onFailure(new o(videoEditor, this, aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VideoEditor videoEditor, AudioPlayStatus audioPlayStatus) {
        if (audioPlayStatus != null) {
            a(audioPlayStatus);
            this.f22261h.a(true);
        }
        videoEditor.b(false);
        b().c().onNext(new Pair<>(d(), c()));
    }

    public void a() {
        b().dispose();
    }
}
