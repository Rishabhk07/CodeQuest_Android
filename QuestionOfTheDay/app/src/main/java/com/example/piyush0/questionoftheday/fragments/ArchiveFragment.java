package com.example.piyush0.questionoftheday.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.piyush0.questionoftheday.activities.MainActivity;
import com.example.piyush0.questionoftheday.R;
import com.example.piyush0.questionoftheday.dummy_utils.DummyQuestion;
import com.example.piyush0.questionoftheday.models.Question;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArchiveFragment extends Fragment {


    public static final String TAG = "Archive Fragment";
    RecyclerView recyclerView;
    ArrayList<Question> questions;
    public String filterSelected;
    ArchiveAdapter archiveAdapter;


    Context context;


    public ArchiveFragment() {
        // Required empty public constructor
    }

    public static ArchiveFragment newInstance() {
        ArchiveFragment fragment = new ArchiveFragment();

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        context = getActivity().getBaseContext();

        View view = inflater.inflate(R.layout.fragment_archive, container, false);
        questions = DummyQuestion.getDummyQuestions();
        Log.d(TAG, "onCreateView: " + questions.size());

        MainActivity.setOnItemSelected(new MainActivity.OnItemSelected() {
            @Override
            public void filterChosen(String filter) {
                filterSelected = filter;
                getQuestion(filterSelected);

            }
        });


        initRecyclerView(view);
        return view;
    }

    public void getQuestion(String filter) {
        //TODO: get questions from filter.
        Log.d(TAG, "getQuestion: " + filter);

        archiveAdapter.notifyDataSetChanged();

    }


    public void initRecyclerView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_archive_list_questions);
        archiveAdapter = new ArchiveAdapter();

        recyclerView.setAdapter(archiveAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }


    public class ArchiveViewHolder extends RecyclerView.ViewHolder {

        TextView tv_question_statement;

        public ArchiveViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class ArchiveAdapter extends RecyclerView.Adapter<ArchiveViewHolder> {

        public ArchiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = li.inflate(R.layout.list_item_questions_archive, null);

            ArchiveViewHolder archiveViewHolder = new ArchiveViewHolder(view);
            archiveViewHolder.tv_question_statement = (TextView) view.findViewById(R.id.item_list_archive_question_statement);

            return archiveViewHolder;
        }

        public void onBindViewHolder(ArchiveViewHolder holder, final int position) {

            holder.tv_question_statement.setText(questions.get(position).getStatement());

            holder.tv_question_statement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_main, SolveQuestionFragment.newInstance()).commit();
                }
            });
        }

        public int getItemCount() {

            return questions.size();
        }
    }

}
