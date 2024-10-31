package com.adobe.creativesdk.foundation.internal.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import c.a.a.a.b.g;
import c.a.a.a.b.i;
import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CloudPickerActivity extends AdobeTOUHandlerActivity implements AdapterView.OnItemClickListener {

    /* renamed from: c */
    private ListView f5195c;

    /* renamed from: e */
    private e f5197e;

    /* renamed from: g */
    private ProgressDialog f5199g;

    /* renamed from: d */
    private Integer f5196d = -1;

    /* renamed from: f */
    List<AdobeCloud> f5198f = new ArrayList();

    /* renamed from: h */
    public boolean f5200h = true;

    private void t() {
        setResult(-1);
        finish();
    }

    public void u() {
        this.f5197e.clear();
        this.f5197e.addAll(this.f5198f);
        this.f5195c.setAdapter((ListAdapter) this.f5197e);
        ProgressDialog progressDialog = this.f5199g;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        this.f5195c.setVisibility(0);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(h.a.a.a.c.a(context));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        finish();
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(g.activity_cloud_picker);
        this.f5195c = (ListView) findViewById(c.a.a.a.b.e.adobe_csdk_cloud_list1);
        this.f5197e = new e(this, this.f5198f);
        this.f5195c.setOnItemClickListener(this);
        Toolbar toolbar = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_cloud_picker_actionbar_toolbar);
        toolbar.setNavigationIcon(c.a.a.a.b.d.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new b(this));
        this.f5200h = getIntent().getBooleanExtra("INDICATE_DEFAULT_CLOUD", true);
        ((TextView) findViewById(c.a.a.a.b.e.adobe_csdk_cloudpicker_actionbar_title)).setText(i.adobe_csdk_asset_ux_settings_change_location);
        s();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == this.f5196d.intValue() || this.f5198f.isEmpty()) {
            return;
        }
        com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().c(this.f5198f.get(i));
        ImageView imageView = this.f5196d.intValue() != -1 ? (ImageView) a(this.f5196d.intValue(), this.f5195c).findViewById(c.a.a.a.b.e.adobe_csdk_Default_Cloud_selector) : null;
        ImageView imageView2 = (ImageView) a(i, this.f5195c).findViewById(c.a.a.a.b.e.adobe_csdk_Default_Cloud_selector);
        if (imageView != null) {
            imageView.setVisibility(4);
            imageView.requestLayout();
        }
        imageView2.setVisibility(0);
        imageView2.requestLayout();
        this.f5196d = Integer.valueOf(i);
        t();
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void s() {
        ArrayList arrayList = new ArrayList();
        if (!this.f5200h && a.a() != null && !a.a().isEmpty()) {
            this.f5198f = a.a();
            u();
        } else {
            this.f5195c.setVisibility(8);
            this.f5199g = ProgressDialog.show(this, null, getString(i.adobe_csdk_asset_ux_wait_message));
            this.f5199g.setCancelable(true);
            com.adobe.creativesdk.foundation.adobeinternal.cloud.d.e().a(new c(this, arrayList), new d(this), new Handler());
        }
    }

    public void a(Integer num) {
        this.f5196d = num;
    }

    private View a(int i, ListView listView) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int childCount = (listView.getChildCount() + firstVisiblePosition) - 1;
        if (i >= firstVisiblePosition && i <= childCount) {
            return listView.getChildAt(i - firstVisiblePosition);
        }
        return listView.getAdapter().getView(i, null, listView);
    }
}
