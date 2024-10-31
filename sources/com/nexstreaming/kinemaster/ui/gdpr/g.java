package com.nexstreaming.kinemaster.ui.gdpr;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.util.regex.Pattern;

/* compiled from: GDPRFragment.java */
/* loaded from: classes.dex */
public class g extends DialogFragment {

    /* renamed from: b */
    private a f21600b;

    /* renamed from: a */
    private int f21599a = 3;

    /* renamed from: c */
    final Linkify.TransformFilter f21601c = new e(this);

    /* compiled from: GDPRFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(DialogInterface dialogInterface);

        void a(DialogInterface dialogInterface, boolean z, boolean z2);
    }

    private void b(View view) {
        TextView textView = (TextView) view.findViewById(R.id.firebase_content);
        textView.setText(R.string.GDPR_Firebase_check_popup_msg);
        a(textView, getString(R.string.GDPR_Firebase_Privacy_policy_link), "https://policies.google.com/privacy");
        a(textView, getString(R.string.GDPR_Flurry_Privacy_policy_link), "https://developer.yahoo.com/flurry/legal-privacy/terms-service/flurry-analytics-terms-service.html");
        a(textView, getString(R.string.GDPR_Fabric_Privacy_policy_link), "https://fabric.io/terms");
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.firebase_scroll);
        nestedScrollView.post(new d(this, nestedScrollView));
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f21599a = arguments.getInt("gdprMode", 3);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        View inflate = View.inflate(getActivity(), R.layout.dialog_gdpr, null);
        com.nexstreaming.kinemaster.ui.a.e eVar = new com.nexstreaming.kinemaster.ui.a.e(getActivity());
        eVar.setOnKeyListener(new b(this));
        eVar.a((CharSequence) null, false);
        eVar.a(inflate, R.drawable.bg_gdpr_dialog);
        eVar.c(getResources().getDimensionPixelOffset(R.dimen.gdpr_popup_width));
        int i = this.f21599a;
        if (i == 1) {
            inflate.findViewById(R.id.admob_checkbox_holder).setVisibility(8);
            inflate.findViewById(R.id.admob_scroll).setVisibility(8);
            inflate.findViewById(R.id.firebase_scroll).setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.gdpr_popup_width), getResources().getDimensionPixelOffset(R.dimen.gdpr_scrollview_height)));
            b(inflate);
        } else if (i == 2) {
            inflate.findViewById(R.id.firebase_checkbox_holder).setVisibility(8);
            inflate.findViewById(R.id.firebase_scroll).setVisibility(8);
            inflate.findViewById(R.id.admob_scroll).setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.gdpr_popup_width), getResources().getDimensionPixelOffset(R.dimen.gdpr_scrollview_height)));
            a(inflate);
        } else if (i == 3) {
            b(inflate);
            a(inflate);
        }
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.firebase_checkbox);
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.admob_checkbox);
        checkBox.setChecked(c.d.b.c.a.d(getActivity()));
        checkBox2.setChecked(c.d.b.c.a.c(getActivity()));
        ((Button) inflate.findViewById(R.id.submit_button)).setOnClickListener(new c(this, eVar, checkBox, checkBox2));
        return eVar;
    }

    private void a(View view) {
        TextView textView = (TextView) view.findViewById(R.id.admob_content);
        textView.setText(R.string.GDPR_AdMob_check_popup_msg);
        a(textView, getString(R.string.GDPR_AdMob_Privacy_policy_link), "https://developers.google.com/admob/android/eu-consent");
        NestedScrollView nestedScrollView = (NestedScrollView) view.findViewById(R.id.admob_scroll);
        nestedScrollView.post(new f(this, nestedScrollView));
    }

    private void a(TextView textView, String str, String str2) {
        if (textView.getText().toString().indexOf(str) > -1) {
            Linkify.addLinks(textView, Pattern.compile(str), str2, (Linkify.MatchFilter) null, this.f21601c);
        }
    }

    public void a(a aVar) {
        this.f21600b = aVar;
    }
}
