package kr.co.tjeit.beautysalon;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjeit.beautysalon.datas.DesignCase;
import kr.co.tjeit.beautysalon.datas.Designer;
import kr.co.tjeit.beautysalon.datas.User;
import kr.co.tjeit.beautysalon.utils.DateTimeUtil;
import kr.co.tjeit.beautysalon.utils.GeneralUtil;

public class MakeReservationActivity extends BaseActivity {

    private android.widget.TextView dateTxt;
    private android.widget.Button selectDateBtn;

    Calendar mReservationDate = Calendar.getInstance();
    private TextView timeTxt;
    private Button selectTimeBtn;
    private Button confirmBtn;
    private android.widget.Spinner hairStyleSpinner;

    ArrayList<String> hairStyles = new ArrayList<String>();
    ArrayAdapter<String> hairAdapter;
    private Spinner categorySpinner;

    private Designer mDesigner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);


        bindViews();
        setupEvents();
        setValues();
        addHairStyle(0);


    }

    private void addHairStyle (int categoryindex) {
        hairStyles.clear();
        if (categoryindex == 0) {
            hairStyles.add("반삭");
            hairStyles.add("댄디컷");
            hairStyles.add("샤기컷");
            hairStyles.add("투블럭");

        }
        else if (categoryindex == 1){
            hairStyles.add("다운펌");
            hairStyles.add("가르마펌");
            hairStyles.add("매직펌");
        }
        else if (categoryindex == 2){
            hairStyles.add("빨강");
            hairStyles.add("파랑");
            hairStyles.add("노랑");
            hairStyles.add("갈색");
            hairStyles.add("탈색");
        }
        hairAdapter.notifyDataSetChanged();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(mConText, position + "번 줄 선택", Toast.LENGTH_SHORT).show();
                addHairStyle(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GeneralUtil.globalDesignCase.add(new DesignCase(-1, mReservationDate, -1, mDesigner, new User(), -1, null));

                Log.d("미용사례개수", GeneralUtil.globalDesignCase.size() + "개");

                Toast.makeText(mConText, R.string.reservation_complete, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        // 예약 신청 버튼이 눌리면 "예약이 완료되었습니다."
        // 이 액티비티를 종료

        // 날짜 선택 버튼을 누르면, Toast로 "날짜 선택 창이 떠야합니다."
        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePickerDialog(mConText, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        mReservationDate.set(Calendar.YEAR, year);
                        mReservationDate.set(Calendar.MONTH, month);
                        mReservationDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);


                        dateTxt.setText(DateTimeUtil.getDateString(mReservationDate));

                    }
                },
                mReservationDate.get(Calendar.YEAR), mReservationDate.get(Calendar.MONTH), mReservationDate.get(Calendar.DAY_OF_MONTH)).show();

            }
        }); // 이벤트 핸들링 , 이벤트 처리

        selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new TimePickerDialog(mConText, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mReservationDate.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        mReservationDate.set(Calendar.MINUTE, minute);
                        timeTxt.setText(DateTimeUtil.getTimeString(mReservationDate));

                    }
                }, mReservationDate.get(Calendar.HOUR_OF_DAY), mReservationDate.get(Calendar.MINUTE), false).show();

            }
        });
    }





    @Override
    public void setValues() {
        super.setValues();

        mDesigner = (Designer)getIntent().getSerializableExtra("designer");

        hairAdapter = new ArrayAdapter<String>(mConText, android.R.layout.simple_spinner_item, hairStyles);
        hairStyleSpinner.setAdapter(hairAdapter);

        String dateString = DateTimeUtil.getDateString(mReservationDate);
        dateTxt.setText(dateString);

        String timeString = DateTimeUtil.getTimeString(mReservationDate);
        timeTxt.setText(timeString);
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.confirmBtn = (Button) findViewById(R.id.confirmBtn);
        this.selectTimeBtn = (Button) findViewById(R.id.selectTimeBtn);
        this.timeTxt = (TextView) findViewById(R.id.timeTxt);
        this.selectDateBtn = (Button) findViewById(R.id.selectDateBtn);
        this.dateTxt = (TextView) findViewById(R.id.dateTxt);
        this.hairStyleSpinner = (Spinner) findViewById(R.id.hairStyleSpinner);
        this.categorySpinner = (Spinner) findViewById(R.id.categorySpinner);
    }
}
