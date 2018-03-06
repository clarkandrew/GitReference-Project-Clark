package com.example.andrewclark.gitreference_project_clark;


/**
 * Created by andrewclark on 2/28/18.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;



public class gitAdapter extends BaseAdapter {
    private Context iContext;
    private ArrayList < GitReference > iDataSource;
    private LayoutInflater iInflater;


    public gitAdapter(Context context, ArrayList < GitReference > gitReferences) {
        iContext = context;
        iInflater = (LayoutInflater) iContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        iDataSource = gitReferences;

    }
    @Override
    public int getCount() {
        return iDataSource.size();

    }
    @Override
    public Object getItem(int i) {
        return iDataSource.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }


    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = iInflater.inflate(R.layout.git_layout, viewGroup, false);

        TextView commandView = rowView.findViewById(R.id.cmd);
        TextView exampleView = rowView.findViewById(R.id.usage);
        TextView explanationView = rowView.findViewById(R.id.expl);

        GitReference gitObj = (GitReference) getItem(position);
        commandView.setText(gitObj.getSection() + " " + iContext.getString(R.string.secDiv) + " " + gitObj.getCommand());
        exampleView.setText(iContext.getString(R.string.usg) + "\n" + gitObj.getExample());
        explanationView.setText(gitObj.getExplanation());


        return rowView;
    }
}