package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaItemType;
import com.nextreaming.nexeditorui.KineMasterApplication;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MediaBrowserAdapter.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1823a extends RecyclerView.Adapter<d> implements InterfaceC1826d, InterfaceC1825c {

    /* renamed from: d, reason: collision with root package name */
    private Context f21674d;

    /* renamed from: f, reason: collision with root package name */
    private com.nexstreaming.kinemaster.mediastore.e f21676f;

    /* renamed from: g, reason: collision with root package name */
    private View.OnClickListener f21677g;

    /* renamed from: h, reason: collision with root package name */
    private View.OnLongClickListener f21678h;

    /* renamed from: e, reason: collision with root package name */
    private final MediaStore f21675e = KineMasterApplication.f24058f.c().p();

    /* renamed from: c, reason: collision with root package name */
    private List<? extends com.nexstreaming.kinemaster.mediastore.item.c> f21673c = new ArrayList();

    /* compiled from: MediaBrowserAdapter.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0114a extends d {
        private ImageView t;
        private ImageView u;
        private ImageView v;
        final /* synthetic */ C1823a w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0114a(C1823a c1823a, View view) {
            super(c1823a, view);
            kotlin.jvm.internal.h.b(view, "itemView");
            this.w = c1823a;
            View findViewById = view.findViewById(R.id.media_image);
            kotlin.jvm.internal.h.a((Object) findViewById, "itemView.findViewById(R.id.media_image)");
            this.t = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.icon_favorite);
            kotlin.jvm.internal.h.a((Object) findViewById2, "itemView.findViewById(R.id.icon_favorite)");
            this.u = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.imageView_content_type);
            kotlin.jvm.internal.h.a((Object) findViewById3, "itemView.findViewById(R.id.imageView_content_type)");
            this.v = (ImageView) findViewById3;
        }

        private final boolean b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
            if (this.w.f21676f == null) {
                C1823a c1823a = this.w;
                Context context = c1823a.f21674d;
                if (context == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                c1823a.f21676f = new com.nexstreaming.kinemaster.mediastore.e(context);
            }
            com.nexstreaming.kinemaster.mediastore.e eVar = this.w.f21676f;
            if (eVar != null) {
                return eVar.c(cVar.getId());
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }

        private final boolean c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
            boolean b2;
            if (cVar.getType() == MediaItemType.IMAGE && !cVar.h()) {
                try {
                    String path = cVar.getPath();
                    if (TextUtils.isEmpty(path)) {
                        return false;
                    }
                    if (path != null) {
                        b2 = kotlin.text.v.b(path, "@solid:", false, 2, null);
                        return b2;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        @Override // com.nexstreaming.kinemaster.ui.mediabrowser.C1823a.d
        public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
            kotlin.jvm.internal.h.b(cVar, "item");
            MediaStore mediaStore = this.w.f21675e;
            if (mediaStore != null) {
                mediaStore.a(cVar, this.t, R.drawable.n2_loading_image_1_img);
                if (b(cVar)) {
                    this.u.setVisibility(0);
                } else {
                    this.u.setVisibility(4);
                }
                this.v.setVisibility(0);
                if (c(cVar)) {
                    this.v.setImageResource(R.drawable.n3_clip_solid);
                    return;
                } else if (cVar.getType() == MediaItemType.IMAGE) {
                    this.v.setImageResource(R.drawable.n3_clip_image);
                    return;
                } else {
                    if (cVar.getType() == MediaItemType.VIDEO) {
                        this.v.setImageResource(R.drawable.n3_clip_video);
                        return;
                    }
                    return;
                }
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaBrowserAdapter.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.a$b */
    /* loaded from: classes.dex */
    public final class b extends d {
        private TextView t;
        private ImageView u;
        private ImageView v;
        private ImageView w;
        private ImageView x;
        final /* synthetic */ C1823a y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C1823a c1823a, View view) {
            super(c1823a, view);
            kotlin.jvm.internal.h.b(view, "itemView");
            this.y = c1823a;
            View findViewById = view.findViewById(R.id.special_img_folder_image);
            kotlin.jvm.internal.h.a((Object) findViewById, "itemView.findViewById(R.…special_img_folder_image)");
            this.u = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.special_img_folder_icon);
            kotlin.jvm.internal.h.a((Object) findViewById2, "itemView.findViewById(R.….special_img_folder_icon)");
            this.v = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.folder_image);
            kotlin.jvm.internal.h.a((Object) findViewById3, "itemView.findViewById(R.id.folder_image)");
            this.w = (ImageView) findViewById3;
            View findViewById4 = view.findViewById(R.id.folder_image_transparent);
            kotlin.jvm.internal.h.a((Object) findViewById4, "itemView.findViewById(R.…folder_image_transparent)");
            this.x = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.folder_title);
            kotlin.jvm.internal.h.a((Object) findViewById5, "itemView.findViewById(R.id.folder_title)");
            this.t = (TextView) findViewById5;
        }

        @Override // com.nexstreaming.kinemaster.ui.mediabrowser.C1823a.d
        public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
            kotlin.jvm.internal.h.b(cVar, "item");
            String c2 = cVar.c();
            MediaStore mediaStore = this.y.f21675e;
            if (mediaStore != null) {
                int d2 = mediaStore.d(cVar);
                if (d2 == 1) {
                    this.u.setVisibility(8);
                    this.v.setVisibility(8);
                    this.w.setVisibility(0);
                    this.x.setVisibility(0);
                    this.y.f21675e.a(cVar, this.w);
                    TextView textView = this.t;
                    Context context = this.y.f21674d;
                    if (context == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    textView.setTextColor(context.getResources().getColor(R.color.mediabrowser_text_color));
                } else if (d2 == 2) {
                    this.u.setVisibility(0);
                    this.v.setVisibility(0);
                    this.w.setVisibility(8);
                    this.x.setVisibility(8);
                    this.y.f21675e.a(cVar, this.v);
                    TextView textView2 = this.t;
                    Context context2 = this.y.f21674d;
                    if (context2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    textView2.setTextColor(context2.getResources().getColor(R.color.mediabrowser_text_color_for_special));
                }
                TextView textView3 = this.t;
                textView3.setText(c2);
                c.d.b.m.n.a(textView3, 8, 10);
                return;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    /* compiled from: MediaBrowserAdapter.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.a$c */
    /* loaded from: classes.dex */
    public final class c extends d {
        private TextView t;
        private ImageView u;
        final /* synthetic */ C1823a v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C1823a c1823a, View view) {
            super(c1823a, view);
            kotlin.jvm.internal.h.b(view, "itemView");
            this.v = c1823a;
            View findViewById = view.findViewById(R.id.folder_title_for_special);
            kotlin.jvm.internal.h.a((Object) findViewById, "itemView.findViewById(R.…folder_title_for_special)");
            this.t = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.icon_view);
            kotlin.jvm.internal.h.a((Object) findViewById2, "itemView.findViewById(R.id.icon_view)");
            this.u = (ImageView) findViewById2;
        }

        @Override // com.nexstreaming.kinemaster.ui.mediabrowser.C1823a.d
        public void a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
            kotlin.jvm.internal.h.b(cVar, "item");
            this.t.setText(cVar.c());
            MediaStore mediaStore = this.v.f21675e;
            if (mediaStore != null) {
                mediaStore.a(cVar, this.u);
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    /* compiled from: MediaBrowserAdapter.kt */
    /* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.a$d */
    /* loaded from: classes.dex */
    public abstract class d extends RecyclerView.ViewHolder {
        final /* synthetic */ C1823a s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1823a c1823a, View view) {
            super(view);
            kotlin.jvm.internal.h.b(view, "itemView");
            this.s = c1823a;
            view.setOnClickListener(c1823a.f21677g);
            view.setOnLongClickListener(c1823a.f21678h);
        }

        public abstract void a(com.nexstreaming.kinemaster.mediastore.item.c cVar);
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public com.nexstreaming.kinemaster.mediastore.item.c getItem(int i) {
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list != null) {
            return list.get(i);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        com.nexstreaming.kinemaster.mediastore.item.c item = getItem(i);
        return item != null ? item.getType().getValue() : MediaItemType.FOLDER.getValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public com.nexstreaming.kinemaster.mediastore.item.c b(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list != null) {
            int indexOf = list.indexOf(cVar);
            if (!d(cVar)) {
                return null;
            }
            List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list2 = this.f21673c;
            if (list2 != null) {
                return list2.get(indexOf - 1);
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public boolean c(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list == null) {
            kotlin.jvm.internal.h.a();
            throw null;
        }
        int indexOf = list.indexOf(cVar);
        if (indexOf <= -1) {
            return false;
        }
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list2 = this.f21673c;
        if (list2 != null) {
            return list2.size() > indexOf + 1;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public boolean d(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list != null) {
            return list.indexOf(cVar) > 0;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public d onCreateViewHolder(ViewGroup viewGroup, int i) {
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        this.f21674d = viewGroup.getContext();
        LayoutInflater from = LayoutInflater.from(this.f21674d);
        MediaItemType a2 = MediaItemType.Companion.a(i);
        if (a2 == null) {
            a2 = MediaItemType.FOLDER;
        }
        if (a2 != null) {
            int i2 = C1824b.f21679a[a2.ordinal()];
            if (i2 == 1) {
                View inflate = from.inflate(R.layout.item_media_browser_folder, viewGroup, false);
                kotlin.jvm.internal.h.a((Object) inflate, "inflate.inflate(R.layout…er_folder, parent, false)");
                return new b(this, inflate);
            }
            if (i2 == 2) {
                View inflate2 = from.inflate(R.layout.item_media_browser_special, viewGroup, false);
                kotlin.jvm.internal.h.a((Object) inflate2, "inflate.inflate(R.layout…r_special, parent, false)");
                return new c(this, inflate2);
            }
            if (i2 == 3 || i2 == 4 || i2 == 5) {
                View inflate3 = from.inflate(R.layout.item_media_browser_file, viewGroup, false);
                kotlin.jvm.internal.h.a((Object) inflate3, "inflate.inflate(R.layout…wser_file, parent, false)");
                return new C0114a(this, inflate3);
            }
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i) {
        kotlin.jvm.internal.h.b(dVar, "viewHolder");
        com.nexstreaming.kinemaster.mediastore.item.c item = getItem(i);
        if (item != null) {
            dVar.a(item);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(d dVar) {
        kotlin.jvm.internal.h.b(dVar, "holder");
        super.onViewRecycled(dVar);
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public com.nexstreaming.kinemaster.mediastore.item.c a(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        kotlin.jvm.internal.h.b(cVar, "item");
        List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list = this.f21673c;
        if (list != null) {
            int indexOf = list.indexOf(cVar);
            if (!c(cVar)) {
                return null;
            }
            List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list2 = this.f21673c;
            if (list2 != null) {
                return list2.get(indexOf + 1);
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1826d
    public void b() {
        notifyDataSetChanged();
    }

    @Override // com.nexstreaming.kinemaster.ui.mediabrowser.InterfaceC1825c
    public void a(List<? extends com.nexstreaming.kinemaster.mediastore.item.c> list) {
        kotlin.jvm.internal.h.b(list, "list");
        synchronized (this) {
            this.f21673c = list;
            kotlin.k kVar = kotlin.k.f28545a;
        }
    }

    public final void a(View.OnClickListener onClickListener) {
        kotlin.jvm.internal.h.b(onClickListener, "onClickListener");
        this.f21677g = onClickListener;
    }

    public final void a(View.OnLongClickListener onLongClickListener) {
        kotlin.jvm.internal.h.b(onLongClickListener, "onLongClickListener");
        this.f21678h = onLongClickListener;
    }
}
