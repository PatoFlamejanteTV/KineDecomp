package com.nexstreaming.kinemaster.ui.a;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class e extends Dialog {
    private int A;
    private ViewGroup.LayoutParams B;
    private int C;
    private String D;
    private boolean E;
    private boolean F;
    private View.OnClickListener G;
    private View.OnLongClickListener H;

    /* renamed from: a */
    private String f21309a;

    /* renamed from: b */
    private String f21310b;

    /* renamed from: c */
    private String f21311c;

    /* renamed from: d */
    private boolean f21312d;

    /* renamed from: e */
    private TextView f21313e;

    /* renamed from: f */
    private TextView f21314f;

    /* renamed from: g */
    private TextView f21315g;

    /* renamed from: h */
    private TextView f21316h;
    private LinearLayout i;
    private SparseArray<b> j;
    private boolean k;
    private ImageView l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private CheckBox t;
    private String u;
    private boolean v;
    private CompoundButton.OnCheckedChangeListener w;
    private View x;
    private FrameLayout y;
    private View z;

    /* compiled from: NexDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private Context f21317a;

        /* renamed from: b */
        private String f21318b;

        /* renamed from: c */
        private String f21319c;

        /* renamed from: d */
        private String f21320d;

        /* renamed from: e */
        private String f21321e;

        /* renamed from: f */
        private String f21322f;
        private View r;

        /* renamed from: g */
        private boolean f21323g = false;

        /* renamed from: h */
        private boolean f21324h = false;
        private boolean i = false;
        private boolean j = false;
        private int k = 0;
        private int l = 14;
        private int m = 20;
        private int n = -1;
        private int o = 0;
        private int p = 0;
        private int q = 0;
        private boolean s = true;
        private DialogInterface.OnCancelListener t = null;
        private DialogInterface.OnDismissListener u = null;
        private CompoundButton.OnCheckedChangeListener v = null;
        private SparseArray<C0111a> w = new SparseArray<>();

        /* compiled from: NexDialog.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.a.e$a$a */
        /* loaded from: classes.dex */
        public static class C0111a {

            /* renamed from: a */
            public String f21325a;

            /* renamed from: b */
            public DialogInterface.OnClickListener f21326b;

            /* renamed from: c */
            public int f21327c;

            /* renamed from: d */
            public final int f21328d;

            /* synthetic */ C0111a(int i, com.nexstreaming.kinemaster.ui.a.a aVar) {
                this(i);
            }

            private C0111a(int i) {
                this.f21328d = i;
            }
        }

        public a(Context context) {
            if (context != null) {
                this.f21317a = context;
                return;
            }
            throw new NullPointerException("Null Context");
        }

        public a a(String str) {
            this.f21318b = str;
            return this;
        }

        public a b(String str) {
            this.f21319c = str;
            return this;
        }

        public a c(int i) {
            this.f21318b = this.f21317a.getResources().getString(i);
            return this;
        }

        public a d(String str) {
            this.f21320d = str;
            return this;
        }

        public a e(int i) {
            this.f21321e = this.f21317a.getResources().getString(i);
            return this;
        }

        public a f(int i) {
            this.m = i;
            return this;
        }

        public a g(int i) {
            this.o = i;
            this.r = null;
            return this;
        }

        public a a(boolean z) {
            this.s = z;
            return this;
        }

        public a b(boolean z) {
            this.f21323g = z;
            return this;
        }

        public a c(String str) {
            this.f21321e = str;
            return this;
        }

        public a d(int i) {
            this.l = i;
            return this;
        }

        public a a(int i) {
            this.n = i;
            return this;
        }

        public a b(int i) {
            this.q = i;
            return this;
        }

        public a c(int i, DialogInterface.OnClickListener onClickListener) {
            a(-1, i, onClickListener);
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.t = onCancelListener;
            return this;
        }

        public a b(String str, DialogInterface.OnClickListener onClickListener) {
            a(-1, str, onClickListener);
            return this;
        }

        public a a(DialogInterface.OnDismissListener onDismissListener) {
            this.u = onDismissListener;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            a(-3, i, onClickListener);
            return this;
        }

        public a a(String str, DialogInterface.OnClickListener onClickListener) {
            a(-2, str, onClickListener);
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            a(-2, i, onClickListener);
            return this;
        }

        public a a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            a(i, i2, -2, onClickListener);
            return this;
        }

        public a a(int i, String str, DialogInterface.OnClickListener onClickListener) {
            a(i, str, -2, onClickListener);
            return this;
        }

        public a a(int i, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            a(i, this.f21317a.getResources().getString(i2), i3, onClickListener);
            return this;
        }

        @Deprecated
        public a a(int i, String str, int i2, DialogInterface.OnClickListener onClickListener) {
            C0111a c0111a = new C0111a(i, null);
            c0111a.f21325a = str;
            c0111a.f21326b = onClickListener;
            c0111a.f21327c = i2;
            this.w.put(i, c0111a);
            return this;
        }

        public e a() {
            e eVar = new e(this.f21317a);
            eVar.a(this.f21318b);
            eVar.b(this.f21319c);
            eVar.c(this.f21320d);
            eVar.setCancelable(this.s);
            eVar.a(this.j);
            eVar.f(this.l);
            eVar.g(this.m);
            eVar.a(this.n);
            eVar.b(this.p);
            eVar.c(this.q);
            eVar.b(this.f21323g);
            if (this.f21324h) {
                eVar.a(this.f21322f, this.i, this.v);
            }
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                C0111a valueAt = this.w.valueAt(i);
                eVar.a(valueAt.f21328d, valueAt.f21325a, valueAt.f21326b);
            }
            String str = this.f21321e;
            if (str != null) {
                eVar.setTitle(str);
            }
            int i2 = this.k;
            if (i2 != 0) {
                eVar.d(i2);
            }
            int i3 = this.o;
            if (i3 != 0) {
                eVar.h(i3);
            } else {
                View view = this.r;
                if (view != null) {
                    eVar.a(view);
                }
            }
            eVar.setOnCancelListener(this.t);
            eVar.setOnDismissListener(this.u);
            return eVar;
        }
    }

    /* compiled from: NexDialog.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a */
        public final int f21329a;

        /* renamed from: b */
        public String f21330b;

        /* renamed from: c */
        public DialogInterface.OnClickListener f21331c;

        /* synthetic */ b(int i, com.nexstreaming.kinemaster.ui.a.a aVar) {
            this(i);
        }

        private b(int i) {
            this.f21329a = i;
        }
    }

    /* compiled from: NexDialog.java */
    /* loaded from: classes.dex */
    public interface c extends DialogInterface.OnClickListener {
        boolean a(DialogInterface dialogInterface, int i);
    }

    public e(Context context) {
        super(context, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        this.j = new SparseArray<>();
        this.k = true;
        this.m = 0;
        this.n = 14;
        this.o = 20;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.w = null;
        this.A = -100;
        this.B = null;
        this.F = true;
        this.G = new com.nexstreaming.kinemaster.ui.a.b(this);
        this.H = new com.nexstreaming.kinemaster.ui.a.c(this);
    }

    public void c(String str, DialogInterface.OnClickListener onClickListener) {
        a(-1, str, onClickListener);
    }

    public void d(int i) {
        this.m = i;
        ImageView imageView = this.l;
        if (imageView != null) {
            int i2 = this.m;
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setImageResource(i2);
                this.l.setVisibility(0);
            }
        }
    }

    public void e(int i) {
        this.f21309a = getContext().getString(i);
        TextView textView = this.f21313e;
        if (textView != null) {
            String str = this.f21309a;
            if (str != null) {
                textView.setText(str);
                this.f21313e.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void f(int i) {
        this.n = i;
        TextView textView = this.f21313e;
        if (textView != null) {
            textView.setTextSize(1, this.n);
        }
    }

    public void g(int i) {
        this.o = i;
        TextView textView = this.f21316h;
        if (textView != null) {
            textView.setTextSize(1, this.o);
        }
    }

    public void h(int i) {
        this.C = i;
        FrameLayout frameLayout = this.y;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f21313e = null;
            this.f21314f = null;
            LayoutInflater.from(getContext()).inflate(this.C, (ViewGroup) this.y, true);
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.k) {
            cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0194  */
    @Override // android.app.Dialog
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.a.e.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        this.k = z;
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a(charSequence, true);
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
        } catch (Exception e2) {
            Log.e("NexDialog", e2.getMessage(), e2);
        }
    }

    public void b(boolean z) {
        this.E = z;
        TextView textView = this.f21314f;
        if (textView != null) {
            if (this.E) {
                textView.setTextSize(1, 8.0f);
                this.f21314f.setGravity(3);
                this.f21314f.setAlpha(0.5f);
                a(this.f21314f, com.nexstreaming.app.kinemasterfree.R.dimen.dialog_tinymessage_top);
                return;
            }
            textView.setTextSize(getContext().getResources().getDimension(com.nexstreaming.app.kinemasterfree.R.dimen.dialog_sub_message_text));
            this.f21314f.setGravity(17);
            this.f21314f.setAlpha(1.0f);
            a(this.f21314f, 0);
        }
    }

    public void c(int i) {
        this.r = i;
        if (findViewById(com.nexstreaming.app.kinemasterfree.R.id.dialog_holder) != null) {
            findViewById(com.nexstreaming.app.kinemasterfree.R.id.dialog_holder).setMinimumWidth(this.r);
        }
    }

    public static a a(Context context) {
        a aVar = new a(context);
        aVar.c(com.nexstreaming.app.kinemasterfree.R.string.button_ok, new com.nexstreaming.kinemaster.ui.a.a());
        return aVar;
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        this.f21311c = getContext().getString(i);
        TextView textView = this.f21316h;
        if (textView != null) {
            String str = this.f21311c;
            if (str != null) {
                textView.setText(str);
                this.f21316h.setTextSize(1, this.o);
                this.f21316h.setVisibility(0);
                this.x.setVisibility(8);
                return;
            }
            textView.setVisibility(8);
            this.x.setVisibility(0);
        }
    }

    public void a(String str, DialogInterface.OnClickListener onClickListener) {
        a(-2, str, onClickListener);
    }

    public void c(String str) {
        this.D = str;
        TextView textView = this.f21315g;
        if (textView != null) {
            if (this.D != null) {
                a(this.f21313e.getPaddingLeft(), this.f21313e.getPaddingTop(), this.f21313e.getPaddingRight(), 0);
                this.f21315g.setText(this.D);
                this.f21315g.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    @Deprecated
    public void a(int i, String str, int i2, DialogInterface.OnClickListener onClickListener) {
        a(i, str, onClickListener);
    }

    public void a(int i, String str, DialogInterface.OnClickListener onClickListener) {
        b bVar = this.j.get(i);
        if (bVar == null) {
            bVar = new b(i, null);
            this.j.put(i, bVar);
        }
        bVar.f21330b = str;
        bVar.f21331c = onClickListener;
        a();
    }

    public void a(View view) {
        a(view, -100);
    }

    public void b(String str, DialogInterface.OnClickListener onClickListener) {
        a(-3, str, onClickListener);
    }

    public void a(View view, int i) {
        a(view, new ViewGroup.LayoutParams(-1, -1), i);
    }

    public void b(int i) {
        this.q = i;
        if (findViewById(com.nexstreaming.app.kinemasterfree.R.id.dialog_holder) != null) {
            findViewById(com.nexstreaming.app.kinemasterfree.R.id.dialog_holder).setMinimumHeight(this.q);
        }
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams, int i) {
        this.z = view;
        this.B = layoutParams;
        this.A = i;
        FrameLayout frameLayout = this.y;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.y.addView(this.z, layoutParams);
            if (i != -100) {
                this.y.setBackgroundResource(i);
            }
            this.f21313e = null;
            this.f21314f = null;
        }
    }

    public e(Context context, int i) {
        super(context, i);
        this.j = new SparseArray<>();
        this.k = true;
        this.m = 0;
        this.n = 14;
        this.o = 20;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.w = null;
        this.A = -100;
        this.B = null;
        this.F = true;
        this.G = new com.nexstreaming.kinemaster.ui.a.b(this);
        this.H = new com.nexstreaming.kinemaster.ui.a.c(this);
    }

    public void b(String str) {
        this.f21310b = str;
        TextView textView = this.f21314f;
        if (textView != null) {
            if (this.f21310b != null) {
                a(this.f21313e.getPaddingLeft(), this.f21313e.getPaddingTop(), this.f21313e.getPaddingRight(), 0);
                this.f21314f.setText(this.f21310b);
                this.f21314f.setVisibility(0);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public void a(int i, String str) {
        b bVar = this.j.get(i);
        if (bVar == null) {
            return;
        }
        bVar.f21330b = str;
        a();
    }

    public void a(CharSequence charSequence, boolean z) {
        this.f21311c = charSequence != null ? charSequence.toString() : null;
        this.F = z;
        TextView textView = this.f21316h;
        if (textView != null) {
            String str = this.f21311c;
            if (str != null) {
                textView.setText(str);
                this.f21316h.setTextSize(1, this.o);
                this.f21316h.setVisibility(0);
                this.x.setVisibility(8);
                return;
            }
            textView.setVisibility(8);
            this.x.setVisibility(this.F ? 0 : 8);
        }
    }

    public void a(String str, boolean z, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.s = str != null;
        this.u = str;
        this.v = z;
        this.w = onCheckedChangeListener;
    }

    public void a(int i) {
        this.p = i;
        a();
    }

    private void a(ViewGroup viewGroup, int i) {
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            viewGroup.getChildAt(i2).setVisibility(i);
        }
    }

    private void a() {
        int i;
        a((ViewGroup) this.i, 8);
        int size = this.j.size();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            if (size < 1) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setBackgroundResource(com.nexstreaming.app.kinemasterfree.R.drawable.dialog_bg_bottom);
                this.i.setVisibility(0);
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b valueAt = this.j.valueAt(i3);
            if (size == 1) {
                i = com.nexstreaming.app.kinemasterfree.R.id.dialog_only_button;
            } else if (i3 == 0) {
                i = com.nexstreaming.app.kinemasterfree.R.id.dialog_left_button;
            } else if (i3 == size - 1) {
                i = com.nexstreaming.app.kinemasterfree.R.id.dialog_right_button;
            } else {
                i2++;
                if (i2 == 1) {
                    i = com.nexstreaming.app.kinemasterfree.R.id.dialog_mid_button_1;
                } else if (i2 == 2) {
                    i = com.nexstreaming.app.kinemasterfree.R.id.dialog_mid_button_2;
                } else if (i2 == 3) {
                    i = com.nexstreaming.app.kinemasterfree.R.id.dialog_mid_button_3;
                } else if (i2 == 4) {
                    i = com.nexstreaming.app.kinemasterfree.R.id.dialog_mid_button_4;
                } else {
                    if (i2 != 5) {
                        throw new IllegalStateException("Too many buttons");
                    }
                    i = com.nexstreaming.app.kinemasterfree.R.id.dialog_mid_button_5;
                }
            }
            Button button = (Button) findViewById(i);
            if (button != null) {
                button.setVisibility(0);
                button.setText(valueAt.f21330b);
                button.setTag(valueAt);
                if (valueAt.f21331c instanceof c) {
                    button.setOnLongClickListener(this.H);
                }
                button.setOnClickListener(this.G);
            }
        }
    }

    public void a(String str) {
        this.f21309a = str;
        TextView textView = this.f21313e;
        if (textView != null) {
            String str2 = this.f21309a;
            if (str2 != null) {
                textView.setText(str2);
                this.f21313e.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void a(boolean z) {
        this.f21312d = z;
    }

    private void a(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        textView.setPadding(textView.getPaddingLeft(), i != 0 ? getContext().getResources().getDimensionPixelOffset(i) : 0, textView.getPaddingRight(), textView.getPaddingBottom());
    }

    public void a(int i, int i2, int i3, int i4) {
        TextView textView = this.f21313e;
        if (textView != null) {
            textView.setPadding(i, i2, i3, i4);
        }
    }
}
