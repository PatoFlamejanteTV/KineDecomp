package com.nexstreaming.kinemaster.ui.share;

import android.arch.persistence.room.RoomDatabase;
import android.database.Cursor;
import java.util.ArrayList;

/* compiled from: ExportedVideoDao_Impl.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2210ba implements W {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f23326a;

    /* renamed from: b, reason: collision with root package name */
    private final android.arch.persistence.room.c f23327b;

    /* renamed from: c, reason: collision with root package name */
    private final android.arch.persistence.room.b f23328c;

    /* renamed from: d, reason: collision with root package name */
    private final android.arch.persistence.room.j f23329d;

    /* renamed from: e, reason: collision with root package name */
    private final android.arch.persistence.room.j f23330e;

    public C2210ba(RoomDatabase roomDatabase) {
        this.f23326a = roomDatabase;
        this.f23327b = new X(this, roomDatabase);
        this.f23328c = new Y(this, roomDatabase);
        this.f23329d = new Z(this, roomDatabase);
        this.f23330e = new C2208aa(this, roomDatabase);
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public void a(V v) {
        this.f23326a.b();
        try {
            this.f23327b.a((android.arch.persistence.room.c) v);
            this.f23326a.i();
        } finally {
            this.f23326a.d();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public int b(V v) {
        this.f23326a.b();
        try {
            int a2 = this.f23328c.a((android.arch.persistence.room.b) v) + 0;
            this.f23326a.i();
            return a2;
        } finally {
            this.f23326a.d();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public int a(ArrayList<V> arrayList) {
        this.f23326a.b();
        try {
            int a2 = this.f23328c.a((Iterable) arrayList) + 0;
            this.f23326a.i();
            return a2;
        } finally {
            this.f23326a.d();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public V[] b(String str) {
        android.arch.persistence.room.i a2 = android.arch.persistence.room.i.a("SELECT * FROM videos WHERE projectName LIKE ? ORDER BY id DESC", 1);
        if (str == null) {
            a2.f(1);
        } else {
            a2.a(1, str);
        }
        Cursor a3 = this.f23326a.a(a2);
        try {
            int columnIndexOrThrow = a3.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = a3.getColumnIndexOrThrow("projectName");
            int columnIndexOrThrow3 = a3.getColumnIndexOrThrow("projectVersion");
            int columnIndexOrThrow4 = a3.getColumnIndexOrThrow("creationTime");
            int columnIndexOrThrow5 = a3.getColumnIndexOrThrow("path");
            int columnIndexOrThrow6 = a3.getColumnIndexOrThrow("width");
            int columnIndexOrThrow7 = a3.getColumnIndexOrThrow("height");
            int columnIndexOrThrow8 = a3.getColumnIndexOrThrow("useMuserkAudio");
            int columnIndexOrThrow9 = a3.getColumnIndexOrThrow("lastEditTime");
            V[] vArr = new V[a3.getCount()];
            int i = 0;
            while (a3.moveToNext()) {
                V v = new V();
                v.f23312a = a3.getInt(columnIndexOrThrow);
                v.f23313b = a3.getString(columnIndexOrThrow2);
                v.f23314c = a3.getInt(columnIndexOrThrow3);
                int i2 = columnIndexOrThrow2;
                int i3 = columnIndexOrThrow3;
                v.f23315d = a3.getLong(columnIndexOrThrow4);
                v.f23316e = a3.getString(columnIndexOrThrow5);
                v.f23317f = a3.getInt(columnIndexOrThrow6);
                v.f23318g = a3.getInt(columnIndexOrThrow7);
                v.f23319h = a3.getInt(columnIndexOrThrow8) != 0;
                v.i = a3.getLong(columnIndexOrThrow9);
                vArr[i] = v;
                i++;
                columnIndexOrThrow2 = i2;
                columnIndexOrThrow3 = i3;
            }
            return vArr;
        } finally {
            a3.close();
            a2.b();
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public void a(String str, String str2) {
        b.a.b.a.f a2 = this.f23329d.a();
        this.f23326a.b();
        try {
            if (str2 == null) {
                a2.f(1);
            } else {
                a2.a(1, str2);
            }
            if (str == null) {
                a2.f(2);
            } else {
                a2.a(2, str);
            }
            a2.D();
            this.f23326a.i();
        } finally {
            this.f23326a.d();
            this.f23329d.a(a2);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.share.W
    public void a(String str) {
        b.a.b.a.f a2 = this.f23330e.a();
        this.f23326a.b();
        try {
            if (str == null) {
                a2.f(1);
            } else {
                a2.a(1, str);
            }
            a2.D();
            this.f23326a.i();
        } finally {
            this.f23326a.d();
            this.f23330e.a(a2);
        }
    }
}
