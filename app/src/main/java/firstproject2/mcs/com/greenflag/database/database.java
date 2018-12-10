package firstproject2.mcs.com.greenflag.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import firstproject2.mcs.com.greenflag.Dao.dao;
import firstproject2.mcs.com.greenflag.entity.customerTable;

@Database(entities = {customerTable.class}, version = 1)
public abstract class database extends RoomDatabase{

            public abstract dao userDao();



}