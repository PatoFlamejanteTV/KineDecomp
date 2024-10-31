package com.nexstreaming.sdk2.nexsns;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.sdk2.nexsns.SNS;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: Youtube.java */
/* loaded from: classes.dex */
public class ag extends SNS {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Activity> f4418a;
    private Task b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(Activity activity) {
        super(activity);
        this.f4418a = new WeakReference<>(activity);
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
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public boolean d() {
        return false;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public int e() {
        return 0;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c_(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String a(int i) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b_(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void c(String str) {
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ad a(File file) {
        Activity activity = this.f4418a.get();
        if (activity == null) {
            throw new RuntimeException("Activiy lost");
        }
        Uri a2 = a(file, activity.getContentResolver());
        if (a2 == null) {
            throw new RuntimeException("Media not indexed");
        }
        return a(a2);
    }

    private Uri a(File file, ContentResolver contentResolver) {
        Uri contentUri = MediaStore.Video.Media.getContentUri("external");
        Cursor query = contentResolver.query(contentUri, new String[]{"_id"}, "_data LIKE ?", new String[]{file.getAbsolutePath()}, null);
        if (query.getCount() < 1) {
            return null;
        }
        query.moveToFirst();
        long j = query.getLong(query.getColumnIndex("_id"));
        query.close();
        return Uri.withAppendedPath(contentUri, String.valueOf(j));
    }

    public ad a(Uri uri) {
        return new ah(this, uri);
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public Task f() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public String g() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public SNS.PrivacyManagementProfile h() {
        return SNS.PrivacyManagementProfile.MANAGED_BY_SNS;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public List<Privacy> i() {
        return null;
    }

    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public ResultTask<List<ac>> j() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a_(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void k() {
        if (this.b != null) {
            this.b = null;
        }
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void o() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void b(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.sdk2.nexsns.SNS
    public void a(Activity activity, int i, int i2, Intent intent) {
    }
}
