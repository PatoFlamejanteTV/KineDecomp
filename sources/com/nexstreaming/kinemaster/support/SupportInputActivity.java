package com.nexstreaming.kinemaster.support;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* loaded from: classes.dex */
public class SupportInputActivity extends AppCompatActivity {

    /* renamed from: a */
    private TextView f21229a = null;

    /* renamed from: b */
    private EditText f21230b = null;

    /* renamed from: c */
    private ListView f21231c = null;

    /* renamed from: d */
    private Button f21232d = null;

    /* renamed from: e */
    private t f21233e = null;

    /* renamed from: f */
    private r f21234f = null;

    /* renamed from: g */
    private r f21235g = null;

    /* renamed from: h */
    private int f21236h = 0;

    private void s() {
        this.f21234f = r.a(getString(R.string.support_main_title), getString(R.string.support_main_title), null, null);
        r.a(getString(R.string.support_main_feature_request), null, getString(R.string.feature_request_error_tag), this.f21234f);
        r a2 = r.a(getString(R.string.support_main_bug_issue_report), getString(R.string.support_sub_title_bug_issue), getString(R.string.issue_report_error_tag), this.f21234f);
        r.a(getString(R.string.support_sub_crash_or_freeze), null, getString(R.string.crash_error_tag), a2);
        r.a(getString(R.string.support_sub_preview_play), null, getString(R.string.play_error_tag), a2);
        r.a(getString(R.string.support_sub_export_or_share), null, getString(R.string.export_error_tag), a2);
        r.a(getString(R.string.support_sub_translation_or_ui), null, getString(R.string.ui_error_tag), a2);
        r.a(getString(R.string.support_other), null, getString(R.string.other_error_tag), a2);
        r a3 = r.a(getString(R.string.support_main_subscription_probelms), getString(R.string.support_sub_title_subscription_problem), getString(R.string.subscription_error_tag), this.f21234f);
        r.a(getString(R.string.support_sub_problem_subscribing), null, getString(R.string.new_error_tag), a3);
        r.a(getString(R.string.support_sub_subscription_not_recognized), null, getString(R.string.existing_error_tag), a3);
        r.a(getString(R.string.support_sub_subscription_cancellation), null, getString(R.string.cancel_error_tag), a3);
        r.a(getString(R.string.support_other), null, getString(R.string.other_error_tag), a3);
        r.a(getString(R.string.support_main_business_inquiry), null, getString(R.string.business_Inquiry_error_tag), this.f21234f);
        r.a(getString(R.string.email_support_data_subject), null, getString(R.string.privacy_tag), this.f21234f);
        r.a(getString(R.string.support_other), null, getString(R.string.other_error_tag), this.f21234f);
    }

    private void t() {
        this.f21229a = (TextView) findViewById(R.id.tv_support_title);
        this.f21230b = (EditText) findViewById(R.id.et_support_input);
        this.f21231c = (ListView) findViewById(R.id.lv_support_category);
        this.f21232d = (Button) findViewById(R.id.btn_support);
        this.f21230b.addTextChangedListener(new o(this));
        this.f21232d.setOnClickListener(new p(this));
        this.f21233e = new t(this, this.f21234f);
        this.f21231c.setAdapter((ListAdapter) this.f21233e);
        this.f21231c.setOnItemClickListener(new q(this));
        c(this.f21234f);
    }

    private void u() {
        this.f21230b.setText("");
        this.f21230b.setVisibility(8);
        this.f21231c.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        t tVar = this.f21233e;
        if (tVar != null) {
            r rVar = tVar.a().f21260f;
            if (this.f21231c.isShown()) {
                if (rVar != null) {
                    c(rVar == null ? this.f21233e.a() : rVar);
                    this.f21233e.a(rVar);
                    return;
                } else {
                    super.onBackPressed();
                    return;
                }
            }
            this.f21235g = null;
            u();
            if (rVar == null) {
                rVar = this.f21233e.a();
            }
            c(rVar);
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_support_input);
        this.f21236h = getIntent().getIntExtra("PT", 0);
        s();
        t();
    }

    public void a(r rVar) {
        if (rVar != null) {
            rVar.f21257c = this.f21230b.getText().toString();
            v.a(this, PurchaseType.fromId(this.f21236h), rVar, "AKM", new File[0]);
        }
        finish();
    }

    public void b(r rVar) {
        if (rVar != null) {
            this.f21235g = rVar;
            this.f21230b.setVisibility(0);
            this.f21231c.setVisibility(8);
            this.f21230b.setFocusable(true);
        }
    }

    public void c(r rVar) {
        if (rVar != null) {
            if (!TextUtils.isEmpty(rVar.f21256b)) {
                this.f21229a.setText(rVar.f21256b);
            }
            if (this.f21235g == null) {
                this.f21232d.setEnabled(true);
                this.f21232d.setText(R.string.support_cancel);
            } else {
                this.f21232d.setText(R.string.support_next);
                this.f21232d.setEnabled(false);
            }
        }
    }
}
