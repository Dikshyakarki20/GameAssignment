package com.example.gameassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_scissors , b_paper;
    TextView tv_score;
    ImageView iv_ComputerChoice, iv_HumanChoice;
    int HumanScore, ComputerScore = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_paper=(Button)findViewById(R.id.b_paper);
        b_scissors=(Button)findViewById(R.id.b_scissors);
        b_rock=(Button)findViewById(R.id.b_rock);
        tv_score=(TextView)findViewById(R.id.tv_score);
        iv_ComputerChoice= (ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice= (ImageView)findViewById(R.id.iv_HumanChoice);
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn ("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+ Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));
            }
        });
        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn ("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+ Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissor);
                String message = play_turn ("scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human:"+ Integer.toString(HumanScore)+"Computer:"+Integer.toString(ComputerScore));
            }
        });

    }
    public String play_turn(String player_choice){
        String computer_choice = "";
        Random r = new Random();
        int computer_choice_number = r.nextInt(3) + 1;
        if (computer_choice_number==1){
            computer_choice="paper";
        }
        else if (computer_choice_number == 2) {

            computer_choice="rock";
        } else if (computer_choice_number == 3) {

            computer_choice="scissors";
        }

        if (computer_choice=="rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }
        if (computer_choice=="paper"){
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }
        if (computer_choice=="scissor"){
            iv_ComputerChoice.setImageResource(R.drawable.scissor);
        }
if (computer_choice==player_choice){
    return "Draw. Nobody Own";
} else if (player_choice == "rock" && computer_choice == "scissors") {
    HumanScore++;
    return "Rock crushes scissors. You win";
}
else if (player_choice=="rock" && computer_choice=="paper"){
    ComputerScore++;
    return "Paper covers rock. Computer wins";
}
else if (player_choice=="scissors" && computer_choice=="rock"){
    ComputerScore++;
    return "Rock crushes scissors. Computer wins";
}
else if (player_choice=="scissors" && computer_choice=="paper"){
    HumanScore++;
    return "Scissors tears paper. You win";
}
else if (player_choice =="paper" && computer_choice=="scissors"){
    ComputerScore++;
    return "Scissors tears paper. Computer wins";
}
else if (player_choice=="paper" && computer_choice=="rock"){
    HumanScore++;
    return "Paper covers rock. You win";
}
else return "Not Sure";
    }
}
