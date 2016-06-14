package magnas.sr03.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magnas.sr03.network.ServiceGenerator;
import magnas.sr03.utils.DividerItemDecoration;
import magnas.sr03.R;
import magnas.sr03.utils.StructItemSelectedListener;
import magnas.sr03.adapters.StudentAdapter;
import magnas.sr03.network.TrombiClient;
import magnas.sr03.model.Struct;
import magnas.sr03.model.Student;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Gregory on 03/04/2016.
 */
public class StructureFragment extends Fragment {
    @Bind(R.id.student_recyclerview) RecyclerView mStudentRecycler;
    @Bind(R.id.no_result_textview) TextView mNoResultTextView;
    @Bind(R.id.structSpinner) Spinner mStructSpinner;
    @Bind(R.id.sousStructSpinner) Spinner mSousStructSpinner;

    TrombiClient mClient;
    Callback<List<Student>> mStudentCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_structure, container, false);
        ButterKnife.bind(this, view);
        mClient = ServiceGenerator.createService(TrombiClient.class);
        initRecyclerView();
        initSpinner();
        initStudentCallback();
        return view;
    }

    @OnClick(R.id.submit)
    public void click() {
        Struct pereStruct = ((Struct) mStructSpinner.getSelectedItem());
        String pereId = pereStruct.getStructure().getStructId();
        Struct filsStruct = ((Struct) mSousStructSpinner.getSelectedItem());
        if(filsStruct.getStructNomId() != -999) {
            String filsId = filsStruct.getStructure().getStructId();
            mClient.resultStruct(pereId, filsId, mStudentCallback);
        }
        mClient.resultStruct(pereId, null, mStudentCallback);
    }

    private void initRecyclerView() {
        mStudentRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mStudentRecycler.addItemDecoration(new DividerItemDecoration());
    }

    private void initSpinner() {
        mClient.structs(new Callback<List<Struct>>() {
            @Override
            public void success(List<Struct> structs, Response response) {
                ArrayAdapter<Struct> dataAdapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_spinner_item, structs);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mStructSpinner.setAdapter(dataAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                System.out.println("TrombiActivity.failure");
            }
        });
        mStructSpinner.setOnItemSelectedListener(new StructItemSelectedListener(mSousStructSpinner));
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
