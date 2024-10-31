package com.nexstreaming.kinemaster.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b;

/* loaded from: classes.dex */
public class ProductView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4377a = ProductView.class.getSimpleName();
    private RelativeLayout b;
    private TextView c;
    private TextView d;
    private TextView e;
    private Button f;
    private ImageView g;
    private boolean h;
    private View.OnTouchListener i;

    public ProductView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = new l(this);
        a(context);
    }

    public ProductView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = new l(this);
        a(context);
        a(context, attributeSet);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.product_view, (ViewGroup) this, true);
        this.b = (RelativeLayout) findViewById(R.id.layout_product_view_body);
        this.c = (TextView) findViewById(R.id.tv_product_title);
        this.d = (TextView) findViewById(R.id.tv_product_price);
        this.e = (TextView) findViewById(R.id.tv_product_discount);
        this.f = (Button) findViewById(R.id.btn_product_buy);
        this.g = (ImageView) findViewById(R.id.iv_product_best_badge);
        this.b.setOnTouchListener(this.i);
        this.c.setOnTouchListener(this.i);
        this.d.setOnTouchListener(this.i);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null && context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.a.ProductView);
            int resourceId = obtainStyledAttributes.getResourceId(0, R.drawable.product_view_default_bg_n);
            float dimension = obtainStyledAttributes.getDimension(1, getResources().getDimension(R.dimen.product_view_title_text_size));
            float dimension2 = obtainStyledAttributes.getDimension(2, getResources().getDimension(R.dimen.product_view_title_text_size));
            String string = obtainStyledAttributes.getString(3);
            obtainStyledAttributes.recycle();
            this.b.setBackgroundResource(resourceId);
            this.c.setTextSize(0, dimension);
            this.f.setTextSize(0, dimension2);
            this.f.setText(string);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        this.f.setTag(obj);
    }

    @Override // android.view.View
    public Object getTag() {
        return this.f.getTag();
    }

    public void setTitle(String str) {
        this.c.setText(str);
    }

    public void setTitle(int i) {
        setTitle(getContext().getString(i));
    }

    public void setTitleColor(int i) {
        this.c.setTextColor(i);
    }

    public void setPrice(String str) {
        this.d.setText(str);
    }

    public void setPrice(int i) {
        setPrice(getContext().getString(i));
    }

    public void setPriceColor(int i) {
        this.d.setTextColor(i);
    }

    public void setDiscountPercent(int i) {
        this.e.setVisibility((i <= 0 || !this.h) ? 8 : 0);
        this.e.setText(String.format(getResources().getString(R.string.save_percent), Integer.valueOf(i)));
    }

    public Button getBuyButton() {
        return this.f;
    }

    public void setBuyButtonText(String str) {
        this.f.setText(str);
    }

    public void setBuyButtonText(int i) {
        setBuyButtonText(getContext().getString(i));
    }

    public void setBest(boolean z) {
        this.h = z;
        this.g.setVisibility(this.h ? 0 : 8);
        this.e.setVisibility(this.h ? 0 : 8);
    }

    public void setBigSIze(boolean z) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.height = z ? (int) getResources().getDimension(R.dimen.product_view_best_height) : (int) getResources().getDimension(R.dimen.product_view_normal_height);
        this.b.setLayoutParams(layoutParams);
        this.b.setPadding(this.b.getPaddingLeft(), z ? (int) getResources().getDimension(R.dimen.product_view_best_padding_top) : (int) getResources().getDimension(R.dimen.product_view_padding_top), this.b.getPaddingRight(), this.b.getPaddingBottom());
    }

    public void setProductViewBackgroundResource(int i) {
        if (this.b != null) {
            this.b.setBackgroundResource(i);
        }
    }
}
