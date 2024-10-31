package android.arch.persistence.room;

/* compiled from: RoomMasterTable.java */
/* loaded from: classes.dex */
public class g {
    public static String a(String str) {
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"" + str + "\")";
    }
}
