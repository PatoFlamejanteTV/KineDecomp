package com.nexstreaming.kinemaster.ui.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NexProgressDialog.java */
/* loaded from: classes.dex */
public class e extends com.nexstreaming.kinemaster.ui.a.a {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f3652a;
    private boolean b;
    private String c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private int h;
    private String i;
    private NumberFormat j;
    private String k;
    private String l;

    public e(Context context) {
        super(context);
        this.g = 0;
        this.h = 10000;
        super.a(R.layout.progress_dialog_view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.a.a, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3652a = (ProgressBar) findViewById(R.id.progressBar);
        this.f3652a.setIndeterminate(this.b);
        this.f3652a.setProgress(this.g);
        this.f3652a.setMax(this.h);
        this.d = (TextView) findViewById(R.id.progressMessage);
        this.e = (TextView) findViewById(R.id.progressText);
        this.f = (TextView) findViewById(R.id.detailText);
        if (this.c != null) {
            this.d.setText(this.c);
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
        if (this.l != null) {
            this.f.setText(this.l);
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        b();
    }

    @Override // com.nexstreaming.kinemaster.ui.a.a
    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.ui.a.a
    public void a(View view) {
        throw new UnsupportedOperationException();
    }

    public void h(int i) {
        if (this.f3652a == null) {
            this.g = i;
        } else {
            this.f3652a.setProgress(i);
            b();
        }
    }

    public void i(int i) {
        if (this.f3652a == null) {
            this.h = i;
        } else {
            this.f3652a.setMax(i);
            b();
        }
    }

    public int a() {
        return this.h;
    }

    public void a(boolean z) {
        if (this.f3652a == null) {
            this.b = z;
        } else {
            this.f3652a.setIndeterminate(z);
            b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.a
    public void c(int i) {
        this.c = getContext().getString(i);
        if (this.d != null) {
            if (this.c != null) {
                this.d.setText(this.c);
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.a
    public void a(String str) {
        this.c = str;
        if (this.d != null) {
            if (this.c != null) {
                this.d.setText(this.c);
                this.d.setVisibility(0);
            } else {
                this.d.setVisibility(8);
            }
        }
    }

    public void d(String str) {
        this.l = str;
        if (this.f != null) {
            if (this.l != null) {
                this.f.setText(this.l);
                this.f.setVisibility(0);
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void e(String str) {
        this.k = str;
        b();
    }

    public void b() {
        if (this.f3652a != null && this.e != null) {
            int progress = this.f3652a.getProgress();
            int max = this.f3652a.getMax();
            StringBuilder sb = new StringBuilder();
            if (this.k != null) {
                sb.append(this.k);
            }
            if (this.i != null) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(String.format(this.i, Integer.valueOf(progress), Integer.valueOf(max)));
            }
            if (this.j != null) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(this.j.format(progress / max));
            }
            if (sb.length() > 0) {
                this.e.setText(sb);
                this.e.setVisibility(0);
            } else {
                this.e.setVisibility(8);
            }
        }
    }

    /* compiled from: NexProgressDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Context f3653a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private boolean g = false;
        private boolean h = false;
        private int i = 0;
        private int j = 20;
        private int k = 20;
        private int l = -1;
        private boolean m = false;
        private boolean n = true;
        private DialogInterface.OnCancelListener o = null;
        private CompoundButton.OnCheckedChangeListener p = null;
        private Map<Integer, C0076a> q = new HashMap();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NexProgressDialog.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.a.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0076a {

            /* renamed from: a, reason: collision with root package name */
            public String f3654a;
            public DialogInterface.OnClickListener b;
            public int c;

            private C0076a() {
            }
        }

        public a(Context context) {
            if (context == null) {
                throw new NullPointerException("Null Context");
            }
            this.f3653a = context;
        }

        public a a(int i) {
            this.b = this.f3653a.getResources().getString(i);
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(int i) {
            this.e = this.f3653a.getResources().getString(i);
            return this;
        }

        public a c(int i) {
            this.f = this.f3653a.getResources().getString(i);
            return this;
        }

        public a a(boolean z) {
            this.n = z;
            return this;
        }

        public a d(int i) {
            this.c = this.f3653a.getResources().getString(i);
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            return a(-2, i, onClickListener);
        }

        public a a(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            return a(i, i2, -2, onClickListener);
        }

        public a a(int i, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            return a(i, this.f3653a.getResources().getString(i2), i3, onClickListener);
        }

        public a a(int i, String str, int i2, DialogInterface.OnClickListener onClickListener) {
            C0076a c0076a = new C0076a();
            c0076a.f3654a = str;
            c0076a.b = onClickListener;
            c0076a.c = i2;
            this.q.put(Integer.valueOf(i), c0076a);
            return this;
        }

        public e a() {
            e eVar = new e(this.f3653a);
            eVar.a(this.b);
            eVar.setCancelable(this.n);
            eVar.d(this.j);
            eVar.e(this.k);
            eVar.f(this.l);
            eVar.a(this.m);
            if (this.f != null) {
                eVar.d(this.f);
            }
            if (this.e != null) {
                eVar.e(this.e);
            }
            if (this.g) {
                eVar.a(this.d, this.h, this.p);
            }
            for (Integer num : this.q.keySet()) {
                C0076a c0076a = this.q.get(num);
                eVar.a(num.intValue(), c0076a.f3654a, c0076a.c, c0076a.b);
                if (this.c != null) {
                    eVar.setTitle(this.c);
                }
            }
            if (this.i != 0) {
                eVar.b(this.i);
            }
            eVar.setOnCancelListener(this.o);
            return eVar;
        }
    }
}
