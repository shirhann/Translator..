package DictionaryProject;

import javax.swing.*;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

public class LanguageTranslator extends JFrame implements ActionListener {

	JTextArea leftTextArea;
    JComboBox<String> translationOptions;
    private JTextArea rightTextArea;

    LanguageTranslator() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PC\\Downloads\\translate.png"));
    	getContentPane().setBackground(Color.GRAY);
        setTitle("Translator App");
        setSize(672, 597);

        String[] options = {"English-Turkish", "Turkish-English"};
        translationOptions = new JComboBox<>(options);
        translationOptions.setFont(new Font("Century Gothic", Font.ITALIC, 17));
        translationOptions.setBounds(240, 31, 150, 30);
        getContentPane().add(translationOptions);

        leftTextArea = new JTextArea();
        leftTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        leftTextArea.setLineWrap(true);
        leftTextArea.setBounds(50, 84, 249, 312);
        getContentPane().add(leftTextArea);

        translationOptions.addActionListener(this);

        getContentPane().setLayout(null);
        
        rightTextArea = new JTextArea();
        rightTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 17));
        rightTextArea.setLineWrap(true);
        rightTextArea.setBounds(369, 84, 249, 312);
        getContentPane().add(rightTextArea);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) translationOptions.getSelectedItem();
        String textToTranslate = leftTextArea.getText();
        String translatedText = "";

        // Çeviri seçeneklerine göre tercüme yap
        if (selectedOption.equals("English-Turkish")) {
            translatedText = translateEnglishToTurkish(textToTranslate);
        } else if (selectedOption.equals("Turkish-English")) {
            translatedText = translateTurkishToEnglish(textToTranslate);
        }

        // Tercüme sonucunu sağdaki JTextArea'ya göster
        rightTextArea.setText(translatedText);
    }

    // İngilizce-Türkçe çeviri yapacak metod
    public String translateEnglishToTurkish(String englishText) {
        // Buraya İngilizce-Türkçe çeviri algoritması eklenecek
        // Örnek olarak, gelen İngilizce kelimenin Türkçe karşılığını döndüren geçici bir kod
        return "Türkçe çevirisi buraya gelecek";
    }

    // Türkçe-İngilizce çeviri yapacak metod
    public String translateTurkishToEnglish(String turkishText) {
        // Buraya Türkçe-İngilizce çeviri algoritması eklenecek
        // Örnek olarak, gelen Türkçe kelimenin İngilizce karşılığını döndüren geçici bir kod
        return "English translation will be here";
    }

    
}

