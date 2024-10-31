package com.google.firebase.database;

import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class FirebaseDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Map<RepoInfo, FirebaseDatabase>> f16635a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final FirebaseApp f16636b;

    /* renamed from: c, reason: collision with root package name */
    private final RepoInfo f16637c;

    /* renamed from: d, reason: collision with root package name */
    private final DatabaseConfig f16638d;

    /* renamed from: e, reason: collision with root package name */
    private Repo f16639e;

    private FirebaseDatabase(FirebaseApp firebaseApp, RepoInfo repoInfo, DatabaseConfig databaseConfig) {
        this.f16636b = firebaseApp;
        this.f16637c = repoInfo;
        this.f16638d = databaseConfig;
    }

    @PublicApi
    public static FirebaseDatabase a() {
        FirebaseApp c2 = FirebaseApp.c();
        if (c2 != null) {
            return a(c2, c2.e().c());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    @PublicApi
    public static String b() {
        return "3.0.0";
    }

    private synchronized void c() {
        if (this.f16639e == null) {
            this.f16639e = RepoManager.a(this.f16638d, this.f16637c, this);
        }
    }

    @PublicApi
    public static synchronized FirebaseDatabase a(FirebaseApp firebaseApp, String str) {
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (!TextUtils.isEmpty(str)) {
                Map<RepoInfo, FirebaseDatabase> map = f16635a.get(firebaseApp.d());
                if (map == null) {
                    map = new HashMap<>();
                    f16635a.put(firebaseApp.d(), map);
                }
                ParsedUrl a2 = Utilities.a(str);
                if (a2.f17062b.isEmpty()) {
                    firebaseDatabase = map.get(a2.f17061a);
                    if (firebaseDatabase == null) {
                        DatabaseConfig databaseConfig = new DatabaseConfig();
                        if (!firebaseApp.h()) {
                            databaseConfig.c(firebaseApp.d());
                        }
                        databaseConfig.a(firebaseApp);
                        FirebaseDatabase firebaseDatabase2 = new FirebaseDatabase(firebaseApp, a2.f17061a, databaseConfig);
                        map.put(a2.f17061a, firebaseDatabase2);
                        firebaseDatabase = firebaseDatabase2;
                    }
                } else {
                    throw new DatabaseException("Specified Database URL '" + str + "' is invalid. It should point to the root of a Firebase Database but it includes a path: " + a2.f17062b.toString());
                }
            } else {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
        }
        return firebaseDatabase;
    }

    @PublicApi
    public DatabaseReference a(String str) {
        c();
        if (str != null) {
            Validation.b(str);
            return new DatabaseReference(this.f16639e, new Path(str));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
    }
}
