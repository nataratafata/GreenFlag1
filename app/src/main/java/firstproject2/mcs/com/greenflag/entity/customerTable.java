package firstproject2.mcs.com.greenflag.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class customerTable{
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "customerName")
    public String name;

    @ColumnInfo(name = "customerUserName")
    public String username;

    @ColumnInfo(name = "customerPassword")
    public String password;

    @ColumnInfo(name = "customerAge")
    public String age;

    @ColumnInfo(name = "customerAddress")
    public String address;

    public int getUid(){
        return uid;
    }

    public void setUid(int uid){
        this.uid = uid;
    }


    public void getAll(String name, String username, String password, String age, String address)
    {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
    }

    public String setName()
    {
        return this.name;
    }

    public String setUserName()
    {
        return this.username;
    }

    public String setPassword()
    {
        return this.password;
    }

    public String setAge()
    {
        return this.age;
    }

    public String setAddress()
    {
        return this.address;
    }
}