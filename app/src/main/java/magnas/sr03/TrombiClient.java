package magnas.sr03;

import java.util.List;

import magnas.sr03.model.Struct;
import magnas.sr03.model.Student;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Gregory on 09/03/2016.
 */
public interface TrombiClient {
    @GET("/Trombi_ws/mytrombi/result")
    void students(@Query("nom") String nom, @Query("prenom") String prenom, Callback<List<Student>> students);
    @GET("/Trombi_ws/mytrombi/structpere")
    void structs(Callback<List<Struct>> structures);
    @GET("/Trombi_ws/mytrombi/structfils")
    void sousstructs(@Query("lid") String id, Callback<List<Struct>> sousStructures);
    @GET("/Trombi_ws/mytrombi/resultstruct")
    void resultStruct(@Query("pere") String pereId, @Query("fils") String filsId, Callback<List<Student>> students);
}
