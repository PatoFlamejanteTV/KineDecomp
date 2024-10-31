package com.nexstreaming.kinemaster.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
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
import com.nexstreaming.app.kinemasterfree.b;
import com.nextreaming.nexeditorui.a.a.a;

/* loaded from: classes.dex */
public class Toolbar extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private TitleMode f4379a;
    private SubTitleMode b;
    private String c;
    private String d;
    private String e;
    private int f;
    private TextView g;
    private View h;
    private TextView i;
    private IconView j;
    private TextView k;
    private ImageView l;
    private View m;
    private View n;
    private ImageButton o;
    private ImageButton p;
    private IconButton q;
    private View r;
    private com.nextreaming.nexeditorui.a.a.a s;
    private int t;
    private boolean u;
    private a.InterfaceC0083a v;
    private View.OnClickListener w;

    /* loaded from: classes.dex */
    public enum ExitButtonMode {
        None,
        Done,
        Cancel
    }

    /* loaded from: classes.dex */
    public enum SubTitleMode {
        None,
        Navigation,
        SelectItem
    }

    /* loaded from: classes.dex */
    public enum TitleMode {
        Title,
        Back,
        Navigation
    }

    public Toolbar(Context context) {
        super(context);
        this.f4379a = TitleMode.Title;
        this.b = SubTitleMode.None;
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4379a = TitleMode.Title;
        this.b = SubTitleMode.None;
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4379a = TitleMode.Title;
        this.b = SubTitleMode.None;
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    @TargetApi(21)
    public Toolbar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f4379a = TitleMode.Title;
        this.b = SubTitleMode.None;
        if (!isInEditMode()) {
            a(attributeSet);
        }
    }

    private void a(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate(R.layout.toolbar, (ViewGroup) this, true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, b.a.Toolbar, 0, 0);
            int integer = obtainStyledAttributes.getInteger(22, 0);
            TitleMode[] values = TitleMode.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                TitleMode titleMode = values[i];
                if (integer != titleMode.ordinal()) {
                    i++;
                } else {
                    setTitleMode(titleMode);
                    break;
                }
            }
            int integer2 = obtainStyledAttributes.getInteger(23, 0);
            SubTitleMode[] values2 = SubTitleMode.values();
            int length2 = values2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                SubTitleMode subTitleMode = values2[i2];
                if (integer2 != subTitleMode.ordinal()) {
                    i2++;
                } else {
                    setSubTitleMode(subTitleMode);
                    break;
                }
            }
            int integer3 = obtainStyledAttributes.getInteger(24, 0);
            ExitButtonMode[] values3 = ExitButtonMode.values();
            int length3 = values3.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    break;
                }
                ExitButtonMode exitButtonMode = values3[i3];
                if (integer3 != exitButtonMode.ordinal()) {
                    i3++;
                } else {
                    setExitButtonMode(exitButtonMode);
                    break;
                }
            }
            int resourceId = obtainStyledAttributes.getResourceId(21, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(25, 0);
            String string = obtainStyledAttributes.getString(2);
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

    public void setRightButton(int i) {
        if (this.q == null) {
            this.q = (IconButton) findViewById(R.id.toolbar_button);
        }
        if (i != 0) {
            this.q.setImageDrawable(getContext().getResources().getDrawable(i));
            if (this.w != null) {
                this.q.setOnClickListener(this.w);
            }
        }
        setRightButtonVisiblity(i != 0);
    }

    public void setTitleMode(TitleMode titleMode) {
        this.f4379a = titleMode;
    }

    public TitleMode getTitleMode() {
        return this.f4379a;
    }

    public void setSubTitleMode(SubTitleMode subTitleMode) {
        this.b = subTitleMode;
    }

    public void setTitle(String str) {
        if (this.g == null) {
            this.g = (TextView) findViewById(R.id.menu_title);
        }
        if (this.h == null) {
            this.h = findViewById(R.id.titleHolder);
        }
        this.c = str;
        this.g.setText(this.c);
        if (this.f4379a == TitleMode.Navigation && this.w != null) {
            this.g.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
            this.h.setClickable(true);
            this.h.setOnClickListener(this.w);
        } else if (this.f4379a == TitleMode.Back && this.w != null) {
            this.g.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
            this.m = findViewById(R.id.backIcon);
            this.m.setVisibility(0);
            this.h.setClickable(true);
            this.h.setOnClickListener(this.w);
        } else if (this.f4379a == TitleMode.Title) {
            if (this.m != null) {
                this.m.setVisibility(8);
                this.m = null;
            }
            this.g.setTextColor(getContext().getResources().getColor(R.color.km_white));
            this.h.setClickable(false);
            this.h.setOnClickListener(null);
        }
        this.f = 0;
    }

    public void a(String str, int i) {
        switch (i) {
            case 1:
                if (this.i == null) {
                    this.i = (TextView) findViewById(R.id.menu_subtitle1);
                }
                this.d = str;
                this.i.setText(this.d);
                View findViewById = findViewById(R.id.menu_subtitle1_holder);
                findViewById.setVisibility(0);
                if (this.b == SubTitleMode.Navigation && this.w != null) {
                    findViewById.setClickable(true);
                    findViewById.setOnClickListener(this.w);
                } else if (this.b == SubTitleMode.SelectItem) {
                    findViewById.setClickable(false);
                    this.r = findViewById(R.id.deleteIcon);
                    this.r.setOnClickListener(this.w);
                    this.r.setVisibility(0);
                }
                this.f = 1;
                b();
                return;
            case 2:
                if (this.b != SubTitleMode.SelectItem) {
                    if (this.k == null) {
                        this.k = (TextView) findViewById(R.id.menu_subtitle2);
                    }
                    View findViewById2 = findViewById(R.id.menu_subtitle2_holder);
                    findViewById2.setVisibility(0);
                    this.e = str;
                    this.k.setText(this.e);
                    if (this.b == SubTitleMode.Navigation && this.w != null) {
                        findViewById2.setOnClickListener(this.w);
                    }
                    this.f = 2;
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(Bitmap bitmap, int i) {
        switch (i) {
            case 1:
                if (this.j == null) {
                    this.j = (IconView) findViewById(R.id.subtitle1_img);
                }
                this.j.setVisibility(0);
                this.j.setImageBitmap(bitmap);
                View findViewById = findViewById(R.id.menu_subtitle1_holder);
                findViewById.setVisibility(0);
                if (this.b == SubTitleMode.SelectItem) {
                    findViewById.setClickable(false);
                    this.r = findViewById(R.id.deleteIcon);
                    this.r.setOnClickListener(this.w);
                    this.r.setVisibility(0);
                }
                this.f = 1;
                return;
            case 2:
                if (this.b == SubTitleMode.SelectItem) {
                }
                return;
            default:
                return;
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.w = onClickListener;
    }

    public void a(int i) {
        switch (i) {
            case 1:
                this.d = null;
                View findViewById = findViewById(R.id.menu_subtitle1_holder);
                findViewById.setVisibility(8);
                if (this.j != null && this.b == SubTitleMode.SelectItem) {
                    this.j.setVisibility(8);
                }
                if (this.b == SubTitleMode.SelectItem) {
                    this.r.setVisibility(8);
                    this.r.setOnClickListener(null);
                } else if (this.b == SubTitleMode.Navigation && this.k != null) {
                    View findViewById2 = findViewById(R.id.menu_subtitle2_holder);
                    findViewById2.setVisibility(8);
                    findViewById2.setOnClickListener(null);
                    findViewById.setOnClickListener(null);
                    this.e = null;
                }
                this.f = 0;
                b();
                return;
            case 2:
                if (this.b != SubTitleMode.SelectItem) {
                    this.e = null;
                    View findViewById3 = findViewById(R.id.menu_subtitle2_holder);
                    findViewById3.setVisibility(8);
                    findViewById3.setOnClickListener(null);
                    this.f = 1;
                    b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void b() {
        switch (this.f) {
            case 1:
                if (this.i != null) {
                    if (this.b == SubTitleMode.Navigation || this.b == SubTitleMode.SelectItem) {
                        this.i.setTextColor(getContext().getResources().getColor(R.color.km_red));
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (this.k != null && (this.b == SubTitleMode.Navigation || this.b == SubTitleMode.SelectItem)) {
                    this.k.setTextColor(getContext().getResources().getColor(R.color.km_red));
                }
                if (this.i != null) {
                    this.i.setTextColor(getContext().getResources().getColorStateList(R.color.text_color_white_red));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setExitButtonMode(ExitButtonMode exitButtonMode) {
        switch (exitButtonMode) {
            case None:
                if (this.o != null) {
                    this.o.setVisibility(8);
                }
                if (this.p != null) {
                    this.p.setVisibility(8);
                    return;
                }
                return;
            case Done:
                if (this.p != null) {
                    this.p.setVisibility(8);
                }
                if (this.o == null) {
                    this.o = (ImageButton) findViewById(R.id.accept_button);
                }
                this.o.setVisibility(0);
                if (this.w != null) {
                    this.o.setOnClickListener(this.w);
                    return;
                }
                return;
            case Cancel:
                if (this.o != null) {
                    this.o.setVisibility(8);
                }
                if (this.p == null) {
                    this.p = (ImageButton) findViewById(R.id.cancel_button);
                }
                this.p.setVisibility(0);
                if (this.w != null) {
                    this.p.setOnClickListener(this.w);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void b(int i) {
        if (this.n == null) {
            this.n = findViewById(R.id.toolbar_menu);
        }
        this.s = new com.nextreaming.nexeditorui.a.a.a(getContext(), this.n);
        this.s.a(i);
        this.s.a(new o(this));
        this.n.setOnClickListener(new p(this));
    }

    public void setMenuBtnVisiblity(boolean z) {
        if (this.n == null) {
            this.n = findViewById(R.id.toolbar_menu);
        }
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    public void setRightButtonVisiblity(boolean z) {
        if (this.q == null) {
            this.q = (IconButton) findViewById(R.id.toolbar_button);
        }
        if (z) {
            this.q.setVisibility(0);
            if (this.w != null) {
                this.q.setOnClickListener(this.w);
                return;
            }
            return;
        }
        this.q.setVisibility(8);
    }

    public void setMenuItemClickListener(a.InterfaceC0083a interfaceC0083a) {
        this.v = interfaceC0083a;
    }

    public void setSelectedMenuPosition(int i) {
        this.t = i;
    }

    public Menu getMenu() {
        return this.s.a();
    }

    public void setHiddenMenuPopup(boolean z) {
        this.u = z;
    }

    public void a() {
        onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.s != null) {
            this.s.c();
        }
        super.onDetachedFromWindow();
    }
}
