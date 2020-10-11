package edu.uoc.android.daada_pec1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class BookListActivity extends AppCompatActivity {

    boolean tabletMode;

    private ListView bookListView ;
    ArrayList<HashMap<String,String>> list=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);

        // Set table/mobile mode
        tabletMode = findViewById(R.id.book_list_detail) != null;
        Log.d("BookListActivity", "onCreate - Tablet mode:" + tabletMode);

        // Insert sample items
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("number", String.valueOf(i) );
            hashMap.put("name", "item" + i);
            list.add(hashMap);
        }

        bookListView = (ListView) findViewById(R.id.book_list);

        //create adapter and add sample items
        String fromArray[] = {"number", "name"};
        int toArray[] = {R.id.id_book_number, R.id.id_book_name};
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.book_list_content,
                fromArray,
                toArray
        );
        bookListView.setAdapter(adapter);

        // Set on click listener to books list
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id){

                if (tabletMode) {
                    //if table mode, get details in fragment
                    BookDetailFragment fragment = BookDetailFragment.newInstance(list.get(position).get("number"),list.get(position).get("name"));
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.book_detail, fragment);
                    ft.commit();
                }
                else{
                    //if mobile mode, get details in new activity
                    Context context = view.getContext();
                    Intent intent = new Intent(context, BookDetailActivity.class);

                    Bundle args = new Bundle();
                    args.putString("book_number", list.get(position).get("number"));
                    args.putString("book_name", list.get(position).get("name"));
                    intent.putExtra("data",args);
                    context.startActivity(intent);
                }

        }});


    }
}
