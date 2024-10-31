package c.d.b.b;

import android.content.Context;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/* compiled from: FirebaseManager.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3609a = "i";

    /* renamed from: b, reason: collision with root package name */
    private static i f3610b;

    /* renamed from: c, reason: collision with root package name */
    private static k f3611c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f3612d;

    /* renamed from: e, reason: collision with root package name */
    private final d f3613e;

    /* renamed from: f, reason: collision with root package name */
    private final b f3614f = new b();

    /* compiled from: FirebaseManager.java */
    /* loaded from: classes.dex */
    public static class a implements ValueEventListener {

        /* renamed from: a, reason: collision with root package name */
        private final DatabaseReference f3615a;

        public a(String str) {
            this.f3615a = i.a(str);
            this.f3615a.b(this);
        }

        public void a() {
            this.f3615a.c(this);
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void a(DatabaseError databaseError) {
            Log.e(i.f3609a, "[DatabaseReference][onCancelled] error: " + databaseError, databaseError.b());
        }
    }

    /* compiled from: FirebaseManager.java */
    /* loaded from: classes.dex */
    public class b extends a {

        /* renamed from: b, reason: collision with root package name */
        private int f3616b;

        public b() {
            super(String.format("privacy_version_android", new Object[0]));
            this.f3616b = 0;
        }

        @Override // com.google.firebase.database.ValueEventListener
        public void a(DataSnapshot dataSnapshot) {
            if (!dataSnapshot.a()) {
                Log.w(i.f3609a, "[PrivacyVersionWrapper][onDataChange] data does not exist!");
                return;
            }
            this.f3616b = ((Integer) dataSnapshot.a(Integer.class)).intValue();
            Log.w(i.f3609a, "[PrivacyVersionWrapper] Policy version: " + this.f3616b);
        }

        public int b() {
            return this.f3616b;
        }
    }

    private i(Context context) {
        this.f3612d = context.getApplicationContext();
        this.f3613e = new d(this.f3612d);
        if (c.d.b.c.a.d(context)) {
            b(context);
        }
    }

    private static void b(Context context) {
        f3611c = new k(context);
    }

    public static b c() {
        i iVar = f3610b;
        if (iVar != null) {
            return iVar.f3614f;
        }
        throw new IllegalStateException("FirebaseApp is not initialized.");
    }

    public static k d() {
        i iVar = f3610b;
        if (iVar != null) {
            if (f3611c == null && c.d.b.c.a.d(iVar.f3612d)) {
                b(f3610b.f3612d);
            }
            i iVar2 = f3610b;
            return f3611c;
        }
        throw new IllegalStateException("FirebaseApp is not initialized.");
    }

    public static void a(Context context) {
        if (f3610b == null) {
            f3610b = new i(context);
        }
    }

    public static d b() {
        i iVar = f3610b;
        if (iVar != null) {
            return iVar.f3613e;
        }
        throw new IllegalStateException("FirebaseApp is not initialized.");
    }

    public static DatabaseReference a(String str) {
        return FirebaseDatabase.a().a(str);
    }

    public static StorageReference b(String str) {
        return FirebaseStorage.b().a(str);
    }
}
