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
import com.nexstreaming.app.kinemasterfree.c;
import com.nextreaming.nexeditorui.a.a.b;

/* loaded from: classes3.dex */
public class ToolbarLayout extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private String f24373a;

    /* renamed from: b */
    private int f24374b;

    /* renamed from: c */
    private int f24375c;

    /* renamed from: d */
    private int f24376d;

    /* renamed from: e */
    private int f24377e;

    /* renamed from: f */
    private boolean f24378f;

    /* renamed from: g */
    private View f24379g;

    /* renamed from: h */
    private ImageView f24380h;
    private TextView i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private ImageButton m;
    private ImageButton n;
    private b o;
    private b.a p;
    private View.OnClickListener q;
    private View.OnClickListener r;
    private View.OnClickListener s;
    private View.OnClickListener t;
    private View.OnClickListener u;
    private View.OnClickListener v;

    public ToolbarLayout(Context context) {
        super(context);
    }

    public void b(CharSequence charSequence, Drawable drawable) {
        View childAt = ((ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder)).getChildAt(0);
        if (childAt == null) {
            a(charSequence, drawable);
            return;
        }
        ImageView imageView = (ImageView) childAt.findViewById(R.id.imageView_toolbar_subtitle_icon);
        TextView textView = (TextView) childAt.findViewById(R.id.textView_toolbar_subtitle_text);
        imageView.setImageDrawable(drawable);
        textView.setText(charSequence);
    }

    public View getLogo() {
        return this.j;
    }

    public Menu getMenu() {
        return this.o.b();
    }

    public View getMenuButton() {
        return this.l;
    }

    public View getNaviTitle() {
        return this.i;
    }

    public View getNavigation() {
        return this.f24380h;
    }

    public View getTitle() {
        return this.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_toolbar_accept /* 2131362399 */:
                View.OnClickListener onClickListener = this.s;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case R.id.button_toolbar_cancel /* 2131362400 */:
                View.OnClickListener onClickListener2 = this.t;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case R.id.imageButton_toolbar_delete_icon /* 2131362809 */:
                a();
                View.OnClickListener onClickListener3 = this.r;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            case R.id.imageButton_toolbar_menu /* 2131362811 */:
                if (this.f24378f) {
                    return;
                }
                this.o.b(this.f24377e);
                this.o.d();
                return;
            case R.id.one_depth_text /* 2131363075 */:
                View.OnClickListener onClickListener4 = this.u;
                if (onClickListener4 != null) {
                    onClickListener4.onClick(view);
                    return;
                }
                return;
            case R.id.textView_toolbar_title /* 2131363538 */:
                View.OnClickListener onClickListener5 = this.v;
                if (onClickListener5 != null) {
                    onClickListener5.onClick(view);
                    return;
                }
                return;
            case R.id.toolbar_navigation_holder /* 2131363594 */:
                View.OnClickListener onClickListener6 = this.q;
                if (onClickListener6 != null) {
                    onClickListener6.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        b bVar = this.o;
        if (bVar != null) {
            bVar.a();
        }
        super.onDetachedFromWindow();
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

    public void setDeleteOnClickListener(View.OnClickListener onClickListener) {
        this.r = onClickListener;
    }

    public void setHiddenMenuPopup(boolean z) {
        this.f24378f = z;
    }

    public void setLogo(int i) {
        this.j.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setMenu(int i) {
        this.l.setVisibility(0);
        this.l.setImageDrawable(getContext().getResources().getDrawable(i));
        this.l.setOnClickListener(this);
    }

    public void setNaviDepthFirst(String str) {
        findViewById(R.id.one_depth_navi_icon).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.one_depth_text);
        textView.setText(str);
        textView.setSelected(true);
        textView.setVisibility(0);
    }

    public void setNaviDepthFirstListener(View.OnClickListener onClickListener) {
        this.u = onClickListener;
        findViewById(R.id.one_depth_text).setOnClickListener(this);
    }

    public void setNaviDepthSecond(String str) {
        ((TextView) findViewById(R.id.one_depth_text)).setSelected(false);
        findViewById(R.id.two_depth_navi_icon).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.two_depth_text);
        textView.setText(str);
        textView.setSelected(true);
        textView.setVisibility(0);
    }

    public void setNaviTitle(CharSequence charSequence) {
        this.f24379g.setVisibility(0);
        this.i.setText(charSequence);
    }

    public void setNavigationIcon(int i) {
        this.f24380h.setImageDrawable(getContext().getResources().getDrawable(i));
        this.f24379g.setOnClickListener(this);
    }

    public void setNavigationOnClickListeners(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void setOnAcceptListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
        this.m.setOnClickListener(this);
    }

    public void setOnCancelListener(View.OnClickListener onClickListener) {
        this.t = onClickListener;
        this.n.setOnClickListener(this);
    }

    public void setOnMenuItemClickListener(b.a aVar) {
        this.p = aVar;
    }

    public void setSelectIcon(int i) {
        this.m.setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setSelectedMenuPosition(int i) {
        this.f24377e = i;
    }

    public void setSubTitle(Bitmap bitmap) {
        b(bitmap, getContext().getResources().getDrawable(R.drawable.icon_toolbar_subtitle));
    }

    public void setTitle(int i) {
        setTitle(getContext().getString(i));
    }

    public void setTitleOnClickListener(View.OnClickListener onClickListener) {
        this.v = onClickListener;
        findViewById(R.id.textView_toolbar_title).setOnClickListener(this);
    }

    public ToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    public void setSubTitle(CharSequence charSequence) {
        b(charSequence, getContext().getResources().getDrawable(R.drawable.icon_toolbar_subtitle));
    }

    public void setTitle(CharSequence charSequence) {
        this.k.setText(charSequence);
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_toolbar, (ViewGroup) this, true);
        this.f24379g = findViewById(R.id.toolbar_navigation_holder);
        this.f24380h = (ImageView) findViewById(R.id.imageButton_toolbar_navigation_icon);
        this.i = (TextView) findViewById(R.id.textView_toolbar_navi_title);
        this.j = (ImageView) findViewById(R.id.imageButton_toolbar_logo);
        this.k = (TextView) findViewById(R.id.textView_toolbar_title);
        this.l = (ImageView) findViewById(R.id.imageButton_toolbar_menu);
        this.m = (ImageButton) findViewById(R.id.button_toolbar_accept);
        this.n = (ImageButton) findViewById(R.id.button_toolbar_cancel);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, c.ToolbarLayout);
            this.f24374b = obtainStyledAttributes.getResourceId(2, 0);
            this.f24375c = obtainStyledAttributes.getResourceId(0, 0);
            this.f24373a = obtainStyledAttributes.getString(4);
            this.f24376d = obtainStyledAttributes.getResourceId(1, 0);
            int i = this.f24374b;
            if (i != 0) {
                setNavigationIcon(i);
            }
            int i2 = this.f24375c;
            if (i2 != 0) {
                setLogo(i2);
            }
            String str = this.f24373a;
            if (str != null) {
                setTitle(str);
            }
            int i3 = this.f24376d;
            if (i3 != 0) {
                setMenu(i3);
            }
            obtainStyledAttributes.recycle();
        }
        this.o = new b(getContext(), this.l);
        this.o.a(new a(this));
    }

    public ToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    @TargetApi(21)
    public ToolbarLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    public void b(Bitmap bitmap, Drawable drawable) {
        View childAt = ((ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder)).getChildAt(0);
        if (childAt == null) {
            a(bitmap, drawable);
            return;
        }
        ImageView imageView = (ImageView) childAt.findViewById(R.id.imageView_toolbar_subtitle_icon);
        IconView iconView = (IconView) childAt.findViewById(R.id.iconView_toolbar_subtitle_img);
        imageView.setImageDrawable(drawable);
        iconView.setImageBitmap(bitmap);
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

    public void a(CharSequence charSequence, Drawable drawable) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_toolbar_subtitle_item, (ViewGroup) findViewById(R.id.linear_toolbar_subtitle_holder), true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imageView_toolbar_subtitle_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.textView_toolbar_subtitle_text);
        imageView.setImageDrawable(drawable);
        textView.setText(charSequence);
        b();
    }

    public void a(Bitmap bitmap, Drawable drawable) {
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
}
