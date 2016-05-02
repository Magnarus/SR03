package magnas.sr03.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magnas.sr03.network.ServiceGenerator;
import magnas.sr03.utils.DividerItemDecoration;
import magnas.sr03.R;
import magnas.sr03.adapters.StudentAdapter;
import magnas.sr03.network.TrombiClient;
import magnas.sr03.model.Student;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Gregory on 03/04/2016.
 */
public class NameFragment extends Fragment {

    @Bind(R.id.lastname)
    EditText mLastName;
    @Bind(R.id.firstname) EditText mFirstName;
    @Bind(R.id.student_recyclerview)
    RecyclerView mStudentRecycler;
    @Bind(R.id.no_result_textview)
    TextView mNoResultTextView;

    TrombiClient mClient;
    Callback<List<Student>> mStudentCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        ButterKnife.bind(this, view);
        mClient = ServiceGenerator.createService(TrombiClient.class);
        initRecyclerView();
        initStudentCallback();
        return view;
    }


    @OnClick(R.id.submit)
    public void click() {
        String lastname = mLastName.getText().toString();
        String firstName = mFirstName.getText().toString();
        mClient.students(lastname, firstName, mStudentCallback);
    }

    private void initRecyclerView() {
        mStudentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mStudentRecycler.addItemDecoration(new DividerItemDecoration());
    }

    private void initStudentCallback() {
        mStudentCallback = new Callback<List<Student>>() {
            @Override
            public void success(List<Student> students, Response response) {
                String imageUrl = "https://demeter.utc.fr/portal/pls/portal30/portal30.get_photo_utilisateur_mini?username=";
                for (Student student : students) {
                    Glide.with(getContext())
                            .load(imageUrl + student.getLogin())
                            .downloadOnly(200, 200);
                }
                if (students.size() == 0) {
                    mStudentRecycler.setAdapter(new StudentAdapter());
                    mNoResultTextView.setVisibility(View.VISIBLE);
                } else {
                    mStudentRecycler.setAdapter(new StudentAdapter(students));
                    mNoResultTextView.setVisibility(View.GONE);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("TrombiActivity.failure");
            }
        };
    }
}
