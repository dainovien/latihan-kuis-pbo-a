/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lat.kuis.pbo;

/**
 *
 * @author HP
 */
class LetterWritingScoring implements Scoring {
    private double structure;
    private double content;
    private double creativity;
    private double languageRules;

    public LetterWritingScoring(double structure, double content, double creativity, double languageRules) {
        this.structure = structure;
        this.content = content;
        this.creativity = creativity;
        this.languageRules = languageRules;
    }

    @Override
    public double calculateScore() {
        return (structure * 0.10) + (content * 0.40) + (creativity * 0.30) + (languageRules * 0.20);
    }
}
