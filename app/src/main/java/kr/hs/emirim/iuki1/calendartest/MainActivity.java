package kr.hs.emirim.iuki1.calendartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button btn_schedule = (Button)findViewById(R.id.ScheduleMemo);
        btn_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //오늘것이 있으면 열어주기! 없으면 토스트로 없습니다 찍어주기

                //Intent intent = new Intent(MainActivity.this,todaysActivity.class);
                //startActivity(intent);
            }
        });

        Button btn_show_list = (Button) findViewById(R.id.eventlist);
        btn_show_list.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DBActivity.class);
                startActivity(intent);

            }
        });

        Button btn_projects = (Button) findViewById(R.id.projects);
        btn_projects.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, projectActivity.class);
                startActivity(intent);
            }
        });
    }
}
