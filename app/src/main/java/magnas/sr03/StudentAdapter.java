package magnas.sr03;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import magnas.sr03.model.Student;

/**
 * Created by Gregory on 09/03/2016.
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    List<Student> students;
    Context context;

    public StudentAdapter() {
        students = new ArrayList<>();
    }

    public StudentAdapter(List<Student> students) {
        this.students = students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    @Override
    public StudentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        return new StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_student, viewGroup, false));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    @Override
    public void onBindViewHolder(StudentViewHolder studentViewHolder, int i) {
        Student student = students.get(i);
        studentViewHolder.mName.setText(student.getNom());
        studentViewHolder.mPseudo.setText(context.getString(R.string.login, student.getLogin()));
        studentViewHolder.mStatus.setText(student.getStructure());
        Glide.with(context)
            .load("https://demeter.utc.fr/portal/pls/portal30/portal30.get_photo_utilisateur_mini?username=" + student.getLogin())
            .override(200,200)
            .error(R.drawable.placeholder)
            .into(studentViewHolder.mPhoto);
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.student_photo) ImageView mPhoto;
        @Bind(R.id.student_name) TextView mName;
        @Bind(R.id.student_pseudo) TextView mPseudo;
        @Bind(R.id.student_status) TextView mStatus;

        public StudentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            Student student = students.get(getLayoutPosition());
        }
    }
}
