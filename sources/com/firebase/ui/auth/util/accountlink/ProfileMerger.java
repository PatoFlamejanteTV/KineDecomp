package com.firebase.ui.auth.util.accountlink;

import android.net.Uri;
import android.text.TextUtils;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.User;
import com.firebase.ui.auth.ui.TaskFailureLogger;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

/* loaded from: classes.dex */
public class ProfileMerger implements Continuation<AuthResult, Task<AuthResult>> {
    private static final String TAG = "ProfileMerger";
    private final IdpResponse mIdpResponse;

    public ProfileMerger(IdpResponse idpResponse) {
        this.mIdpResponse = idpResponse;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.tasks.Continuation
    public Task<AuthResult> then(Task<AuthResult> task) throws Exception {
        final AuthResult b2 = task.b();
        FirebaseUser user = b2.getUser();
        String displayName = user.getDisplayName();
        Uri O = user.O();
        if (!TextUtils.isEmpty(displayName) && O != null) {
            return Tasks.a(b2);
        }
        User user2 = this.mIdpResponse.getUser();
        if (TextUtils.isEmpty(displayName)) {
            displayName = user2.getName();
        }
        if (O == null) {
            O = user2.getPhotoUri();
        }
        return user.a(new UserProfileChangeRequest.Builder().a(displayName).a(O).a()).a(new TaskFailureLogger(TAG, "Error updating profile")).b(new Continuation<Void, Task<AuthResult>>() { // from class: com.firebase.ui.auth.util.accountlink.ProfileMerger.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.gms.tasks.Continuation
            public Task<AuthResult> then(Task<Void> task2) throws Exception {
                return Tasks.a(b2);
            }
        });
    }
}
