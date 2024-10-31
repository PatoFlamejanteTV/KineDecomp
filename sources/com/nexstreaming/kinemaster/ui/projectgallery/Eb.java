package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;

/* compiled from: ProjectGalleryAdapter.kt */
/* loaded from: classes2.dex */
public final class Eb extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    private int f22827e;

    /* renamed from: f, reason: collision with root package name */
    private int f22828f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<com.nexstreaming.kinemaster.project.k> f22829g;

    /* renamed from: h, reason: collision with root package name */
    private b f22830h;
    private RecyclerView i;
    private FrameLayout j;
    private Integer k;
    private final Context l;
    private final com.bumptech.glide.j m;
    private final View n;
    private final View o;
    private int p;
    private int q;

    /* renamed from: d, reason: collision with root package name */
    public static final a f22826d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final String f22825c = Eb.class.getSimpleName();

    /* compiled from: ProjectGalleryAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final int a(Context context, int i, int i2) {
            kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
            return Math.max((i2 - ((int) context.getResources().getDimension(R.dimen.project_gallery_left_width))) / i, 1);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final Bitmap a(Bitmap bitmap, Resources resources, boolean z, boolean z2) {
            int dimensionPixelSize;
            int dimensionPixelSize2;
            int dimensionPixelSize3;
            int dimensionPixelSize4;
            int dimensionPixelSize5;
            int dimensionPixelSize6;
            LinearGradient linearGradient;
            int i;
            float f2;
            float f3;
            int i2;
            Shader shader;
            kotlin.jvm.internal.h.b(resources, "rsrc");
            if (z) {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_width);
                dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_height);
                dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_corner);
                dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_radius);
                dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_offset);
                dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_border);
            } else {
                dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_width);
                dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_height);
                dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_corner);
                dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_radius);
                dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_offset);
                dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_border);
            }
            int i3 = dimensionPixelSize5 + dimensionPixelSize4;
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
            float f4 = dimensionPixelSize2;
            LinearGradient linearGradient2 = new LinearGradient(0.0f, dimensionPixelSize2 / 8, 0.0f, f4, 0, -872415232, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            Paint paint2 = new Paint();
            float f5 = dimensionPixelSize5;
            paint2.setShadowLayer(dimensionPixelSize4, f5, f5, 855638016);
            paint2.setColor(855638016);
            RectF rectF = new RectF();
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (bitmap == null) {
                float f6 = i3;
                rectF.set(f6, f6, dimensionPixelSize - i3, dimensionPixelSize2 - i3);
                paint.setColor(469762048);
                float f7 = dimensionPixelSize3;
                canvas.drawRoundRect(rectF, f7, f7, paint);
                kotlin.jvm.internal.h.a((Object) createBitmap, "bm");
                return createBitmap;
            }
            float f8 = i3;
            int i4 = dimensionPixelSize - i3;
            float f9 = i4;
            int i5 = dimensionPixelSize2 - i3;
            int i6 = dimensionPixelSize6;
            float f10 = i5;
            rectF.set(f8, f8, f9, f10);
            float f11 = dimensionPixelSize3;
            canvas.drawRoundRect(rectF, f11, f11, paint2);
            if (Build.VERSION.SDK_INT >= 21) {
                i2 = i4;
                linearGradient = linearGradient2;
                i = i5;
                f2 = f11;
                f3 = f8;
                canvas.saveLayer(0.0f, 0.0f, dimensionPixelSize, f4, null);
            } else {
                linearGradient = linearGradient2;
                i = i5;
                f2 = f11;
                f3 = f8;
                i2 = i4;
                canvas.saveLayer(0.0f, 0.0f, dimensionPixelSize, f4, null, 31);
            }
            paint.setColor(-1);
            rectF.set(f3, f3, f9, f10);
            canvas.drawRoundRect(rectF, f2, f2, paint);
            paint.setXfermode(porterDuffXfermode);
            if (z2) {
                float height = (f4 / bitmap.getHeight()) * f4;
                float f12 = (f4 - height) / 2.0f;
                rectF.set(new RectF(rectF.left, f12, rectF.right, height + f12));
                canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
                shader = null;
            } else {
                float f13 = dimensionPixelSize;
                float width = ((bitmap.getWidth() * (((dimensionPixelSize3 * 2) + dimensionPixelSize2) - (i3 * 2))) / bitmap.getHeight()) - f13;
                float f14 = 2;
                rectF.set((-width) / f14, -dimensionPixelSize3, f13 + (width / f14), dimensionPixelSize2 + dimensionPixelSize3);
                shader = null;
                canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
            }
            paint.setShader(linearGradient);
            rectF.set(f3, f3, f9, f10);
            canvas.drawRoundRect(rectF, f2, f2, paint);
            paint.setShader(shader);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(i6);
            paint.setColor(553648127);
            float f15 = i3 + (i6 / 2);
            rectF.set(f15, f15, i2 - r1, i - r1);
            canvas.drawRoundRect(rectF, f2, f2, paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setXfermode(null);
            canvas.restore();
            kotlin.jvm.internal.h.a((Object) createBitmap, "bm");
            return createBitmap;
        }
    }

    /* compiled from: ProjectGalleryAdapter.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, int i);
    }

    /* compiled from: ProjectGalleryAdapter.kt */
    /* loaded from: classes2.dex */
    public final class c extends RecyclerView.ViewHolder implements View.OnClickListener {
        final /* synthetic */ Eb s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Eb eb, View view) {
            super(view);
            kotlin.jvm.internal.h.b(view, "itemView");
            this.s = eb;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            kotlin.jvm.internal.h.b(view, "v");
            if (getAdapterPosition() == -1) {
                return;
            }
            Eb eb = this.s;
            eb.notifyItemChanged(eb.i());
            this.s.c(getAdapterPosition());
            Eb eb2 = this.s;
            eb2.notifyItemChanged(eb2.i());
            b g2 = this.s.g();
            if (g2 != null) {
                g2.a(view, getAdapterPosition());
            }
        }

        public final void t() {
            String format;
            if (getAdapterPosition() < this.s.h().size()) {
                this.itemView.setOnClickListener(null);
                this.itemView.setOnClickListener(this);
                com.nexstreaming.kinemaster.project.k kVar = this.s.h().get(getAdapterPosition());
                Bitmap b2 = kVar != null ? kVar.b() : null;
                if (b2 != null) {
                    com.bumptech.glide.h<Bitmap> a2 = this.s.m.a().a(b2);
                    a2.a((com.bumptech.glide.k<?, ? super Bitmap>) new com.bumptech.glide.load.resource.bitmap.f().b());
                    com.bumptech.glide.h<Bitmap> a3 = a2.a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().b());
                    a3.b((com.bumptech.glide.request.e<Bitmap>) new Fb(this));
                    View view = this.itemView;
                    kotlin.jvm.internal.h.a((Object) view, "itemView");
                    a3.a((ImageView) view.findViewById(com.nexstreaming.app.kinemasterfree.b.thumbnail));
                }
                int g2 = kVar != null ? kVar.g() : 0;
                if (1 <= g2 && 1000 > g2) {
                    g2 = 1000;
                }
                if (kVar != null) {
                    Date d2 = kVar.d();
                    if (d2 == null) {
                        format = "";
                    } else {
                        View view2 = this.itemView;
                        kotlin.jvm.internal.h.a((Object) view2, "itemView");
                        format = DateFormat.getMediumDateFormat(view2.getContext()).format(d2);
                    }
                    kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f28544a;
                    long j = g2;
                    String str = format;
                    Object[] objArr = {Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(kVar.g()) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(kVar.g()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))};
                    String format2 = String.format("%02d:%02d:%02d", Arrays.copyOf(objArr, objArr.length));
                    kotlin.jvm.internal.h.a((Object) format2, "java.lang.String.format(format, *args)");
                    View view3 = this.itemView;
                    kotlin.jvm.internal.h.a((Object) view3, "itemView");
                    TextView textView = (TextView) view3.findViewById(com.nexstreaming.app.kinemasterfree.b.name);
                    kotlin.jvm.internal.h.a((Object) textView, "itemView.name");
                    String f2 = kVar.f();
                    if (f2 == null) {
                        f2 = "";
                    }
                    textView.setText(f2);
                    View view4 = this.itemView;
                    kotlin.jvm.internal.h.a((Object) view4, "itemView");
                    TextView textView2 = (TextView) view4.findViewById(com.nexstreaming.app.kinemasterfree.b.detailDate);
                    kotlin.jvm.internal.h.a((Object) textView2, "itemView.detailDate");
                    textView2.setText(str);
                    View view5 = this.itemView;
                    kotlin.jvm.internal.h.a((Object) view5, "itemView");
                    TextView textView3 = (TextView) view5.findViewById(com.nexstreaming.app.kinemasterfree.b.detailTime);
                    kotlin.jvm.internal.h.a((Object) textView3, "itemView.detailTime");
                    textView3.setText(format2);
                    View view6 = this.itemView;
                    kotlin.jvm.internal.h.a((Object) view6, "itemView");
                    FrameLayout frameLayout = (FrameLayout) view6.findViewById(com.nexstreaming.app.kinemasterfree.b.fl_selection);
                    kotlin.jvm.internal.h.a((Object) frameLayout, "itemView.fl_selection");
                    frameLayout.setVisibility(0);
                    return;
                }
                return;
            }
            View view7 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view7, "itemView");
            TextView textView4 = (TextView) view7.findViewById(com.nexstreaming.app.kinemasterfree.b.name);
            kotlin.jvm.internal.h.a((Object) textView4, "itemView.name");
            textView4.setText("");
            View view8 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view8, "itemView");
            TextView textView5 = (TextView) view8.findViewById(com.nexstreaming.app.kinemasterfree.b.detailDate);
            kotlin.jvm.internal.h.a((Object) textView5, "itemView.detailDate");
            textView5.setText("");
            View view9 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view9, "itemView");
            TextView textView6 = (TextView) view9.findViewById(com.nexstreaming.app.kinemasterfree.b.detailTime);
            kotlin.jvm.internal.h.a((Object) textView6, "itemView.detailTime");
            textView6.setText("");
            View view10 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view10, "itemView");
            FrameLayout frameLayout2 = (FrameLayout) view10.findViewById(com.nexstreaming.app.kinemasterfree.b.fl_selection);
            kotlin.jvm.internal.h.a((Object) frameLayout2, "itemView.fl_selection");
            frameLayout2.setVisibility(8);
            View view11 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view11, "itemView");
            CardView cardView = (CardView) view11.findViewById(com.nexstreaming.app.kinemasterfree.b.cv_container);
            kotlin.jvm.internal.h.a((Object) cardView, "itemView.cv_container");
            cardView.setCardElevation(0.0f);
            View view12 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view12, "itemView");
            ((CardView) view12.findViewById(com.nexstreaming.app.kinemasterfree.b.cv_container)).setCardBackgroundColor(0);
            View view13 = this.itemView;
            kotlin.jvm.internal.h.a((Object) view13, "itemView");
            ((ImageView) view13.findViewById(com.nexstreaming.app.kinemasterfree.b.thumbnail)).setImageResource(R.drawable.project_gallery_card_view_background);
        }
    }

    public Eb(Context context, com.bumptech.glide.j jVar, View view, View view2, int i, int i2, ArrayList<com.nexstreaming.kinemaster.project.k> arrayList) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(jVar, "glide");
        kotlin.jvm.internal.h.b(view, "prevFocusView");
        kotlin.jvm.internal.h.b(view2, "nextFocusView");
        kotlin.jvm.internal.h.b(arrayList, "projectInfoList");
        this.l = context;
        this.m = jVar;
        this.n = view;
        this.o = view2;
        this.p = i;
        this.q = i2;
        this.f22827e = -1;
        this.f22829g = arrayList;
    }

    private final Integer m() {
        this.k = Integer.valueOf(f22826d.a(this.l, this.p, this.q));
        return this.k;
    }

    public final void f() {
        this.f22828f = this.f22827e;
        this.f22827e = -1;
        notifyItemChanged(this.f22828f);
    }

    public final b g() {
        return this.f22830h;
    }

    public final com.nexstreaming.kinemaster.project.k getItem(int i) {
        if (i < 0 || i >= this.f22829g.size()) {
            return null;
        }
        return this.f22829g.get(i);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size = this.f22829g.size();
        Integer m = m();
        if (m == null) {
            return size;
        }
        int intValue = m.intValue();
        double d2 = size;
        double d3 = intValue;
        Double.isNaN(d2);
        Double.isNaN(d3);
        int ceil = (((int) Math.ceil(d2 / d3)) * intValue) - size;
        if (size < 6) {
            return 6;
        }
        return size % intValue != 0 ? size + ceil : size;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int a2;
        if (this.j == null) {
            return R.layout.project_list_item;
        }
        a2 = kotlin.collections.k.a((List) this.f22829g);
        return (a2 >= 1 && i == 1 && this.f22829g.get(1) == null) ? R.layout.project_list_ad_item : R.layout.project_list_item;
    }

    public final ArrayList<com.nexstreaming.kinemaster.project.k> h() {
        return this.f22829g;
    }

    public final int i() {
        return this.f22827e;
    }

    public final boolean j() {
        return this.j == null;
    }

    public final void k() {
        this.f22827e = this.f22828f;
        RecyclerView recyclerView = this.i;
        if (recyclerView != null) {
            recyclerView.post(new Hb(this));
        }
    }

    public final void l() {
        this.f22827e = 0;
        RecyclerView recyclerView = this.i;
        if (recyclerView != null) {
            recyclerView.post(new Ib(this));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.h.b(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.i = recyclerView;
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            recyclerView.setOnKeyListener(new Gb(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.SimpleItemAnimator");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        kotlin.jvm.internal.h.b(viewHolder, "holder");
        c cVar = (c) viewHolder;
        if (cVar.getItemViewType() == R.layout.project_list_item) {
            cVar.t();
        }
        View view = cVar.itemView;
        kotlin.jvm.internal.h.a((Object) view, "itemView");
        FrameLayout frameLayout = (FrameLayout) view.findViewById(com.nexstreaming.app.kinemasterfree.b.fl_selection);
        kotlin.jvm.internal.h.a((Object) frameLayout, "itemView.fl_selection");
        frameLayout.setSelected(this.f22827e == i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.view.View] */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewGroup viewGroup2;
        kotlin.jvm.internal.h.b(viewGroup, "parent");
        switch (i) {
            case R.layout.project_list_ad_item /* 2131493230 */:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
                if (inflate != null) {
                    ViewGroup viewGroup3 = (ViewGroup) inflate;
                    viewGroup2 = viewGroup3;
                    if (getItemCount() >= 1) {
                        FrameLayout frameLayout = this.j;
                        viewGroup2 = viewGroup3;
                        if (frameLayout != null) {
                            ViewParent parent = frameLayout != null ? frameLayout.getParent() : null;
                            if (!(parent instanceof ViewGroup)) {
                                parent = null;
                            }
                            ViewGroup viewGroup4 = (ViewGroup) parent;
                            if (viewGroup4 != null) {
                                viewGroup4.removeView(this.j);
                            }
                            viewGroup3.addView(this.j, 0);
                            viewGroup2 = viewGroup3;
                            break;
                        }
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                break;
            case R.layout.project_list_item /* 2131493231 */:
                viewGroup2 = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
                break;
            default:
                viewGroup2 = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
                break;
        }
        kotlin.jvm.internal.h.a((Object) viewGroup2, "when (viewType) {\n      … false)\n                }");
        return new c(this, viewGroup2);
    }

    public final void b(int i, int i2) {
        this.p = i2;
        this.q = i;
    }

    public final void c(int i) {
        this.f22827e = i;
    }

    public final void a(ArrayList<com.nexstreaming.kinemaster.project.k> arrayList) {
        kotlin.jvm.internal.h.b(arrayList, "value");
        if (arrayList.size() >= 1 && this.j != null) {
            arrayList.add(1, null);
        }
        this.f22829g = arrayList;
    }

    public final void a(b bVar) {
        this.f22830h = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a(RecyclerView.LayoutManager layoutManager, int i) {
        int i2 = this.f22827e + i;
        int itemCount = getItemCount();
        if (i2 < 0 || itemCount <= i2) {
            return false;
        }
        notifyItemChanged(this.f22827e);
        this.f22827e = i2;
        notifyItemChanged(this.f22827e);
        layoutManager.scrollToPosition(this.f22827e);
        return true;
    }

    public final Bitmap a(Context context, int i) {
        kotlin.jvm.internal.h.b(context, com.umeng.analytics.pro.b.Q);
        com.nexstreaming.kinemaster.project.k kVar = this.f22829g.get(i);
        if (kVar == null) {
            return null;
        }
        a aVar = f22826d;
        kotlin.jvm.internal.h.a((Object) kVar, "it");
        Bitmap b2 = kVar.b();
        Resources resources = context.getResources();
        kotlin.jvm.internal.h.a((Object) resources, "context.resources");
        return aVar.a(b2, resources, true, false);
    }

    public final void a(FrameLayout frameLayout) {
        if (frameLayout == null) {
            if (this.j != null && this.f22829g.size() >= 2) {
                this.f22829g.remove(1);
                notifyDataSetChanged();
            }
        } else {
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.ad_imageview);
            if (imageView != null) {
                Drawable drawable = imageView.getDrawable();
                a aVar = f22826d;
                if (drawable == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                }
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Resources resources = frameLayout.getResources();
                kotlin.jvm.internal.h.a((Object) resources, "adView.resources");
                imageView.setImageBitmap(aVar.a(bitmap, resources, false, true));
            }
            if (this.f22829g.size() >= 1 && (this.f22829g.size() < 2 || this.f22829g.get(1) != null)) {
                this.f22829g.add(1, null);
                notifyDataSetChanged();
            }
        }
        this.j = frameLayout;
    }
}
