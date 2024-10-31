package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

/* compiled from: AudioEffectAdapter.kt */
/* loaded from: classes2.dex */
public final class f extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements g {

    /* renamed from: c, reason: collision with root package name */
    private b f22232c;

    /* renamed from: d, reason: collision with root package name */
    private AudioPlayStatus f22233d;

    /* renamed from: e, reason: collision with root package name */
    private final PublishSubject<Pair<AudioPlayStatus, b>> f22234e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<b> f22235f;

    /* renamed from: g, reason: collision with root package name */
    private final io.reactivex.disposables.b f22236g;

    /* renamed from: h, reason: collision with root package name */
    private final i f22237h;

    /* compiled from: AudioEffectAdapter.kt */
    /* loaded from: classes2.dex */
    public final class a extends RecyclerView.ViewHolder {
        static final /* synthetic */ kotlin.reflect.g[] s;
        private final kotlin.d t;
        private final kotlin.d u;
        private final kotlin.d v;
        private final kotlin.d w;
        private final kotlin.d x;
        final /* synthetic */ f y;

        static {
            PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.j.a(a.class), "iconView", "getIconView()Lcom/nexstreaming/app/general/util/IconView;");
            kotlin.jvm.internal.j.a(propertyReference1Impl);
            PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(a.class), "textView", "getTextView()Landroid/widget/TextView;");
            kotlin.jvm.internal.j.a(propertyReference1Impl2);
            PropertyReference1Impl propertyReference1Impl3 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(a.class), "separator", "getSeparator()Landroid/view/View;");
            kotlin.jvm.internal.j.a(propertyReference1Impl3);
            PropertyReference1Impl propertyReference1Impl4 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(a.class), "iconFree", "getIconFree()Landroid/widget/ImageView;");
            kotlin.jvm.internal.j.a(propertyReference1Impl4);
            PropertyReference1Impl propertyReference1Impl5 = new PropertyReference1Impl(kotlin.jvm.internal.j.a(a.class), "optDepthIndicator", "getOptDepthIndicator()Landroid/view/View;");
            kotlin.jvm.internal.j.a(propertyReference1Impl5);
            s = new kotlin.reflect.g[]{propertyReference1Impl, propertyReference1Impl2, propertyReference1Impl3, propertyReference1Impl4, propertyReference1Impl5};
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, final View view) {
            super(view);
            kotlin.d a2;
            kotlin.d a3;
            kotlin.d a4;
            kotlin.d a5;
            kotlin.d a6;
            kotlin.jvm.internal.h.b(view, "view");
            this.y = fVar;
            a2 = kotlin.f.a(new kotlin.jvm.a.a<IconView>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter$AudioEffectViewHolder$iconView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.a.a
                public final IconView invoke() {
                    return (IconView) view.findViewById(R.id.icon);
                }
            });
            this.t = a2;
            a3 = kotlin.f.a(new kotlin.jvm.a.a<TextView>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter$AudioEffectViewHolder$textView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.a.a
                public final TextView invoke() {
                    return (TextView) view.findViewById(R.id.text);
                }
            });
            this.u = a3;
            a4 = kotlin.f.a(new kotlin.jvm.a.a<View>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter$AudioEffectViewHolder$separator$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.a.a
                public final View invoke() {
                    return view.findViewById(R.id.separator);
                }
            });
            this.v = a4;
            a5 = kotlin.f.a(new kotlin.jvm.a.a<ImageView>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter$AudioEffectViewHolder$iconFree$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.a.a
                public final ImageView invoke() {
                    ImageView imageView = (ImageView) view.findViewById(R.id.icon_free);
                    imageView.setBackgroundResource(R.drawable.premium_03);
                    return imageView;
                }
            });
            this.w = a5;
            a6 = kotlin.f.a(new kotlin.jvm.a.a<View>() { // from class: com.nexstreaming.kinemaster.ui.projectedit.audioeffect.AudioEffectAdapter$AudioEffectViewHolder$optDepthIndicator$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.a.a
                public final View invoke() {
                    return view.findViewById(R.id.opt_depth_indicator);
                }
            });
            this.x = a6;
        }

        private final TextView A() {
            kotlin.d dVar = this.u;
            kotlin.reflect.g gVar = s[1];
            return (TextView) dVar.getValue();
        }

        private final ImageView w() {
            kotlin.d dVar = this.w;
            kotlin.reflect.g gVar = s[3];
            return (ImageView) dVar.getValue();
        }

        private final IconView x() {
            kotlin.d dVar = this.t;
            kotlin.reflect.g gVar = s[0];
            return (IconView) dVar.getValue();
        }

        private final View y() {
            kotlin.d dVar = this.x;
            kotlin.reflect.g gVar = s[4];
            return (View) dVar.getValue();
        }

        private final View z() {
            kotlin.d dVar = this.v;
            kotlin.reflect.g gVar = s[2];
            return (View) dVar.getValue();
        }

        public final void a(b bVar, int i) {
            kotlin.jvm.internal.h.b(bVar, "item");
            View view = this.itemView;
            view.setActivated(kotlin.jvm.internal.h.a(bVar, this.y.g()));
            view.setOnClickListener(new e(this, bVar));
            IconView x = x();
            if (kotlin.jvm.internal.h.a(bVar, this.y.g())) {
                int i2 = d.f22229a[this.y.f().ordinal()];
                if (i2 == 1) {
                    x.setImageResource(R.drawable.material_pause);
                } else if (i2 == 2) {
                    x.setImageResource(R.drawable.material_pause_dis);
                } else if (i2 == 3) {
                    x.setImageResource(R.drawable.material_play);
                }
            } else {
                x.setImageResource(R.drawable.material_radio);
            }
            TextView A = A();
            A.setText(A.getContext().getString(bVar.g()));
            w().setVisibility(bVar.d() == IABManager.BillingType.FREE ? 8 : 0);
            z().setVisibility(0);
            y().setVisibility(8);
        }
    }

    public f(i iVar) {
        kotlin.jvm.internal.h.b(iVar, "presenter");
        this.f22237h = iVar;
        this.f22232c = b.f22223b.a();
        this.f22233d = AudioPlayStatus.STOP;
        PublishSubject<Pair<AudioPlayStatus, b>> f2 = PublishSubject.f();
        kotlin.jvm.internal.h.a((Object) f2, "PublishSubject.create()");
        this.f22234e = f2;
        this.f22235f = new ArrayList<>();
        io.reactivex.disposables.b a2 = c().b(io.reactivex.g.b.b()).a(io.reactivex.a.b.b.a()).a((io.reactivex.c.e<? super Pair<AudioPlayStatus, b>>) new c(this));
        kotlin.jvm.internal.h.a((Object) a2, "subject.subscribeOn(Sche…second)\n                }");
        this.f22236g = a2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.g
    public PublishSubject<Pair<AudioPlayStatus, b>> c() {
        return this.f22234e;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.g
    public int d() {
        return this.f22235f.indexOf(g());
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.g
    public void dispose() {
        if (this.f22236g.isDisposed()) {
            return;
        }
        this.f22236g.isDisposed();
    }

    public AudioPlayStatus f() {
        return this.f22233d;
    }

    public b g() {
        return this.f22232c;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f22235f.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        kotlin.jvm.internal.h.b(viewHolder, "holder");
        if (viewHolder instanceof a) {
            b bVar = this.f22235f.get(i);
            kotlin.jvm.internal.h.a((Object) bVar, "audioEffectList[position]");
            ((a) viewHolder).a(bVar, i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_menu_list_item, viewGroup, false);
        kotlin.jvm.internal.h.a((Object) inflate, "view");
        return new a(this, inflate);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.audioeffect.g
    public void a(b bVar) {
        kotlin.jvm.internal.h.b(bVar, "<set-?>");
        this.f22232c = bVar;
    }

    public void a(AudioPlayStatus audioPlayStatus) {
        kotlin.jvm.internal.h.b(audioPlayStatus, "<set-?>");
        this.f22233d = audioPlayStatus;
    }

    public void a(ArrayList<b> arrayList) {
        kotlin.jvm.internal.h.b(arrayList, "list");
        this.f22235f.addAll(arrayList);
        kotlin.collections.o.c(this.f22235f);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(AudioPlayStatus audioPlayStatus, b bVar) {
        a(audioPlayStatus);
        a(bVar);
        notifyDataSetChanged();
    }
}
