package com.ver2point0.android.periodic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int quizScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Score all questions
    public void scoreQuestions() {

        // For Question 1
        EditText editTextQ1 = (EditText) findViewById(R.id.q_1_answer_edit_text);
        String q1 = editTextQ1.getText().toString();
        String q1Answer = "H";
        scoreEditTextQuestion(q1, q1Answer);

        // For Question 2
        RadioButton q2 = (RadioButton) findViewById(R.id.q_2_radio_button_1);
        scoreRadioButtonQuestion(q2);

        // For Question 3
        int q3Id = 3;
        scoreCheckBoxQuestion(q3Id);

        // For Question 4
        EditText editTextQ4 = (EditText) findViewById(R.id.q_4_answer_edit_text);
        String q4 = editTextQ4.getText().toString();
        String q4Answer = "Si";
        scoreEditTextQuestion(q4, q4Answer);

        // For Question 5
        RadioButton q5 = (RadioButton) findViewById(R.id.q_5_radio_button_2);
        scoreRadioButtonQuestion(q5);

        // For Question 6
        int q6Id = 6;
        scoreCheckBoxQuestion(q6Id);

        // For Question 7
        EditText editTextQ7 = (EditText) findViewById(R.id.q_7_answer_edit_text);
        String q7 = editTextQ7.getText().toString();
        String q7Answer = "BAtMn";
        scoreEditTextQuestion(q7, q7Answer);

        // For Question 8
        RadioButton q8 = (RadioButton) findViewById(R.id.q_8_radio_button_3);
        scoreRadioButtonQuestion(q8);

        // For Question 9
        int q9Id = 9;
        scoreCheckBoxQuestion(q9Id);

        // For Question 10
        EditText editTextQ10 = (EditText) findViewById(R.id.q_10_answer_edit_text);
        String q10 = editTextQ10.getText().toString();
        String q10Answer = "FIRe";
        scoreEditTextQuestion(q10, q10Answer);
    }

    // Score EditText view questions
    public int scoreEditTextQuestion(String a, String b) {
        if (a.equals(b)) {
            quizScore += 1;
        } else {
            quizScore += 0;
        }
        return quizScore;
    }

    // Score RadioButton view questions
    public int scoreRadioButtonQuestion(RadioButton rB) {
        if (rB.isChecked()) {
            quizScore += 1;
        } else {
            quizScore += 0;
        }
        return quizScore;
    }

    public int scoreCheckBoxQuestion(int checkBoxId) {
        switch (checkBoxId) {
            case 3:
                CheckBox q3cB1 = (CheckBox) findViewById(R.id.q_3_check_box_1);
                CheckBox q3cB2 = (CheckBox) findViewById(R.id.q_3_check_box_2);
                CheckBox q3cB3 = (CheckBox) findViewById(R.id.q_3_check_box_3);
                CheckBox q3cB4 = (CheckBox) findViewById(R.id.q_3_check_box_4);
                final boolean q3cB1Checked = q3cB1.isChecked();
                final boolean q3cB2Checked = q3cB2.isChecked();
                final boolean q3cB3Checked = q3cB3.isChecked();
                final boolean q3cB4Checked = q3cB4.isChecked();

                if ((q3cB1Checked && q3cB2Checked) && !(q3cB3Checked || q3cB4Checked)) {
                    quizScore += 1;
                } else {
                    quizScore += 0;
                }
                break;

            case 6:
                CheckBox q6cB1 = (CheckBox) findViewById(R.id.q_6_check_box_1);
                CheckBox q6cB2 = (CheckBox) findViewById(R.id.q_6_check_box_2);
                CheckBox q6cB3 = (CheckBox) findViewById(R.id.q_6_check_box_3);
                CheckBox q6cB4 = (CheckBox) findViewById(R.id.q_6_check_box_4);
                final boolean q6cB1Checked = q6cB1.isChecked();
                final boolean q6cB2Checked = q6cB2.isChecked();
                final boolean q6cB3Checked = q6cB3.isChecked();
                final boolean q6cB4Checked = q6cB4.isChecked();

                if ((q6cB2Checked && q6cB4Checked) && !(q6cB1Checked || q6cB3Checked)) {
                    quizScore += 1;
                } else {
                    quizScore += 0;
                }
                break;

            case 9:
                CheckBox q9cB1 = (CheckBox) findViewById(R.id.q_9_check_box_1);
                CheckBox q9cB2 = (CheckBox) findViewById(R.id.q_9_check_box_2);
                CheckBox q9cB3 = (CheckBox) findViewById(R.id.q_9_check_box_3);
                CheckBox q9cB4 = (CheckBox) findViewById(R.id.q_9_check_box_4);
                final boolean q9cB1Checked = q9cB1.isChecked();
                final boolean q9cB2Checked = q9cB2.isChecked();
                final boolean q9cB3Checked = q9cB3.isChecked();
                final boolean q9cB4Checked = q9cB4.isChecked();

                if ((q9cB1Checked && q9cB2Checked && q9cB3Checked) && !q9cB4Checked) {
                    quizScore += 1;
                } else {
                    quizScore += 0;
                }
                break;
        }
        return quizScore;
    }

    // Display final Score based on number of correct questions
    public void displayScore(View v) {
        scoreQuestions();
        Toast.makeText(getApplicationContext(), getString(R.string.quiz_score_toast) + quizScore, Toast.LENGTH_SHORT).show();
        quizScore = 0;
    }

}
