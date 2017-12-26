package strauss.sebastian.eduardo.apidos.GETGitHub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import strauss.sebastian.eduardo.apidos.R;

public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo>{

    private Context mContext;
    private List<GitHubRepo> mGitHubRepoList;

    public GitHubRepoAdapter(Context context, List<GitHubRepo> values) {
        super(context, R.layout.list_item_pagination, values);
        mContext = context;
        mGitHubRepoList = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;

        if(row == null){
            LayoutInflater inflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item);
        GitHubRepo item = mGitHubRepoList.get(position);
        String message = item.getName();
        textView.setText(message);

        return row;
    }





}
