package com.nexstreaming.kinemaster.ui.projectgallery;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nexstreaming.sdk2.nexsns.SNS;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ExportFileListActivity extends com.nexstreaming.kinemaster.ui.share.ad {

    /* renamed from: a, reason: collision with root package name */
    private ListView f4122a;
    private View b;
    private View e;
    private List<File> c = new ArrayList();
    private BaseAdapter f = new t(this);
    private View.OnClickListener g = new u(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SupportLogger.Event.Activity_ShareQuality_OnCreate.log(new int[0]);
        setContentView(R.layout.export_file_list);
        a(bundle);
        this.b = findViewById(R.id.projectDetailsThumb);
        this.f4122a = (ListView) findViewById(R.id.exportFileList);
        this.e = findViewById(R.id.editProject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStart() {
        KMUsage.Activity_ShareChooseQuality.begin();
        super.onStart();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad, com.nextreaming.nexeditorui.ba, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    protected void a() {
        super.b(false);
        try {
            File[] listFiles = EditorGlobal.e(this).listFiles(new o(this));
            String f = e().f();
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].getName().startsWith(f)) {
                    this.c.add(listFiles[i]);
                }
            }
        } catch (Exception e) {
            Log.e("ExportFileListActivity", e.getMessage());
        }
        this.b.addOnLayoutChangeListener(new p(this));
        this.f.notifyDataSetChanged();
        this.f4122a.setOnItemClickListener(new q(this));
        this.e.setOnClickListener(new r(this));
    }

    @Override // com.nexstreaming.kinemaster.ui.share.ad
    public void a(File file, NexExportProfile nexExportProfile) {
        this.f.notifyDataSetChanged();
        SNS c = c();
        if (c == null) {
            super.a(file, nexExportProfile);
        } else {
            a(c.a(file).a(e().f()).a());
        }
    }
}
