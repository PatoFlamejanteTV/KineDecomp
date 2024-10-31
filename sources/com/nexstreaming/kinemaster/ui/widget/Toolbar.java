package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.nexstreaming.app.general.util.IconButton;
import com.nexstreaming.app.general.util.IconView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nextreaming.nexeditorui.a.a.b;

/* loaded from: classes2.dex */
public class Toolbar extends RelativeLayout {

    /* renamed from: a */
    private TitleMode f23820a;

    /* renamed from: b */
    private SubTitleMode f23821b;

    /* renamed from: c */
    private String f23822c;

    /* renamed from: d */
    private String f23823d;

    /* renamed from: e */
    private String f23824e;

    /* renamed from: f */
    private int f23825f;

    /* renamed from: g */
    private TextView f23826g;

    /* renamed from: h */
    private View f23827h;
    private TextView i;
    private IconView j;
    private TextView k;
    private ImageView l;
    private ImageView m;
    private View n;
    private View o;
    private ImageButton p;
    private ImageButton q;
    private IconButton r;
    private View s;
    private com.nextreaming.nexeditorui.a.a.b t;
    private int u;
    private boolean v;
    private b.a w;
    private View.OnClickListener x;

    /* loaded from: classes2.dex */
    public enum ExitButtonMode {
        None,
        Done,
        Cancel
    }

    /* loaded from: classes2.dex */
    public enum SubTitleMode {
        None,
        Navigation,
        SelectItem
    }

    /* loaded from: classes2.dex */
    public enum TitleMode {
        Title,
        Back,
        Navigation,
        Detail
    }

    public Toolbar(Context context) {
        super(context);
        this.f23820a = TitleMode.Title;
        this.f23821b = SubTitleMode.None;
        this.f23822c = "";
    }

    public int getCurrentDepth() {
        return this.f23825f;
    }

    public Menu getMenu() {
        return this.t.b();
    }

    public String getTitle() {
        return this.f23822c;
    }

    public TitleMode getTitleMode() {
        return this.f23820a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.nextreaming.nexeditorui.a.a.b bVar = this.t;
        if (bVar != null) {
            bVar.a();
        }
        super.onDetachedFromWindow();
    }

