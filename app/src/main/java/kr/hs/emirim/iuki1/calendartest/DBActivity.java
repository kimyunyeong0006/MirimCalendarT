package kr.hs.emirim.iuki1.calendartest;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by 김윤영 on 2017-10-22.
 */

public class DBActivity extends Activity {
    DBHelper mHelper;
    SQLiteDatabase db;
    Cursor cursor;
    MyCursorAdapter myAdapter;

    final static String KEY_ID = "_id";
    final static String TABLE_NAME = "schedule";
    final static String KEY_MONTH = "month";
    final static String KEY_DAY = "day";
    final static String KEY_CATEGORY = "category";
    final static String KEY_CONT = "contents";
    final static String KEY_IMPR = "impression";

    final static String querySelectAll = String.format("SELECT * FROM %s", TABLE_NAME);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_todays);

        TextView tv = (TextView)findViewById(R.id.tv_top);
        tv.setText("일정 리스트");

        ListView list = (ListView) findViewById(R.id.schedule_list);

        mHelper = new DBHelper(this);
        db = mHelper.getWritableDatabase();

        cursor = db.rawQuery(querySelectAll, null);
        myAdapter = new MyCursorAdapter(this, cursor);

        list.setAdapter(myAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getApplicationContext(),""+id, Toast.LENGTH_SHORT).show();

                Log.v("id",""+id);

                Intent intent = new Intent(DBActivity.this,todaysActivity.class);
                intent.putExtra("key_id",id);
                startActivity(intent);
            }
        });
    }
}