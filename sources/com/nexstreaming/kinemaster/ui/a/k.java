package com.nexstreaming.kinemaster.ui.a;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.kinemasterfree.R;

/* compiled from: NexDialogFragment.java */
/* loaded from: classes.dex */
public class k extends DialogFragment implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    private k f21343a;

    /* renamed from: b */
    private b f21344b;

    /* renamed from: c */
    private Bundle f21345c = null;

    /* renamed from: d */
    private Button f21346d = null;

    /* compiled from: NexDialogFragment.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        private Context f21347a;

        /* renamed from: b */
        private Bundle f21348b = new Bundle();

        /* renamed from: c */
        private b f21349c;

        public a(Context context) {
            if (context != null) {
                this.f21347a = context;
                return;
            }
            throw new NullPointerException("Null Context");
        }

        public a a(int i) {
            this.f21348b.putString("Message", this.f21347a.getResources().getString(i));
            return this;
        }

        public a b(int i) {
            this.f21348b.putString("Title", this.f21347a.getResources().getString(i));
            return this;
        }

        public a a(int i, String str) {
            if (!this.f21348b.containsKey("MessageLinks")) {
                this.f21348b.putBundle("MessageLinks", new Bundle());
            }
            this.f21348b.getBundle("MessageLinks").putString(this.f21347a.getResources().getString(i), str);
            return this;
        }

        public a a(b bVar) {
            this.f21349c = bVar;
            return this;
        }

        public k a() {
            k kVar = new k();
            kVar.setArguments(this.f21348b);
            b bVar = this.f21349c;
            if (bVar != null) {
                kVar.a(bVar);
            }
            return kVar;
        }
    }

    /* compiled from: NexDialogFragment.java */
    /* loaded from: classes.dex */
    public interface b {
        void onDialogCanceled(DialogInterface dialogInterface, DialogFragment dialogFragment);

        void onDialogOk(DialogInterface dialogInterface, DialogFragment dialogFragment);
    }

    private void c(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        Bundle bundle = this.f21345c;
        if (bundle == null || !bundle.containsKey("Title")) {
            return;
        }
        textView.setText(this.f21345c.getString("Title"));
        if (this.f21345c.containsKey("TitleLinks")) {
            Bundle bundle2 = this.f21345c.getBundle("TitleLinks");
            for (String str : bundle2.keySet()) {
                J.a(textView, str, bundle2.getString(str));
            }
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f21345c = getArguments();
        this.f21343a = this;
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = View.inflate(getActivity(), R.layout.dialog_fragment, null);
        e eVar = new e(getActivity());
        eVar.setOnKeyListener(new f(this));
        eVar.a((CharSequence) null, false);
        eVar.a(inflate, R.drawable.bg_gdpr_dialog);
        eVar.c(getResources().getDimensionPixelOffset(R.dimen.gdpr_popup_width));
        inflate.findViewById(R.id.scroll).setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dialog_fragment_width), getResources().getDimensionPixelOffset(R.dimen.dialog_fragment_scrollview_height)));
        c(inflate);
        b(inflate);
        a(inflate);
        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.scroll);
        nestedScrollView.post(new g(this, nestedScrollView));
        this.f21346d = (Button) inflate.findViewById(R.id.ok_button);
        this.f21346d.setOnClickListener(new h(this, eVar));
        Button button = this.f21346d;
        button.addTextChangedListener(a(button, 8, (int) a(button.getTextSize())));
        this.f21346d.getViewTreeObserver().addOnGlobalLayoutListener(this);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new i(this, eVar));
        return eVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Button button = this.f21346d;
        if (button != null) {
            button.setText(button.getText());
        }
    }

    private TextWatcher a(TextView textView, int i, int i2) {
        return new j(this, textView, i2, i);
    }

    public float b(float f2) {
        return f2 * getResources().getDisplayMetrics().scaledDensity;
    }

    public float a(float f2) {
        return f2 / getResources().getDisplayMetrics().scaledDensity;
    }

    private void b(View view) {
        TextView textView = (TextView) view.findViewById(R.id.content);
        Bundle bundle = this.f21345c;
        if (bundle == null || !bundle.containsKey("Message")) {
            return;
        }
        textView.setText(this.f21345c.getString("Message"));
        if (this.f21345c.containsKey("MessageLinks")) {
            Bundle bundle2 = this.f21345c.getBundle("MessageLinks");
            for (String str : bundle2.keySet()) {
                J.a(textView, str, bundle2.getString(str));
            }
        }
    }

    private void a(View view) {
        Bundle bundle = this.f21345c;
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("Positive")) {
            ((TextView) view.findViewById(R.id.ok_button)).setText(this.f21345c.getString("Positive"));
        }
        if (this.f21345c.containsKey("Negative")) {
            ((TextView) view.findViewById(R.id.cancel_button)).setText(this.f21345c.getString("Negative"));
        }
    }

    public void a(b bVar) {
        this.f21344b = bVar;
    }

    public static a a(Context context) {
        return new a(context);
    }
}
