package com.firebase.ui.auth.provider;

import android.text.TextUtils;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

/* loaded from: classes.dex */
public final class ProviderUtils {
    private static final String TAG = "ProviderUtils";

    private ProviderUtils() {
        throw new AssertionError("No instance for you!");
    }

    public static Task<String> fetchTopProvider(FirebaseAuth firebaseAuth, String str) {
        if (TextUtils.isEmpty(str)) {
            return Tasks.a((Exception) new NullPointerException("Email cannot be empty"));
        }
        return firebaseAuth.a(str).a(new TaskFailureLogger(TAG, "Error fetching providers for email")).a((Continuation<ProviderQueryResult, TContinuationResult>) new Continuation<ProviderQueryResult, String>() { // from class: com.firebase.ui.auth.provider.ProviderUtils.1
            @Override // com.google.android.gms.tasks.Continuation
            public String then(Task<ProviderQueryResult> task) throws Exception {
                List<String> a2;
                if (!task.e() || (a2 = task.b().a()) == null || a2.isEmpty()) {
                    return null;
                }
                return a2.get(a2.size() - 1);
            }
        });
    }

    public static AuthCredential getAuthCredential(IdpResponse idpResponse) {
        return null;
    }
}
