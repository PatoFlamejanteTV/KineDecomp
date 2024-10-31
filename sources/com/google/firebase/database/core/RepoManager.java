package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
/* loaded from: classes2.dex */
public class RepoManager {

    /* renamed from: a, reason: collision with root package name */
    private static final RepoManager f16923a = new RepoManager();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Context, Map<String, Repo>> f16924b = new HashMap();

    public static Repo a(Context context, RepoInfo repoInfo, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return f16923a.b(context, repoInfo, firebaseDatabase);
    }

    private Repo b(Context context, RepoInfo repoInfo, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        Repo repo;
        context.b();
        String str = "https://" + repoInfo.f16919a + "/" + repoInfo.f16921c;
        synchronized (this.f16924b) {
            if (!this.f16924b.containsKey(context)) {
                this.f16924b.put(context, new HashMap());
            }
            Map<String, Repo> map = this.f16924b.get(context);
            if (!map.containsKey(str)) {
                repo = new Repo(repoInfo, context, firebaseDatabase);
                map.put(str, repo);
            } else {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
        }
        return repo;
    }
}
