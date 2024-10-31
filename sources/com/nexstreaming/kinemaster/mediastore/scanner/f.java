package com.nexstreaming.kinemaster.mediastore.scanner;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* compiled from: MediaDb.java */
/* loaded from: classes.dex */
public class f extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ File f21083a;

    /* renamed from: b */
    final /* synthetic */ Bitmap f21084b;

    /* renamed from: c */
    final /* synthetic */ MediaDb f21085c;

    public f(MediaDb mediaDb, File file, Bitmap bitmap) {
        this.f21085c = mediaDb;
        this.f21083a = file;
        this.f21084b = bitmap;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        h hVar;
        String[] strArr = {this.f21083a.getAbsolutePath()};
        hVar = this.f21085c.f21042c;
        SQLiteDatabase writableDatabase = hVar.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (this.f21084b == null) {
            contentValues.put("thumbnail", new byte[0]);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.f21084b.compress(g.f21086a, 80, byteArrayOutputStream);
            contentValues.put("thumbnail", byteArrayOutputStream.toByteArray());
        }
        try {
            writableDatabase.update("entry", contentValues, "path=?", strArr);
            return null;
        } catch (SQLiteFullException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
