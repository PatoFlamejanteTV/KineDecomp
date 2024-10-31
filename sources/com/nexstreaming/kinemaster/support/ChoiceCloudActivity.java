package com.nexstreaming.kinemaster.support;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.File;

/* loaded from: classes.dex */
public class ChoiceCloudActivity extends AppCompatActivity {

    /* renamed from: a */
    private TextView f21213a = null;

    /* renamed from: b */
    private TextView f21214b = null;

    /* renamed from: c */
    private EditText f21215c = null;

    /* renamed from: d */
    private ListView f21216d = null;

    /* renamed from: e */
    private Button f21217e = null;

    /* renamed from: f */
    private t f21218f = null;

    /* renamed from: g */
    private r f21219g = null;

    /* renamed from: h */
    private r f21220h = null;

    private void s() {
        this.f21219g = r.a(getString(R.string.upload_project_popup_title), getString(R.string.upload_project_popup_title), getString(R.string.upload_project_popup_explain), "Cloud", null);
        r.a("Adobe Creative Cloud", null, "AdobeCC", this.f21219g);
        r.a("Google Drive", null, "GoogleDrive", this.f21219g);
    }

    private void t() {
        this.f21213a = (TextView) findViewById(R.id.tv_support_title);
        this.f21214b = (TextView) findViewById(R.id.tv_support_subtitle);
        this.f21215c = (EditText) findViewById(R.id.et_support_input);
        this.f21216d = (ListView) findViewById(R.id.lv_support_category);
        this.f21217e = (Button) findViewById(R.id.btn_support);
        this.f21215c.addTextChangedListener(new a(this));
        this.f21217e.setOnClickListener(new b(this));
        this.f21218f = new t(this, this.f21219g);
        this.f21216d.setAdapter((ListAdapter) this.f21218f);
        this.f21216d.setOnItemClickListener(new c(this));
        b(this.f21219g);
    }

    private void u() {
        this.f21215c.setText("");
        this.f21215c.setVisibility(8);
        this.f21216d.setVisibility(0);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        t tVar = this.f21218f;
        if (tVar != null) {
            r rVar = tVar.a().f21260f;
            if (this.f21216d.isShown()) {
                if (rVar != null) {
                    b(rVar == null ? this.f21218f.a() : rVar);
                    this.f21218f.a(rVar);
                    return;
                } else {
                    super.onBackPressed();
                    return;
                }
            }
            this.f21220h = null;
            u();
            if (rVar == null) {
                rVar = this.f21218f.a();
            }
            b(rVar);
            return;
        }
        super.onBackPressed();
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.nexstreaming.kinemaster.usage.analytics.b.a(getLocalClassName());
        super.onCreate(bundle);
        setContentView(R.layout.activity_choice_cloud);
        s();
        t();
    }

    private void b(r rVar) {
        if (rVar != null) {
            if (!TextUtils.isEmpty(rVar.f21256b)) {
                this.f21213a.setText(rVar.f21256b);
            }
            if (!TextUtils.isEmpty(rVar.f21261g)) {
                this.f21214b.setText(rVar.f21261g);
            }
            if (this.f21220h == null) {
                this.f21217e.setEnabled(true);
                this.f21217e.setText(R.string.support_cancel);
            } else {
                this.f21217e.setText(R.string.support_next);
                this.f21217e.setEnabled(false);
            }
        }
    }

    public void c(String str) {
        if (str != null) {
            Intent intent = getIntent();
            intent.putExtra("cloudName", str);
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        finish();
    }

    public void a(r rVar) {
        if (rVar != null) {
            rVar.f21257c = this.f21215c.getText().toString();
            v.a(this, null, rVar, "AKM", new File[0]);
        }
        finish();
    }
}
