package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.List;

/* compiled from: ColorEffectListAdapter.java */
/* renamed from: com.nextreaming.nexeditorui.c */
/* loaded from: classes.dex */
public class C2300c extends BaseAdapter {

    /* renamed from: a */
    private Context f24217a;

    /* renamed from: b */
    private List<ColorEffect> f24218b;

    /* renamed from: d */
    private a f24220d;

    /* renamed from: c */
    private int f24219c = -1;

    /* renamed from: e */
    private View.OnTouchListener f24221e = new ViewOnTouchListenerC2298b(this);

    /* compiled from: ColorEffectListAdapter.java */
    /* renamed from: com.nextreaming.nexeditorui.c$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public C2300c(Context context, List<ColorEffect> list) {
        this.f24217a = context;
        this.f24218b = list;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24218b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24218b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Drawable drawable;
        ColorEffect colorEffect = this.f24218b.get(i);
        if (view == null) {
            view = new ImageView(this.f24217a);
            int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, this.f24217a.getResources().getDisplayMetrics());
            view.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
            view.setOnTouchListener(this.f24221e);
        }
        if (colorEffect.getIconResourceId() != 0) {
            drawable = this.f24217a.getResources().getDrawable(colorEffect.getIconResourceId());
        } else {
            drawable = this.f24217a.getResources().getDrawable(R.drawable.img_sample_color_effect);
        }
        C2341x c2341x = new C2341x(a((BitmapDrawable) drawable, (int) TypedValue.applyDimension(1, 4.0f, this.f24217a.getResources().getDisplayMetrics())));
        ColorMatrix colorMatrix = colorEffect.getColorMatrix();
        if (colorMatrix != null) {
            c2341x.a(colorMatrix);
        }
        if (this.f24219c == i) {
            ((ImageView) view).setImageBitmap(a(c2341x, this.f24217a.getResources().getDrawable(R.drawable.color_tint_selected)));
            view.setBackground(null);
        } else {
            ((ImageView) view).setImageDrawable(c2341x);
            view.setBackground(null);
        }
        view.setTag(Integer.valueOf(i));
        view.setLayoutParams(new AbsListView.LayoutParams(this.f24217a.getResources().getDimensionPixelOffset(R.dimen.pedit_color_tint_grid_view_item_width), this.f24217a.getResources().getDimensionPixelOffset(R.dimen.pedit_color_tint_grid_view_item_height)));
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
    }

    public void a(a aVar) {
        this.f24220d = aVar;
    }

    public void a(int i) {
        this.f24219c = i;
    }

    public Drawable a(BitmapDrawable bitmapDrawable, int i) {
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setColor(-12434878);
        canvas.drawARGB(0, 0, 0, 0);
        float f2 = i;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return new BitmapDrawable(this.f24217a.getResources(), createBitmap);
    }

    private Bitmap a(Drawable drawable, Drawable drawable2) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
        drawable.draw(canvas);
        int width = (int) ((canvas.getWidth() / 2) - ((drawable2.getIntrinsicWidth() * 1.2f) / 2.0f));
        int height = (int) ((canvas.getHeight() / 2) - ((drawable2.getIntrinsicHeight() * 1.2f) / 2.0f));
        drawable2.setBounds(width, height, (int) (width + (drawable2.getIntrinsicWidth() * 1.2f)), (int) (height + (drawable2.getIntrinsicHeight() * 1.2f)));
        drawable2.draw(canvas);
        return createBitmap;
    }
}
