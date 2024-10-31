package com.nexstreaming.kinemaster.ui.projectgallery;

import android.app.FragmentManager;
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
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.a.a.c;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: ProjectAdapter.java */
/* loaded from: classes.dex */
public class x extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<com.nexstreaming.kinemaster.project.f> f4225a;
    private com.nextreaming.a.a.e b;
    private Bitmap c;
    private Bitmap d;

    @Override // android.widget.Adapter
    public int getCount() {
        int size;
        if (this.f4225a != null && (size = this.f4225a.size()) >= 6) {
            return size % 2 != 0 ? size + 1 : size;
        }
        return 6;
    }

    public void a(List<com.nexstreaming.kinemaster.project.f> list) {
        this.f4225a = list;
        notifyDataSetChanged();
    }

    public List<com.nexstreaming.kinemaster.project.f> a() {
        return this.f4225a;
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.nexstreaming.kinemaster.project.f getItem(int i) {
        if (i < 0 || i >= this.f4225a.size()) {
            return null;
        }
        return this.f4225a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    private Bitmap a(Context context) {
        if (this.c == null) {
            this.c = a((Bitmap) null, context.getResources(), false);
        }
        return this.c;
    }

    private Bitmap b(Context context) {
        if (this.d == null) {
            this.d = a((Bitmap) null, context.getResources(), false);
        }
        return this.d;
    }

    public Bitmap a(Context context, int i) {
        return a(this.f4225a.get(i).e(), context.getResources(), true);
    }

    public static Bitmap a(Bitmap bitmap, Resources resources, boolean z) {
        int dimensionPixelSize;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (z) {
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_width);
            int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_height);
            int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_corner);
            int dimensionPixelSize5 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_radius);
            int dimensionPixelSize6 = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_shadow_offset);
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_details_thumb_border);
            i = dimensionPixelSize6;
            i2 = dimensionPixelSize5;
            i3 = dimensionPixelSize4;
            i4 = dimensionPixelSize3;
            i5 = dimensionPixelSize2;
        } else {
            int dimensionPixelSize7 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_width);
            int dimensionPixelSize8 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_height);
            int dimensionPixelSize9 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_corner);
            int dimensionPixelSize10 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_radius);
            int dimensionPixelSize11 = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_shadow_offset);
            dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.project_gallery_thumb_border);
            i = dimensionPixelSize11;
            i2 = dimensionPixelSize10;
            i3 = dimensionPixelSize9;
            i4 = dimensionPixelSize8;
            i5 = dimensionPixelSize7;
        }
        int i6 = i + i2;
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        LinearGradient linearGradient = new LinearGradient(0.0f, i4 / 8, 0.0f, i4, 0, -872415232, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Paint paint2 = new Paint();
        paint2.setShadowLayer(i2, i, i, 855638016);
        paint2.setColor(855638016);
        RectF rectF = new RectF();
        Bitmap createBitmap = Bitmap.createBitmap(i5, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (bitmap == null) {
            rectF.set(i6, i6, i5 - i6, i4 - i6);
            paint.setColor(469762048);
            canvas.drawRoundRect(rectF, i3, i3, paint);
            return createBitmap;
        }
        rectF.set(i6, i6, i5 - i6, i4 - i6);
        canvas.drawRoundRect(rectF, i3, i3, paint2);
        canvas.saveLayer(0.0f, 0.0f, i5, i4, null, 31);
        paint.setColor(-1);
        rectF.set(i6, i6, i5 - i6, i4 - i6);
        canvas.drawRoundRect(rectF, i3, i3, paint);
        paint.setXfermode(porterDuffXfermode);
        if (bitmap != null) {
            float width = ((bitmap.getWidth() * (((i3 * 2) + i4) - (i6 * 2))) / bitmap.getHeight()) - i5;
            rectF.set((-width) / 2.0f, -i3, (width / 2.0f) + i5, i4 + i3);
            canvas.drawBitmap(bitmap, (Rect) null, rectF, paint);
        }
        paint.setShader(linearGradient);
        rectF.set(i6, i6, i5 - i6, i4 - i6);
        canvas.drawRoundRect(rectF, i3, i3, paint);
        paint.setShader(null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dimensionPixelSize);
        paint.setColor(553648127);
        rectF.set((dimensionPixelSize / 2) + i6, (dimensionPixelSize / 2) + i6, (i5 - i6) - (dimensionPixelSize / 2), (i4 - i6) - (dimensionPixelSize / 2));
        canvas.drawRoundRect(rectF, i3, i3, paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setXfermode(null);
        canvas.restore();
        return createBitmap;
    }

    private com.nextreaming.a.a.e c(Context context) {
        if (this.b == null) {
            this.b = new y(this, context, context.getResources());
        }
        return this.b;
    }

    public void a(Context context, FragmentManager fragmentManager, c.a aVar) {
        c(context).a(fragmentManager, aVar);
    }

    public void b() {
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.f4225a != null && i < this.f4225a.size();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.project_list_item, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.name);
        TextView textView2 = (TextView) view.findViewById(R.id.detailDate);
        TextView textView3 = (TextView) view.findViewById(R.id.detailTime);
        ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail);
        if (viewGroup != null && ((GridView) viewGroup).getRequestedColumnWidth() != view.getWidth()) {
            view.getLayoutParams().width = ((GridView) viewGroup).getRequestedColumnWidth();
        }
        if (this.f4225a != null && i < this.f4225a.size()) {
            com.nexstreaming.kinemaster.project.f fVar = this.f4225a.get(i);
            c(view.getContext()).a(fVar, imageView, a(view.getContext()));
            Date c = fVar.c();
            String format = c == null ? "" : DateFormat.getMediumDateFormat(view.getContext()).format(c);
            int d = fVar.d();
            if (d < 1000 && d >= 1) {
                d = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            }
            String format2 = String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(d)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(fVar.d()) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(d))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(fVar.d()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(d))));
            textView.setText(fVar.f());
            textView2.setText(format);
            textView3.setText(format2);
        } else {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            imageView.setImageBitmap(b(view.getContext()));
        }
        return view;
    }
}
