package kr.hs.emirim.iuki1.calendartest;

/**
 * Created by 김윤영 on 2017-10-22.
 */

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_CONT;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_DAY;
import static kr.hs.emirim.iuki1.calendartest.DBActivity.KEY_MONTH;


/**
 * Created by 김윤영 on 2017-10-22.
 */

class MyCursorAdapter extends CursorAdapter {

    @SuppressWarnings("deprecation")
    public MyCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvMonth = (TextView) view.findViewById( R.id.tv_month );
        TextView tvDay = (TextView) view.findViewById( R.id.tv_day );
        TextView tvCont = (TextView) view.findViewById( R.id.tv_cont );
        String month = cursor.getString( cursor.getColumnIndex( KEY_MONTH) );
        String day = cursor.getString( cursor.getColumnIndex( KEY_DAY ) );
        String cont = cursor.getString( cursor.getColumnIndex( KEY_CONT) );

        Log.d("스트링 확인", month + ", " + day);

        tvMonth.setText( month );
        tvDay.setText( day );
        tvCont.setText( cont );
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View v = inflater.inflate( R.layout.list_item, parent, false );
        return v;
    }

}
