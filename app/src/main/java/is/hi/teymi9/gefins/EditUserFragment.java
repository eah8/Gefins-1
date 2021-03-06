package is.hi.teymi9.gefins;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import is.hi.teymi9.gefins.model.User;

/**
 * Fragment fyrir viðmótið í EditUserActivity og virknina þar.
 *
 * @author Einar
 * @version 1.0
 */

public class EditUserFragment extends Fragment {

    // Textasvið fyrir notandanafn
    private EditText mUsername;
    // Textasvið fyrir lykilorð
    private EditText mPassword;
    // Textasvið fyrir endurtekið lykilorð
    private EditText mPasswordRepeat;
    // Textasvið fyrir tölvupóstfang
    private EditText mEmail;
    // Textasvið fyrir fullt nafn
    private EditText mFullName;
    // Textasvið fyrir símanúmber
    private EditText mPhoneNumber;
    // Textasvið fyrir póstnúmer
    private EditText mZipcode;
    // Textasvið fyrir heimilisfang
    private EditText mAddress;
    // Takki fyrir staðfestingu á breyttum upplýsingum
    private Button mRegisterButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_edit_user, container, false);

        mUsername = (EditText) v.findViewById(R.id.username);
        mPassword = (EditText) v.findViewById(R.id.password);
        mPasswordRepeat = (EditText) v.findViewById(R.id.password_repeat);
        mEmail = (EditText) v.findViewById(R.id.email_address);
        mFullName = (EditText) v.findViewById(R.id.full_name);
        mPhoneNumber = (EditText) v.findViewById(R.id.phonenumber);
        mZipcode = (EditText) v.findViewById(R.id.zipcode);
        mAddress = (EditText) v.findViewById(R.id.address);

        mUsername.setText(LoginActivity.getUserService().getCurrentUser().getUsername());
        mPassword.setText(LoginActivity.getUserService().getCurrentUser().getPassword());
        mPasswordRepeat.setText(LoginActivity.getUserService().getCurrentUser().getPassword());
        mEmail.setText(LoginActivity.getUserService().getCurrentUser().getEmail());
        mFullName.setText(LoginActivity.getUserService().getCurrentUser().getFullName());
        mPhoneNumber.setText(LoginActivity.getUserService().getCurrentUser().getPhonenr());
        mZipcode.setText(""+LoginActivity.getUserService().getCurrentUser().getZip());
        mAddress.setText(LoginActivity.getUserService().getCurrentUser().getAddress());

        // Við viljum mögulega bæta við TextChangedListener á þetta til þess að geta komið með
        // live feedback um hvort inntak sé gilt.

        mRegisterButton = (Button) v.findViewById(R.id.register);
        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LoginActivity.getUserService().getCurrentUser().setUsername( mUsername.getText().toString());
                LoginActivity.getUserService().getCurrentUser().setPassword( mPassword.getText().toString());
                LoginActivity.getUserService().getCurrentUser().setEmail( mEmail.getText().toString());
                LoginActivity.getUserService().getCurrentUser().setFullName( mFullName.getText().toString());
                LoginActivity.getUserService().getCurrentUser().setPhonenr( mPhoneNumber.getText().toString());
                LoginActivity.getUserService().getCurrentUser().setZip( Integer.parseInt(mZipcode.getText().toString()));
                LoginActivity.getUserService().getCurrentUser().setAddress( mAddress.getText().toString());
                LoginActivity.getUserService().updateUser(LoginActivity.getUserService().getCurrentUser());
                Intent intent = new Intent(getActivity(), UsersiteActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
