package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.Freezable;

/* loaded from: classes.dex */
public interface Person extends Freezable<Person> {

    /* loaded from: classes.dex */
    public interface AgeRange extends Freezable<AgeRange> {
    }

    /* loaded from: classes.dex */
    public interface Cover extends Freezable<Cover> {

        /* loaded from: classes.dex */
        public interface CoverInfo extends Freezable<CoverInfo> {
        }

        /* loaded from: classes.dex */
        public interface CoverPhoto extends Freezable<CoverPhoto> {
        }

        /* loaded from: classes.dex */
        public static final class Layout {
            private Layout() {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Gender {
        private Gender() {
        }
    }

    /* loaded from: classes.dex */
    public interface Image extends Freezable<Image> {
    }

    /* loaded from: classes.dex */
    public interface Name extends Freezable<Name> {
    }

    /* loaded from: classes.dex */
    public static final class ObjectType {
        private ObjectType() {
        }
    }

    /* loaded from: classes.dex */
    public interface Organizations extends Freezable<Organizations> {

        /* loaded from: classes.dex */
        public static final class Type {
            private Type() {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PlacesLived extends Freezable<PlacesLived> {
    }

    /* loaded from: classes.dex */
    public static final class RelationshipStatus {
        private RelationshipStatus() {
        }
    }

    /* loaded from: classes.dex */
    public interface Urls extends Freezable<Urls> {

        /* loaded from: classes.dex */
        public static final class Type {
            private Type() {
            }
        }
    }
}
