package css.cis3334.devogellaandroidsqlitefirst;
//package de.vogella.android.sqlite.first;

/**
 * Code
 * Code taken from Vogella SQLite database example on 3/31/17
 * Edited by sdesrocher on 3/31/2017.
 */

public class Comment {
    private long id;
    private String comment;

    //retain the id and then show it in the table
    public long getId() {
        return id;
    }

    //setting a new id as this.id
    public void setId(long id) {
        this.id = id;
    }

    //retrieving the comment that is preset to be shown in the table
    public String getComment() {
        return comment;
    }

    //setting a new comment as this.comment
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    //changing the comment to toString to be shown
    public String toString() {
        return comment;
    }
}
