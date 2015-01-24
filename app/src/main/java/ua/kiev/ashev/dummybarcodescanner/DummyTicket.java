package ua.kiev.ashev.dummybarcodescanner;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Ashev on 15.01.2015.
 *
 * Returns tickets numbers from set of real MAC codes
 *
 */
public class DummyTicket {

    private static final String PREF_ARRAY_CURSOR_POSITION = "array_cursor_position";

    private static final String[] mTickets = {
            "003008050071340000929845",
            "003008050071340100902690",
            "003008050071340200921529",
            "003008050071340300881248",
            "003008050071340000929845",
            "003008050071340100902690"
    };
    private static int mCurrentIndex = 0;

    public static String getNextTicketNumber(Context context){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        mCurrentIndex = sp.getInt(PREF_ARRAY_CURSOR_POSITION, 0);

        if (mCurrentIndex+1 > mTickets.length)
            mCurrentIndex = 0;

        String ticketNumber = mTickets[mCurrentIndex];

        if (mCurrentIndex < mTickets.length - 1)
            mCurrentIndex++;
        else
            mCurrentIndex = 0;

        sp = PreferenceManager.getDefaultSharedPreferences(context);
        sp.edit().putInt(PREF_ARRAY_CURSOR_POSITION, mCurrentIndex).apply();

        return ticketNumber;
    }
}
