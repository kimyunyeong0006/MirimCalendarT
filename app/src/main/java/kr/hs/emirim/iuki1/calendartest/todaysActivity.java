package kr.hs.emirim.iuki1.calendartest;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static kr.hs.emirim.iuki1.calendartest.DBActivity.TABLE_NAME;

/**
 * Created by 김윤영 on 2017-10-21.
 */

public class todaysActivity extends AppCompatActivity{
    final static String querySelectAll = String.format("SELECT * FROM %s", TABLE_NAME);
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todays);

        final DBHelper mHelper = new DBHelper(this);
        SQLiteDatabase db = mHelper.getWritableDatabase();

        Intent intent = getIntent();
        final long key = intent.getExtras().getLong("key_id",-1);
        Log.v("쿼리",""+key);


        String query = "select * from schedule where _id = "+key+";";
        Log.v("쿼리",query);

        Cursor cursor = db.rawQuery( querySelectAll, null );
        cursor.moveToPosition((int) (key-1));

        Log.v("메시지",cursor.getString(1));
        Log.v("메시지",cursor.getString(2));
        String m = cursor.getString(1);
        String d = cursor.getString(2);
        String cate = cursor.getString(3);
        final String cont1 = cursor.getString(4);
        final String impr1 = cursor.getString(5);

        TextView tv = (TextView)findViewById(R.id.tv_top);
        tv.setText("오늘의 소감문");

        TextView month = (TextView)findViewById(R.id.month);
        month.setText(m+"월"); //날짜

        TextView day = (TextView)findViewById(R.id.day);
        day.setText(d+"일"); //날짜

        TextView schedule = (TextView)findViewById(R.id.Schedule);
        schedule.setText("ㅁ"+cate); //행사 명 ex)특강, 봉사,

        final TextView a_Input = (TextView)findViewById(R.id.activitiesInput);
        a_Input.setText(cont1); //주제 입력했던 값 있다면

        final TextView i_Input = (TextView)findViewById(R.id.impressionInput);
        i_Input.setText(impr1); //소감 입력했던 값 있다면


        Button btn_save = (Button)findViewById(R.id.save_content);
        btn_save.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                try{
                    mHelper.update(Integer.parseInt(Long.toString(key)), a_Input.getText().toString(), i_Input.getText().toString());

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(todaysActivity.this, "저장실패", Toast.LENGTH_SHORT).show();
                }
                //DB 구현하세요 . . . .
                Toast.makeText(todaysActivity.this, "저장되었어요!", Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
