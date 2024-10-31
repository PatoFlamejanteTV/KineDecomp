package com.nexstreaming.kinemaster.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
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
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NexDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {
    private String A;
    private boolean B;
    private View.OnClickListener C;

    /* renamed from: a, reason: collision with root package name */
    private String f3646a;
    private String b;
    private String c;
    private boolean d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private LinearLayout i;
    private SparseArray<b> j;
    private boolean k;
    private ImageView l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private CheckBox s;
    private String t;
    private boolean u;
    private CompoundButton.OnCheckedChangeListener v;
    private View w;
    private FrameLayout x;
    private View y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NexDialog.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f3649a;
        public String b;
        public DialogInterface.OnClickListener c;
        public boolean d;

        /* synthetic */ b(int i, com.nexstreaming.kinemaster.ui.a.b bVar) {
            this(i);
        }

        private b(int i) {
            this.f3649a = i;
        }
    }

    public static C0074a a(Context context) {
        return new C0074a(context).a(R.string.button_ok, new com.nexstreaming.kinemaster.ui.a.b());
    }

    /* compiled from: NexDialog.java */
    /* renamed from: com.nexstreaming.kinemaster.ui.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a {

        /* renamed from: a, reason: collision with root package name */
        private Context f3647a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private View q;
        private boolean g = false;
        private boolean h = false;
        private boolean i = false;
        private boolean j = false;
        private int k = 0;
        private int l = 14;
        private int m = 20;
        private int n = -1;
        private int o = 0;
        private int p = 0;
        private boolean r = true;
        private DialogInterface.OnCancelListener s = null;
        private CompoundButton.OnCheckedChangeListener t = null;
        private SparseArray<C0075a> u = new SparseArray<>();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NexDialog.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0075a {

            /* renamed from: a, reason: collision with root package name */
            public String f3648a;
            public DialogInterface.OnClickListener b;
            public int c;
            public final int d;

            /* synthetic */ C0075a(int i, com.nexstreaming.kinemaster.ui.a.b bVar) {
                this(i);
            }

            private C0075a(int i) {
                this.d = i;
            }
        }

        public C0074a(Context context) {
            if (context == null) {
                throw new NullPointerException("Null Context");
            }
            this.f3647a = context;
        }

        public C0074a a(int i) {
            this.b = this.f3647a.getResources().getString(i);
            return this;
        }

        public C0074a a(String str) {
            this.b = str;
            return this;
        }

        public C0074a b(String str) {
            this.c = str;
            return this;
        }

        public C0074a c(String str) {
            this.d = str;
            return this;
        }

        public C0074a b(int i) {
            this.o = i;
            this.q = null;
            return this;
        }

        public C0074a a(boolean z) {
            this.r = z;
            return this;
        }

        public C0074a c(int i) {
            this.l = i;
            return this;
        }

        public C0074a d(int i) {
            this.m = i;
            return this;
        }

        public C0074a e(int i) {
            this.n = i;
            return this;
        }

        public C0074a f(int i) {
            this.e = this.f3647a.getResources().getString(i);
            return this;
        }

        public C0074a d(String str) {
            this.e = str;
            return this;
        }

        public C0074a a(DialogInterface.OnCancelListener onCancelListener) {
            this.s = onCancelListener;
            return this;
        }

        public C0074a g(int i) {
            this.p = i;
            return this;
        }

        public C0074a a(String str, DialogInterface.OnClickListener onClickListener) {
            return a(-1, str, onClickListener);
        }

        public C0074a b(String str, DialogInterface.OnClickListener onClickListener) {
            return a(-2, str, onClickListener);
        }

        public C0074a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(-1, i, onClickListener);
        }

        public C0074a b(int i, DialogInterface.OnClickListener onClickListener) {
            return a(-2, i, onClickListener);
        }

        public C0074a c(int i, DialogInterface.OnClickListener onClickListener) {
            return a(-3, i, onClickListener);
        }

        public C0074a a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            return a(i, i2, -2, onClickListener);
        }

        public C0074a a(int i, String str, DialogInterface.OnClickListener onClickListener) {
            return a(i, str, -2, onClickListener);
        }

        public C0074a a(int i, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            return a(i, this.f3647a.getResources().getString(i2), i3, onClickListener);
        }

        @Deprecated
        public C0074a a(int i, String str, int i2, DialogInterface.OnClickListener onClickListener) {
            C0075a c0075a = new C0075a(i, null);
            c0075a.f3648a = str;
            c0075a.b = onClickListener;
            c0075a.c = i2;
            this.u.put(i, c0075a);
            return this;
        }

        public a a() {
            a aVar = new a(this.f3647a);
            aVar.a(this.b);
            aVar.b(this.c);
            aVar.c(this.d);
            aVar.setCancelable(this.r);
            aVar.b(this.j);
            aVar.d(this.l);
            aVar.e(this.m);
            aVar.f(this.n);
            aVar.g(this.p);
            aVar.a(this.g);
            if (this.h) {
                aVar.a(this.f, this.i, this.t);
            }
            int size = this.u.size();
            for (int i = 0; i < size; i++) {
                C0075a valueAt = this.u.valueAt(i);
                aVar.a(valueAt.d, valueAt.f3648a, valueAt.b);
            }
            if (this.e != null) {
                aVar.setTitle(this.e);
            }
            if (this.k != 0) {
                aVar.b(this.k);
            }
            if (this.o != 0) {
                aVar.a(this.o);
            } else if (this.q != null) {
                aVar.a(this.q);
            }
            aVar.setOnCancelListener(this.s);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.B = z;
        if (this.f != null) {
            if (this.B) {
                this.f.setTextSize(1, 8.0f);
                this.f.setGravity(3);
                this.f.setAlpha(0.5f);
                a(this.f, R.dimen.dialog_tinymessage_top);
                return;
            }
            this.f.setTextSize(getContext().getResources().getDimension(R.dimen.dialog_sub_message_text));
            this.f.setGravity(17);
            this.f.setAlpha(1.0f);
            a(this.f, 0);
        }
    }

    public a(Context context) {
        super(context, android.R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        this.j = new SparseArray<>();
        this.k = true;
        this.m = 0;
        this.n = 14;
        this.o = 20;
        this.p = -1;
        this.q = 0;
        this.r = false;
        this.v = null;
        this.C = new c(this);
    }

    public void a(String str, DialogInterface.OnClickListener onClickListener) {
        a(-1, str, onClickListener);
    }

    public void b(String str, DialogInterface.OnClickListener onClickListener) {
        a(-2, str, onClickListener);
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
        bVar.b = str;
        bVar.c = onClickListener;
        a();
    }

    public void a(View view) {
        this.y = view;
        if (this.x != null) {
            this.x.removeAllViews();
            this.x.addView(this.y, -1, -1);
            this.e = null;
            this.f = null;
        }
    }

    public void a(int i) {
        this.z = i;
        if (this.x != null) {
            this.x.removeAllViews();
            this.e = null;
            this.f = null;
            LayoutInflater.from(getContext()).inflate(this.z, (ViewGroup) this.x, true);
        }
    }

    public void a(int i, boolean z) {
        b bVar = this.j.get(i);
        if (bVar != null) {
            bVar.d = !z;
            a();
        }
    }

    public void b(int i) {
        this.m = i;
        if (this.l != null) {
            if (this.m == 0) {
                this.l.setVisibility(8);
            } else {
                this.l.setImageResource(this.m);
                this.l.setVisibility(0);
            }
        }
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.c = charSequence.toString();
        if (this.h != null) {
            if (this.c != null) {
                this.h.setText(this.c);
                this.h.setTextSize(1, this.o);
                this.h.setVisibility(0);
                this.w.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
            this.w.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        this.c = getContext().getString(i);
        if (this.h != null) {
            if (this.c != null) {
                this.h.setText(this.c);
                this.h.setTextSize(1, this.o);
                this.h.setVisibility(0);
                this.w.setVisibility(8);
                return;
            }
            this.h.setVisibility(8);
            this.w.setVisibility(0);
        }
    }

    public void a(String str, boolean z, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.r = str != null;
        this.t = str;
        this.u = z;
        this.v = onCheckedChangeListener;
    }

    public void c(int i) {
        this.f3646a = getContext().getString(i);
        if (this.e != null) {
            if (this.f3646a != null) {
                this.e.setText(this.f3646a);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    public void d(int i) {
        this.n = i;
        if (this.e != null) {
            this.e.setTextSize(1, this.n);
        }
    }

    public void e(int i) {
        this.o = i;
        if (this.h != null) {
            this.h.setTextSize(1, this.o);
        }
    }

    public void f(int i) {
        this.p = i;
        a();
    }

    public void g(int i) {
        this.q = i;
        if (findViewById(R.id.dialog_holder) != null) {
            findViewById(R.id.dialog_holder).setMinimumHeight(this.q);
        }
    }

    private void a(ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                viewGroup.getChildAt(i2).setVisibility(i);
            }
        }
    }

    private void a() {
        int i;
        a(this.i, 8);
        int size = this.j.size();
        if (this.i != null) {
            if (size < 1) {
                this.i.setBackgroundResource(R.drawable.dialog_button_bg_only);
            } else {
                this.i.setBackgroundResource(R.drawable.dialog_bg_bottom);
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b valueAt = this.j.valueAt(i3);
            if (size == 1) {
                i = R.id.dialog_only_button;
            } else if (i3 == 0) {
                i = R.id.dialog_left_button;
            } else if (i3 == size - 1) {
                i = R.id.dialog_right_button;
            } else {
                i2++;
                switch (i2) {
                    case 1:
                        i = R.id.dialog_mid_button_1;
                        break;
                    case 2:
                        i = R.id.dialog_mid_button_2;
                        break;
                    case 3:
                        i = R.id.dialog_mid_button_3;
                        break;
                    case 4:
                        i = R.id.dialog_mid_button_4;
                        break;
                    case 5:
                        i = R.id.dialog_mid_button_5;
                        break;
                    default:
                        throw new IllegalStateException("Too many buttons");
                }
            }
            Button button = (Button) findViewById(i);
            if (button != null) {
                button.setVisibility(0);
                button.setText(valueAt.b);
                button.setTag(valueAt);
                button.setOnClickListener(this.C);
            }
        }
    }

    public void a(String str) {
        this.f3646a = str;
        if (this.e != null) {
            if (this.f3646a != null) {
                this.e.setText(this.f3646a);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    public void b(String str) {
        this.b = str;
        if (this.f != null) {
            if (this.b != null) {
                a(this.e.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), 0);
                this.f.setText(this.b);
                this.f.setVisibility(0);
                return;
            }
            this.f.setVisibility(8);
        }
    }

    public void c(String str) {
        this.A = str;
        if (this.g != null) {
            if (this.A != null) {
                a(this.e.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), 0);
                this.g.setText(this.A);
                this.g.setVisibility(0);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        this.d = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView(R.layout.nex_dialog);
        this.h = (TextView) findViewById(R.id.title);
        this.w = findViewById(R.id.no_title_placeholder);
        this.e = (TextView) findViewById(R.id.message);
        this.f = (TextView) findViewById(R.id.subMessage);
        this.g = (TextView) findViewById(R.id.warningMessage);
        this.s = null;
        this.i = (LinearLayout) findViewById(R.id.dialogButtons);
        this.x = (FrameLayout) findViewById(R.id.dialogContent);
        View findViewById = findViewById(R.id.dialog_holder);
        if (this.y != null) {
            this.x.removeAllViews();
            this.x.addView(this.y, -1, -1);
            this.e = null;
            this.f = null;
            this.g = null;
            z = true;
        } else if (this.z != 0) {
            this.x.removeAllViews();
            this.e = null;
            this.f = null;
            this.g = null;
            LayoutInflater.from(getContext()).inflate(this.z, (ViewGroup) this.x, true);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ViewGroup.LayoutParams layoutParams = this.x.getLayoutParams();
            layoutParams.width = -2;
            this.x.setLayoutParams(layoutParams);
        }
        if (this.e != null) {
            if (this.f3646a != null) {
                this.e.setText(this.f3646a);
                this.e.setVisibility(0);
                this.e.setTextSize(1, this.n);
            } else {
                this.e.setVisibility(8);
            }
        }
        if (this.f != null) {
            if (this.B) {
                this.f.setTextSize(1, 8.0f);
                this.f.setGravity(3);
                this.f.setAlpha(0.5f);
                a(this.f, R.dimen.dialog_tinymessage_top);
            }
            if (this.b != null) {
                a(this.e.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), 0);
                this.f.setText(this.b);
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        }
        if (this.g != null) {
            if (this.A != null) {
                a(this.e.getPaddingLeft(), this.e.getPaddingTop(), this.e.getPaddingRight(), 0);
                this.g.setText(this.A);
                this.g.setVisibility(0);
            } else {
                this.g.setVisibility(8);
            }
        }
        if (this.c != null) {
            this.h.setText(this.c);
            this.h.setTextSize(1, this.o);
            this.w.setVisibility(8);
        } else {
            this.h.setVisibility(8);
            this.w.setVisibility(0);
        }
        if (this.r && this.s != null) {
            this.s.setVisibility(0);
            this.s.setChecked(this.u);
            this.s.setOnCheckedChangeListener(new d(this));
        }
        if (this.q > 0) {
            findViewById.setMinimumHeight(this.q);
        }
        a();
        getWindow().setLayout(-2, -2);
    }

    private void a(TextView textView, int i) {
        if (textView != null) {
            int i2 = 0;
            if (i != 0) {
                i2 = getContext().getResources().getDimensionPixelOffset(i);
            }
            textView.setPadding(textView.getPaddingLeft(), i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (this.e != null) {
            this.e.setPadding(i, i2, i3, i4);
        }
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        this.k = z;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.k) {
            cancel();
        }
    }
}
