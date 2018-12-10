package firstproject2.mcs.com.greenflag.Dao;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import firstproject2.mcs.com.greenflag.entity.customerTable;

@Dao
public interface dao {
    @Query("SELECT * FROM CustomerTable")
    List<customerTable> getAll();
    @Insert
    void insertAll(customerTable... ctInsert);

    @Delete
    void delete(customerTable ctDelete);

}
