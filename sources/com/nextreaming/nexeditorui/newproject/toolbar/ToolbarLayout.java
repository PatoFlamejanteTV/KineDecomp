package com.nextreaming.nexeditorui.newproject.toolbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.app.kinemasterfree.b;
import com.nextreaming.nexeditorui.a.a.a;

/* loaded from: classes.dex */
public class ToolbarLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private String f4749a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private View g;
    private ImageView h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private ImageButton m;
    private ImageButton n;
    private com.nextreaming.nexeditorui.a.a.a o;
    private a.InterfaceC0083a p;
    private View.OnClickListener q;
    private View.OnClickListener r;
    private View.OnClickListener s;
    private View.OnClickListener t;
    private View.OnClickListener u;
    private View.OnClickListener v;

    public ToolbarLayout(Context context) {
        super(context);
    }

    public ToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    public ToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    @TargetApi(21)
    public ToolbarLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_toolbar, (ViewGroup) this, true);
        this.g = findViewById(R.id.toolbar_navigation_holder);
        this.h = (ImageView) findViewById(R.id.imageButton_toolbar_navigation_icon);
        this.i = (TextView) findViewById(R.id.textView_toolbar_navi_title);
        this.j = (ImageView) findViewById(R.id.imageButton_toolbar_logo);
        this.k = (TextView) findViewById(R.id.textView_toolbar_title);
        this.l = (ImageView) findViewById(R.id.imageButton_toolbar_menu);
        this.m = (ImageButton) findViewById(R.id.button_toolbar_accept);
        this.n = (ImageButton) findViewById(R.id.button_toolbar_cancel);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.a.ToolbarLayout);
            this.b = obtainStyledAttributes.getResourceId(2, 0);
            this.c = obtainStyledAttributes.getResourceId(1, 0);
            this.f4749a = obtainStyledAttributes.getString(0);
            this.d = obtainStyledAttributes.getResourceId(3, 0);
            if (this.b != 0) {
                setNavigationIcon(this.b);
            }
            if (this.c != 0) {
                setLogo(this.c);
            }
            if (this.f4749a != null) {
                setTitle(this.f4749a);
            }
            if (this.d != 0) {
                setMenu(this.d);
            }
            obtainStyledAttributes.recycle();
        }
        this.o = new com.nextreaming.nexeditorui.a.a.a(getContext(), this.l);
        this.o.a(new a(this));
    }

    public void setNavigationIcon(int i) {
        this.h.setImageDrawable(getContext().getResources().getDrawable(i));
        this.g.setOnClickListener(this);
    }

    public View getNavigation() {
        return this.h;
    }

    public void setLogo(int i) {
        this.j.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public View getLogo() {
        return this.j;
    }

    public void setTitle(int i) {
        setTitle(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    public View getTitle() {
        return this.k;
    }

    public void setTitleOnClickListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
        findViewById(R.id.textView_toolbar_title).setOnClickListener(this);
    }

    public void setNaviTitle(CharSequence charSequence) {
        this.g.setVisibility(0);
        this.i.setText(charSequence);
    }

    public View getNaviTitle() {
        return this.i;
    }

    public View getMenuButton() {
        return this.l;
    }

    public void setNaviDepthFirstListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
        findViewById(R.id.one_depth_text).setOnClickListener(this);
    }

    public void setNaviDepthFirst(String str) {
        findViewById(R.id.one_depth_navi_icon).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.one_depth_text);
        textView.setText(str);
        textView.setSelected(true);
        textView.setVisibility(0);
    }

    public void setNaviDepthSecond(String str) {
        ((TextView) findViewById(R.id.one_depth_text)).setSelected(false);
        findViewById(R.id.two_depth_navi_icon).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.two_depth_text);
        textView.setText(str);
        textView.setSelected(true);
        textView.setVisibility(0);
    }

    public void setSubTitle(Bitmap bitmap) {
        a(bitmap, getContext().getResources().getDrawable(R.drawable.icon_toolbar_subtitle));
    }

    public void setSubTitle(CharSequence charSequence) {
        a(charSequence, getContext().getResources().getDrawable(R.drawable.icon_toolbar_subtitle));
    }

    public void a(CharSequence charSequence, Drawable drawable) {
        View childAt = ((ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder)).getChildAt(0);
        if (childAt == null) {
            b(charSequence, drawable);
            return;
        }
        ImageView imageView = (ImageView) childAt.findViewById(R.id.imageView_toolbar_subtitle_icon);
        TextView textView = (TextView) childAt.findViewById(R.id.textView_toolbar_subtitle_text);
        imageView.setImageDrawable(drawable);
        textView.setText(charSequence);
    }

    public void a(Bitmap bitmap, Drawable drawable) {
        View childAt = ((ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder)).getChildAt(0);
        if (childAt == null) {
            b(bitmap, drawable);
            return;
        }
        ImageView imageView = (ImageView) childAt.findViewById(R.id.imageView_toolbar_subtitle_icon);
        IconView iconView = (IconView) childAt.findViewById(R.id.iconView_toolbar_subtitle_img);
        imageView.setImageDrawable(drawable);
        iconView.setImageBitmap(bitmap);
    }

    public void b(CharSequence charSequence, Drawable drawable) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_toolbar_subtitle_item, (ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder), true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView_toolbar_subtitle_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.textView_toolbar_subtitle_text);
        imageView.setImageDrawable(drawable);
        textView.setText(charSequence);
        b();
    }

    public void b(Bitmap bitmap, Drawable drawable) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_toolbar_subtitle_item, (ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder), true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView_toolbar_subtitle_icon);
        IconView iconView = (IconView) inflate.findViewById(R.id.iconView_toolbar_subtitle_img);
        imageView.setImageDrawable(drawable);
        iconView.setImageBitmap(bitmap);
        b();
    }

    public void a() {
        ((ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder)).removeViewAt(r0.getChildCount() - 1);
        ((ImageView) findViewById(R.id.imageButton_toolbar_delete_icon)).setVisibility(8);
    }

    public void b() {
        ImageView imageView = (ImageView) findViewById(R.id.imageButton_toolbar_delete_icon);
        if (imageView.getVisibility() == 8) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(this);
        } else if (imageView.getVisibility() == 0) {
            imageView.setVisibility(8);
        }
    }

    public void setMenu(int i) {
        this.l.setVisibility(0);
        this.l.setImageDrawable(getContext().getResources().getDrawable(i));
        this.l.setOnClickListener(this);
    }

    public void setAcceptButtonVisible(boolean z) {
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void setCancelButtonVisible(boolean z) {
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public void setSelectIcon(int i) {
        this.m.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSelectedMenuPosition(int i) {
        this.e = i;
    }

    public Menu getMenu() {
        return this.o.a();
    }

    public void setNavigationOnClickListeners(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setOnAcceptListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
        this.m.setOnClickListener(this);
    }

    public void setOnCancelListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
        this.n.setOnClickListener(this);
    }

    public void setOnMenuItemClickListener(a.InterfaceC0083a interfaceC0083a) {
        this.p = interfaceC0083a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.o != null) {
            this.o.c();
        }
        super.onDetachedFromWindow();
    }

    public void setHiddenMenuPopup(boolean z) {
        this.f = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton_toolbar_delete_icon /* 2131820626 */:
                a();
                if (this.r != null) {
                    this.r.onClick(view);
                    return;
                }
                return;
            case R.id.textView_toolbar_title /* 2131821110 */:
                if (this.v != null) {
                    this.v.onClick(view);
                    return;
                }
                return;
            case R.id.one_depth_text /* 2131821112 */:
                if (this.u != null) {
                    this.u.onClick(view);
                    return;
                }
                return;
            case R.id.imageButton_toolbar_menu /* 2131821119 */:
                if (!this.f) {
                    this.o.b(this.e);
                    this.o.b();
                    return;
                }
                return;
            case R.id.button_toolbar_cancel /* 2131821120 */:
                if (this.t != null) {
                    this.t.onClick(view);
                    return;
                }
                return;
            case R.id.button_toolbar_accept /* 2131821121 */:
                if (this.s != null) {
                    this.s.onClick(view);
                    return;
                }
                return;
            case R.id.toolbar_navigation_holder /* 2131821122 */:
                if (this.q != null) {
                    this.q.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
