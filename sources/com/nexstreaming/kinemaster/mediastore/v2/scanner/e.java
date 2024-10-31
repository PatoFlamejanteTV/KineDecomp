package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaDb.java */
/* loaded from: classes.dex */
public class e extends AsyncTask<Void, Void, Void> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3613a;
    final /* synthetic */ Bitmap b;
    final /* synthetic */ MediaDb c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MediaDb mediaDb, File file, Bitmap bitmap) {
        this.c = mediaDb;
        this.f3613a = file;
        this.b = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        g gVar;
        String[] strArr = {this.f3613a.getAbsolutePath()};
        gVar = this.c.f3602a;
        SQLiteDatabase writableDatabase = gVar.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (this.b == null) {
            contentValues.put("thumbnail", new byte[0]);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.b.compress(f.f3614a, 80, byteArrayOutputStream);
            contentValues.put("thumbnail", byteArrayOutputStream.toByteArray());
        }
        try {
            writableDatabase.update("entry", contentValues, "path=?", strArr);
            return null;
        } catch (SQLiteFullException e) {
            e.printStackTrace();
            return null;
        }
    }
}
