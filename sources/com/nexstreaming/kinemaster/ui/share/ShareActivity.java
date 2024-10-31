package com.nexstreaming.kinemaster.ui.share;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import com.facebook.share.internal.ShareConstants;
import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.settings.aw;
import com.nexstreaming.kinemaster.usage.KMUsage;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ShareActivity extends ad implements aw.a {

    /* renamed from: a, reason: collision with root package name */
    private String f4275a;
    private View e;
    private View f;
    private GridLayout g;
    private View b = null;
    private int c = -1;
    private View.OnClickListener h = new aa(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4275a = getIntent() == null ? null : getIntent().getStringExtra(ShareConstants.FEED_SOURCE_PARAM);
        setContentView(R.layout.share_activity);
        a(bundle);
        findViewById(R.id.sns_share_youtube).setOnClickListener(this.h);
        findViewById(R.id.sns_share_facebook).setOnClickListener(this.h);
        findViewById(R.id.sns_share_dropbox).setOnClickListener(this.h);
        findViewById(R.id.sns_share_gplus).setOnClickListener(this.h);
        findViewById(R.id.sns_share_other).setOnClickListener(this.h);
        findViewById(R.id.sns_share_gallery).setOnClickListener(this.h);
        findViewById(R.id.sns_share_wechat).setOnClickListener(this.h);
        findViewById(R.id.sns_share_youtube).setVisibility(com.nexstreaming.kinemaster.h.a.f(this) ? 8 : 0);
        findViewById(R.id.sns_share_facebook).setVisibility(com.nexstreaming.kinemaster.h.a.f(this) ? 8 : 0);
        findViewById(R.id.sns_share_dropbox).setVisibility(com.nexstreaming.kinemaster.h.a.f(this) ? 8 : 0);
        findViewById(R.id.sns_share_gplus).setVisibility(com.nexstreaming.kinemaster.h.a.f(this) ? 8 : 0);
        findViewById(R.id.sns_share_wechat).setVisibility(8);
        this.g = (GridLayout) findViewById(R.id.shareGridLayout);
        this.b = findViewById(R.id.shareProjectDetails);
        this.e = findViewById(R.id.progressBarHolder);
        this.e.setOnTouchListener(new z(this));
        this.f = findViewById(R.id.dateAndDurationHolder);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.g.getChildCount(); i++) {
            View childAt = this.g.getChildAt(i);
            if (childAt.getVisibility() == 8) {
                arrayList.add(childAt);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.g.removeView((View) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage kMUsage = KMUsage.Activity_Share;
        String[] strArr = new String[2];
        strArr[0] = ShareConstants.FEED_SOURCE_PARAM;
        strArr[1] = this.f4275a == null ? "unknown" : this.f4275a;
        kMUsage.begin(strArr);
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onStop() {
        KMUsage.Activity_Share.end();
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        if (getFragmentManager().findFragmentById(android.R.id.content) == null && this.b != null) {
            this.b.setVisibility(0);
        }
        super.onResume();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    protected void a() {
        if (this.e.getVisibility() != 8) {
            this.e.setVisibility(8);
            this.f.setVisibility(0);
        }
        super.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (A() != null) {
            if (!A().E() || (A().D() && F())) {
                Fragment findFragmentById = getFragmentManager().findFragmentById(android.R.id.content);
                if (findFragmentById != null && findFragmentById.isAdded() && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.settings.aw)) {
                    getFragmentManager().popBackStackImmediate();
                }
                getFragmentManager().beginTransaction().replace(android.R.id.content, com.nexstreaming.kinemaster.ui.settings.aw.a(A(), 1, "share"), com.nexstreaming.kinemaster.ui.settings.aw.f4229a).addToBackStack(com.nexstreaming.kinemaster.ui.settings.aw.f4229a).commitAllowingStateLoss();
                this.b.setVisibility(8);
                return;
            }
            A().a(new ac(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        if (this.e.getVisibility() == 8) {
            if (getFragmentManager().popBackStackImmediate()) {
                this.b.setVisibility(0);
            } else {
                super.onBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba
    public void a(Context context) {
        super.a(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.settings.aw.a
    public void w() {
        getFragmentManager().popBackStackImmediate();
        if (this.c != -1) {
            Intent intent = new Intent(this, (Class<?>) ShareQualityActivity.class);
            f().a(intent);
            intent.putExtras(getIntent());
            intent.setData(getIntent().getData());
            intent.putExtra("kinemaster.shareTo", this.c);
            startActivity(intent);
            overridePendingTransition(0, 0);
            this.c = -1;
        }
    }

    @Override // com.nextreaming.nexeditorui.ba, com.nexstreaming.app.general.iab.IABHelper.a
    public void a(boolean z, Purchase purchase, String str) {
        super.a(z, purchase, str);
        if (z) {
            try {
                getFragmentManager().popBackStackImmediate();
            } catch (Exception e) {
                e.printStackTrace();
                Fragment findFragmentById = getFragmentManager().findFragmentById(android.R.id.content);
                if (findFragmentById != null && findFragmentById.isAdded() && (findFragmentById instanceof com.nexstreaming.kinemaster.ui.settings.aw)) {
                    ((com.nexstreaming.kinemaster.ui.settings.aw) findFragmentById).a(true);
                }
            }
            this.b.setVisibility(0);
            if (this.c != -1) {
                Intent intent = new Intent(this, (Class<?>) ShareQualityActivity.class);
                f().a(intent);
                intent.putExtras(getIntent());
                intent.setData(getIntent().getData());
                intent.putExtra("kinemaster.shareTo", this.c);
                startActivity(intent);
                overridePendingTransition(0, 0);
                this.c = -1;
            }
        }
    }
}
