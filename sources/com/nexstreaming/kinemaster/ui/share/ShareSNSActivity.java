package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.projectedit.FullScreenInputActivity;
import com.nexstreaming.kinemaster.ui.widget.TransparentTextButton;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.sdk2.nexsns.Privacy;
import com.nexstreaming.sdk2.nexsns.SNS;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.newproject.toolbar.ToolbarLayout;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apmem.tools.layouts.FlowLayout;

/* loaded from: classes.dex */
public class ShareSNSActivity extends ad {

    /* renamed from: a, reason: collision with root package name */
    private Spinner f4281a;
    private Spinner b;
    private Spinner c;
    private TextView e;
    private TextView f;
    private TransparentTextButton g;
    private ScrollView h;
    private ImageButton i;
    private FlowLayout j;
    private LinearLayout k;
    private List<Privacy> l;
    private String[] m;
    private NexExportProfile n;
    private List<com.nexstreaming.sdk2.nexsns.ac> o;
    private com.nexstreaming.sdk2.nexsns.ac p;
    private Privacy q;
    private String r;
    private List<String> s;
    private ToolbarLayout t;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        Serializable serializableExtra;
        super.onCreate(bundle);
        setContentView(R.layout.share_sns_activity);
        Intent intent = getIntent();
        if (intent != null && (serializableExtra = intent.getSerializableExtra("exportProfile")) != null && (serializableExtra instanceof NexExportProfile)) {
            this.n = (NexExportProfile) serializableExtra;
        }
        this.f4281a = (Spinner) findViewById(R.id.userIdList);
        this.b = (Spinner) findViewById(R.id.openRangeList);
        this.c = (Spinner) findViewById(R.id.categoryList);
        this.e = (TextView) findViewById(R.id.projectTitle);
        this.f = (TextView) findViewById(R.id.projectExplainView);
        this.g = (TransparentTextButton) findViewById(R.id.shareButton);
        this.h = (ScrollView) findViewById(R.id.tagsScrollView);
        this.i = (ImageButton) findViewById(R.id.addTagBtn);
        this.j = (FlowLayout) findViewById(R.id.tagTvHolder);
        this.k = (LinearLayout) findViewById(R.id.tagsHolder);
        this.t = (ToolbarLayout) findViewById(R.id.toolbar_sns);
        a(bundle);
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_ShareDetails.begin();
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    protected void a() {
        super.a();
        l();
        m();
        n();
    }

    private void k() {
        SNS c = c();
        if (c != null) {
            if (c.b()) {
                this.c.setEnabled(false);
                this.g.setEnabled(false);
                this.c.setVisibility(0);
                c.j().onResultAvailable(new bs(this));
            } else {
                this.c.setVisibility(8);
                this.g.setEnabled(true);
            }
            this.e.setVisibility(c.c() ? 0 : 8);
            this.f.setVisibility(c.d() ? 0 : 8);
            this.k.setVisibility(c.a() ? 0 : 8);
            int e = c.e();
            if (e < 1) {
                this.f4281a.setVisibility(8);
            } else {
                this.f4281a.setVisibility(0);
                this.m = new String[e];
                for (int i = 0; i < e; i++) {
                    this.m[i] = c.a(i);
                }
            }
            switch (c.h()) {
                case ALWAYS_PUBLIC:
                    this.l = Collections.singletonList(Privacy.EVERYONE);
                    this.b.setVisibility(0);
                    break;
                case MANAGED_BY_SNS:
                    this.b.setVisibility(8);
                    break;
                case MANAGED_BY_APP:
                    this.l = c.i();
                    this.b.setVisibility(0);
                    break;
            }
        }
        this.t.setLogo(j());
        this.t.setTitle(h());
    }

    private void l() {
        if (this.m != null && this.f4281a.getVisibility() == 0) {
            this.f4281a.setAdapter((SpinnerAdapter) new bz(this, this.m));
            this.f4281a.setOnItemSelectedListener(new ca(this));
        }
        if (this.l != null && this.b.getVisibility() == 0) {
            this.b.setAdapter((SpinnerAdapter) new cb(this, this.l));
            this.b.setOnItemSelectedListener(new cc(this));
        }
        if (this.o == null && this.c.getVisibility() == 0) {
            this.c.setAdapter((SpinnerAdapter) new cd(this, new String[]{getResources().getString(R.string.sns_cat_loading)}));
        }
        this.c.setOnItemSelectedListener(new ce(this));
    }

    private void m() {
        if (this.e != null && this.e.getVisibility() == 0) {
            this.e.setText(e().f());
            this.e.setOnTouchListener(new cf(this));
        }
        if (this.f != null && this.f.getVisibility() == 0) {
            this.f.setMovementMethod(new ScrollingMovementMethod());
            this.f.setOnTouchListener(new cg(this));
        }
    }

    private void n() {
        if (this.h != null && this.h.getVisibility() == 0 && this.i != null) {
            this.i.setOnClickListener(new bu(this));
        }
        if (e() != null) {
            if (cl.a(this, this.n, e()).exists()) {
                this.g.setText(getResources().getString(R.string.save_share));
            } else {
                this.g.setText(getResources().getString(R.string.save_export_and_share));
            }
        }
        this.g.setOnClickListener(new bv(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onStop() {
        KMUsage.Activity_ShareDetails.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        if (intent != null && i == FullScreenInputActivity.a()) {
            if (this.f != null && (stringExtra = intent.getStringExtra("text")) != null) {
                this.f.setText(stringExtra.trim());
            }
        } else if (intent != null && i == R.id.add_tag) {
            TextView textView = new TextView(D());
            String stringExtra2 = intent.getStringExtra("text");
            if (stringExtra2 != null && !stringExtra2.trim().equals("")) {
                textView.setText(stringExtra2.trim());
            }
            textView.setBackground(getResources().getDrawable(R.drawable.share_sns_white_round_bg));
            textView.setTextColor(getResources().getColor(R.color.sns_tag_text_color));
            textView.setTextSize(2, getResources().getDimension(R.dimen.sns_tag_text_size));
            this.j.addView(textView, this.j.getChildCount() <= 0 ? 0 : this.j.getChildCount() - 1);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.sns_tag_padding);
            textView.setPadding(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            textView.setOnTouchListener(new bw(this));
            if (o() && this.k != null) {
                this.k.setBackground(getResources().getDrawable(R.drawable.share_sns_black_trans_round_bg));
            } else if (this.k != null) {
                this.k.setBackground(null);
            }
            if (this.s == null) {
                this.s = new ArrayList();
            }
            this.s.add(stringExtra2);
        } else if (intent != null && i == R.id.edit_project_title_for_sns) {
            String stringExtra3 = intent.getStringExtra("text");
            if (this.e != null && stringExtra3 != null && !stringExtra3.trim().equals("")) {
                this.e.setText(stringExtra3.trim());
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    private boolean o() {
        View childAt = this.h.getChildAt(0);
        if (childAt != null) {
            return this.h.getHeight() < ((childAt.getHeight() * 2) + this.h.getPaddingTop()) + this.h.getPaddingBottom();
        }
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    public void a(File file, NexExportProfile nexExportProfile) {
        SNS c = c();
        if (c == null) {
            super.a(file, nexExportProfile);
        } else {
            c.c_(this.r);
            a(c.a(file).a(this.p).b(this.f.getText().toString()).a(e().f()).a(this.s).a(this.q).a());
        }
    }
}
