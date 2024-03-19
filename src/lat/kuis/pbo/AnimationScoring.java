/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat.kuis.pbo;

/**
 *
 * @author HP
 */
public class AnimationScoring implements Scoring {
    private double plot;
    private double content;
    private double creativity;
    private double cinematography;

    public AnimationScoring(double plot, double content, double creativity, double cinematography) {
        this.plot = plot;
        this.content = content;
        this.creativity = creativity;
        this.cinematography = cinematography;
    }

    @Override
    public double calculateScore() {
        return (plot * 0.15) + (content * 0.35) + (creativity * 0.35) + (cinematography * 0.15);
    }
}
