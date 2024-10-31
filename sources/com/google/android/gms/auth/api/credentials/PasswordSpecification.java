package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class PasswordSpecification implements SafeParcelable {
    public static final zze CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public static final PasswordSpecification f792a = new zza().a(12, 16).a("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").a("abcdefghijkmnopqrstxyz", 1).a("ABCDEFGHJKLMNPQRSTXY", 1).a("3456789", 1).a();
    public static final PasswordSpecification b = new zza().a(12, 16).a("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").a("abcdefghijklmnopqrstuvwxyz", 1).a("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).a("1234567890", 1).a();
    final int c;
    final String d;
    final List<String> e;
    final List<Integer> f;
    final int g;
    final int h;
    private final int[] i = a();
    private final Random j = new SecureRandom();

    /* loaded from: classes.dex */
    public static class zza {

        /* renamed from: a, reason: collision with root package name */
        private final TreeSet<Character> f793a = new TreeSet<>();
        private final List<String> b = new ArrayList();
        private final List<Integer> c = new ArrayList();
        private int d = 12;
        private int e = 16;

        private TreeSet<Character> a(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.b(c, 32, 126)) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        private void b() {
            int i;
            int i2 = 0;
            Iterator<Integer> it = this.c.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                } else {
                    i2 = it.next().intValue() + i;
                }
            }
            if (i > this.e) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void c() {
            boolean[] zArr = new boolean[95];
            Iterator<String> it = this.b.iterator();
            while (it.hasNext()) {
                for (char c : it.next().toCharArray()) {
                    if (zArr[c - ' ']) {
                        throw new zzb("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - ' '] = true;
                }
            }
        }

        public zza a(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            }
            if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            }
            this.d = i;
            this.e = i2;
            return this;
        }

        public zza a(String str) {
            this.f793a.addAll(a(str, "allowedChars"));
            return this;
        }

        public zza a(String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.b.add(PasswordSpecification.b(a(str, "requiredChars")));
            this.c.add(Integer.valueOf(i));
            return this;
        }

        public PasswordSpecification a() {
            if (this.f793a.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            b();
            c();
            return new PasswordSpecification(1, PasswordSpecification.b(this.f793a), this.b, this.c, this.d, this.e);
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.c = i;
        this.d = str;
        this.e = Collections.unmodifiableList(list);
        this.f = Collections.unmodifiableList(list2);
        this.g = i2;
        this.h = i3;
    }

    private int a(char c) {
        return c - ' ';
    }

    private int[] a() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        Iterator<String> it = this.e.iterator();
        int i = 0;
        while (it.hasNext()) {
            for (char c : it.next().toCharArray()) {
                iArr[a(c)] = i;
            }
            i++;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator<Character> it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = it.next().charValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze.a(this, parcel, i);
    }
}