    public void setCategoryIcon(String str) {
        if (this.m == null) {
            this.m = (ImageView) findViewById(R.id.categoryIcon);
        }
        if (!TextUtils.isEmpty(str)) {
            setCategoryVisiblity(true);
            com.bumptech.glide.c.b(getContext()).a(str).a((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().a(Integer.MIN_VALUE, Integer.MIN_VALUE)).a(this.m);
        } else {
            setCategoryVisiblity(false);
        }
    }

    public void setCategoryVisiblity(boolean z) {
        if (this.m == null) {
            this.m = (ImageView) findViewById(R.id.categoryIcon);
        }
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.x = onClickListener;
    }

    public void setExitButtonMode(ExitButtonMode exitButtonMode) {
        int i = u.f23890a[exitButtonMode.ordinal()];
        if (i == 1) {
            ImageButton imageButton = this.p;
            if (imageButton != null) {
                imageButton.setVisibility(8);
            }
            ImageButton imageButton2 = this.q;
            if (imageButton2 != null) {
                imageButton2.setVisibility(8);
                return;
            }
            return;
        }
        if (i == 2) {
            ImageButton imageButton3 = this.q;
            if (imageButton3 != null) {
                imageButton3.setVisibility(8);
            }
            if (this.p == null) {
                this.p = (ImageButton) findViewById(R.id.accept_button);
            }
            this.p.setVisibility(0);
            View.OnClickListener onClickListener = this.x;
            if (onClickListener != null) {
                this.p.setOnClickListener(onClickListener);
                return;
            }
            return;
        }
        if (i != 3) {
            return;
        }
        ImageButton imageButton4 = this.p;
        if (imageButton4 != null) {
            imageButton4.setVisibility(8);
        }
        if (this.q == null) {
            this.q = (ImageButton) findViewById(R.id.cancel_button);
        }
        this.q.setVisibility(0);
        View.OnClickListener onClickListener2 = this.x;
        if (onClickListener2 != null) {
            this.q.setOnClickListener(onClickListener2);
        }
    }

    public void setHiddenMenuPopup(boolean z) {
        this.v = z;
    }

    public void setLogo(int i) {
        if (this.l == null) {
            this.l = (ImageView) findViewById(R.id.logoIcon);
        }
        if (i != 0) {
            this.l.setImageDrawable(getContext().getResources().getDrawable(i));
        }
        setLogoVisiblity(i != 0);
    }

    public void setLogoVisiblity(boolean z) {
        if (this.l == null) {
            this.l = (ImageView) findViewById(R.id.logoIcon);
        }
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void setMenuBtnVisiblity(boolean z) {
        if (this.o == null) {
            this.o = findViewById(R.id.toolbar_menu);
        }
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void setMenuItemClickListener(b.a aVar) {
        this.w = aVar;
    }

    public void setRightButton(int i) {
        if (this.r == null) {
            this.r = (IconButton) findViewById(R.id.toolbar_button);
        }
        if (i != 0) {
            this.r.setImageDrawable(getContext().getResources().getDrawable(i));
            View.OnClickListener onClickListener = this.x;
            if (onClickListener != null) {
                this.r.setOnClickListener(onClickListener);
            }
        }
        setRightButtonVisiblity(i != 0);
    }

    public void setRightButtonVisiblity(boolean z) {
        if (this.r == null) {
            this.r = (IconButton) findViewById(R.id.toolbar_button);
        }
        if (z) {
            this.r.setVisibility(0);
            View.OnClickListener onClickListener = this.x;
            if (onClickListener != null) {
                this.r.setOnClickListener(onClickListener);
                return;
            }
            return;
        }
        this.r.setVisibility(8);
    }

    public void setSelectedMenuPosition(int i) {
        this.u = i;
    }

    public void setSubTitleMode(SubTitleMode subTitleMode) {
        this.f23821b = subTitleMode;
    }

    public void setTitle(String str) {
        if (this.f23826g == null) {
            this.f23826g = (TextView) findViewById(R.id.menu_title);
        }
        if (this.f23827h == null) {
            this.f23827h = findViewById(R.id.titleHolder);
        }
        this.f23822c = str;
        this.f23826g.setText(this.f23822c);
        if (this.f23820a == TitleMode.Navigation && this.x != null) {
            this.f23826g.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
            this.f23827h.setClickable(true);
            this.f23827h.setOnClickListener(this.x);
        } else if (this.f23820a == TitleMode.Back && this.x != null) {
            this.f23826g.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
            this.n = findViewById(R.id.backIcon);
            this.n.setVisibility(0);
            this.f23827h.setClickable(true);
            this.f23827h.setOnClickListener(this.x);
        } else {
            TitleMode titleMode = this.f23820a;
            if (titleMode == TitleMode.Title) {
                View view = this.n;
                if (view != null) {
                    view.setVisibility(8);
                    this.n = null;
                }
                this.f23826g.setTextColor(getContext().getResources().getColor(R.color.km_white));
                this.f23827h.setClickable(false);
                this.f23827h.setOnClickListener(null);
            } else if (titleMode == TitleMode.Detail) {
                View view2 = this.n;
                if (view2 != null) {
                    view2.setVisibility(8);
                    this.n = null;
                }
                this.f23826g.setVisibility(4);
                this.f23827h.setClickable(true);
                this.f23827h.setOnClickListener(this.x);
                setRightButtonVisiblity(false);
            }
        }
        this.f23825f = 0;
    }

    public void setTitleMode(TitleMode titleMode) {
        this.f23820a = titleMode;
    }

    private void b() {
        SubTitleMode subTitleMode;
        int i = this.f23825f;
        if (i == 1) {
            if (this.i != null) {
                SubTitleMode subTitleMode2 = this.f23821b;
                if (subTitleMode2 == SubTitleMode.Navigation || subTitleMode2 == SubTitleMode.SelectItem) {
                    this.i.setTextColor(getContext().getResources().getColor(R.color.km_red));
                    return;
                }
                return;
            }
            return;
        }
        if (i != 2) {
            return;
        }
        if (this.k != null && ((subTitleMode = this.f23821b) == SubTitleMode.Navigation || subTitleMode == SubTitleMode.SelectItem)) {
            this.k.setTextColor(getContext().getResources().getColor(R.color.km_red));
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
        }
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.toolbar, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.nexstreaming.app.kinemasterfree.c.Toolbar, 0, 0);
            int integer = obtainStyledAttributes.getInteger(30, 0);
            TitleMode[] values = TitleMode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                TitleMode titleMode = values[i];
                if (integer == titleMode.ordinal()) {
                    setTitleMode(titleMode);
                    break;
                }
                i++;
            }
            int integer2 = obtainStyledAttributes.getInteger(20, 0);
            SubTitleMode[] values2 = SubTitleMode.values();
            int length2 = values2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                SubTitleMode subTitleMode = values2[i2];
                if (integer2 == subTitleMode.ordinal()) {
                    setSubTitleMode(subTitleMode);
                    break;
                }
                i2++;
            }
            int integer3 = obtainStyledAttributes.getInteger(11, 0);
            ExitButtonMode[] values3 = ExitButtonMode.values();
            int length3 = values3.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    break;
                }
                ExitButtonMode exitButtonMode = values3[i3];
                if (integer3 == exitButtonMode.ordinal()) {
                    setExitButtonMode(exitButtonMode);
                    break;
                }
                i3++;
            }
            int resourceId = obtainStyledAttributes.getResourceId(14, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(33, 0);
            String string = obtainStyledAttributes.getString(23);
            if (resourceId != 0) {
                setLogo(resourceId);
            }
            if (resourceId2 != 0) {
                setRightButton(resourceId2);
            }
            if (string != null) {
                setTitle(string);
            }
            obtainStyledAttributes.recycle();
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23820a = TitleMode.Title;
        this.f23821b = SubTitleMode.None;
        this.f23822c = "";
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    public void b(int i) {
        if (this.o == null) {
            this.o = findViewById(R.id.toolbar_menu);
        }
        this.t = new com.nextreaming.nexeditorui.a.a.b(getContext(), this.o);
        this.t.a(i);
        this.t.a(new s(this));
        this.t.b(this.u);
        this.o.setOnClickListener(new t(this));
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23820a = TitleMode.Title;
        this.f23821b = SubTitleMode.None;
        this.f23822c = "";
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    @TargetApi(21)
    public Toolbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f23820a = TitleMode.Title;
        this.f23821b = SubTitleMode.None;
        this.f23822c = "";
        if (isInEditMode()) {
            return;
        }
        a(attributeSet);
    }

    public void a() {
        this.f23820a = TitleMode.Back;
        setLogo(0);
    }

    public void a(String str, int i) {
        View.OnClickListener onClickListener;
        if (i != 1) {
            if (i == 2 && this.f23821b != SubTitleMode.SelectItem) {
                if (this.k == null) {
                    this.k = (TextView) findViewById(R.id.menu_subtitle2);
                }
                findViewById(R.id.menu_subtitle1_holder).setClickable(false);
                View findViewById = findViewById(R.id.menu_subtitle2_holder);
                findViewById.setVisibility(0);
                this.f23824e = str;
                this.k.setText(this.f23824e);
                if (this.f23821b == SubTitleMode.Navigation && (onClickListener = this.x) != null) {
                    findViewById.setOnClickListener(onClickListener);
                }
                this.f23825f = 2;
                b();
                return;
            }
            return;
        }
        if (this.i == null) {
            this.i = (TextView) findViewById(R.id.menu_subtitle1);
        }
        this.f23823d = str;
        this.i.setText(this.f23823d);
        View findViewById2 = findViewById(R.id.menu_subtitle1_holder);
        findViewById2.setVisibility(0);
        if (this.f23821b == SubTitleMode.Navigation && this.x != null) {
            findViewById2.setClickable(true);
            findViewById2.setOnClickListener(this.x);
        } else if (this.f23821b == SubTitleMode.SelectItem) {
            findViewById2.setClickable(false);
            this.s = findViewById(R.id.deleteIcon);
            this.s.setOnClickListener(this.x);
            this.s.setVisibility(0);
        }
        this.f23825f = 1;
        b();
    }

    public void a(Bitmap bitmap, int i) {
        if (i != 1) {
            if (i == 2 && this.f23821b != SubTitleMode.SelectItem) {
                return;
            } else {
                return;
            }
        }
        if (this.j == null) {
            this.j = (IconView) findViewById(R.id.subtitle1_img);
        }
        this.j.setVisibility(0);
        this.j.setImageBitmap(bitmap);
        View findViewById = findViewById(R.id.menu_subtitle1_holder);
        findViewById.setVisibility(0);
        if (this.f23821b == SubTitleMode.SelectItem) {
            findViewById.setClickable(false);
            this.s = findViewById(R.id.deleteIcon);
            this.s.setOnClickListener(this.x);
            this.s.setVisibility(0);
        }
        this.f23825f = 1;
    }

    public void a(int i) {
        if (i != 1) {
            if (i == 2 && this.f23821b != SubTitleMode.SelectItem) {
                this.f23824e = null;
                View findViewById = findViewById(R.id.menu_subtitle2_holder);
                findViewById.setVisibility(8);
                findViewById.setOnClickListener(null);
                this.f23825f = 1;
                b();
                return;
            }
            return;
        }
        this.f23823d = null;
        View findViewById2 = findViewById(R.id.menu_subtitle1_holder);
        findViewById2.setVisibility(8);
        IconView iconView = this.j;
        if (iconView != null && this.f23821b == SubTitleMode.SelectItem) {
            iconView.setVisibility(8);
        }
        SubTitleMode subTitleMode = this.f23821b;
        if (subTitleMode == SubTitleMode.SelectItem) {
            this.s.setVisibility(8);
            this.s.setOnClickListener(null);
        } else if (subTitleMode == SubTitleMode.Navigation && this.k != null) {
            View findViewById3 = findViewById(R.id.menu_subtitle2_holder);
            findViewById3.setVisibility(8);
            findViewById3.setOnClickListener(null);
            findViewById2.setOnClickListener(null);
            this.f23824e = null;
        }
        this.f23825f = 0;
        b();
    }
}
