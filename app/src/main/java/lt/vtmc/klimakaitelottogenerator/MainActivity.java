package lt.vtmc.klimakaitelottogenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText enterNumber;
    private Button inputButton;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterNumber=findViewById(R.id.enterNumber);
        inputButton=findViewById(R.id.inputButton);
        results=findViewById(R.id.results);

        inputButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    if(enterNumber.getText().toString().equals("")){
                        String userMessage = "Please enter number!";
                        generateMessage(userMessage);
                    }else{
                        int number=Integer.parseInt(enterNumber.getText().toString());
                        String numbers=generateNumbers(number);
                        results.setText(numbers);
                    }
                }
                catch (NumberFormatException ignored){

                }
            }
        });
    }

    private void generateMessage(String userMessage) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, userMessage, duration);
        toast.show();
    }


    private String generateNumbers(int number){
        if (number<0 || number>10){
            String errorMessage = "number < 0 or number > 10";
            generateMessage(errorMessage);
        }
        ArrayList<Integer> numbersList = new ArrayList<>(); // 1,2,3,4,5,...
        for (int i = 1; i <= 100; i++){
            numbersList.add(i);
        }
        Collections.shuffle(numbersList); // ?,?,...
        ArrayList<Integer> selectedNumbersList = new ArrayList<>();
        for (int i = 0; i < number; i++){
            selectedNumbersList.add(numbersList.get(i));
        }
        Collections.sort(selectedNumbersList);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : selectedNumbersList){
            stringBuilder.append(String.valueOf(i));
            stringBuilder.append(", ");
        }
        return stringBuilder.toString().replaceAll(", $", "");
    }

}
