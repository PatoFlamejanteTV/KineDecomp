package com.squareup.picasso;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.squareup.picasso.E;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContactsPhotoRequestHandler.java */
/* renamed from: com.squareup.picasso.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2400m extends E {

    /* renamed from: a, reason: collision with root package name */
    private static final UriMatcher f25647a = new UriMatcher(-1);

    /* renamed from: b, reason: collision with root package name */
    private final Context f25648b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ContactsPhotoRequestHandler.java */
    @TargetApi(14)
    /* renamed from: com.squareup.picasso.m$a */
    /* loaded from: classes3.dex */
    public static class a {
        static InputStream a(ContentResolver contentResolver, Uri uri) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
        }
    }

    static {
        f25647a.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f25647a.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f25647a.addURI("com.android.contacts", "contacts/#/photo", 2);
        f25647a.addURI("com.android.contacts", "contacts/#", 3);
        f25647a.addURI("com.android.contacts", "display_photo/#", 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2400m(Context context) {
        this.f25648b = context;
    }

    private InputStream c(C c2) throws IOException {
        ContentResolver contentResolver = this.f25648b.getContentResolver();
        Uri uri = c2.f25547e;
        int match = f25647a.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 14) {
            return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
        }
        return a.a(contentResolver, uri);
    }

    @Override // com.squareup.picasso.E
    public boolean a(C c2) {
        Uri uri = c2.f25547e;
        return "content".equals(uri.getScheme()) && ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) && f25647a.match(c2.f25547e) != -1;
    }

    @Override // com.squareup.picasso.E
    public E.a a(C c2, int i) throws IOException {
        InputStream c3 = c(c2);
        if (c3 != null) {
            return new E.a(c3, Picasso.LoadedFrom.DISK);
        }
        return null;
    }
}
