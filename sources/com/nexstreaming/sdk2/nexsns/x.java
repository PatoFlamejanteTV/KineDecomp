package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.plus.PlusShare;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GooglePlus.java */
/* loaded from: classes.dex */
public class x extends SNS {

    /* renamed from: a, reason: collision with root package name */
    private final int f4442a;
    private Activity b;

    public x(Activity activity) {
        super(activity);
        this.f4442a = 2;
        this.b = activity;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ad a(File file) {
        try {
            return new a(this, file, null);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public Task f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a_(Bundle bundle) {
    }

    /* compiled from: GooglePlus.java */
    /* loaded from: classes.dex */
    private class a implements ad {
        private Uri b;
        private String c;
        private String d;

        /* synthetic */ a(x xVar, File file, y yVar) throws FileNotFoundException {
            this(file);
        }

        private a(File file) throws FileNotFoundException {
            if (file.exists()) {
                this.b = x.this.a(file.getAbsolutePath(), x.this.b.getContentResolver());
                this.c = x.this.b.getContentResolver().getType(this.b);
                Log.d("GooglePlus", "Google Plus Uri and MimeType : " + this.b + " " + this.c);
                return;
            }
            throw new FileNotFoundException(file.toString());
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public Task a() {
            return x.this.a(this.b, this.c, this.d);
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public ad a(String str) {
            this.d = str;
            Log.d("GooglePlus", "Title : " + this.d);
            return this;
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public ad b(String str) {
            return this;
        }

        public String toString() {
            return "[GooglePlusUploadBuilder " + this.b + "]";
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public ad a(Privacy privacy) {
            return this;
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public ad a(List<String> list) {
            return this;
        }

        @Override // com.nexstreaming.sdk2.nexsns.ad
        public ad a(ac acVar) {
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task a(Uri uri, String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Task task = new Task();
        if (!p()) {
            task.sendFailure(new y(this));
        } else {
            Log.d("GooglePlus", "Google Plus uploadTask activity ; " + this.b);
            if (uri == null || str == null) {
                task.sendFailure(new z(this));
            } else {
                PlusShare.Builder builder = new PlusShare.Builder(this.b);
                builder.a((CharSequence) str2);
                builder.b(uri);
                builder.a(str);
                this.b.startActivityForResult(builder.a(), 2);
                task.signalEvent(Task.Event.SUCCESS);
            }
        }
        return task;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void n() {
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a(Activity activity, int i, int i2, Intent intent) {
    }

    public boolean p() {
        boolean z = true;
        try {
            ApplicationInfo applicationInfo = this.b.getPackageManager().getApplicationInfo("com.google.android.apps.plus", 0);
            Log.d("GooglePlus", "Google Plus app installed!!! ");
            if (applicationInfo.enabled) {
                Log.d("GooglePlus", "Google Plus app is enabled!!! ");
            } else if (!applicationInfo.enabled) {
                Log.d("GooglePlus", "Google Plus app is disabled!!! ");
                z = false;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("GooglePlus", "Google Plus app not installed!!! ");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri a(String str, ContentResolver contentResolver) {
        Uri contentUri = MediaStore.Video.Media.getContentUri("external");
        String[] strArr = {"_id", ShareConstants.WEB_DIALOG_PARAM_TITLE, "date_added", "mime_type", "_size", "bucket_display_name", "_data"};
        Cursor query = contentResolver.query(contentUri, strArr, "_data LIKE ?", new String[]{str}, null);
        if (query.getCount() < 1) {
            return null;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex(strArr[0]));
        query.close();
        return Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, string);
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public SNS.PrivacyManagementProfile h() {
        return SNS.PrivacyManagementProfile.MANAGED_BY_SNS;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public int e() {
        return 0;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String a(int i) {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean a() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean b() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean c() {
        return true;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean d() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public List<Privacy> i() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ResultTask<List<ac>> j() {
        ResultTask<List<ac>> resultTask = new ResultTask<>();
        resultTask.sendResult(Collections.emptyList());
        return resultTask;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b_(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c_(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String g() {
        return null;
    }
}
