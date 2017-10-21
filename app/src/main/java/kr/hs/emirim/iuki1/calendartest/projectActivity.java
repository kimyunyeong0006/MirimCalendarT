package kr.hs.emirim.iuki1.calendartest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class projectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        TextView tv = (TextView)findViewById(R.id.tv_top);
        tv.setText("프로젝트 리스트");
        Toast.makeText(projectActivity.this,"추가를 원한다면 오른쪽 상단의 \n   버튼을 클릭해주세요",Toast.LENGTH_LONG).show();
/*
        final DBHelper dbHelper = new DBHelper_projct(getApplicationContext(), "Project_DB.db", null, 1);
        Button mShowDialog = (Button) findViewById(R.id.btn);
        final DatePicker mdpStart = (DatePicker) findViewById(R.id.dpstart);
        final DatePicker mdpDead = (DatePicker) findViewById(R.id.dpdead);

        Log.v("통과","projectActivity1");

        mShowDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(projectActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.project_insert, null);
                final EditText mProjectName = (EditText)mView.findViewById(R.id.etProjectName);
                final Button mInsert = (Button)mView.findViewById(R.id.btn_insert);

                mInsert .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {



                        if(!mProjectName.getText().toString().isEmpty()){
                            Toast.makeText(projectActivity.this,
                                    "Insert successful",
                                    Toast.LENGTH_SHORT).show();
                            //DBHelper
                            int startyear = mdpStart.getYear();
                            int startmonth = mdpStart.getMonth();
                            int startday = mdpStart.getDayOfMonth();
                            final Date start = new Date(startyear, startmonth, startday);

                            int deadyear = mdpDead.getYear();
                            int deadmonth = mdpDead.getMonth();
                            int deadday = mdpDead.getDayOfMonth();
                            final Date dead = new Date(deadyear, deadmonth, deadday);

                            // DB에 데이터 추가
                        }else{
                            Toast.makeText(projectActivity.this,
                                    "입력해주세요",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });*/
    }
}
