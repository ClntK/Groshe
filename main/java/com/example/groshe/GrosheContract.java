package com.example.groshe;

import android.provider.BaseColumns;

public class GrosheContract {

    private GrosheContract() {}

    public static final class GrosheEntry implements BaseColumns {
        public static final String TABLE_NAME = "grosheList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
