package com.example.roomwordssample;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Word word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    //LiveData handles generation of required code for updating the LD when the DB is updated
    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    //Gets ONE word.
    @Query("SELECT * from word_table LIMIT 1")
    Word[] getAnyWord();

    //Delete one word; The Delete annotation deletes a whole row from the DB
    @Delete
    void deleteWord(Word word);

}
