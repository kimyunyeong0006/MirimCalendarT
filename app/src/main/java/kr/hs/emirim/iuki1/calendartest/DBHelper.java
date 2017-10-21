package kr.hs.emirim.iuki1.calendartest;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_CATEGORY;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_CONT;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_DAY;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_IMPR;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_MONTH;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.TABLE_NAME;

class DBHelper extends SQLiteOpenHelper{
    public DBHelper(Context context)    {
        super(context, "calendar.db", null, 9);
    }

    public void onCreate(SQLiteDatabase db)    {
        // AUTOINCREMENT 속성 사용 시 PRIMARY KEY로 지정한다.
        String query = String.format( "CREATE TABLE %s ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "%s TEXT, "
                + "%s TEXT, "
                + "%s TEXT, "
                + "%s TEXT, "
                + "%s TEXT );", TABLE_NAME, KEY_MONTH, KEY_DAY, KEY_CATEGORY, KEY_CONT, KEY_IMPR );
        db.execSQL( query );
        Log.v("생성","DB");

        db.execSQL("insert into schedule values(null, 9, 2,'봉사','관악구 봉사',null);");
        db.execSQL("insert into schedule values(null,'9','7','전시','뉴 미디어 디자인쇼',null);");
        db.execSQL("insert into schedule values(null,'9','18','봉사','1학년 SW계열 꽃동네 봉사활동',null);");
        db.execSQL("insert into schedule values(null,'9','29','활동','모교방문',null);");
        db.execSQL("insert into schedule values(null,'10','12','시험','중간고사 첫번째날',null);");
        db.execSQL("insert into schedule values(null,'10','21','교내행사','입학설명회',null);");
        db.execSQL("insert into schedule values(null,'10','26','활동','미림콘서트',null);");
        db.execSQL("insert into schedule values(null,'10','27','전시','동아리 활동 발표회',null);");
        db.execSQL("insert into schedule values(null,'11','2','현장학습','지역문화탐방',null);");


        //인서트
    }


    public void insert(String month, String day,String category, String cont, String impr) { // 기본 값 (학사일정)
        // 읽고 쓰기가 가능하게 DB 열기
        SQLiteDatabase db = getWritableDatabase();
        // DB에 입력한 값으로 행 추가
        db.execSQL("INSERT INTO schedule VALUES(null, '" + month + "', " +day+ ", " + category + ", "
                + cont + ", " + impr + ");");

        Log.v("입력",""+cont);

        db.close();
    }

    public void update(int key, String cont, String impr){
        SQLiteDatabase db = getWritableDatabase();
        String update = "update schedule set KEY_CONT = 'happy' where _id = 3;";
        update = "UPDATE schedule SET contents='" + cont + "', impression='" + impr + "' WHERE _id='" + key + "';";

        Log.v("업뎃",Long.toString(key));
        Log.v("업뎃",update);
        db.execSQL(update);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)    {
        String query = String.format( "DROP TABLE IF EXISTS %s", TABLE_NAME );
        db.execSQL( query );
        onCreate( db );
    }
}