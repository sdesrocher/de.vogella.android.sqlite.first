package css.cis3334.devogellaandroidsqlitefirst;

//package de.vogella.android.sqlite.first;

/*
* Vogella SQLite Participation 8
*
* Code taken from Vogella SQLite database example
*  Edited by: Sara Desrocher
*  Edited on: 3/31/17
*/

import java.util.List;
import java.util.Random;

import android.app.ListActivity;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class TestDatabaseActivity extends ListActivity {
    private CommentsDataSource datasource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_database);

        datasource = new CommentsDataSource(this);
        datasource.open();

        List<Comment> values = datasource.getAllComments();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
    }

    // Will be called via the onClick attribute
    // of the buttons in main.xml
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        ArrayAdapter<Comment> adapter = (ArrayAdapter<Comment>) getListAdapter();

        Comment comment = null;
        Rating rating = null;
        switch (view.getId()) {
            case R.id.add:
                //String[] comments = new String[] { "Cool", "Very nice", "Hate it" };
                //int nextInt = new Random().nextInt(3);
                // save the new comment to the database

                EditText txtComment = (EditText) findViewById(R.id.etComment);
                // Retrieve rating from the edit text
                EditText txtRating = (EditText) findViewById(R.id.etRating);


                comment = datasource.createComment(txtComment.getText().toString());
                //pass rating as parameter
                rating = datasource.createComment(txtRating.getText().toString());

                //txtRating.setText("");
                //txtComment.setText("");
                adapter.add(comment);


                break;

            case R.id.delete:
                if (getListAdapter().getCount() > 0) {
                    comment = (Comment) getListAdapter().getItem(0);
                    datasource.deleteComment(comment);
                    adapter.remove(comment);
                }
                break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }

}
