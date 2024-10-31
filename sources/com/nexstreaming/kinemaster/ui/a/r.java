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
public class r extends e {
    private ProgressBar I;
    private boolean J;
    private String K;
    private TextView L;
    private TextView M;
    private TextView N;
    private int O;
    private int P;
    private String Q;
    private NumberFormat R;
    private String S;
    private String T;

    /* compiled from: NexProgressDialog.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private Context f21360a;

        /* renamed from: b */
        private String f21361b;

        /* renamed from: c */
        private String f21362c;

        /* renamed from: d */
        private String f21363d;

        /* renamed from: e */
        private String f21364e;

        /* renamed from: f */
        private String f21365f;

        /* renamed from: g */
        private boolean f21366g = false;

        /* renamed from: h */
        private boolean f21367h = false;
        private int i = 0;
        private int j = 20;
        private int k = 20;
        private int l = -1;
        private boolean m = false;
        private boolean n = true;
        private DialogInterface.OnCancelListener o = null;
        private CompoundButton.OnCheckedChangeListener p = null;
        private Map<Integer, C0112a> q = new HashMap();

        /* compiled from: NexProgressDialog.java */
        /* renamed from: com.nexstreaming.kinemaster.ui.a.r$a$a */
        /* loaded from: classes.dex */
        public static class C0112a {

            /* renamed from: a */
            public String f21368a;

            /* renamed from: b */
            public DialogInterface.OnClickListener f21369b;

            /* renamed from: c */
            public int f21370c;

            private C0112a() {
            }

            /* synthetic */ C0112a(q qVar) {
                this();
            }
        }

        public a(Context context) {
            if (context != null) {
                this.f21360a = context;
                return;
            }
            throw new NullPointerException("Null Context");
        }

        public a a(String str) {
            this.f21361b = str;
            return this;
        }

        public a b(int i) {
            this.f21361b = this.f21360a.getResources().getString(i);
            return this;
        }

        public a c(int i) {
            this.f21362c = this.f21360a.getResources().getString(i);
            return this;
        }

        public a a(int i) {
            this.f21365f = this.f21360a.getResources().getString(i);
            return this;
        }

        public a b(String str) {
            this.f21362c = str;
            return this;
        }

        public a a(boolean z) {
            this.n = z;
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

        public a a(int i, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
            a(i, this.f21360a.getResources().getString(i2), i3, onClickListener);
            return this;
        }

        public a a(int i, String str, int i2, DialogInterface.OnClickListener onClickListener) {
            C0112a c0112a = new C0112a();
            c0112a.f21368a = str;
            c0112a.f21369b = onClickListener;
            c0112a.f21370c = i2;
            this.q.put(Integer.valueOf(i), c0112a);
            return this;
        }

        public r a() {
            r rVar = new r(this.f21360a);
            rVar.a(this.f21361b);
            rVar.setCancelable(this.n);
            rVar.f(this.j);
            rVar.g(this.k);
            rVar.a(this.l);
            rVar.a(this.m);
            String str = this.f21365f;
            if (str != null) {
                rVar.d(str);
            }
            String str2 = this.f21364e;
            if (str2 != null) {
                rVar.e(str2);
            }
            if (this.f21366g) {
                rVar.a(this.f21363d, this.f21367h, this.p);
            }
            for (Integer num : this.q.keySet()) {
                C0112a c0112a = this.q.get(num);
                rVar.a(num.intValue(), c0112a.f21368a, c0112a.f21370c, c0112a.f21369b);
                String str3 = this.f21362c;
                if (str3 != null) {
                    rVar.setTitle(str3);
                }
            }
            int i = this.i;
            if (i != 0) {
                rVar.d(i);
            }
            rVar.setOnCancelListener(this.o);
            return rVar;
        }
    }

    public r(Context context) {
        super(context);
        this.O = 0;
        this.P = io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT;
        super.h(R.layout.progress_dialog_view);
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e
    public void a(View view) {
        throw new UnsupportedOperationException();
    }

    public void b() {
        ProgressBar progressBar = this.I;
        if (progressBar == null || this.M == null) {
            return;
        }
        int progress = progressBar.getProgress();
        int max = this.I.getMax();
        StringBuilder sb = new StringBuilder();
        String str = this.S;
        if (str != null) {
            sb.append(str);
        }
        if (this.Q != null) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(String.format(this.Q, Integer.valueOf(progress), Integer.valueOf(max)));
        }
        if (this.R != null) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            double d2 = progress;
            double d3 = max;
            Double.isNaN(d2);
            Double.isNaN(d3);
            sb.append(this.R.format(d2 / d3));
        }
        if (sb.length() > 0) {
            this.M.setText(sb);
            this.M.setVisibility(0);
        } else {
            this.M.setVisibility(8);
        }
    }

    public void d(String str) {
        this.T = str;
        TextView textView = this.N;
        if (textView != null) {
            String str2 = this.T;
            if (str2 != null) {
                textView.setText(str2);
                this.N.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e
    public void e(int i) {
        this.K = getContext().getString(i);
        TextView textView = this.L;
        if (textView != null) {
            String str = this.K;
            if (str != null) {
                textView.setText(str);
                this.L.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e
    public void h(int i) {
        throw new UnsupportedOperationException();
    }

    public void i(int i) {
        ProgressBar progressBar = this.I;
        if (progressBar == null) {
            this.P = i;
        } else {
            progressBar.setMax(i);
            b();
        }
    }

    public void j(int i) {
        ProgressBar progressBar = this.I;
        if (progressBar == null) {
            this.O = i;
        } else {
            progressBar.setProgress(i);
            b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.I = (ProgressBar) findViewById(R.id.progressBar);
        this.I.setIndeterminate(this.J);
        this.I.setProgress(this.O);
        this.I.setMax(this.P);
        this.L = (TextView) findViewById(R.id.progressMessage);
        this.M = (TextView) findViewById(R.id.progressText);
        this.N = (TextView) findViewById(R.id.detailText);
        String str = this.K;
        if (str != null) {
            this.L.setText(str);
            this.L.setVisibility(0);
        } else {
            this.L.setVisibility(8);
        }
        String str2 = this.T;
        if (str2 != null) {
            this.N.setText(str2);
            this.N.setVisibility(0);
        } else {
            this.N.setVisibility(8);
        }
        b();
    }

    public void a(boolean z) {
        ProgressBar progressBar = this.I;
        if (progressBar == null) {
            this.J = z;
        } else {
            progressBar.setIndeterminate(z);
            b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.e
    public void a(String str) {
        this.K = str;
        TextView textView = this.L;
        if (textView != null) {
            String str2 = this.K;
            if (str2 != null) {
                textView.setText(str2);
                this.L.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void e(String str) {
        this.S = str;
        b();
    }

    public void a() {
        TextView textView = this.N;
        if (textView != null) {
            textView.setTextSize(getContext().getResources().getDimensionPixelSize(R.dimen.detail_log_text_size));
            this.N.setGravity(3);
            this.N.setHorizontallyScrolling(true);
        }
    }
}
