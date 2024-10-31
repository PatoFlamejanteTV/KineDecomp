package com.nexstreaming.kinemaster.mediastore.v2.scanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaDbHelper.java */
/* loaded from: classes.dex */
public class g extends SQLiteOpenHelper {
    public g(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE entry (_id INTEGER PRIMARY KEY,bucket_id INTEGER,bucket_name TEXT,path TEXT UNIQUE NOT NULL,title TEXT,media_type TEXT,possible_garbage INTEGER DEFAULT 0,width INTEGER DEFAULT 0,height INTEGER DEFAULT 0,size INTEGER DEFAULT 0,has_audio INTEGER DEFAULT 0,has_video INTEGER DEFAULT 0,date_created INTEGER DEFAULT 0,date_modified INTEGER DEFAULT 0,date_taken INTEGER DEFAULT 0,fps INTEGER DEFAULT 0,orientation INTEGER DEFAULT 0,duration INTEGER DEFAULT 0,thumbnail BLOB,support_type INTEGER DEFAULT 0 )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS entry");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }
}
