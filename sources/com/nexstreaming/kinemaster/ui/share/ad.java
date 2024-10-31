package com.nexstreaming.kinemaster.ui.share;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.ui.a.a;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nexstreaming.kinemaster.ui.share.k;
import com.nexstreaming.kinemaster.ui.widget.ImageCyclerView;
import com.nexstreaming.sdk2.nexsns.SNS;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.tencent.mm.sdk.constants.ConstantsAPI;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public abstract class ad extends com.nextreaming.nexeditorui.ba {

    /* renamed from: a, reason: collision with root package name */
    private ImageCyclerView f4288a;
    private ImageView b;
    private com.nexstreaming.kinemaster.project.f c;
    private int e;

    public static String a(int i) {
        switch (i) {
            case R.id.sns_share_gallery /* 2131821505 */:
            case R.id.shareGridLayout /* 2131821506 */:
            case R.id.sns_share_other /* 2131821512 */:
            default:
                return null;
            case R.id.sns_share_youtube /* 2131821507 */:
                return "youtube";
            case R.id.sns_share_facebook /* 2131821508 */:
                return "facebook";
            case R.id.sns_share_gplus /* 2131821509 */:
                return "google+";
            case R.id.sns_share_dropbox /* 2131821510 */:
                return "dropbox";
            case R.id.sns_share_wechat /* 2131821511 */:
                return ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE;
        }
    }

    public SNS c() {
        String a2 = a(d());
        if (a2 == null) {
            return null;
        }
        return y().a(a2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        if (this.b != null) {
            this.b.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Bitmap bitmap) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Bundle bundle) {
        byte[] byteArrayExtra;
        this.b = (ImageView) findViewById(R.id.projectDetailsThumb);
        this.f4288a = (ImageCyclerView) findViewById(R.id.imageCycler);
        this.f4288a.setBlur(1.0f);
        Intent intent = getIntent();
        if (intent != null) {
            this.e = intent.getIntExtra("kinemaster.shareTo", 0);
            this.f4288a.b(intent);
            Bitmap a2 = ProjectGalleryActivity.a(intent.getIntExtra("projectThumb", 0));
            if (a2 == null && (byteArrayExtra = intent.getByteArrayExtra("projectThumb")) != null) {
                a2 = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
            }
            if (a2 != null) {
                a(a2);
                com.nexstreaming.kinemaster.project.f.a(intent.getData()).onResultAvailable(new ae(this));
                return;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra("projectThumb");
            if (parcelableExtra != null && (parcelableExtra instanceof Bitmap)) {
                a((Bitmap) parcelableExtra);
                com.nexstreaming.kinemaster.project.f.a(intent.getData()).onResultAvailable(new ai(this));
            } else {
                com.nexstreaming.kinemaster.project.f.a(intent.getData()).onResultAvailable(new aj(this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        if (z) {
            k();
        }
    }

    private void k() {
        ((TextView) findViewById(R.id.projectDetailsTitle)).setText(this.c.f());
        ((TextView) findViewById(R.id.projectDetailDate)).setText(this.c.c() == null ? "" : DateFormat.getMediumDateFormat(D()).format(this.c.c()));
        int d = this.c.d();
        if (d < 1000 && d >= 1) {
            d = 1000;
        }
        ((TextView) findViewById(R.id.projectDetailTime)).setText(String.format("%02d:%02d:%02d", Long.valueOf(TimeUnit.MILLISECONDS.toHours(d)), Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(d) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(d))), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(this.c.d()) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(d)))));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onStop() {
        this.f4288a.setAnimationEnabled(false);
        super.onStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onRestart() {
        this.f4288a.setAnimationEnabled(true);
        super.onRestart();
    }

    @Override // com.nextreaming.nexeditorui.ba, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.nexstreaming.kinemaster.project.f e() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ImageCyclerView f() {
        return this.f4288a;
    }

    public void b(File file, NexExportProfile nexExportProfile) {
        Uri a2 = a(file.getAbsolutePath());
        Uri fromFile = a2 == null ? Uri.fromFile(file) : a2;
        ArrayList arrayList = new ArrayList();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        Iterator<ResolveInfo> it = getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (it.hasNext()) {
            String str = it.next().activityInfo.packageName;
            if (!str.equals(getPackageName())) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("video/*");
                intent2.putExtra("android.intent.extra.STREAM", fromFile);
                intent2.setPackage(str);
                arrayList.add(intent2);
            }
        }
        Intent createChooser = Intent.createChooser((Intent) arrayList.get(0), getString(R.string.share_intent_title, new Object[]{Integer.valueOf(nexExportProfile.width()), Integer.valueOf(nexExportProfile.displayHeight())}));
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[0]));
        startActivity(createChooser);
    }

    public void c(File file, NexExportProfile nexExportProfile) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "video/*");
        startActivity(Intent.createChooser(intent, getResources().getString(R.string.play_intent_title, Integer.valueOf(nexExportProfile.width()), Integer.valueOf(nexExportProfile.displayHeight()))));
    }

    public void a(File file, NexExportProfile nexExportProfile) {
        if (d() == R.id.sns_share_other) {
            b(file, nexExportProfile);
        } else {
            new a.C0074a(this).f(R.string.save_video_to_gallery).g(getResources().getDimensionPixelOffset(R.dimen.dialog_min_height)).b(file.getAbsolutePath()).a(R.string.save_video_to_gallery_done).a(R.string.button_ok, new am(this)).c(R.string.save_play, new al(this, file, nexExportProfile)).b(R.string.save_share, new ak(this, file, nexExportProfile)).a().show();
        }
    }

    public void a(NexExportProfile nexExportProfile) {
        String c;
        SupportLogger.Event.ShareBaseActivity_Export.log(new int[0]);
        k a2 = k.a();
        com.nexstreaming.kinemaster.project.f e = e();
        File a3 = cl.a(this, nexExportProfile, e);
        if (a3.exists()) {
            SupportLogger.Event.ShareBaseActivity_ExportFileExists.log(new int[0]);
            a(a3, nexExportProfile);
            return;
        }
        SupportLogger.Event.ShareBaseActivity_BeginGetPurchases.log(new int[0]);
        SupportLogger.Event event = SupportLogger.Event.ShareBaseActivity_GetPurchasesComplete;
        int[] iArr = new int[1];
        iArr[0] = a2.b() ? 1 : 0;
        event.log(iArr);
        if (B()) {
            E().a(false);
            c = EditorGlobal.c("up");
        } else {
            E().a(true);
            c = EditorGlobal.c("std");
        }
        if (!a2.b()) {
            k.a a4 = a2.a(e.a(), a3, nexExportProfile, false, c, B(), (int) (Float.parseFloat(PreferenceManager.getDefaultSharedPreferences(D()).getString("exporting_frame_rate", "30")) * 100.0f), d(), com.nexstreaming.kinemaster.tracelog.e.c(this) ? com.nexstreaming.kinemaster.tracelog.e.e() : 0);
            SupportLogger.Event.ShareBaseActivity_MadeExportTask.log(new int[0]);
            new a().a(a4).show(getFragmentManager(), "Export");
            SupportLogger.Event.ShareBaseActivity_MadeExportDialog.log(new int[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        if (KineMasterApplication.a().a(ProjectEditActivity.class)) {
            Intent intent = new Intent(this, (Class<?>) ProjectEditActivity.class);
            intent.setFlags(603979776);
            startActivity(intent);
            overridePendingTransition(0, 0);
            return;
        }
        Intent intent2 = new Intent();
        intent2.setClassName(this, "com.nexstreaming.kinemaster.ui.share.ShareActivity");
        intent2.setFlags(603979776);
        startActivity(intent2);
        overridePendingTransition(0, 0);
    }

    private Uri a(String str) {
        Cursor query = getContentResolver().query(MediaStore.Video.Media.getContentUri("external"), new String[]{"_id"}, "_data LIKE ?", new String[]{str}, null);
        if (query.getCount() < 1) {
            return null;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_id"));
        query.close();
        return Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Task task) {
        task.onFailure(new af(this)).onProgress(new ap(this)).onComplete(new ao(this)).onSuccess(new an(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int h() {
        switch (d()) {
            case R.id.sns_share_youtube /* 2131821507 */:
                return R.string.sns_youtube;
            case R.id.sns_share_facebook /* 2131821508 */:
                return R.string.sns_facebook;
            case R.id.sns_share_gplus /* 2131821509 */:
                return R.string.sns_gplus;
            case R.id.sns_share_dropbox /* 2131821510 */:
                return R.string.sns_dropbox;
            case R.id.sns_share_wechat /* 2131821511 */:
                return R.string.sns_wechat;
            case R.id.sns_share_other /* 2131821512 */:
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        switch (d()) {
            case R.id.sns_share_youtube /* 2131821507 */:
            case R.id.sns_share_facebook /* 2131821508 */:
            case R.id.sns_share_gplus /* 2131821509 */:
            case R.id.sns_share_wechat /* 2131821511 */:
                return true;
            case R.id.sns_share_dropbox /* 2131821510 */:
                return false;
            case R.id.sns_share_other /* 2131821512 */:
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int j() {
        switch (d()) {
            case R.id.sns_share_youtube /* 2131821507 */:
                return R.drawable.n2_youtube;
            case R.id.sns_share_facebook /* 2131821508 */:
                return R.drawable.n2_2_facebook;
            case R.id.sns_share_gplus /* 2131821509 */:
                return R.drawable.n2_2_gplus;
            case R.id.sns_share_dropbox /* 2131821510 */:
                return R.drawable.n2_2_dropbox_btn;
            case R.id.sns_share_wechat /* 2131821511 */:
                return R.drawable.n2_2_wechat;
            case R.id.sns_share_other /* 2131821512 */:
            default:
                return 0;
        }
    }
}
