package magnas.sr03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magnas.sr03.model.Struct;
import magnas.sr03.model.Student;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class TrombiActivity extends AppCompatActivity {

    @Bind(R.id.lastname) EditText mLastName;
    @Bind(R.id.firstname) EditText mFirstName;
    @Bind(R.id.student_recyclerview) RecyclerView mStudentRecycler;
    @Bind(R.id.no_result_textview) TextView mNoResultTextView;
    @Bind(R.id.structSpinner) Spinner mStructSpinner;
    @Bind(R.id.sousStructSpinner) Spinner mSousStructSpinner;
    @Bind(R.id.toolbar) Toolbar mToolbar;
    @Bind(R.id.filter) CheckBox mFilter;

    TrombiClient mClient;
    Callback<List<Student>> mStudentCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trombi);
        ButterKnife.bind(this);
        mClient = ServiceGenerator.createService(TrombiClient.class);

        initRecyclerView();
        initActionBar();
        initSpinner();
        initStudentCallback();
    }

    @OnClick(R.id.submit)
    public void click() {
        String lastname = mLastName.getText().toString();
        System.out.println("lastname = " + lastname);
        String firstName = mFirstName.getText().toString();
        System.out.println("firstName = " + firstName);

        if(mFilter.isChecked()) {
            Struct pereStruct = ((Struct) mStructSpinner.getSelectedItem());
            String pereId = pereStruct.getStructure().getStructId();
            Struct filsStruct = ((Struct) mSousStructSpinner.getSelectedItem());
            if(filsStruct.getStructNomId() != -999) {
                String filsId = filsStruct.getStructure().getStructId();
                mClient.resultStruct(pereId, filsId, mStudentCallback);
            }
            mClient.resultStruct(pereId, null, mStudentCallback);
        } else {
            mClient.students(lastname, firstName, mStudentCallback);
        }
    }

    private void initRecyclerView() {
        mStudentRecycler.setLayoutManager(new LinearLayoutManager(this));
        mStudentRecycler.addItemDecoration(new DividerItemDecoration());
    }

    private void initActionBar() {
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.app_name);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    private void initSpinner() {
        mClient.structs(new Callback<List<Struct>>() {
            @Override
            public void success(List<Struct> structs, Response response) {
                ArrayAdapter<Struct> dataAdapter = new ArrayAdapter<>(TrombiActivity.this,
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
                  Glide.with(TrombiActivity.this)
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
