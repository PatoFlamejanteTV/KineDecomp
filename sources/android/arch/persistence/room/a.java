package android.arch.persistence.room;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import b.a.b.a.c;
import java.util.List;
import java.util.Set;

/* compiled from: DatabaseConfiguration.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public final c.InterfaceC0008c f74a;

    /* renamed from: b */
    public final Context f75b;

    /* renamed from: c */
    public final String f76c;

    /* renamed from: d */
    public final RoomDatabase.c f77d;

    /* renamed from: e */
    public final List<RoomDatabase.b> f78e;

    /* renamed from: f */
    public final boolean f79f;

    /* renamed from: g */
    public final RoomDatabase.JournalMode f80g;

    /* renamed from: h */
    public final boolean f81h;
    private final Set<Integer> i;

    public a(Context context, String str, c.InterfaceC0008c interfaceC0008c, RoomDatabase.c cVar, List<RoomDatabase.b> list, boolean z, RoomDatabase.JournalMode journalMode, boolean z2, Set<Integer> set) {
        this.f74a = interfaceC0008c;
        this.f75b = context;
        this.f76c = str;
        this.f77d = cVar;
        this.f78e = list;
        this.f79f = z;
        this.f80g = journalMode;
        this.f81h = z2;
        this.i = set;
    }

    public boolean a(int i) {
        Set<Integer> set;
        return this.f81h && ((set = this.i) == null || !set.contains(Integer.valueOf(i)));
    }
}
