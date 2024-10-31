package com.adobe.creativesdk.foundation.internal.storage.controllers.b;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.a.a.b.g;
import com.adobe.creativesdk.foundation.internal.grid.utils.DynamicHeightImageView;
import com.adobe.creativesdk.foundation.internal.storage.controllers.Sc;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import java.util.Date;
import java.util.List;

/* compiled from: AdobeDesignLibraryItemsCellHolders.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0031a extends RecyclerView.ViewHolder {
        private C0622wb s;

        public AbstractC0031a(View view) {
            super(view);
        }

        public void a(C0622wb c0622wb) {
            this.s = c0622wb;
        }

        public C0622wb t() {
            return this.s;
        }

        public void a(boolean z) {
            this.itemView.setAlpha(z ? 0.3f : 1.0f);
        }
    }

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* loaded from: classes.dex */
    public static class b extends AbstractC0031a {
        private TextView t;
        private TextView u;
        private RelativeLayout v;
        private ImageView w;
        private RelativeLayout x;
        private View y;

        public b(View view) {
            super(view);
            a(view);
            b((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_color_rgb_text));
            b((RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_color_cell_background));
            a((ImageView) view.findViewById(c.a.a.a.b.e.adobe_libraryitem_color_menu_icon));
            a((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_color_date));
            a((RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_libraryitem_color_menu_layout));
        }

        public void a(String str) {
            z().setText(str);
        }

        public void b(TextView textView) {
            this.t = textView;
        }

        public void c(int i) {
            w().setBackgroundColor(i);
        }

        public View u() {
            return this.y;
        }

        public RelativeLayout v() {
            return this.x;
        }

        public RelativeLayout w() {
            return this.v;
        }

        public ImageView x() {
            return this.w;
        }

        public TextView y() {
            return this.u;
        }

        public TextView z() {
            return this.t;
        }

        public void a(long j) {
            y().setText(a.b(j, this.itemView));
        }

        public void b(RelativeLayout relativeLayout) {
            this.v = relativeLayout;
        }

        public void b(View.OnClickListener onClickListener) {
            v().setTag(this);
            v().setOnClickListener(onClickListener);
        }

        public void a(Typeface typeface) {
            z().setTypeface(typeface);
        }

        public void a(TextView textView) {
            this.u = textView;
        }

        public void a(ImageView imageView) {
            this.w = imageView;
        }

        public void a(RelativeLayout relativeLayout) {
            this.x = relativeLayout;
        }

        public void a(View view) {
            this.y = view;
        }

        public void a(View.OnClickListener onClickListener) {
            u().setOnClickListener(onClickListener);
        }
    }

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* loaded from: classes.dex */
    public static class c extends AbstractC0031a {
        private LinearLayout t;
        private TextView u;
        private TextView v;
        private ImageView w;
        private RelativeLayout x;
        private View y;

        public c(View view) {
            super(view);
            a(view);
            a((LinearLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_colortheme_container));
            b((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_colortheme_text));
            a((ImageView) view.findViewById(c.a.a.a.b.e.adobe_libraryitem_colortheme_menu_icon));
            a((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_colortheme_date));
            a((RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_colortheme_menu_layout));
        }

        public void a(List<Integer> list) {
            int min = Math.min(w().getChildCount(), list.size());
            for (int i = 0; i < min; i++) {
                w().getChildAt(i).setBackgroundColor(list.get(i).intValue());
            }
        }

        public void b(TextView textView) {
            this.u = textView;
        }

        public View u() {
            return this.y;
        }

        public RelativeLayout v() {
            return this.x;
        }

        public LinearLayout w() {
            return this.t;
        }

        public ImageView x() {
            return this.w;
        }

        public TextView y() {
            return this.v;
        }

        public TextView z() {
            return this.u;
        }

        public void b(View.OnClickListener onClickListener) {
            v().setTag(this);
            v().setOnClickListener(onClickListener);
        }

        public void a(String str) {
            z().setText(str);
        }

        public void a(long j) {
            y().setText(a.b(j, this.itemView));
        }

        public void a(Typeface typeface) {
            z().setTypeface(typeface);
        }

        public void a(LinearLayout linearLayout) {
            this.t = linearLayout;
        }

        public void a(TextView textView) {
            this.v = textView;
        }

        public void a(ImageView imageView) {
            this.w = imageView;
        }

        public void a(RelativeLayout relativeLayout) {
            this.x = relativeLayout;
        }

        public void a(View view) {
            this.y = view;
        }

        public void a(View.OnClickListener onClickListener) {
            u().setOnClickListener(onClickListener);
        }
    }

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* loaded from: classes.dex */
    public static class d extends AbstractC0031a {
        private TextView t;

        public d(View view) {
            super(view);
            a((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_header_text_id));
        }

        public void a(String str) {
            u().setText(str);
        }

        public TextView u() {
            return this.t;
        }

        public void a(TextView textView) {
            this.t = textView;
        }
    }

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* loaded from: classes.dex */
    public static class e extends AbstractC0031a {
        private DynamicHeightImageView t;
        private TextView u;
        private TextView v;
        private RelativeLayout w;
        private ImageView x;
        private RelativeLayout y;
        private View z;

        public e(View view) {
            super(view);
            a(view);
            b((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_imagecolletion_title));
            a((DynamicHeightImageView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_imagecollection_image));
            u().setHeightRatio(1.0d);
            b((RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_libraryitem_cell_relativelayout));
            a((ImageView) view.findViewById(c.a.a.a.b.e.adobe_libraryitem_menu_icon));
            a((RelativeLayout) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_imagecollection_menu_layout));
            a((TextView) view.findViewById(c.a.a.a.b.e.adobe_csdk_library_items_imagecollection_date));
        }

        public void a(Bitmap bitmap) {
            u().setImageBitmap(bitmap);
        }

        public void b(TextView textView) {
            this.u = textView;
        }

        public DynamicHeightImageView u() {
            return this.t;
        }

        public View v() {
            return this.z;
        }

        public RelativeLayout w() {
            return this.y;
        }

        public ImageView x() {
            return this.x;
        }

        public TextView y() {
            return this.v;
        }

        public TextView z() {
            return this.u;
        }

        public void a(BitmapDrawable bitmapDrawable) {
            u().setImageDrawable(bitmapDrawable);
        }

        public void b(RelativeLayout relativeLayout) {
            this.w = relativeLayout;
        }

        public void a(double d2) {
            u().setHeightRatio(d2);
        }

        public void b(View.OnClickListener onClickListener) {
            w().setTag(this);
            w().setOnClickListener(onClickListener);
        }

        public void a(long j) {
            y().setText(a.b(j, this.itemView));
        }

        public void a(Typeface typeface) {
            z().setTypeface(typeface);
        }

        @Override // com.adobe.creativesdk.foundation.internal.storage.controllers.b.a.AbstractC0031a
        public void a(boolean z) {
            u().setAlpha(z ? 0.3f : 1.0f);
            z().setAlpha(z ? 0.3f : 1.0f);
        }

        public void a(String str) {
            z().setText(str);
        }

        public void a(DynamicHeightImageView dynamicHeightImageView) {
            this.t = dynamicHeightImageView;
        }

        public void a(TextView textView) {
            this.v = textView;
        }

        public void a(ImageView imageView) {
            this.x = imageView;
        }

        public void a(RelativeLayout relativeLayout) {
            this.y = relativeLayout;
        }

        public void a(View view) {
            this.z = view;
        }

        public void a(View.OnClickListener onClickListener) {
            v().setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j, View view) {
        return com.adobe.creativesdk.foundation.internal.utils.a.a(view.getContext(), new Date(j));
    }

    /* compiled from: AdobeDesignLibraryItemsCellHolders.java */
    /* loaded from: classes.dex */
    public static class f extends e {
        private Sc.b A;

        private f(View view) {
            super(view);
        }

        public static f a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Sc.b bVar = new Sc.b();
            bVar.a(layoutInflater, g.adobe_library_items_imagecollectioncell, viewGroup);
            f fVar = new f(bVar.g());
            fVar.a(bVar);
            return fVar;
        }

        public Sc.b A() {
            return this.A;
        }

        public void a(Sc.b bVar) {
            this.A = bVar;
        }
    }
}
