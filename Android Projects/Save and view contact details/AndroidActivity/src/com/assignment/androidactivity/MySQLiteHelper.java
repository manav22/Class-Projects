package com.assignment.androidactivity;
 
import java.util.LinkedList;
import java.util.List;
 

 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
 
public class MySQLiteHelper extends SQLiteOpenHelper {
	String TAG = "MySQLiteHelper";
 
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "UserDataDB";
    
    
    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */
 
    // Books table name
    private static final String TABLE_USERDATA = "UserData";
    
 
    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_FirstName = "FirstName";
    private static final String KEY_LastName = "LastName";
    private static final String KEY_Address = "Address";
    private static final String KEY_CreditCard = "CreditCard";
 
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
    	final String CREATE_USERDATA_TABLE = "CREATE TABLE IF NOT EXISTS " 
  		      + TABLE_USERDATA
  		      + "(" 
  		      + KEY_ID + " integer primary key autoincrement, " 
  		      + KEY_FirstName + " text not null, " 
  		      + KEY_LastName  + " text not null, " 
  		      + KEY_Address   + " text not null, " 
  		      + KEY_CreditCard + " text not null"
  		      + ");";
        // create books table
        db.execSQL(CREATE_USERDATA_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS UserData");
 
        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------
 
    
 
    //private static final String[] COLUMNS = {KEY_ID, KEY_FirstName, KEY_LastName, KEY_Address, KEY_CreditCard};
 
    public void addUserData(UserData userData){
       // Log.d("userData", savedata.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
 
      ContentValues values = new ContentValues();
      values.put(KEY_FirstName, userData.getFirstName());
      values.put(KEY_LastName, userData.getLastName());
      values.put(KEY_Address, userData.getAddress());
      values.put(KEY_CreditCard, userData.getCreditCardNUmber());
        
        // 2. create ContentValues to add key "column"/value
         // get author
      Log.e(TAG, "Going to insert data");
        // 3. insert
        db.insert(TABLE_USERDATA, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        Log.e(TAG, "After insert");
        // 4. close
        db.close(); 
    }
 
 
    // Get All Books
    public List<UserData> getAllUserData() {
        List<UserData> users = new LinkedList<UserData>();
 
        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USERDATA;
 
        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        // 3. go over each row, build book and add it to list
        UserData user = null;
        if (cursor.moveToFirst()) {
            do {
            	user = new UserData();
            	user.setId(Integer.parseInt(cursor.getString(0)));
            	user.setFirstName(cursor.getString(1));
            	user.setLastName(cursor.getString(2));
            	user.setAddress(cursor.getString(3));
            	user.setCreditCardNUmber(cursor.getString(4));
 
                // Add book to books
                users.add(user);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllBooks()", users.toString());
 
        // return books
        return users;
    }
 
     // Updating single book
   
   
}