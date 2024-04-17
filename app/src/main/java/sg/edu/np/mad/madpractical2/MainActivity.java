package sg.edu.np.mad.madpractical2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

// Add these.
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.res.Configuration;
import android.content.pm.ActivityInfo;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Start from Here!
        // Initialize a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnFollow = findViewById(R.id.btnFollow);

        // Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        // Set the OnClickListener for the follow button
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the followed state
                user.followed = !user.followed;

                // Update the button text based on the new state
                if (user.followed) {
                    btnFollow.setText("Unfollow");
                }
                else {
                    btnFollow.setText("Follow");
                }
            }
        });
    }
}