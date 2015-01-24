package ua.kiev.ashev.dummybarcodescanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class ScanResultActivity extends Activity {

    static final String PREF_ARRAY_CURSOR_POSITION = "array_cursor_position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_scan_result);

        String ticketNumber = DummyTicket.getNextTicketNumber(getApplicationContext());

        Intent intent = new Intent();
        intent.putExtra("SCAN_RESULT", ticketNumber);
        intent.putExtra("SCAN_RESULT_FORMAT", "CODE_128");

        setResult(RESULT_OK, intent);
        finish();
    }
}
