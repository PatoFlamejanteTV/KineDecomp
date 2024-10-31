package c.d.b.b;

import android.util.Log;
import c.d.b.b.d;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Account.java */
/* loaded from: classes.dex */
public class c implements ValueEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f3597a = dVar;
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void a(DataSnapshot dataSnapshot) {
        FirebaseAuth firebaseAuth;
        d.b bVar;
        d.b bVar2;
        d.b bVar3;
        d.b bVar4;
        if (!dataSnapshot.a()) {
            Log.w(d.f3598a, "[handleActivityResult] User data does not exist!");
            Date date = new Date();
            bVar3 = this.f3597a.f3601d;
            bVar3.b().setPrivacyAgreeTime(date.getTime());
            bVar4 = this.f3597a.f3601d;
            bVar4.b().setPrivacyVersion(i.c().b());
        }
        firebaseAuth = this.f3597a.f3600c;
        FirebaseUser a2 = firebaseAuth.a();
        if (a2 != null) {
            bVar = this.f3597a.f3601d;
            if (bVar != null) {
                bVar2 = this.f3597a.f3601d;
                bVar2.a(a2.getEmail(), a2.getDisplayName(), dataSnapshot.a());
            }
        }
    }

    @Override // com.google.firebase.database.ValueEventListener
    public void a(DatabaseError databaseError) {
        Log.e(d.f3598a, "[handleActivityResult] error: " + databaseError, databaseError.b());
        this.f3597a.c();
    }
}
