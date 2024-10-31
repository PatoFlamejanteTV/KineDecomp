package com.nexstreaming.app.general.norm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: NormDb.java */
/* loaded from: classes2.dex */
public abstract class b extends SQLiteOpenHelper {

    /* renamed from: a */
    private final Gson f19650a;

    public b(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f19650a = new Gson();
    }

    public static String a(String str) {
        String lowerCase = str.replaceAll("(?<=[A-Z])(?=[A-Z][a-z])|(?<=[^A-Z])(?=[A-Z])|(?<=[A-Za-z])(?=[^A-Za-z])", io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR).toLowerCase(Locale.ENGLISH);
        if (lowerCase.length() < 1) {
            return io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR;
        }
        char charAt = lowerCase.charAt(0);
        if (charAt == '_') {
            return lowerCase;
        }
        if (charAt >= 'a' && charAt <= 'z') {
            return lowerCase;
        }
        return io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + lowerCase;
    }

    private <T extends c> ContentValues e(T t) {
        ContentValues contentValues = new ContentValues();
        try {
            for (NormColumnInfo normColumnInfo : t.getTableInfo().b()) {
                if (normColumnInfo != null && !normColumnInfo.f19647g) {
                    String str = null;
                    byte[] bArr = null;
                    byte[] bArr2 = null;
                    switch (a.f19649a[normColumnInfo.f19643c.ordinal()]) {
                        case 1:
                            Object obj = normColumnInfo.f19642b.get(t);
                            if (obj == null) {
                                contentValues.putNull(normColumnInfo.f19641a);
                                break;
                            } else {
                                contentValues.put(normColumnInfo.f19641a, String.valueOf(obj));
                                break;
                            }
                        case 2:
                            contentValues.put(normColumnInfo.f19641a, Integer.valueOf(normColumnInfo.f19642b.getInt(t)));
                            break;
                        case 3:
                            if (normColumnInfo.f19646f) {
                                Object obj2 = normColumnInfo.f19642b.get(t);
                                if (obj2 instanceof c) {
                                    contentValues.put(normColumnInfo.f19641a, Long.valueOf(((c) obj2).getDbRowID()));
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                contentValues.put(normColumnInfo.f19641a, Long.valueOf(normColumnInfo.f19642b.getLong(t)));
                                break;
                            }
                        case 4:
                            contentValues.put(normColumnInfo.f19641a, Double.valueOf(normColumnInfo.f19642b.getDouble(t)));
                            break;
                        case 5:
                            contentValues.put(normColumnInfo.f19641a, Float.valueOf(normColumnInfo.f19642b.getFloat(t)));
                            break;
                        case 6:
                            Enum r6 = (Enum) normColumnInfo.f19642b.get(t);
                            String str2 = normColumnInfo.f19641a;
                            if (r6 != null) {
                                str = r6.name();
                            }
                            contentValues.put(str2, str);
                            break;
                        case 7:
                            contentValues.put(normColumnInfo.f19641a, Integer.valueOf(normColumnInfo.f19642b.getBoolean(t) ? 1 : 0));
                            break;
                        case 8:
                            contentValues.put(normColumnInfo.f19641a, (byte[]) normColumnInfo.f19642b.get(t));
                            break;
                        case 9:
                            Bitmap bitmap = (Bitmap) normColumnInfo.f19642b.get(t);
                            if (bitmap != null) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                bArr2 = byteArrayOutputStream.toByteArray();
                            }
                            contentValues.put(normColumnInfo.f19641a, bArr2);
                            break;
                        case 10:
                            Bitmap bitmap2 = (Bitmap) normColumnInfo.f19642b.get(t);
                            if (bitmap2 != null) {
                                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                bitmap2.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream2);
                                bArr = byteArrayOutputStream2.toByteArray();
                            }
                            contentValues.put(normColumnInfo.f19641a, bArr);
                            break;
                        case 11:
                            contentValues.put(normColumnInfo.f19641a, this.f19650a.toJson(normColumnInfo.f19642b.get(t)));
                            break;
                    }
                }
            }
            return contentValues;
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public <T extends c> void b(T t) {
        a((b) t, getWritableDatabase().insertWithOnConflict(t.getTableInfo().f(), null, e(t), 5));
    }

    public <T extends c> long c(Class<T> cls, String str, Object... objArr) {
        List<T> d2 = d(cls, str + " LIMIT 1", objArr);
        if (d2 == null || d2.isEmpty()) {
            return 0L;
        }
        return d2.get(0).getDbRowID();
    }

    protected abstract Class<? extends c>[] c();

    public <T extends c> void d(T t) {
        try {
            getWritableDatabase().update(t.getTableInfo().f(), e(t), "_id = ?", new String[]{String.valueOf(t.getTableInfo().e().f19642b.getLong(t))});
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        for (Class<? extends c> cls : c()) {
            for (String str : e.a(cls).c()) {
                Log.d("NormDb", "CreateTable:" + str);
                sQLiteDatabase.execSQL(str);
                Log.d("NormDb", "Created");
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 11) {
            for (Class<? extends c> cls : c()) {
                for (String str : e.a(cls).d()) {
                    Log.d("NormDb", "DropTable:" + str);
                    sQLiteDatabase.execSQL(str);
                    Log.d("NormDb", "Dropped");
                }
            }
            onCreate(sQLiteDatabase);
            return;
        }
        if (i < i2) {
            try {
                try {
                    sQLiteDatabase.beginTransaction();
                    for (Class<? extends c> cls2 : c()) {
                        for (String str2 : e.a(cls2).a(i)) {
                            Log.d("NormDb", "Upgrade: " + str2 + " START");
                            sQLiteDatabase.execSQL(str2);
                            Log.d("NormDb", "Upgrade: " + str2 + " END");
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } catch (SQLiteException e2) {
                    Log.e("NormDb", "Can't upgrade database.", e2);
                }
            } finally {
                sQLiteDatabase.endTransaction();
            }
        }
    }

    public <T extends c> T b(Class<T> cls, String str, Object... objArr) {
        List<T> d2 = d(cls, str + " LIMIT 1", objArr);
        if (d2 == null || d2.isEmpty()) {
            return null;
        }
        return d2.get(0);
    }

    public <T extends c> void c(T t) {
        getWritableDatabase().delete(t.getTableInfo().f(), t.getTableInfo().e() + " = ?", new String[]{String.valueOf(t.getDbRowID())});
    }

    private <T extends c> void a(T t, long j) {
        try {
            t.getTableInfo().e().f19642b.setLong(t, j);
            t.addedOrUpdatedToDb = true;
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public <T extends c> List<T> d(Class<T> cls, String str, Object... objArr) {
        return b(cls, str, objArr, true);
    }

    private <T extends c> List<T> b(Class<T> cls, String str, Object[] objArr, boolean z) {
        return a(cls, str, objArr, z, null);
    }

    public void d() {
        getWritableDatabase().setTransactionSuccessful();
    }

    public <T extends c> void a(T t) {
        a((b) t, getWritableDatabase().insert(t.getTableInfo().f(), null, e(t)));
    }

    public void b() {
        getWritableDatabase().endTransaction();
    }

    public <T extends c> T a(Class<T> cls, long j) {
        List<T> d2 = d(cls, e.a((Class<? extends c>) cls).e().f19641a + " = ? LIMIT 1", Long.valueOf(j));
        if (d2 == null || d2.isEmpty()) {
            return null;
        }
        return d2.get(0);
    }

    public <T extends c> List<T> a(Class<T> cls) {
        return b(cls, null, null, true);
    }

    public <T extends c> List<T> a(Class<T> cls, String str, String str2, Object... objArr) {
        return a(cls, str, objArr, true, str2);
    }

    public <T extends c> int a(Class<T> cls, String str, Object... objArr) {
        return a((Class) cls, str, objArr, false);
    }

    private <T extends c> int a(Class<T> cls, String str, Object[] objArr, boolean z) {
        String[] strArr;
        if (objArr != null) {
            strArr = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr[i] = String.valueOf(objArr[i]);
            }
        } else {
            strArr = null;
        }
        e a2 = e.a((Class<? extends c>) cls);
        Cursor query = getReadableDatabase().query(a2.f(), new String[]{a2.e().f19641a}, str, strArr, null, null, null);
        int count = query.getCount();
        query.close();
        return count;
    }

    private <T extends c> List<T> a(Class<T> cls, String str, Object[] objArr, boolean z, String str2) {
        String[] strArr;
        if (objArr != null) {
            String[] strArr2 = new String[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                strArr2[i] = String.valueOf(objArr[i]);
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        e a2 = e.a((Class<? extends c>) cls);
        NormColumnInfo[] b2 = a2.b();
        Cursor query = getReadableDatabase().query(a2.f(), a2.a(), str, strArr, null, null, str2);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        try {
            try {
                query.moveToPosition(-1);
                while (query.moveToNext()) {
                    T newInstance = cls.newInstance();
                    for (int i2 = 0; i2 < b2.length; i2++) {
                        switch (a.f19649a[b2[i2].f19643c.ordinal()]) {
                            case 1:
                                b2[i2].f19642b.set(newInstance, query.getString(i2));
                                break;
                            case 2:
                                b2[i2].f19642b.setInt(newInstance, query.getInt(i2));
                                break;
                            case 3:
                                if (b2[i2].f19646f) {
                                    if (z) {
                                        if (!hashMap.containsKey(b2[i2].j)) {
                                            hashMap.put(b2[i2].j, new HashMap());
                                        }
                                        long j = query.getLong(query.getColumnIndex(b2[i2].f19641a));
                                        Object obj = ((Map) hashMap.get(b2[i2].j)).get(Long.valueOf(j));
                                        if (obj == null) {
                                            obj = a((Class<Object>) b2[i2].j, j);
                                            ((Map) hashMap.get(b2[i2].j)).put(Long.valueOf(j), obj);
                                        }
                                        b2[i2].f19642b.set(newInstance, obj);
                                        break;
                                    } else {
                                        break;
                                    }
                                } else {
                                    b2[i2].f19642b.setLong(newInstance, query.getLong(i2));
                                    break;
                                }
                            case 4:
                                b2[i2].f19642b.setDouble(newInstance, query.getDouble(i2));
                                break;
                            case 5:
                                b2[i2].f19642b.setFloat(newInstance, query.getFloat(i2));
                                break;
                            case 6:
                                Class<?> type = b2[i2].f19642b.getType();
                                String string = query.getString(i2);
                                if (string != null) {
                                    try {
                                        b2[i2].f19642b.set(newInstance, Enum.valueOf(type, string));
                                        break;
                                    } catch (IllegalArgumentException unused) {
                                        b2[i2].f19642b.set(newInstance, null);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            case 7:
                                b2[i2].f19642b.setBoolean(newInstance, query.getInt(i2) != 0);
                                break;
                            case 8:
                                b2[i2].f19642b.set(newInstance, query.getBlob(i2));
                                break;
                            case 9:
                            case 10:
                                byte[] blob = query.getBlob(i2);
                                b2[i2].f19642b.set(newInstance, BitmapFactory.decodeByteArray(blob, 0, blob.length));
                                break;
                            case 11:
                                b2[i2].f19642b.set(newInstance, this.f19650a.fromJson(query.getString(i2), b2[i2].f19642b.getGenericType()));
                                break;
                        }
                    }
                    arrayList.add(newInstance);
                }
                return arrayList;
            } catch (IllegalAccessException e2) {
                throw new IllegalStateException(e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            }
        } finally {
            query.close();
        }
    }

    public void a() {
        getWritableDatabase().beginTransaction();
    }
}
