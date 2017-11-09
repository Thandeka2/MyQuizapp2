package com.example.andriod.myquizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by eKasiLab Alex CDTB on 2017/11/09.
 */

public class Qustion {

    private final String qustionType;

    private final String qustion;

    private final ArrayList<String> answers;



    private Qustion(final String questionType, final String question, final ArrayList<String> answers) {

        this.qustionType = questionType;

        this.qustion = question;

        this.answers = answers;

    }



    /**

     * Takes a comma separated String of the question type, the question, and the answers, and returns a {@link Question} representation of them.

     *

     * @param input The input String made up of the type of question, the question itself, and the answers (comma separated).

     * @return a {@link Qustion} representation of the input string.
     * stion} representation of the input string.

     * @throws IllegalArgumentException

     */

    public static Qustion parse(final String input) throws IllegalArgumentException {



        final String[] questionComponents;

        final String questionType;

        final String question;

        final ArrayList<String> answers = new ArrayList<String>();



        // Split the input on commas

        if (null != input) {

            questionComponents = input.split(",");

        } else {

            throw new IllegalArgumentException("Question to be parsed was null."); // Dev String

        }



        // Extract the component parts of the question

        if (4 < questionComponents.length) {

            questionType = questionComponents[0].trim();

            question = questionComponents[1].trim();



            for (int i = 2; i < questionComponents.length; i++) {

                answers.add(questionComponents[i].trim());

            }



        } else {

            throw new IllegalArgumentException("Question had insufficient parts. Note that at least two answers are required."); // Dev String

        }



        // Construct and return a new Question

        return new Qustion(questionType, question, answers);



    }



    /**

     * Returns the type of the {@link Qustion}

     *

     * @return the type of the {@link Qustion}

     */

    public final String getQuestionType() {

        return qustionType;

    }



    /**

     * Returns the question element of the {@link Qustion}

     *

     * @return the question element of the {@link Qustion}

     */

    public final String getQuestion() {

        return qustion;

    }



    /**

     * Returns the answers, in a random order, as an ArrayList of String

     *

     * @return the answers, in a random order, as an ArrayList of String

     */

    public final List<String> getAnswers() {

        // ArryList is not immutable, create a defensive copy

        final ArrayList<String> answers = new ArrayList<String>(this.answers);

        Collections.shuffle(answers);

        return answers;

    }



    /**

     * Returns the correct answer to the {@link Qustion}

     *

     * @return the correct answer to the {@link Qustion}

     */

    public final String getAnswer() {

        return answers.get(0);

    }
}
