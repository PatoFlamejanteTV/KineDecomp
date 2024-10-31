package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamLocalUriFetcher.java */
/* loaded from: classes.dex */
public class o extends m<InputStream> {

    /* renamed from: d */
    private static final UriMatcher f8573d = new UriMatcher(-1);

    static {
        f8573d.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f8573d.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f8573d.addURI("com.android.contacts", "contacts/#/photo", 2);
        f8573d.addURI("com.android.contacts", "contacts/#", 3);
        f8573d.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f8573d.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public o(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream b(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        int match = f8573d.match(uri);
        if (match != 1) {
            if (match == 3) {
                return a(contentResolver, uri);
            }
            if (match != 5) {
                return contentResolver.openInputStream(uri);
            }
        }
        Uri lookupContact = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (lookupContact != null) {
            return a(contentResolver, lookupContact);
        }
        throw new FileNotFoundException("Contact cannot be found");
    }

    @Override // com.bumptech.glide.load.a.m
    public InputStream a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        InputStream b2 = b(uri, contentResolver);
        if (b2 != null) {
            return b2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    private InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // com.bumptech.glide.load.a.m
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.a.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
