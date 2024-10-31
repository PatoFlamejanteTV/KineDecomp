package com.nexstreaming.kinemaster.ui.a;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.HashMap;
import kotlin.TypeCastException;

/* compiled from: NexFullScreenDialog.kt */
/* loaded from: classes.dex */
public final class m extends DialogFragment implements p {

    /* renamed from: c */
    private l f21352c;

    /* renamed from: d */
    private TextView f21353d;

    /* renamed from: e */
    private TextView f21354e;

    /* renamed from: f */
    private ProgressBar f21355f;

    /* renamed from: g */
    private Button f21356g;

    /* renamed from: h */
    private Button f21357h;
    private HashMap i;

    /* renamed from: b */
    public static final a f21351b = new a(null);

    /* renamed from: a */
    private static final String f21350a = f21350a;

    /* renamed from: a */
    private static final String f21350a = f21350a;

    /* compiled from: NexFullScreenDialog.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public final m a(Bundle bundle) {
            kotlin.jvm.internal.h.b(bundle, "bundle");
            m mVar = new m();
            mVar.setArguments(bundle);
            return mVar;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public final l A() {
        return this.f21352c;
    }

    public final void a(l lVar) {
        kotlin.jvm.internal.h.b(lVar, "nfsci");
        this.f21352c = lVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void c(String str) {
        kotlin.jvm.internal.h.b(str, "title");
        TextView textView = this.f21353d;
        if (textView != null) {
            textView.setText(str);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void e(String str) {
        kotlin.jvm.internal.h.b(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        TextView textView = this.f21354e;
        if (textView != null) {
            textView.setText(str);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void f(int i) {
        Button button = this.f21356g;
        if (button != null) {
            button.setVisibility(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void g(int i) {
        ProgressBar progressBar = this.f21355f;
        if (progressBar != null) {
            progressBar.setProgress(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void k(int i) {
        Button button = this.f21357h;
        if (button != null) {
            button.setVisibility(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.h.b(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.dialog_full_screen, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.main_title);
        if (findViewById != null) {
            this.f21353d = (TextView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.main_message);
            if (findViewById2 != null) {
                this.f21354e = (TextView) findViewById2;
                View findViewById3 = inflate.findViewById(R.id.progress_bar);
                if (findViewById3 != null) {
                    this.f21355f = (ProgressBar) findViewById3;
                    ProgressBar progressBar = this.f21355f;
                    if (progressBar != null) {
                        progressBar.setProgress(0);
                        ProgressBar progressBar2 = this.f21355f;
                        if (progressBar2 != null) {
                            progressBar2.setMax(100);
                            View findViewById4 = inflate.findViewById(R.id.close_button);
                            if (findViewById4 != null) {
                                this.f21356g = (Button) findViewById4;
                                Button button = this.f21356g;
                                if (button != null) {
                                    button.setOnClickListener(new n(this));
                                    View findViewById5 = inflate.findViewById(R.id.cancel_button);
                                    if (findViewById5 != null) {
                                        this.f21357h = (Button) findViewById5;
                                        Button button2 = this.f21357h;
                                        if (button2 != null) {
                                            button2.setOnClickListener(new o(this));
                                            TextView textView = this.f21354e;
                                            if (textView != null) {
                                                textView.setText(getString(R.string.reverse_dialog_message_prepare));
                                                l lVar = this.f21352c;
                                                if (lVar != null) {
                                                    lVar.a(this);
                                                    l lVar2 = this.f21352c;
                                                    if (lVar2 != null) {
                                                        lVar2.start();
                                                        return inflate;
                                                    }
                                                    kotlin.jvm.internal.h.a();
                                                    throw null;
                                                }
                                                kotlin.jvm.internal.h.a();
                                                throw null;
                                            }
                                            kotlin.jvm.internal.h.a();
                                            throw null;
                                        }
                                        kotlin.jvm.internal.h.a();
                                        throw null;
                                    }
                                    throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
                                }
                                kotlin.jvm.internal.h.a();
                                throw null;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type android.widget.Button");
                        }
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ProgressBar");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        z();
    }

    public void z() {
        HashMap hashMap = this.i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void c(int i) {
        TextView textView = this.f21354e;
        if (textView != null) {
            textView.setVisibility(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.a.p
    public void e(int i) {
        ProgressBar progressBar = this.f21355f;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
