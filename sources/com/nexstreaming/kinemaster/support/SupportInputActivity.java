package com.nexstreaming.kinemaster.support;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* loaded from: classes.dex */
public class SupportInputActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private TextView f3629a = null;
    private EditText b = null;
    private ListView c = null;
    private Button d = null;
    private h e = null;
    private g f = null;
    private g g = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_support_input);
        a();
        b();
    }

    private void a() {
        this.f = new g(getString(R.string.support_main_title), getString(R.string.support_main_title), null, null);
        new g(getString(R.string.support_main_feature_request), null, getString(R.string.feature_request_error_tag), this.f);
        g gVar = new g(getString(R.string.support_main_bug_issue_report), getString(R.string.support_sub_title_bug_issue), getString(R.string.issue_report_error_tag), this.f);
        g.a(getString(R.string.support_sub_crash_or_freeze), null, getString(R.string.crash_error_tag), gVar);
        g.a(getString(R.string.support_sub_preview_play), null, getString(R.string.play_error_tag), gVar);
        g.a(getString(R.string.support_sub_export_or_share), null, getString(R.string.export_error_tag), gVar);
        g.a(getString(R.string.support_sub_translation_or_ui), null, getString(R.string.ui_error_tag), gVar);
        g.a(getString(R.string.support_other), null, getString(R.string.other_error_tag), gVar);
        g gVar2 = new g(getString(R.string.support_main_subscription_probelms), getString(R.string.support_sub_title_subscription_problem), getString(R.string.subscription_error_tag), this.f);
        g.a(getString(R.string.support_sub_problem_subscribing), null, getString(R.string.new_error_tag), gVar2);
        g.a(getString(R.string.support_sub_subscription_not_recognized), null, getString(R.string.existing_error_tag), gVar2);
        g.a(getString(R.string.support_sub_subscription_cancellation), null, getString(R.string.cancel_error_tag), gVar2);
        g.a(getString(R.string.support_other), null, getString(R.string.other_error_tag), gVar2);
        new g(getString(R.string.support_main_business_inquiry), null, getString(R.string.business_Inquiry_error_tag), this.f);
        new g(getString(R.string.support_other), null, getString(R.string.other_error_tag), this.f);
    }

    private void b() {
        this.f3629a = (TextView) findViewById(R.id.tv_support_title);
        this.b = (EditText) findViewById(R.id.et_support_input);
        this.c = (ListView) findViewById(R.id.lv_support_category);
        this.d = (Button) findViewById(R.id.btn_support);
        this.b.addTextChangedListener(new d(this));
        this.d.setOnClickListener(new e(this));
        this.e = new h(this, this.f);
        this.c.setAdapter((ListAdapter) this.e);
        this.c.setOnItemClickListener(new f(this));
        a(this.f);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.e != null) {
            g gVar = this.e.a().f;
            if (this.c.isShown()) {
                if (gVar != null) {
                    a(gVar == null ? this.e.a() : gVar);
                    this.e.a(gVar);
                    return;
                } else {
                    super.onBackPressed();
                    return;
                }
            }
            this.g = null;
            c();
            if (gVar == null) {
                gVar = this.e.a();
            }
            a(gVar);
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar) {
        if (gVar != null) {
            if (!TextUtils.isEmpty(gVar.b)) {
                this.f3629a.setText(gVar.b);
            }
            if (this.g == null) {
                this.d.setEnabled(true);
                this.d.setText(R.string.support_cancel);
            } else {
                this.d.setText(R.string.support_send);
                this.d.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(g gVar) {
        if (gVar != null) {
            this.g = gVar;
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.b.setFocusable(true);
        }
    }

    private void c() {
        this.b.setText("");
        this.b.setVisibility(8);
        this.c.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar) {
        if (gVar != null) {
            gVar.c = this.b.getText().toString();
            i.a(this, gVar, "AKM", new File[0]);
        }
        finish();
    }
}
