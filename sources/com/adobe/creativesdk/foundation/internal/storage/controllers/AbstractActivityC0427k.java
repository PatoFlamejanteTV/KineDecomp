package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.R;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.KeyCharacterMap;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.adobeinternal.net.AdobeNetworkReachability;
import com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity;
import com.adobe.creativesdk.foundation.internal.utils.DrawShadowRelativeLayout;
import java.io.File;

/* compiled from: AdobeAssetShareBaseOneUpActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC0427k extends AdobeTOUHandlerActivity {

    /* renamed from: c, reason: collision with root package name */
    static AdobeNetworkReachability f6155c;

    /* renamed from: d, reason: collision with root package name */
    protected int f6156d;

    /* renamed from: e, reason: collision with root package name */
    File f6157e;

    /* renamed from: f, reason: collision with root package name */
    protected FragmentStatePagerAdapter f6158f;

    /* renamed from: g, reason: collision with root package name */
    protected ViewPager f6159g;

    /* renamed from: h, reason: collision with root package name */
    TextView f6160h;
    View i;
    protected View j;
    TextView k;
    protected RelativeLayout l;
    protected RelativeLayout m;
    protected RelativeLayout n;
    protected RelativeLayout o;
    protected RelativeLayout p;
    protected ImageView q;
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d r;
    protected com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.b s;
    protected int t;
    protected ViewGroup v;
    private Toast w;
    protected boolean u = false;
    private final String x = "Share_Asset_Name";
    protected View.OnTouchListener y = new ViewOnTouchListenerC0422j(this);

    private void B() {
        Toast toast = this.w;
        if (toast != null) {
            toast.cancel();
        }
    }

    public static boolean y() {
        if (f6155c == null) {
            f6155c = com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        }
        return f6155c.b();
    }

    protected abstract void A();

    Intent a(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.putExtra("Share_Asset_Name", str);
        intent.addFlags(1);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SpannableString c(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new com.adobe.creativesdk.foundation.internal.utils.d(null, com.adobe.creativesdk.foundation.internal.utils.c.a(this)), 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(c.a.a.a.b.b.adobe_csdk_asset_browser_dark_text)), 0, spannableString.length(), 33);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
        com.adobe.creativesdk.foundation.internal.utils.b.a(findViewById(R.id.content), str);
    }

    protected abstract void d(boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        w();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Boolean valueOf = Boolean.valueOf(C0455p.b(this));
        if (valueOf.booleanValue()) {
            setContentView(c.a.a.a.b.g.adobe_library_item_collection_activity_loki);
        } else {
            setContentView(c.a.a.a.b.g.adobe_library_item_collection_activity);
        }
        this.v = (ViewGroup) findViewById(c.a.a.a.b.e.adobe_csdk_library_oneup_rootview);
        ((DrawShadowRelativeLayout) this.v).setShadowTopOffset(getResources().getDimensionPixelSize(c.a.a.a.b.c.adobe_csdk_action_bar_size));
        this.r = a(getIntent().getExtras());
        x();
        z();
        this.f6159g = (ViewPager) findViewById(c.a.a.a.b.e.adobe_csdk_library_item_pager);
        this.f6159g.addOnPageChangeListener(t());
        this.f6159g.setOnTouchListener(this.y);
        this.f6159g.setPageTransformer(true, new C0479u());
        this.j = findViewById(c.a.a.a.b.e.adobe_csdk_library_item_open_button_container);
        this.i = findViewById(c.a.a.a.b.e.adobe_csdk_library_item_selection_open_file_btn);
        this.k = (TextView) findViewById(c.a.a.a.b.e.adobe_csdk_library_item_photo_number);
        this.f6160h = (TextView) findViewById(c.a.a.a.b.e.adobe_csdk_library_item_selection_open_file_text);
        A();
        if (f6155c == null) {
            f6155c = com.adobe.creativesdk.foundation.adobeinternal.net.a.b();
        }
        if (valueOf.booleanValue()) {
            this.l = (RelativeLayout) findViewById(c.a.a.a.b.e.adobe_csdk_bottombar);
            this.l.setVisibility(8);
            this.m = (RelativeLayout) findViewById(c.a.a.a.b.e.comments_bottombar_layout);
            this.o = (RelativeLayout) findViewById(c.a.a.a.b.e.edit_bottombar_layout);
            this.p = (RelativeLayout) findViewById(c.a.a.a.b.e.share_bottombar_layout);
            this.n = (RelativeLayout) findViewById(c.a.a.a.b.e.info_bottombar_layout);
            this.q = (ImageView) findViewById(c.a.a.a.b.e.share_bottombar);
        }
        this.f6157e = new File(getFilesDir(), "adobeassetviewerimages");
        if (this.f6157e.exists()) {
            return;
        }
        this.f6157e.mkdirs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        B();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.adobe.creativesdk.foundation.internal.base.AdobeTOUHandlerActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        B();
    }

    protected abstract String s();

    protected abstract ViewPager.SimpleOnPageChangeListener t();

    protected abstract File u();

    public Intent v() {
        File u = u();
        String s = s();
        if (u != null && u.exists()) {
            return this.s.c() ? a(FileProvider.getUriForFile(this, this.r.a(), u), s) : new Intent("android.intent.action.SEND");
        }
        Toast toast = this.w;
        if (toast == null || !toast.getView().isShown()) {
            this.w = Toast.makeText(getApplicationContext(), getResources().getString(c.a.a.a.b.i.adobe_csdk_one_up_view_preview_not_availabe), 0);
            this.w.show();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public void w() {
        ActionBar supportActionBar = getSupportActionBar();
        ViewConfiguration.get(this).hasPermanentMenuKey();
        int i = 4;
        KeyCharacterMap.deviceHasKey(4);
        this.f6159g.setBackgroundColor(getResources().getColor(c.a.a.a.b.b.adobe_csdk_oneupview_background_color));
        if (supportActionBar != null) {
            if (supportActionBar.isShowing()) {
                supportActionBar.hide();
                ((DrawShadowRelativeLayout) this.v).a(false, false);
                this.j.setVisibility(8);
                d(false);
                this.f6159g.setPadding(0, 0, 0, 0);
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 16) {
                    i = 0;
                } else if (i2 >= 19) {
                    i = 2052;
                }
                View decorView = getWindow().getDecorView();
                if (com.adobe.creativesdk.foundation.internal.utils.s.a(this)) {
                    i |= 1794;
                }
                decorView.setSystemUiVisibility(i);
                return;
            }
            supportActionBar.show();
            ((DrawShadowRelativeLayout) this.v).a(true, false);
            A();
            d(true);
            this.f6159g.setPadding(0, supportActionBar.getHeight(), 0, 0);
            getWindow().getDecorView().setSystemUiVisibility(0);
        }
    }

    protected abstract void x();

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        Toolbar toolbar;
        Boolean valueOf = Boolean.valueOf(C0455p.b(this));
        if (valueOf.booleanValue()) {
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(ViewCompat.MEASURED_STATE_MASK);
            }
            toolbar = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_toolbar_loki);
            toolbar.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            toolbar = (Toolbar) findViewById(c.a.a.a.b.e.adobe_csdk_actionbar_toolbar);
        }
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (valueOf.booleanValue()) {
                if (Build.VERSION.SDK_INT >= 21) {
                    supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_close_white_24dp, null));
                } else {
                    supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_close_white_24dp));
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_close_black_24dp, null));
            } else {
                supportActionBar.setHomeAsUpIndicator(getResources().getDrawable(c.a.a.a.b.d.ic_close_black_24dp));
            }
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setDisplayOptions(14);
            supportActionBar.setTitle("");
        }
    }

    private com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.d a(Bundle bundle) {
        if (bundle != null) {
            this.t = bundle.getInt("one_up_controller_code");
            this.r = com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration.c.a(this.t);
        }
        return this.r;
    }
}
