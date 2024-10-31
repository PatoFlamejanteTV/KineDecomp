package com.nexstreaming.kinemaster.ui.share;

import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.widget.Toolbar;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.sdk2.nexsns.SNS;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;

/* loaded from: classes.dex */
public class ShareQualityActivity extends ad {

    /* renamed from: a, reason: collision with root package name */
    private ListView f4280a;
    private View b;
    private NexExportProfile[] c;
    private Toolbar e;
    private View f;
    private View g;
    private View h;
    private View i;
    private boolean j = false;
    private BaseAdapter k = new bm(this);
    private Runnable l = new br(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SupportLogger.Event.Activity_ShareQuality_OnCreate.log(new int[0]);
        setContentView(R.layout.share_quality_activity);
        a(bundle);
        this.b = findViewById(R.id.projectDetailsThumb);
        this.f4280a = (ListView) findViewById(R.id.exportQualityList);
        this.e = (Toolbar) findViewById(R.id.toolbar_quality);
        this.f = findViewById(R.id.share_launch_fb);
        this.g = findViewById(R.id.share_launch);
        this.h = findViewById(R.id.toolbarMoreButton);
        this.i = findViewById(R.id.toolbarDoneButton);
        NexExportProfile[] supportedExportProfiles = NexEditorDeviceProfile.getDeviceProfile().getSupportedExportProfiles(E().i());
        this.c = new NexExportProfile[supportedExportProfiles.length];
        for (int i = 0; i < this.c.length; i++) {
            this.c[i] = supportedExportProfiles[i].mutableCopy();
            this.c[i].setBitrate(PreferenceManager.getDefaultSharedPreferences(this).getInt("export_" + this.c[i].width() + "x" + this.c[i].height() + "_bitrate", (int) (((((((float) (this.c[i].width() * this.c[i].height())) * 30.0f) * 2.0f) * 0.07f) / 1000.0f) * 1024.0f)));
        }
        this.f4280a.setAdapter((ListAdapter) this.k);
        this.h.setOnClickListener(new bi(this));
        this.i.setOnClickListener(new bk(this));
        if (j() == 0) {
            this.e.setTitle(getResources().getString(R.string.save_video_to_gallery));
        } else {
            this.e.setLogo(j());
            this.e.setTitle(getResources().getString(h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_ShareChooseQuality.begin();
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onStop() {
        this.g.setVisibility(8);
        this.f.setVisibility(8);
        KMUsage.Activity_ShareChooseQuality.end();
        this.g.removeCallbacks(this.l);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    protected void a() {
        SupportLogger.Event.Activity_ShareQuality_OnProjectInfoAvailable.log(new int[0]);
        super.a();
        this.k.notifyDataSetChanged();
        this.f4280a.setOnItemClickListener(new bl(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onResume() {
        this.g.removeCallbacks(this.l);
        if (this.g != null) {
            this.g.setVisibility(4);
        }
        if (this.f != null) {
            this.f.setVisibility(4);
        }
        super.onResume();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    public void a(File file, NexExportProfile nexExportProfile) {
        this.k.notifyDataSetChanged();
        SNS c = c();
        if (c == null) {
            super.a(file, nexExportProfile);
            return;
        }
        Task a2 = c.a(file).a(e().f()).a();
        this.g.setVisibility(0);
        a2.onFailure(new bq(this)).onCancel(new bp(this)).onComplete(new bo(this));
        if (Build.VERSION.SDK_INT >= 23 && d() == R.id.sns_share_facebook) {
            this.g.postDelayed(this.l, 5000L);
        }
        a(a2);
    }
}
