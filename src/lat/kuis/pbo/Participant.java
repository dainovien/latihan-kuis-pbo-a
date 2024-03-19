/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat.kuis.pbo;

/**
 *
 * @author HP
 */
public class Participant {
 private String name;
    private String school;
    private Scoring scoring;

    public Participant(String name, String school, Scoring scoring) {
        this.name = name;
        this.school = school;
        this.scoring = scoring;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public double getScore() {
        return scoring.calculateScore();
    }
}
