package com.nexstreaming.kinemaster.ui.share;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v4.content.FileProvider;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.e;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.share.U;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexExportProfile;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes2.dex */
public abstract class na extends com.nextreaming.nexeditorui.I {
    private ImageCyclerView H;
    private ImageView I;
    private com.nexstreaming.kinemaster.project.k J;
    private int K = 0;

    private void K() {
        ((TextView) findViewById(R.id.projectDetailsTitle)).setText(this.J.f());
        ((TextView) findViewById(R.id.projectDetailDate)).setText(this.J.d() == null ? "" : DateFormat.getMediumDateFormat(u()).format(this.J.d()));
        int g2 = this.J.g();
        if (g2 < 1000 && g2 >= 1) {
            g2 = 1000;
        }
        long j = g2;
        ((TextView) findViewById(R.id.projectDetailTime)).setText(String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(j)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(j) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(j))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.J.g()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j)))));
    }

    public ImageCyclerView G() {
        return this.H;
    }

    public com.nexstreaming.kinemaster.project.k H() {
        return this.J;
    }

    protected int I() {
        return this.K;
    }

    public void J() {
        K();
    }

    public void a(Bitmap bitmap) {
    }

    public void b(Bitmap bitmap) {
        ImageView imageView = this.I;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override // com.nextreaming.nexeditorui.I
    public void j(boolean z) {
        if (Build.VERSION.SDK_INT < 23 || com.nexstreaming.kinemaster.ui.e.b.a((Context) this, com.nexstreaming.kinemaster.ui.e.b.f21563a)) {
            super.j(z);
        }
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    @Override // com.nextreaming.nexeditorui.I, android.app.Activity
    public void onRestart() {
        this.H.setAnimationEnabled(true);
        super.onRestart();
    }

    @Override // com.nextreaming.nexeditorui.I, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        this.H.setAnimationEnabled(false);
        super.onStop();
    }

    public final void a(Bundle bundle) {
        byte[] byteArrayExtra;
        this.I = (ImageView) findViewById(R.id.projectDetailsThumb);
        this.H = (ImageCyclerView) findViewById(R.id.image_cycler_view);
        this.H.setBlur(1.0f);
        Intent intent = getIntent();
        if (intent != null) {
            this.K = intent.getIntExtra("kinemaster.shareTo", 0);
            this.H.b(intent);
            Bitmap c2 = ProjectGalleryActivity.c(intent.getIntExtra("projectThumb", 0));
            if (c2 == null && (byteArrayExtra = intent.getByteArrayExtra("projectThumb")) != null) {
                c2 = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            }
            if (c2 != null) {
                b(c2);
                com.nexstreaming.kinemaster.project.k.a(intent.getData()).onResultAvailable(new C2222ha(this));
                return;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra("projectThumb");
            if (parcelableExtra != null && (parcelableExtra instanceof Bitmap)) {
                b((Bitmap) parcelableExtra);
                com.nexstreaming.kinemaster.project.k.a(intent.getData()).onResultAvailable(new C2224ia(this));
            } else {
                com.nexstreaming.kinemaster.project.k.a(intent.getData()).onResultAvailable(new C2226ja(this));
            }
        }
    }

    public void b(File file, int i, int i2) {
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName(), file);
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        for (ResolveInfo resolveInfo : getPackageManager().queryIntentActivities(intent, 0)) {
            String str = resolveInfo.activityInfo.packageName;
            if (!str.equals(getPackageName())) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("video/*");
                intent2.putExtra("android.intent.extra.STREAM", uriForFile);
                intent2.setPackage(str);
                intent2.setClassName(str, resolveInfo.loadLabel(getPackageManager()).toString());
                intent2.setComponent(new ComponentName(str, resolveInfo.activityInfo.name));
                intent2.addFlags(1);
                if (Build.VERSION.SDK_INT >= 16) {
                    intent2.addFlags(2);
                } else {
                    grantUriPermission(str, uriForFile, 3);
                }
                arrayList.add(new LabeledIntent(intent2, str, resolveInfo.loadLabel(getPackageManager()), resolveInfo.getIconResource()));
            }
        }
        if (arrayList.size() > 0) {
            intent = Intent.createChooser((Intent) arrayList.get(0), getString(R.string.share_intent_title, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        }
        startActivity(intent);
    }

    public void a(File file, int i, int i2) {
        Uri uriForFile = FileProvider.getUriForFile(this, getPackageName(), file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "video/*");
        intent.addFlags(1);
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.play_intent_title, Integer.valueOf(i), Integer.valueOf(i2))));
    }

    public void a(File file, NexExportProfile nexExportProfile) {
        if (I() == R.id.sns_share_other) {
            b(file, nexExportProfile.width(), nexExportProfile.displayHeight());
            return;
        }
        e.a aVar = new e.a(this);
        aVar.e(R.string.save_video_to_gallery);
        aVar.b(file.getAbsolutePath());
        aVar.c(R.string.save_video_to_gallery_done);
        aVar.c(R.string.button_ok, new ma(this));
        aVar.b(R.string.save_play, new la(this, file, nexExportProfile));
        aVar.a(R.string.save_share, new ka(this, file, nexExportProfile));
        aVar.a().show();
    }

    public U.a a(NexExportProfile nexExportProfile, boolean z) {
        File b2;
        String a2;
        SupportLogger.Event.ShareBaseActivity_Export.log(new int[0]);
        U b3 = U.b();
        com.nexstreaming.kinemaster.project.k H = H();
        if (nexExportProfile == null) {
            return null;
        }
        if (!z) {
            b2 = Ja.a(this, nexExportProfile, H);
        } else {
            b2 = Ja.b(this, nexExportProfile, H);
        }
        File file = b2;
        if (file.exists()) {
            SupportLogger.Event.ShareBaseActivity_ExportFileExists.log(new int[0]);
            a(file, nexExportProfile);
            return null;
        }
        SupportLogger.Event.ShareBaseActivity_BeginGetPurchases.log(new int[0]);
        SupportLogger.Event.ShareBaseActivity_GetPurchasesComplete.log(b3.c() ? 1 : 0);
        if (!C() && !z) {
            z().b(true);
            a2 = EditorGlobal.a("std");
        } else {
            z().b(false);
            a2 = EditorGlobal.a("up");
        }
        String str = a2;
        if (b3.c()) {
            return null;
        }
        U.a a3 = b3.a(H.e(), file, nexExportProfile, false, str, C(), (int) (Float.parseFloat(PreferenceManager.getDefaultSharedPreferences(u()).getString("exporting_frame_rate", "30")) * 100.0f), I(), 0);
        SupportLogger.Event.ShareBaseActivity_MadeExportTask.log(new int[0]);
        return a3;
    }
}
