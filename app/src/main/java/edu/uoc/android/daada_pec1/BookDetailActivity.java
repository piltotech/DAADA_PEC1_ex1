package edu.uoc.android.daada_pec1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail);

        Bundle data = getIntent().getBundleExtra("data");
        String number = data.getString("book_number");
        String name = data.getString("book_name");

        String details_text = "Details from book " + number + " - Title:" + name;
        Log.d("BookDetailActivity", details_text);
        TextView text = findViewById(R.id.book_list_detail);
        text.setText(details_text);

    }
}
