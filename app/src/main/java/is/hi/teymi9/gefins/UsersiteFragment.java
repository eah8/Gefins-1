package is.hi.teymi9.gefins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Fragment fyrir viðmótið í UsersiteActivity og virknina þar.
 *
 * @author Einar
 * @version 1.0
 */

public class UsersiteFragment extends Fragment {

    // Takki fyrir útskráningu
    private Button mLogout;
    // Takki fyrir leit
    private Button mSearch;
    private Button mAddAd;
    private Button mEditUser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_usersite, container, false);

        mLogout = (Button) v.findViewById(R.id.logout_button);
        mSearch = (Button) v.findViewById(R.id.search_button);
        mAddAd = (Button) v.findViewById(R.id.add_ad_button);
        mEditUser = (Button) v.findViewById(R.id.edit_user_button);


        mSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),
                        R.string.clickSearch,
                        Toast.LENGTH_SHORT).show();

            }
        });


        mLogout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LoginActivity.getUserService().logout();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mEditUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = EditUserActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });

        mAddAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = AddAdActivity.newIntent(getActivity());
                startActivity(intent);
            }
        });

        return v;
    }
}
