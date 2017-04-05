package css.cis3334.devogellaandroidsqlitefirst;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Main class creating table for comments to be kept. Creating option to update.
 * Code taken from Vogella SQLite database example on 3/31/17
 * Edited by sdesrocher on 3/31/2017.
 */



 import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;

    public class MySQLiteHelper extends SQLiteOpenHelper {

            //TABLE_COMMENTS is a string for comments kept for the table
        public static final String TABLE_COMMENTS = "comments";
            //String for the id given to each entry
        public static final String COLUMN_ID = "_id";
            //Label the column with the actaul comment in it
        public static final String COLUMN_COMMENT = "comment";
        //add new rating filed
        public static final String COLUMN_RATING = "rating";

            //Naming of the database
        private static final String DATABASE_NAME = "commments.db";
            //give the database a version for updating in the future
        private static final int DATABASE_VERSION = 1;

        // Database creation sql statement - using the created table, comments, id and columns
        private static final String DATABASE_CREATE = "create table "
                + TABLE_COMMENTS + "( " + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_COMMENT + " text not null" + COLUMN_RATING+ "TEXT);";

        /* SQL table create-------------------
        * CREATE TABLE comments(
        * COMMENT_ID string,
        * COMMENT string,
        * );
        *
         */


        public MySQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(css.cis3334.devogellaandroidsqlitefirst.MySQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");


            db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
            onCreate(db);
        }

    }


