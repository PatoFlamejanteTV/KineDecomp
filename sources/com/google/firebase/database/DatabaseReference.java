package com.google.firebase.database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public class DatabaseReference extends Query {

    /* compiled from: com.google.firebase:firebase-database@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public interface CompletionListener {
        @PublicApi
        void a(DatabaseError databaseError, DatabaseReference databaseReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    @PublicApi
    public DatabaseReference a(String str) {
        if (str != null) {
            if (a().isEmpty()) {
                Validation.b(str);
            } else {
                Validation.a(str);
            }
            return new DatabaseReference(this.f16642a, a().e(new Path(str)));
        }
        throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
    }

    @PublicApi
    public String c() {
        if (a().isEmpty()) {
            return null;
        }
        return a().d().a();
    }

    @PublicApi
    public DatabaseReference d() {
        Path parent = a().getParent();
        if (parent != null) {
            return new DatabaseReference(this.f16642a, parent);
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        DatabaseReference d2 = d();
        if (d2 == null) {
            return this.f16642a.toString();
        }
        try {
            return d2.toString() + "/" + URLEncoder.encode(c(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e2) {
            throw new DatabaseException("Failed to URLEncode key: " + c(), e2);
        }
    }

    @PublicApi
    public Task<Void> a(Map<String, Object> map) {
        return a(map, null);
    }

    private Task<Void> a(Map<String, Object> map, CompletionListener completionListener) {
        if (map != null) {
            Map<String, Object> a2 = CustomClassMapper.a(map);
            CompoundWrite a3 = CompoundWrite.a(Validation.a(a(), a2));
            Pair<Task<Void>, CompletionListener> a4 = Utilities.a(completionListener);
            this.f16642a.b(new a(this, a3, a4, a2));
            return a4.a();
        }
        throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
    }
}
