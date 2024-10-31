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
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f4536a;
    private List<ColorEffect> b;
    private a d;
    private int c = -1;
    private View.OnTouchListener e = new c(this);

    /* compiled from: ColorEffectListAdapter.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    public void a(a aVar) {
        this.d = aVar;
    }

    public b(Context context, List<ColorEffect> list) {
        this.f4536a = context;
        this.b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void a(int i) {
        this.c = i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        Drawable drawable;
        ColorEffect colorEffect = this.b.get(i);
        if (view == null) {
            view2 = new ImageView(this.f4536a);
            int applyDimension = (int) TypedValue.applyDimension(1, 2.0f, this.f4536a.getResources().getDisplayMetrics());
            view2.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
            view2.setOnTouchListener(this.e);
        } else {
            view2 = view;
        }
        if (colorEffect.getIconResourceId() != 0) {
            drawable = this.f4536a.getResources().getDrawable(colorEffect.getIconResourceId());
        } else {
            drawable = this.f4536a.getResources().getDrawable(R.drawable.img_sample_color_effect);
        }
        z zVar = new z(a((BitmapDrawable) drawable, (int) TypedValue.applyDimension(1, 4.0f, this.f4536a.getResources().getDisplayMetrics())));
        ColorMatrix colorMatrix = colorEffect.getColorMatrix();
        if (colorMatrix != null) {
            zVar.a(colorMatrix);
        }
        if (this.c == i) {
            ((ImageView) view2).setImageBitmap(a(zVar, this.f4536a.getResources().getDrawable(R.drawable.color_tint_selected)));
            view2.setBackground(null);
        } else {
            ((ImageView) view2).setImageDrawable(zVar);
            view2.setBackground(null);
        }
        view2.setTag(Integer.valueOf(i));
        view2.setLayoutParams(new AbsListView.LayoutParams((int) TypedValue.applyDimension(1, 80.4f, this.f4536a.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 47.0f, this.f4536a.getResources().getDisplayMetrics())));
        return view2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return false;
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
        canvas.drawRoundRect(rectF, i, i, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return new BitmapDrawable(this.f4536a.getResources(), createBitmap);
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
