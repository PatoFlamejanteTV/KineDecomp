package android.arch.persistence.room;

import android.arch.persistence.room.e;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InvalidationTracker.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar) {
        this.f105a = eVar;
    }

    private boolean b() {
        RoomDatabase roomDatabase;
        Object[] objArr;
        roomDatabase = this.f105a.f112g;
        objArr = this.f105a.f110e;
        Cursor a2 = roomDatabase.a("SELECT * FROM room_table_modification_log WHERE version  > ? ORDER BY version ASC;", objArr);
        boolean z = false;
        while (a2.moveToNext()) {
            try {
                long j = a2.getLong(0);
                this.f105a.f109d[a2.getInt(1)] = j;
                this.f105a.f111f = j;
                z = true;
            } finally {
                a2.close();
            }
        }
        return z;
    }

    @Override // java.lang.Runnable
    public void run() {
        RoomDatabase roomDatabase;
        boolean b2;
        RoomDatabase roomDatabase2;
        b.a.b.a.f fVar;
        Object[] objArr;
        long j;
        RoomDatabase roomDatabase3;
        RoomDatabase roomDatabase4;
        roomDatabase = this.f105a.f112g;
        Lock e2 = roomDatabase.e();
        boolean z = false;
        try {
            try {
                e2.lock();
                b2 = this.f105a.b();
            } catch (SQLiteException | IllegalStateException e3) {
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e3);
            }
            if (b2) {
                if (this.f105a.f113h.compareAndSet(true, false)) {
                    roomDatabase2 = this.f105a.f112g;
                    if (roomDatabase2.g()) {
                        return;
                    }
                    fVar = this.f105a.j;
                    fVar.D();
                    objArr = this.f105a.f110e;
                    j = this.f105a.f111f;
                    objArr[0] = Long.valueOf(j);
                    roomDatabase3 = this.f105a.f112g;
                    if (roomDatabase3.f62e) {
                        roomDatabase4 = this.f105a.f112g;
                        b.a.b.a.b a2 = roomDatabase4.f().a();
                        try {
                            a2.C();
                            z = b();
                            a2.E();
                            a2.F();
                        } catch (Throwable th) {
                            a2.F();
                            throw th;
                        }
                    } else {
                        z = b();
                    }
                    if (z) {
                        synchronized (this.f105a.l) {
                            Iterator<Map.Entry<e.b, e.c>> it = this.f105a.l.iterator();
                            while (it.hasNext()) {
                                it.next().getValue().a(this.f105a.f109d);
                            }
                        }
                    }
                }
            }
        } finally {
            e2.unlock();
        }
    }
}
